/**
 * Classe para objetos do tipo Score. 
 * 
 * @author Vitoria Postai Martins
 * @version 15 06 2019
 */

import java.util.Scanner;
import java.io.*;

public class Score
{
    /**
     * Cria um novo Score.
     */
    public Score(){
    }
    /**
     * Metodo para salvar o score em um arquivo txt.
     * @param jogador nome do jogador vencedor cuja vitoria se quer guardar
     * @param rodadas numero de rodadas as quais o jogador ganhou
     */
    public void salvaScore(String jogador, int rodadas) throws FileNotFoundException{        
            String entrada = "score.txt";
            try{
                File inputFile = new File(entrada); 
                Scanner in = new Scanner(inputFile); 
                try{
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(entrada, true))); //cria um printwriter para escrever no final do arquivo
                    out.println(jogador +"--"+rodadas+" rodadas");
                    out.close();
                }catch (IOException erro){
                    System.out.println("erro");
                }
            }catch(FileNotFoundException e){
                PrintWriter out = new PrintWriter("score.txt");
                
                out.println(jogador +"--"+rodadas+" rodadas");
                
                out.close();
           }
    }
}
