package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Country;
import com.codeup.comradlister.models.Party;
import com.codeup.comradlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPartiesDao implements Parties {
    private Connection connection;

    public MySQLPartiesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }



    @Override
    public Party findByName(String name) {
        List<Party> allParties = DaoFactory.getPartiesDao().all();
        for(Party party : allParties){
            if (party.getName().equals(name)){
                return party;
            }
        }
        return null;
    }

    @Override
    public List<Party> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.parties");
            ResultSet rs = stmt.executeQuery();
            return createPartyFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all parties.", e);
        }
    }

    private List<Party> createPartyFromResults(ResultSet rs) throws SQLException {
        List<Party> list = new ArrayList<>();
        while (rs.next()) {
            list.add(extractParty(rs));
        }
        return list;
    }

    private Party extractParty(ResultSet rs) throws SQLException {
        return new Party(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDate("date_founded"),
                rs.getDate("date_dissolved"),
                rs.getLong("country_of_operation_id"),
                rs.getString("flag_url")
        );
    }

    @Override
    public Long insert(Party party) {
        String query = "INSERT INTO comrad_lister.parties(name, description, date_founded, date_dissolved, country_of_operation_id, flag_url) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, party.getName());
            stmt.setString(2, party.getDescription());
            stmt.setDate(3, party.getDateFounded());
            stmt.setDate(4, party.getDateDissolved());
            stmt.setLong(5, party.getCountryID());
            stmt.setString(6, party.getFlagUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new party", e);
        }
    }

    public static void main(String[] args) {
        Party found = DaoFactory.getPartiesDao().findByName("Communist Party of the Soviet Union (CPSU)");
        System.out.println(found.getName());
        String test = "Communist Party of the Soviet Union (CPSU),";
        String[] split = test.split(",");
        found = DaoFactory.getPartiesDao().findByName(split[0]);
        System.out.println(found.getName());
        for (String s : split) {
            found = DaoFactory.getPartiesDao().findByName(s);
            if(found != null){
                System.out.println(found.getId());;
            }
        }
    }


    @Override
    public List<Comrad> getPartyComrads(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.comrades JOIN comrad_lister.comrades_parties WHERE comrades_parties.parties_id = ? AND comrades_parties.comrade_id = comrades.id");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            return createComradesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all comrades.", e);
        }
    }

    private List<Comrad> createComradesFromResults(ResultSet rs) throws SQLException {
        List<Comrad> comrads = new ArrayList<>();
        while (rs.next()) {
            comrads.add(extractComrade(rs));
        }
        return comrads;
    }

    private Comrad extractComrade(ResultSet rs) throws SQLException {
        return new Comrad(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("wiki_link"),
                rs.getLong("user_id")
        );
    }

    public Country getCountryFromId(Long id){
        return DaoFactory.getCountriesDao().findById(id);
    }
}
