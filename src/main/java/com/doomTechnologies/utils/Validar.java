/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doomTechnologies.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {

    public static boolean isDNI(String cadena) {
        if (cadena == null) return false;
        Pattern patron = Pattern.compile("^[0-9]{8}$");
        Matcher mat = patron.matcher(cadena);
        return mat.matches();
    }

    public static boolean isCorreoElectronico(String cadena) {
        if (cadena == null) return false;
        Pattern patron = Pattern.compile("^[a-z0-9]+(\\.?[a-z0-9]+)*@([a-z]+\\.)+[a-z]{2,}$");
        Matcher mat = patron.matcher(cadena);
        return mat.matches();
    }

    public static boolean isDouble(String cadena) {
        if (cadena == null) return false;
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isInteger(String cadena) {
        if (cadena == null) return false;
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isPasswordStrong(String cadena) {
        if (cadena == null) return false;
        // At least 8 characters, one uppercase letter, one lowercase letter, one digit, and one special character
        Pattern patron = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$");
        Matcher mat = patron.matcher(cadena);
        return mat.matches();
    }

    public static boolean isDate(String cadena) {
        if (cadena == null) return false;
        // Date format: dd/MM/yyyy
        Pattern patron = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
        Matcher mat = patron.matcher(cadena);
        return mat.matches();
    }

    public static boolean isPhoneNumber(String cadena) {
        if (cadena == null) return false;
        // Phone number format: exactly 9 digits
        Pattern patron = Pattern.compile("^\\d{9}$");
        Matcher mat = patron.matcher(cadena);
        return mat.matches();
    }

    public static boolean isNotEmpty(String cadena) {
        return cadena != null && !cadena.trim().isEmpty();
    }

    public static boolean isLengthInRange(String cadena, int min, int max) {
        if (cadena == null) return false;
        int length = cadena.length();
        return length >= min && length <= max;
    }
}
