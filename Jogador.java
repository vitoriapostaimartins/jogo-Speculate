/**
 * Classe para objetos do tipo Jogador.
 * 
 * @author Vitoria Postai Martins
 * @version 15 06 2019
 */

public class Jogador{
    private int numBolas;
    /**
     * Cria um novo jogador com 15 bolinhas.
     */
    public Jogador(){
        numBolas = 15;
    }
    /**
     * Adiciona uma bola ao numero de bolas que o jogador tem.
     */
    public void adicionaBola(){
        numBolas++;
    }
    /**
     * Remove uma bola do numero de bolas que o jogador tem.
     */
    public void removeBola(){
        numBolas--;
    }
    /**
     * Obtem o numero de bolas que o jogador tem.
     * @return numero de bolas.
     */
    public int obtemBolas(){
        return numBolas;
    }
}
