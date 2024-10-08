/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vortex_store;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author vinic
 */
public class NewClass extends JFrame {
    
       public NewClass() {
        // Criação de um painel principal com layout de caixa vertical (BoxLayout)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Disposição vertical

        // Array com as informações para cada painel
        String[] informacoes = {"Painel 1", "Painel 2", "Painel 3", "Painel 4", "Painel 5"};

        // Criação dinâmica de painéis com base nas informações do array
        for (String info : informacoes) {
            JPanel panel = criarPainel(info); // Método para criar e configurar cada painel
            mainPanel.add(panel); // Adiciona o painel ao painel principal
            mainPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre painéis
        }

        // Configurações do JFrame
        add(new JScrollPane(mainPanel)); // Adiciona o painel principal ao JFrame com rolagem
        setTitle("Exemplo de Painéis Dinâmicos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Método para criar um novo JPanel com base em um texto
    private JPanel criarPainel(String texto) {
        JPanel panel = new JPanel(); // Novo painel
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Bordas para visualização
        panel.add(new JLabel(texto)); // Adiciona um JLabel com o texto fornecido
        panel.setPreferredSize(new Dimension(300, 50)); // Define tamanho preferencial
        return panel;
    }

    public static void main(String[] args) {
        new NewClass();
    }
    
}
