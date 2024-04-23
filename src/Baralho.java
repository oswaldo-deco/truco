import java.util.ArrayList;
import java.util.Random;

public class Baralho {
    ArrayList<Cartas> conteudo;
    Random random;
    Baralho(){
        this.random = new Random();
        NAIPES[] naipes = {NAIPES.COPAS, NAIPES.ESPADAS, NAIPES.OUROS, NAIPES.PAUS};
        this.conteudo = new ArrayList<Cartas>();
        for(Integer i = 1;i<4 ;i++){
            for(NAIPES naipe : naipes){
                Cartas carta = new Cartas(naipe, i);
                this.conteudo.add(carta);
            }
        }
        for(Integer i = 11;i<14 ;i++){
            for(NAIPES naipe : naipes){
                Cartas carta = new Cartas(naipe, i);
                this.conteudo.add(carta);
            }
        }

        Cartas copas = new Cartas(NAIPES.COPAS, 7);
        Cartas zap = new Cartas(NAIPES.PAUS, 4);
        Cartas ouros = new Cartas(NAIPES.OUROS, 7);

        this.conteudo.add(ouros);
        this.conteudo.add(zap);
        this.conteudo.add(copas);
    }

    public void Embaralhar() {
        int n = this.conteudo.size();
        for(int i = 1; i< 100; i++){
            int index1 = this.random.nextInt(n);
            int index2 = this.random.nextInt(n);
            Cartas carta1 = this.conteudo.get(index1);
            Cartas carta2 = this.conteudo.get(index2);
            this.conteudo.set(index1, carta2);
            this.conteudo.set(index2, carta1);
        }
    }

    public Cartas Comprar(){
        Cartas carta = this.conteudo.get(0);
        this.conteudo.remove(0);
        return carta;
    }
}
