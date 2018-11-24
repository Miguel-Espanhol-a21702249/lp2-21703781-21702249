package pt.ulusofona.lp2.crazyChess;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Simulador {
    int sizeTabuleiro;
    int numeroDePecas;
    ArrayList<CrazyPiece> listaPecas = new ArrayList<>();
    static HashMap<Integer,CrazyPiece> mapaDePecas = null;

    public boolean iniciaJogo(File ficheiroInicial){
        int count =0 ,linhaTabuleiro=0;
        mapaDePecas = new HashMap<>();
        try {
            Scanner leitorFicheiro = new Scanner(ficheiroInicial);


            while(leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(":");
                if (count < 2 ) {
                    if (count == 0){
                        if (Integer.parseInt(dados[0])>=4 && Integer.parseInt(dados[0])<=12){
                            sizeTabuleiro = Integer.parseInt(dados[0]);
                        }
                    }else{
                        if (Integer.parseInt(dados[0])<sizeTabuleiro*sizeTabuleiro){
                            numeroDePecas = Integer.parseInt(dados[0]);
                        }
                    }
                    count++;
                }else if (count < 2 + numeroDePecas) {

                    if(!listaPecas.contains(Integer.parseInt(dados[0])) && Integer.parseInt(dados[0])>=1) {
                        if(Integer.parseInt(dados[1])>=0 && Integer.parseInt(dados[1])<=10) {
                            if (Integer.parseInt(dados[2]) == 0 || Integer.parseInt(dados[2])==1) {
                                CrazyPiece piece = new CrazyPiece(Integer.parseInt(dados[0]),Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),dados[3]);

                                mapaDePecas.put(Integer.parseInt(dados[0]),piece);
                                listaPecas.add(piece);
                            }
                        }
                    }
                    count++;
                }else {
                    CrazyPiece piece = new CrazyPiece();
                    for (int coluna =0 ;coluna < sizeTabuleiro ; coluna++) {
                        if( Integer.parseInt(dados[coluna]) != 0 ) {
                            piece = mapaDePecas.get(Integer.parseInt(dados[coluna]));
                            piece.posicaoX(coluna);
                            piece.posicaoY(linhaTabuleiro);
                            mapaDePecas.put(Integer.parseInt(dados[coluna]),piece);
                        }
                    }
                    linhaTabuleiro++;
                }
            }

            leitorFicheiro.close();

            return true;

        } catch(FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + ficheiroInicial.getName() + " nao foi encontrado.";
            System.out.println(mensagem);
            return false;
        }
    }

    public int getTamanhoTabuleiro(){
        return sizeTabuleiro;
    }
/*
    public boolean processaJogada(int xO, int yO, int xD, int Yd){

    }*/
    public List<CrazyPiece> getPecasMalucas(){
        return listaPecas;
    }/*
    public boolean jogoTerminado(){

    }*/
    public List<String> getAutores() {
        List<String> dados = new ArrayList<>();
        dados.add("a21702249 - Miguel Espanhol");
        dados.add("a21703781 - Rui Prata");
        return dados;
    }
    /*public List<String> getResultados(){

    }*/
    public int getIDPeca(int x, int y){
        for (int i = 0; i< listaPecas.size; i++){
            if(listaPecas.get(i).x == x){
                if(listaPecas.get(i).y == y){
                    return ;
                }
            }
        }
    }
    /*
    public int getIDEquipaAJogar(){

    }*/
}
