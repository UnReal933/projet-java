import java.util.Random;

/**
 * Created by zulupero on 20/09/16.
 */
public class Util {

    private static Random random;

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

	public static String[] state2tab(String chaine){

		int taille = chaine.length();
		String tab[] = new String [((taille-5)/2)];
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

	public static String state2string(String tab[]){

		int taille = tab.length;
		String chaine = "[ ";

		for (int i = 0 ; i < taille; i++){
			 chaine = chaine + tab[i] + " ";

		}
        chaine  = chaine + "]";

		return chaine;
	}

     public static double distance(double x1, double y1, double x2, double y2){

    	double distance;
    	double calcul = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
    	distance = Math.sqrt(calcul);

    	return distance;
    }


    public static int idDebutLigne(int ligne){

        int id  = (int)(0.5*Math.pow(ligne,2) - 0.5*ligne);
        
        return id;
    }


    public static int idFinLigne(int ligne){
        
        int id = (int)(0.5*Math.pow(ligne, 2) + 0.5*ligne - 1);
        
        return id;
    }

    public static int calculGagnant(int idresultat, Jeton[] etat){
		int ligne =0;
		int score =0;

		while( idresultat < (idFinLigne(ligne))){
			ligne++;
		}

		int scoretemp =0;
		if (idresultat == idFinLigne(ligne)){                                       /* CALCUL POUR FIN DE LIGNE */
			if (etat[idresultat + (6-ligne)].getCouleur() == Plateau.couleur.ROUGE){
				scoretemp += -(etat[idresultat + (6-ligne)].getValeur());
			}
			else{
				scoretemp += etat[idresultat + (6-ligne)].getValeur();
			}
			if (etat[idresultat + (6-ligne)].getCouleur() == Plateau.couleur.ROUGE){
				scoretemp += -(etat[idresultat + (6-ligne)].getValeur());
			}
			else{
				scoretemp += etat[idresultat - 1].getValeur();
			}
			if (etat[idresultat - (6-ligne)].getCouleur() == Plateau.couleur.ROUGE){
				scoretemp += -(etat[idresultat - (6-ligne)].getValeur());
			}
			else{
				scoretemp += etat[idresultat - (6-ligne)].getValeur();
			}
			if (etat[idresultat - (6-ligne+1)].getCouleur() == Plateau.couleur.ROUGE){
				scoretemp += -(etat[idresultat - (6-ligne)].getValeur());
			}
			else{
				scoretemp += etat[idresultat - (6-ligne+1)].getValeur();
			}

		}


		if (idresultat == idDebutLigne(ligne)){

		}

		else {

		}
		return scoretemp;
	}

}
