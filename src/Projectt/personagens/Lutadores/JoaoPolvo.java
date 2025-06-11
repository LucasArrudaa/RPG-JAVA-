package Projectt.personagens.Lutadores;

import Projectt.personagens.Contrato.Estrutura;
import Projectt.personagens.abstractClass.Personagem;

import java.util.Random;

public class JoaoPolvo extends Personagem implements Estrutura {

    //Atributos
    protected Random acao = new Random();

    //Construtor
    public JoaoPolvo (String nome, int vida, int defesa, int ataque, int especial, int vitorias, int derrotas) {
        super("João Polvo🐙", 100, 30, 30, 55, 0, 0);
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
        return "=> João Polvo\n\n" +
                "\nJoão Polvo é o caos ambulante. Após um acidente inusitado em um laboratório marinho, ele caminha " +
                "\ncom oito tentáculos prontos para atacar. Cada braço causa dano moderado (+5 de ataque), " +
                "\nmas sua verdadeira força está no controle: ele pode paralisar ou " +
                "\natrapalhar oponentes +8 em mobilidade e alcance. É quase impossível lutar contra múltiplos ataques simultâneos.";
    }

}