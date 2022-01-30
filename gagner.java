public class gagner {
	
	public static boolean gagne(int [][]p){
		//boolean g = true;
		boolean j1=true;     //perdu
		boolean j2=true;
		int c1=0,c2=0;     //pion
		int d1=0,d2=0;		//dame
		for(int x=1;x<11;x++){
			for(int y=1;y<11;y++){
				if (p[x][y]==1||p[x][y]==3)
				{
					j1=false;
					c1++;
				}
				if (p[x][y]==3) d1++;
			}
		}
		for(int x=1;x<11;x++){
			for(int y=1;y<11;y++){
				if (p[x][y]==2||p[x][y]==4)
				{
					j2=false;
					c2++;
				}
				if (p[x][y]==4) d2++;
			}
		}
		/*for(int x=0;x<10;x++){
			for(int y=0;y<10;y++){
			  if (p[x][y]!=2&&p[x][y]!=4){				 
				  System.out.println("joueur 1 gagne");
				  g=true;
			  }
			  if (p[x][y]!=1&&p[x][y]!=3){
				  System.out.println("joueur 2 gagne");
				   g=true;
			  }
			  if(p[x][y]!=3){
				 for(int z=0;z<10;z++){
		          for(int c=0;c<10;c++){ 
				       if(p[x][y]+p[z][c]==3){ 
						   System.out.println("match nul");
						    g=true;
					   }
				   }
			  }
		   }
		}*/
		
		if (j2&&j1==false)
		{
			System.out.println("joueur 1 gagne");
		}
		if (j1&&j2==false)
		{
			System.out.println("joueur 2 gagne");
		}
		if (j1==false&&j2==false)
		{
			if (c1==d1&&c2==d2)
			{
				System.out.println("match nul");
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
}
