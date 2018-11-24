package pt.ulusofona.lp2.crazyChess;

import javax.swing.*;

public class CrazyPiece {
    int IDPeca;
    int tipoDePeca;
    int IDEquipa;
    String alcunha;
    int x;
    int y;

    CrazyPiece(int IDPeca, int tipoDePeca, int IDEquipa, String alcunha) {
        this.IDPeca = IDPeca;
        this.tipoDePeca = tipoDePeca;
        this.IDEquipa = IDEquipa;
        this.alcunha = alcunha;
    }

    CrazyPiece() {

    }

    int posicaoX(int x) {
        this.x = x;
        return x;
    }

    int posicaoY(int y) {
        this.y = y;
        return y;
    }


    public int getID(int IDPeca) {
        this.IDPeca = IDPeca;
        return IDPeca;
    }/*
    public String getImagePNG(){
        if(IDEquipa == 0){
            getIcon("icon8-king-50-white.png");
        }
        if(IDEquipa == 1){
            getIcon("icon8-king-50-black.png");
        }
    }/*
    public String toString(){
        if (){                                                 É MAIS OU MENOS ISTO
            return IDdaPeca + tipoDaPeca + IDEquipa + alcunha + "@ (" + x + ", " + y ")";
        }else{
            return IDdaPeca + tipoDaPeca + IDEquipa + alcunha + "@ está fora!";
        }
    }*/
}