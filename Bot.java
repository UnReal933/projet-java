import java.util.*;

public class Bot {

    /**
     * Génération de l'IA
     * @param etat[] tableau des valeurs
     * @param nbcoupstemps le nb de coups pour définir la couleur à utiliser
     * @param valeur la valeur à attibuer au jeton
     */

    public static void playBot ( Jeton[] etat, int nbcoupstemp, int valeur ){

        int position =0;
        int condition = 0;
        int ligne;
        int tour = 0;


        if (valeur < 6){        //Lorsque les valeurs sont inférieurs à 6, on place aléatoirement

            while (condition == 0){

                position = (int)(Math.random() * (( 20 - 0 )+1));       //Génération position aléatoire
                ligne =0;

                while (position > Util.idFinLigne(ligne)){

                    ligne++;                                            //Récupération de la ligne

                }

                if (etat[position] == null && Util.idFinLigne(ligne) != position && Util.idDebutLigne(ligne) != position){     // On évite de placer aux extrémités au départ

                    if (nbcoupstemp%2 == 0){

                        etat[position] = new Jeton(valeur, Plateau.couleur.BLEU, position);
                        condition = 1;
                    }
                    else{

                        etat[position] = new Jeton(valeur, Plateau.couleur.ROUGE, position);
                        condition = 1;
                    }

                }
                if (tour > 15 && condition != 1){           // On inclut quand même le reste du plateau au cas ou elle sera toute prise
                    if (etat[position] == null){
                        if (nbcoupstemp%2 == 0){

                            etat[position] = new Jeton(valeur, Plateau.couleur.BLEU, position);
                            condition = 1;
                        }
                        else{

                            etat[position] = new Jeton(valeur, Plateau.couleur.ROUGE, position);
                            condition = 1;
                        }
                    }
                }

                tour++;
            }

        }

        else {

            condition = 0;
            for (int i = 0 ; i <6 ; i++) {                  // A partir de 6 on utilise les extrémités en premier lieu

                if (etat[Util.idFinLigne(i)] == null && condition != 1) {       //On teste fin de lignes

                    if (nbcoupstemp % 2 == 0) {

                        etat[Util.idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, Util.idFinLigne(i));
                        condition = 1;

                    } else {

                        etat[Util.idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, Util.idFinLigne(i));
                        condition = 1;
                    }
                }

                if (etat[Util.idDebutLigne(i)] == null && condition != 1) {     // Sinon on teste les débuts de ligne

                    if (nbcoupstemp % 2 == 0) {

                        etat[Util.idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, Util.idDebutLigne(i));
                        condition = 1;

                    } else {

                        etat[Util.idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, Util.idDebutLigne(i));
                        condition = 1;
                    }
                }
            }
            if (condition !=1) {
                for (int i = 0 ; i <20 ; i++) {                         //Si elles sont prises ont rempli les trous

                    if (etat[i] == null && condition != 1) {

                        if (etat[i + 1] != null) {

                            if (nbcoupstemp % 2 == 0) {

                                etat[i] = new Jeton(valeur, Plateau.couleur.BLEU, i);       // On test trou horizontal
                                condition = 1;

                            } else {

                                etat[i] = new Jeton(valeur, Plateau.couleur.ROUGE, i);
                                condition = 1;
                            }
                        }
                        if (etat[i] == null && condition != 1) {
                            ligne = 0;
                            while (i > Util.idFinLigne(ligne)){

                                ligne++;

                            }

                            if (etat[i + (6-ligne)] != null) {

                                if (nbcoupstemp % 2 == 0) {

                                    etat[i] = new Jeton(valeur, Plateau.couleur.BLEU, i);   // Puis les trous verticaux
                                    condition = 1;

                                } else {

                                    etat[i] = new Jeton(valeur, Plateau.couleur.ROUGE, i);
                                    condition = 1;
                                }
                            }
                        }
                    }
                }

                

                if (condition != 1 ) {          // Si on ne peut pas on remplit ce qu'il reste
                    for (int i = 0; i <= 20; i++) {

                        if (etat[i] == null && condition != 1) {

                            if (nbcoupstemp % 2 == 0) {

                                etat[i] = new Jeton(valeur, Plateau.couleur.BLEU, i);
                                condition = 1;
                            } else {

                                etat[i] = new Jeton(valeur, Plateau.couleur.ROUGE, i);
                                condition = 1;


                            }
                        }
                    }
                }
            }
        }
    }
}