/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.utils;

/**
 *
 * @author mical
 */
public class Validation {

    public static boolean onlyNumber(String st) {
        boolean rs = false;
        if (st.matches("[0-9]+")) {
            rs = true;
        }
        return rs;
    }

    public static boolean onlyAlphabet(String st) {
        boolean rs = false;
        if (st.matches("[a-zA-Z]+")) {
            rs = true;
        }
        return rs;
    }

    public static int stringToInt(String st) {
        int rs = 0;
        if (onlyNumber(st)) {
            rs = Integer.parseInt(st);
        }
        return rs;
    }
}
