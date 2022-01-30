public class marcher {
	
	public static void main (String[] args) {
	Plateau pan = new Plateau(10);
	boolean over=false;
		//int [][]p=new int[10][10];
		/*for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(j<=1&&(i+j)%2==0){	
					p[i][j]=1;
				}
			    else if(j>=8&&(i+j)%2==0){
					p[i][j]=2;
				}
				else {
					p[i][j]=0;
				}
			}
		}*/
    pan.Affichage();
    do
	{
		pan.avancer1();
		pan.Affichage();
		over=pan.gagne();
		if (over==false)
		{
			pan.avancer2();
			pan.Affichage();
			over=pan.gagne();
		}
	}
	while (over==false);
	}
}
