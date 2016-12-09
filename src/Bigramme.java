import java.util.ArrayList;

/*Classe Sac qui permet d'implementer
 * la doublePile.
 * */
public class Bigramme<E> implements DoublePile<E>{
	/*Noeud utilisée par la doublePile
	 * */
	public class Noeud <F> {
	    protected F element;
	    protected F element2;
	    protected Noeud<F> precedent;
	    
	   public Noeud(F element,F element2) {
	        this.element = element;
	        this.element2 = element2;
	        this.precedent = null;
	   }
	}
	
	private Noeud<E> sommet = null;
	private int nbElement = 0;
	
    public boolean estVide(){
    	return sommet == null;
    }
    
    public int taille(){
    	return nbElement;
    }
    
    /*Permet d'empiler deux elements à la fois
     * @params
     * 	E element, E element2
     * */
    public void empiler(E element,E element2){
    	Noeud<E>tmp = null;
    	
    	tmp = sommet;
    	sommet = new Noeud<E>(element,element2);
    	sommet.precedent = tmp;
    	
        nbElement ++;
    }
    
    /*Permet de depiler la doublePile
     * et de renvoyer un arrayList avec 
     * les deux elements.  
     * @return
     * 	ArrayList<E>   
     * */
    public ArrayList<E> depiler(){
        ArrayList<E>tmp = new ArrayList<>();
        tmp.add(sommet.element);
        tmp.add(sommet.element2);
        sommet = sommet.precedent;
        return tmp;
    }

}
