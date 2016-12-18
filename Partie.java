import java.util.Scanner;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * Created by zulupero on 08/09/16.
 */
public class Partie{
    final static Scanner input = new Scanner(System.in);


    public static void main(String[] args) throws InterruptedException {
        StdDraw.enableDoubleBuffering(); // permet un affichage sans scintillement
        int jouer = 0;
        while(jouer == 0){
        Plateau jeu = new Plateau();  // argument à compléter selon conception
        
        boolean start = true;
        int nbTour = 20;
        boolean melange = true;
        int rep = 0;
        int nbCoup = 0;
        int nbCoupBleu = 0;
        int nbCoupRouge = 0;
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

        //écran de sélection pour mélangez ou on les jetons
        while(rep == 0){
            if(StdDraw.mousePressed()){ 
                        if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                            x = StdDraw.mouseX();
                            y = StdDraw.mouseY();
                            //position des 2 boutons de choix du mélange ou non
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
        rep = 0;
        
            Jeton[] etat = jeu.getEtat();
            etat = new Jeton[Plateau.N_POS];

            StdDraw.clear();
            jeu.Plateau(melange, etat);
            StdDraw.show();
            StdDraw.pause(10);
           
            

            //fonctions s'occupant du déroulement de la partie
            while(nbCoup<20){
                if (StdDraw.mousePressed()){ 
                    if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                        x = StdDraw.mouseX();
                        y = StdDraw.mouseY();
                            
                        id = jeu.selectId(x, y);

                        if(id != 22 && etat[id] == null){
                            if(nbCoup%2==0){
                                val = jeu.getIdBleu();
                                etat[id] = new Jeton(val, Plateau.couleur.BLEU, id);
                                StdDraw.setPenColor(StdDraw.BLUE);
                                Jeton.trace(Plateau.plateau[id][0], Plateau.plateau[id][1], val);
                                nbCoupBleu++;
                                if(nbCoupBleu<10){
                                    jeu.setIdBLeu(nbCoupBleu);
                                }
                            }else{
                                val = jeu.getIdRouge();
                                etat[id] = new Jeton(val, Plateau.couleur.ROUGE, id);
                                StdDraw.setPenColor(StdDraw.RED);
                                Jeton.trace(Plateau.plateau[id][0], Plateau.plateau[id][1], val);
                                nbCoupRouge++;
                                if(nbCoupRouge<10){
                                    jeu.setIdRouge(nbCoupRouge);
                                }
                                
                            }

                            StdDraw.clear(); 
                            jeu.setEtat(etat);
                            jeu.trace(etat);

                            if(nbCoupBleu == 10){
                                StdDraw.setPenColor(StdDraw.GRAY);
                                StdDraw.filledCircle(0.5, 4.5, 0.5);
                            }
                            if(nbCoupRouge == 10){
                                StdDraw.setPenColor(StdDraw.GRAY);
                                StdDraw.filledCircle(4.5, 4.5, 0.5); 
                            }
                            StdDraw.show();
                            StdDraw.pause(10);
                            nbCoup++;
                        }
                                                  
                    }
                        
                }
                
            } 
            
            int caseVide = jeu.caseVide(etat);
            int gagnant = jeu.determineGagnant(etat, caseVide);
            StdDraw.clear();
            if(gagnant == 1){
                System.out.println("Le joueur bleu a gagné !");
                StdDraw.text(2.5, 3, "Le joueur bleu a gagné !");
            }
            else if(gagnant == -1){
                System.out.println("Le joueur rouge a gagné !");
                StdDraw.text(2.5, 3, "Le joueur rouge a gagné !");
            }
            else{
                System.out.println("Egalité !");
                StdDraw.text(2.5, 3, "Egalité !");
            }
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledRectangle(1.75, 2, 0.5, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(1.75, 2, "Rejouer");
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(3.25, 2, 0.5, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(3.25, 2, "Menu");
            StdDraw.show();
            StdDraw.pause(10);

            while(rep == 0){
                if(StdDraw.mousePressed()){ 
                            if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                                x = StdDraw.mouseX();
                                y = StdDraw.mouseY();
                                //position des 2 boutons de choix du mélange ou non
                                if((x >= (1.75-0.5) && x <= (1.75+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                    jouer = 0;
                                    rep = 1;
                                }
                                if((x >= (3.25-0.5) && x <= (3.25+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                    jouer = 1;
                                    rep = 1;
                                }
                            }
                }
            }
            rep = 0;
        }
        StdDraw.clear(); 
        StdDraw.show();
        StdDraw.text(2.5, 3, "Menu");
    }
}
