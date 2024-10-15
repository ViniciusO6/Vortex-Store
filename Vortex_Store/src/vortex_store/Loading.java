/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vortex_store;

/**
 *
 * @author Vinicius
 */

import vortex_store.Error;
import conexao.Conexao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Loading extends javax.swing.JFrame {

  Conexao con_cliente;
  Error erro;
  
    public Loading() {
        setUndecorated(true);
        initComponents();
        // Define a cor personalizada após a inicialização dos componentes
        jProgressBar1.setUI(new javax.swing.plaf.basic.BasicProgressBarUI());
        jProgressBar1.setForeground(new Color(143,101,189));  
        jProgressBar1.setBackground(new Color (217,217,217));
        setLocationRelativeTo(null);
        con_cliente = new Conexao();  
        
        sVGImage1.setSvgImage("imagens/RostoFalha.svg", 100, 100);
        sVGImage1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    
        if(con_cliente.conecta(true) == false){   
            
            jDialog1.setLocationRelativeTo(null);
            jDialog1.setModal(true);
            jDialog1.setVisible(true);
       
        }
        
        
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/logos/VortexIcon3.png"));
        setIconImage(icon.getImage());
    }
    

    
    public void MetodoCarregar(){
    
        new CarregamentoWorker().execute();
    
    
    }
    
     // Classe interna que herda SwingWorker para gerenciar o carregamento
    private class CarregamentoWorker extends SwingWorker<Void, Integer> {
        // Método que contém o código a ser executado em segundo plano
        @Override
        protected Void doInBackground() throws Exception {
            // Simulação de estágios do processo de carregamento (isso seria substituído pelas operações reais)
            for (int i = 0; i <= 100; i++) {
                // Pausa de 100ms para simular o tempo necessário para carregar cada etapa
                Thread.sleep(100);
                
                // Envia o valor atual de progresso para o método process()
                publish(i);
            }
            return null;
        }
    
        
    
        // Método chamado a cada vez que o progresso é atualizado
        @Override
        protected void process(java.util.List<Integer> chunks) {
            // Pega o último valor de progresso
            int progresso = chunks.get(chunks.size() - 1);
            boolean Erro = false;
            
            // Atualiza o valor da barra de progresso
            if(Erro == false){
              jProgressBar1.setValue(progresso);  
            }
            

            
            // Atualiza a mensagem com base no valor do progresso e executa as verificações 
            
            if(progresso == 1){
                //Estabelece a conexão com o banco de dados, caso não seja  estabelecida o programa é encerradi

            }
            if (progresso == 30) {
                Mensagens.setText("Carregando recursos...");

            } else if (progresso == 60) {
                Mensagens.setText("Inicializando módulos...");
            } else if (progresso == 90) {
                Mensagens.setText("Finalizando...");
            } else if(progresso > 90){
                Mensagens.setText("Concluído!");
            }
        }

        // Método chamado quando o carregamento termina
        @Override
        protected void done() {
            // Fecha a tela de carregamento
            AbrirTela();
            
            // Aqui você pode abrir a janela principal do seu programa
           
        }
    }
    
    
    private void AbrirTela() {
        // Gradualmente reduz a opacidade da janela
        new Thread(() -> {
            try {
                for (float i = 1.0f; i > 0.0f; i -= 0.05f) {
                    setOpacity(i);  // Reduz a opacidade da janela
                    Thread.sleep(2); // Aguarda 50ms para criar o efeito de transição suave
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Login Login = new Login();
            Login.setVisible(true);
            setVisible(false);
        }).start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sVGImage1 = new imagens.SVGImage();
        button1 = new com.raven.swing.Button();
        button2 = new com.raven.swing.Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        Mensagens = new javax.swing.JLabel();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setMinimumSize(new java.awt.Dimension(480, 300));
        jDialog1.setUndecorated(true);
        jDialog1.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(27, 30, 43));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Falha na Conexão");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Não foi possível se conectar ao Servidor");

        button1.setBackground(new java.awt.Color(76, 31, 129));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Tentar Novamente");
        button1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1MouseExited(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(222, 0, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Fechar");
        button2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button2MouseExited(evt);
            }
        });
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(480, 300));

        jPanel1.setBackground(new java.awt.Color(27, 30, 43));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/VortexLogo.png"))); // NOI18N

        jProgressBar1.setBackground(new java.awt.Color(217, 217, 217));
        jProgressBar1.setForeground(new java.awt.Color(51, 51, 255));
        jProgressBar1.setBorder(null);
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        Mensagens.setForeground(new java.awt.Color(217, 217, 217));
        Mensagens.setText("Inicializando...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Mensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseEntered
        button1.setBackground(new Color(59, 32, 91));
    }//GEN-LAST:event_button1MouseEntered

    private void button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseExited
        button1.setBackground(new Color(76,31,129) );
    }//GEN-LAST:event_button1MouseExited

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        jDialog1.dispose();
                
            if(con_cliente.conecta(false) == false){   
                jDialog1.setLocationRelativeTo(null);
                jDialog1.setModal(true);
                jDialog1.setVisible(true);
            }
                         
                 
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button2ActionPerformed

    private void button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseEntered
       button2.setBackground(new Color(150, 0, 0));
    }//GEN-LAST:event_button2MouseEntered

    private void button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseExited
       button2.setBackground(new Color(222,0,0));
    }//GEN-LAST:event_button2MouseExited

    /**
     * @param args the command line arguments
     */
    
      public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         SwingUtilities.invokeLater(() -> {
            Loading telaDeCarregamento = new Loading();
            telaDeCarregamento.setVisible(true);
            telaDeCarregamento.MetodoCarregar();
        });
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mensagens;
    private com.raven.swing.Button button1;
    private com.raven.swing.Button button2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private imagens.SVGImage sVGImage1;
    // End of variables declaration//GEN-END:variables
}
