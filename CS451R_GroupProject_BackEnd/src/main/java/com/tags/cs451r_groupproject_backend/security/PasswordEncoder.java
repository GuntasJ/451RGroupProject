package com.tags.cs451r_groupproject_backend.security;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordEncoder {
    private static final int SALT_LENGTH = 16;
    private static final int HASH_LENGTH = 64;
    private static final int ITERATIONS = 10000;

    public static String encodePassword(String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, HASH_LENGTH * 8);
            SecretKey secretKey = keyFactory.generateSecret(keySpec);

            byte[] hashedPassword = secretKey.getEncoded();

            // Combine salt and hashed password and encode them as Base64
            byte[] combined = new byte[salt.length + hashedPassword.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);

            return Base64.getEncoder().encodeToString(combined);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkPassword(String password, String encodedPassword) {
        try {
            byte[] combined = Base64.getDecoder().decode(encodedPassword);
            byte[] salt = new byte[SALT_LENGTH];
            byte[] storedHash = new byte[HASH_LENGTH];

            System.arraycopy(combined, 0, salt, 0, salt.length);
            System.arraycopy(combined, salt.length, storedHash, 0, storedHash.length);

            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, HASH_LENGTH * 8);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] newHash = keyFactory.generateSecret(keySpec).getEncoded();

            // Compare the computed hash with the stored hash
            boolean passwordMatch = MessageDigest.isEqual(storedHash, newHash);
            return passwordMatch;

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return false;
        }
    }
}
