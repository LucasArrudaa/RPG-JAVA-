package Projectt.personagens.Lutadores;

import Projectt.personagens.Contrato.Estrutura;
import Projectt.personagens.abstractClass.Personagem;

import java.util.Random;

public class ZeMartelo extends Personagem implements Estrutura {

    //Atributos
    protected Random acao = new Random();

    //Construtor
    public ZeMartelo(String nome, int vida, int defesa, int ataque, int especial, int vitorias, int derrotas) {
        super("Zé Martelo🔨", 100, 30, 29, 55, 0, 0);
    }

    //Metodos
    @Override
    public int ataqueLutadores(){
        int ataque = acao.nextInt(50);
        int ataqueFinal = ataque + this.ataque;
        return ataqueFinal;
    }

    @Override
    public int defesaLutadores( int ataqueFinal ) {
        int defesa = acao.nextInt(50) + this.defesa;
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
        return "=> Zé Martelo\n\n" +
                "Zé Martelo é uma muralha viva. Ex-pedreiro e lutador de rua, ele trocou a colher de pedreiro" +
                "\npor golpes pesados e uma defesa inquebrável. Embora seus ataques não causem tanto dano +7 de ataque," +
                "\né quase impossível derrubá-lo graças à sua impressionante bônus de +14 em defesa." +
                "\nQuando Zé entra na arena, ele não vence pela força bruta – vence pela resistência. " +
                "\nE quem bate nele, cansa primeiro";
    }

}

