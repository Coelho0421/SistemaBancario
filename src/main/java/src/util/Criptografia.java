/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.util;

/**
 *
 * @author felip
 */
public class Criptografia {
    //Criptografia com Cifra de Cesar
    public static String criptografar(String texto) {
        StringBuilder resultado = new StringBuilder();
        int deslocamento = 3; // quantas posições no alfabeto vamos pular
        
        for(char c : texto.toCharArray()){
            if(Character.isLetter(c)){
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char letraCriptografada = (char) ((c - base + deslocamento)% 26 + base);
                resultado.append(letraCriptografada);
            }else{
                resultado.append(c); //mantém espaços, números e síimbolos                    
            }
        }
        return resultado.toString();
        
        
    }
    //Método que Descriptografa
    public static String descriptografar(String textoCriptografado){
        StringBuilder resultado = new StringBuilder();
        int deslocamento = 3;
        
        for(char c : textoCriptografado.toCharArray()){
            if(Character.isLetter(c)){
                
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            char letraOriginal = (char) ((c - base - deslocamento + 26)% 26 + base);
            resultado.append(letraOriginal);
            
            }else{
                resultado.append(c);
            }
        }
        return resultado.toString();
    }
    //Gerador de Hash
}
