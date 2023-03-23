/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author mical
 */
public class Utilities {

    public static Date convert(String date) {
        int[] a = new int[3];
        String[] words = date.split("-");
        int count = 0;
        for (String word : words) {
            a[count] = Integer.parseInt(word);
            count++;
        }
        Date date1 = new Date(a[0] - 1900, a[1] - 1, a[2]);
        return date1;
    }

    public static Date getDate() {
        int[] a = new int[3];
        Date date = new Date(System.currentTimeMillis());
        String s1 = date.toString();
        String[] words = s1.split("-");
        int count = 0;
        for (String word : words) {
            a[count] = Integer.parseInt(word);
            count++;
        }
        date = new Date(a[0] - 1900, a[1] - 1, a[2]);
        return date;
    }

    public static Date getDate(int[] a) {
        a[0] -= 1900;
        a[1] -= 1;
        Date date = new Date(a[0], a[1], a[2]);
        System.out.println(date);
        return date;
    }

    public static int getYear(String date) {
        String[] words = date.split("-");
        return Integer.parseInt(words[0]);
    }

    public static int getMonth(String date) {
        String[] words = date.split("-");
        return Integer.parseInt(words[1]);
    }

    public static int getDay(String date) {
        String[] words = date.split("-");
        return Integer.parseInt(words[2]);
    }

    public static String stringToMD5(String str) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            result = DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int countMonth(String d1, String d2){
        int yearCount = 0, monthCount = 0;
        int m1 = getMonth(d1);
        int m2 = getMonth(d2);
        int y1 = getYear(d1);
        int y2 = getYear(d2);
        if(m1 > m2){
            yearCount = y2 - y1 - 1;
            monthCount = 12 - m1 + m2;
        } else{
            yearCount = y2 - y1;
            monthCount = m2 - m1;
        }
        return yearCount*12 + monthCount;
    }
    
    public static BigDecimal calculateSystemFee(int monthCount){
        // Duoi 2 nam : 
        double monthlyFee = 0;
        if(monthCount <24) monthlyFee = 0.5;
        else if(monthCount < 60) monthlyFee = 0.4;
        else monthlyFee = 0.3;
        return BigDecimal.valueOf(monthCount).multiply(BigDecimal.valueOf(monthlyFee));
    }

    public static void main(String[] args) {
        String pass = "123abc";
        System.out.println(stringToMD5(pass));
        String pass1 = "123abc";
        System.out.println(stringToMD5(pass1));
        Date d1 = convert("2023-11-12");
        Date d2 = convert("2025-10-12");
        System.out.println(countMonth(d1.toString(), d2.toString()));
        BigDecimal a = calculateSystemFee(50);
        System.out.println(a);
    }
    
    
}
