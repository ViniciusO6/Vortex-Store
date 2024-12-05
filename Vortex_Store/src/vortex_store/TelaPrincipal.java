/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vortex_store;

import conexao.Upload;
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar; 
import javax.swing.JScrollPane;
import jnafilechooser.api.JnaFileChooser;
import scrollbar.ScrollBarCustom;
import conexao.TokenGenerator;
/**
 *
 * @author vinic 
 */

public class TelaPrincipal extends javax.swing.JFrame {
    Conexao conexao;
    String URLs[] = new String[8];
    int offset = -20;
    int offset2 = -20;
    String[] ID_CARD = new String[20] ;
    String[] ID_CARD_LOJA = new String[20] ;
    
    String ID_BUSCAR;
    String token = lerDados();
    String ID_usuario = "";
    
    int linhas = 0;
    int avancou = 0;
    boolean MaisJogos;
    
    int avancou2 = 0;
    boolean MaisJogos2;
   
    //imagens do jogo
    String url_img1, url_img2, url_img3, url_img4, url_img5;
    
    ScrollBarCustom scrollBarCustom = new  ScrollBarCustom();
    
    public TelaPrincipal() {
        conexao = new Conexao(); 
        conexao.conecta(false);
        
        
        
        initComponents();
        EmailPuxado.setText("vinifernandes");
        
        btnVoltar.setVisible(false);
        btnAvancar.setVisible(false);
        
        CarregarJogos(false, false);
        CarregarJogosAleatorios(false, false);
        scrollBarCustom.imprimir();

        
        //Configuração da tela rolavel, a ScrollBar de todas as telas
        
        // Tela da Biblioteca
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(30);//rolagem rapida
        simpleTitleBar1.init(this);
        getContentPane().setBackground(Color.BLACK);
        
        //Tela de meus jogos
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        this.jScrollPane2.getVerticalScrollBar().setUnitIncrement(30);//rolagem rapida
        this.setLocationRelativeTo(null);//janela no meio da tela
        simpleTitleBar1.init(this);
        getContentPane().setBackground(Color.BLACK);
        
        //Tela de compra
        jScrollPane9.setVerticalScrollBar(new ScrollBarCustom());
        this.jScrollPane9.getVerticalScrollBar().setUnitIncrement(30);//rolagem rapida
        this.setLocationRelativeTo(null);//janela no meio da tela
        simpleTitleBar1.init(this);
        getContentPane().setBackground(Color.BLACK);
        
        //Setando icone
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/logos/VortexIcon3.png"));
        setIconImage(icon.getImage());
        
      
        sVGImage10.setSvgImage("imagens/SenhaRedefinida.svg", 100,100);
        sVGImage27.setSvgImage("imagens/SenhaAlterada.svg", 100,100);
        sVGImage28.setSvgImage("imagens/ExcluirConta.svg", 100,100);
        sVGImage29.setSvgImage("imagens/RostoFalha.svg", 100,100);
        editarNome.setSvgImage("imagens/edit.svg", 24, 24);
        editarEmail.setSvgImage("imagens/edit.svg", 24, 24);
        editarFoto.setSvgImage("imagens/edit.svg", 24, 24);
        
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
                jTabbedPane1.setSelectedIndex(5);
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
        jDialog2 = new javax.swing.JDialog();
        jPanel117 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        sVGImage10 = new imagens.SVGImage();
        jLabel99 = new javax.swing.JLabel();
        Avançar = new com.raven.swing.Button();
        Cancelar1 = new com.raven.swing.Button();
        jDialog3 = new javax.swing.JDialog();
        jPanel118 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        Avançar1 = new com.raven.swing.Button();
        Cancelar2 = new com.raven.swing.Button();
        jLabel103 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JPasswordField();
        jPanel122 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JPasswordField();
        jPanel123 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JPasswordField();
        jDialog4 = new javax.swing.JDialog();
        jPanel119 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        sVGImage27 = new imagens.SVGImage();
        jLabel105 = new javax.swing.JLabel();
        Avançar2 = new com.raven.swing.Button();
        jDialog5 = new javax.swing.JDialog();
        jPanel121 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        sVGImage28 = new imagens.SVGImage();
        jLabel107 = new javax.swing.JLabel();
        AvançarExcluir = new com.raven.swing.Button();
        CancelarExcluir = new com.raven.swing.Button();
        jDialog6 = new javax.swing.JDialog();
        jPanel124 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        Avançar3 = new com.raven.swing.Button();
        CancelarConta = new com.raven.swing.Button();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jPanel126 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JPasswordField();
        jPanel127 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JPasswordField();
        EmailPuxado = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jDialog7 = new javax.swing.JDialog();
        jPanel125 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        sVGImage29 = new imagens.SVGImage();
        jLabel114 = new javax.swing.JLabel();
        Avançar4 = new com.raven.swing.Button();
        ocultoPanel2 = new javax.swing.JPanel();
        OcultoText2 = new javax.swing.JLabel();
        OcultoImgCard2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        PanelCard21 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        ImgCard21 = new javax.swing.JLabel();
        TextCard21 = new javax.swing.JLabel();
        PanelCard22 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        ImgCard22 = new javax.swing.JLabel();
        TextCard22 = new javax.swing.JLabel();
        PanelCard25 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        ImgCard25 = new javax.swing.JLabel();
        TextCard25 = new javax.swing.JLabel();
        PanelCard23 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        ImgCard23 = new javax.swing.JLabel();
        TextCard23 = new javax.swing.JLabel();
        PanelCard24 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        ImgCard24 = new javax.swing.JLabel();
        TextCard24 = new javax.swing.JLabel();
        PanelCard26 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        ImgCard26 = new javax.swing.JLabel();
        TextCard26 = new javax.swing.JLabel();
        PanelCard27 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        ImgCard27 = new javax.swing.JLabel();
        TextCard27 = new javax.swing.JLabel();
        PanelCard28 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        ImgCard28 = new javax.swing.JLabel();
        TextCard28 = new javax.swing.JLabel();
        PanelCard29 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        ImgCard29 = new javax.swing.JLabel();
        TextCard29 = new javax.swing.JLabel();
        PanelCard30 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        ImgCard30 = new javax.swing.JLabel();
        TextCard30 = new javax.swing.JLabel();
        PanelCard35 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        ImgCard35 = new javax.swing.JLabel();
        TextCard35 = new javax.swing.JLabel();
        PanelCard33 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        ImgCard33 = new javax.swing.JLabel();
        TextCard33 = new javax.swing.JLabel();
        PanelCard31 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        ImgCard31 = new javax.swing.JLabel();
        TextCard31 = new javax.swing.JLabel();
        PanelCard34 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        ImgCard34 = new javax.swing.JLabel();
        TextCard34 = new javax.swing.JLabel();
        PanelCard32 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        ImgCard32 = new javax.swing.JLabel();
        TextCard32 = new javax.swing.JLabel();
        PanelCard36 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        ImgCard36 = new javax.swing.JLabel();
        TextCard36 = new javax.swing.JLabel();
        PanelCard37 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        ImgCard37 = new javax.swing.JLabel();
        TextCard37 = new javax.swing.JLabel();
        PanelCard38 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        ImgCard38 = new javax.swing.JLabel();
        TextCard38 = new javax.swing.JLabel();
        PanelCard39 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        ImgCard39 = new javax.swing.JLabel();
        TextCard39 = new javax.swing.JLabel();
        PanelCard40 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        ImgCard40 = new javax.swing.JLabel();
        TextCard40 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnVoltar1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        sVGImage9 = new imagens.SVGImage();
        btnAvancar1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sVGImage7 = new imagens.SVGImage();
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
        jPanel109 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        button1 = new com.raven.swing.Button();
        imageAvatar1 = new com.raven.Perfil.ImageAvatar();
        editarNome1 = new imagens.SVGImage();
        editarFoto = new imagens.SVGImage();
        excluir = new com.raven.swing.Button();
        jPanel112 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel113 = new javax.swing.JPanel();
        Nome = new javax.swing.JTextField();
        panelRounds18 = new com.raven.swing.combobox.PanelRounds();
        editarNome = new imagens.SVGImage();
        jLabel94 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        Email = new javax.swing.JTextField();
        panelRounds19 = new com.raven.swing.combobox.PanelRounds();
        editarEmail = new imagens.SVGImage();
        jLabel95 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        Nome2 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        Flag = new imagens.SVGImage();
        paisLabel = new javax.swing.JLabel();
        Salvar = new com.raven.swing.Button();
        Senha = new com.raven.swing.Button();
        jLabel97 = new javax.swing.JLabel();
        jPanel138 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel139 = new javax.swing.JPanel();
        TituloPrincipal = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        TituloJogo = new javax.swing.JLabel();
        img5 = new javaswingdev.ImageReajust();
        img4 = new javaswingdev.ImageReajust();
        img3 = new javaswingdev.ImageReajust();
        img2 = new javaswingdev.ImageReajust();
        img1 = new javaswingdev.ImageReajust();
        ImgPrincipal = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        capaJogo = new javax.swing.JLabel();
        Sinopse = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        nomeDesenvolvedor = new javax.swing.JLabel();
        data_public = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        categoriasJogo = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jPanel142 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        descricao = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel143 = new javax.swing.JPanel();
        jPanel144 = new javax.swing.JPanel();
        imgClassificacao = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel145 = new javax.swing.JPanel();
        jPanel146 = new javax.swing.JPanel();
        jLabel198 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        publicar2 = new com.raven.swing.Button();
        publicar3 = new com.raven.swing.Button();
        jLabel117 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        minimo1 = new javax.swing.JLabel();
        minimo2 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        minimo3 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        minimo4 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        minimo5 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        recomendado1 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        recomendado2 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        recomendado3 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        recomendado4 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        recomendado5 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        idiomasJogo = new javax.swing.JLabel();
        sVGImage31 = new imagens.SVGImage();
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

        jDialog2.setMinimumSize(new java.awt.Dimension(480, 300));
        jDialog2.setUndecorated(true);
        jDialog2.getContentPane().setLayout(null);

        jPanel117.setBackground(new java.awt.Color(27, 30, 43));

        jLabel98.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Redefinir Senha");

        jLabel99.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Deseja mesmo redefinir sua senha?");

        Avançar.setBackground(new java.awt.Color(76, 31, 128));
        Avançar.setForeground(new java.awt.Color(255, 255, 255));
        Avançar.setText("Sim");
        Avançar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Avançar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AvançarMouseClicked(evt);
            }
        });
        Avançar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvançarActionPerformed(evt);
            }
        });

        Cancelar1.setBackground(new java.awt.Color(186, 33, 33));
        Cancelar1.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar1.setText("Cancelar");
        Cancelar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(sVGImage10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel117Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel99)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel117Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(Avançar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(Cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel98)
                .addGap(18, 18, 18)
                .addComponent(sVGImage10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel99)
                .addGap(18, 18, 18)
                .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Avançar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDialog2.getContentPane().add(jPanel117);
        jPanel117.setBounds(0, 0, 480, 0);

        jDialog3.setMinimumSize(new java.awt.Dimension(600, 400));

        jPanel118.setBackground(new java.awt.Color(27, 30, 43));

        jLabel100.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Redefinir Senha");

        Avançar1.setBackground(new java.awt.Color(76, 31, 128));
        Avançar1.setForeground(new java.awt.Color(255, 255, 255));
        Avançar1.setText("Redefinir");
        Avançar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Avançar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Avançar1MouseClicked(evt);
            }
        });
        Avançar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Avançar1ActionPerformed(evt);
            }
        });

        Cancelar2.setBackground(new java.awt.Color(186, 33, 33));
        Cancelar2.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar2.setText("Cancelar");
        Cancelar2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Cancelar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cancelar2MouseClicked(evt);
            }
        });
        Cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar2ActionPerformed(evt);
            }
        });

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Repetir Nova Senha:");

        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("Nova Senha:");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("Senha Atual:");

        jPanel120.setBackground(new java.awt.Color(50, 53, 60));

        jTextField1.setBackground(new java.awt.Color(50, 53, 60));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel120Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel122.setBackground(new java.awt.Color(50, 53, 60));

        jTextField2.setBackground(new java.awt.Color(50, 53, 60));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel122Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel122Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel123.setBackground(new java.awt.Color(50, 53, 60));

        jTextField3.setBackground(new java.awt.Color(50, 53, 60));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);

        javax.swing.GroupLayout jPanel123Layout = new javax.swing.GroupLayout(jPanel123);
        jPanel123.setLayout(jPanel123Layout);
        jPanel123Layout.setHorizontalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel123Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel123Layout.setVerticalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel123Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel118Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel101)
                    .addComponent(jLabel102)
                    .addComponent(jLabel103)
                    .addGroup(jPanel118Layout.createSequentialGroup()
                        .addComponent(Avançar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(Cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel100)
                .addGap(18, 18, 18)
                .addComponent(jLabel101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel102)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel103)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Avançar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDialog4.setMinimumSize(new java.awt.Dimension(480, 300));
        jDialog4.setModal(true);
        jDialog4.setUndecorated(true);
        jDialog4.getContentPane().setLayout(null);

        jPanel119.setBackground(new java.awt.Color(27, 30, 43));

        jLabel104.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Redefinir Senha");

        jLabel105.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("Senha alterada com sucesso!");

        Avançar2.setBackground(new java.awt.Color(76, 31, 128));
        Avançar2.setForeground(new java.awt.Color(255, 255, 255));
        Avançar2.setText("Ok");
        Avançar2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Avançar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Avançar2MouseClicked(evt);
            }
        });
        Avançar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Avançar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(sVGImage27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel119Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel105)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel119Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Avançar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel104)
                .addGap(18, 18, 18)
                .addComponent(sVGImage27, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel105)
                .addGap(18, 18, 18)
                .addComponent(Avançar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDialog4.getContentPane().add(jPanel119);
        jPanel119.setBounds(0, 0, 480, 0);

        jDialog5.setMinimumSize(new java.awt.Dimension(480, 300));
        jDialog5.setUndecorated(true);
        jDialog5.getContentPane().setLayout(null);

        jPanel121.setBackground(new java.awt.Color(27, 30, 43));

        jLabel106.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Excluir Conta");

        jLabel107.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Deseja mesmo deseja mesmo excluir sua conta?");

        AvançarExcluir.setBackground(new java.awt.Color(76, 31, 128));
        AvançarExcluir.setForeground(new java.awt.Color(255, 255, 255));
        AvançarExcluir.setText("Sim");
        AvançarExcluir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        AvançarExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AvançarExcluirMouseClicked(evt);
            }
        });
        AvançarExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvançarExcluirActionPerformed(evt);
            }
        });

        CancelarExcluir.setBackground(new java.awt.Color(186, 33, 33));
        CancelarExcluir.setForeground(new java.awt.Color(255, 255, 255));
        CancelarExcluir.setText("Cancelar");
        CancelarExcluir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        CancelarExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarExcluirMouseClicked(evt);
            }
        });
        CancelarExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(sVGImage28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel121Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel107)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel121Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(AvançarExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(CancelarExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel106)
                .addGap(18, 18, 18)
                .addComponent(sVGImage28, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel107)
                .addGap(18, 18, 18)
                .addGroup(jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AvançarExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelarExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDialog5.getContentPane().add(jPanel121);
        jPanel121.setBounds(0, 0, 480, 0);

        jDialog6.setMinimumSize(new java.awt.Dimension(600, 400));

        jPanel124.setBackground(new java.awt.Color(27, 30, 43));

        jLabel108.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("Excluir Conta");

        Avançar3.setBackground(new java.awt.Color(76, 31, 128));
        Avançar3.setForeground(new java.awt.Color(255, 255, 255));
        Avançar3.setText("Confirmar");
        Avançar3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Avançar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Avançar3MouseClicked(evt);
            }
        });
        Avançar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Avançar3ActionPerformed(evt);
            }
        });

        CancelarConta.setBackground(new java.awt.Color(186, 33, 33));
        CancelarConta.setForeground(new java.awt.Color(255, 255, 255));
        CancelarConta.setText("Cancelar");
        CancelarConta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        CancelarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarContaMouseClicked(evt);
            }
        });
        CancelarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarContaActionPerformed(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setText("Confirmar Senha:");

        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setText("Senha Atual:");

        jLabel111.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setText("Digite sua senha para que possa ser confirmada a exclusão");

        jPanel126.setBackground(new java.awt.Color(50, 53, 60));

        jTextField5.setBackground(new java.awt.Color(50, 53, 60));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);

        javax.swing.GroupLayout jPanel126Layout = new javax.swing.GroupLayout(jPanel126);
        jPanel126.setLayout(jPanel126Layout);
        jPanel126Layout.setHorizontalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel126Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel126Layout.setVerticalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel126Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel127.setBackground(new java.awt.Color(50, 53, 60));

        jTextField6.setBackground(new java.awt.Color(50, 53, 60));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(null);

        javax.swing.GroupLayout jPanel127Layout = new javax.swing.GroupLayout(jPanel127);
        jPanel127.setLayout(jPanel127Layout);
        jPanel127Layout.setHorizontalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel127Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel127Layout.setVerticalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel127Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EmailPuxado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        EmailPuxado.setForeground(new java.awt.Color(255, 255, 255));
        EmailPuxado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setText("Lamentamos que você deseja excluir a sua conta cujo email é:");

        javax.swing.GroupLayout jPanel124Layout = new javax.swing.GroupLayout(jPanel124);
        jPanel124.setLayout(jPanel124Layout);
        jPanel124Layout.setHorizontalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EmailPuxado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel124Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel124Layout.createSequentialGroup()
                        .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel124Layout.createSequentialGroup()
                        .addComponent(jLabel111)
                        .addGap(121, 121, 121))))
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addGroup(jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel124Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel110)
                            .addComponent(jLabel109)
                            .addGroup(jPanel124Layout.createSequentialGroup()
                                .addComponent(Avançar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115)
                                .addComponent(CancelarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel124Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel113)))
                .addGap(0, 112, Short.MAX_VALUE))
        );
        jPanel124Layout.setVerticalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel108)
                .addGap(18, 18, 18)
                .addComponent(jLabel113)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailPuxado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel110)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel109)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Avançar3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jDialog6Layout = new javax.swing.GroupLayout(jDialog6.getContentPane());
        jDialog6.getContentPane().setLayout(jDialog6Layout);
        jDialog6Layout.setHorizontalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog6Layout.setVerticalGroup(
            jDialog6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog7.setMinimumSize(new java.awt.Dimension(480, 300));
        jDialog7.setModal(true);
        jDialog7.setUndecorated(true);
        jDialog7.getContentPane().setLayout(null);

        jPanel125.setBackground(new java.awt.Color(27, 30, 43));

        jLabel112.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("Excluir conta");

        jLabel114.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("Sua conta foi excluida com sucesso!");

        Avançar4.setBackground(new java.awt.Color(76, 31, 128));
        Avançar4.setForeground(new java.awt.Color(255, 255, 255));
        Avançar4.setText("Ok");
        Avançar4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Avançar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Avançar4MouseClicked(evt);
            }
        });
        Avançar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Avançar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(sVGImage29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel125Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel114)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel125Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Avançar4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel112)
                .addGap(18, 18, 18)
                .addComponent(sVGImage29, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel114)
                .addGap(18, 18, 18)
                .addComponent(Avançar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDialog7.getContentPane().add(jPanel125);
        jPanel125.setBounds(0, 0, 480, 0);

        javax.swing.GroupLayout ocultoPanel2Layout = new javax.swing.GroupLayout(ocultoPanel2);
        ocultoPanel2.setLayout(ocultoPanel2Layout);
        ocultoPanel2Layout.setHorizontalGroup(
            ocultoPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        ocultoPanel2Layout.setVerticalGroup(
            ocultoPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        OcultoText2.setText("jLabel11");

        OcultoImgCard2.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(10, 15, 22));

        jPanel12.setBackground(new java.awt.Color(10, 15, 22));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel13.setBackground(new java.awt.Color(18, 22, 32));
        jPanel13.setMaximumSize(new java.awt.Dimension(1263, 1560));
        jPanel13.setMinimumSize(new java.awt.Dimension(1263, 1560));

        jLabel11.setBackground(new java.awt.Color(76, 31, 129));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Loja");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        PanelCard21.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(ImgCard21)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(ImgCard21)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard21.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard21.setForeground(new java.awt.Color(255, 255, 255));
        TextCard21.setText("Nome do Jogo");
        TextCard21.setToolTipText("");
        TextCard21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard21.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard21Layout = new javax.swing.GroupLayout(PanelCard21);
        PanelCard21.setLayout(PanelCard21Layout);
        PanelCard21Layout.setHorizontalGroup(
            PanelCard21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard21Layout.createSequentialGroup()
                .addGroup(PanelCard21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard21, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard21Layout.setVerticalGroup(
            PanelCard21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard21Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard22.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addComponent(ImgCard22)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addComponent(ImgCard22)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard22.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard22.setForeground(new java.awt.Color(255, 255, 255));
        TextCard22.setText("Nome do Jogo");
        TextCard22.setToolTipText("");
        TextCard22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard22.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard22Layout = new javax.swing.GroupLayout(PanelCard22);
        PanelCard22.setLayout(PanelCard22Layout);
        PanelCard22Layout.setHorizontalGroup(
            PanelCard22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard22Layout.createSequentialGroup()
                .addGroup(PanelCard22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard22, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard22Layout.setVerticalGroup(
            PanelCard22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard22Layout.createSequentialGroup()
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard25.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(ImgCard25)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(ImgCard25)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard25.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard25.setForeground(new java.awt.Color(255, 255, 255));
        TextCard25.setText("Nome do Jogo");
        TextCard25.setToolTipText("");
        TextCard25.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard25.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard25Layout = new javax.swing.GroupLayout(PanelCard25);
        PanelCard25.setLayout(PanelCard25Layout);
        PanelCard25Layout.setHorizontalGroup(
            PanelCard25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard25Layout.createSequentialGroup()
                .addGroup(PanelCard25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard25, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard25Layout.setVerticalGroup(
            PanelCard25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard25Layout.createSequentialGroup()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard23.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(ImgCard23)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(ImgCard23)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard23.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard23.setForeground(new java.awt.Color(255, 255, 255));
        TextCard23.setText("Nome do Jogo");
        TextCard23.setToolTipText("");
        TextCard23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard23.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard23Layout = new javax.swing.GroupLayout(PanelCard23);
        PanelCard23.setLayout(PanelCard23Layout);
        PanelCard23Layout.setHorizontalGroup(
            PanelCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard23Layout.createSequentialGroup()
                .addGroup(PanelCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard23, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard23Layout.setVerticalGroup(
            PanelCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard23Layout.createSequentialGroup()
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard23, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard24.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(ImgCard24)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(ImgCard24)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard24.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard24.setForeground(new java.awt.Color(255, 255, 255));
        TextCard24.setText("Nome do Jogo");
        TextCard24.setToolTipText("");
        TextCard24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard24.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard24Layout = new javax.swing.GroupLayout(PanelCard24);
        PanelCard24.setLayout(PanelCard24Layout);
        PanelCard24Layout.setHorizontalGroup(
            PanelCard24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard24Layout.createSequentialGroup()
                .addGroup(PanelCard24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard24, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard24Layout.setVerticalGroup(
            PanelCard24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard24Layout.createSequentialGroup()
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard26.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addComponent(ImgCard26)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addComponent(ImgCard26)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard26.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard26.setForeground(new java.awt.Color(255, 255, 255));
        TextCard26.setText("Nome do Jogo");
        TextCard26.setToolTipText("");
        TextCard26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard26.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard26Layout = new javax.swing.GroupLayout(PanelCard26);
        PanelCard26.setLayout(PanelCard26Layout);
        PanelCard26Layout.setHorizontalGroup(
            PanelCard26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard26Layout.createSequentialGroup()
                .addGroup(PanelCard26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard26, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard26Layout.setVerticalGroup(
            PanelCard26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard26Layout.createSequentialGroup()
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard27.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(ImgCard27)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(ImgCard27)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard27.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard27.setForeground(new java.awt.Color(255, 255, 255));
        TextCard27.setText("Nome do Jogo");
        TextCard27.setToolTipText("");
        TextCard27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard27.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard27Layout = new javax.swing.GroupLayout(PanelCard27);
        PanelCard27.setLayout(PanelCard27Layout);
        PanelCard27Layout.setHorizontalGroup(
            PanelCard27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard27Layout.createSequentialGroup()
                .addGroup(PanelCard27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard27, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard27Layout.setVerticalGroup(
            PanelCard27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard27Layout.createSequentialGroup()
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard27, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard28.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addComponent(ImgCard28)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addComponent(ImgCard28)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard28.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard28.setForeground(new java.awt.Color(255, 255, 255));
        TextCard28.setText("Nome do Jogo");
        TextCard28.setToolTipText("");
        TextCard28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard28.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard28Layout = new javax.swing.GroupLayout(PanelCard28);
        PanelCard28.setLayout(PanelCard28Layout);
        PanelCard28Layout.setHorizontalGroup(
            PanelCard28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard28Layout.createSequentialGroup()
                .addGroup(PanelCard28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard28, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard28Layout.setVerticalGroup(
            PanelCard28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard28Layout.createSequentialGroup()
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard28, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard29.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard29MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(ImgCard29)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(ImgCard29)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard29.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard29.setForeground(new java.awt.Color(255, 255, 255));
        TextCard29.setText("Nome do Jogo");
        TextCard29.setToolTipText("");
        TextCard29.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard29.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard29Layout = new javax.swing.GroupLayout(PanelCard29);
        PanelCard29.setLayout(PanelCard29Layout);
        PanelCard29Layout.setHorizontalGroup(
            PanelCard29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard29Layout.createSequentialGroup()
                .addGroup(PanelCard29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard29, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard29Layout.setVerticalGroup(
            PanelCard29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard29Layout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard30.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard30MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addComponent(ImgCard30)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addComponent(ImgCard30)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard30.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard30.setForeground(new java.awt.Color(255, 255, 255));
        TextCard30.setText("Nome do Jogo");
        TextCard30.setToolTipText("");
        TextCard30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard30.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard30Layout = new javax.swing.GroupLayout(PanelCard30);
        PanelCard30.setLayout(PanelCard30Layout);
        PanelCard30Layout.setHorizontalGroup(
            PanelCard30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard30Layout.createSequentialGroup()
                .addGroup(PanelCard30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard30, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard30Layout.setVerticalGroup(
            PanelCard30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard30Layout.createSequentialGroup()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard35.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard35MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(ImgCard35)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(ImgCard35)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard35.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard35.setForeground(new java.awt.Color(255, 255, 255));
        TextCard35.setText("Nome do Jogo");
        TextCard35.setToolTipText("");
        TextCard35.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard35.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard35Layout = new javax.swing.GroupLayout(PanelCard35);
        PanelCard35.setLayout(PanelCard35Layout);
        PanelCard35Layout.setHorizontalGroup(
            PanelCard35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard35Layout.createSequentialGroup()
                .addGroup(PanelCard35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard35, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard35Layout.setVerticalGroup(
            PanelCard35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard35Layout.createSequentialGroup()
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard35, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard33.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addComponent(ImgCard33)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addComponent(ImgCard33)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard33.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard33.setForeground(new java.awt.Color(255, 255, 255));
        TextCard33.setText("Nome do Jogo");
        TextCard33.setToolTipText("");
        TextCard33.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard33.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard33Layout = new javax.swing.GroupLayout(PanelCard33);
        PanelCard33.setLayout(PanelCard33Layout);
        PanelCard33Layout.setHorizontalGroup(
            PanelCard33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard33Layout.createSequentialGroup()
                .addGroup(PanelCard33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard33, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard33Layout.setVerticalGroup(
            PanelCard33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard33Layout.createSequentialGroup()
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard33, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard31.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(ImgCard31)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(ImgCard31)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard31.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard31.setForeground(new java.awt.Color(255, 255, 255));
        TextCard31.setText("Nome do Jogo");
        TextCard31.setToolTipText("");
        TextCard31.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard31.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard31Layout = new javax.swing.GroupLayout(PanelCard31);
        PanelCard31.setLayout(PanelCard31Layout);
        PanelCard31Layout.setHorizontalGroup(
            PanelCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard31Layout.createSequentialGroup()
                .addGroup(PanelCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard31, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard31Layout.setVerticalGroup(
            PanelCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard31Layout.createSequentialGroup()
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard31, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard34.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard34MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addComponent(ImgCard34)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addComponent(ImgCard34)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard34.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard34.setForeground(new java.awt.Color(255, 255, 255));
        TextCard34.setText("Nome do Jogo");
        TextCard34.setToolTipText("");
        TextCard34.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard34.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard34Layout = new javax.swing.GroupLayout(PanelCard34);
        PanelCard34.setLayout(PanelCard34Layout);
        PanelCard34Layout.setHorizontalGroup(
            PanelCard34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard34Layout.createSequentialGroup()
                .addGroup(PanelCard34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard34, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard34Layout.setVerticalGroup(
            PanelCard34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard34Layout.createSequentialGroup()
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard34, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard32.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(ImgCard32)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(ImgCard32)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard32.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard32.setForeground(new java.awt.Color(255, 255, 255));
        TextCard32.setText("Nome do Jogo");
        TextCard32.setToolTipText("");
        TextCard32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard32.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard32Layout = new javax.swing.GroupLayout(PanelCard32);
        PanelCard32.setLayout(PanelCard32Layout);
        PanelCard32Layout.setHorizontalGroup(
            PanelCard32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard32Layout.createSequentialGroup()
                .addGroup(PanelCard32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard32, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard32Layout.setVerticalGroup(
            PanelCard32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard32Layout.createSequentialGroup()
                .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard32, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard36.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard36MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addComponent(ImgCard36)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addComponent(ImgCard36)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard36.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard36.setForeground(new java.awt.Color(255, 255, 255));
        TextCard36.setText("Nome do Jogo");
        TextCard36.setToolTipText("");
        TextCard36.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard36.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard36Layout = new javax.swing.GroupLayout(PanelCard36);
        PanelCard36.setLayout(PanelCard36Layout);
        PanelCard36Layout.setHorizontalGroup(
            PanelCard36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard36Layout.createSequentialGroup()
                .addGroup(PanelCard36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard36, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard36Layout.setVerticalGroup(
            PanelCard36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard36Layout.createSequentialGroup()
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard36, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard37.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard37MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addComponent(ImgCard37)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addComponent(ImgCard37)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard37.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard37.setForeground(new java.awt.Color(255, 255, 255));
        TextCard37.setText("Nome do Jogo");
        TextCard37.setToolTipText("");
        TextCard37.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard37.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard37Layout = new javax.swing.GroupLayout(PanelCard37);
        PanelCard37.setLayout(PanelCard37Layout);
        PanelCard37Layout.setHorizontalGroup(
            PanelCard37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard37Layout.createSequentialGroup()
                .addGroup(PanelCard37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard37, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard37Layout.setVerticalGroup(
            PanelCard37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard37Layout.createSequentialGroup()
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard37, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard38.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard38MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(ImgCard38)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addComponent(ImgCard38)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard38.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard38.setForeground(new java.awt.Color(255, 255, 255));
        TextCard38.setText("Nome do Jogo");
        TextCard38.setToolTipText("");
        TextCard38.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard38.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard38Layout = new javax.swing.GroupLayout(PanelCard38);
        PanelCard38.setLayout(PanelCard38Layout);
        PanelCard38Layout.setHorizontalGroup(
            PanelCard38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard38Layout.createSequentialGroup()
                .addGroup(PanelCard38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard38, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard38Layout.setVerticalGroup(
            PanelCard38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard38Layout.createSequentialGroup()
                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard38, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard39.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard39MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(ImgCard39)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(ImgCard39)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard39.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard39.setForeground(new java.awt.Color(255, 255, 255));
        TextCard39.setText("Nome do Jogo");
        TextCard39.setToolTipText("");
        TextCard39.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard39.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard39Layout = new javax.swing.GroupLayout(PanelCard39);
        PanelCard39.setLayout(PanelCard39Layout);
        PanelCard39Layout.setHorizontalGroup(
            PanelCard39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard39Layout.createSequentialGroup()
                .addGroup(PanelCard39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard39, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard39Layout.setVerticalGroup(
            PanelCard39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard39Layout.createSequentialGroup()
                .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard39, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard40.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard40MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addComponent(ImgCard40)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addComponent(ImgCard40)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextCard40.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TextCard40.setForeground(new java.awt.Color(255, 255, 255));
        TextCard40.setText("Nome do Jogo");
        TextCard40.setToolTipText("");
        TextCard40.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        TextCard40.setMaximumSize(new java.awt.Dimension(107, 32));

        javax.swing.GroupLayout PanelCard40Layout = new javax.swing.GroupLayout(PanelCard40);
        PanelCard40.setLayout(PanelCard40Layout);
        PanelCard40Layout.setHorizontalGroup(
            PanelCard40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard40Layout.createSequentialGroup()
                .addGroup(PanelCard40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard40, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard40Layout.setVerticalGroup(
            PanelCard40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard40Layout.createSequentialGroup()
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard40, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel14.setOpaque(false);

        btnVoltar1.setBackground(new java.awt.Color(59, 32, 91));
        btnVoltar1.setMaximumSize(new java.awt.Dimension(212, 39));
        btnVoltar1.setMinimumSize(new java.awt.Dimension(212, 39));
        btnVoltar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltar1MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Página Anterior");

        javax.swing.GroupLayout btnVoltar1Layout = new javax.swing.GroupLayout(btnVoltar1);
        btnVoltar1.setLayout(btnVoltar1Layout);
        btnVoltar1Layout.setHorizontalGroup(
            btnVoltar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVoltar1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(sVGImage9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(18, 18, 18))
        );
        btnVoltar1Layout.setVerticalGroup(
            btnVoltar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGImage9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
            .addGroup(btnVoltar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.add(btnVoltar1);

        btnAvancar1.setBackground(new java.awt.Color(59, 32, 91));
        btnAvancar1.setMaximumSize(new java.awt.Dimension(212, 39));
        btnAvancar1.setMinimumSize(new java.awt.Dimension(212, 39));
        btnAvancar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAvancar1MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Próxima Página");

        javax.swing.GroupLayout btnAvancar1Layout = new javax.swing.GroupLayout(btnAvancar1);
        btnAvancar1.setLayout(btnAvancar1Layout);
        btnAvancar1Layout.setHorizontalGroup(
            btnAvancar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAvancar1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sVGImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        btnAvancar1Layout.setVerticalGroup(
            btnAvancar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAvancar1Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(9, 9, 9))
            .addComponent(sVGImage7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.add(btnAvancar1);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(PanelCard31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(PanelCard26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(76, 76, 76))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(PanelCard21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(PanelCard22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(PanelCard36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(52, 52, 52)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelCard21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel13);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel12);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel9);

        jPanel109.setBackground(new java.awt.Color(18, 22, 32));
        jPanel109.setPreferredSize(new java.awt.Dimension(1195, 628));

        jPanel110.setBackground(new java.awt.Color(27, 30, 43));
        jPanel110.setPreferredSize(new java.awt.Dimension(100, 550));

        jPanel111.setBackground(new java.awt.Color(38, 41, 57));

        jLabel92.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Dados do Usuário");

        jSeparator3.setBackground(new java.awt.Color(27, 30, 43));
        jSeparator3.setForeground(new java.awt.Color(27, 30, 43));
        jSeparator3.setToolTipText("");
        jSeparator3.setPreferredSize(new java.awt.Dimension(10, 3));

        button1.setBackground(new java.awt.Color(76, 31, 129));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Encerrar Sessão");
        button1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        imageAvatar1.setForeground(new java.awt.Color(76, 31, 129));
        imageAvatar1.setBorderSize(5);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FotoPerfil.png"))); // NOI18N

        editarNome1.setBackground(new java.awt.Color(255, 0, 0));
        editarNome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarNome1.setMaximumSize(new java.awt.Dimension(30, 30));
        editarNome1.setMinimumSize(new java.awt.Dimension(30, 30));
        editarNome1.setPreferredSize(new java.awt.Dimension(30, 30));
        editarNome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNome1MouseClicked(evt);
            }
        });
        imageAvatar1.add(editarNome1);
        editarNome1.setBounds(90, 80, 24, 22);

        editarFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarFoto.setMaximumSize(new java.awt.Dimension(30, 30));
        editarFoto.setMinimumSize(new java.awt.Dimension(30, 30));
        editarFoto.setPreferredSize(new java.awt.Dimension(30, 30));

        excluir.setBackground(new java.awt.Color(186, 33, 33));
        excluir.setForeground(new java.awt.Color(255, 255, 255));
        excluir.setText("Excluir Conta");
        excluir.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excluirMouseClicked(evt);
            }
        });
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel111Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(editarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addGroup(jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel111Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel111Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );

        jPanel112.setBackground(new java.awt.Color(38, 41, 57));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("Nome de Usuário");

        jPanel113.setBackground(new java.awt.Color(50, 53, 60));

        Nome.setBackground(new java.awt.Color(50, 53, 60));
        Nome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Nome.setForeground(new java.awt.Color(255, 255, 255));
        Nome.setBorder(null);
        Nome.setDisabledTextColor(new java.awt.Color(50, 53, 60));
        Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel113Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRounds18.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds18.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds18.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds18.setRoundBottomLeft(5);
        panelRounds18.setRoundBottomRight(5);
        panelRounds18.setRoundTopLeft(5);
        panelRounds18.setRoundTopRight(5);
        panelRounds18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds18MouseClicked(evt);
            }
        });

        editarNome.setBackground(new java.awt.Color(255, 0, 0));
        editarNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarNome.setMaximumSize(new java.awt.Dimension(30, 30));
        editarNome.setMinimumSize(new java.awt.Dimension(30, 30));
        editarNome.setPreferredSize(new java.awt.Dimension(30, 30));
        editarNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarNomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds18Layout = new javax.swing.GroupLayout(panelRounds18);
        panelRounds18.setLayout(panelRounds18Layout);
        panelRounds18Layout.setHorizontalGroup(
            panelRounds18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds18Layout.setVerticalGroup(
            panelRounds18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Email");

        jPanel114.setBackground(new java.awt.Color(50, 53, 60));

        Email.setBackground(new java.awt.Color(50, 53, 60));
        Email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setBorder(null);
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel114Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRounds19.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds19.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds19.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds19.setRoundBottomLeft(5);
        panelRounds19.setRoundBottomRight(5);
        panelRounds19.setRoundTopLeft(5);
        panelRounds19.setRoundTopRight(5);
        panelRounds19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds19MouseClicked(evt);
            }
        });

        editarEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarEmail.setMaximumSize(new java.awt.Dimension(30, 30));
        editarEmail.setMinimumSize(new java.awt.Dimension(30, 30));
        editarEmail.setPreferredSize(new java.awt.Dimension(30, 30));
        editarEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarEmailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds19Layout = new javax.swing.GroupLayout(panelRounds19);
        panelRounds19.setLayout(panelRounds19Layout);
        panelRounds19Layout.setHorizontalGroup(
            panelRounds19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds19Layout.setVerticalGroup(
            panelRounds19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("Data de Nascimento");

        jPanel115.setBackground(new java.awt.Color(50, 53, 60));

        Nome2.setBackground(new java.awt.Color(50, 53, 60));
        Nome2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Nome2.setForeground(new java.awt.Color(255, 255, 255));
        Nome2.setBorder(null);
        Nome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nome2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel115Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("País");

        jPanel116.setBackground(new java.awt.Color(50, 53, 60));

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel116Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Flag, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel116Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Flag, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        paisLabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        paisLabel.setForeground(new java.awt.Color(255, 255, 255));

        Salvar.setBackground(new java.awt.Color(76, 31, 129));
        Salvar.setForeground(new java.awt.Color(255, 255, 255));
        Salvar.setText("Salvar Alterações");
        Salvar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        Senha.setBackground(new java.awt.Color(76, 31, 129));
        Senha.setForeground(new java.awt.Color(255, 255, 255));
        Senha.setText("Alterar Senha");
        Senha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SenhaMouseClicked(evt);
            }
        });
        Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel112Layout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel112Layout.createSequentialGroup()
                        .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel112Layout.createSequentialGroup()
                                .addComponent(jPanel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRounds18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel112Layout.createSequentialGroup()
                                .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel112Layout.createSequentialGroup()
                                            .addComponent(jPanel116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(paisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRounds19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel112Layout.createSequentialGroup()
                        .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRounds18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel94)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRounds19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel95)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel96)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel97.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("Meu Perfil");

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel97))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel109Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel109Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("tab7", jPanel109);

        jScrollPane9.setBorder(null);
        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel139.setBackground(new java.awt.Color(18, 22, 32));
        jPanel139.setForeground(new java.awt.Color(255, 255, 255));
        jPanel139.setMaximumSize(new java.awt.Dimension(1195, 1890));
        jPanel139.setMinimumSize(new java.awt.Dimension(1195, 1890));

        TituloPrincipal.setBackground(new java.awt.Color(76, 31, 129));
        TituloPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        TituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        TituloPrincipal.setText("Título do Jogo");
        TituloPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TituloPrincipalMouseClicked(evt);
            }
        });

        jPanel140.setBackground(new java.awt.Color(10, 15, 22));
        jPanel140.setLayout(null);

        jLabel115.setBackground(new java.awt.Color(76, 31, 129));
        jLabel115.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("SOBRE ESTE JOGO");
        jLabel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel115MouseClicked(evt);
            }
        });
        jPanel140.add(jLabel115);
        jLabel115.setBounds(20, 520, 206, 32);

        TituloJogo.setBackground(new java.awt.Color(76, 31, 129));
        TituloJogo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        TituloJogo.setForeground(new java.awt.Color(255, 255, 255));
        TituloJogo.setText("Título do Jogo");
        TituloJogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TituloJogoMouseClicked(evt);
            }
        });
        jPanel140.add(TituloJogo);
        TituloJogo.setBounds(640, 190, 254, 27);

        img5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PosterDefault.png"))); // NOI18N
        img5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img5MouseClicked(evt);
            }
        });
        jPanel140.add(img5);
        img5.setBounds(498, 374, 112, 125);

        img4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PosterDefault.png"))); // NOI18N
        img4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img4MouseClicked(evt);
            }
        });
        jPanel140.add(img4);
        img4.setBounds(376, 374, 112, 125);

        img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PosterDefault.png"))); // NOI18N
        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img3MouseClicked(evt);
            }
        });
        jPanel140.add(img3);
        img3.setBounds(254, 374, 112, 125);

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PosterDefault.png"))); // NOI18N
        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img2MouseClicked(evt);
            }
        });
        jPanel140.add(img2);
        img2.setBounds(132, 374, 112, 125);

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PosterDefault.png"))); // NOI18N
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img1MouseClicked(evt);
            }
        });
        jPanel140.add(img1);
        img1.setBounds(10, 374, 112, 125);

        ImgPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PosterDefault.png"))); // NOI18N
        jPanel140.add(ImgPrincipal);
        ImgPrincipal.setBounds(10, 10, 600, 370);

        jPanel141.setBackground(new java.awt.Color(18, 22, 32));

        javax.swing.GroupLayout jPanel141Layout = new javax.swing.GroupLayout(jPanel141);
        jPanel141.setLayout(jPanel141Layout);
        jPanel141Layout.setHorizontalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel141Layout.setVerticalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1760, Short.MAX_VALUE)
        );

        jPanel140.add(jPanel141);
        jPanel141.setBounds(620, 0, 10, 1760);

        capaJogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CapaDefault.png"))); // NOI18N
        jPanel140.add(capaJogo);
        capaJogo.setBounds(640, 10, 300, 170);

        Sinopse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Sinopse.setForeground(new java.awt.Color(255, 255, 255));
        Sinopse.setText("<html>Red Dead Redemption 2 é um jogo eletrônico de ação-aventura desenvolvido e publicado pela Rockstar Games. É o terceiro título da série Red Dead e uma prequela de Red Dead Redemption, tendo sido lançado em outubro de 2018 para PlayStation 4 e Xbox One e em novembro de 2019 para Microsoft Windows e Google Stadia.</html>"); // NOI18N
        Sinopse.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Sinopse.setMaximumSize(new java.awt.Dimension(300, 140));
        Sinopse.setMinimumSize(new java.awt.Dimension(300, 140));
        jPanel140.add(Sinopse);
        Sinopse.setBounds(640, 230, 300, 140);

        jLabel180.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 255, 255));
        jLabel180.setText("Desenvolvedor:");
        jPanel140.add(jLabel180);
        jLabel180.setBounds(640, 370, 90, 16);

        nomeDesenvolvedor.setForeground(new java.awt.Color(255, 255, 255));
        nomeDesenvolvedor.setText("Nome desenvolvedor");
        jPanel140.add(nomeDesenvolvedor);
        nomeDesenvolvedor.setBounds(730, 370, 200, 16);

        data_public.setForeground(new java.awt.Color(255, 255, 255));
        data_public.setText("xx/xx/xxxx");
        jPanel140.add(data_public);
        data_public.setBounds(760, 390, 110, 16);

        jLabel183.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 255, 255));
        jLabel183.setText("Data de lançamento:");
        jPanel140.add(jLabel183);
        jLabel183.setBounds(640, 390, 120, 16);

        categoriasJogo.setForeground(new java.awt.Color(255, 255, 255));
        categoriasJogo.setText("categoria, categoria, categoria");
        categoriasJogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(categoriasJogo);
        categoriasJogo.setBounds(700, 410, 240, 40);

        jLabel185.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(255, 255, 255));
        jLabel185.setText("Categoria:");
        jPanel140.add(jLabel185);
        jLabel185.setBounds(640, 410, 60, 16);

        jLabel186.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setText("GRÁTIS");
        jPanel140.add(jLabel186);
        jLabel186.setBounds(870, 450, 70, 20);

        jPanel142.setBackground(new java.awt.Color(18, 22, 32));

        javax.swing.GroupLayout jPanel142Layout = new javax.swing.GroupLayout(jPanel142);
        jPanel142.setLayout(jPanel142Layout);
        jPanel142Layout.setHorizontalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel142Layout.setVerticalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel140.add(jPanel142);
        jPanel142.setBounds(630, 540, 320, 10);
        jPanel140.add(jSeparator4);
        jSeparator4.setBounds(10, 560, 600, 10);

        descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descricao.setForeground(new java.awt.Color(255, 255, 255));
        descricao.setText("<html><p>Estados Unidos, 1899.   Arthur Morgan e a gangue Van der Linde são bandidos em fuga. Com agentes federais e os melhores caçadores de recompensas no seu encalço, a gangue precisa roubar, assaltar e lutar para sobreviver no impiedoso coração dos Estados Unidos. Conforme divisões internas profundas ameaçam despedaçar a gangue, Arthur deve fazer uma escolha entre os seus próprios ideais e a lealdade à gangue que o criou.  Agora com conteúdo adicional no Modo História e um Modo Foto repleto de recursos, Red Dead Redemption 2 também inclui acesso gratuito ao mundo compartilhado de Red Dead Online. Nele, os jogadores assumem uma diversidade de ofícios para construir suas próprias trajetórias na fronteira, seja perseguindo criminosos procurados como Caçador de Recompensa, estabelecendo um negócio como Mercador, escavando tesouros exóticos como Colecionador ou operando uma destilaria subterrânea como Moonshiner, e muito mais.  Com novas melhorias gráficas e técnicas que tornam o jogo mais imersivo, Red Dead Redemption 2 para PC aproveita ao máximo a potência do PC para dar vida a cada canto deste mundo gigantesco, rico e detalhado, incluindo maiores distâncias de renderização; iluminação global de maior qualidade e oclusão do ambiente para melhorar a iluminação do dia e da noite; melhorias nos reflexos e sombras mais fortes e de maior resolução a todas as distâncias; texturas de árvore tesseladas e melhorias nas texturas de grama e pelo, tornando todas as plantas e animais mais realistas.  Red Dead Redemption 2 para PC também oferece suporte a HDR e a monitores de ponta com resolução 4K ou superior, configurações com vários monitores, widescreen, taxas de quadros mais rápidas, entre outras opções.</html>");
        descricao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(descricao);
        descricao.setBounds(20, 580, 580, 410);

        jLabel116.setBackground(new java.awt.Color(76, 31, 129));
        jLabel116.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setText("Requisitos mínimos:");
        jLabel116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel116MouseClicked(evt);
            }
        });
        jPanel140.add(jLabel116);
        jLabel116.setBounds(20, 1090, 180, 25);
        jPanel140.add(jSeparator5);
        jSeparator5.setBounds(10, 1070, 600, 10);

        jPanel143.setBackground(new java.awt.Color(18, 22, 32));

        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(jPanel143);
        jPanel143.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel140.add(jPanel143);
        jPanel143.setBounds(630, 660, 320, 10);

        jPanel144.setBackground(new java.awt.Color(18, 22, 32));

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel140.add(jPanel144);
        jPanel144.setBounds(630, 840, 320, 10);

        imgClassificacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/classificação/classificacao-18-anos-logo-1.png"))); // NOI18N
        jPanel140.add(imgClassificacao);
        imgClassificacao.setBounds(640, 690, 90, 90);

        jLabel194.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setText("<html>Classificação etária: Coordenação de Classificação Indicativa</html>");
        jPanel140.add(jLabel194);
        jLabel194.setBounds(640, 800, 310, 30);

        jLabel195.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(255, 255, 255));
        jLabel195.setText("Violência");
        jPanel140.add(jLabel195);
        jLabel195.setBounds(760, 700, 100, 20);

        jLabel196.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(255, 255, 255));
        jLabel196.setText("Atos criminosos");
        jPanel140.add(jLabel196);
        jLabel196.setBounds(760, 720, 110, 20);

        jLabel197.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(255, 255, 255));
        jLabel197.setText("Drogas ilícitas");
        jPanel140.add(jLabel197);
        jLabel197.setBounds(760, 740, 110, 20);

        jScrollPane11.setBorder(null);

        jPanel145.setBackground(new java.awt.Color(10, 15, 22));

        jPanel146.setBackground(new java.awt.Color(18, 22, 32));

        javax.swing.GroupLayout jPanel146Layout = new javax.swing.GroupLayout(jPanel146);
        jPanel146.setLayout(jPanel146Layout);
        jPanel146Layout.setHorizontalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel146Layout.setVerticalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel145Layout = new javax.swing.GroupLayout(jPanel145);
        jPanel145.setLayout(jPanel145Layout);
        jPanel145Layout.setHorizontalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel145Layout.setVerticalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel145Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(684, Short.MAX_VALUE))
        );

        jScrollPane11.setViewportView(jPanel145);

        jPanel140.add(jScrollPane11);
        jScrollPane11.setBounds(640, 960, 300, 790);

        jLabel198.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setText("Avaliações");
        jPanel140.add(jLabel198);
        jLabel198.setBounds(640, 870, 100, 25);

        jPanel147.setBackground(new java.awt.Color(18, 22, 32));

        jTextField7.setBackground(new java.awt.Color(18, 22, 32));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(null);

        publicar2.setBackground(new java.awt.Color(59, 32, 91));
        publicar2.setForeground(new java.awt.Color(255, 255, 255));
        publicar2.setText("Enviar");
        publicar2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        publicar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel147Layout = new javax.swing.GroupLayout(jPanel147);
        jPanel147.setLayout(jPanel147Layout);
        jPanel147Layout.setHorizontalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel147Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(publicar2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );
        jPanel147Layout.setVerticalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField7)
            .addComponent(publicar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel140.add(jPanel147);
        jPanel147.setBounds(640, 900, 300, 30);

        publicar3.setBackground(new java.awt.Color(59, 32, 91));
        publicar3.setForeground(new java.awt.Color(255, 255, 255));
        publicar3.setText("Baixar");
        publicar3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        publicar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publicar3MouseClicked(evt);
            }
        });
        publicar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicar3ActionPerformed(evt);
            }
        });
        jPanel140.add(publicar3);
        publicar3.setBounds(640, 480, 300, 34);

        jLabel117.setBackground(new java.awt.Color(76, 31, 129));
        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setText("REQUISITOS DE SISTEMA");
        jLabel117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel117MouseClicked(evt);
            }
        });
        jPanel140.add(jLabel117);
        jLabel117.setBounds(20, 1030, 290, 32);

        jLabel199.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel199.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel199);
        jLabel199.setBounds(20, 1118, 11, 40);

        minimo1.setForeground(new java.awt.Color(255, 255, 255));
        minimo1.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        minimo1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(minimo1);
        minimo1.setBounds(40, 1130, 250, 40);

        minimo2.setForeground(new java.awt.Color(255, 255, 255));
        minimo2.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        minimo2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(minimo2);
        minimo2.setBounds(40, 1170, 250, 40);

        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel120.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel120);
        jLabel120.setBounds(20, 1160, 11, 40);

        minimo3.setForeground(new java.awt.Color(255, 255, 255));
        minimo3.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        minimo3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(minimo3);
        minimo3.setBounds(40, 1210, 250, 40);

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel122.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel122);
        jLabel122.setBounds(20, 1200, 11, 40);

        minimo4.setForeground(new java.awt.Color(255, 255, 255));
        minimo4.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        minimo4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(minimo4);
        minimo4.setBounds(40, 1250, 250, 40);

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel124.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel124);
        jLabel124.setBounds(20, 1240, 11, 40);

        minimo5.setForeground(new java.awt.Color(255, 255, 255));
        minimo5.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        minimo5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(minimo5);
        minimo5.setBounds(40, 1290, 250, 40);

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel126.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel126);
        jLabel126.setBounds(20, 1280, 11, 40);

        recomendado1.setForeground(new java.awt.Color(255, 255, 255));
        recomendado1.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        recomendado1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(recomendado1);
        recomendado1.setBounds(360, 1130, 250, 40);

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel135.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel135);
        jLabel135.setBounds(340, 1120, 11, 40);

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel136.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel136);
        jLabel136.setBounds(340, 1160, 11, 40);

        recomendado2.setForeground(new java.awt.Color(255, 255, 255));
        recomendado2.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        recomendado2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(recomendado2);
        recomendado2.setBounds(360, 1170, 250, 40);

        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel138.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel138);
        jLabel138.setBounds(340, 1200, 11, 40);

        recomendado3.setForeground(new java.awt.Color(255, 255, 255));
        recomendado3.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        recomendado3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(recomendado3);
        recomendado3.setBounds(360, 1210, 250, 40);

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel140.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel140);
        jLabel140.setBounds(340, 1240, 11, 40);

        recomendado4.setForeground(new java.awt.Color(255, 255, 255));
        recomendado4.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        recomendado4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(recomendado4);
        recomendado4.setBounds(360, 1250, 250, 40);

        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setText("<html><p><span style=\"font-size: 20px;\">•</span></p></html>");
        jLabel142.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(jLabel142);
        jLabel142.setBounds(340, 1280, 11, 40);

        recomendado5.setForeground(new java.awt.Color(255, 255, 255));
        recomendado5.setText("<html>Requer um processador e sistema operacional de 64 bits</html>");
        recomendado5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(recomendado5);
        recomendado5.setBounds(360, 1290, 250, 40);

        jLabel150.setBackground(new java.awt.Color(76, 31, 129));
        jLabel150.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setText("Requisitos recomendados:");
        jLabel150.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel150MouseClicked(evt);
            }
        });
        jPanel140.add(jLabel150);
        jLabel150.setBounds(340, 1090, 230, 25);

        jLabel151.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setText("Idiomas:");
        jPanel140.add(jLabel151);
        jLabel151.setBounds(640, 556, 60, 20);

        idiomasJogo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        idiomasJogo.setForeground(new java.awt.Color(255, 255, 255));
        idiomasJogo.setText("<html>Português, Inglês, Espanhol</html>");
        idiomasJogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel140.add(idiomasJogo);
        idiomasJogo.setBounds(640, 580, 250, 70);
        jPanel140.add(sVGImage31);
        sVGImage31.setBounds(640, 440, 124, 20);

        javax.swing.GroupLayout jPanel139Layout = new javax.swing.GroupLayout(jPanel139);
        jPanel139.setLayout(jPanel139Layout);
        jPanel139Layout.setHorizontalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel139Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel140, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153))
        );
        jPanel139Layout.setVerticalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel139Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(TituloPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel140, javax.swing.GroupLayout.PREFERRED_SIZE, 1540, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane9.setViewportView(jPanel139);

        javax.swing.GroupLayout jPanel138Layout = new javax.swing.GroupLayout(jPanel138);
        jPanel138.setLayout(jPanel138Layout);
        jPanel138Layout.setHorizontalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        jPanel138Layout.setVerticalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel138Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab6", jPanel138);

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
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        sVGImage6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage6MouseClicked(evt);
            }
        });

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
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void sVGImage5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage5MouseClicked
        jTabbedPane1.setSelectedIndex(4);
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
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard1MouseClicked

    private void ImgCard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard2MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[1];
        System.out.println(ID_BUSCAR);
        BuscarJogo();
    }//GEN-LAST:event_ImgCard2MouseClicked

    private void ImgCard5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard5MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[2];
        System.out.println(ID_BUSCAR);
        BuscarJogo();
    }//GEN-LAST:event_ImgCard5MouseClicked

    private void ImgCard3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard3MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[3];
        System.out.println(ID_BUSCAR);
        BuscarJogo();
    }//GEN-LAST:event_ImgCard3MouseClicked

    private void ImgCard4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard4MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[4];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard4MouseClicked

    private void ImgCard6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard6MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[5];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard6MouseClicked

    private void ImgCard7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard7MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[6];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard7MouseClicked

    private void ImgCard8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard8MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[7];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard8MouseClicked

    private void ImgCard9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard9MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[8];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard9MouseClicked

    private void ImgCard10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard10MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[9];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard10MouseClicked

    private void ImgCard15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard15MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[10];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard15MouseClicked

    private void ImgCard13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard13MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[11];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard13MouseClicked

    private void ImgCard11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard11MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[12];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard11MouseClicked

    private void ImgCard14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard14MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[13];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard14MouseClicked

    private void ImgCard12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard12MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[14];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard12MouseClicked

    private void ImgCard16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard16MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[15];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard16MouseClicked

    private void ImgCard17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard17MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[16];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard17MouseClicked

    private void ImgCard18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard18MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[17];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard18MouseClicked

    private void ImgCard19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard19MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[18];
        BuscarJogo();
    }//GEN-LAST:event_ImgCard19MouseClicked

    private void ImgCard20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard20MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD[19];
        BuscarJogo();
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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeActionPerformed

    private void editarNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNomeMouseClicked

    }//GEN-LAST:event_editarNomeMouseClicked

    private void panelRounds18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds18MouseClicked

    }//GEN-LAST:event_panelRounds18MouseClicked

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void editarEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarEmailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editarEmailMouseClicked

    private void panelRounds19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds19MouseClicked

    private void Nome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nome2ActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        String nome, email, foto, sql, msg;
        nome = Nome.getText();
        email = Email.getText();

        /*
        try{
            if(txtCod.getText().equals("")){
                sql="insert into cliente (nome, email) values ('"+nome+"','"+email+"')";
                msg="Gravação de um novo registro";
            }else{
                sql = "update tbclientes set nome = '"+nome+"', email = '"+email+"' where cod = " + txtCod.getText();
                msg="Alterações de registro";
            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,msg+ " realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            con_cliente.executaSQL("select * from tbclientes order by cod");
            con_cliente.resultset.first();

        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }*/

    }//GEN-LAST:event_SalvarActionPerformed

    private void SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SenhaActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_excluirActionPerformed

    private void SenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SenhaMouseClicked
         jDialog2.setLocationRelativeTo(null);
         jDialog2.setModal(true);
         jDialog2.setVisible(true);
    }//GEN-LAST:event_SenhaMouseClicked

    private void Cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar1ActionPerformed
        // TODO add your handling code here:
        jDialog2.dispose();
    }//GEN-LAST:event_Cancelar1ActionPerformed

    private void AvançarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvançarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AvançarActionPerformed

    private void AvançarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AvançarMouseClicked
       jDialog2.dispose();
       
       jDialog3.setLocationRelativeTo(null);
       jDialog3.setModal(true);
       jDialog3.setUndecorated(true);
       jDialog3.setVisible(true);
    }//GEN-LAST:event_AvançarMouseClicked

    private void Avançar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Avançar1MouseClicked
        jDialog3.dispose();
       
       jDialog4.setLocationRelativeTo(null);
       jDialog4.setModal(true);
       jDialog4.setUndecorated(true);
       jDialog4.setVisible(true);
    }//GEN-LAST:event_Avançar1MouseClicked

    private void Avançar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Avançar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Avançar1ActionPerformed

    private void Cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cancelar2ActionPerformed

    private void Cancelar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancelar2MouseClicked
        jDialog3.dispose();
    }//GEN-LAST:event_Cancelar2MouseClicked

    private void Avançar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Avançar2MouseClicked
        jDialog4.dispose();
    }//GEN-LAST:event_Avançar2MouseClicked

    private void Avançar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Avançar2ActionPerformed
     
    }//GEN-LAST:event_Avançar2ActionPerformed

    private void AvançarExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AvançarExcluirMouseClicked
        // TODO add your handling code here:
        jDialog5.dispose();
        
        jDialog6.setLocationRelativeTo(null);
        jDialog6.setModal(true);
        jDialog6.setUndecorated(true);
        jDialog6.setVisible(true);
    }//GEN-LAST:event_AvançarExcluirMouseClicked

    private void AvançarExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvançarExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AvançarExcluirActionPerformed

    private void CancelarExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarExcluirActionPerformed

    private void excluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirMouseClicked
        // TODO add your handling code here:
        jDialog5.setLocationRelativeTo(null);
        jDialog5.setModal(true);
        jDialog5.setUndecorated(true);
        jDialog5.setVisible(true);
    }//GEN-LAST:event_excluirMouseClicked

    private void Avançar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Avançar3MouseClicked
        // TODO add your handling code here:
        jDialog6.dispose();
        jDialog7.setLocationRelativeTo(null);
        jDialog7.setModal(true);
        jDialog7.setUndecorated(true);
        jDialog7.setVisible(true);
    }//GEN-LAST:event_Avançar3MouseClicked

    private void Avançar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Avançar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Avançar3ActionPerformed

    private void CancelarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarContaMouseClicked
        // TODO add your handling code here:
        jDialog6.dispose();
    }//GEN-LAST:event_CancelarContaMouseClicked

    private void CancelarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarContaActionPerformed

    private void CancelarExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarExcluirMouseClicked
        jDialog5.dispose();
    }//GEN-LAST:event_CancelarExcluirMouseClicked

    private void Avançar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Avançar4MouseClicked
        // TODO add your handling code here:
        jDialog7.dispose();
    }//GEN-LAST:event_Avançar4MouseClicked

    private void Avançar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Avançar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Avançar4ActionPerformed

    private void btnAvancar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvancar1MouseClicked

    private void btnVoltar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltar1MouseClicked

    private void ImgCard40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard40MouseClicked
        // Evento de clicar no card do jogo indice 19
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[19];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard40MouseClicked

    private void ImgCard39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard39MouseClicked
        // Evento de clicar no card do jogo indice 18
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[18];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard39MouseClicked

    private void ImgCard38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard38MouseClicked
        // Evento de clicar no card do jogo indice 17
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[17];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard38MouseClicked

    private void ImgCard37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard37MouseClicked
        // Evento de clicar no card do jogo indice 16
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[16];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard37MouseClicked

    private void ImgCard36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard36MouseClicked
        // Evento de clicar no card do jogo indice 15
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[15];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard36MouseClicked

    private void ImgCard32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard32MouseClicked
       // Evento de clicar no card do jogo indice 11
       jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[11];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard32MouseClicked

    private void ImgCard34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard34MouseClicked
        // Evento de clicar no card do jogo indice 13
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[13];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard34MouseClicked

    private void ImgCard31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard31MouseClicked
        // Evento de clicar no card do jogo indice 10
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[10];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard31MouseClicked

    private void ImgCard33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard33MouseClicked
        // Evento de clicar no card do jogo indice 12
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[12];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard33MouseClicked

    private void ImgCard35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard35MouseClicked
        // Evento de clicar no card do jogo indice 14
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[14];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard35MouseClicked

    private void ImgCard30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard30MouseClicked
        // Evento de clicar no card do jogo indice 9
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[9];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard30MouseClicked

    private void ImgCard29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard29MouseClicked
       // Evento de clicar no card do jogo indice 8
       jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[8];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard29MouseClicked

    private void ImgCard28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard28MouseClicked
        // Evento de clicar no card do jogo indice 7
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[7];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard28MouseClicked

    private void ImgCard27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard27MouseClicked
        // Evento de clicar no card do jogo indice 6
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[6];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard27MouseClicked

    private void ImgCard26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard26MouseClicked
        // Evento de clicar no card do jogo indice 5
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[5];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard26MouseClicked

    private void ImgCard24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard24MouseClicked
        // Evento de clicar no card do jogo indice 3
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[3];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard24MouseClicked

    private void ImgCard23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard23MouseClicked
        // Evento de clicar no card do jogo indice 2
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[2];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard23MouseClicked

    private void ImgCard25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard25MouseClicked
        // Evento de clicar no card do jogo indice 4
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[4];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard25MouseClicked

    private void ImgCard22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard22MouseClicked
        // Evento de clicar no card do jogo indice 1
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[1];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard22MouseClicked

    private void ImgCard21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard21MouseClicked
        // Evento de clicar no card do jogo indice 0
        jTabbedPane1.setSelectedIndex(3);
        ID_BUSCAR = ID_CARD_LOJA[0];
        BuscarJogo();
        System.out.println(ID_BUSCAR);
    }//GEN-LAST:event_ImgCard21MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void TituloPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TituloPrincipalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloPrincipalMouseClicked

    private void jLabel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel115MouseClicked

    private void TituloJogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TituloJogoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloJogoMouseClicked

    private void jLabel116MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel116MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel116MouseClicked

    private void publicar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publicar2ActionPerformed

    private void publicar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publicar3ActionPerformed

    private void jLabel117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel117MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel117MouseClicked

    private void jLabel150MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel150MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel150MouseClicked

    private void sVGImage6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage6MouseClicked
