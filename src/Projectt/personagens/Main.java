package Projectt.personagens;

import Projectt.personagens.itens.Confronto;
import Projectt.personagens.itens.Item;
import Projectt.personagens.itens.Torneio;
import Projectt.personagens.Lutadores.*;
import Projectt.personagens.abstractClass.*;
import Projectt.personagens.itens.Usuario;

import javax.swing.*;
// 11/06/2025
public class Main {
    public static void main(String[] args) {

        //Criação dos Personagens
        Personagem[] personagems = new Personagem[6];
        personagems[0] = new Cabecudo("Cabeçudo",100,11,6,10,0,0);
        personagems[1] = new ChicoMachado("Chico Machado",100,3,12,10,0,0);
        personagems[2] = new JoaoPolvo("João Polvo",100,8,5,10,0,0);
        personagems[3] = new PedroTesoura("Pedro Tesoura",100,2,9,10,0,0);
        personagems[4] = new TonhoCouveFlor("Tonho Couve Flor",100,4,14,10,0,0);
        personagems[5] = new ZeMartelo("Zé Martelo",100,14,2,10,0,0);

        // Criar usuário
        String nomeJogador = JOptionPane.showInputDialog(null, "Digite seu nome para iniciar:");
        String[] nomesPersonagens = new String[personagems.length];

        for (int i = 0; i < personagems.length; i++) {
            nomesPersonagens[i] = personagems[i].getNome();
        }

        //Inicio do Jogo
        JOptionPane.showMessageDialog(null,"    RPG CRAZY-FIGHT","\nBEM-VINDO \n\n",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "“Sejam bem-vindos ao Crazy‑Fight, o torneio onde a insanidade faz parte das regras — e " +
                "apenas os mais loucos sobrevivem!","RPG CRAZY-FIGHT",JOptionPane.INFORMATION_MESSAGE);

        String escolha = (String) JOptionPane.showInputDialog(null, "Antes de seguir.... escolha seu personagem favorito:", "CRIAR USUÁRIO",
                JOptionPane.QUESTION_MESSAGE, null, nomesPersonagens, nomesPersonagens[0]);

        Personagem personagemEscolhido = null;
        for (Personagem p : personagems) {
            if (p.getNome().equals(escolha)) {
                personagemEscolhido = p;
                break;
            }
        }
        Usuario usuario = new Usuario(nomeJogador, personagemEscolhido);
        usuario.adicionarItem(new Item("Poção de Vida", "cura", 30));
        usuario.adicionarItem(new Item("Poção de Força", "ataque", 3));
        usuario.adicionarItem(new Item("Poção de Defesa", "defesa", 3));
        JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!\n\n" + usuario.status());
        JOptionPane.showMessageDialog(null, "" + personagemEscolhido.apresentacaoPersonagens());

        boolean sair = false;
        while (!sair) {

            String opcao = JOptionPane.showInputDialog(null,"        => MENU <=" +
                    "\n\n[ 1 ] - Sinopse" +
                    "\n[ 2 ] - Personagem" +
                    "\n[ 3 ] - Jogar" +
                    "\n[ 4 ] - Vitorias e Derrotas" +
                    "\n[ 5 } - Atributos" +
                    "\n[ 6 ] - Ataques especiais" +
                    "\n[ 7 ] - Torneio" +
                    "\n[ 8 ] - Sair\n\n","RPG CRAZY-FIGHT",JOptionPane.INFORMATION_MESSAGE);
            int opcaomenu = Integer.parseInt( opcao );
            switch (opcaomenu) {
                case 1: // Exibir Sinopse do Jogo
                    JOptionPane.showMessageDialog(null, "Sinopse\n\n" +
                            "Em um futuro distópico onde arenas substituíram os palcos de justiça, " +
                            "\no Crazy‑Fight convida os mais insanos e improváveis guerreiros para disputarem " +
                            "\nnão só honra, mas suas próprias malucas origens. Cada combate é uma tempestade " +
                            "\nde força, resiliência e estratégia — mas também de histórias pessoais que queimam " +
                            "\npor redenção, glória e, claro, pura insanidade.", "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE);

                    break;

                case 2: // Conhecer a história de cada personagem
                    int idx = Integer.parseInt(JOptionPane.showInputDialog(null, "Conheça a historia de cada personagem:" +
                            "\n\n[ 1 ] - Cabeçudo🫨" +
                            "\n[ 2 ] - Chico Machado🪓" +
                            "\n[ 3 ] - João Polvo🐙" +
                            "\n[ 4 ] - Pedro Tesoura✂️" +
                            "\n[ 5 ] - Tonho Couve-Flor🥬" +
                            "\n[ 6 ] - Zé Martelo🔨\n\n", "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE)) - 1;
                    Personagem selecionado = personagems[idx];
                    JOptionPane.showMessageDialog(null, selecionado.apresentacaoPersonagens());

                    break;

                case 3: // Iniciar o Jogo
                    //Escolha do primeiro personagem
                    String personagem1 = JOptionPane.showInputDialog(null, "        => Escolha os Lutadores <=" +
                            "\n\n[ 1 ] - Cabeçudo🫨" +
                            "\n[ 2 ] - Chico Machado🪓" +
                            "\n[ 3 ] - João Polvo🐙" +
                            "\n[ 4 ] - Pedro Tesoura✂️" +
                            "\n[ 5 ] - Tonho Couve-Flor🥬" +
                            "\n[ 6 ] - Zé Martelo🔨\n\n" +
                            "Play 1 => ", "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE);
                    if (personagem1 == null) return;
                    int person1 = Integer.parseInt(personagem1) - 1;

                    //Escolha do segundo personagem
                    String personagem2 = JOptionPane.showInputDialog(null, "        => Escolha os Lutadores <=" +
                            "\n\n[ 1 ] - Cabeçudo🫨" +
                            "\n[ 2 ] - Chico Machado🪓" +
                            "\n[ 3 ] - João Polvo🐙" +
                            "\n[ 4 ] - Pedro Tesoura✂️" +
                            "\n[ 5 ] - Tonho Couve-Flor🥬" +
                            "\n[ 6 ] - Zé Martelo🔨\n\n" +
                            "Play 2 => ", "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE);
                    if (personagem2 == null) return;
                    int person2 = Integer.parseInt(personagem2) - 1;

                    Confronto.lutar(personagems[person1], personagems[person2]);

                    break;

                case 4: // Exibir Estatísticas de um Lutador específico
                    String[] nomes = new String[personagems.length];
                    for (int i = 0; i < personagems.length; i++) {
                        nomes[i] = personagems[i].getNome();
                    }

                    String historico = (String) JOptionPane.showInputDialog(
                            null,
                            "Escolha o personagem para ver o histórico de lutas:",
                            "RPG CRAZY-FIGHT",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            nomes,
                            nomes[0]
                    );

                    if (escolha != null) {
                        for (int i = 0; i < personagems.length; i++) {
                            if (personagems[i].getNome().equals(escolha)) {
                                String status = "📊 ESTATÍSTICAS DE " + personagems[i].getNome() + " 📊\n\n" +
                                        "🏆 Vitórias: " + personagems[i].getVitorias() + "\n" +
                                        "❌ Derrotas: " + personagems[i].getDerrotas();
                                JOptionPane.showMessageDialog(null, status, "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }
                    }
                    break;

                case 5:
                    int ix = Integer.parseInt(JOptionPane.showInputDialog(null, "Conheça a vida e o poder de ataque de cada lutador:" +
                            "\n\n[ 1 ] - Cabeçudo🫨" +
                            "\n[ 2 ] - Chico Machado🪓" +
                            "\n[ 3 ] - João Polvo🐙" +
                            "\n[ 4 ] - Pedro Tesoura✂️" +
                            "\n[ 5 ] - Tonho Couve-Flor🥬" +
                            "\n[ 6 ] - Zé Martelo🔨\n\n", "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE)) - 1;
                    Personagem selecionadoo = personagems[ix];
                    JOptionPane.showMessageDialog(null, "A vida do lutador é: " + selecionadoo.getVida());
                    JOptionPane.showMessageDialog(null, "O poder de ataque do lutador : " + selecionadoo.getAtaque());
                    break;

                case  6:
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Conheça o ataque especial de cada personagem:" +
                            "\n\n[ 1 ] - Cabeçudo🫨" +
                            "\n[ 2 ] - Chico Machado🪓" +
                            "\n[ 3 ] - João Polvo🐙" +
                            "\n[ 4 ] - Pedro Tesoura✂️" +
                            "\n[ 5 ] - Tonho Couve-Flor🥬" +
                            "\n[ 6 ] - Zé Martelo🔨\n\n", "RPG CRAZY-FIGHT", JOptionPane.INFORMATION_MESSAGE)) - 1;
                    Personagem selecionad = personagems[id];
                    JOptionPane.showMessageDialog(null, "O dano do especial do lutador é " +
                            ": " + selecionad.getEspecial());
                    break;

                case 7:
                    Torneio torneio = new Torneio(usuario, personagems);
                    torneio.iniciar();
                    break;


                case 8:
                    JOptionPane.showMessageDialog(null,"       Obrigado por jogar o Crazy‑Fight!\n\n " +
                                    "☠️ Crazy‑Fight — onde a loucura faz parte das regras!! ☠️",
                            "RPG CRAZY-FIGHT",JOptionPane.INFORMATION_MESSAGE);
                    sair = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "🚫 Opção inválida!! 🚫","RPG CRAZY-FIGHT",JOptionPane.INFORMATION_MESSAGE);
                    break;

               }
        }
    }
}
