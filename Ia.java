import java.util.*;

public class Ia {

    public Jeton[] Bot( Jeton[] etat, int nbcoupstemp, int valeur ){

        double nbcoups = nbcoupstemp/2;
        int position =0;

        while (position > idFinLigne(ligne)){

            ligne++;

        }

        if (valeur < 6){

            while (condition == 0){

                position = (int)(Math.random() * (( 20 - 0 )+1));
                int ligne =0;

                if (caseVide(Jeton[position]) ==0 && idFinLigne(ligne) != position && idDebutLigne(ligne) != position){

                    if (nbcoupstemp%2 == 0){

                        etat[position] = new Jeton(valeur, Plateau.couleur.BLEU, position);
                    }
                    else{

                        etat[position] = new Jeton(valeur, Plateau.couleur.ROUGE, position);
                    }

                }

            }
            
        }

        else {

            for (int i = 0 ; i <6 ; i++){

                if (caseVide(Jeton[idFinLigne(i)]) ==0){

                    if (nbcoupstemp%2 == 0){

                        etat[idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, idFinLigne(i));

                    }

                    else{

                        etat[idFinLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, idFinLigne(i));
                    }
                }
                if (caseVide(Jeton[idDebutLigne(i)]) ==0){

                    if (nbcoupstemp%2 == 0){

                        etat[idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.BLEU, idDebutLigne(i));

                    }

                    else{

                        etat[idDebutLigne(i)] = new Jeton(valeur, Plateau.couleur.ROUGE, idDebutLigne(i));
                    }
                }

                else {

                    for (int i = 0 ; i <20 ; i++){

                        if (caseVide(Jeton[i]) ==0){

                            if (caseVide(Jeton[i+1]) ==0 ){

                                if (nbcoupstemp%2 == 0){

                                    etat[i] = new Jeton(valeur, Plateau.couleur.ROUGE, i);

                                }

                                else{

                                    etat[i] = new Jeton(valeur, Plateau.couleur.ROUGE, i);
                                }
                            }
                        }
                    }

                    for (int i = 0 ; i <=20 ; i++){

                        if (caseVide(Jeton[i]) ==0){

                            if (nbcoupstemp%2 == 0){

                                etat[i] = new Jeton(valeur, Plateau.couleur.ROUGE, i);
                            }

                            else{

                                etat[i] = new Jeton(valeur, Plateau.couleur.ROUGE, i);
                            }
                        }
                    }
                }
            }
        }
    }
}