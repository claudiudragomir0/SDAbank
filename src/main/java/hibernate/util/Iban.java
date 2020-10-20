package hibernate.util;

import java.util.Random;

public class Iban {

    public static Random rand = new Random();
    public static String card = "RO";

    public static String ibanGenerator(){
    for (int i = 0;i < 22;i++)
    {
        int n = rand.nextInt(10) + 0;
        card += Integer.toString(n);
    }
    for (int i = 0; i < 24; i++)
    {
        if(i % 4 == 0)
            System.out.print("");
        System.out.print(card.charAt(i));
    }
     return card;
}

}
