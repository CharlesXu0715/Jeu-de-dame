import java.util.Scanner;
public class Plateau {
	/*public int x;
	public int y;
	public int choix;
	public int choix2;*/
	private int[][] p;
	private boolean done;
	public Plateau(int n)
	{
		
		int[][] p=new int[12][12];
		this.p=p;
		this.done=done;
		
		for(int i=1;i<11;i++){  //pour le match normale
			for(int j=1;j<11;j++){
				if(j<=4&&(i+j)%2==0){	
					p[i][j]=1;
				}
			    else if(j>=7&&(i+j)%2==0){
					p[i][j]=2;
				}
				else {
					p[i][j]=0;
				}
			}
		}
	}
	     
	     /*for(int i=1;i<11;i++){  //pour la presentation
			for(int j=1;j<11;j++){
				p[i][j]=0;
			}
		}	     
	     p[2][2]=2;
	     p[7][9]=2;
	     p[10][6]=1;
	     p[10][8]=2;
	     p[3][3]=1;   
	   }*/
	
	
	public void avancer1(){
		done=false;
		int x,y,ligne,colonne;
		int f,m=0,n=0;
		boolean ok;
		do
		{
			ok=true;
			System.out.println( "numero de ligne dont le piece que vous voulez bouger ");
			Scanner sc=new Scanner(System.in);
			ligne=sc.nextInt();
			System.out.println( "numero de colonne dont le piece que vous voulez bouger ");
			colonne=sc.nextInt();
			x=ligne+1;
			y=colonne+1;
			//System.out.println(p[x][y]);
			if (p[x][y]!=1&&p[x][y]!=3)
			{
				ok=false;
			}
			else if (p[x][y]==1)
			{
				if ((p[x-1][y+1]==1||p[x-1][y+1]==3)&&(p[x+1][y+1]==1||p[x+1][y+1]==3))
				{
					ok=false;
				}
				if (recherche1(x,y,-1)==false||recherche1(x,y,1)==false)
				{
					for (int i=1;i<11;i++)
					{
						for (int j=1;j<11;j++)
						{
							if (p[i][j]==1&&(recherche1(i,j,-1)||recherche1(i,j,1))&&i!=x&&j!=y) ok=false;
						}
					}
				}
			}
			else
			{
				if ((p[x-1][y+1]==1||p[x-1][y+1]==3)&&(p[x+1][y+1]==1||p[x+1][y+1]==3)&&(p[x+1][y-1]==1||p[x+1][y-1]==3)&&(p[x-1][y-1]==1||p[x-1][y-1]==3))
				{
					ok=false;
				}
			}
			
		}
		while (ok==false);
		do
		{
			f=sauter1(p,x,y);
			if (f!=0)
			{
				dame(p);
			}
			switch (f){
			case 1:
				m=-1;
				n=1;
				break;
			case 2:
				m=1;
				n=1;
				break;
			case 3:
				m=-1;
				n=-1;
				break;
			case 4:
				m=1;
				n=-1;
				break;
			}
			x=x+m*2;
			y=y+n*2;
			//System.out.println(f);
		}
		while (f!=0);
        if (done==false)
        {
			avancera1(p,x,y);
			dame(p);
		}
        dame(p);
        
	}
	
