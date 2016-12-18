import java.util.Scanner;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.*;
import sun.audio.*;
import java.awt.event.*;
import java.io.*;

/**
 * Created by zulupero on 08/09/16.
 */
public class Partie{
    final static Scanner input = new Scanner(System.in);

            public static boolean quitter = false;
            public static int nbTour = 20;
            public static boolean melange = true;
            public static int reponse = 0;
            public static int nbCoup = 0;
            public static int nbCoupBleu = 0;
            public static int nbCoupRouge = 0;
            public static double x = 0;
            public static double y = 0;
            public static int id;
            public static int val;
            public static int typePartie;

    public static void main(String[] args) throws InterruptedException {
        StdDraw.enableDoubleBuffering(); // permet un affichage sans scintillement


        musique();
        
        while(quitter == false){

            menu();

            while(typePartie == 0){
                partieJoueurJoueur();
            }

            while(typePartie == 1){    
                partieJoueurServeur();
            }

            while(typePartie == 2){
                partieJoueurIA();
            }


            StdDraw.clear(); 
        }
        System.exit(0);
    }

    public static void menu(){
          // Menu principal du jeu
            StdDraw.setXscale(-0.5, 5.5);
            StdDraw.setYscale(-0.5, 5.5);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(2.5, 5, "Le jeton manquant");
            StdDraw.text(2.5, 4, "MENU");

            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledRectangle(2.5, 3, 1, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(2.5, 3, "Joueur vs Joueur");

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(2.5, 2.5, 1, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(2.5, 2.5, "Joueur vs Serveur");

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledRectangle(2.5, 2, 1, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(2.5, 2, "Joueur vs IA");

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(2.5, 1.5, 1, 0.25);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(2.5, 1.5, "QUITTER");

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
                                    typePartie = 0;
                                    reponse = 1;
                                }
                                if((x >= (2.5-1) && x <= (2.5+1)) && (y >= (2.5-0.25) && y <= (2.5+0.25))){
                                     typePartie = 1; 
                                     reponse = 1;    
                                }
                                if((x >= (2.5-1) && x <= (2.5+1)) && (y >= (2-0.25) && y <= (2+0.25))){
                                     typePartie = 2;  
                                     reponse = 1;   
                                }
                                if((x >= (2.5-1) && x <= (2.5+1)) && (y >= (1.5-0.25) && y <= (1.5+0.25))){
                                     quitter = true;  
                                     reponse = 1;   
                                }
                                
                            }
                }
            }
            reponse = 0;
            StdDraw.clear();
    }

    public static void partieJoueurJoueur(){
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

                    //Menu fin de partie
                    StdDraw.clear();
                    int caseVide = jeu.caseVide(etat);
                    int gagnant = jeu.determineGagnant(etat, caseVide);
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
                                    typePartie = 4;
                                    reponse = 1;
                                }
                            }
                        }
                    }
                    reponse = 0;
    }


    public static void partieJoueurServeur(){

        Plateau jeu = new Plateau();  // argument à compléter selon conception
        Client client = new Client();      
        String reponseServeur;
        String chaineEtat;
        melange = false;
        reponse = 0;
        nbCoup = 0;
        nbCoupBleu = 0;
        nbCoupRouge = 0;
        x = 0;
        y = 0;
                    
        Jeton[] etat = jeu.getEtat();
        etat = new Jeton[Plateau.N_POS];

        StdDraw.clear();
        jeu.Plateau(melange, etat);
        StdDraw.show();
        StdDraw.pause(10);
                   
        int j = 0; 

        //fonctions s'occupant du déroulement de la partie
        while(nbCoup < 20){
            if(nbCoup%2 == 0){
                while(j == 0){
                    if(StdDraw.mousePressed()){ 
                        if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                            x = StdDraw.mouseX();
                            y = StdDraw.mouseY();
                                
                            id = jeu.selectId(x, y);

                            if(id != 22 && etat[id] == null){
                                
                                val = jeu.getIdBleu();
                                etat[id] = new Jeton(val, Plateau.couleur.BLEU, id);
                                StdDraw.setPenColor(StdDraw.BLUE);
                                Jeton.trace(Plateau.plateau[id][0], Plateau.plateau[id][1], val);
                                nbCoupBleu++;
                                if(nbCoupBleu<10){
                                    jeu.setIdBLeu(nbCoupBleu);
                                }
                                j = 1;  
                            }
                        }
                    }
                }
            }else{
                chaineEtat = jeu.afficheEtat(etat);
                if(nbCoup<=10){
                    reponseServeur = client.querySimplePlay(chaineEtat);
                }else{
                    reponseServeur = client.querySecondStage(chaineEtat);
                }
                

                String tab1[] = Util.state2tab(chaineEtat);
                String tab2[] = Util.state2tab(reponseServeur);

                int taille = tab2.length;
                int i = 0;
                while(tab1[i] == tab2[i]){
                    i++;
                }
                etat[i] = new Jeton(nbCoupRouge+1, Plateau.couleur.ROUGE, i);
                StdDraw.setPenColor(StdDraw.RED);
                Jeton.trace(Plateau.plateau[i][0], Plateau.plateau[i][1], nbCoupRouge+1);
                nbCoupRouge++;
            }
            j=0;
            StdDraw.clear(); 
            jeu.setEtat(etat);
            jeu.trace(etat);
            StdDraw.show();
            StdDraw.pause(10);
            nbCoup++;
            if(nbCoup == 10){
                 chaineEtat = jeu.afficheEtat(etat);
                reponseServeur = client.initSecondStage(chaineEtat);   
            }
        }
        
       
                         
        chaineEtat = jeu.afficheEtat(etat);
        reponseServeur = client.endPlay(chaineEtat);


        //Menu fin de partie
        StdDraw.clear();
        int caseVide = jeu.caseVide(etat);
        int gagnant = jeu.determineGagnant(etat, caseVide);
        if(reponseServeur == "bleus"){
            System.out.println("Le joueur bleu a gagné !");
            StdDraw.text(2.5, 3, "Le joueur bleu a gagné !");
        }
        else if(reponseServeur == "rouges"){
            System.out.println("Le serveur a gagné !");
            StdDraw.text(2.5, 3, "Le serveur a gagné !");
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

        reponseServeur = client.close();
        System.out.println(reponseServeur);

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

    public static void partieJoueurIA(){

        Plateau jeu = new Plateau();  // argument à compléter selon conception
      
        melange = false;
        reponse = 0;
        nbCoup = 0;
        nbCoupBleu = 0;
        nbCoupRouge = 0;
        x = 0;
        y = 0;
                    
        Jeton[] etat = jeu.getEtat();
        etat = new Jeton[Plateau.N_POS];

        StdDraw.clear();
        jeu.Plateau(melange, etat);
        StdDraw.show();
        StdDraw.pause(10);
                   
        int j = 0; 

        //fonctions s'occupant du déroulement de la partie
        while(nbCoup < 20){
            if(nbCoup%2 == 0){
                while(j == 0){
                    if(StdDraw.mousePressed()){ 
                        if(x != StdDraw.mouseX() || y != StdDraw.mouseY()){
                            x = StdDraw.mouseX();
                            y = StdDraw.mouseY();
                                
                            id = jeu.selectId(x, y);

                            if(id != 22 && etat[id] == null){
                                
                                val = jeu.getIdBleu();
                                etat[id] = new Jeton(val, Plateau.couleur.BLEU, id);
                                StdDraw.setPenColor(StdDraw.BLUE);
                                Jeton.trace(Plateau.plateau[id][0], Plateau.plateau[id][1], val);
                                nbCoupBleu++;
                                if(nbCoupBleu<10){
                                    jeu.setIdBLeu(nbCoupBleu);
                                }
                                j = 1;  
                            }
                        }
                    }
                }
            }else{
                Bot.playBot(etat, nbCoupRouge, nbCoupRouge+1);
            }
            j=0;
            StdDraw.clear(); 
            jeu.setEtat(etat);
            jeu.trace(etat);
            StdDraw.show();
            StdDraw.pause(10);
            nbCoup++;
            
        }

        //Menu fin de partie
        StdDraw.clear();
        int caseVide = jeu.caseVide(etat);
        int gagnant = jeu.determineGagnant(etat, caseVide);
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

    public static void musique(){
        try
        {
            InputStream in = new FileInputStream("music.wav");
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);

        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }

}