jTabbedPane1.setSelectedIndex(2);        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage6MouseClicked

    private void editarNome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarNome1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editarNome1MouseClicked

    private void img1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseClicked
        // onCLICK DA IMAGEM DO JOGO 1
        try{                            
        String URL_IMG = url_img1;             
        URL imageUrl = new URL(URL_IMG);
        Image image = ImageIO.read(imageUrl);
        ImgPrincipal.setIcon(new ImageIcon(image));
   
        }catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_img1MouseClicked

    private void img2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img2MouseClicked
        // onCLICK DA IMAGEM DO JOGO 2
        try{                            
        String URL_IMG = url_img2;             
        URL imageUrl = new URL(URL_IMG);
        Image image = ImageIO.read(imageUrl);
        ImgPrincipal.setIcon(new ImageIcon(image));
   
        }catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_img2MouseClicked

    private void img3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img3MouseClicked
        try{                            
        String URL_IMG = url_img3;             
        URL imageUrl = new URL(URL_IMG);
        Image image = ImageIO.read(imageUrl);
        ImgPrincipal.setIcon(new ImageIcon(image));
   
        }catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_img3MouseClicked

    private void img4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img4MouseClicked
        try{                            
        String URL_IMG = url_img4;             
        URL imageUrl = new URL(URL_IMG);
        Image image = ImageIO.read(imageUrl);
        ImgPrincipal.setIcon(new ImageIcon(image));
   
        }catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_img4MouseClicked

    private void img5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img5MouseClicked
        try{                            
        String URL_IMG = url_img5;             
        URL imageUrl = new URL(URL_IMG);
        Image image = ImageIO.read(imageUrl);
        ImgPrincipal.setIcon(new ImageIcon(image));
   
        }catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_img5MouseClicked

    private void publicar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publicar3MouseClicked
        publicar3.setText("Instalando");
    }//GEN-LAST:event_publicar3MouseClicked
    
    
    public String lerDados() {
        String linha = null; // Variável para armazenar a primeira linha
        String path = "src/conexao/Token.txt"; // Caminho do arquivo

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            linha = reader.readLine(); // Lê apenas a primeira linha
        } catch (IOException e) {
            e.printStackTrace(); // Imprime a pilha de exceções se ocorrer um erro
        }

        return linha; // Retorna a primeira linha lida
    }

   
    
    
    
    
    //Comentei
    
    
    public void CarregarJogos(boolean voltou, boolean recarregar){
        try{ 
            String pesquisa = "SELECT ID_cliente FROM cliente WHERE token = '" + token + "'";
               
            conexao.executaSQL(pesquisa);         
            if(conexao.resultset != null && conexao.resultset.first()){
                String id = ""+conexao.resultset.getString("ID_cliente");    
                System.out.println("Pesquisou ID: "+id);
                ID_usuario = id;
                
            }else{
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        System.out.println("Id usuario: "+ID_usuario);
            JPanel[] JPanel = {
            PanelCard1, PanelCard2, PanelCard3, PanelCard4, PanelCard5,
            PanelCard6, PanelCard7, PanelCard8, PanelCard9, PanelCard10,
            PanelCard11, PanelCard12, PanelCard13, PanelCard14, PanelCard15,
            PanelCard16, PanelCard17, PanelCard18, PanelCard19, PanelCard20, ocultoPanel2
            };
            JLabel[] labels = {
            TextCard1, TextCard2, TextCard3, TextCard4, TextCard5, 
            TextCard6, TextCard7, TextCard8, TextCard9, TextCard10, 
            TextCard11, TextCard12, TextCard13, TextCard14, TextCard15, 
            TextCard16, TextCard17, TextCard18, TextCard19, TextCard20, OcultoText2
            };
            JLabel[] ImgCard = {
            ImgCard1, ImgCard2, ImgCard3, ImgCard4, ImgCard5, 
            ImgCard6, ImgCard7, ImgCard8, ImgCard9, ImgCard10, 
            ImgCard11, ImgCard12, ImgCard13, ImgCard14, ImgCard15, 
            ImgCard16, ImgCard17, ImgCard18, ImgCard19, ImgCard20, OcultoImgCard2
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
            System.out.println("ID FINAL:" +ID_usuario);
            String pesquisa = "SELECT "
           + "jogo.ID_jogo, "
           + "jogo.titulo_do_jogo, "
           + "(SELECT URL_imagem "
           + " FROM imagens_jogo "
           + " WHERE imagens_jogo.ID_jogo = jogo.ID_jogo "
           + "   AND imagens_jogo.tipo_imagem = 2 "
           + " LIMIT 1) AS URL_imagem "
           + "FROM jogo "
           + "INNER JOIN jogos_adquiridos ON jogos_adquiridos.ID_jogo = jogo.ID_jogo "
           + "INNER JOIN colecao_jogos ON jogos_adquiridos.ID_colecao = colecao_jogos.ID_colecao "
           + "WHERE colecao_jogos.ID_cliente = "+ID_usuario + " "
           + "ORDER BY jogo.ID_jogo ASC "
           + "LIMIT 21 OFFSET " + offset + ";";
                  conexao.executaSQL(pesquisa);
            
            String titulo_jogo;
            String URL_IMG;
            
 
            if(conexao.resultset != null && conexao.resultset.first()){
                System.out.println();
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
                    ID_CARD[i] = ""+conexao.resultset.getString("ID_jogo");
                    System.out.println("ID CARD = "+ID_CARD[i]);
                    titulo_jogo = ""+conexao.resultset.getString("titulo_do_jogo");
                    URL_IMG = ""+conexao.resultset.getString("URL_imagem");               
                    URL imageUrl = new URL(URL_IMG);
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
    
    public void CarregarJogosAleatorios(boolean voltou, boolean recarregar){  
            JPanel[] JPanel = {
                PanelCard21, PanelCard22, PanelCard23, PanelCard24, PanelCard25,
                PanelCard26, PanelCard27, PanelCard28, PanelCard29, PanelCard30,
                PanelCard31, PanelCard32, PanelCard33, PanelCard34, PanelCard35,
                PanelCard36, PanelCard37, PanelCard38, PanelCard39, PanelCard40, ocultoPanel
            };
            JLabel[] labels = {
                TextCard21, TextCard22, TextCard23, TextCard24, TextCard25, 
                TextCard26, TextCard27, TextCard28, TextCard29, TextCard30, 
                TextCard31, TextCard32, TextCard33, TextCard34, TextCard35, 
                TextCard36, TextCard37, TextCard38, TextCard39, TextCard40, OcultoText
            };
            JLabel[] ImgCard = {
                ImgCard21, ImgCard22, ImgCard23, ImgCard24, ImgCard25, 
                ImgCard26, ImgCard27, ImgCard28, ImgCard29, ImgCard30, 
                ImgCard31, ImgCard32, ImgCard33, ImgCard34, ImgCard35, 
                ImgCard36, ImgCard37, ImgCard38, ImgCard39, ImgCard40, jLabel9
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
              offset2 = offset2;
            }
            else if(voltou == false){
              offset2 += 20; 
              System.out.println("Avançou");
            }else{
              offset2 -= 20;
              System.out.println("Voltou");
            }
            
            String pesquisa = "SELECT jogo.ID_jogo, jogo.titulo_do_jogo, imagens_jogo.URL_imagem " +
                  "FROM jogo " +
                  "JOIN imagens_jogo ON jogo.ID_jogo = imagens_jogo.ID_jogo " +
                  "WHERE imagens_jogo.tipo_imagem = 2 " +
                  "ORDER BY jogo.ID_jogo ASC LIMIT 21 OFFSET " + offset2 + ";";
                  conexao.executaSQL(pesquisa);
            
            String titulo_jogo;
            String URL_IMG;
            
 
            if(conexao.resultset != null && conexao.resultset.first()){
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
                    ID_CARD_LOJA[i] = ""+conexao.resultset.getString("ID_jogo");
                    titulo_jogo = ""+conexao.resultset.getString("titulo_do_jogo");
                    URL_IMG = ""+conexao.resultset.getString("URL_imagem");               
                    URL imageUrl = new URL(URL_IMG);
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
    
    public void BuscarJogo(){  
        

            String idDesenvolvedor = "";
           try{ 
            String pesquisa = "SELECT * " +
                  "FROM jogo " +
                  "JOIN imagens_jogo ON jogo.ID_jogo = imagens_jogo.ID_jogo " +
                  "WHERE jogo.ID_jogo = '" + ID_BUSCAR + "'";
            
                  
                  conexao.executaSQL(pesquisa);
            
            String titulo_jogo;
            String URL_IMG;
            
 
            if(conexao.resultset != null && conexao.resultset.first()){
                    
                System.out.println("Rodou a pesquisa do jogo");
                idDesenvolvedor = ""+conexao.resultset.getString("ID_desenvolvedor");
                
                String requisitos = ""+conexao.resultset.getString("requisitos");
                String[] partes = requisitos.split("#");
                
                minimo1.setText("<html>" + partes[0] + "</html>");
                minimo2.setText("<html>" + partes[1] + "</html>");
                minimo3.setText("<html>" + partes[2] + "</html>");
                minimo4.setText("<html>" + partes[3] + "</html>");
                minimo5.setText("<html>" + partes[4] + "</html>");
                
                recomendado1.setText("<html>" + partes[5] + "</html>");
                recomendado2.setText("<html>" + partes[6] + "</html>");
                recomendado3.setText("<html>" + partes[7] + "</html>");
                recomendado4.setText("<html>" + partes[8] + "</html>");
                recomendado5.setText("<html>" + partes[9] + "</html>");
                

                titulo_jogo = ""+conexao.resultset.getString("titulo_do_jogo");
                String sinopse = ""+conexao.resultset.getString("sinopse");
                String data_publicacao = ""+conexao.resultset.getString("data_publicacao");
                String classificacao = ""+conexao.resultset.getString("classificacao_indicativa");
                String[] dataSplit = data_publicacao.split("-");
                
                String descricao_jogo = ""+conexao.resultset.getString("descricao_jogo");
                URL_IMG = ""+conexao.resultset.getString("URL_imagem");               
                URL imageUrl = new URL(URL_IMG);
                Image image = ImageIO.read(imageUrl);
                
                System.out.println("titulo: " + titulo_jogo);
                //JPanel[i].setVisible(true);
                Sinopse.setText("<html> " + sinopse + " </html>");
                descricao.setText("<html> " + descricao_jogo + " </html>");
                TituloJogo.setText("<html>" + titulo_jogo + "</html>");      
                TituloPrincipal.setText("<html>" + titulo_jogo + "</html>");
                data_public.setText("<html> " + dataSplit[2]+"/"+dataSplit[1]+"/"+dataSplit[0]+" </html>"); 
                ImgPrincipal.setIcon(new ImageIcon(image));
                System.out.println(classificacao);
                if(classificacao.equals("18")){
                    ImageIcon icon = new ImageIcon("src/imagens/classificação/classificacao-18-anos-logo-1.png"); // Substitua pelo caminho da sua imagem
                    imgClassificacao.setIcon(icon);
                }else if(classificacao.equals("16")){
                    ImageIcon icon = new ImageIcon("src/imagens/classificação/classificacao-16-anos-logo.png"); // Substitua pelo caminho da sua imagem
                    imgClassificacao.setIcon(icon);
                }else if(classificacao.equals("14")){
                    ImageIcon icon = new ImageIcon("src/imagens/classificação/classificacao-14-anos-logo.png"); // Substitua pelo caminho da sua imagem
                    imgClassificacao.setIcon(icon);
                }else if(classificacao.equals("12")){
                    ImageIcon icon = new ImageIcon("src/imagens/classificação/classificacao-12-anos-logo.png"); // Substitua pelo caminho da sua imagem
                    imgClassificacao.setIcon(icon);
                }else if(classificacao.equals("10")){
                    ImageIcon icon = new ImageIcon("src/imagens/classificação/classificacao-10-anos-logo.png"); // Substitua pelo caminho da sua imagem
                    imgClassificacao.setIcon(icon);
                }else{
                    ImageIcon icon = new ImageIcon("src/imagens/classificação/classificacao-livre-anos-logo"); // Substitua pelo caminho da sua imagem
                    imgClassificacao.setIcon(icon);
                }
                    
                }else{
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
           
     //Faz a consulta dos dados da desenvolvedora      
           try{ 
            String pesquisa = "SELECT * FROM desenvolvedor WHERE ID_desenvolvedor = '" + idDesenvolvedor + "'";
               
            conexao.executaSQL(pesquisa);         
            if(conexao.resultset != null && conexao.resultset.first()){
                    
                System.out.println("Rodou a pesquisa da desenvolvedora");
                String nome = ""+conexao.resultset.getString("nome");
                
                nomeDesenvolvedor.setText("<html> " + nome + " </html>");


                }else{
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
           
           //carrega todas as imagens do jogo
           
           try{ 
            String URL_IMG;
            String pesquisa = "SELECT * " +
                  "FROM imagens_jogo " +
                  "WHERE  ID_jogo = '" + ID_BUSCAR + "'";
            
                  
                  conexao.executaSQL(pesquisa);         
            if(conexao.resultset != null && conexao.resultset.first()){
                      int i=0;         
                do {      
                    i++;
                    URL_IMG = ""+conexao.resultset.getString("URL_imagem");               
                    URL imageUrl = new URL(URL_IMG);
                    Image image = ImageIO.read(imageUrl);
   
                          
                    if(i == 1){
                      img1.setIcon(new ImageIcon(image));
                      url_img1 = ""+conexao.resultset.getString("URL_imagem");
                    }else if(i == 2){
                      img2.setIcon(new ImageIcon(image));
                      url_img2 = ""+conexao.resultset.getString("URL_imagem");
                    }else if(i== 3){
                      img3.setIcon(new ImageIcon(image)); 
                      url_img3 = ""+conexao.resultset.getString("URL_imagem");
                    }else if(i == 4){   
                      img4.setIcon(new ImageIcon(image));
                      url_img4 = ""+conexao.resultset.getString("URL_imagem");
                    }else if(i ==5){
                      img5.setIcon(new ImageIcon(image));  
                      url_img5 = ""+conexao.resultset.getString("URL_imagem");
                    }else if(i ==7){
                      capaJogo.setIcon(new ImageIcon(image));  
                    }
               
                } while (conexao.resultset.next());


                }else{
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           //Carregar categorias
            
           String categorias = "";
           String pesquisa = "SELECT * "
                   + "FROM categoria "
                   + "INNER JOIN jogo_categoria ON categoria.ID_categoria = jogo_categoria.ID_categoria "
                   + "WHERE jogo_categoria.ID_jogo = '" + ID_BUSCAR + "'";
       
                  conexao.executaSQL(pesquisa);         
        try {
            if(conexao.resultset != null && conexao.resultset.first()){
                
                do {
                   System.out.println(""+conexao.resultset.getString("ID_categoria"));               
                   categorias = categorias  +conexao.resultset.getString("nome_categoria")+ ", "; 

                } while (conexao.resultset.next());
                System.out.println(""+categorias);
                categoriasJogo.setText("<html>" + categorias + "</html>");
                
            }
        } catch (SQLException ex) { 
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Carregar idiomas
        
        String idiomas = "";
        pesquisa = "SELECT * "
                   + "FROM idioma "
                   + "INNER JOIN jogo_idioma ON idioma.ID_idioma = jogo_idioma.ID_idioma "
                   + "WHERE jogo_idioma.ID_jogo = '" + ID_BUSCAR + "'";
 
       
                  conexao.executaSQL(pesquisa);         
        try {
            if(conexao.resultset != null && conexao.resultset.first()){
                System.out.println(""+conexao.resultset.getString("ID_idioma"));
                do {
                   System.out.println(""+conexao.resultset.getString("ID_idioma"));               
                   idiomas = idiomas  +conexao.resultset.getString("nome_idioma")+ ", "; 

                } while (conexao.resultset.next());
                System.out.println(""+idiomas);
                idiomasJogo.setText("<html>" + idiomas + "</html>");
                
            }
        } catch (SQLException ex) { 
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public void CadastrarCategoria(int ID_jogo, List<Integer> categoriasSelecionadas){
           
            for(int categoria : categoriasSelecionadas) {               
                try{   
                    String insert_sql="insert into jogo_categoria (ID_jogo, ID_categoria) values ('" +ID_jogo+ "','" +categoria+"' )";
                    conexao.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação da Categoria Realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    
     }
                
   }
       
   }
    
    public void CadastrarIdiomas(int ID_jogo, List<Integer> idiomaSelecionados){
           
            for(int idioma : idiomaSelecionados) {               
                try{   
                    String insert_sql="insert into jogo_idioma (ID_jogo, ID_idioma) values ('" +ID_jogo+ "','" +idioma+"' )";
                    conexao.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação do idioma Realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    
     }
                
   }
       
   }
    
    public void BuscarIdUsuario(String token){
        try{ 
            String pesquisa = "SELECT ID_cliente FROM cliente WHERE ID_cliente = '" + token + "'";
               
            conexao.executaSQL(pesquisa);         
            if(conexao.resultset != null && conexao.resultset.first()){
                String id = ""+conexao.resultset.getString("ID_cliente");    
                System.out.println("Pesquisou ID: "+id);
                
            }else{
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void CadastrarImagens(int ID_jogo, String[] URLs){
        int TipoImagem = 0;
               for (int i = 0; i < 5; i++) {
               TipoImagem = 1; // Imagens do jogo
               String URL_imagem = URLs[0]; 
               Upload UpImagens = new Upload("http://tcloud.site/Vinicius/Vortex/UploadImagens.php", URLs[i]);
               String NomeImagem = "http://tcloud.site/Vinicius/Vortex/FotosJogos/"+UpImagens.nomeFile;
               System.out.println("Imagem Upada: "+NomeImagem);
               System.out.println("URL_imagem");
                      
                try{   
                    String insert_sql="insert into imagens_jogo (ID_jogo, URL_imagem, tipo_imagem) values ('" +ID_jogo+ "','" +NomeImagem + "','" +TipoImagem+"' )";
                    conexao.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação das imagens Realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    
     }
   }
        TipoImagem = 2; // Capa do Jogo
        String URL_imagem = URLs[5]; 
        Upload UpCapa = new Upload("http://tentreosbrothers.shop/Vinicius/Vortex/UploadImagens.php", URLs[5]);
        String NomeImagem = "http://tentreosbrothers.shop/Vinicius/Vortex/FotosJogos/"+UpCapa.nomeFile;
        System.out.println("cassio gaymer "+NomeImagem);
        System.out.println("URL_imagem");
        try{   
            String insert_sql="insert into imagens_jogo (ID_jogo, URL_imagem, tipo_imagem) values ('" +ID_jogo+ "','" +NomeImagem + "','" +TipoImagem+"' )";
            conexao.statement.executeUpdate(insert_sql);
           JOptionPane.showMessageDialog(null, "Gravação das imagens Realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    
     }
        
        TipoImagem = 3; // Poster do Jogo
        URL_imagem = URLs[6]; 
        Upload UpPoster = new Upload("http://tentreosbrothers.shop/Vinicius/Vortex/UploadImagens.php", URLs[6]);
        NomeImagem = "http://tentreosbrothers.shop/Vinicius/Vortex/FotosJogos/"+UpPoster.nomeFile;
        System.out.println("cassio gaymer "+NomeImagem);
        System.out.println("URL_imagem");
        try{   
            String insert_sql="insert into imagens_jogo (ID_jogo, URL_imagem, tipo_imagem) values ('" +ID_jogo+ "','" +NomeImagem + "','" +TipoImagem+"' )";
            conexao.statement.executeUpdate(insert_sql);
           JOptionPane.showMessageDialog(null, "Gravação das imagens Realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    
     }
        
        TipoImagem = 10; // Jogo
        URL_imagem = URLs[7]; 
        Upload UpJogo = new Upload("http://tentreosbrothers.shop/Vinicius/Vortex/UploadImagens.php", URLs[7]);
        NomeImagem = "http://tentreosbrothers.shop/Vinicius/Vortex/Jogos/"+UpJogo.nomeFile;
        System.out.println(""+NomeImagem);
        System.out.println("URL_imagem");
        try{   
            String insert_sql="insert into imagens_jogo (ID_jogo, URL_imagem, tipo_imagem) values ('" +ID_jogo+ "','" +NomeImagem + "','" +TipoImagem+"' )";
            conexao.statement.executeUpdate(insert_sql);
           JOptionPane.showMessageDialog(null, "Gravação das imagens Realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    
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
    private com.raven.swing.Button Avançar;
    private com.raven.swing.Button Avançar1;
    private com.raven.swing.Button Avançar2;
    private com.raven.swing.Button Avançar3;
    private com.raven.swing.Button Avançar4;
    private com.raven.swing.Button AvançarExcluir;
    private com.raven.swing.Button Cancelar1;
    private com.raven.swing.Button Cancelar2;
    private com.raven.swing.Button CancelarConta;
    private com.raven.swing.Button CancelarExcluir;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel EmailPuxado;
    private imagens.SVGImage Flag;
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
    private javax.swing.JLabel ImgCard21;
    private javax.swing.JLabel ImgCard22;
    private javax.swing.JLabel ImgCard23;
    private javax.swing.JLabel ImgCard24;
    private javax.swing.JLabel ImgCard25;
    private javax.swing.JLabel ImgCard26;
    private javax.swing.JLabel ImgCard27;
    private javax.swing.JLabel ImgCard28;
    private javax.swing.JLabel ImgCard29;
    private javax.swing.JLabel ImgCard3;
    private javax.swing.JLabel ImgCard30;
    private javax.swing.JLabel ImgCard31;
    private javax.swing.JLabel ImgCard32;
    private javax.swing.JLabel ImgCard33;
    private javax.swing.JLabel ImgCard34;
    private javax.swing.JLabel ImgCard35;
    private javax.swing.JLabel ImgCard36;
    private javax.swing.JLabel ImgCard37;
    private javax.swing.JLabel ImgCard38;
    private javax.swing.JLabel ImgCard39;
    private javax.swing.JLabel ImgCard4;
    private javax.swing.JLabel ImgCard40;
    private javax.swing.JLabel ImgCard5;
    private javax.swing.JLabel ImgCard6;
    private javax.swing.JLabel ImgCard7;
    private javax.swing.JLabel ImgCard8;
    private javax.swing.JLabel ImgCard9;
    private javax.swing.JLabel ImgPrincipal;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField Nome2;
    private javax.swing.JLabel OcultoImgCard2;
    private javax.swing.JLabel OcultoText;
    private javax.swing.JLabel OcultoText2;
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
    private javax.swing.JPanel PanelCard21;
    private javax.swing.JPanel PanelCard22;
    private javax.swing.JPanel PanelCard23;
    private javax.swing.JPanel PanelCard24;
    private javax.swing.JPanel PanelCard25;
    private javax.swing.JPanel PanelCard26;
    private javax.swing.JPanel PanelCard27;
    private javax.swing.JPanel PanelCard28;
    private javax.swing.JPanel PanelCard29;
    private javax.swing.JPanel PanelCard3;
    private javax.swing.JPanel PanelCard30;
    private javax.swing.JPanel PanelCard31;
    private javax.swing.JPanel PanelCard32;
    private javax.swing.JPanel PanelCard33;
    private javax.swing.JPanel PanelCard34;
    private javax.swing.JPanel PanelCard35;
    private javax.swing.JPanel PanelCard36;
    private javax.swing.JPanel PanelCard37;
    private javax.swing.JPanel PanelCard38;
    private javax.swing.JPanel PanelCard39;
    private javax.swing.JPanel PanelCard4;
    private javax.swing.JPanel PanelCard40;
    private javax.swing.JPanel PanelCard5;
    private javax.swing.JPanel PanelCard6;
    private javax.swing.JPanel PanelCard7;
    private javax.swing.JPanel PanelCard8;
    private javax.swing.JPanel PanelCard9;
    private com.raven.swing.Button Salvar;
    private com.raven.swing.Button Senha;
    private javax.swing.JLabel Sinopse;
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
    private javax.swing.JLabel TextCard21;
    private javax.swing.JLabel TextCard22;
    private javax.swing.JLabel TextCard23;
    private javax.swing.JLabel TextCard24;
    private javax.swing.JLabel TextCard25;
    private javax.swing.JLabel TextCard26;
    private javax.swing.JLabel TextCard27;
    private javax.swing.JLabel TextCard28;
    private javax.swing.JLabel TextCard29;
    private javax.swing.JLabel TextCard3;
    private javax.swing.JLabel TextCard30;
    private javax.swing.JLabel TextCard31;
    private javax.swing.JLabel TextCard32;
    private javax.swing.JLabel TextCard33;
    private javax.swing.JLabel TextCard34;
    private javax.swing.JLabel TextCard35;
    private javax.swing.JLabel TextCard36;
    private javax.swing.JLabel TextCard37;
    private javax.swing.JLabel TextCard38;
    private javax.swing.JLabel TextCard39;
    private javax.swing.JLabel TextCard4;
    private javax.swing.JLabel TextCard40;
    private javax.swing.JLabel TextCard5;
    private javax.swing.JLabel TextCard6;
    private javax.swing.JLabel TextCard7;
    private javax.swing.JLabel TextCard8;
    private javax.swing.JLabel TextCard9;
    private javax.swing.JLabel TituloJogo;
    private javax.swing.JLabel TituloPrincipal;
    private javax.swing.JPanel btnAvancar;
    private javax.swing.JPanel btnAvancar1;
    private javax.swing.JPanel btnVoltar;
    private javax.swing.JPanel btnVoltar1;
    private com.raven.swing.Button button1;
    private javax.swing.JLabel capaJogo;
    private javax.swing.JLabel categoriasJogo;
    private javax.swing.JLabel data_public;
    private javax.swing.JLabel descricao;
    private imagens.SVGImage editarEmail;
    private imagens.SVGImage editarFoto;
    private imagens.SVGImage editarNome;
    private imagens.SVGImage editarNome1;
    private com.raven.swing.Button excluir;
    private javax.swing.JLabel idiomasJogo;
    private com.raven.Perfil.ImageAvatar imageAvatar1;
    private javaswingdev.ImageReajust img1;
    private javaswingdev.ImageReajust img2;
    private javaswingdev.ImageReajust img3;
    private javaswingdev.ImageReajust img4;
    private javaswingdev.ImageReajust img5;
    private javax.swing.JLabel imgClassificacao;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog6;
    private javax.swing.JDialog jDialog7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
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
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
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
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField jTextField1;
    private javax.swing.JPasswordField jTextField2;
    private javax.swing.JPasswordField jTextField3;
    private javax.swing.JPasswordField jTextField5;
    private javax.swing.JPasswordField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel minimo1;
    private javax.swing.JLabel minimo2;
    private javax.swing.JLabel minimo3;
    private javax.swing.JLabel minimo4;
    private javax.swing.JLabel minimo5;
    private javax.swing.JLabel nomeDesenvolvedor;
    private javax.swing.JPanel ocultoPanel;
    private javax.swing.JPanel ocultoPanel2;
    private javax.swing.JLabel paisLabel;
    private com.raven.swing.combobox.PanelRounds panelRounds18;
    private com.raven.swing.combobox.PanelRounds panelRounds19;
    private com.raven.swing.Button publicar2;
    private com.raven.swing.Button publicar3;
    private javax.swing.JLabel recomendado1;
    private javax.swing.JLabel recomendado2;
    private javax.swing.JLabel recomendado3;
    private javax.swing.JLabel recomendado4;
    private javax.swing.JLabel recomendado5;
    private imagens.SVGImage sVGImage1;
    private imagens.SVGImage sVGImage10;
    private imagens.SVGImage sVGImage2;
    private imagens.SVGImage sVGImage27;
    private imagens.SVGImage sVGImage28;
    private imagens.SVGImage sVGImage29;
    private imagens.SVGImage sVGImage3;
    private imagens.SVGImage sVGImage31;
    private imagens.SVGImage sVGImage4;
    private imagens.SVGImage sVGImage5;
    private imagens.SVGImage sVGImage6;
    private imagens.SVGImage sVGImage7;
    private imagens.SVGImage sVGImage8;
    private imagens.SVGImage sVGImage9;
    private javaswingdev.SimpleTitleBar simpleTitleBar1;
    // End of variables declaration//GEN-END:variables
}
//sVGImage6