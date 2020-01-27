package com.codeup.politicianlister.dao;

import com.codeup.politicianlister.Config.Config;

public class DaoFactory {
    private static Politicians politiciansDao;
    private static Users usersDao;
    private static Parties partiesDao;
    private static Countries countriesDao;
    private static Config config = new Config();

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Politicians getPoliticiansDao() {
        if (politiciansDao == null) {
            politiciansDao = new MySQLPoliticianDao(config);
        }
        return politiciansDao;
    }

    public static Countries getCountriesDao() {
        if (countriesDao == null) {
            countriesDao = new MySQLCountriesDao(config);
        }
        return countriesDao;
    }

    public static Parties getPartiesDao() {
        if (partiesDao == null) {
            partiesDao = new MySQLPartiesDao(config);
        }
        return partiesDao;
    }
}
