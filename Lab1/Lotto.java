import java.util.Random;

public class Lotto { 
	public static void main(String[] args) { 
	    Random rand = new Random();
        int tab[] = new int[6];
        for (int i = 0; i < 6; i++)
        {
            tab[i] = rand.nextInt(49) + 1;
        }
        for (int i = 0; i < 6; i++)
            System.out.print(tab[i]+" "); 
	} 
} 