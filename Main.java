/**
 * Classe principal para o jogo de Speculate. Main class. 
 * 
 * @author Vitoria Postai Martins
 * @version 15 06 2019
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main{
    public static void main (String[] args) throws FileNotFoundException{
        Jogo jogo = new Jogo(); //cria um novo Jogo 
        
        jogo.jogar(); 
    }
}
