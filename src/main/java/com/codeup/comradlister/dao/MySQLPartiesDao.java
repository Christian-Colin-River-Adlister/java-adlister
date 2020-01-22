package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.models.Comrad;
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




    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("bio"),
                rs.getString("password")
        );
    }

//    @Override
//    public Parties findByName(String name) {
//        return null;
//    }

    @Override
    public List<Party> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.comrades");
            ResultSet rs = stmt.executeQuery();
            return createPartyFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
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
        if (! rs.next()) {
            return null;
        }
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

    @Override
    public Long insert(Party party) {
        String query = "INSERT INTO comrad_lister.parties(name, description, date_founded, date_dissolved, country_of_operation_id, flag_url) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, party.getName());
            stmt.setString(2, party.getDescription());
            stmt.setString(3, party.getDateFounded());
            stmt.setString(4, party.getDateDissolved());
            stmt.setLong(5, party.getCountryID());
            stmt.setString(6, party.getFlagUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }
}
