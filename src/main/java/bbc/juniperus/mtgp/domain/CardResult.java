package bbc.juniperus.mtgp.domain;

import java.io.Serializable;

public class CardResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String type;
	private String edition;
	private double price;
	private String notFoundMsg;
	
	public CardResult(String name, String type, String edition, double d){
	
		if (name != null)
			this.name = name.replaceAll("[`�]", "'");
		this.type = type;
		this.edition = edition;
		this.price = d;
	}

	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}


	public String getEdition() {
		return edition;
	}


	public double getPrice() {
		return price;
	}
	
	
	public void setNotFound(String msg){
		notFoundMsg = msg;
	}
	
	@Override
	public String toString(){
		
		if (notFoundMsg != null)
			return "N/A: " + notFoundMsg;
		
		return this.getClass().getSimpleName() + "[" + name + ", " + type +", " + 
				", " + edition  +", " + price + "]";
	}
	
	
}