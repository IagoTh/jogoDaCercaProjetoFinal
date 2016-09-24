package jogodacercaprojetofinal;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 *
 * @author Ronisson Santos
 */
public class SalvarUsuario {

    String[] ArraysDados;

    /**
     * @param novoLogin;
     * @param novaSenha;
     */
    
    //método para salvar usuario em arquivo e consolidar o cadastro 
    public void arquivarLogin(String novoLogin, String novaSenha) {
        File arquivo = new File("usuarioCadastrado.txt");

        try {

            if (!(arquivo.exists())) {
                arquivo.createNewFile();
            }
            FileReader caminho = new FileReader("usuarioCadastrado.txt");
            BufferedReader lerArq = new BufferedReader(caminho);

            int cont = 1;
            String ler = lerArq.readLine();
            while ((lerArq.ready())){

                ler = lerArq.readLine();
                cont++;
            } 
            FileReader caminho1 = new FileReader("usuarioCadastrado.txt");
            BufferedReader lerArq1 = new BufferedReader(caminho1);
            ArraysDados = new String[cont+1];
           
            int j = 0;
            String dados = lerArq1.readLine();
            while (dados != null) {

                String login = dados.substring(0, dados.indexOf("|"));
                String senha = dados.substring(dados.indexOf("|") + 1, dados.length());
                ArraysDados[j] = login + "|" + senha;
                dados = lerArq1.readLine();
                j++;

            }

            for (int i = 0; i < ArraysDados.length; i++) {
                
                if (ArraysDados[i] == null) {
                    
                    ArraysDados[i] =""+ novoLogin + "|" + novaSenha;
                }
            }

            FileWriter writer = new FileWriter("usuarioCadastrado.txt");
            BufferedWriter escrever = new BufferedWriter(writer);
            for (int i = 0; i < ArraysDados.length; i++) {

                escrever.write(ArraysDados[i]);
                escrever.newLine();

            }

            escrever.close();
        } catch (IOException erro) {

        }

    }
}
