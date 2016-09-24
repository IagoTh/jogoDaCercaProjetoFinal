package jogodacercaprojetofinal;

/**
 *
 * @author Lucas Menchonhe
 */
public class Cripto {
    // método para criptografar senha
    String passEncript(String senha) {
        int i, j;
        String encript;

        char[] arrayPass = senha.toCharArray(); //transforma a string em um array de char
        i = arrayPass.length; //salvo o numero de caracteres que a palavra contém para poder criar a matriz codificada
        char result[] = new char[i]; //matriz que receberá o codigo encriptado
        //para evitar estruturas condicionais desnecessárias adicionei três caracteres ao fim de cada array, ou seja, minha sequencia de saltos é de 3 caracteres
        char alfaminus[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'w', 'y', 'z', 'a', 'b', 'c'};
        char alfamajor[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'W', 'Y', 'Z', 'A', 'B', 'C'};
        char numeric[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2'};

        //verificação e substituição de caracteres alfabéticos
        for (i = 0; i < arrayPass.length; i++) {
            for (j = 0; j < 26; j++) {
                if (alfaminus[j] == arrayPass[i]) {
                    result[i] = alfaminus[j + 3];
                } else if (alfamajor[j] == arrayPass[i]) {
                    result[i] = alfamajor[j + 3];
                }

            }
        }

        //verificação e substituição de caracteres numéricos
        for (i = 0; i < arrayPass.length; i++) {
            for (j = 0; j < 10; j++) {
                if (arrayPass[i] == numeric[j]) {
                    result[i] = numeric[j + 3];
                }
            }
        }
        //transformando vetor em String
        encript = new String(result);

        return encript;
    }
//=====================================================================================================================//
    // método para descriptogrfar senha
    String passUncript(String encript){
        String uncript;
        int i,j;
        
        
        char[] arrayPass = encript.toCharArray(); //transforma a string em um array de char
        i = arrayPass.length; //salvo o numero de caracteres que a palavra contém para poder criar a matriz descodificada
        char result[] = new char[i]; //matriz que receberá o codigo desencriptado
        //para evitar estruturas condicionais desnecessárias adicionei três caracteres ao fim de cada array, ou seja, minha sequencia de saltos é de 3 caracteres
        char alfaminus[] = {'c' ,'b' ,'a' ,'z' ,'y' ,'w' ,'x' ,'v' ,'u' ,'t' ,'s' ,'r' ,'q' ,'p' ,'o' ,'n' ,'m' ,'l' ,'k' ,'j' ,'i' ,'h' ,'g' ,'f' ,'e' ,'d' ,'c' ,'b' ,'a'};
        char alfamajor[] = {'C' ,'B' ,'A' ,'Z' ,'Y' ,'W' ,'X' ,'V' ,'U' ,'T' ,'S' ,'R' ,'Q' ,'P' ,'O' ,'N' ,'M' ,'L' ,'K' ,'J' ,'I' ,'H' ,'G' ,'F' ,'E' ,'D' ,'C' ,'B' ,'A'};
        char numeric[] = {'2' ,'1' ,'0' ,'9' ,'8' ,'7' ,'6' ,'5' ,'4' ,'3' ,'2' ,'1' ,'0'};
       
        //verificação e substituição de caracteres alfabéticos
        for (i = 0; i < arrayPass.length; i++) {
            for (j = 0; j < 26; j++) {
                if (alfaminus[j] == arrayPass[i]) {
                    result[i] = alfaminus[j + 3];
                } else if (alfamajor[j] == arrayPass[i]) {
                    result[i] = alfamajor[j + 3];
                }

            }
        }

        //verificação e substituição de caracteres numéricos
        for (i = 0; i < arrayPass.length; i++) {
            for (j = 0; j < 10; j++) {
                if (arrayPass[i] == numeric[j]) {
                    result[i] = numeric[j + 3];
                }
            }
        }
        uncript = new String(result);
        return uncript;
    }
}