	public void avancer2(){
		done=false;
		int x,y,ligne,colonne;
		int f,m=0,n=0;
		boolean ok;
		do
		{
			ok=true;
			System.out.println( "numero de ligne dont le piece que vous voulez bouger ");
			Scanner sc=new Scanner(System.in);
			ligne=sc.nextInt();
			System.out.println( "numero de colonne dont le piece que vous voulez bouger ");
			colonne=sc.nextInt();
			x=ligne+1;
			y=colonne+1;
			//System.out.println(p[x][y]);
			if (p[x][y]!=2&&p[x][y]!=4)
			{
				ok=false;
			}
			else if (p[x][y]==2)
			{
				if ((p[x-1][y-1]==2||p[x-1][y-1]==4)&&(p[x+1][y-1]==2||p[x+1][y-1]==4))
				{
					ok=false;
				}
				//System.out.println(ok);
				if (recherche2(x,y,-1)==false||recherche2(x,y,1)==false)
				{
					for (int i=1;i<11;i++)
					{
						for (int j=1;j<11;j++)
						{
							if (p[i][j]==2&&(recherche2(i,j,-1)||recherche2(i,j,1))&&i!=x&&j!=y)
							{
								ok=false;
								//System.out.println(i+" "+j);
							}
						}
					}
				}
				//System.out.println(ok);
			}
			else
			{
				if ((p[x-1][y+1]==2||p[x-1][y+1]==4)&&(p[x+1][y+1]==2||p[x+1][y+1]==4)&&(p[x+1][y-1]==2||p[x+1][y-1]==4)&&(p[x-1][y-1]==2||p[x-1][y-1]==4))
				{
					ok=false;
				}
			}
		}
		while (ok==false);
		do
		{
			f=sauter2(p,x,y);
			if (f!=0)
			{
				dame(p);
			}
			switch (f){
			case 1:
				m=-1;
				n=1;
				break;
			case 2:
				m=1;
				n=1;
				break;
			case 3:
				m=-1;
				n=-1;
				break;
			case 4:
				m=1;
				n=-1;
				break;
			}
			x=x+m*2;
			y=y+n*2;
			//System.out.println(f);
		}
		while (f!=0);
        if (done==false)
        {
			avancera2(p,x,y);
			dame(p);
		}
        dame(p);
        
	}  
		public int sauter1(int p[][],int x,int y){
			Scanner sc=new Scanner(System.in);
			boolean up,down;
			//boolean fait=false;
			int sens=0;
			if(p[x][y]!=3){
				up=recherche1(x,y,-1);
				down=recherche1(x,y,1);
				if (up==false&&down)
				{
					p[x+1][y+1]=0;
					p[x+2][y+2]=1;
					p[x][y]=0;
					x=x+2;
					y=y+2;
					done=true;
					//fait=true;
					sens=2;
					//System.out.println(111);
				}
				else if (down==false&&up)
				{
					p[x-1][y+1]=0;
					p[x-2][y+2]=1;
					p[x][y]=0;
					x=x-2;
					y=y+2;
					done=true;
					//fait=true;
					sens=1;
					//System.out.println(222);
				}
				else if (up&&down)
				{
					System.out.println("Si vous voulez bouger en bas importez 1;si en haut importez 2");
					int choix=sc.nextInt();
					if(choix==1){
						p[x+1][y+1]=0;
						p[x+2][y+2]=p[x][y];
						x=x+2;
						y=y+2;
						sens=2;
					}
					else{
						p[x-1][y+1]=0;
						p[x-2][y+2]=p[x][y];
						x=x-2;
						y=y+2;
						sens=1;
					}
					done=true;
					//fait=true;
				}
			}
			/*if (done)
			{
				sauter1(p,x,y);
				//return true;
			}
			else
			{
				return;
			}*/
			return sens;
		}
	
