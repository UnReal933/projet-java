import java.util.*;

public class Bot {

    public void PlayBot ( Jeton[] etat, int nbcoupstemp, int valeur ){

        double nbcoups = nbcoupstemp/2;
        int position =0;
        int condition = 0;
        int ligne;



        if (valeur < 6){

            while (condition == 0){

                position = (int)(Math.random() * (( 20 - 0 )+1));
                ligne =0;

                while (position > idFinLigne(ligne)){

                    ligne++;

                }

                if (caseVide(Jeton[position]) ==0 && idFinLigne(ligne) != position && idDebutLigne(ligne) != position){

                    if (nbcoupstemp%2 == 0){

                        etat[position] = new Jeton(valeur, Plateau.couleur.BLEU, position);
                        condition = 1;
                    }
                    else{

                        etat[position] = new Jeton(valeur, Plateau.couleur.ROUGE, position);
                        condition = 1;
                    }

                }
                if (tour > 15 && condition != 1){
                    if (caseVide(Jeton[position]) ==0){
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


            }

        }

        else {

            condition = 0;
            for (int i = 0 ; i <6 ; i++) {

                if (caseVide(Jeton[idFinLigne(i)]) == 0) {

                    if (nbcoupstemp % 2 == 0) {

                        etat[idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, idFinLigne(i));
                        condition = 1;

                    } else {

                        etat[idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, idFinLigne(i));
                        condition = 1;
                    }
                }

                if (caseVide(Jeton[idDebutLigne(i)]) == 0 && condition != 1) {

                    if (nbcoupstemp % 2 == 0) {

                        etat[idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, idDebutLigne(i));
                        condition = 1;

                    } else {

                        etat[idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, idDebutLigne(i));
                        condition = 1;
                    }
                }
            }
            if (condition !=1) {
                for (int i = 0 ; i <20 ; i++) {

                    if (caseVide(Jeton[i]) == 0) {

                        if (caseVide(Jeton[i + 1]) != 0) {

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

                        if (caseVide(Jeton[i]) == 0) {

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