/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 *
 * @author victor
 */
public class CryptoUtils {
    
    public static String hashSenha(String senha){
        return BCrypt.withDefaults().hashToString(12,senha.toCharArray());
    }
    
    public static boolean verificarSenha(String senha_informada, String senha_cadastrada){
        BCrypt.Result verifica = BCrypt.verifyer().verify(senha_informada.toCharArray(), senha_cadastrada);
        return verifica.verified;
    }
    
    
    public static void main(String[] args) {
        String teste = "123";
        System.out.println(hashSenha(teste));
        
        System.out.println(verificarSenha(teste, "$2a$12$MM2iTape7fdgtc5G7wrE/.RWOup4tx/Z9mkvmwchOpH.Q5CsuUnLe"));
    }
}
