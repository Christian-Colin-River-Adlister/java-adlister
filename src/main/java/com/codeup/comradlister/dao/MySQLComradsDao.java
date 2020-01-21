package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Party;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        return null;
    }

    @Override
    public List<Comrad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.comrades");
            ResultSet rs = stmt.executeQuery();
            return createComradsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Comrad comrad) {
        try {
            String insertQuery = "INSERT INTO comrad_lister.comrades(name, description, user_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, comrad.getName());
            stmt.setString(2, comrad.getDescription());
            stmt.setLong(3, comrad.getUser_id());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
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
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a comrade party connection.", e);
        }
    }

    @Override
    public List<Party> getComradeParties(Comrad comrad) {
        PreparedStatement stmt = null;
        try {
            Long user_id = comrad.getUser_id();
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.comrades_parties WHERE comrade_id = "+ user_id +"");
            ResultSet rs = stmt.executeQuery();
            return createPartiesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    private Party extractParty(ResultSet rs) throws SQLException {
        return new Party(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("date_founded"),
                rs.getString("date_dissolved"),
                rs.getLong("country_of_operation_id"),
                rs.getString("flag_url")

        );
    }

    private List<Party> createPartiesFromResults(ResultSet rs) throws SQLException {
        List<Party> comrads = new ArrayList<>();
        while (rs.next()) {
            comrads.add(extractParty(rs));
        }
        return comrads;
    }

    private Comrad extractComrad(ResultSet rs) throws SQLException {
        return new Comrad(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getLong("user_id"),
                createPartiesFromResults(rs)

        );
    }

    private List<Comrad> createComradsFromResults(ResultSet rs) throws SQLException {
        List<Comrad> comrads = new ArrayList<>();
        while (rs.next()) {
            comrads.add(extractComrad(rs));
        }
        return comrads;
    }
}
