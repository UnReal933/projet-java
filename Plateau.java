/**
 * Created by zulupero on 08/09/16.
 */

import java.util.*;

public class Plateau {

    /* constantes de la classe*/
    public static final int N_POS = 21; // nombre de cases
    public static final int N_LIG = 6;  // nombre de lignes de cases
    public static final double R = 0.5; // rayon des cases
    public static final double D = 2*R; // diamètre des cases
    public static final int ID_MAX = 10;// Valeur max / indice max des jetons
    //public static final double L_JEU = 10;              // Largeur de la fenêtre de jeu
    //public static final double H_JEU = L_JEU; // Hauteur de la fenêtre de jeu

    /* attributs */
    private int idBleu;    // numéro d'ordre du prochan jeton bleu à poser
    private int idRouge;    // numéro d'ordre du prochan jeton rouge à poser

    private int[] valBleus = new int[ID_MAX];             // valeurs faciales des jetons bleus
    private int[] valRouges = new int[ID_MAX];     // valeurs faciales des jetons rouges

    public static double[][] plateau = new double[21][2];

    public static double L_JEU;
    public static double H_JEU;


    public enum couleur {                       // constantes pour les couleurs des jetons
        BLEU, ROUGE
    };


     public void Plateau(boolean melange, Jeton[] etat){
       
        L_JEU = 10;
        H_JEU = L_JEU;

        Random rand = new Random();

        int random; 
        int i = 0;
        int j = 0;
        int compteur = 0;
        boolean test = false;
        for(i=0; i<10; i++){
                valBleus[i] = i+1;
                valRouges[i] = i+1;
        }
        if(melange == true){
            Util.shuffle(valBleus);
            Util.shuffle(valRouges);
        }
    
        idBleu = valBleus[0];
        idRouge = valRouges[0];


        for (i=0; i<N_LIG;i++){
            for (j=0; j<(N_LIG-i);j++){
                    if (i>0){
                        plateau[compteur][0] = j+i*R;
                        plateau[compteur][1] = i-i*0.12;
                    }else{
                        plateau[compteur][0] = j+i*R;
                        plateau[compteur][1] = i;
                    }  
                    compteur++;  
            }
        }
        trace(etat);
    }
        
        /*
        public String[] afficheEtat(){
            String j;

            String[] chaine;
            j=Util.state2string(chaine);
            chaine = j.split("");
            return chaine;
        }

    */
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

    
    public void trace(Jeton[] etat){
        int i;
        int val;

        StdDraw.setXscale(-R, 5.5); // fixe l'amplitude des abscisses dans la fenêtre
        StdDraw.setYscale(-R, 5.5); // fixe l'amplitude des ordonnées dans la fenêtre
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(2.5, 5.2, "Le jeton manquant");
        for(i=0; i<N_POS; i++){
              StdDraw.circle(plateau[i][0], plateau[i][1], R);
              //StdDraw.text(plateau[i][0], plateau[i][1], String.valueOf(i)); 
        }
       
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(R, 4.5, R);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(4.5, 4.5, R); 
        StdDraw.setPenColor(StdDraw.WHITE);
        String nombreBleu =  String.valueOf(idBleu);
        String nombreRouge =  String.valueOf(idRouge);
        StdDraw.text(0.5, 4.5, nombreBleu);
        StdDraw.text(4.5, 4.5, nombreRouge);
        
        for(i = 0; i<N_POS; i++){
            if(etat[i] != null){
                val = etat[i].getValeur();
                if(etat[i].getCouleur() == Plateau.couleur.BLEU){
                    StdDraw.setPenColor(StdDraw.BLUE);
                }else{
                    StdDraw.setPenColor(StdDraw.RED);
                }
                StdDraw.filledCircle(plateau[i][0], plateau[i][1], R);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(plateau[i][0], plateau[i][1], String.valueOf(val));  
            }
        }
    }

    public int selectId(double x, double y){
        
        int id = getIdCase(x, y);
       
        return id;
    }

    public int getIdCase(double x, double y){
        int id = 22;
        double distance;
        for(int i=0; i<N_POS; i++){
            distance = Util.distance(plateau[i][0],plateau[i][1], x, y);
            if(distance < R){
                id = i;
            }
        }

        return id;
    }

    private Jeton[] etat;                       // tableau de jetons (1 jeton par case ou null si vide)

    /* fin des attributs */

    /* assesseurs pour l'attribut état */
    public Jeton[] getEtat(){
        return etat;
    }
    public void setEtat(Jeton[] state){
        etat = state.clone();
    }


    public double caseVide(){
        for (double i=0; i<=N_POS;i++ ) {
            for (double j=0;j<=N_POS;j++  ) {
                
            
            if(selectId(i,j)!=getIdRouge()&& selectId(i,j)!=getIdBleu()){
                return selectId(i,j);
            }
           } 
        }
        return 1;
    }


}
