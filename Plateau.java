/**
 * Created by zulupero on 08/09/16.
 */

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

    /**

     * Fonctions définissant l'échelle de la fenêtre graphique, et initialisant les attributs et appelle la méthode trace.

     * @param melange mode aléatoire ou non

     * @param Jeton[] etat donne l'état du jeton

     */
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
    /**
     * Fonctions affichant la chaine des état des jetons.
     */
    public void affiche(double x, double y, String chaine){
         StdDraw.text(x, y, chaine);
    }
    /**

     * Fonctions créant une chaine avec les états des jetons.

     * @param Jeton[] etat donne l'état du jeton

     */
    public String afficheEtat(Jeton[] etat){
        String chaineEtat = "[ ";
        int val;
        for(int i = 0; i<N_POS; i++){
            if(etat[i] != null){
                val = etat[i].getValeur();
                if(etat[i].getCouleur() == Plateau.couleur.BLEU){
                    chaineEtat = chaineEtat + "B";
                }else{
                    chaineEtat = chaineEtat + "R";
                }
                chaineEtat = chaineEtat + String.valueOf(val);
            }else{
                chaineEtat = chaineEtat + "_";
            }
            chaineEtat = chaineEtat + " ";
        }

        chaineEtat = chaineEtat + "]";

        return chaineEtat;
    }

    /**

     * Fonctions retournant l'id bleu.

     */
    public int getIdBleu(){
        return idBleu;
    }

    /**

     * Fonctions retournant l'id rouge.

     */
    public int getIdRouge(){
        return idRouge;
    }

    /**

     * Fonctions définissant l'Id d'un jetons bleu.

     */
    public void setIdBLeu(int rang){
        idBleu = valBleus[rang];
    }

    /**

     * Fonctions définissant l(id d'un jeotn rouge.

     */
    public void setIdRouge(int rang){
        idRouge = valRouges[rang];
    }

    /**

     * Fonctions traçant le tableau.

     * @param Jeton[] etat donne l'état du jeton

     */
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
    /**

     * Fonctions créant une chaine avec les états des jetons.

     * @param double x , donne l'abscisse du jeton.

     *@param double y , donne l'ordonné du jeton.

     */
    public int selectId(double x, double y){
        
        int id = getIdCase(x, y);
       
        return id;
    }
    /**

     * Fonctions retournant l'Id de la case.

     * @param double x , donne l'abscisse du jeton.

     *@param double y , donne l'ordonné du jeton.

     */
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

    /**

     * Fonctions retournant le numéro de la case vide.

     * @param Jeton[] etat donne l'état du jeton


     */
    public int caseVide(Jeton[] etat){
        int i = 0;

        while(etat[i] != null){
            i++;
        }
        return i;
    }
    /**

     * Fonctions déterminant le gangant.

     * @param Jeton[] etat donne l'état du jeton.

     * @param idVide est l'Id de la case vide.

     */
    public static int determineGagnant(Jeton[] etat, int idVide){
        int scoreBleu = 0;
        int scoreRouge = 0;
        double distance;
        int gagnant;

        for(int i = 0; i < Plateau.N_POS; i++){
            if(i != idVide){
               distance = Util.distance(plateau[i][0],plateau[i][1], plateau[idVide][0], plateau[idVide][1]);
                if(distance <= 2.1*Plateau.R){
                    if(etat[i].getCouleur() == couleur.BLEU){
                        scoreBleu = scoreBleu + etat[i].getValeur();
                    }else{
                        scoreRouge = scoreRouge + etat[i].getValeur();
                    }
                } 
            } 
        }

        if(scoreRouge > scoreBleu){
            gagnant = 1;
        }
        else if(scoreRouge < scoreBleu){
            gagnant = -1;
        }
        else{
            gagnant = 0;
        }
        
        return gagnant;
    }

}
