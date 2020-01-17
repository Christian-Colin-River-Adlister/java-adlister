package com.codeup.comradlister.dao;

import com.codeup.comradlister.Config.Config;

public class DaoFactory {
    private static Comrads adsDao;
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
}
