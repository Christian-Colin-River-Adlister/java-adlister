package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.Config.Config;
import com.codeup.politicianlister.models.Politician;
import com.codeup.politicianlister.models.Country;
import com.codeup.politicianlister.models.Party;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPoliticianDao implements Politicians {
    private Connection connection = null;

    public MySQLPoliticianDao(Config config) {
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
    public Politician findByName(String name) {
        PreparedStatement s = null;
        List<Politician> all = DaoFactory.getPoliticiansDao().all();
        Politician found = null;
        for(Politician politician : all){
            if(politician.getName().equals(name)){
                found = politician;
            }
        }
        return found;
    }

    @Override
    public List<Politician> all() {
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM politic_lister.politicians");
            ResultSet rs = stmt.executeQuery();
           return createPoliticiansFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all comrades.", e);
        }
    }

    @Override
    public Long insert(Politician politician) {
        try {
            String insertQuery = "INSERT INTO politic_lister.politicians(name, description,wiki_link, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, politician.getName());
            stmt.setString(2, politician.getDescription());
            stmt.setString(3, politician.getWikiLink());
            stmt.setLong(4, politician.getUserId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new Politician.", e);
        }
    }

    @Override
    public Long update(Politician politician) {
        String query = "UPDATE politic_lister.politicians SET name = ?, description = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, politician.getName());
            stmt.setString(2, politician.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error changing politician information", e);
        }
    }

    @Override
    public Long delete(String name) {
        String query = "DELETE FROM politic_lister.politicians WHERE name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting politician", e);
        }
    }

    public Long insertPoliticianParty(Politician politician, Party party){
        try {
            String insertQuery = "INSERT INTO politic_lister.politicians_parties(politician_id, parties_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, politician.getId());
            stmt.setLong(2, party.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                return rs.getLong(1);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a politician party connection.", e);
        }
    }

    @Override
    public List<Party> getPoliticianParties(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM politic_lister.parties JOIN politic_lister.politicians_parties WHERE politicians_parties.politician_id = ? AND politicians_parties.parties_id = parties.id");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            return createPartiesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all parties.", e);
        }
    }

    public List<Party> updatePoliticianParties(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM politic_lister.parties JOIN politic_lister.politicians_parties WHERE politicians_parties.politician_id = ? AND politicians_parties.parties_id = parties.id");
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
                rs.getString("wiki_link"),
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

    private Politician extractPolitician(ResultSet rs) throws SQLException {
        return new Politician(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("wiki_link"),
                rs.getString("head_shot_url"),
                rs.getLong("user_id")
        );
    }

    private List<Politician> createPoliticiansFromResults(ResultSet rs) throws SQLException {
        List<Politician> politicians = new ArrayList<>();
        while (rs.next()) {
            politicians.add(extractPolitician(rs));
        }
        return politicians;
    }

    public static void main(String[] args) {
        Country country = DaoFactory.getCountriesDao().findByName("China");
        System.out.println(DaoFactory.getCountriesDao().getPartiesFromId(country.getId()).get(0).getName());
    }
}
