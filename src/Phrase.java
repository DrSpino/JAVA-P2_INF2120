import java.util.ArrayList;

/*Cette classe permet de créer
 * un Objet phrase.
 * */
@SuppressWarnings("serial")
public class Phrase extends ArrayList<ArrayList<String>> {
	
	//Liste qui contient chaque mot de la phrase.
	private ArrayList<String> mots = new ArrayList<>();
	//DoublePile qui permet de créer les bigrammes.
	private DoublePile<String> p = new Bigramme<>();
	private int espace;
	
	//constructeur
	public Phrase(String phrase,int espace) {
		this.espace = espace;
		partage(phrase);
		bigramme();
	}
	
	/*Methode partage
	 * Elle permet de separer les mots
	 * de la phrase et de les mettres
	 * dans l'ArrayList mots.
	 * @params
	 * 	String phrase
	 * */
	public void partage(String phrase) {
		
		String mot = "";
		for (int i = 0; i < phrase.length(); i++){
			if((phrase.charAt(i) >= 'A' && phrase.charAt(i) <= 'Z')||
					(phrase.charAt(i) >= 'a' && phrase.charAt(i) <= 'z') ){
				
				mot += phrase.charAt(i);
				if(i == phrase.length()-1){
					mot = mot.toUpperCase();
					mots.add(mot);
					mot = "";
				}
			}else if(!(i == 0)){
				mot = mot.toUpperCase();
				mots.add(mot);
				mot = "";
			}
		}
	}
	
	/*Methode bigramme
	 * Permet de créer les bigrammes
	 * en utilisant la doublePile.
	 * */
	public void bigramme(){
		if(espace == -1){
			espace = mots.size();
		}
		for (int i = 0; i < mots.size(); i++){
			for(int x = 1; x < mots.size() && x < i+espace+1; x++){
				if(i < x){
					p.empiler(mots.get(i),mots.get(x));
				}
			}
		}
		mots.clear();
		
		for(int i = 0; i < p.taille();i++){
			this.add(p.depiler());
		}
		
	}
			
}