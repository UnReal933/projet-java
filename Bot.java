import java.util.*;

public class Bot {

    public static void playBot ( Jeton[] etat, int nbcoupstemp, int valeur ){

        double nbcoups = nbcoupstemp/2;
        int position =0;
        int condition = 0;
        int ligne;
        int tour = 0;


        if (valeur < 6){

            while (condition == 0){

                position = (int)(Math.random() * (( 20 - 0 )+1));
                ligne =0;

                while (position > Util.idFinLigne(ligne)){

                    ligne++;

                }

                if (etat[position] == null && Util.idFinLigne(ligne) != position && Util.idDebutLigne(ligne) != position){

                    if (nbcoupstemp%2 == 0){

                        etat[position] = new Jeton(valeur, Plateau.couleur.ROUGE, position);
                        condition = 1;
                    }
                    else{

                        etat[position] = new Jeton(valeur, Plateau.couleur.BLEU, position);
                        condition = 1;
                    }

                }
                if (tour > 15 && condition != 1){
                    if (etat[position] == null){
                        if (nbcoupstemp%2 == 0){

                            etat[position] = new Jeton(valeur, Plateau.couleur.ROUGE, position);
                            condition = 1;
                        }
                        else{

                            etat[position] = new Jeton(valeur, Plateau.couleur.BLEU, position);
                            condition = 1;
                        }
                    }
                }

                tour++;
            }

        }

        else {

            condition = 0;
            for (int i = 0 ; i <6 ; i++) {

                if (etat[Util.idFinLigne(i)] == null && condition != 1) {

                    if (nbcoupstemp % 2 == 0) {

                        etat[Util.idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, Util.idFinLigne(i));
                        condition = 1;

                    } else {

                        etat[Util.idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, Util.idFinLigne(i));
                        condition = 1;
                    }
                }

                if (etat[Util.idDebutLigne(i)] == null && condition != 1) {

                    if (nbcoupstemp % 2 == 0) {

                        etat[Util.idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, Util.idDebutLigne(i));
                        condition = 1;

                    } else {

                        etat[Util.idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, Util.idDebutLigne(i));
                        condition = 1;
                    }
                }
            }
            if (condition !=1) {
                for (int i = 0 ; i <20 ; i++) {

                    if (etat[i] == null && condition != 1) {

                        if (etat[i + 1] != null) {

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

                

                if (condition != 1 ) {
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