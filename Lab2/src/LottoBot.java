import java.util.ArrayList;
import java.util.Random;

public class LottoBot {
	public static void main(String[] args) { 
	    Random rand = new Random();
        ArrayList<Integer> tab = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            int n = rand.nextInt(49) + 1;
            while (tab.contains(n)) {
                n = rand.nextInt(49) + 1;
            }
            tab.add(n);
        }

        ArrayList<Integer> botTypy = new ArrayList<>();
        int counter = 0;
        double time = System.currentTimeMillis();
        while(botTypy.size() != 6) {
            counter++;
            botTypy =  new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                int n = rand.nextInt(49) + 1;
                while (botTypy.contains(n)) {
                    n = rand.nextInt(49) + 1;
                }
                botTypy.add(n);
            }
            botTypy.retainAll(tab);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Liczba losowań potrzebnych do pełnego trafienia: " + counter);
        System.out.println("Łączny czas działania programu: " + time/1000 + "s");
    }
} 