package bbc.juniperus.mtgp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deck {
	
	List<String> cardNames = new ArrayList<String>();
	Map<String, Integer> cardQuantity = new HashMap<String, Integer>();
	
	//To find word + n whitespace+word pair after that.
	String regExpName = "[a-zA-Z'-]+(\\s+[a-zA-Z']+)*";
	String regExpNumber = "\\d+";

	public void readFromFile(String path) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		String line;
		while ( (line =reader.readLine()) != null){
			
			//Ignore empty lines
			if (line.trim().equals(""))
				continue;
			//System.out.println(line);
			Pattern patName = Pattern.compile(regExpName);
			Pattern patNumber = Pattern.compile(regExpNumber);
			
			
			Matcher mName = patName.matcher(line);
			Matcher mNumber = patNumber.matcher(line);
			
			mName.find();
			mNumber.find();
			
			String name = mName.group();
			String quantity = mNumber.group();
			
			//System.out.println(name + "  " + quantity);
			
			cardNames.add(name);
			cardQuantity.put(name, Integer.parseInt(quantity));
			
		}
		
		reader.close();
		
	}
	
	public static void main (String[] args) throws IOException{
		
		
		new Deck().readFromFile("d:\\deck.txt");
		
	}
	
	
	public List<String> getCardNames(){
		return new ArrayList<String>(cardNames);
	}
	
	
	public int getQuantityOf(String cardName){
		return cardQuantity.get(cardName);
	}
	
}