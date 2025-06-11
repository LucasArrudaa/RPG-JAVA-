package Projectt.personagens.abstractClass;

import Projectt.personagens.Contrato.Estrutura;

import java.util.Random;

public abstract class Personagem implements Estrutura {

    //Atributos
    protected String nome;
    protected int vida;
    protected int defesa;
    protected int ataque;
    protected int especial;
    protected int vitorias;
    protected int Derrotas;
    protected Random acao;

    //Contrutor
    public Personagem(String nome, int vida, int defesa, int ataque, int especial, int vitorias, int derrotas) {
        this.nome = nome;
        this.vida = 100;
        this.defesa = defesa;
        this.ataque = ataque;
        this.especial = especial;
        this.vitorias = 0;
        Derrotas = 0;
    }

    //Metodos
    public boolean estavivo(){
        return vida > 0;
    }

    @Override
    public abstract int ataqueLutadores();

    @Override
    public abstract int defesaLutadores(int ataque);

    @Override
    public String apresentacaoPersonagens() {
        return "";
    }

    //Get - Sett
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getVida() { return vida; }

    public void setVida(int vida) { this.vida = vida; }

    public int getDefesa() { return defesa; }

    public void setDefesa(int defesa) { this.defesa = defesa; }

    public int getEspecial() { return especial; }

    public void setEspecial( int especial ) { this.especial = especial; }

    public int getAtaque() { return ataque; }

    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getVitorias() { return vitorias; }

    public void setVitorias(int vitorias) { this.vitorias = vitorias; }

    public int getDerrotas() {return Derrotas; }

    public void setDerrotas(int derrotas) { Derrotas = derrotas; }

    public void upgrade() {
        this.vida += 10;
        this.ataque += 2;
        this.defesa += 2;
        this.especial += 1;
        System.out.println("🔼 " + this.nome + " subiu de nível!");
    }

}

