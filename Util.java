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

     public static double distance(double x1, double y1, double x2, double y2){

    	double distance;
    	double calcul = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
    	distance = Math.sqrt(calcul);

    	return distance;
    }
}
