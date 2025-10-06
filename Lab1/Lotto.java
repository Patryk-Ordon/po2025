import java.util.Random;
import java.util.HashSet;

public class Lotto { 
	public static void main(String[] args) { 
	    Random rand = new Random();
        HashSet<Integer> tab = new HashSet<Integer>();
        while(tab.size() < 6)
        {
            tab.add(rand.nextInt(49) + 1);
        }
        System.out.print(tab);
    }
} 