		public void avancera1(int[][]p,int x,int y){
			Scanner sc=new Scanner(System.in);
			if(p[x][y]==1){
				/*if(p[x+1][y+1]==0){
					if(p[x-1][y+1]==0){
						System.out.println("Si vous voulez bouger en bas importez 1;si en haut imprimez 2");
						int choix2=sc.nextInt();
						if(choix2==1){
							p[x+1][y+1]=p[x][y];
							//System.out.println(p[x][y]);
							
						}
						else
						{
							p[x-1][y+1]=p[x][y];
						}
					}
					else if(p[x-1][y+1]!=0){
						p[x+1][y+1]=p[x][y];
					}
				}
				else if(p[x-1][y+1]==0 && p[x+1][y+1]!=0){
					p[x-1][y+1]=p[x][y];
				}*/
				if (x==1)
				{
					p[x+1][y+1]=1;
				}
				else if (x==10)
				{
					p[x-1][y+1]=1;
				}
				else
				{
					if (p[x+1][y+1]==0&&p[x-1][y+1]==0)
					{
						System.out.println("Si vous voulez bouger en bas importez 1;si en haut importez 2");
						int choix2=sc.nextInt();
						if(choix2==1){
							p[x+1][y+1]=p[x][y];
							//System.out.println(p[x][y]);	
						}
						else
						{
							p[x-1][y+1]=p[x][y];
						}
					}
					else if (p[x+1][y+1]!=0&&p[x-1][y+1]==0)
					{
						p[x-1][y+1]=1;
					}
					else if (p[x+1][y+1]==0&&p[x-1][y+1]!=0)
					{
						p[x+1][y+1]=1;
					}
				}
			p[x][y]=0;
			}
			else
			{
				damea(x,y);
			}
		}
		public void dame(int[][]p){
		   for(int q=1;q<11;q++){
			   if(p[q][10]==1){
				   p[q][10]=3;
				}
				if(p[q][1]==2){
					p[q][1]=4;
				}
			}
		}
		public int sauter2(int p[][],int x,int y)
		{
			Scanner sc=new Scanner(System.in);
			boolean up,down;
			//boolean fait=false;
			int sens=0;
			if(p[x][y]!=4){
				up=recherche2(x,y,-1);
				down=recherche2(x,y,1);
				if (up==false&&down)
				{
					p[x+1][y-1]=0;
					p[x+2][y-2]=2;
					p[x][y]=0;
					x=x+2;
					y=y-2;
					done=true;
					sens=4;
					//fait=true;
				}
				else if (down==false&&up)
				{
					p[x-1][y-1]=0;
					p[x-2][y-2]=2;
					p[x][y]=0;
					x=x-2;
					y=y-2;
					done=true;
					//fait=true;
					sens=3;
				}
				else if (up&&down)
				{
					System.out.println("Si vous voulez bouger en bas importez 1;si en haut importez 2");
					int choix=sc.nextInt();
					if(choix==1){
						p[x+1][y-1]=0;
						p[x+2][y-2]=p[x][y];
						x=x+2;
						y=y-2;
						sens=4;
					}
					else{
						p[x-1][y-1]=0;
						p[x-2][y-2]=p[x][y];
						x=x-2;
						y=y-2;
						sens=3;
					}
					done=true;
					//fait=true;
				}
			}
			/*if (done)
			{
				sauter2(p,x,y);
				//return true;
			}
			else
			{
				return;
			}*/
			return sens;
		}
		
		public void avancera2(int[][]p,int x,int y){
		Scanner sc=new Scanner(System.in);
		if(p[x][y]!=3&&p[x][y]!=4){
			/*if(p[x+1][y-1]==0){
				if(p[x-1][y-1]==0){
					System.out.println("Si vous voulez bouger en bas importez 1;si en haut importez 2");
					int choix2=sc.nextInt();
					if(choix2==1){
						p[x+1][y-1]=p[x][y];
					}
					else {
						p[x-1][y-1]=p[x][y];
					}
				}
				else if(p[x-1][y-1]!=0){
					p[x+1][y-1]=p[x][y];
				}
			}
			else if(p[x-1][y-1]==0 && p[x+1][y-1]!=0){
				p[x-1][y-1]=p[x][y];
			}*/
			if (x==1)
				{
					p[x+1][y-1]=2;
				}
			else if (x==10)
				{
					p[x-1][y-1]=2;
				}
			else
				{
					if (p[x+1][y-1]==0&&p[x-1][y-1]==0)
					{
						System.out.println("Si vous voulez bouger en bas importez 1;si en haut importez 2");
						int choix2=sc.nextInt();
						if(choix2==1){
							p[x+1][y-1]=p[x][y];
							//System.out.println(p[x][y]);
						}
						else
						{
							p[x-1][y-1]=p[x][y];
						}
					}
					else if (p[x+1][y-1]!=0&&p[x-1][y-1]==0)
					{
						p[x-1][y-1]=2;
					}
					else if (p[x+1][y-1]==0&&p[x-1][y-1]!=0)
					{
						p[x+1][y-1]=2;
					}
				}
		p[x][y]=0;
	    }
	    else
		{
				damea(x,y);
		}
	}
	public void Affichage(){
		afficheplateau.afficherplateau(p);
	}
	
