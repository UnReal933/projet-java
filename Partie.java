import java.util.Scanner;

/**
 * Created by zulupero on 08/09/16.
 */
public class Partie {
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        StdDraw.enableDoubleBuffering(); // permet un affichage sans scintillement

        Plateau jeu = new Plateau();  // argument à compléter selon conception


        StdDraw.clear(); 
        jeu.trace();
        StdDraw.show(); 
        StdDraw.pause(10); 
        /*
         *  Modèle de séquence pour afficher correctement
         *
        StdDraw.clear();    // effacer le tampon (cela n'affecte pas encore l'affichage)
        jeu.tracePlateau(); // effectuer les tracés voulus (n'affecte pas encore l'affichage)
        StdDraw.show();     // mettre à jour l'affichage à l'écran
        StdDraw.pause(10);  // attendre avant la prochaine mis à jour
        */

    }
}
