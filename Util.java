import java.util.Random;

/**
 * Created by zulupero on 20/09/16.
 */
public class Util {

    private static Random random;

	/**
	 * Randomizer des valeurs
	 * @param tab[] valeur faciale des jetons
	 */

    public static void shuffle(int[] tab){

    	int taille = tab.length;
    	int temp;
    	int alea;

    	random = new Random();

    	for(int i = 0; i<taille; i++){
    		alea = random.nextInt(taille);
    		temp = tab[i];
    		tab[i] = tab[alea];
    		tab[alea] = temp;
    	}    

    }

	/**
	 * Transformateur de chaine de caractères en tableau
	 * @param chaine la chaine actuelle qui définit le plateau
	 */

	public static String[] state2tab(String chaine){

		int taille = chaine.length();
		String tab[] = new String [21];
		int rangtab = 0;

		for (int i = 1; i<taille-1; i++){
            if(chaine.charAt(i) == 'R' || chaine.charAt(i) == 'B'){
                String tempchaine = chaine.substring(i, (i + 2));
                tab[rangtab] = tempchaine;
                rangtab++;
            }
            else if(chaine.charAt(i) == '_'){
                tab[rangtab] = "_";
                rangtab++;
            }
			
		}

		return tab;
	}

	/**
	 * Transformateur de tableau en chaine de caractere
	 * @param tab[] le tableau du plateau
	 */

	public static String state2string(String tab[]){

		int taille = tab.length;
		String chaine = "[ ";

		for (int i = 0 ; i < taille; i++){
			 chaine = chaine + tab[i] + " ";

		}
        chaine  = chaine + "]";

		return chaine;
	}

	/**
	 * Calcul la distance euclidienne entre deux points
	 * @param x1 coordonnée en X du premier point
	 * @param y1 coordonnée en Y du premier point
	 * @param x2 coordonnée en X du deuxième point
	 * @param y2 coordonnée en Y du deuxième point
	 */

     public static double distance(double x1, double y1, double x2, double y2){

    	double distance;
    	double calcul = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
    	distance = Math.sqrt(calcul);

    	return distance;
    }

	/**
	 * Calcul du premier ID de la ligne passé en paramètre
	 * @param ligne qui correspond à la ligne
	 */

    public static int idDebutLigne(int ligne){
    	int id = 0;
        switch (ligne) {
        	case 0:
        		id = 0;
        		break;
        	case 1:
        		id = 6;
        		break;
        	case 2:
        		id = 11;
        		break;
        	case 3:
        		id = 15;
        		break;
        	case 4:
        		id = 18;
        		break;
        	case 5:
        		id = 20;
        		break;
        }
        
        return id;
    }

	/**
	 * Calcul du dernier ID de la ligne passé en paramètre
	 * @param ligne qui correspond à la ligne
	 */

    public static int idFinLigne(int ligne){
        int id = 0;

        switch (ligne) { 
        	case 0:
        		id = 5;
        		break;
        	case 1:
        		id = 10;
        		break;
        	case 2:
        		id = 14;
        		break;
        	case 3:
        		id = 17;
        		break;
        	case 4:
        		id = 19;
        		break;
        	case 5:
        		id = 20;
        		break;
        }

        return id;
    }


   
}
