import java.util.Random;
import java.util.ArrayList;

public class Lotto { 
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
        System.out.print(tab);
    }
} 