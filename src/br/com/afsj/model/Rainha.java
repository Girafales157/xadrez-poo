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

        if (dx == 0 || dy == 0) {
            return true;
        }

        if (Math.abs(dx) == Math.abs(dy)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean capturar(int x, int y) {
        return mover(x, y);
    }
}
