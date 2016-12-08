/**
 * Created by zulupero on 08/09/16.
 */

import java.util.*;

public class Plateau {

    /* constantes de la classe*/
    public static final int N_POS = 21; // nombre de cases
    public static final int N_LIG = 6;  // nombre de lignes de cases
    public static final double R = 1.0; // rayon des cases
    public static final double D = 2*R; // diamètre des cases
    public static final int ID_MAX = 10;// Valeur max / indice max des jetons
    //public static final double L_JEU = 10;              // Largeur de la fenêtre de jeu
    //public static final double H_JEU = L_JEU; // Hauteur de la fenêtre de jeu

    /* attributs */
    private int idBleu;    // numéro d'ordre du prochan jeton bleu à poser
    private int idRouge;    // numéro d'ordre du prochan jeton rouge à poser

    private int[] valBleus = new int[10];             // valeurs faciales des jetons bleus
    private int[] valRouges = new int[10];     // valeurs faciales des jetons rouges

    public static double L_JEU;
    public static double H_JEU;

    public enum couleur {                       // constantes pour les couleurs des jetons
        BLEU, ROUGE
    };


     public void Plateau(boolean melange){
        L_JEU = 10;
        H_JEU = L_JEU;

        Random rand = new Random();

        int random; 
        int i = 0;
        int j = 0;
        boolean test = false;
        
        if(melange == true){
            while(i<10){
                test = false;
                random = rand.nextInt(10 - 1 + 1) + 1;
                System.out.println(random);
                for(int k = 0; k<10; k++){
                    if(valBleus[k] == random){
                        test = true;
                    }
                }
                if(test==false){
                    valBleus[i] = random;
                    i++;
                }
            }
            while(j<10){
                test = false;
                random = rand.nextInt(10 - 1 + 1) + 1;
                for(int k = 0; k<10; k++){
                    if(valRouges[k] == random){
                        test = true;
                    }
                }
                if(test==false){
                    valRouges[j] = random;
                    j++;
                }
            }
        }else{
            for(i=0; i<10; i++){
                valBleus[i] = i+1;
                valRouges[i] = i+1;
            }
        }

        idBleu = valBleus[0];
        idRouge = valRouges[0];
        
        tracePlateau();
        traceEmplacementJeton();
        
    }


    public int getIdBleu(){
        return idBleu;
    }

    public int getIdRouge(){
        return idRouge;
    }

    public void setIdBLeu(int rang){
        idBleu = valBleus[rang];
    }

    public void setIdRouge(int rang){
        idRouge = valRouges[rang];
    }

    public void testDeplacementJeton(){
       
        double x;
        double y;
        
        x = StdDraw.mouseX();
        y = StdDraw.mouseY();
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(x, y, 0.5);
       

    }

    public void traceEmplacementJeton(){
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(0.5, 4.5, 0.5);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(4.5, 4.5, 0.5); 
        StdDraw.setPenColor(StdDraw.WHITE);
        String nombreBleu =  String.valueOf(idBleu);
        String nombreRouge =  String.valueOf(idRouge);
        StdDraw.text(0.5, 4.5, nombreBleu);
        StdDraw.text(4.5, 4.5, nombreRouge);

    }
    
    public void tracePlateau(){
        double i;
        double j;

        StdDraw.setXscale(-0.5, 5.5); // fixe l'amplitude des abscisses dans la fenêtre
        StdDraw.setYscale(-0.5, 5.5); // fixe l'amplitude des ordonnées dans la fenêtre
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(2.5, 5.2, "Le jeton manquant");
        for (i=0; i<N_LIG;i++){
            for (j=0; j<(N_LIG-i);j++){
                    if (i>0){
                        StdDraw.circle(j+i*0.5, i-i*0.12, 0.5);  
                    }else{
                        StdDraw.circle(j+i*0.5, i, 0.5);  
                    }  
                      
            }
        }
    }

    private Jeton[] etat;                       // tableau de jetons (1 jeton par case ou null si vide)

    /* fin des attribus */

    /* assesseurs pour l'attribut état */
    public Jeton[] getEtat(){
        return etat;
    }
    public void setEtat(Jeton[] state){
        etat = state.clone();
    }


}
