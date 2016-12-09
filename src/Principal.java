import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Classe Principal
 * comprend le main.
 * */
public class Principal {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	public static void main(String[]args)throws NumberFormatException{
		String phrase1 = null;
		String phrase2 = null;
		int espace = -1;
		
		try {
			phrase1 = br.readLine();
			phrase2 = br.readLine();
			espace = Integer.parseInt(br.readLine());
			while (espace < -1 || espace == 0){
				System.out.print("**Erreur l'espace doit soit etre -1 "
						+ "soit superieur à zéro."+"\n"
						+ "espace : ");
				espace = Integer.parseInt(br.readLine());;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		Phrase p1 = new Phrase(phrase1,espace);
		Phrase p2 = new Phrase(phrase2,espace);
		
		Compare cmp = new Compare(p1,p2);
		System.out.print(cmp.getResultat());
	}

}
