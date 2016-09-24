package jogodacercaprojetofinal;

/*Esta classe é a responsável por ler os dados do arquivo pontuação.txt colocar os dados dentro dos vetores ordena-los em ordem decrescente e 
salvá-los novemente incluindo os novos dados gerados*/
import java.io.*;
/**
*
*@author Ronisson Santos 
*
*/
public class EscreverDados{
	//inicio do método construtor passando como parâmetros as variáveis "a" e "b" 
	public EscreverDados(String a,int b,int c){
		//inicia as variáveis globais
		String[] nome=new String[10];int[] pontosInt=new int[10];int[] pontosJ2=new int[10];int i=0;
		String nomeJogador="",num="";
		//atribui o valor 0 a todas as posições do vetor pontosInt[]
		for(i=0;i<pontosInt.length;i++){
			pontosInt[i]=0;
		}i=0;
		//instância da classe File
		File arquivo = new File("recordes.txt");
		try{
			//condição que verifica se o arquivo 'pontuacao.txt' existe, se o arquivo não existir ele vai ser criado com o método createNewFile();
			if(!(arquivo.exists())){
				arquivo.createNewFile();
			}
			//instancias das classes FileReader e BufferedReader para ler o arquivo 'pontuação.txt' 
			FileReader lerDados = new FileReader("recordes.txt");
			BufferedReader lerBuffer = new BufferedReader(lerDados);
			String linha = lerBuffer.readLine();
				//loop que para no momento em que a variável linha tiver o valor nulo
				while(linha!=null){
					// A variável nomeJogador vai pegar o nome do jogador de cada linha e a variável num pega a pontuação
					nome[i]= linha.substring(0,linha.indexOf("|"));
					pontosInt[i] = Integer.parseInt(linha.substring(linha.indexOf("|")+1,linha.indexOf("X")));
					pontosJ2[i]=Integer.parseInt(linha.substring(linha.indexOf("X")+1,linha.length()));
					//oa vetores nome[i] pega os nomes que estiverem no arquivo e o pontosInt recebe os valores de num transformados em inteiros
					linha = lerBuffer.readLine();
					i++;
				}
			
    		//este for ordena os dados que foram recebidos do arquivo pelo vetor pontosInt[] em ordem decrescente
			for(i=0;i<pontosInt.length;i++){	
				for(int j=0;j<pontosInt.length;j++){
					if(pontosInt[i] > pontosInt[j]){
						int maior=pontosInt[i];pontosInt[i]=pontosInt[j];pontosInt[j]=maior;
						nomeJogador=nome[i];nome[i]=nome[j];nome[j]=nomeJogador; 
						int aux=pontosJ2[i];pontosJ2[i]=pontosJ2[j];pontosJ2[j]=aux;
					}
				}	
			}
			//este for inclui dentro do vetor nome[]o valor da variável  "a"  e pontosInt[] o valor da variável "b"  desde que b seja maior que algum valor do vetor pontosInt[]  
			for(i=0;i<pontosInt.length;i++){
				if( b > pontosInt[i]){
					int aux=pontosInt[i];pontosInt[i]=b;b=aux;
					String auxNome=nome[i];nome[i]=a;a=auxNome; 
					aux = pontosJ2[i];pontosJ2[i]=c;c=aux;
				}
			}i=0;
			//Esta classe escreve os dados no arquivo 
			FileWriter escDados = new FileWriter("recordes.txt");
			BufferedWriter escrever = new BufferedWriter(escDados);
			while(nome[i]!=null){
				//a variável dados recebe os valores dos vetores nome[] e pontosInt[] de forma concatenada
				String dados=nome[i]+"|"+pontosInt[i]+"X"+pontosJ2[i];		
				escrever.write(dados);
				escrever.newLine();
				i++;	
			}i=0;
			escrever.close();
		}catch(IOException err){
			
		}
	}
}