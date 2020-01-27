package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.Config.Config;
import com.codeup.politicianlister.models.Politician;
import com.codeup.politicianlister.models.Country;
import com.codeup.politicianlister.models.Party;
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
            stmt = connection.prepareStatement("SELECT * FROM politic_lister.parties");
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
                rs.getString("wiki_link"),
                rs.getLong("country_of_operation_id"),
                rs.getString("flag_url")
        );
    }

    @Override
    public Long insert(Party party) {
        String query = "INSERT INTO politic_lister.parties(name, description,wiki_link, country_of_operation_id, flag_url) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, party.getName());
            stmt.setString(2, party.getDescription());
            stmt.setString(3,party.getWiki_link());
            stmt.setLong(4, party.getCountryID());
            stmt.setString(5, party.getFlagUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new party", e);
        }
    }

    public Long update(Party party) {
        String query = "UPDATE politic_lister.parties SET name = ?, description = ?,wiki_link = ? ,country_of_operation_id = ?, flag_url =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, party.getName());
            stmt.setString(2, party.getDescription());
            stmt.setString(3,party.getWiki_link());
            stmt.setLong(4, party.getCountryID());
            stmt.setString(5,party.getFlagUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error changing party information", e);
        }
    }

    @Override
    public Long delete(String name) {
        String query = "DELETE FROM politic_lister.parties WHERE parties.name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting party", e);
        }
    }

    public static void main(String[] args) {
    }


    @Override
    public List<Politician> getPartyPoliticians(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM politic_lister.politicians JOIN politic_lister.politicians_parties WHERE politicians_parties.parties_id = ? AND politicians_parties.politician_id = politicians.id");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            return createPoliticiansFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all comrades.", e);
        }
    }

    private List<Politician> createPoliticiansFromResults(ResultSet rs) throws SQLException {
        List<Politician> politicians = new ArrayList<>();
        while (rs.next()) {
            politicians.add(extractPolitician(rs));
        }
        return politicians;
    }

    private Politician extractPolitician(ResultSet rs) throws SQLException {
        return new Politician(
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
