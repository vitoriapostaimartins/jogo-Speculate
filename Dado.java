/**
 * Classe para o objeto dado. 
 * 
 * @author Vitoria Postai Martins
 * @version 15 06 2019
 */

import java.util.Random;

public class Dado{
	private int numFaces;
	private Random r;
	/**
	 * Cria um novo dado com 6 faces.
	 */
	public Dado(){
		numFaces= 6;
		r = new Random();
	}
	/**
	 * Cria um novo dado com o numero de faces desejado.
	 * @param nf numero de faces desejado
	 */
	public Dado(int nf){
		numFaces = nf;
		r = new Random();
	}
	/**
	 * Rola o dado 
	 * @return um numero que corresponde a uma das faces do dado.
	 */
	public int rolar(){
		return r.nextInt(numFaces)+1;
	}
	
}
