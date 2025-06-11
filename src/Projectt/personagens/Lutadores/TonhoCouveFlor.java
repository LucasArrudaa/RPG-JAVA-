package Projectt.personagens.Lutadores;

import Projectt.personagens.Contrato.Estrutura;
import Projectt.personagens.abstractClass.Personagem;

import java.util.Random;

public class TonhoCouveFlor extends Personagem implements Estrutura {

    //Atributos
    protected Random acao = new Random();

    //Construtor
    public TonhoCouveFlor(String nome, int vida, int defesa, int ataque, int especial, int vitorias, int derrotas) {
        super("Tonho Couve-Flor🥬", 100, 30, 31, 49, 0, 0);
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
    public String apresentacaoPersonagens() {
        return "=>  Tonho Couve‑Flor\n\n" +
                "\nTonho Couve‑Flor é o soco imprevisível. Cicatrizes profundas deixaram seu rosto deformado, " +
                "\nmas marcaram também sua trajetória: de lutador de rua a lenda temida. Seus golpes causam dano desigual" +
                "\n +14 de ataque, dependendo de quão enfurecido ele esteja. Sua defesa é discreta +4, mas é sua fúria que " +
                "\nassusta os adversários. Quem subestima Tonho, se perde no caos.";
    }

}