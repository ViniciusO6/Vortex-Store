/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vortex_store;

import conexao.Conexao;
import Buckup.*;
import vortex_store.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar; 
import scrollbar.ScrollBarCustom;
/**
 *
 * @author vinic
 */

public class TelaPrincipal extends javax.swing.JFrame {
    Conexao conexao;   
    int offset = -20;
    int[] ID_CARD = new int[20] ;
    int ID_BUSCAR;
    int linhas = 0;
    boolean MaisJogos;
    int avancou = 0;

     ScrollBarCustom scrollBarCustom = new  ScrollBarCustom();
    public TelaPrincipal() {
        conexao = new Conexao(); 
        conexao.conecta(false);
        initComponents();
        btnVoltar.setVisible(false);
        btnAvancar.setVisible(false);
        CarregarJogos(false, false);
        scrollBarCustom.imprimir();

        
        
        
        
        //Configuração da tela rolavel, a ScrollBar de todas as telas
        
        // Tela da Biblioteca
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(30);//rolagem rapida
        this.setLocationRelativeTo(null);//janela no meio da tela
        simpleTitleBar1.init(this);
        getContentPane().setBackground(Color.BLACK);
        
        //Tela de meus jogos
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        this.jScrollPane2.getVerticalScrollBar().setUnitIncrement(30);//rolagem rapida
        this.setLocationRelativeTo(null);//janela no meio da tela
        simpleTitleBar1.init(this);
        getContentPane().setBackground(Color.BLACK);
        
        
        
        
        //Setando icone
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/logos/VortexIcon3.png"));
        setIconImage(icon.getImage());
        
        sVGImage2.setSvgImage("imagens/icones/lupa.svg", 20, 20);
        sVGImage2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage1.setSvgImage("imagens/icones/sacola.svg", 35, 35);
        sVGImage1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage8.setSvgImage("imagens/icones/seta-esquerda.svg", 35, 35);
        sVGImage8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        
        sVGImage3.setSvgImage("imagens/icones/biblioteca.svg", 35, 35);
        sVGImage3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage4.setSvgImage("imagens/icones/seta-direita.svg", 35, 35);
        sVGImage4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage5.setSvgImage("imagens/icones/carrinho.svg", 35, 35);
        sVGImage5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage6.setSvgImage("imagens/icones/profile.svg", 50, 50);
        sVGImage6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ocultoPanel = new javax.swing.JPanel();
        OcultoText = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelCard1 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        ImgCard1 = new javax.swing.JLabel();
        TextCard1 = new javax.swing.JLabel();
        PanelCard2 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        ImgCard2 = new javax.swing.JLabel();
        TextCard2 = new javax.swing.JLabel();
        PanelCard5 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        ImgCard5 = new javax.swing.JLabel();
        TextCard5 = new javax.swing.JLabel();
        PanelCard3 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        ImgCard3 = new javax.swing.JLabel();
        TextCard3 = new javax.swing.JLabel();
        PanelCard4 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        ImgCard4 = new javax.swing.JLabel();
        TextCard4 = new javax.swing.JLabel();
        PanelCard6 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        ImgCard6 = new javax.swing.JLabel();
        TextCard6 = new javax.swing.JLabel();
        PanelCard7 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        ImgCard7 = new javax.swing.JLabel();
        TextCard7 = new javax.swing.JLabel();
        PanelCard8 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        ImgCard8 = new javax.swing.JLabel();
        TextCard8 = new javax.swing.JLabel();
        PanelCard9 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        ImgCard9 = new javax.swing.JLabel();
        TextCard9 = new javax.swing.JLabel();
        PanelCard10 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        ImgCard10 = new javax.swing.JLabel();
        TextCard10 = new javax.swing.JLabel();
        PanelCard15 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        ImgCard15 = new javax.swing.JLabel();
        TextCard15 = new javax.swing.JLabel();
        PanelCard13 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        ImgCard13 = new javax.swing.JLabel();
        TextCard13 = new javax.swing.JLabel();
        PanelCard11 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        ImgCard11 = new javax.swing.JLabel();
        TextCard11 = new javax.swing.JLabel();
        PanelCard14 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        ImgCard14 = new javax.swing.JLabel();
        TextCard14 = new javax.swing.JLabel();
        PanelCard12 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        ImgCard12 = new javax.swing.JLabel();
        TextCard12 = new javax.swing.JLabel();
        PanelCard16 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        ImgCard16 = new javax.swing.JLabel();
        TextCard16 = new javax.swing.JLabel();
        PanelCard17 = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        ImgCard17 = new javax.swing.JLabel();
        TextCard17 = new javax.swing.JLabel();
        PanelCard18 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        ImgCard18 = new javax.swing.JLabel();
        TextCard18 = new javax.swing.JLabel();
        PanelCard19 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        ImgCard19 = new javax.swing.JLabel();
        TextCard19 = new javax.swing.JLabel();
        PanelCard20 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        ImgCard20 = new javax.swing.JLabel();
        TextCard20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        sVGImage8 = new imagens.SVGImage();
        btnAvancar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sVGImage4 = new imagens.SVGImage();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        sVGImage2 = new imagens.SVGImage();
        jPanel4 = new javax.swing.JPanel();
        sVGImage1 = new imagens.SVGImage();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        sVGImage3 = new imagens.SVGImage();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        sVGImage5 = new imagens.SVGImage();
        jLabel5 = new javax.swing.JLabel();
        sVGImage6 = new imagens.SVGImage();
        simpleTitleBar1 = new javaswingdev.SimpleTitleBar();

        javax.swing.GroupLayout ocultoPanelLayout = new javax.swing.GroupLayout(ocultoPanel);
        ocultoPanel.setLayout(ocultoPanelLayout);
        ocultoPanelLayout.setHorizontalGroup(
            ocultoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        ocultoPanelLayout.setVerticalGroup(
            ocultoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        OcultoText.setText("jLabel11");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(10, 15, 22));

        jPanel8.setBackground(new java.awt.Color(10, 15, 22));

        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("2");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(jLabel7)
                .addContainerGap(870, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel7)
                .addContainerGap(390, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel8);

        jPanel9.setBackground(new java.awt.Color(10, 15, 22));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel6.setBackground(new java.awt.Color(18, 22, 32));
        jPanel6.setMaximumSize(new java.awt.Dimension(1263, 1560));
        jPanel6.setMinimumSize(new java.awt.Dimension(1263, 1560));
        jPanel6.setPreferredSize(new java.awt.Dimension(1263, 1560));

        jLabel4.setBackground(new java.awt.Color(76, 31, 129));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Biblioteca");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        PanelCard1.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(ImgCard1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(ImgCard1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard1.setForeground(new java.awt.Color(255, 255, 255));
        TextCard1.setText("Nome do Jogo");
        TextCard1.setToolTipText("");
        TextCard1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard1.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard1Layout = new javax.swing.GroupLayout(PanelCard1);
        PanelCard1.setLayout(PanelCard1Layout);
        PanelCard1Layout.setHorizontalGroup(
            PanelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard1Layout.createSequentialGroup()
                .addGroup(PanelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard1Layout.setVerticalGroup(
            PanelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard1Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard2.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(ImgCard2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(ImgCard2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard2.setForeground(new java.awt.Color(255, 255, 255));
        TextCard2.setText("Nome do Jogo");
        TextCard2.setToolTipText("");
        TextCard2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard2.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard2Layout = new javax.swing.GroupLayout(PanelCard2);
        PanelCard2.setLayout(PanelCard2Layout);
        PanelCard2Layout.setHorizontalGroup(
            PanelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard2Layout.createSequentialGroup()
                .addGroup(PanelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard2Layout.setVerticalGroup(
            PanelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard2Layout.createSequentialGroup()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard5.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(ImgCard5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(ImgCard5)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard5.setForeground(new java.awt.Color(255, 255, 255));
        TextCard5.setText("Nome do Jogo");
        TextCard5.setToolTipText("");
        TextCard5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard5.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard5Layout = new javax.swing.GroupLayout(PanelCard5);
        PanelCard5.setLayout(PanelCard5Layout);
        PanelCard5Layout.setHorizontalGroup(
            PanelCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard5Layout.createSequentialGroup()
                .addGroup(PanelCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard5Layout.setVerticalGroup(
            PanelCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard5Layout.createSequentialGroup()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard3.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(ImgCard3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(ImgCard3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard3.setForeground(new java.awt.Color(255, 255, 255));
        TextCard3.setText("Nome do Jogo");
        TextCard3.setToolTipText("");
        TextCard3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard3.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard3Layout = new javax.swing.GroupLayout(PanelCard3);
        PanelCard3.setLayout(PanelCard3Layout);
        PanelCard3Layout.setHorizontalGroup(
            PanelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard3Layout.createSequentialGroup()
                .addGroup(PanelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard3Layout.setVerticalGroup(
            PanelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard3Layout.createSequentialGroup()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard4.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(ImgCard4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(ImgCard4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard4.setForeground(new java.awt.Color(255, 255, 255));
        TextCard4.setText("Nome do Jogo");
        TextCard4.setToolTipText("");
        TextCard4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard4.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard4Layout = new javax.swing.GroupLayout(PanelCard4);
        PanelCard4.setLayout(PanelCard4Layout);
        PanelCard4Layout.setHorizontalGroup(
            PanelCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard4Layout.createSequentialGroup()
                .addGroup(PanelCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard4Layout.setVerticalGroup(
            PanelCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard4Layout.createSequentialGroup()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard6.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(ImgCard6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(ImgCard6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard6.setForeground(new java.awt.Color(255, 255, 255));
        TextCard6.setText("Nome do Jogo");
        TextCard6.setToolTipText("");
        TextCard6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard6.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard6Layout = new javax.swing.GroupLayout(PanelCard6);
        PanelCard6.setLayout(PanelCard6Layout);
        PanelCard6Layout.setHorizontalGroup(
            PanelCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard6Layout.createSequentialGroup()
                .addGroup(PanelCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard6Layout.setVerticalGroup(
            PanelCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard6Layout.createSequentialGroup()
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard7.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(ImgCard7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(ImgCard7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard7.setForeground(new java.awt.Color(255, 255, 255));
        TextCard7.setText("Nome do Jogo");
        TextCard7.setToolTipText("");
        TextCard7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard7.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard7Layout = new javax.swing.GroupLayout(PanelCard7);
        PanelCard7.setLayout(PanelCard7Layout);
        PanelCard7Layout.setHorizontalGroup(
            PanelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard7Layout.createSequentialGroup()
                .addGroup(PanelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard7Layout.setVerticalGroup(
            PanelCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard7Layout.createSequentialGroup()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard8.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(ImgCard8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(ImgCard8)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard8.setForeground(new java.awt.Color(255, 255, 255));
        TextCard8.setText("Nome do Jogo");
        TextCard8.setToolTipText("");
        TextCard8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard8.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard8Layout = new javax.swing.GroupLayout(PanelCard8);
        PanelCard8.setLayout(PanelCard8Layout);
        PanelCard8Layout.setHorizontalGroup(
            PanelCard8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard8Layout.createSequentialGroup()
                .addGroup(PanelCard8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard8Layout.setVerticalGroup(
            PanelCard8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard8Layout.createSequentialGroup()
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard9.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(ImgCard9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(ImgCard9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard9.setForeground(new java.awt.Color(255, 255, 255));
        TextCard9.setText("Nome do Jogo");
        TextCard9.setToolTipText("");
        TextCard9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard9.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard9Layout = new javax.swing.GroupLayout(PanelCard9);
        PanelCard9.setLayout(PanelCard9Layout);
        PanelCard9Layout.setHorizontalGroup(
            PanelCard9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard9Layout.createSequentialGroup()
                .addGroup(PanelCard9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard9Layout.setVerticalGroup(
            PanelCard9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard9Layout.createSequentialGroup()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard10.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(ImgCard10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(ImgCard10)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard10.setForeground(new java.awt.Color(255, 255, 255));
        TextCard10.setText("Nome do Jogo");
        TextCard10.setToolTipText("");
        TextCard10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard10.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard10Layout = new javax.swing.GroupLayout(PanelCard10);
        PanelCard10.setLayout(PanelCard10Layout);
        PanelCard10Layout.setHorizontalGroup(
            PanelCard10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard10Layout.createSequentialGroup()
                .addGroup(PanelCard10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard10Layout.setVerticalGroup(
            PanelCard10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard10Layout.createSequentialGroup()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard15.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addComponent(ImgCard15)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addComponent(ImgCard15)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard15.setForeground(new java.awt.Color(255, 255, 255));
        TextCard15.setText("Nome do Jogo");
        TextCard15.setToolTipText("");
        TextCard15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard15.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard15Layout = new javax.swing.GroupLayout(PanelCard15);
        PanelCard15.setLayout(PanelCard15Layout);
        PanelCard15Layout.setHorizontalGroup(
            PanelCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard15Layout.createSequentialGroup()
                .addGroup(PanelCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard15, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard15Layout.setVerticalGroup(
            PanelCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard15Layout.createSequentialGroup()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard13.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(ImgCard13)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(ImgCard13)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard13.setForeground(new java.awt.Color(255, 255, 255));
        TextCard13.setText("Nome do Jogo");
        TextCard13.setToolTipText("");
        TextCard13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard13.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard13Layout = new javax.swing.GroupLayout(PanelCard13);
        PanelCard13.setLayout(PanelCard13Layout);
        PanelCard13Layout.setHorizontalGroup(
            PanelCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard13Layout.createSequentialGroup()
                .addGroup(PanelCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard13Layout.setVerticalGroup(
            PanelCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard13Layout.createSequentialGroup()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard11.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addComponent(ImgCard11)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addComponent(ImgCard11)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard11.setForeground(new java.awt.Color(255, 255, 255));
        TextCard11.setText("Nome do Jogo");
        TextCard11.setToolTipText("");
        TextCard11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard11.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard11Layout = new javax.swing.GroupLayout(PanelCard11);
        PanelCard11.setLayout(PanelCard11Layout);
        PanelCard11Layout.setHorizontalGroup(
            PanelCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard11Layout.createSequentialGroup()
                .addGroup(PanelCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard11, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard11Layout.setVerticalGroup(
            PanelCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard11Layout.createSequentialGroup()
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard14.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addComponent(ImgCard14)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addComponent(ImgCard14)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard14.setForeground(new java.awt.Color(255, 255, 255));
        TextCard14.setText("Nome do Jogo");
        TextCard14.setToolTipText("");
        TextCard14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard14.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard14Layout = new javax.swing.GroupLayout(PanelCard14);
        PanelCard14.setLayout(PanelCard14Layout);
        PanelCard14Layout.setHorizontalGroup(
            PanelCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard14Layout.createSequentialGroup()
                .addGroup(PanelCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard14, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard14Layout.setVerticalGroup(
            PanelCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard14Layout.createSequentialGroup()
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard12.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addComponent(ImgCard12)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addComponent(ImgCard12)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard12.setForeground(new java.awt.Color(255, 255, 255));
        TextCard12.setText("Nome do Jogo");
        TextCard12.setToolTipText("");
        TextCard12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard12.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard12Layout = new javax.swing.GroupLayout(PanelCard12);
        PanelCard12.setLayout(PanelCard12Layout);
        PanelCard12Layout.setHorizontalGroup(
            PanelCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard12Layout.createSequentialGroup()
                .addGroup(PanelCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard12Layout.setVerticalGroup(
            PanelCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard12Layout.createSequentialGroup()
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard16.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addComponent(ImgCard16)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addComponent(ImgCard16)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard16.setForeground(new java.awt.Color(255, 255, 255));
        TextCard16.setText("Nome do Jogo");
        TextCard16.setToolTipText("");
        TextCard16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard16.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard16Layout = new javax.swing.GroupLayout(PanelCard16);
        PanelCard16.setLayout(PanelCard16Layout);
        PanelCard16Layout.setHorizontalGroup(
            PanelCard16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard16Layout.createSequentialGroup()
                .addGroup(PanelCard16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard16, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard16Layout.setVerticalGroup(
            PanelCard16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard16Layout.createSequentialGroup()
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard17.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addComponent(ImgCard17)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addComponent(ImgCard17)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard17.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard17.setForeground(new java.awt.Color(255, 255, 255));
        TextCard17.setText("Nome do Jogo");
        TextCard17.setToolTipText("");
        TextCard17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard17.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard17Layout = new javax.swing.GroupLayout(PanelCard17);
        PanelCard17.setLayout(PanelCard17Layout);
        PanelCard17Layout.setHorizontalGroup(
            PanelCard17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard17Layout.createSequentialGroup()
                .addGroup(PanelCard17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard17, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard17Layout.setVerticalGroup(
            PanelCard17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard17Layout.createSequentialGroup()
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard18.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addComponent(ImgCard18)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addComponent(ImgCard18)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard18.setForeground(new java.awt.Color(255, 255, 255));
        TextCard18.setText("Nome do Jogo");
        TextCard18.setToolTipText("");
        TextCard18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard18.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard18Layout = new javax.swing.GroupLayout(PanelCard18);
        PanelCard18.setLayout(PanelCard18Layout);
        PanelCard18Layout.setHorizontalGroup(
            PanelCard18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard18Layout.createSequentialGroup()
                .addGroup(PanelCard18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard18, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard18Layout.setVerticalGroup(
            PanelCard18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard18Layout.createSequentialGroup()
                .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard19.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addComponent(ImgCard19)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addComponent(ImgCard19)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard19.setForeground(new java.awt.Color(255, 255, 255));
        TextCard19.setText("Nome do Jogo");
        TextCard19.setToolTipText("");
        TextCard19.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard19.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard19Layout = new javax.swing.GroupLayout(PanelCard19);
        PanelCard19.setLayout(PanelCard19Layout);
        PanelCard19Layout.setHorizontalGroup(
            PanelCard19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard19Layout.createSequentialGroup()
                .addGroup(PanelCard19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard19, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard19Layout.setVerticalGroup(
            PanelCard19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard19Layout.createSequentialGroup()
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard20.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(ImgCard20)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(ImgCard20)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard20.setForeground(new java.awt.Color(255, 255, 255));
        TextCard20.setText("Nome do Jogo");
        TextCard20.setToolTipText("");
        TextCard20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard20.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard20Layout = new javax.swing.GroupLayout(PanelCard20);
        PanelCard20.setLayout(PanelCard20Layout);
        PanelCard20Layout.setHorizontalGroup(
            PanelCard20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard20Layout.createSequentialGroup()
                .addGroup(PanelCard20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard20, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard20Layout.setVerticalGroup(
            PanelCard20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard20Layout.createSequentialGroup()
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel11.setOpaque(false);

        btnVoltar.setBackground(new java.awt.Color(59, 32, 91));
        btnVoltar.setMaximumSize(new java.awt.Dimension(212, 39));
        btnVoltar.setMinimumSize(new java.awt.Dimension(212, 39));
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Página Anterior");

        javax.swing.GroupLayout btnVoltarLayout = new javax.swing.GroupLayout(btnVoltar);
        btnVoltar.setLayout(btnVoltarLayout);
        btnVoltarLayout.setHorizontalGroup(
            btnVoltarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVoltarLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(sVGImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addGap(18, 18, 18))
        );
        btnVoltarLayout.setVerticalGroup(
            btnVoltarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGImage8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
            .addGroup(btnVoltarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.add(btnVoltar);

        btnAvancar.setBackground(new java.awt.Color(59, 32, 91));
        btnAvancar.setMaximumSize(new java.awt.Dimension(212, 39));
        btnAvancar.setMinimumSize(new java.awt.Dimension(212, 39));
        btnAvancar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAvancarMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Próxima Página");

        javax.swing.GroupLayout btnAvancarLayout = new javax.swing.GroupLayout(btnAvancar);
        btnAvancar.setLayout(btnAvancarLayout);
        btnAvancarLayout.setHorizontalGroup(
            btnAvancarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAvancarLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sVGImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        btnAvancarLayout.setVerticalGroup(
            btnAvancarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAvancarLayout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(9, 9, 9))
            .addComponent(sVGImage4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.add(btnAvancar);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PanelCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(PanelCard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(76, 76, 76))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(PanelCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(PanelCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PanelCard16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelCard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel9);

        jPanel10.setBackground(new java.awt.Color(10, 15, 22));

        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("3");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(jLabel8)
                .addContainerGap(870, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel8)
                .addContainerGap(390, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel10);

        jPanel2.setBackground(new java.awt.Color(82, 43, 136));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/VortexPhotoshop.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(127, 55, 212));

        sVGImage2.setMaximumSize(new java.awt.Dimension(25, 25));
        sVGImage2.setMinimumSize(new java.awt.Dimension(25, 25));
        sVGImage2.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(sVGImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(82, 43, 136));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        sVGImage1.setMaximumSize(new java.awt.Dimension(30, 33));
        sVGImage1.setMinimumSize(new java.awt.Dimension(30, 33));
        sVGImage1.setPreferredSize(new java.awt.Dimension(30, 33));
        sVGImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Loja");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2))
            .addComponent(sVGImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(82, 43, 136));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        sVGImage3.setMaximumSize(new java.awt.Dimension(30, 33));
        sVGImage3.setMinimumSize(new java.awt.Dimension(30, 33));
        sVGImage3.setPreferredSize(new java.awt.Dimension(30, 33));
        sVGImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Biblioteca");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3))
            .addComponent(sVGImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBackground(new java.awt.Color(82, 43, 136));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        sVGImage5.setMaximumSize(new java.awt.Dimension(30, 33));
        sVGImage5.setMinimumSize(new java.awt.Dimension(30, 33));
        sVGImage5.setPreferredSize(new java.awt.Dimension(30, 33));
        sVGImage5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage5MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Carrinho");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(sVGImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sVGImage6.setMaximumSize(new java.awt.Dimension(30, 33));
        sVGImage6.setMinimumSize(new java.awt.Dimension(30, 33));
        sVGImage6.setPreferredSize(new java.awt.Dimension(30, 33));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sVGImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simpleTitleBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(simpleTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void sVGImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage1MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_sVGImage1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void sVGImage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage3MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_sVGImage3MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void sVGImage5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage5MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_sVGImage5MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    CarregarJogos(false, true);
    }//GEN-LAST:event_jLabel4MouseClicked

    
    // Mouse click dos Cards, direciona o usuario para parte de compra do jogo
    private void ImgCard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard1MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[0];
    }//GEN-LAST:event_ImgCard1MouseClicked

    private void ImgCard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard2MouseClicked

    private void ImgCard5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard5MouseClicked

    private void ImgCard3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard3MouseClicked

    private void ImgCard4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard4MouseClicked

    private void ImgCard6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard6MouseClicked

    private void ImgCard7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard7MouseClicked

    private void ImgCard8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard8MouseClicked

    private void ImgCard9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard9MouseClicked

    private void ImgCard10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard10MouseClicked

    private void ImgCard15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard15MouseClicked

    private void ImgCard13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard13MouseClicked

    private void ImgCard11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard11MouseClicked

    private void ImgCard14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard14MouseClicked

    private void ImgCard12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard12MouseClicked

    private void ImgCard16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard16MouseClicked

    private void ImgCard17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard17MouseClicked

    private void ImgCard18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard18MouseClicked

    private void ImgCard19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard19MouseClicked

    private void ImgCard20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard20MouseClicked

    private void btnAvancarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancarMouseClicked
        avancou++;
        jScrollPane1.getViewport().setViewPosition(new Point(0, 0));
        btnVoltar.setVisible(true);
        CarregarJogos(false, false);
    }//GEN-LAST:event_btnAvancarMouseClicked

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        avancou--;
        jScrollPane1.getViewport().setViewPosition(new Point(0, 0));
        CarregarJogos(true, false);
    }//GEN-LAST:event_btnVoltarMouseClicked
    
    
    
    public void CarregarJogos(boolean voltou, boolean recarregar){  
            JPanel[] JPanel = {
            PanelCard1, PanelCard2, PanelCard3, PanelCard4, PanelCard5,
            PanelCard6, PanelCard7, PanelCard8, PanelCard9, PanelCard10,
            PanelCard11, PanelCard12, PanelCard13, PanelCard14, PanelCard15,
            PanelCard16, PanelCard17, PanelCard18, PanelCard19, PanelCard20, ocultoPanel
            };
            JLabel[] labels = {
            TextCard1, TextCard2, TextCard3, TextCard4, TextCard5, 
            TextCard6, TextCard7, TextCard8, TextCard9, TextCard10, 
            TextCard11, TextCard12, TextCard13, TextCard14, TextCard15, 
            TextCard16, TextCard17, TextCard18, TextCard19, TextCard20, OcultoText
            };
            JLabel[] ImgCard = {
            ImgCard1, ImgCard2, ImgCard3, ImgCard4, ImgCard5, 
            ImgCard6, ImgCard7, ImgCard8, ImgCard9, ImgCard10, 
            ImgCard11, ImgCard12, ImgCard13, ImgCard14, ImgCard15, 
            ImgCard16, ImgCard17, ImgCard18, ImgCard19, ImgCard20, jLabel9
            };
            int[] MargemLihas = {
            450, 450, 445, 410, 390
            };
            int Margem;
            
  
           ocultoPanel.setVisible(false);
           OcultoText.setVisible(false);
            for(int i = 0; i < 20; i++) {
                JPanel[i].setVisible(false);
             }
        
        try{
            int i = -1;
            if(recarregar == true){
              offset = offset;
            }
            else if(voltou == false){
              offset += 20; 
              System.out.println("Avançou");
            }else{
              offset -= 20;
                System.out.println("Voltou");
            }
            String pesquisa = "select ID_jogo, titulo_do_jogo, imagens_do_jogo from jogo  ORDER BY titulo_do_jogo ASC LIMIT 21 OFFSET " + offset + ";";


            
            conexao.executaSQL(pesquisa, false);
            String titulo_jogo;
            String URL_IMG;
            
            if(conexao.resultset.first()){
                do {               
                    i++;
                    switch(i){
                        case 0:
                           linhas = 1;
                           MaisJogos = false;
                           break;
                        case 5:
                           linhas = 2;
                           MaisJogos = false;
                           break;
                        case 10:
                           linhas = 3;
                           MaisJogos = false;
                           break;
                        case 15:
                            linhas = 4;
                            MaisJogos = false;
                            System.out.println("4");
                           break;
                        case 20:
                            MaisJogos = true;
                           break;
                    }
                    System.out.println("Rodou"+ i +" Vez");

                    titulo_jogo = ""+conexao.resultset.getString("titulo_do_jogo");
                    URL_IMG = ""+conexao.resultset.getString("imagens_do_jogo");
                    
                    URL imageUrl = new URL(URL_IMG);
                    // Carregar a imagem da URL
                    Image image = ImageIO.read(imageUrl);
                    
                    JPanel[i].setVisible(true);
                    labels[i].setText("<html>" + titulo_jogo + "</html>");      
                    ImgCard[i].setIcon(new ImageIcon(image));
                } while (conexao.resultset.next());
                    Margem = MargemLihas[linhas] * linhas;
                    System.out.println(Margem);
                    jPanel6.setPreferredSize(new Dimension(1263, Margem));
                    jPanel6.revalidate();
                    jPanel6.repaint(); 
                    if(MaisJogos == true){
                        btnAvancar.setVisible(true);
                        System.out.println("truou");           
                    }else{
                        btnAvancar.setVisible(false);
                        System.out.println("falsou");
                    }
                    if(avancou == 0){
                        btnVoltar.setVisible(false);
                        System.out.println("não pode mais voltar, voltou demais");
                    }
                        
                    

            }
            else{
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgCard1;
    private javax.swing.JLabel ImgCard10;
    private javax.swing.JLabel ImgCard11;
    private javax.swing.JLabel ImgCard12;
    private javax.swing.JLabel ImgCard13;
    private javax.swing.JLabel ImgCard14;
    private javax.swing.JLabel ImgCard15;
    private javax.swing.JLabel ImgCard16;
    private javax.swing.JLabel ImgCard17;
    private javax.swing.JLabel ImgCard18;
    private javax.swing.JLabel ImgCard19;
    private javax.swing.JLabel ImgCard2;
    private javax.swing.JLabel ImgCard20;
    private javax.swing.JLabel ImgCard3;
    private javax.swing.JLabel ImgCard4;
    private javax.swing.JLabel ImgCard5;
    private javax.swing.JLabel ImgCard6;
    private javax.swing.JLabel ImgCard7;
    private javax.swing.JLabel ImgCard8;
    private javax.swing.JLabel ImgCard9;
    private javax.swing.JLabel OcultoText;
    private javax.swing.JPanel PanelCard1;
    private javax.swing.JPanel PanelCard10;
    private javax.swing.JPanel PanelCard11;
    private javax.swing.JPanel PanelCard12;
    private javax.swing.JPanel PanelCard13;
    private javax.swing.JPanel PanelCard14;
    private javax.swing.JPanel PanelCard15;
    private javax.swing.JPanel PanelCard16;
    private javax.swing.JPanel PanelCard17;
    private javax.swing.JPanel PanelCard18;
    private javax.swing.JPanel PanelCard19;
    private javax.swing.JPanel PanelCard2;
    private javax.swing.JPanel PanelCard20;
    private javax.swing.JPanel PanelCard3;
    private javax.swing.JPanel PanelCard4;
    private javax.swing.JPanel PanelCard5;
    private javax.swing.JPanel PanelCard6;
    private javax.swing.JPanel PanelCard7;
    private javax.swing.JPanel PanelCard8;
    private javax.swing.JPanel PanelCard9;
    private javax.swing.JLabel TextCard1;
    private javax.swing.JLabel TextCard10;
    private javax.swing.JLabel TextCard11;
    private javax.swing.JLabel TextCard12;
    private javax.swing.JLabel TextCard13;
    private javax.swing.JLabel TextCard14;
    private javax.swing.JLabel TextCard15;
    private javax.swing.JLabel TextCard16;
    private javax.swing.JLabel TextCard17;
    private javax.swing.JLabel TextCard18;
    private javax.swing.JLabel TextCard19;
    private javax.swing.JLabel TextCard2;
    private javax.swing.JLabel TextCard20;
    private javax.swing.JLabel TextCard3;
    private javax.swing.JLabel TextCard4;
    private javax.swing.JLabel TextCard5;
    private javax.swing.JLabel TextCard6;
    private javax.swing.JLabel TextCard7;
    private javax.swing.JLabel TextCard8;
    private javax.swing.JLabel TextCard9;
    private javax.swing.JPanel btnAvancar;
    private javax.swing.JPanel btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel ocultoPanel;
    private imagens.SVGImage sVGImage1;
    private imagens.SVGImage sVGImage2;
    private imagens.SVGImage sVGImage3;
    private imagens.SVGImage sVGImage4;
    private imagens.SVGImage sVGImage5;
    private imagens.SVGImage sVGImage6;
    private imagens.SVGImage sVGImage8;
    private javaswingdev.SimpleTitleBar simpleTitleBar1;
    // End of variables declaration//GEN-END:variables
}
