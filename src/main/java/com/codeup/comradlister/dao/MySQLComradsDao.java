package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Country;
import com.codeup.comradlister.models.Party;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLComradsDao implements Comrads {
    private Connection connection = null;

    public MySQLComradsDao(Config config) {
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
    public Comrad findByName(String name) {
        PreparedStatement s = null;
        List<Comrad> all = DaoFactory.getComradsDao().all();
        Comrad found = null;
        for(Comrad comrad : all){
            if(comrad.getName().equals(name)){
                found = comrad;
            }
        }
        return found;
    }

    @Override
    public List<Comrad> all() {
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.comrades");
            ResultSet rs = stmt.executeQuery();
           return createComradsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all comrades.", e);
        }
    }

    @Override
    public Long insert(Comrad comrad) {
        try {
            String insertQuery = "INSERT INTO comrad_lister.comrades(name, description,wiki_link, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, comrad.getName());
            stmt.setString(2, comrad.getDescription());
            stmt.setString(3, comrad.getWikiLink());
            stmt.setLong(4, comrad.getUserId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new Comrade.", e);
        }
    }

    @Override
    public Long update(Comrad comrad) {
        String query = "UPDATE comrad_lister.comrades SET name = ?, description = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, comrad.getName());
            stmt.setString(2, comrad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error changing comrad information", e);
        }
    }

    @Override
    public Long delete(String name) {
        String query = "DELETE FROM comrad_lister.comrades WHERE comrades.name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting comrade", e);
        }
    }

    public Long insertComradeParty(Comrad comrad, Party party){
        try {
            String insertQuery = "INSERT INTO comrad_lister.comrades_parties(comrade_id, parties_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, comrad.getId());
            stmt.setLong(2, party.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                return rs.getLong(1);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a comrade party connection.", e);
        }
    }

    @Override
    public List<Party> getComradeParties(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.parties JOIN comrad_lister.comrades_parties WHERE comrades_parties.comrade_id = ? AND comrades_parties.parties_id = parties.id");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            return createPartiesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all parties.", e);
        }
    }

    public List<Party> updateComradeParties(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.parties JOIN comrad_lister.comrades_parties WHERE comrades_parties.comrade_id = ? AND comrades_parties.parties_id = parties.id");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            return createPartiesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all parties.", e);
        }
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

    private List<Party> createPartiesFromResults(ResultSet rs) throws SQLException {
        List<Party> parties = new ArrayList<>();
        while (rs.next()) {
            parties.add(extractParty(rs));
        }
        return parties;
    }

    private Comrad extractComrad(ResultSet rs) throws SQLException {
        return new Comrad(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("wiki_link"),
                rs.getLong("user_id")
        );
    }

    private List<Comrad> createComradsFromResults(ResultSet rs) throws SQLException {
        List<Comrad> comrads = new ArrayList<>();
        while (rs.next()) {
            comrads.add(extractComrad(rs));
        }
        return comrads;
    }

    public static void main(String[] args) {
        Country country = DaoFactory.getCountriesDao().findByName("China");
        System.out.println(DaoFactory.getCountriesDao().getPartiesFromId(country.getId()).get(0).getName());
    }
}
