public class afficheplateau {
	public static void afficherplateau(int [][]p){
		System.out.println();
		System.out.print("   ");
		
		for(int m=0;m<10;m++)
		{
				System.out.print((m)+" ");
		}
		System.out.println();
		for(int m=0;m<10;m++){
			System.out.print(" "+(m)+" ");
			for(int n=0;n<10;n++){
				if (p[m+1][n+1]==1)
				{
					System.out.print('^');
				}
				else if (p[m+1][n+1]==2)
				{
					System.out.print('-');
				}
				else if (p[m+1][n+1]==3)
				{
					System.out.print('*');
				}
				else if (p[m+1][n+1]==4)
				{
					System.out.print('+');
				}
				else
				{
					System.out.print(' ');
				}
				System.out.print(' ');
				/*
				System.out.print(p[m][n]);
				System.out.print(' ');*/
			}
	    System.out.println();		
	}
}
}