	public boolean gagne(){
		return gagner.gagne(p);
	}
	
	public boolean recherche1(int x,int y,int f){
		if (f==-1&&x<=2||f==1&&x>=9||y>=9)
		{
			return false;
		}
		else
		{
			if (p[x+f][y+1]==2&&p[x+f*2][y+2]==0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	
	public boolean recherche2(int x,int y,int f){
		if (f==-1&&x<=2||f==1&&x>=9||y<=2)
		{
			return false;
		}
		else
		{
			if (p[x+f][y-1]==1&&p[x+f*2][y-2]==0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public int recherched(int x,int y,int f){
		int a=0;
		int m=0,n=0;
		boolean ok=true;
		switch (f){
		case 1:
			m=-1;
			n=1;
			break;
		case 2:
			m=1;
			n=1;
			break;
		case 3:
			m=-1;
			n=-1;
			break;
		case 4:
			m=1;
			n=-1;
			break;
		}
		do
		{
			a++;
			//System.out.println((x+a*m)+"-"+(y+a*n));
			if ((x+a*m)>10||(x+a*m)<1||(y+a*n)>10||(y+a*n)<1)
			{
				ok=false;
				//System.out.println(ok);
			} 
			else if (p[x+a*m][y+a*n]!=0)
			{
				ok=false;
				//System.out.println(ok);
			}
		}
		while (ok);
		a--;
		return a;
	}
	
	/*public void dame1(int[][]p,int x,int y){
		Scanner sc=new Scanner(System.in);
		if(p[x][y]==3){
			System.out.println("Si vous voulez bouger en bas imprimez1;si en haut imprimez 2");
			int choix2=sc.nextInt();
			if(choix2==1){
				System.out.println("Si vous voulez bouger en gauche imprimez1;si en droit imprimez 2");
				int choix3=sc.nextInt();
				if(choix3==1){
				System.out.println("Combien de allure vous voulez bouger,imprimez");
				int n=sc.nextInt();
				p[x+n][y-n]=3;
				p[x][y]=0;
				}
				if(choix3==2){
				System.out.println("Combien de allure vous voulez bouger,imprimez");
				int n=sc.nextInt();
				p[x+n][y+n]=3;
				p[x][y]=0;
				}
			}
			if(choix2==2){
				  System.out.println("Si vous voulez bouger en gauche imprimez1;si en droit imprimez 2");
				  int choix3=sc.nextInt();
				  if(choix3==1){
					  System.out.println("Combien de allure vous voulez bouger,imprimez");
					  int n=sc.nextInt();
					  p[x-n][y-n]=3;
					  p[x][y]=0;
				  }
				if(choix3==2){
				  System.out.println("Combien de allure vous voulez bouger,imprimez");
				  int n=sc.nextInt();
				  p[x-n][y+n]=3;
				  p[x][y]=0;
				}
			}
	    }
	}
	public void dame2(int[][]p,int x,int y){
		  Scanner sc=new Scanner(System.in);
		  if(p[x][y]==4){
		  System.out.println("Si vous voulez bouger en bas imprimez1;si en haut imprimez 2");
		  int choix2=sc.nextInt();
		  if(choix2==1){
			  System.out.println("Si vous voulez bouger en gauche imprimez1;si en droit imprimez 2");
		      int choix3=sc.nextInt();
		      if(choix3==1){
			  System.out.println("Combien de allure vous voulez bouger,imprimez");
			  int n=sc.nextInt();
			  p[x+n][y-n]=3;
			  p[x][y]=0;
		  }
	          if(choix3==2){
			  System.out.println("Combien de allure vous voulez bouger,imprimez");
			  int n=sc.nextInt();
			  p[x+n][y+n]=3;
			  p[x][y]=0;
		  }
		 }
		  if(choix2==2){
			  System.out.println("Si vous voulez bouger en gauche imprimez1;si en droit imprimez 2");
		      int choix3=sc.nextInt();
		      if(choix3==1){
			  System.out.println("Combien de allure vous voulez bouger,imprimez");
			  int n=sc.nextInt();
			  p[x-n][y-n]=3;
			  p[x][y]=0;
		  }
	          if(choix3==2){
			  System.out.println("Combien de allure vous voulez bouger,imprimez");
			  int n=sc.nextInt();
			  p[x-n][y+n]=3;
			  p[x][y]=0;
		  }
		 }
	    }
	}*/
	public void damea(int x,int y)
	{
		Scanner sc=new Scanner(System.in);
		int[] bushu=new int [5];
		int m=0,n=0,k=0;
		//boolean ok=true;
		for (int i=1;i<=4;i++)
		{
			bushu[i]=recherched(x,y,i);
			//System.out.println(bushu[i]);
		}
		System.out.println("Choisir la direction que vous voulez bouger:");
		if (bushu[1]!=0||(p[x][y]+p[x-1][y+1])%2!=0)
		{
			System.out.println("1:en haut&a droit");
		}
		if (bushu[2]!=0||(p[x][y]+p[x+1][y+1])%2!=0)
		{
			System.out.println("2:en bas&a droit");
		}
		if (bushu[3]!=0||(p[x][y]+p[x-1][y-1])%2!=0)
		{
			System.out.println("3:en haut&a gauche");
		}
		if (bushu[4]!=0||(p[x][y]+p[x+1][y-1])%2!=0)
		{
			System.out.println("4:en bas&a gauche");
		}
		int choixd=sc.nextInt();
		switch (choixd){
		case 1:
			m=-1;
			n=1;
			break;
		case 2:
			m=1;
			n=1;
			break;
		case 3:
			m=-1;
			n=-1;
			break;
		case 4:
			m=1;
			n=-1;
			break;
		}
		do
		{
			System.out.println("Combien de allure vous voulez bouger,importez");
			k=sc.nextInt();
			/*if (k>bushu[choixd]+1)
			{
				ok=false;
			}
			if (k=bushu[choixd]+1)
			{
				if (p[x][y]==3)
				{
					if (p[x+k*m][y+k*n]==1||p[x+k*m][y+k*n]==3)
					{
						ok=false;
					}
				}
				else
				{
					if (p[x+k*m][y+k*n]==2||p[x+k*m][y+k*n]==4)
					{
						ok=false;
					}
				}
			}*/
		}
		while (k>bushu[choixd]);
		p[x+k*m][y+k*n]=p[x][y];
		if (p[x+(k+1)*m][y+(k+1)*n]!=0&&(p[x+(k+1)*m][y+(k+1)*n]+p[x][y])%2!=0&&p[x+(k+2)*m][y+(k+2)*n]==0)
		{
			System.out.println("Si vous voulez sauter importez 1;si non importez 2");
			int choixs=sc.nextInt();
			if (choixs==1)
			{
				p[x+k*m][y+k*n]=0;
				p[x+(k+1)*m][y+(k+1)*n]=0;
				p[x+(k+2)*m][y+(k+2)*n]=p[x][y];
			}
		}
		
		p[x][y]=0;
	}
}

  
			
			
