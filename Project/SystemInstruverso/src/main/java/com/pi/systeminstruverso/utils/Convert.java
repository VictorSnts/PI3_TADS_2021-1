/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.utils;

import java.text.DecimalFormat;

/**
 *
 * @author victor
 */
public class Convert {
    
    public static int ToInt(String str){
        int num = Integer.parseInt(str);
        return num;
    }
    
    public static double ToDouble(String str){
        double num = Double.parseDouble(str);
        return num;
    }
    
    public static double RoundDecimal(double n){
        DecimalFormat df = new DecimalFormat("#.00");
        df.format(n);
        return n;
    }
    
}
