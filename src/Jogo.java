import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    ArrayList<Jogador> equipe1;
    ArrayList<Jogador> equipe2;
    Integer pontuacao1;
    Integer pontuacao2;
    Jogo(String nome1, String nome2, String nome3, String nome4){
        this.equipe1 = new ArrayList<Jogador>();
        this.equipe2 = new ArrayList<Jogador>();

        this.equipe1.add(new Jogador(nome1));
        this.equipe1.add(new Jogador(nome2));
        this.equipe2.add(new Jogador(nome3));
        this.equipe2.add(new Jogador(nome4));

        this.pontuacao1 = 0;
        this.pontuacao2 = 0;
    }

    public void Rodada(){
        Baralho baralhoRodada = new Baralho();
        this.equipe1.get(0).ComprarMao(baralhoRodada);
        this.equipe1.get(1).ComprarMao(baralhoRodada);
        this.equipe2.get(0).ComprarMao(baralhoRodada);
        this.equipe2.get(1).ComprarMao(baralhoRodada);
        int pontos1Rodada = 0;
        int pontos2Rodada = 0;

        boolean semGanhador = true;

        while(semGanhador){
             Random random = new Random();
             int indexCarta = random.nextInt(this.equipe1.get(0).mao.size());
             ArrayList<Cartas> jogadas = new ArrayList<Cartas>();

             for(Jogador jogador: equipe1){
                jogadas.add(jogador.JogarCarta(indexCarta));
             }
             for(Jogador jogador: equipe2){
                jogadas.add(jogador.JogarCarta(indexCarta));
             }

             int vencedor = this.CompararCartas(jogadas);

             if(vencedor == 0 || vencedor == 1){
                pontos1Rodada += 1;
             } if(vencedor == 2 || vencedor == 3){
                pontos2Rodada += 1;
             }

             if (pontos1Rodada == 2) {
                this.pontuacao1 += 1;
                semGanhador = false;
             } else if(pontos2Rodada == 2){
                this.pontuacao2 += 1;
                semGanhador = false;
             }
        }
    }

    public Integer CompararCartas(ArrayList<Cartas> jogadas){
        Cartas[] manilhas = {new Cartas(NAIPES.OUROS, 7), new Cartas(NAIPES.ESPADAS, 1), new Cartas(NAIPES.COPAS, 7), new Cartas(NAIPES.PAUS, 4)};
        boolean contemManilha = false;
        for(Cartas carta: manilhas){
            contemManilha = jogadas.contains(carta);
        }

        if(contemManilha){
            for(int i = 3; i >=0; i--){
                if(jogadas.contains(manilhas[i])){
                return jogadas.indexOf(manilhas[i]);
                }
            }
        }

        Integer[] restante = {11,12,13,1,2,3};

        ArrayList<Integer> jogadasValores = new ArrayList<Integer>();

        for(Cartas carta: jogadas){
            jogadasValores.add(carta.valor);
        }

        for(int i = 5; i >=0; i--){
            if(jogadasValores.contains(restante[i])){
                return jogadasValores.indexOf(restante[i]);
            }
        }

        return -1;
    }
}
