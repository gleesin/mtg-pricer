package bbc.juniperus.mtgp.cardsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bbc.juniperus.mtgp.domain.Card;

public class CardParser {
	
	//Any sequence of letter,',-,/ or white space (includes leading and trailing white spaces).
	public final static String REG_EXP_NAME = "[a-zA-Z\\s'-/]+";
	public final static String REG_EXP_NUMBER = "\\d+";
	
	
	public Map<Card,Integer> parseFromFile(File file) throws IOException, ParseException{
		
		Map<Card,Integer> cards = new LinkedHashMap<Card,Integer>();
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
	
		int lineCounter=0;
		String line;
		while ((line =reader.readLine()) != null){
			lineCounter++;
			//Ignore empty lines
			if (line.trim().equals(""))
				continue;
			
			int q = parseQuantity(line);
			//If no number specified. Set it to 1.
			if (q == 0)
				q = 1;
			String name = parseCardName(line);
			
			if (name == null){
				//No name matching regexp was found int line.
				reader.close();
				throw new ParseException("Failed to parse " + file.getAbsolutePath() + 
									" on the line " + lineCounter +
									"'.\nThe line has to contain expressions matching '"+
									REG_EXP_NAME + "' (name of the card).",0);
			}
			
			Card c = new Card(name);
			cards.put(c, q);
		}
		reader.close();
		
		return cards;
	}
	
	private int parseQuantity(String line){
		Pattern pat = Pattern.compile(REG_EXP_NUMBER);
		Matcher mat = pat.matcher(line);
		
		int q = 0;
		if (mat.find())
			//If regex is correct we won't ge IllegalArgumentException
			q = Integer.parseInt(mat.group());
		
		return q;
	}
	
	private String parseCardName(String line){
		
		Pattern pat = Pattern.compile(REG_EXP_NAME);
		
		Matcher mat = pat.matcher(line);
		String name = null;
		
		if (mat.find()){
			//Trim leading and trailing \w.
			name = mat.group().trim();
			//In case of split cards written in bad format.
			name = name.replace("/", " // ");
		}

		return name;
	}
}
