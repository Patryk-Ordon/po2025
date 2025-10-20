public class Choinka { 
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		for (int i=0; i<=n; i++)
		{
			int k = i;
			int q = n - k;
			for(int j=q; j>0; j--)
			{
 				System.out.print(" ");
			}		
			for(int j=0; j<(k-1)*2+1; j++)
			{
 				System.out.print("*");
			}
			System.out.println();
		}
	} 
} 