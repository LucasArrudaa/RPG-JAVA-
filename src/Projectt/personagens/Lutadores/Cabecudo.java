package Projectt.personagens.Lutadores;

import Projectt.personagens.Contrato.Estrutura;
import Projectt.personagens.abstractClass.Personagem;

import java.util.Random;

public class Cabecudo extends Personagem implements Estrutura {

    //Atributos
    protected Random acao = new Random();

    //Construtor
    public Cabecudo (String nome, int vida, int defesa, int ataque, int especial, int vitorias, int derrotas) {
        super("Cabeçudo🫨", 100, 30, 33, 50, 0, 0);
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
        return "=> Cabeçudo\n\n" +
                "Cabeçudo é o escudo ambulante. Após um experimento que expandiu seu crânio a proporções descomunais, " +
                "\nvirou um muro de carne e osso. Seu ataque é consistente +6, " +
                "\nmas é na defesa que brilha: +11 em proteção de cabeça. Cada cabeçada é violenta — e muitas vezes, " +
                "\ninstintiva. Só tome cuidado para não trombar com seu próprio crânio.";

        //JOptionPane.showMessageDialog(null,","RPG CRAZY-FIGHT",JOptionPane.INFORMATION_MESSAGE);
    }

}