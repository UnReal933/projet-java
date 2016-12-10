import java.util.Random;

/**
 * Created by zulupero on 20/09/16.
 */
public class Util {

    private static Random random;

    public static void shuffle(int[] tab){

    	int taille = tab.length;
    	int a;
    	int alea;

    	random = new Random();

    	for(int i = 0; i<taille; i++){
    		alea = random.nextInt(taille);
    		a = tab[i];
    		tab[i] = tab[alea];
    		tab[alea] = a;
    	}

    }

	public static String[] state2tab(String chaine){

		int taille = chaine.length()-2;
		String tab[] = new String [taille];
		int rangtab = 0;
		for (int i = 1; i<(taille/2); i++){
			String tempchaine = chaine.substring(i, (i + 1));
			tab[rangtab] = tempchaine;
			rangtab++;
		}
		return tab;
	}

	public static String state2string (String tab[]){

		int longueur = (tab.length)/2;
		String chainefinale = "";
		for (int i = 1 ; i < longueur-1 ; i++){
			String tempchaine = tab[i];
            chainefinale= chainefinale +tempchaine;

		}
		return chainefinale;

	}

     public static double distance(double x1, double y1, double x2, double y2){

    	double distance;
    	double calcul = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
    	distance = Math.sqrt(calcul);

    	return distance;
    }
}
