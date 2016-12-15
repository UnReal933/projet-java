import java.util.Scanner;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * Created by zulupero on 08/09/16.
 */
public class Partie{
    final static Scanner input = new Scanner(System.in);


    public static void main(String[] args) throws InterruptedException {
        StdDraw.enableDoubleBuffering(); // permet un affichage sans scintillement

        Plateau jeu = new Plateau();  // argument à compléter selon conception
        
        boolean start = true;
        int nbTour = 20;
        boolean melange = true;
        int rep = 0;
        int nbCoup = 0;
        int nbCoupBleu = 1;
        int nbCoupRouge = 1;
        double x = 0;
        double y = 0;
        int id;
        int val;

        // Menu pour choisir si l'on veut melanger ou non les jetons
        StdDraw.setXscale(-0.5, 5.5); // fixe l'amplitude des abscisses dans la fenêtre
        StdDraw.setYscale(-0.5, 5.5); // fixe l'amplitude des ordonnées dans la fenêtre
        StdDraw.text(2.5, 4, "Le jeton manquant");
        StdDraw.text(2.5, 3, "Voulez-vous mélanger les jetons ?");
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledRectangle(1.75, 2, 0.5, 0.25);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(1.75, 2, "Oui");
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(3.25, 2, 0.5, 0.25);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(3.25, 2, "Non");
        StdDraw.show();
        StdDraw.pause(10);

        while(rep == 0){
            if(StdDraw.mousePressed()){ 
                        if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                            x = StdDraw.mouseX();
                            y = StdDraw.mouseY();

                            if((x >= (1.75-0.5) && x <= (1.75+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                melange = true;
                                rep = 1;
                            }
                            if((x >= (3.25-0.5) && x <= (3.25+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                 melange = false;
                                 rep = 1;
                            }
                        }
            }
        }
        
        /*
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

        */
        StdDraw.clear();
        jeu.Plateau(melange);
        StdDraw.show();
        StdDraw.pause(10);
       
        Jeton jeu = new Jeton();

        while(nbCoup<20){
            if (StdDraw.mousePressed()){ 
                if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                    x = StdDraw.mouseX();
                    y = StdDraw.mouseY();
                        
                    id = jeu.selectId(x, y);
                    Jeton[] etat = jeu.getEtat();


                        if(nbCoup%2==0){
                            val = jeu.getIdBleu();
                            StdDraw.setPenColor(StdDraw.BLUE);
                            jeu.setIdBLeu(nbCoupBleu);
                            nbCoupBleu++;
                            // etat[nbCoup] = new Jeton(val, Plateau.couleur.BLEU, id);
                        }else{
                            val = jeu.getIdRouge();
                            StdDraw.setPenColor(StdDraw.RED);
                            jeu.setIdRouge(nbCoupRouge);
                            nbCoupRouge++;
                        }

                        StdDraw.clear(); 
                        jeu.setEtat(etat);
                        jeu.trace();
                        StdDraw.show();
                        StdDraw.pause(10);
                        nbCoup++;
                    
                                              
                }
                    
            }
            
        }
        

    }


    
}
