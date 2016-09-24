/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodacercaprojetofinal;

import java.util.Scanner;

/**
 *
 * @author AdenilsonCamara
 */
public class Menuajuda {
    public static void ajuda(){
        int opcao;
        do{

                System.out.println("================================");
                System.out.println("  Bem vindo ao menu de ajuda!");
                System.out.println("================================");
                System.out.println("  [1] Como se cadastrar");
                System.out.println("  [2] Como recuperar sua senha");
                System.out.println("  [3] Botões de controle");
                System.out.println("  [4] Interface");
                System.out.println("  [5] Sobre");
                System.out.println("  [0] Voltar");
                opcao=new Scanner(System.in).nextInt();
                switch (opcao){
                    case 1:
                        System.out.println("====================================================================");
                        System.out.println("O cadastro do jogo é feito de forma simples, apenas com a seleção da\r\n"
                                +"opção (cadastro) no menu principal, você tera como inserir seu nickname. \r\n"
                                +"O próprio jogo te levara ao campo de insersão de sua senha!");
                        System.out.println("====================================================================");
                    break;
                    case 2:
                        System.out.println("====================================================================");
                        System.out.println("Infelizmente ainda não dispomos de um modulo para recuperação de senhas\r\n"
                                + "a melhor forma de ajudarmos a você usuario é permitir que crie uma nova conta!");
                        System.out.println("====================================================================");
                    break;
                    case 3:
                        System.out.println("====================================================================");
                        System.out.println("Para jogar você usara coordenadas, os comandos do jogo foi feito com"
                                + "referencia no jogo de xadrez que se movimenta sobre linhas posicionadas na "
                                + "vertical e horizontal, escolha a coluna que deseja jogar e a linha ai será feito!");
                        System.out.println("====================================================================");
                    break;
                    case 4:
                        System.out.println("====================================================================");
                        System.out.println("A interface do jogo foi totalmente pensada e projetada pensando em \r\n"
                                + "atender o maximo de interatividade sem comprometer a velocidade de execução \r\n"
                                + "do jogo");
                        System.out.println("====================================================================");
                    break;
                    case 5:
                        System.out.println("====================================================================");
                        System.out.println("Esta é a versão Beta do jogo:"
                                + "\r\n"
                                + "      JOGO DA CERCA 1.0\r\n"
                                + "\r\n"
                                + "Desenvolvido por: \r\n"
                                + "Lucas Menchone\r\n"
                                + "Ronisson Santos\r\n"
                                + "Lucas Martins\r\n"
                                + "Iago Thiago\r\n"
                                + "Adenilson Camara\r\n");
                        System.out.println("====================================================================");
                    break;
                        
                }
                }while (opcao!=0);
    }
    
}
