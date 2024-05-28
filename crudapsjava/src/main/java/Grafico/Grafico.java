
//classe responsável por criar o gráfico
package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafico extends JPanel {
    private double[][] percentagensDeEmissao;
    private Color[] coresDasBarras;
    private int semestreAtual;
    private final String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    public Grafico(double[][] percentagensDeEmissao) {
        this.percentagensDeEmissao = percentagensDeEmissao;
        this.coresDasBarras = gerarCoresDasBarras(percentagensDeEmissao[0].length);
        this.semestreAtual = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int largura = getWidth();
        int altura = getHeight();
        int numMeses = percentagensDeEmissao[semestreAtual].length;
        int larguraDaBarra = largura / numMeses;

        double porcentagemMaxima = 0;
        for (double porcentagem : percentagensDeEmissao[semestreAtual]) {
            if (porcentagem > porcentagemMaxima) {
                porcentagemMaxima = porcentagem;
            }
        }

        for (int i = 0; i < numMeses; i++) {
            int alturaDaBarra = (int) ((percentagensDeEmissao[semestreAtual][i] / porcentagemMaxima) * altura);
            int x = i * larguraDaBarra;
            int y = altura - alturaDaBarra;
            g2d.setColor(coresDasBarras[i]);
            g2d.fillRect(x, y, larguraDaBarra, alturaDaBarra);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, larguraDaBarra, alturaDaBarra);

            String nomeDoMes = meses[i];
            FontMetrics fm = g2d.getFontMetrics();
            int larguraDoTexto = fm.stringWidth(nomeDoMes);
            int alturaDoTexto = fm.getHeight();
            int xTexto = x + (larguraDaBarra - larguraDoTexto) / 2;
            int yTexto = y + (alturaDaBarra - alturaDoTexto) / 2 + fm.getAscent();
            g2d.drawString(nomeDoMes, xTexto, yTexto);

            // Adicionando os números às barras
            String porcentagemString = String.format("%.1f%%", percentagensDeEmissao[semestreAtual][i]);
            int larguraDoTextoPorcentagem = fm.stringWidth(porcentagemString);
            g2d.drawString(porcentagemString, x + (larguraDaBarra - larguraDoTextoPorcentagem) / 2, y - 5);
        }
    }

    private Color[] gerarCoresDasBarras(int numBarras) {
        Color[] cores = new Color[numBarras];
        float incrementoDeMatiz = 1.0f / numBarras;
        for (int i = 0; i < numBarras; i++) {
            cores[i] = Color.getHSBColor(i * incrementoDeMatiz, 0.7f, 0.9f);
        }
        return cores;
    }

    public static void main(String[] args) {
        double[][] percentagensDeEmissao = {
                {10.5, 12.3, 15.2, 14.6, 13.8, 16.5, 10.2, 11.5, 13.2, 14.1, 12.8, 15.3},
                {17.2, 18.4, 19.6, 21.3, 20.7, 22.1, 16.8, 18.2, 19.9, 21.7, 20.5, 22.8}
        };

        JFrame frame = new JFrame("Gráfico de Barras de Emissão de CO2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grafico graficoDeBarras = new Grafico(percentagensDeEmissao);
        frame.add(graficoDeBarras, BorderLayout.CENTER);

        JComboBox<String> comboBoxSemestre = new JComboBox<>(new String[]{"Semestre 1", "Semestre 2"});
        comboBoxSemestre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graficoDeBarras.semestreAtual = comboBoxSemestre.getSelectedIndex();
                graficoDeBarras.repaint();
            }
        });
        frame.add(comboBoxSemestre, BorderLayout.NORTH);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
