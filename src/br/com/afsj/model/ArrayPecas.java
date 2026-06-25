package br.com.afsj.model;

import java.util.ArrayList;

public class ArrayPecas extends ArrayList<Peca> {
	
	Peca pecaPosicao(int x, int y) {
		// Retorna a Peca que esta na posicao indicada
		// Retorna null, caso nao haja pecas nessa posicao
		Peca p;
		for (int i = 0; i < this.size(); i++) {
			p = this.get(i);
			if ((p.getPosX() == x) && (p.getPosY() == y))
				return p;
		}
		return null;
	}
	
	ArrayPecas pecasParaPosicao(int x, int y) {
		// Retorna um Array contendo as pecas que podem ir a uma dada posicao.
		ArrayPecas pRetorno = new ArrayPecas();
		Peca p;
		for (int i = 0; i < this.size(); i++) {
			p = this.get(i);
			if (p.movimentoOK(x, y))
				pRetorno.add(p);
		}
		return pRetorno;		
	}
	
	boolean posicaoLivreAtaque(int x, int y) {
		// Retorna true se nenhuma peca pode atacar esta posicao
		// Retorna false se pelo menos uma peca pode atacar a posicao
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).movimentoOK(x, y))
				return false;
		}
		return true;		
		
	}
}
