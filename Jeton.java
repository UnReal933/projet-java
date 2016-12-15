/**
 * Created by zulupero on 08/09/16.
 */
public class Jeton {
    private int valeur;
    private Plateau.couleur couleur;
    private int position;
    private double rayon ;

    /**
     * Constructeur initialisant l'ensemble des attributs.
     * @param val valeur faciale du jeton
     * @param col couleur du jeton
     * @param r rayon du jeton
     * @param pos position sur le plateau
     */
    public Jeton(int val, Plateau.couleur col, double r, int pos){
        valeur = val;
        couleur = col;
        position = pos;
        rayon = r;
    }

    /**
     * Constructeur initialisant l'ensemble des atributs,
     * sauf le rayon.
     * @param val valeur faciale du jeton
     * @param col couleur du jeton
     * @param pos position sur le plateau
     */
    public Jeton(int val, Plateau.couleur col, int pos){
        valeur = val;
        couleur = col;
        position = pos;
    }

    /**
     * Constructeur initialisant l'ensemble des attributs,
     * sauf la position, qui n'est pas nécessairement connue
     * à la construction.
     * @param val valeur faciale du jeton
     * @param col couleur du jeton
     * @param r rayon du jeton
     */
    public Jeton(int val, Plateau.couleur col, double r){
        valeur = val;
        couleur = col;
        rayon = r;
    }

    /**
     * Dessine le jeton sur le plateau
     * @param x abcisse du jeton
     * @param y ordonnée du jeton
     */
    public void trace(double x, double y){
        StdDraw.filledCircle(x, y, 0.5); 
    }

    public int getPosition(){ return position; }
    public void setPosition(int id){
        position = id;
    }

    public int getValeur(){ return valeur; }
    public void setValeur(int val){
        valeur = val;
    }

    public Plateau.couleur getCouleur(){ return couleur; }
    public void setCouleur(Plateau.couleur col){
        couleur = col;
    }

    public double getRayon(){ return rayon; }
    public void setRayon(double r){
        rayon = r;
    }


}
