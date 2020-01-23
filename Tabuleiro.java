/**
 * Classe para o objeto tabuleiro do jogo Speculate. 
 * 
 * @author Vitoria Postai Martins
 * @version 15 06 2019
 */

public class Tabuleiro{
    private boolean buraco1;
    private boolean buraco2;
    private boolean buraco3;
    private boolean buraco4;
    private boolean buraco5;
    
    /**
     * Cria um novo tabuleiro com os buracos 1, 3, e 5 preenchidos com bolinhas e os buracos 2 e 4 vazios.
     */
    public Tabuleiro(){
        buraco1 = buraco3 = buraco5 = true;
        buraco2 = buraco4 = false;
    }
    /**
     * Checa se eh para incrementar, decrementar ou descartar a bola do jogador.
     * @param buraco numero do buraco 
     * @return um numero inteiro: 1 se eh para incrementar o numero de bolas, -1 se eh para decrementar, -2 se o buraco for 6 e a bola tiver que ser "descartada" e -999 se o buraco nao existir.
     */
    //1 = incrementa, -1 = decrementa, -2=descarta
    public int bolaBuracos(int buraco){
        if(buraco == 1){
            if(buraco1==true){
                buraco1 = false;
                return 1;
            }
            else{
                buraco1 = true;
                return -1;
            }
        }
        else if(buraco == 2){
            if(buraco2==true){
                buraco2 = false;
                return 1;
            }
            else{
                buraco2 = true;
                return -1;
            }
        }
        else if(buraco == 3){
            if(buraco3==true){
                buraco3 = false;
                return 1;
            }
            else{
                buraco3 = true;
                return -1;
            }
        }
        else if(buraco == 4){
            if(buraco4==true){
                buraco4 = false;
                return 1;
            }
            else{
                buraco4 = true;
                return -1;
            }
        }
        else if(buraco == 5){
            if(buraco5==true){
                buraco5 = false;
                return 1;
            }
            else{
                buraco5 = true;
                return -1;
            }
        }
        else if (buraco == 6){
            return -2;
        }
        else{
            return -999;
        }
    }
    /**
     * Metodo para obter se o buraco esta preenchido ou nao.
     * @param buraco numero do buraco
     * @return um valor booleano: true se estiver preenchido, false se estiver vazio.
     */
    public boolean obtemBuraco(int buraco){
        if(buraco==1){
            return buraco1;
        }
        else if(buraco==2){
            return buraco2;
        }
        else if(buraco==3){
            return buraco3;
        }
        else if(buraco == 4){
            return buraco4;
        }
        else if(buraco == 5){
            return buraco5;
        }
        else{
            return false;
        }
    }
}
