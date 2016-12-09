import java.util.ArrayList;

/*Classe Compare
 * Cette classe prend deux Phrase
 * et les compare.
 * */
public class Compare {
	
	private Phrase p1;
	private Phrase p2;
	private ArrayList<ArrayList<String>> intersection = new ArrayList<>();
	private double resultat;
	
	public Compare(Phrase p1, Phrase p2){
		this.p1 = p1;
		this.p2 = p2;
		comparer();
	}
	
	/*Methode getResultat
	 * @return
	 * 	double resultat
	 * */
	public double getResultat(){
		return resultat;
	}
	
	/*Methode comparer
	 * C'est cette methode
	 * qui permet tout 
	 * le processus de comapraison.
	 * */
	public void comparer(){
		
		for(int i = 0; i < p1.size(); i++){
			for(int x = 0; x < p2.size(); x++){
				if(p1.get(i).equals(p2.get(x))){
					intersection.add(p1.get(i));
				}
			}
		}
		
		doublons();
		double u = (double)intersection.size()/(double)p1.size();
		double v = (double)intersection.size()/(double)p2.size();
		
		resultat = (2*u*v)/(u+v);
	}
	
	/*Methode doublon
	 * Permet de gerer le cas des
	 * doublons selon les regles
	 * du TP.
	 * */
	public void doublons(){
		ArrayList<ArrayList<String>> doublons = new ArrayList<>();
		
		int x = 1;
		for(int i = 0; i < intersection.size(); i++){
			for(int n = x; n < intersection.size(); n++){
				if((intersection.get(i).equals(intersection.get(n))&&
						!doublons.contains(intersection.get(i)))){
					
					doublons.add(intersection.get(i));
				}
			}
			x++;
		}
		
		for(int i = 0; i < doublons.size(); i++){
			
			modifierIntersection(doublons,i);
		}
	}
	
	/*Modifie l'interesection
	 * à la suite du calcul des doublons.
	 * */
	public void modifierIntersection(ArrayList<ArrayList<String>> doublons,int i){
		int d = 0;
		for(int n = 0; n < intersection.size(); n++){
			if(doublons.get(i).equals(intersection.get(n))){
				d++;
			}
		}
		
		int d1 = 0;
		for(int n = 0; n < p1.size(); n++){
			if(doublons.get(i).equals(p1.get(n))){
				d1++;
			}
		}
		
		int d2 = 0;
		for(int n = 0; n < p2.size(); n++){
			if(doublons.get(i).equals(p2.get(n))){
				d2++;
			}
		}
		
		if(d1 < d2){
			for(int z = 0; z < d-d1; z ++){
				intersection.remove(doublons.get(i));
			}
		}else if(d2 < d1){
			for(int z = 0; z < d-d2; z ++){
				intersection.remove(doublons.get(i));
			}
		}else{
			for(int z = 0; z < d-d1; z ++){
				intersection.remove(doublons.get(i));
			}
		}
	}
	
		
}
