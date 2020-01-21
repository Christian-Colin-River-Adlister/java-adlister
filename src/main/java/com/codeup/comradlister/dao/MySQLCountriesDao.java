package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.models.Country;
import com.mysql.cj.jdbc.Driver;

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
    public Country findByName(String name) {
        return null;
    }

    @Override
    public List<Country> all() {
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
    public Long insert(Country country) {
        try {
            String insertQuery = "INSERT INTO comrad_lister.comrades(name, description, user_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getContinent());
            stmt.setLong(3, country.getLevel_of_comradery());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Country extractCountries(ResultSet rs) throws SQLException {
        return new Country(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("continent"),
                rs.getInt("level_of_comradery")
        );
    }

    private List<Country> createCountriesFromResults(ResultSet rs) throws SQLException {
        List<Country> countries = new ArrayList<>();
        while (rs.next()) {
            countries.add(extractCountries(rs));
        }
        return countries;
    }
}
