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

        while(true){
            boolean start = true;
            int nbTour = 20;
            boolean melange = true;
            int reponse = 0;
            int nbCoup = 0;
            int nbCoupBleu = 0;
            int nbCoupRouge = 0;
            double x = 0;
            double y = 0;
            int id;
            int val;
            int typePartie = 0;

            // Menu principal du jeu
            StdDraw.setXscale(-0.5, 5.5);
            StdDraw.setYscale(-0.5, 5.5);
            StdDraw.text(2.5, 5, "Le jeton manquant");
            StdDraw.text(2.5, 4, "MENU");

            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledRectangle(2.5, 3, 1, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(2.5, 3, "Joueur vs Joueur");

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(2.5, 2, 1, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(2.5, 2, "Joueur vs Serveur");

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledRectangle(2.5, 1, 1, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(2.5, 1, "IA");

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.text(2.5, 0, "Thomas BICHOT - Thomas GARCENOT - Benjamin ESCOBAR");
            StdDraw.show();
            StdDraw.pause(10);

            //écran de sélection pour mélangez ou on les jetons
            while(reponse == 0){

                if(StdDraw.mousePressed()){ 
                            if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                                x = StdDraw.mouseX();
                                y = StdDraw.mouseY();
                                //position des 2 boutons de choix du mélange ou non
                                if((x >= (2.5-1) && x <= (2.5+1)) && (y >= (3-0.25) && y <= (3+0.25))){
                                    System.out.println("JvJ");
                                    typePartie = 0;     
                                }
                                if((x >= (2.5-1) && x <= (2.5+1)) && (y >= (2-0.25) && y <= (2+0.25))){
                                     System.out.println("JvC");
                                     typePartie = 1;     
                                }
                                 if((x >= (2.5-1) && x <= (2.5+1)) && (y >= (1-0.25) && y <= (1+0.25))){
                                     System.out.println("IA");
                                     typePartie = 2;     
                                }
                                reponse = 1;
                            }
                }
            }
            reponse = 0;
            StdDraw.clear();


            while(typePartie == 0){
                Plateau jeu = new Plateau();  // argument à compléter selon conception
            
                melange = true;
                reponse = 0;
                nbCoup = 0;
                nbCoupBleu = 0;
                nbCoupRouge = 0;
                x = 0;
                y = 0;
                

                // Menu pour choisir si l'on veut melanger ou non les jetons
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
                while(reponse == 0){
                    if(StdDraw.mousePressed()){ 
                                if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                                    x = StdDraw.mouseX();
                                    y = StdDraw.mouseY();
                                    //position des 2 boutons de choix du mélange ou non
                                    if((x >= (1.75-0.5) && x <= (1.75+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                        melange = true;
                                        reponse = 1;
                                    }
                                    if((x >= (3.25-0.5) && x <= (3.25+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                         melange = false;
                                         reponse = 1;
                                    }
                                }
                    }
                }
                reponse = 0;
                
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

                    while(reponse == 0){
                        if(StdDraw.mousePressed()){ 
                                    if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                                        x = StdDraw.mouseX();
                                        y = StdDraw.mouseY();
                                        //position des 2 boutons de choix du mélange ou non
                                        if((x >= (1.75-0.5) && x <= (1.75+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                            typePartie = 0;
                                            reponse = 1;
                                        }
                                        if((x >= (3.25-0.5) && x <= (3.25+0.5)) && (y >= (2-0.25) && y <= (2+0.25))){
                                            typePartie = 3;
                                            reponse = 1;
                                        }
                                    }
                        }
                    }
                    reponse = 0;
            }
        StdDraw.clear(); 
        }
    }
}
