package br.com.afsj.model;

public class Rainha extends Peca {

    @Override
    public boolean movimentoOK(int x, int y) {
        if (posX == -1 && posY == -1) {
            return true;
        }
        
        int dx = x - posX;
        int dy = y - posY;

        if (dx == 0 && dy == 0) {
            return false;
        }

        // Movimento em linha reta ou diagonal
        boolean linhaReta = (dx == 0 || dy == 0);
        boolean diagonal = (Math.abs(dx) == Math.abs(dy));
        if (!linhaReta && !diagonal)
            return false;

        // Passo em cada direção (-1, 0, 1)
        int stepX = Integer.compare(dx, 0);
        int stepY = Integer.compare(dy, 0);

        int cx = posX + stepX;
        int cy = posY + stepY;

        // Verifica cada casa até o destino (excluindo o destino)
        while (cx != x || cy != y) {
            Peca p = Tabuleiro.listaBrancas.pecaPosicao(cx, cy);
            if (p != null)
                return false; // existe peça no caminho
            p = Tabuleiro.listaPretas.pecaPosicao(cx, cy);
            if (p != null)
                return false; // existe peça no caminho

            cx += stepX;
            cy += stepY;
        }

        // No destino: permitido se vazio ou peça adversária
        Peca destino = Tabuleiro.listaBrancas.pecaPosicao(x, y);
        if (destino == null)
            destino = Tabuleiro.listaPretas.pecaPosicao(x, y);
        if (destino == null)
            return true; // casa livre
        return destino.getCor() != this.getCor(); // captura apenas se cores diferentes
    }

    @Override
    public boolean capturar(int x, int y) {
        return mover(x, y);
    }
}
