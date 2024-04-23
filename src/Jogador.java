import java.util.ArrayList;

public class Jogador {
    
    ArrayList<Cartas> mao;
    String nome;
    Jogador(String nome){
        this.mao  = new ArrayList<Cartas>();
        this.nome = nome;
    }

    public void ComprarMao(Baralho baralho){
        for(int i = 1; i <= 3; i++){
            Cartas carta = baralho.Comprar();
            this.mao.add(carta);
        }
    }

    public Cartas JogarCarta(int index){
        Cartas carta = this.mao.get(index);
        this.mao.remove(index);
        return carta;
    }
}
