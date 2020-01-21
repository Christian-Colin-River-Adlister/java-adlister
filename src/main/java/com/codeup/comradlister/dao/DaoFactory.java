package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;

public class DaoFactory {
    private static Comrads comradsDao;
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

    public static Comrads getComradsDao() {
        if (comradsDao == null) {
            comradsDao = new MySQLComradsDao(config);
        }
        return comradsDao;
    }

    public static Countries getCountriesDao() {
        if (countriesDao == null) {
            countriesDao = new MySQLCountriesDao(config);
        }
        return countriesDao;
    }
}
