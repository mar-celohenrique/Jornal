package br.ufc.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Criptografia {
	private static MessageDigest md = null; 
	
	/**
	 * Metodo responsavel por informa qual metodo
	 * De criptografia a ser utilizado.
	 */
	
	static { 
		try { 
			md = MessageDigest.getInstance("MD5"); 
		}catch (NoSuchAlgorithmException ex) { 
			ex.printStackTrace(); 
		} 
	} 
	
	/**
	 * Metodo responsavel pela criptografia da senha ou de qualquer outro dado.
	 */
	
	private static char[] hexCodes(byte[] text) { 
		char[] hexOutput = new char[text.length * 2]; 
		String hexString; 
		for (int i = 0; i < text.length; i++) { 
			hexString = "00" + Integer.toHexString(text[i]); 
			hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2); 
			
		} 
		
		return hexOutput; 
		
	} 
	
	public static String criptografar(String pwd) { 
		if (md != null) { 
			return new String(hexCodes(md.digest(pwd.getBytes()))); 
		} 
		
		return null; 
		
	}
	public static void main(String[] args) {
		String senha = criptografar("12345");
		System.out.println(senha);
	}
	
}
