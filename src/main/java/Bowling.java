import java.util.LinkedList;

/**
 * Created by 21502887 on 02/03/2016.
 */
public class Bowling {
    int nbjeux; //nombre de lancer
    int prevcoup; //coup précedant
    int nbCoupDernierJeux;
    LinkedList<Integer> jeux;//liste des jeux

    //Constructeur
    public Bowling(){
        nbjeux = 0;
        prevcoup = -1;
        jeux = new LinkedList<Integer>();
        nbCoupDernierJeux =0;
    }

    public Bowling(int pNbJeux,LinkedList<Integer> pJeux){
        nbjeux = pNbJeux;
        prevcoup = -1;
        jeux = pJeux;
        nbCoupDernierJeux =0;
    }

    public LinkedList<Integer> getJeux() {
        return jeux;
    }

    public int getNbjeux() {
        return nbjeux;
    }

    public void addCoup(int coup) throws IllegalAccessException, IllegalArgumentException {
        if(nbjeux < 10 && nbCoupDernierJeux < 3) {
            if (prevcoup == -1) {
                if (coup == 10) {
                    jeux.add(coup);
                    prevcoup = -1;
                    if(nbjeux < 9 || (nbjeux == 9 && nbCoupDernierJeux == 2))
                        nbjeux++;
                    else
                        nbCoupDernierJeux++;
                } else {
                    if(coup >= 0 && coup <10) {
                        jeux.add(coup);
                        prevcoup = coup;
                        if(nbjeux == 9 && nbCoupDernierJeux <2)
                            nbCoupDernierJeux++;
                        else if(nbjeux == 9 && nbCoupDernierJeux == 2){
                            nbjeux++;
                        }
                    }else{
                        throw new IllegalArgumentException("Le coup n'est pas valide");
                    }
                }
            } else {
                if ((coup + prevcoup) <= 10 && (coup + prevcoup) >= 0) {
                    if(coup >= 0 && coup <10) {
                        jeux.add(coup);

                        if(nbjeux < 9)
                            nbjeux++;
                        else{
                            if(coup+prevcoup == 10){

                                nbCoupDernierJeux++;
                            }else{
                                nbjeux++;
                            }
                        }
                       // System.out.println("jeux : "+nbjeux+"   valeur coup :"+(coup+prevcoup));

                        prevcoup = -1;
                    }else{
                        throw new IllegalArgumentException("Le coup n'est pas valide");
                    }
                }else{
                    throw new IllegalArgumentException("Le coup n'est pas valide");
                }
            }
        }else{
            throw new IllegalAccessException("La partie doit etre fini");
        }
    }

    public int calculScore() throws IllegalAccessException {
        int scoreFinal = 0;
        int scoreTemp = -1;

        if(nbjeux != 10){
            throw new IllegalAccessException("La partie doit etre finiE poiur calculer le score");
        }else{
            for(int i = 0;i<jeux.size();i++){
                int temp = jeux.get(i);
                if(scoreTemp == -1){
                    if(temp == 10){
                        if(i<jeux.size()-2){
                            temp += jeux.get(i+1) + jeux.get(i+2);
                            scoreFinal += temp;
                        }
                    }else{
                        scoreTemp = temp;
                    }
                }else{
                    scoreTemp += temp;
                    if(scoreTemp == 10){
                        if(i<jeux.size()-1){
                            scoreFinal += scoreTemp + jeux.get(i+1);
                        }
                    }else{
                        scoreFinal += scoreTemp;
                    }
                    scoreTemp =-1;
                }
            }
        }
        return scoreFinal;
    }





}
