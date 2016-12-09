import java.util.ArrayList;

/*Cette interface comme son
 * nom l'indique permet de créer une 
 * Pile qui empile deux elements à la fois.
 * Je l'ai crée pour reviser mais j'ai trouvé
 * utile de l'utiliser dans le cadre de ce TP.
 * */
public interface DoublePile <L> {
	
	public boolean estVide();
	public int taille();
	public void empiler(L element,L element2);
	public ArrayList<L> depiler();
}
