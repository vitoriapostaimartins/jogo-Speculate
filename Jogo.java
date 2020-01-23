/**
 * Classe para objetos do tipo jogo. 
 * 
 * @author Vitoria Postai Martins
 * @version 15 06 2019
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
public class Jogo{
    private Scanner in;
    private Dado dado;
    private Tabuleiro tabuleiro;
    private Jogador usuario;
    private Jogador pc;
    private boolean turno;
    private int totalBolas;   
    private int numRodadas;
    private Score score;
    /**
     * Cria um novo jogo.
     */
    
    public Jogo(){
        in = new Scanner (System.in);
        dado = new Dado(6);
        tabuleiro = new Tabuleiro();
        usuario = new Jogador();
        pc = new Jogador();
        turno = false;
        totalBolas = 33;
        numRodadas=0;
    }
    /**
     * Inicia um novo jogo.
     */
    public void jogar() throws FileNotFoundException{
        System.out.println("Qual eh o seu nome?");
        String nome = in.nextLine();
        
        while(true){
                if(turno == false){ //vez do usuario
                    System.out.println("numero de bolas:"+usuario.obtemBolas());
                    System.out.print("quantas vezes voce quer jogar o dado? ");
                    int numJogadas = in.nextInt(); //numero de vezes que o usuario quer jogar o dado
                    
                    if(numJogadas>usuario.obtemBolas() || numJogadas<1){ //opcoes de erro
                        System.out.println("erro! jogue outra vez");
                    }
                    else{ //opcoes validas
                        for (int i = numJogadas; i>0; i--){ //laco para repetir a jogada do dado o numero de vezes o usuario quiser.
                            int resDado = dado.rolar();
                            System.out.println("dado: "+resDado);
                            int resTabuleiro = tabuleiro.bolaBuracos(resDado);//tira ou coloca uma bolinha no buraco em que o dado resultou. 
                            if( resTabuleiro == 1){ //incrementa
                                usuario.adicionaBola();
                                System.out.println(nome+" - numero de bolas: "+usuario.obtemBolas());
                            }
                            else if(resTabuleiro== -1){ //decrementa
                                usuario.removeBola();
                                System.out.println(nome+ "- numero de bolas: "+usuario.obtemBolas());
                            }
                            else if (resTabuleiro==-2){ //descarta 
                                usuario.removeBola();
                                System.out.println(nome+" - numero de bolas: "+usuario.obtemBolas());
                                totalBolas--;
                            }
                            else{
                                System.out.print("erro");
                            }
                        }
                        System.out.println("#########################################################");
                        numRodadas++; //incrementa o numero de rodadas
                        turno=!turno;
                    }
                    
                }
                else{ //vez do computador jogar
                    System.out.println("vezes que o computador vai jogar o dado: "+ pc.obtemBolas());
                    int numJogadas = pc.obtemBolas(); //o pc sempre joga o numero de vezes correspondente ao numero de bolas que ele tem
                    
                    for (int i = numJogadas; i>0; i--){ 
                        int resDado = dado.rolar(); 
                        System.out.println("dado: "+resDado);
                        int resTabuleiro = tabuleiro.bolaBuracos(resDado);
                        if( resTabuleiro == 1){
                            pc.adicionaBola();
                            System.out.println("pc - numero de bolas: "+pc.obtemBolas());
                        }
                        else if(resTabuleiro== -1){
                            pc.removeBola();
                            System.out.println("pc - numero de bolas: "+pc.obtemBolas());
                        }
                        else if(resTabuleiro==-2){
                            pc.removeBola();
                            System.out.println("pc - numero de bolas: "+pc.obtemBolas());
                            totalBolas--;
                        }
                        else {
                            System.out.print("erro");
                        }
                    }              
                    System.out.println("#########################################################");
                    if (usuario.obtemBolas()<=0 || pc.obtemBolas()==0){
                        break; //sai do laco ja que alguem tem zero bolinhas e, portanto, ganhou o jogo.
                    }
                        
                    turno=!turno; //muda o turno
                }
                
        }
        if(usuario.obtemBolas()==0){
                System.out.println(nome+" GANHOU EM "+numRodadas+" RODADAS"+"! \n PLACAR FINAL: " + nome + ": " + usuario.obtemBolas() 
                                              +"   "       + " PC: "    + pc.obtemBolas());
                score = new Score();
                score.salvaScore(nome, numRodadas); //salva o score do usuario somente
        }
        else{
                System.out.println("PC GANHOU EM "+numRodadas+" RODADAS"+"! \n PLACAR FINAL: " + nome + ": " + usuario.obtemBolas() 
                                              +"   "       + " PC: "    + pc.obtemBolas());
        }
        }
    
}
