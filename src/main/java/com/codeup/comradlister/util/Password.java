package com.codeup.comradlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    private static final int ROUNDS = 12;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public static void main(String[] args) {
        System.out.println(hash("12345"));
    }
}
