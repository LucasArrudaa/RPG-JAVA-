package Projectt.personagens.itens;

import Projectt.personagens.abstractClass.Personagem;

import javax.swing.*;
import java.util.ArrayList;


public class Usuario {
    private String nome;
    private Personagem personagemFavorito;
    private int xp;
    private int nivel;
    private ArrayList<Item> inventario = new ArrayList<>();

    public Usuario(String nome, Personagem personagemFavorito) {
        this.nome = nome;
        this.personagemFavorito = personagemFavorito;
        this.xp = 0;
        this.nivel = 1;
    }

    public String getNome() { return nome; }
    public Personagem getPersonagemFavorito() { return personagemFavorito; }
    public int getXp() { return xp; }
    public int getNivel() { return nivel; }

    public void ganharXp(int valor) {
        this.xp += valor;
        while (this.xp >= 100) {
            this.xp -= 100;
            this.nivel++;
            personagemFavorito.upgrade(); // método na classe Personagem
        }
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public void usarItem(Personagem p) {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seu inventário está vazio!");
            return;
        }

        String[] nomes = new String[inventario.size()];
        for (int i = 0; i < inventario.size(); i++) {
            nomes[i] = inventario.get(i).getNome() + " (" + inventario.get(i).getTipo() + ")";
        }

        String escolha = (String) JOptionPane.showInputDialog(null,
                "Escolha um item para usar:", "Inventário",
                JOptionPane.QUESTION_MESSAGE, null, nomes, nomes[0]);

        if (escolha != null) {
            for (Item item : inventario) {
                if (escolha.startsWith(item.getNome())) {
                    item.usar(p);
                    inventario.remove(item);
                    JOptionPane.showMessageDialog(null, "Você usou o item: " + item.getNome());
                    break;
                }
            }
        }
    }

    public String status() {
        return "👤 Jogador: " + nome + "\n🎮 Personagem: " + personagemFavorito.getNome() +
                "\n⭐ Nível: " + nivel + "\n📈 XP: " + xp + "/100";
    }
}
