package bbc.juniperus.mtgp.cardsearch;


public class SearcherFactory {

	public static final int CERNY_RYTIR = 777;
	public static final int MODRA_VEVERICKA = 778;
	public static final int DRAGON = 779;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Searcher getSearcher(int searcherType){
		Searcher result = null;
	
		switch (searcherType) {
        case CERNY_RYTIR:		result = getCernyRytirPricer();
        						break;
        case MODRA_VEVERICKA:	result= getModraVeverickaPricer();
                 				break;
        case DRAGON:			result= getDragonPricer();
								break;    
		}
		
		return result;
	}
	
	
	public static Searcher getCernyRytirPricer(){
		return new CernyRytirSearcher();
	}
	
	public static Searcher getModraVeverickaPricer(){
		return new ModraVeverickaSearcher();
	}
	
	public static Searcher getDragonPricer(){
		return  new DragonHostSearcher();
	}

}