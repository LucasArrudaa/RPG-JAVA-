package Projectt.personagens.itens;

import Projectt.personagens.abstractClass.Personagem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;


public class Torneio {

    private Usuario jogador;
    private ArrayList<Personagem> oponentes;

    public Torneio(Usuario jogador, Personagem[] todos) {
        this.jogador = jogador;
        this.oponentes = new ArrayList<>();

        for (Personagem p : todos) {
            if (!p.getNome().equals(jogador.getPersonagemFavorito().getNome())) {
                oponentes.add(p);
            }
        }

        Collections.shuffle(oponentes); // embaralhar
    }

    public void iniciar() {
        JOptionPane.showMessageDialog(null, "🏆 Bem-vindo ao Torneio dos Campeões!");
        Personagem seuPersonagem = jogador.getPersonagemFavorito();

        for (int fase = 0; fase < oponentes.size(); fase++) {
            Personagem inimigo = oponentes.get(fase);
            JOptionPane.showMessageDialog(null, "⚔️ Fase " + (fase + 1) + ": " + seuPersonagem.getNome() + " vs " + inimigo.getNome());

            Confronto.lutar(seuPersonagem, inimigo);
            Personagem vencedor = seuPersonagem.estavivo() ? seuPersonagem : inimigo;

            if (vencedor.getNome().equals(seuPersonagem.getNome())) {
                jogador.ganharXp(50);
                JOptionPane.showMessageDialog(null, "✅ Você venceu esta fase!\n" + jogador.status());
            } else {
                JOptionPane.showMessageDialog(null, "❌ Você foi eliminado do torneio.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "🏆 Parabéns, " + jogador.getNome() + "! Você é o CAMPEÃO do torneio!");
    }
}
