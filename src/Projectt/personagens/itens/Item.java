package Projectt.personagens.itens;

import Projectt.personagens.abstractClass.Personagem;

public class Item {
    private String nome;
    private String tipo; // "cura", "ataque", etc.
    private int efeito;

    public Item(String nome, String tipo, int efeito) {
        this.nome = nome;
        this.tipo = tipo;
        this.efeito = efeito;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getEfeito() { return efeito; }

    public void usar(Personagem p) {
        switch (tipo) {
            case "cura":
                p.setVida(p.getVida() + efeito);
                break;
            case "ataque":
                p.setAtaque(p.getAtaque() + efeito);
                break;
            case "defesa":
                p.setDefesa(p.getDefesa() + efeito);
                break;
        }
    }
}