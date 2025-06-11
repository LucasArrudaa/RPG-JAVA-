package Projectt.personagens.Lutadores;

import Projectt.personagens.Contrato.Estrutura;
import Projectt.personagens.abstractClass.Personagem;

import java.util.Random;

public class ChicoMachado extends Personagem implements Estrutura {

    //Atributos
    protected Random acao = new Random();

    //Construtor
    public ChicoMachado (String nome, int vida, int defesa, int ataque, int especial, int vitorias, int derrotas) {
        super("Chico Machado🪓", 100, 30, 30, 51, 0, 0);
    }

    //Metodos
    @Override
    public int ataqueLutadores(){
        int ataque = acao.nextInt(10);
        int ataqueFinal = ataque + this.ataque;
        return ataqueFinal;
    }

    @Override
    public int defesaLutadores( int ataqueFinal ) {
        int defesa = acao.nextInt(10) + this.defesa;
        int danoFinal = ataqueFinal - defesa;
        if (danoFinal < 0) {
            danoFinal = 0;
        }
        vida -= danoFinal;
        if ( vida < 0 ) {
            vida = 0;
        }
        return danoFinal;
    }

    @Override
    public String apresentacaoPersonagens(){
        return "=> Chico Machado\n\n" +
                "\nChico Machado é um martelo humano. De aprendiz de ferreiro a gladiador, ele traz para a arena a " +
                "\nhabilidade de forjar seus próprios ataques. Seus golpes causam dano devastador +12 de ataque," +
                "\n mas isso tem custo — sua defesa é mediana +3. Cada pancada é calculada, " +
                "\ne seu tempo entre golpes pode ser explorado… a menos que você seja atingido em cheio.";
    }

}