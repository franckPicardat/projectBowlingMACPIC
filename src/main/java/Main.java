/**
 * Created by 21502947 on 09/03/2016.
 */
public class Main {


    public static void main(String[] args) {
        Bowling bowling = new Bowling();

        for(int i = 0; i<20;i+=2){
            try {
                bowling.addCoup(9);
                bowling.addCoup(0);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println(bowling.calculScore());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
