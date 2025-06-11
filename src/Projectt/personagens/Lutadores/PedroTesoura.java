package Projectt.personagens.Lutadores;

import Projectt.personagens.Contrato.Estrutura;
import Projectt.personagens.abstractClass.Personagem;

import java.util.Random;

public class PedroTesoura extends Personagem implements Estrutura {

    //Atributos
    protected Random acao = new Random();

    //Construtor
    public PedroTesoura(String nome, int vida, int defesa, int ataque, int especial, int vitorias, int derrotas) {
        super("Pedro Tesoura✂️", 100, 30, 35, 49, 0, 0);
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
        return "=> Pedro Tesoura\n\n" +
                "\nPedro Tesoura é a lâmina cirúrgica. Um ex-barbeiro com habilidades mecânicas, trocou seus dedos por " +
                "\nlâminas afiadas. Seus golpes causam dano cortante (+9 de ataque) e têm chance de causar sangramento. " +
                "\nContudo, sua defesa é baixa (‑2), então ele precisa ser rápido e preciso — um erro, e pode ser despedaçado.";
    }

}