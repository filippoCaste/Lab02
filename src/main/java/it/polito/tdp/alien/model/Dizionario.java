package it.polito.tdp.alien.model;
import java.util.*;

public class Dizionario {
	
	Map <String, String> dizionario;
	// List <String> dizionarioList;
	
	public Dizionario() {
		this.dizionario = new HashMap<String, String> ();
		
	}
	
	public boolean add(String parola1, String parola2) {
		boolean b = true;

		if(!parola1.matches("[a-zA-Z]+"))
			b = false;
		if(!parola2.matches("[a-zA-Z]+"))
			b = false;

		if(b) {
			dizionario.put(parola1, parola2);
    	}

    	return b;
	}
	
	public Collection<String> getDizionario() {
		return dizionario.values();
	}

	@Override
	public String toString() {
		String out = "";
		
		for(String s : dizionario.keySet()) {
			if(out!="")
				out+="\n";
			out+= s + " - " + dizionario.get(s);
		}
		
		return out;
	}

	public String trovaTraduzione(String s) {
		String out = "";
		
		if(dizionario.containsKey(s))
			out = this.dizionario.get(s);
		
		return out;
	}
}