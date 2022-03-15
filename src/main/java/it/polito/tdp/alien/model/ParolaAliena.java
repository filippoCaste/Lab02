package it.polito.tdp.alien.model;

import java.util.regex.*;

public class ParolaAliena {
	
	String parola;
	
	public boolean verificaNumero(String s) {
		
		String REGEX = "[a-zA-Z]*";
		boolean matcher = Pattern.matches(REGEX, s);
		
		
		return false;
	}

}
