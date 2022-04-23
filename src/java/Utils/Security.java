/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author Ludimilla
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Security {

    private Security() {}

    public static String encryptPassword(String flatPassword) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] passwordDigest = md5.digest(flatPassword.getBytes("UTF-8"));
            StringBuilder passwordHash = new StringBuilder();
            for (byte b : passwordDigest)
                passwordHash.append(String.format("%02X", 0xFF & b));
            return passwordHash.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
