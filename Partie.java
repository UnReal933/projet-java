import java.util.Scanner;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * Created by zulupero on 08/09/16.
 */
public class Partie {
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        StdDraw.enableDoubleBuffering(); // permet un affichage sans scintillement

        Plateau jeu = new Plateau();  // argument à compléter selon conception
        boolean start = true;
        
        boolean melange;
        int rep;

        do{
            System.out.println("Voulez-vous mélanger les jetons ? (O : Oui / 1 : Non)");
            rep = input.nextInt();
        }
        while(rep != 0 && rep != 1);

        if(rep == 0){
            melange = true;
        }else{
            melange = false;
        }

        StdDraw.enableDoubleBuffering();
        StdDraw.clear(); 
        jeu.Plateau(melange);
        StdDraw.show();
        
        
    
       
      
        /*
         *  Modèle de séquence pour afficher correctement
         *
        StdDraw.clear();    // effacer le tampon (cela n'affecte pas encore l'affichage)
        jeu.tracePlateau(); // effectuer les tracés voulus (n'affecte pas encore l'affichage)
        StdDraw.show();     // mettre à jour l'affichage à l'écran
        StdDraw.pause(10);  // attendre avant la prochaine mis à jour
        */

    }
    public void mouseClicked(MouseEvent e) {
       System.out.println("click");
    }
}
