package Projectt.personagens.itens;

import javax.swing.*;

import Projectt.personagens.abstractClass.Personagem;

public class Confronto {
    public static void lutar(Personagem play1, Personagem play2) {

        if (play1 == play2) {
            JOptionPane.showMessageDialog(null, "❌ Escolha personagens diferentes! ❌",
                    "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Desafiante - " + play1.getNome() + " ⚔️  Desafiado - " + play2.getNome(),
                "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE);

        // reinicializa a vida dos lutadores
        play1.getVida();
        play2.getVida();

        String vencedor = "";
        String perdedor = "";

        int rodada = 1;
        StringBuilder logLuta = new StringBuilder();

        while (play1.estavivo() && play2.estavivo()) {
            logLuta.append("=> Rodada ").append(rodada).append(" <=\n");

            // ATAQUE DO PRIMEIRO JOGADOR
            int ataqueFinal1 = play1.ataqueLutadores();
            logLuta.append(play1.getNome()).append(" provoca dano de ").append(ataqueFinal1).append("\n");
            play2.defesaLutadores(ataqueFinal1);

            if (!play2.estavivo()) {
                logLuta.append(play2.getNome()).append(" foi derrotado! ☠️⚰️\n");
                play1.setVitorias(play1.getVitorias() + 1);
                play2.setDerrotas(play2.getDerrotas() + 1);
                break;
            }

            // ATAQUE DO SEGUNDO JOGADOR
            int ataqueFinal2 = play2.ataqueLutadores();
            logLuta.append(play2.getNome()).append(" provoca dano de ").append(ataqueFinal2).append("\n");
            play1.defesaLutadores(ataqueFinal2);

            if (!play1.estavivo()) {
                logLuta.append(play1.getNome()).append(" foi derrotado! ☠️⚰️\n");
                play2.setVitorias(play2.getVitorias() + 1);
                play1.setDerrotas(play1.getDerrotas() + 1);
                break;
            }

            rodada++;
        }

        if (!play2.estavivo()) {
            vencedor = play1.getNome();
            perdedor = play2.getNome();
        } else {
            vencedor = play2.getNome();
            perdedor = play1.getNome();
        }

        String resumo = "=> Resumo de Luta <=\n" +
                "Rodadas disputadas: " + rodada + "\n" +
                "Vencedor: " + vencedor + "\n" +
                "Perdedor: " + perdedor;

        // Exibe o log da luta
        JOptionPane.showMessageDialog(null, logLuta.toString(),
                "BATALHA EM ANDAMENTO", JOptionPane.INFORMATION_MESSAGE);

        // Exibe o resumo
        JOptionPane.showMessageDialog(null, resumo,
                "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE);
    }
}