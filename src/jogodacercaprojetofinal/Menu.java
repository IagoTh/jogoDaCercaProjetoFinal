package jogodacercaprojetofinal;

import java.io.Console;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Iago Thiago
 */
public class Menu {

    public String jogador1;
    public String jogador2;
    public String senhaj1;
    public String senhaj2;
    public String senhaverij1;
    public String senhaverij2;
    public Cripto criptografar;
    public SalvarUsuario salvar;
    Console console = System.console();

    static Scanner entrada = new Scanner(System.in);

    // método que implementa o menu do jogo
    public void menu() throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException {

        criptografar = new Cripto();
        salvar = new SalvarUsuario();

        int comando;
        do {
            System.out.println("          Jogo da Velha v2.0");
            System.out.println("===================================");
            System.out.println("          [1]Cadastro");
            System.out.println("          [2]Login");
            System.out.println("          [0]Sair");
            System.out.println("===================================");
            comando = entrada.nextInt();
            switch (comando) {
                case 1:
                    System.out.println("=================================================================================");
                    System.out.println("                                  CADASTRO  ");
                    System.out.println("=================================================================================");
                    System.out.println("Player1:");
                    jogador1 = entrada.next();
                    System.out.println("Senha:");
                    senhaj1 = entrada.next();
                    System.out.println("Confirmar senha:");
                    senhaverij1 = entrada.next();
                    if (!(senhaj1.equals(senhaverij1))) {
                        do {
                            System.out.println("Senha diferentes,redigite sua senha:");
                            senhaj1 = entrada.next();

                        } while (senhaj1.equals(senhaverij1));

                    }
                    // chamando o método passEncript para concluir a critografia
                    String senhaCriptografadaJ1 = criptografar.passEncript(senhaj1);
                    salvar.arquivarLogin(jogador1, senhaCriptografadaJ1);
                    System.out.println("=================================================================================");
                    System.out.println("                    Cadastro efetuado com sucesso!");
                    System.out.println("=================================================================================");
                    LimpaTela.clearScreen();
                    break;
                /*
                 System.out.println("Player2:");
                 jogador2 = entrada.next();
                 System.out.println("Senha:");
                 senhaj2 = entrada.next();
                 System.out.println("Confirmar senha:");
                 senhaverij2 = entrada.next();
                 if (!(senhaj2.equals(senhaverij2))) {
                 do {
                 System.out.println("Senha diferentes,redigite sua senha:");
                 senhaj2 = entrada.next();

                 } while (senhaj2.equals(senhaverij2));

                 }
                 //chamando o método cripto para criptografar a senha do jogador 2
                 String senhaCriptografadaJ2 = criptografar.passEncript(senhaj2);
                 salvar.arquivarLogin(jogador2, senhaCriptografadaJ2);
                 System.out.println("=================================================================================");
                 System.out.println("                    Cadastro efetuado com sucesso!");
                 System.out.println("=================================================================================");
                 */
                case 2:
                    System.out.println("Login:");
                    String login = entrada.next();
                    System.out.println("Senha:");
                    String senha = entrada.next();
                    if (Validar.validarLogin(login, senha)) {
                        do {
                            System.out.println("-------------------------------------------");
                            System.out.println("            Jogo da Cerca v2.0");
                            System.out.println("-------------------------------------------");
                            System.out.println("             [2] Novo jogo");
                            System.out.println("             [3] Recordes");
                            System.out.println("             [4] Instruções");
                            System.out.println("             [5] Ajuda");
                            System.out.println("             [0] Sair    ");
                            comando = entrada.nextInt();
                            switch (comando) {
                                case 2:
                                    // Carrega o arquivo de áudio (não funciona com .mp3, só .wav)
                                    URL oUrl = new URL("file:///C:\\Users\\Iago\\Desktop\\jogoDaCercaProjetoFinal\\Musica\\Jogo.wav");
                                    Clip oClip = AudioSystem.getClip();
                                    AudioInputStream oStream = AudioSystem.getAudioInputStream(oUrl);
                                    oClip.open(oStream);

                                    //oClip.loop(0); // Toca uma vez
                                    oClip.loop(Clip.LOOP_CONTINUOUSLY); // Toca continuamente (para o caso de músicas)

                                    // Para a execução (senão o programa termina antes de você ouvir o som)
                                    SwingUtilities.invokeLater(new Runnable() {
                                        public void run() {

                                        }
                                    });
                                    System.out.println("Informe o nome do jogador convidado ");
                                    String j2 = entrada.next();
                                    Jogo novoJogo = new Jogo(login, j2);

                                    break;
                                case 3:
                                    FileRecords record = new FileRecords();
                                    record.records();
                                    break;
                                case 4:
                                    int cmd;
                                    do {
                                        System.out.println("===================================================================================");
                                        System.out.println(" Nos jogos de linhas e colunas, é preciso desenvolver estratégicas desde a primeira\n\r"
                                                + " jogada para estabelecer uma dinâmica que leve á vitória.");
                                        System.out.println("===================================================================================");
                                        System.out.println("                                                             [0] Voltar");
                                        cmd = entrada.nextInt();
                                    } while (cmd != 0);
                                    break;

                                case 5:
                                    Menuajuda.ajuda();

                                    break;
                                case 0:
                                    System.out.println("Jogo Finalizado!!!!");
                                    break;

                            }
                        } while (comando != 0);
                    } else {
                        System.out.println("Os dados não conferem !!!");
                    }

            }

        } while (comando != 0);

    }

}
