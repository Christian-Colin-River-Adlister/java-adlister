package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.Config.Config;
import com.codeup.politicianlister.models.Country;
import com.codeup.politicianlister.models.Party;
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
        Config config = new Config();
        MySQLCountriesDao mySQLCountriesDao = new MySQLCountriesDao(config);
        List<Country> all = mySQLCountriesDao.all();
        Country found = null;
        for(Country country : all){
            if(country.getName().equals(name)){
                found = country;
            }
        }
        return found;
    }

    public Country findById(Long id) {
        Config config = new Config();
        MySQLCountriesDao mySQLCountriesDao = new MySQLCountriesDao(config);
        List<Country> all = mySQLCountriesDao.all();
        Country found = null;
        for(Country country : all){
            if(country.getId()== id){
                found = country;
            }
        }
        return found;
    }

    @Override
    public List<Country> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM politic_lister.countries");
            ResultSet rs = stmt.executeQuery();
            return createCountriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all countries.", e);
        }
    }

    public List<Party> getPartiesFromId(Long id){
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM politic_lister.parties WHERE country_of_operation_id = ? ");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            return createPartiesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all parties.", e);
        }
    }

    private List<Party> createPartiesFromResults(ResultSet rs) throws SQLException {
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
    public Long insert(Country country) {
        try {
            String insertQuery = "INSERT INTO politic_lister.countries(name, continent) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getContinent());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new country.", e);
        }
    }

    private Country extractCountries(ResultSet rs) throws SQLException {
        return new Country(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("continent")
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
