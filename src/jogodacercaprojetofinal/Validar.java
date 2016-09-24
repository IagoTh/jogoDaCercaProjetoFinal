package jogodacercaprojetofinal;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Ronisson Santos
 */
public class Validar {
// médoto que lê os dados gravados no arquivo e verifica se é igual ao valor digitado retorna true caso encontre valore iguais e false se não encontrar
    public static boolean validarLogin(String login, String senha) {
        boolean validar = false;
        Cripto decriptar = new Cripto();
        try {
            FileReader caminho = new FileReader("usuarioCadastrado.txt");
            BufferedReader lerArq = new BufferedReader(caminho);

            while (lerArq.ready()) {
                String dados = lerArq.readLine();
                if ((dados.substring(0, dados.indexOf("|")).equals(login)) && ((decriptar.passUncript(dados.substring(dados.indexOf("|") + 1, dados.length())).equals(senha)))) {
                    validar = true;
                }
            }

        } catch (IOException erro) {

        }

        return validar;
    }

}
