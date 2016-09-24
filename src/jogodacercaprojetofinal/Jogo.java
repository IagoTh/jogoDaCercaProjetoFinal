package jogodacercaprojetofinal;
import java.util.Scanner;
/**
 *
 * @author Ronisson Santos
 */
public class Jogo{
    public Jogo(String jogador_1,String jogador_2) {
		Scanner scanner = new Scanner(System.in);
        int lin=0,col=0;
        char[] alfaminus ={'a',' ','b',' ','c',' ','d',' ','e',' ','f',' ','g',' ','h',' ','i',' ','j',' ','k',' ','l',' ','m',' ','n',' ','o',' ','p',' ','q',' ','r',' ','s',' ','t',' ','u',' ','v',' ','x',' ','w',' ','y',' ','z'};
        char[] alfamajor ={'A',' ','B',' ','C',' ','D',' ','E',' ','F',' ','G',' ','H',' ','I',' ','J',' ','K',' ','L',' ','M',' ','N',' ','O',' ','P',' ','Q',' ','R',' ','S',' ','T',' ','U',' ','V',' ','X',' ','W',' ','Y',' ','Z'};
        char[] numeric   ={'0',' ','1',' ','2',' ','3',' ','4',' ','5',' ','6',' ','7',' ','8',' ','9'};
		String jogar=" ";int x=0,y=0;boolean verificar=false;boolean l=true ,c=true;
		do{
			if(l){
			System.out.println(jogador_1+" Informe a quantidade de linhas entre 2 x 10: ");
				x=scanner.nextInt();
			}
			if(c){
				System.out.println(jogador_1+" Informe a quantidade de colunas entre 2 x 26");
				y=scanner.nextInt();
			}
			if(((x<2)||(x>10))||((y<2)||(y>26))){
				if((x<2)||(x>10)){	
					l=true;
				}else{
					l=false;
				}
				if((y<2)||(y>26)){
					c=true;
				}else{
					c=false;
				}
				verificar=true;
			}else{
				verificar=false;
			}
		}while(verificar);
        x=(x*2)-1;
        y=(y*2)-1;
		char matriz[][]= new char[x+1][y+1];int jogador=1;int pontuacao_jogador_1=0,pontuacao_jogador_2=0,outra_jogada=0;int finalizar=0;boolean marcador=false;int i=0;int j=0;
		//variáveis que serão usadas para definir índices
		int vXA=0,vXB=0,vX=0,vY=0,vYA=0,vYB=0;
		for(i=0;i<x;i++){
			for(j=0;j<y;j++){
				if((i%2==0)&&(j%2==0)){
					matriz[i][j] = '*';
				}else{
					matriz[i][j] = ' ';
				}
				if((i%2>0)&&(j%2>0)){
					matriz[i][j] = ' ';
				}
				
			}
				
		}
		do{	
			finalizar=0;
			System.out.print("    ");
			for(j=0;j<y;j+=2){
                if(j<(y-2)){
					System.out.print(alfamajor[j]+"-----");  
			    }else{
				    System.out.print(alfamajor[j]);   
			    }
            }
		    System.out.println("\n");
            for(i=0;i<x;i++){
                if(i%2==0){
                    
                    if(lin<10){
                        System.out.print(lin + " ");
                    }else{
                        System.out.print(lin);
                    }
					lin++;
                }else{
                    System.out.print("  ");
                }

                for(j=0;j<y;j++){
					System.out.print("  " + matriz[i][j]);
					if(matriz[i][j]==' '){
						finalizar++;
					}
				}
                System.out.print("\n\n");

            }
		    for(j=0;j<y;j++){
                System.out.print("---");
            }
			System.out.print("--\n");
			do{
				boolean v= false;
				
				if(finalizar >0){
					do{
						if((v)||(verificar)){
							System.out.print(" Jogue da forma correta ");v=false;
						}
						
							if(jogador==1){
								System.out.print(" "+jogador_1+": ");
								jogar=scanner.next();marcador=false;
							}else{
								System.out.print(" "+jogador_2+": ");
								jogar=scanner.next();marcador=false;
							}
							
							if((jogar.length()<3)||(jogar.length()>3)||(v)){
								v=true;
							}
						
					}while(v);
					if((jogar!=" ")&&(jogar.length()==3)){
						for(i=0;i<x;i+=2){
							if(jogar.charAt(0)==numeric[i]){
								vXA=i;
							}
						}
						for(i=0;i<x;i+=2){	
							if(jogar.charAt(2)==numeric[i]){
								vXB=i;
							}
						}
						for(i=0;i<y;i+=2){
							if((jogar.charAt(1)==alfaminus[i])||(jogar.charAt(1)==alfamajor[i])){
								vYA=i;
							}
						}
						for(i=0;i<y;i+=2){
							if((jogar.charAt(2)==alfaminus[i])||(jogar.charAt(2)==alfamajor[i])){
								vYB=i;
							}
						}
						for(i=0;i<y;i++){
							if((jogar.charAt(2)==alfaminus[i])||(jogar.charAt(2)==alfamajor[i])){
								if(vYA+1==vYB-1){
									vX=vXA;	
									vY=vYA+1;
									verificar=false;
								}else{
									verificar=true;	
								}
							}else{
								if(i<x){
									if(jogar.charAt(2)==numeric[i]){
										if((vXA+1)==(vXB-1)){
											vX=vXA+1;
											vY=vYA;
											verificar=false;
										}else{
											verificar=true;
										}
									}
								}	
							}
						}
					}
					if(matriz[vX][vY]==' '){
						matriz[vX][vY]='.';
					}else{
						if((matriz[vX][vY]=='.') && !(verificar)){
							System.out.print(" Este campo ja foi jogado jogue em outro ");
							marcador=true;
						}
					}	
				}
			}while(((verificar)||(marcador)));
			for(i=0;i<x;i++){
				for(j=0;j<y;j++){
					if((i%2>0)&&(j%2>0)){
						if(matriz[i][j]==' '){
							if((matriz[i-1][j]=='.')&&(matriz[i+1][j]=='.')&&(matriz[i][j-1]=='.')&&(matriz[i][j+1]=='.')){
								if(jogador==1){
									pontuacao_jogador_1 = pontuacao_jogador_1 + 1;	
									matriz[i][j]='1';
									outra_jogada = 2;
								}else{
									pontuacao_jogador_2 = pontuacao_jogador_2 + 1;	
									matriz[i][j]='2';
									outra_jogada = 2;
								}
							
							}
						
						}
						
					}
				
				}
			
			}
		    if(jogador==1){
				jogador=2;
				if(outra_jogada==2){
					jogador=1;
					outra_jogada=0;
				}
			}else{
				jogador=1;
				if(outra_jogada==2){
					jogador=2;
					outra_jogada=0;
				}
			}
		lin=0;col =0;
        }while(finalizar != 0);
		if(pontuacao_jogador_1 > pontuacao_jogador_2){
			System.out.println(" Vitoria do Jogador "+jogador_1+" por "+pontuacao_jogador_1+"X"+pontuacao_jogador_2);
			//instancia da classe "EscreverDados" que recebe como parâmetros o nome e a pontuação do jogador_1 se ele for o vencedor
			EscreverDados escDados =new EscreverDados(jogador_1,pontuacao_jogador_1,pontuacao_jogador_2);
		}
		if(pontuacao_jogador_1 < pontuacao_jogador_2){
			System.out.println(" Vitoria do Jogador "+jogador_2+" por "+pontuacao_jogador_2+"X"+pontuacao_jogador_1);
			//instancia da classe "EscreverDados" que recebe como parâmetros o nome e a pontuação do jogador_2 se ele for o vencedor
			EscreverDados  escDados = new EscreverDados(jogador_2,pontuacao_jogador_2,pontuacao_jogador_1);
		}
			//caso haja empate!
		if(pontuacao_jogador_1 == pontuacao_jogador_2){
			System.out.println(" Jogo empatado em "+pontuacao_jogador_1+"X"+pontuacao_jogador_2);
		}
    }
}