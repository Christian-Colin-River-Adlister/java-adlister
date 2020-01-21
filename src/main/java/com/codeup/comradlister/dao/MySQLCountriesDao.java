package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.models.Comrad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCountriesDao implements Countries {
    private Connection connection = null;

    public MySQLCountriesDao(Config config) {
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
    public Countries findByName(String name) {
        return null;
    }

    @Override
    public List<Countries> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrad_lister.countries");
            ResultSet rs = stmt.executeQuery();
            return createCountriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Countries countries) {
        try {
            String insertQuery = "INSERT INTO comrad_lister.comrades(name, description, user_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, countries.getName());
            stmt.setString(2, countries.getDescription());
            stmt.setLong(3, countries.getUser_id());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Countries extractCountries(ResultSet rs) throws SQLException {
        return new Countries(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getLong("user_id")
        );
    }

    private List<Countries> createComradsFromResults(ResultSet rs) throws SQLException {
        List<Countries> countries = new ArrayList<>();
        while (rs.next()) {
            countries.add(extractCountries(rs));
        }
        return countries;
    }
}
