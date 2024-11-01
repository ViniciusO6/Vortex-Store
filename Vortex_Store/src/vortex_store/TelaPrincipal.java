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
/**
 *
 * @author vinic 
 */

public class TelaPrincipal extends javax.swing.JFrame {
    Conexao conexao;
    String URLs[] = new String[8];
    int offset = -20;
    int[] ID_CARD = new int[20] ;
    int ID_BUSCAR;
    int linhas = 0;
    int avancou = 0;
    boolean MaisJogos;
    
    ScrollBarCustom scrollBarCustom = new  ScrollBarCustom();
    
    public TelaPrincipal() {
        conexao = new Conexao(); 
        conexao.conecta(false);
        
        
        
        initComponents();
        jTabbedPane1.setSelectedIndex(1);
        EmailPuxado.setText("vinifernandes");
        
        btnVoltar.setVisible(false);
        btnAvancar.setVisible(false);
        
        CarregarJogos(false, false);
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
        
        //Tela de meus jogos
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        this.jScrollPane3.getVerticalScrollBar().setUnitIncrement(30);//rolagem rapida
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

        sVGImage11.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        sVGImage12.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage12.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar sVGImage6
            }
        });
                sVGImage13.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage13.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage14.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage14.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage15.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage15.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage16.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage16.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage16.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage18.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage18.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage18.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
        sVGImage17.setSvgImage("imagens/icones/arquivo.svg", 30, 30);
        sVGImage17.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage17.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Colocar função do botão de pesquisar
            }
        });
        
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
                jTabbedPane1.setSelectedIndex(6);
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
        PanelCard23 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        ImgCard23 = new javax.swing.JLabel();
        TextCard23 = new javax.swing.JLabel();
        PanelCard24 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        ImgCard24 = new javax.swing.JLabel();
        TextCard24 = new javax.swing.JLabel();
        PanelCard25 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        ImgCard25 = new javax.swing.JLabel();
        TextCard25 = new javax.swing.JLabel();
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
        PanelCard31 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        ImgCard31 = new javax.swing.JLabel();
        TextCard31 = new javax.swing.JLabel();
        PanelCard32 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        ImgCard32 = new javax.swing.JLabel();
        TextCard32 = new javax.swing.JLabel();
        PanelCard33 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        ImgCard33 = new javax.swing.JLabel();
        TextCard33 = new javax.swing.JLabel();
        PanelCard34 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        ImgCard34 = new javax.swing.JLabel();
        TextCard34 = new javax.swing.JLabel();
        PanelCard35 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        ImgCard35 = new javax.swing.JLabel();
        TextCard35 = new javax.swing.JLabel();
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
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        requisitos1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        requisitos2 = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        requisitos3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        requisitos4 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        requisitos5 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        requisitos10 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        requisitos6 = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        requisitos7 = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        requisitos8 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        requisitos9 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        NomeJogo = new javax.swing.JTextField();
        Classificacao = new com.raven.swing.combobox.ComboBoxSuggestion();
        jLabel16 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jCheckBoxCustom1 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom2 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom3 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom4 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom5 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom6 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom7 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom8 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom9 = new checkbox.JCheckBoxCustom();
        jLabel17 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        preco = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jCheckBoxCustom10 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom11 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom12 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom13 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom14 = new checkbox.JCheckBoxCustom();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Sinopse = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Descricao = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        PosterJogo = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        panelRounds3 = new com.raven.swing.combobox.PanelRounds();
        sVGImage12 = new imagens.SVGImage();
        jLabel38 = new javax.swing.JLabel();
        panelRounds2 = new com.raven.swing.combobox.PanelRounds();
        sVGImage11 = new imagens.SVGImage();
        jPanel38 = new javax.swing.JPanel();
        CapaJogo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        Imagem1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        panelRounds4 = new com.raven.swing.combobox.PanelRounds();
        sVGImage13 = new imagens.SVGImage();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        panelRounds5 = new com.raven.swing.combobox.PanelRounds();
        sVGImage14 = new imagens.SVGImage();
        jPanel41 = new javax.swing.JPanel();
        Imagem2 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        Imagem3 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        panelRounds6 = new com.raven.swing.combobox.PanelRounds();
        sVGImage15 = new imagens.SVGImage();
        panelRounds7 = new com.raven.swing.combobox.PanelRounds();
        sVGImage16 = new imagens.SVGImage();
        jPanel43 = new javax.swing.JPanel();
        Imagem4 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        panelRounds8 = new com.raven.swing.combobox.PanelRounds();
        sVGImage17 = new imagens.SVGImage();
        jLabel48 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        Imagem5 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        ArquivoJogo = new javax.swing.JTextField();
        panelRounds9 = new com.raven.swing.combobox.PanelRounds();
        sVGImage18 = new imagens.SVGImage();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        publicar = new com.raven.swing.Button();
        descartar = new com.raven.swing.Button();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel53 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        requisitos11 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        requisitos12 = new javax.swing.JTextField();
        jPanel88 = new javax.swing.JPanel();
        requisitos13 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        requisitos14 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        requisitos15 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        requisitos16 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        requisitos17 = new javax.swing.JTextField();
        jPanel92 = new javax.swing.JPanel();
        requisitos18 = new javax.swing.JTextField();
        jPanel93 = new javax.swing.JPanel();
        requisitos19 = new javax.swing.JTextField();
        jPanel94 = new javax.swing.JPanel();
        requisitos20 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        NomeJogo1 = new javax.swing.JTextField();
        Classificacao1 = new com.raven.swing.combobox.ComboBoxSuggestion();
        jLabel67 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jCheckBoxCustom15 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom16 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom17 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom18 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom19 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom20 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom21 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom22 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom23 = new checkbox.JCheckBoxCustom();
        jLabel68 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        preco1 = new javax.swing.JTextField();
        jPanel98 = new javax.swing.JPanel();
        jCheckBoxCustom24 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom25 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom26 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom27 = new checkbox.JCheckBoxCustom();
        jCheckBoxCustom28 = new checkbox.JCheckBoxCustom();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Sinopse1 = new javax.swing.JTextArea();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Descricao1 = new javax.swing.JTextArea();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jPanel100 = new javax.swing.JPanel();
        PosterJogo1 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        panelRounds10 = new com.raven.swing.combobox.PanelRounds();
        sVGImage19 = new imagens.SVGImage();
        jLabel76 = new javax.swing.JLabel();
        panelRounds11 = new com.raven.swing.combobox.PanelRounds();
        sVGImage20 = new imagens.SVGImage();
        jPanel101 = new javax.swing.JPanel();
        CapaJogo1 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jPanel103 = new javax.swing.JPanel();
        Imagem6 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        panelRounds12 = new com.raven.swing.combobox.PanelRounds();
        sVGImage21 = new imagens.SVGImage();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        panelRounds13 = new com.raven.swing.combobox.PanelRounds();
        sVGImage22 = new imagens.SVGImage();
        jPanel104 = new javax.swing.JPanel();
        Imagem7 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        Imagem8 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        panelRounds14 = new com.raven.swing.combobox.PanelRounds();
        sVGImage23 = new imagens.SVGImage();
        panelRounds15 = new com.raven.swing.combobox.PanelRounds();
        sVGImage24 = new imagens.SVGImage();
        jPanel106 = new javax.swing.JPanel();
        Imagem9 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        panelRounds16 = new com.raven.swing.combobox.PanelRounds();
        sVGImage25 = new imagens.SVGImage();
        jLabel87 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        Imagem10 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        ArquivoJogo1 = new javax.swing.JTextField();
        panelRounds17 = new com.raven.swing.combobox.PanelRounds();
        sVGImage26 = new imagens.SVGImage();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        publicar1 = new com.raven.swing.Button();
        descartar1 = new com.raven.swing.Button();
        jPanel109 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        button1 = new com.raven.swing.Button();
        imageAvatar1 = new com.raven.Perfil.ImageAvatar();
        editarPerfil = new imagens.SVGImage();
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

        jDialog2.setMaximumSize(new java.awt.Dimension(480, 300));
        jDialog2.setMinimumSize(new java.awt.Dimension(480, 300));
        jDialog2.setUndecorated(true);
        jDialog2.setPreferredSize(new java.awt.Dimension(480, 300));
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
        jPanel117.setBounds(0, 0, 480, 300);

        jDialog3.setMinimumSize(new java.awt.Dimension(600, 390));

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
                .addContainerGap(23, Short.MAX_VALUE)
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

        jDialog4.setMaximumSize(new java.awt.Dimension(480, 300));
        jDialog4.setMinimumSize(new java.awt.Dimension(480, 300));
        jDialog4.setModal(true);
        jDialog4.setUndecorated(true);
        jDialog4.setPreferredSize(new java.awt.Dimension(480, 300));
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
        jPanel119.setBounds(0, 0, 480, 300);

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
        jPanel121.setBounds(0, 0, 480, 300);

        jDialog6.setMinimumSize(new java.awt.Dimension(600, 390));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
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
        jPanel125.setBounds(0, 0, 480, 300);

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

        jPanel12.setBackground(new java.awt.Color(10, 15, 22));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel13.setBackground(new java.awt.Color(18, 22, 32));
        jPanel13.setMaximumSize(new java.awt.Dimension(1263, 1560));
        jPanel13.setMinimumSize(new java.awt.Dimension(1263, 1560));

        jLabel11.setBackground(new java.awt.Color(76, 31, 129));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Bibliosteca");
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

        PanelCard23.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(ImgCard23)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
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
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard23, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard23Layout.setVerticalGroup(
            PanelCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard23Layout.createSequentialGroup()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(ImgCard24)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
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
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard24, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard24Layout.setVerticalGroup(
            PanelCard24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard24Layout.createSequentialGroup()
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard25.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(ImgCard25)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
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
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard25, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard25Layout.setVerticalGroup(
            PanelCard25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard25Layout.createSequentialGroup()
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        PanelCard31.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(ImgCard31)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
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
                    .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard31, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard31Layout.setVerticalGroup(
            PanelCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard31Layout.createSequentialGroup()
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard31, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard32.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addComponent(ImgCard32)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
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
                    .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard32, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard32Layout.setVerticalGroup(
            PanelCard32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard32Layout.createSequentialGroup()
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard32, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelCard33.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(ImgCard33)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
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
                    .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard33, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard33Layout.setVerticalGroup(
            PanelCard33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard33Layout.createSequentialGroup()
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard33, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        PanelCard35.setBackground(new java.awt.Color(18, 22, 32));

        ImgCard35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DefaultImg.png"))); // NOI18N
        ImgCard35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgCard35MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(ImgCard35)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
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
                    .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCard35, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelCard35Layout.setVerticalGroup(
            PanelCard35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCard35Layout.createSequentialGroup()
                .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCard35, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(PanelCard33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(PanelCard31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(PanelCard24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(PanelCard23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(PanelCard23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCard25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCard33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCard32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel12);

        jPanel15.setBackground(new java.awt.Color(10, 15, 22));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel16.setBackground(new java.awt.Color(18, 22, 32));
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel16.setMaximumSize(new java.awt.Dimension(1195, 2200));
        jPanel16.setMinimumSize(new java.awt.Dimension(1195, 1890));
        jPanel16.setPreferredSize(new java.awt.Dimension(1195, 1890));
        jPanel16.setLayout(null);
        jPanel16.add(jSeparator1);
        jSeparator1.setBounds(270, 100, 760, 10);

        jLabel22.setBackground(new java.awt.Color(76, 31, 129));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Publicar Jogo");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel22);
        jLabel22.setBounds(270, 40, 228, 48);

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));
        jPanel22.setOpaque(false);

        jPanel36.setBackground(new java.awt.Color(50, 53, 60));

        requisitos1.setBackground(new java.awt.Color(50, 53, 60));
        requisitos1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos1.setForeground(new java.awt.Color(255, 255, 255));
        requisitos1.setBorder(null);
        requisitos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Sistema Operacional");

        jLabel14.setBackground(new java.awt.Color(76, 31, 129));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Requisitos mínimos");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Processador");

        jPanel35.setBackground(new java.awt.Color(50, 53, 60));

        requisitos2.setBackground(new java.awt.Color(50, 53, 60));
        requisitos2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos2.setForeground(new java.awt.Color(255, 255, 255));
        requisitos2.setBorder(null);
        requisitos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel34.setBackground(new java.awt.Color(50, 53, 60));

        requisitos3.setBackground(new java.awt.Color(50, 53, 60));
        requisitos3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos3.setForeground(new java.awt.Color(255, 255, 255));
        requisitos3.setBorder(null);
        requisitos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Memória RAM");

        jPanel33.setBackground(new java.awt.Color(50, 53, 60));

        requisitos4.setBackground(new java.awt.Color(50, 53, 60));
        requisitos4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos4.setForeground(new java.awt.Color(255, 255, 255));
        requisitos4.setBorder(null);
        requisitos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Placa de vídeo");

        jPanel37.setBackground(new java.awt.Color(50, 53, 60));

        requisitos5.setBackground(new java.awt.Color(50, 53, 60));
        requisitos5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos5.setForeground(new java.awt.Color(255, 255, 255));
        requisitos5.setBorder(null);
        requisitos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Armazenamento");

        jPanel31.setBackground(new java.awt.Color(50, 53, 60));

        requisitos10.setBackground(new java.awt.Color(50, 53, 60));
        requisitos10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos10.setForeground(new java.awt.Color(255, 255, 255));
        requisitos10.setBorder(null);
        requisitos10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos10, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel31.setBackground(new java.awt.Color(76, 31, 129));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Requisitos Recomendados");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Memória RAM");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Armazenamento");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Sistema Operacional");

        jPanel27.setBackground(new java.awt.Color(50, 53, 60));

        requisitos6.setBackground(new java.awt.Color(50, 53, 60));
        requisitos6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos6.setForeground(new java.awt.Color(255, 255, 255));
        requisitos6.setBorder(null);
        requisitos6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos6, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel28.setBackground(new java.awt.Color(50, 53, 60));

        requisitos7.setBackground(new java.awt.Color(50, 53, 60));
        requisitos7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos7.setForeground(new java.awt.Color(255, 255, 255));
        requisitos7.setBorder(null);
        requisitos7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos7, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel29.setBackground(new java.awt.Color(50, 53, 60));

        requisitos8.setBackground(new java.awt.Color(50, 53, 60));
        requisitos8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos8.setForeground(new java.awt.Color(255, 255, 255));
        requisitos8.setBorder(null);
        requisitos8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos8, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel30.setBackground(new java.awt.Color(50, 53, 60));

        requisitos9.setBackground(new java.awt.Color(50, 53, 60));
        requisitos9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos9.setForeground(new java.awt.Color(255, 255, 255));
        requisitos9.setBorder(null);
        requisitos9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos9, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Placa de vídeo");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Processador");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nome do Jogo");

        jPanel17.setBackground(new java.awt.Color(50, 53, 60));

        NomeJogo.setBackground(new java.awt.Color(50, 53, 60));
        NomeJogo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        NomeJogo.setForeground(new java.awt.Color(255, 255, 255));
        NomeJogo.setBorder(null);
        NomeJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeJogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Classificacao.setBackground(new java.awt.Color(50, 53, 60));
        Classificacao.setBorder(null);
        Classificacao.setEditable(false);
        Classificacao.setForeground(new java.awt.Color(255, 255, 255));
        Classificacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Livre", "+10", "+12", "+14", "+16", "+18", " " }));
        Classificacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Classificação");

        jPanel19.setBackground(new java.awt.Color(50, 53, 60));
        jPanel19.setMaximumSize(new java.awt.Dimension(147, 244));
        jPanel19.setMinimumSize(new java.awt.Dimension(147, 244));

        jCheckBoxCustom1.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom1.setText("Ação");
        jCheckBoxCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCustom1ActionPerformed(evt);
            }
        });

        jCheckBoxCustom2.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom2.setText("Aventura");

        jCheckBoxCustom3.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom3.setText("RPG");

        jCheckBoxCustom4.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom4.setText("Estratégia");

        jCheckBoxCustom5.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom5.setText("Simulação");

        jCheckBoxCustom6.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom6.setText("Esportes e Corrida");

        jCheckBoxCustom7.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom7.setText("Quebra-Cabeças");

        jCheckBoxCustom8.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom8.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom8.setText("Terror");

        jCheckBoxCustom9.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom9.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom9.setText("Casual");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jCheckBoxCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Preço do Jogo");

        jPanel20.setBackground(new java.awt.Color(50, 53, 60));

        preco.setBackground(new java.awt.Color(50, 53, 60));
        preco.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        preco.setForeground(new java.awt.Color(255, 255, 255));
        preco.setBorder(null);
        preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(preco, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.setBackground(new java.awt.Color(50, 53, 60));
        jPanel21.setMaximumSize(new java.awt.Dimension(147, 244));
        jPanel21.setMinimumSize(new java.awt.Dimension(147, 244));
        jPanel21.setPreferredSize(new java.awt.Dimension(147, 244));

        jCheckBoxCustom10.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom10.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom10.setText("Português");
        jCheckBoxCustom10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCustom10ActionPerformed(evt);
            }
        });

        jCheckBoxCustom11.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom11.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom11.setText("Espanhol");

        jCheckBoxCustom12.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom12.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom12.setText("Inglês");

        jCheckBoxCustom13.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom13.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom13.setText("Francês");

        jCheckBoxCustom14.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom14.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom14.setText("Japonês");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCustom10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jCheckBoxCustom10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Categoria");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Idioma");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Sinopse do Jogo");

        Sinopse.setBackground(new java.awt.Color(50, 53, 60));
        Sinopse.setColumns(20);
        Sinopse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Sinopse.setForeground(new java.awt.Color(255, 255, 255));
        Sinopse.setRows(5);
        Sinopse.setBorder(null);
        jScrollPane5.setViewportView(Sinopse);
        Sinopse.setLineWrap(true);  // Quebra de linha automática
        Sinopse.setWrapStyleWord(true);  // Quebra entre palavras

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Descrição do Jogo");

        Descricao.setBackground(new java.awt.Color(50, 53, 60));
        Descricao.setColumns(20);
        Descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Descricao.setForeground(new java.awt.Color(255, 255, 255));
        Descricao.setRows(5);
        jScrollPane4.setViewportView(Descricao);
        Descricao.setLineWrap(true);  // Quebra de linha automática
        Descricao.setWrapStyleWord(true);  // Quebra entre palavras

        jLabel29.setBackground(new java.awt.Color(76, 31, 129));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Capa e Pôster");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel39.setBackground(new java.awt.Color(76, 31, 129));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Imagens do Jogo");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        jPanel24.setOpaque(false);

        jPanel39.setBackground(new java.awt.Color(50, 53, 60));

        PosterJogo.setBackground(new java.awt.Color(50, 53, 60));
        PosterJogo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PosterJogo.setForeground(new java.awt.Color(255, 255, 255));
        PosterJogo.setBorder(null);
        PosterJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosterJogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PosterJogo))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PosterJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Pôster do Jogo (É exibido na compra)");

        panelRounds3.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds3.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds3.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds3.setRoundBottomLeft(5);
        panelRounds3.setRoundBottomRight(5);
        panelRounds3.setRoundTopLeft(5);
        panelRounds3.setRoundTopRight(5);
        panelRounds3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds3MouseClicked(evt);
            }
        });

        sVGImage12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage12.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage12.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage12.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds3Layout = new javax.swing.GroupLayout(panelRounds3);
        panelRounds3.setLayout(panelRounds3Layout);
        panelRounds3Layout.setHorizontalGroup(
            panelRounds3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds3Layout.setVerticalGroup(
            panelRounds3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("185x247");

        panelRounds2.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds2.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds2.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds2.setRoundBottomLeft(5);
        panelRounds2.setRoundBottomRight(5);
        panelRounds2.setRoundTopLeft(5);
        panelRounds2.setRoundTopRight(5);
        panelRounds2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds2MouseClicked(evt);
            }
        });

        sVGImage11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage11.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage11.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage11.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage11MouseClicked(evt);
            }
        });
        sVGImage11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sVGImage11KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelRounds2Layout = new javax.swing.GroupLayout(panelRounds2);
        panelRounds2.setLayout(panelRounds2Layout);
        panelRounds2Layout.setHorizontalGroup(
            panelRounds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds2Layout.setVerticalGroup(
            panelRounds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel38.setBackground(new java.awt.Color(50, 53, 60));

        CapaJogo.setBackground(new java.awt.Color(50, 53, 60));
        CapaJogo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        CapaJogo.setForeground(new java.awt.Color(255, 255, 255));
        CapaJogo.setBorder(null);
        CapaJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapaJogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CapaJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CapaJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Capa do Jogo (É exibido na loja)");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("185x247");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRounds2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRounds3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)))
                .addGap(14, 14, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel37))
                .addGap(5, 5, 5)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRounds2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38))
                .addGap(5, 5, 5)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel25.setOpaque(false);

        jPanel40.setBackground(new java.awt.Color(50, 53, 60));

        Imagem1.setBackground(new java.awt.Color(50, 53, 60));
        Imagem1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem1.setForeground(new java.awt.Color(255, 255, 255));
        Imagem1.setBorder(null);
        Imagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Imagem 1");

        panelRounds4.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds4.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds4.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds4.setRoundBottomLeft(5);
        panelRounds4.setRoundBottomRight(5);
        panelRounds4.setRoundTopLeft(5);
        panelRounds4.setRoundTopRight(5);
        panelRounds4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds4MouseClicked(evt);
            }
        });

        sVGImage13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage13.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage13.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage13.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds4Layout = new javax.swing.GroupLayout(panelRounds4);
        panelRounds4.setLayout(panelRounds4Layout);
        panelRounds4Layout.setHorizontalGroup(
            panelRounds4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds4Layout.setVerticalGroup(
            panelRounds4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("185x247");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Imagem 2");

        panelRounds5.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds5.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds5.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds5.setRoundBottomLeft(5);
        panelRounds5.setRoundBottomRight(5);
        panelRounds5.setRoundTopLeft(5);
        panelRounds5.setRoundTopRight(5);
        panelRounds5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds5MouseClicked(evt);
            }
        });

        sVGImage14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage14.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage14.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage14.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds5Layout = new javax.swing.GroupLayout(panelRounds5);
        panelRounds5.setLayout(panelRounds5Layout);
        panelRounds5Layout.setHorizontalGroup(
            panelRounds5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds5Layout.setVerticalGroup(
            panelRounds5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel41.setBackground(new java.awt.Color(50, 53, 60));

        Imagem2.setBackground(new java.awt.Color(50, 53, 60));
        Imagem2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem2.setForeground(new java.awt.Color(255, 255, 255));
        Imagem2.setBorder(null);
        Imagem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("185x247");

        jPanel42.setBackground(new java.awt.Color(50, 53, 60));

        Imagem3.setBackground(new java.awt.Color(50, 53, 60));
        Imagem3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem3.setForeground(new java.awt.Color(255, 255, 255));
        Imagem3.setBorder(null);
        Imagem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem3, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("185x247");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Imagem 3");

        panelRounds6.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds6.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds6.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds6.setRoundBottomLeft(5);
        panelRounds6.setRoundBottomRight(5);
        panelRounds6.setRoundTopLeft(5);
        panelRounds6.setRoundTopRight(5);
        panelRounds6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds6MouseClicked(evt);
            }
        });

        sVGImage15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage15.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage15.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage15.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds6Layout = new javax.swing.GroupLayout(panelRounds6);
        panelRounds6.setLayout(panelRounds6Layout);
        panelRounds6Layout.setHorizontalGroup(
            panelRounds6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds6Layout.setVerticalGroup(
            panelRounds6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRounds7.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds7.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds7.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds7.setRoundBottomLeft(5);
        panelRounds7.setRoundBottomRight(5);
        panelRounds7.setRoundTopLeft(5);
        panelRounds7.setRoundTopRight(5);
        panelRounds7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds7MouseClicked(evt);
            }
        });

        sVGImage16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage16.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage16.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage16.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds7Layout = new javax.swing.GroupLayout(panelRounds7);
        panelRounds7.setLayout(panelRounds7Layout);
        panelRounds7Layout.setHorizontalGroup(
            panelRounds7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds7Layout.setVerticalGroup(
            panelRounds7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel43.setBackground(new java.awt.Color(50, 53, 60));

        Imagem4.setBackground(new java.awt.Color(50, 53, 60));
        Imagem4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem4.setForeground(new java.awt.Color(255, 255, 255));
        Imagem4.setBorder(null);
        Imagem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem4, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Imagem 4");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("185x247");

        panelRounds8.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds8.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds8.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds8.setRoundBottomLeft(5);
        panelRounds8.setRoundBottomRight(5);
        panelRounds8.setRoundTopLeft(5);
        panelRounds8.setRoundTopRight(5);
        panelRounds8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds8MouseClicked(evt);
            }
        });

        sVGImage17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage17.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage17.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage17.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds8Layout = new javax.swing.GroupLayout(panelRounds8);
        panelRounds8.setLayout(panelRounds8Layout);
        panelRounds8Layout.setHorizontalGroup(
            panelRounds8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds8Layout.setVerticalGroup(
            panelRounds8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Imagem 5");

        jPanel46.setBackground(new java.awt.Color(50, 53, 60));

        Imagem5.setBackground(new java.awt.Color(50, 53, 60));
        Imagem5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem5.setForeground(new java.awt.Color(255, 255, 255));
        Imagem5.setBorder(null);
        Imagem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem5, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("185x247");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel47))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(5, 5, 5)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42))
                .addGap(5, 5, 5)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(5, 5, 5)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addGap(5, 5, 5)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49))
                .addGap(5, 5, 5)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jLabel50.setBackground(new java.awt.Color(76, 31, 129));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Arquivo do Jogo");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });

        jPanel65.setBackground(new java.awt.Color(50, 53, 60));

        ArquivoJogo.setBackground(new java.awt.Color(50, 53, 60));
        ArquivoJogo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ArquivoJogo.setForeground(new java.awt.Color(255, 255, 255));
        ArquivoJogo.setBorder(null);
        ArquivoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArquivoJogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ArquivoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ArquivoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRounds9.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds9.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds9.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds9.setRoundBottomLeft(5);
        panelRounds9.setRoundBottomRight(5);
        panelRounds9.setRoundTopLeft(5);
        panelRounds9.setRoundTopRight(5);
        panelRounds9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds9MouseClicked(evt);
            }
        });

        sVGImage18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage18.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage18.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage18.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds9Layout = new javax.swing.GroupLayout(panelRounds9);
        panelRounds9.setLayout(panelRounds9Layout);
        panelRounds9Layout.setHorizontalGroup(
            panelRounds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds9Layout.setVerticalGroup(
            panelRounds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("185x247");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Jogo (Até 3 GB)");

        publicar.setBackground(new java.awt.Color(59, 32, 91));
        publicar.setForeground(new java.awt.Color(255, 255, 255));
        publicar.setText("Publicar");
        publicar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        publicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicarActionPerformed(evt);
            }
        });

        descartar.setBackground(new java.awt.Color(186, 33, 33));
        descartar.setForeground(new java.awt.Color(255, 255, 255));
        descartar.setText("Descartar");
        descartar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel17))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel19))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel52))
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(publicar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                            .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(panelRounds9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(descartar, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addContainerGap())))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel20)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel30)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel35)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel34)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel33)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel32)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel23)
                                .addGap(5, 5, 5)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel24)
                                .addGap(5, 5, 5)
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel25)
                                .addGap(5, 5, 5)
                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel26)
                                .addGap(5, 5, 5)
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel27))
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel31)))
                        .addGap(5, 5, 5)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descartar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(publicar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRounds9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel22);
        jPanel22.setBounds(240, 110, 830, 1940);

        jScrollPane3.setViewportView(jPanel16);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel15);

        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel23.setBackground(new java.awt.Color(18, 22, 32));
        jPanel23.setForeground(new java.awt.Color(255, 255, 255));
        jPanel23.setMaximumSize(new java.awt.Dimension(1195, 1890));
        jPanel23.setMinimumSize(new java.awt.Dimension(1195, 1890));
        jPanel23.setLayout(null);
        jPanel23.add(jSeparator2);
        jSeparator2.setBounds(270, 100, 760, 10);

        jLabel53.setBackground(new java.awt.Color(76, 31, 129));
        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Editar Jogo");
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        jPanel23.add(jLabel53);
        jLabel53.setBounds(270, 40, 190, 48);

        jPanel26.setBackground(new java.awt.Color(0, 0, 0));
        jPanel26.setOpaque(false);
        jPanel26.setLayout(null);

        jPanel86.setBackground(new java.awt.Color(50, 53, 60));

        requisitos11.setBackground(new java.awt.Color(50, 53, 60));
        requisitos11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos11.setForeground(new java.awt.Color(255, 255, 255));
        requisitos11.setBorder(null);
        requisitos11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos11, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel86Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel86);
        jPanel86.setBounds(40, 705, 323, 34);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Sistema Operacional");
        jPanel26.add(jLabel54);
        jLabel54.setBounds(40, 675, 170, 25);

        jLabel55.setBackground(new java.awt.Color(76, 31, 129));
        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Requisitos mínimos");
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel55);
        jLabel55.setBounds(40, 602, 340, 41);

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Processador");
        jPanel26.add(jLabel56);
        jLabel56.setBounds(40, 755, 170, 25);

        jPanel87.setBackground(new java.awt.Color(50, 53, 60));

        requisitos12.setBackground(new java.awt.Color(50, 53, 60));
        requisitos12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos12.setForeground(new java.awt.Color(255, 255, 255));
        requisitos12.setBorder(null);
        requisitos12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos12, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel87Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel87);
        jPanel87.setBounds(40, 785, 323, 34);

        jPanel88.setBackground(new java.awt.Color(50, 53, 60));

        requisitos13.setBackground(new java.awt.Color(50, 53, 60));
        requisitos13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos13.setForeground(new java.awt.Color(255, 255, 255));
        requisitos13.setBorder(null);
        requisitos13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos13, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel88Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel88);
        jPanel88.setBounds(40, 865, 323, 34);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Memória RAM");
        jPanel26.add(jLabel57);
        jLabel57.setBounds(40, 835, 170, 25);

        jPanel89.setBackground(new java.awt.Color(50, 53, 60));

        requisitos14.setBackground(new java.awt.Color(50, 53, 60));
        requisitos14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos14.setForeground(new java.awt.Color(255, 255, 255));
        requisitos14.setBorder(null);
        requisitos14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos14, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel89Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel89);
        jPanel89.setBounds(40, 945, 323, 34);

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Placa de vídeo");
        jPanel26.add(jLabel58);
        jLabel58.setBounds(40, 915, 120, 25);

        jPanel90.setBackground(new java.awt.Color(50, 53, 60));

        requisitos15.setBackground(new java.awt.Color(50, 53, 60));
        requisitos15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos15.setForeground(new java.awt.Color(255, 255, 255));
        requisitos15.setBorder(null);
        requisitos15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos15, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel90Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel90);
        jPanel90.setBounds(40, 1025, 323, 34);

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Armazenamento");
        jPanel26.add(jLabel59);
        jLabel59.setBounds(40, 995, 170, 25);

        jPanel32.setBackground(new java.awt.Color(50, 53, 60));

        requisitos16.setBackground(new java.awt.Color(50, 53, 60));
        requisitos16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos16.setForeground(new java.awt.Color(255, 255, 255));
        requisitos16.setBorder(null);
        requisitos16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos16, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel32);
        jPanel32.setBounds(461, 1025, 323, 34);

        jLabel60.setBackground(new java.awt.Color(76, 31, 129));
        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Requisitos Recomendados");
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel60);
        jLabel60.setBounds(455, 602, 369, 41);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Memória RAM");
        jPanel26.add(jLabel61);
        jLabel61.setBounds(461, 835, 170, 25);

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Armazenamento");
        jPanel26.add(jLabel62);
        jLabel62.setBounds(461, 995, 170, 25);

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Sistema Operacional");
        jPanel26.add(jLabel63);
        jLabel63.setBounds(461, 675, 170, 25);

        jPanel91.setBackground(new java.awt.Color(50, 53, 60));

        requisitos17.setBackground(new java.awt.Color(50, 53, 60));
        requisitos17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos17.setForeground(new java.awt.Color(255, 255, 255));
        requisitos17.setBorder(null);
        requisitos17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos17, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel91Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel91);
        jPanel91.setBounds(461, 705, 323, 34);

        jPanel92.setBackground(new java.awt.Color(50, 53, 60));

        requisitos18.setBackground(new java.awt.Color(50, 53, 60));
        requisitos18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos18.setForeground(new java.awt.Color(255, 255, 255));
        requisitos18.setBorder(null);
        requisitos18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos18, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel92Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel92);
        jPanel92.setBounds(461, 785, 323, 34);

        jPanel93.setBackground(new java.awt.Color(50, 53, 60));

        requisitos19.setBackground(new java.awt.Color(50, 53, 60));
        requisitos19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos19.setForeground(new java.awt.Color(255, 255, 255));
        requisitos19.setBorder(null);
        requisitos19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos19, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel93Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel93);
        jPanel93.setBounds(461, 865, 323, 34);

        jPanel94.setBackground(new java.awt.Color(50, 53, 60));

        requisitos20.setBackground(new java.awt.Color(50, 53, 60));
        requisitos20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        requisitos20.setForeground(new java.awt.Color(255, 255, 255));
        requisitos20.setBorder(null);
        requisitos20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisitos20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requisitos20, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel94Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requisitos20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel94);
        jPanel94.setBounds(461, 945, 323, 34);

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Placa de vídeo");
        jPanel26.add(jLabel64);
        jLabel64.setBounds(461, 915, 120, 25);

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Processador");
        jPanel26.add(jLabel65);
        jLabel65.setBounds(461, 755, 170, 25);

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Nome do Jogo");
        jPanel26.add(jLabel66);
        jLabel66.setBounds(40, 44, 120, 25);

        jPanel95.setBackground(new java.awt.Color(50, 53, 60));

        NomeJogo1.setBackground(new java.awt.Color(50, 53, 60));
        NomeJogo1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        NomeJogo1.setForeground(new java.awt.Color(255, 255, 255));
        NomeJogo1.setBorder(null);
        NomeJogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeJogo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NomeJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel95Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NomeJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel95);
        jPanel95.setBounds(40, 75, 323, 34);

        Classificacao1.setBackground(new java.awt.Color(50, 53, 60));
        Classificacao1.setBorder(null);
        Classificacao1.setEditable(false);
        Classificacao1.setForeground(new java.awt.Color(255, 255, 255));
        Classificacao1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Livre", "+10", "+12", "+14", "+16", "+18", " " }));
        Classificacao1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel26.add(Classificacao1);
        Classificacao1.setBounds(40, 169, 147, 34);

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Classificação");
        jPanel26.add(jLabel67);
        jLabel67.setBounds(40, 138, 99, 25);

        jPanel96.setBackground(new java.awt.Color(50, 53, 60));
        jPanel96.setMaximumSize(new java.awt.Dimension(147, 244));
        jPanel96.setMinimumSize(new java.awt.Dimension(147, 244));

        jCheckBoxCustom15.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom15.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom15.setText("Ação");
        jCheckBoxCustom15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCustom15ActionPerformed(evt);
            }
        });

        jCheckBoxCustom16.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom16.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom16.setText("Aventura");

        jCheckBoxCustom17.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom17.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom17.setText("RPG");

        jCheckBoxCustom18.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom18.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom18.setText("Estratégia");

        jCheckBoxCustom19.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom19.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom19.setText("Simulação");

        jCheckBoxCustom20.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom20.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom20.setText("Esportes e Corrida");

        jCheckBoxCustom21.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom21.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom21.setText("Quebra-Cabeças");

        jCheckBoxCustom22.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom22.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom22.setText("Terror");

        jCheckBoxCustom23.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom23.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom23.setText("Casual");

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCustom15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jCheckBoxCustom15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel26.add(jPanel96);
        jPanel96.setBounds(40, 255, 147, 263);

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Preço do Jogo");
        jPanel26.add(jLabel68);
        jLabel68.setBounds(215, 138, 115, 25);

        jPanel97.setBackground(new java.awt.Color(50, 53, 60));

        preco1.setBackground(new java.awt.Color(50, 53, 60));
        preco1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        preco1.setForeground(new java.awt.Color(255, 255, 255));
        preco1.setBorder(null);
        preco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preco1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(preco1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel97Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(preco1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel97);
        jPanel97.setBounds(205, 169, 149, 34);

        jPanel98.setBackground(new java.awt.Color(50, 53, 60));
        jPanel98.setMaximumSize(new java.awt.Dimension(147, 263));
        jPanel98.setMinimumSize(new java.awt.Dimension(147, 263));
        jPanel98.setPreferredSize(new java.awt.Dimension(147, 263));

        jCheckBoxCustom24.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom24.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom24.setText("Português");
        jCheckBoxCustom24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCustom24ActionPerformed(evt);
            }
        });

        jCheckBoxCustom25.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom25.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom25.setText("Espanhol");

        jCheckBoxCustom26.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom26.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom26.setText("Inglês");

        jCheckBoxCustom27.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom27.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom27.setText("Francês");

        jCheckBoxCustom28.setBackground(new java.awt.Color(59, 32, 91));
        jCheckBoxCustom28.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxCustom28.setText("Japonês");

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCustom24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCustom28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jCheckBoxCustom24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel26.add(jPanel98);
        jPanel98.setBounds(207, 255, 147, 263);

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Categoria");
        jPanel26.add(jLabel69);
        jLabel69.setBounds(40, 224, 76, 25);

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Idioma");
        jPanel26.add(jLabel70);
        jLabel70.setBounds(215, 224, 56, 25);

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Sinopse do Jogo");
        jPanel26.add(jLabel71);
        jLabel71.setBounds(461, 44, 134, 25);

        Sinopse1.setBackground(new java.awt.Color(50, 53, 60));
        Sinopse1.setColumns(20);
        Sinopse1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Sinopse1.setForeground(new java.awt.Color(255, 255, 255));
        Sinopse1.setRows(5);
        Sinopse1.setBorder(null);
        jScrollPane7.setViewportView(Sinopse1);
        Sinopse.setLineWrap(true);  // Quebra de linha automática
        Sinopse.setWrapStyleWord(true);  // Quebra entre palavras

        jPanel26.add(jScrollPane7);
        jScrollPane7.setBounds(461, 74, 327, 206);

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Descrição do Jogo");
        jPanel26.add(jLabel72);
        jLabel72.setBounds(461, 304, 147, 25);

        Descricao1.setBackground(new java.awt.Color(50, 53, 60));
        Descricao1.setColumns(20);
        Descricao1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Descricao1.setForeground(new java.awt.Color(255, 255, 255));
        Descricao1.setRows(5);
        jScrollPane8.setViewportView(Descricao1);
        Descricao.setLineWrap(true);  // Quebra de linha automática
        Descricao.setWrapStyleWord(true);  // Quebra entre palavras

        jPanel26.add(jScrollPane8);
        jScrollPane8.setBounds(461, 334, 327, 206);

        jLabel73.setBackground(new java.awt.Color(76, 31, 129));
        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Capa e Pôster");
        jLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel73MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel73);
        jLabel73.setBounds(40, 1133, 340, 41);

        jLabel74.setBackground(new java.awt.Color(76, 31, 129));
        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Imagens do Jogo");
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel74);
        jLabel74.setBounds(462, 1133, 340, 41);

        jPanel99.setOpaque(false);

        jPanel100.setBackground(new java.awt.Color(50, 53, 60));

        PosterJogo1.setBackground(new java.awt.Color(50, 53, 60));
        PosterJogo1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PosterJogo1.setForeground(new java.awt.Color(255, 255, 255));
        PosterJogo1.setBorder(null);
        PosterJogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosterJogo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PosterJogo1))
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel100Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PosterJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Pôster do Jogo (É exibido na compra)");

        panelRounds10.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds10.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds10.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds10.setRoundBottomLeft(5);
        panelRounds10.setRoundBottomRight(5);
        panelRounds10.setRoundTopLeft(5);
        panelRounds10.setRoundTopRight(5);
        panelRounds10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds10MouseClicked(evt);
            }
        });

        sVGImage19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage19.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage19.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage19.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds10Layout = new javax.swing.GroupLayout(panelRounds10);
        panelRounds10.setLayout(panelRounds10Layout);
        panelRounds10Layout.setHorizontalGroup(
            panelRounds10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds10Layout.setVerticalGroup(
            panelRounds10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("185x247");

        panelRounds11.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds11.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds11.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds11.setRoundBottomLeft(5);
        panelRounds11.setRoundBottomRight(5);
        panelRounds11.setRoundTopLeft(5);
        panelRounds11.setRoundTopRight(5);
        panelRounds11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds11MouseClicked(evt);
            }
        });

        sVGImage20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage20.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage20.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage20.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage20MouseClicked(evt);
            }
        });
        sVGImage20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sVGImage20KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelRounds11Layout = new javax.swing.GroupLayout(panelRounds11);
        panelRounds11.setLayout(panelRounds11Layout);
        panelRounds11Layout.setHorizontalGroup(
            panelRounds11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds11Layout.setVerticalGroup(
            panelRounds11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel101.setBackground(new java.awt.Color(50, 53, 60));

        CapaJogo1.setBackground(new java.awt.Color(50, 53, 60));
        CapaJogo1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        CapaJogo1.setForeground(new java.awt.Color(255, 255, 255));
        CapaJogo1.setBorder(null);
        CapaJogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapaJogo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel101Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CapaJogo1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel101Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CapaJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Capa do Jogo (É exibido na loja)");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("185x247");

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel99Layout.createSequentialGroup()
                        .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRounds11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRounds10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel99Layout.createSequentialGroup()
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76))
                    .addGroup(jPanel99Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel78)))
                .addGap(14, 14, Short.MAX_VALUE))
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78))
                .addGap(5, 5, 5)
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRounds11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel76))
                .addGap(5, 5, 5)
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel26.add(jPanel99);
        jPanel99.setBounds(40, 1186, 347, 182);

        jPanel102.setOpaque(false);

        jPanel103.setBackground(new java.awt.Color(50, 53, 60));

        Imagem6.setBackground(new java.awt.Color(50, 53, 60));
        Imagem6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem6.setForeground(new java.awt.Color(255, 255, 255));
        Imagem6.setBorder(null);
        Imagem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem6, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel103Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Imagem 1");

        panelRounds12.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds12.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds12.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds12.setRoundBottomLeft(5);
        panelRounds12.setRoundBottomRight(5);
        panelRounds12.setRoundTopLeft(5);
        panelRounds12.setRoundTopRight(5);
        panelRounds12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds12MouseClicked(evt);
            }
        });

        sVGImage21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage21.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage21.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage21.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds12Layout = new javax.swing.GroupLayout(panelRounds12);
        panelRounds12.setLayout(panelRounds12Layout);
        panelRounds12Layout.setHorizontalGroup(
            panelRounds12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds12Layout.setVerticalGroup(
            panelRounds12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("185x247");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Imagem 2");

        panelRounds13.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds13.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds13.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds13.setRoundBottomLeft(5);
        panelRounds13.setRoundBottomRight(5);
        panelRounds13.setRoundTopLeft(5);
        panelRounds13.setRoundTopRight(5);
        panelRounds13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds13MouseClicked(evt);
            }
        });

        sVGImage22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage22.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage22.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage22.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds13Layout = new javax.swing.GroupLayout(panelRounds13);
        panelRounds13.setLayout(panelRounds13Layout);
        panelRounds13Layout.setHorizontalGroup(
            panelRounds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds13Layout.setVerticalGroup(
            panelRounds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel104.setBackground(new java.awt.Color(50, 53, 60));

        Imagem7.setBackground(new java.awt.Color(50, 53, 60));
        Imagem7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem7.setForeground(new java.awt.Color(255, 255, 255));
        Imagem7.setBorder(null);
        Imagem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem7, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel104Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("185x247");

        jPanel105.setBackground(new java.awt.Color(50, 53, 60));

        Imagem8.setBackground(new java.awt.Color(50, 53, 60));
        Imagem8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem8.setForeground(new java.awt.Color(255, 255, 255));
        Imagem8.setBorder(null);
        Imagem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem8, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel105Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("185x247");

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Imagem 3");

        panelRounds14.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds14.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds14.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds14.setRoundBottomLeft(5);
        panelRounds14.setRoundBottomRight(5);
        panelRounds14.setRoundTopLeft(5);
        panelRounds14.setRoundTopRight(5);
        panelRounds14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds14MouseClicked(evt);
            }
        });

        sVGImage23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage23.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage23.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage23.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds14Layout = new javax.swing.GroupLayout(panelRounds14);
        panelRounds14.setLayout(panelRounds14Layout);
        panelRounds14Layout.setHorizontalGroup(
            panelRounds14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds14Layout.setVerticalGroup(
            panelRounds14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRounds15.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds15.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds15.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds15.setRoundBottomLeft(5);
        panelRounds15.setRoundBottomRight(5);
        panelRounds15.setRoundTopLeft(5);
        panelRounds15.setRoundTopRight(5);
        panelRounds15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds15MouseClicked(evt);
            }
        });

        sVGImage24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage24.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage24.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage24.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds15Layout = new javax.swing.GroupLayout(panelRounds15);
        panelRounds15.setLayout(panelRounds15Layout);
        panelRounds15Layout.setHorizontalGroup(
            panelRounds15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds15Layout.setVerticalGroup(
            panelRounds15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel106.setBackground(new java.awt.Color(50, 53, 60));

        Imagem9.setBackground(new java.awt.Color(50, 53, 60));
        Imagem9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem9.setForeground(new java.awt.Color(255, 255, 255));
        Imagem9.setBorder(null);
        Imagem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem9, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel106Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Imagem 4");

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("185x247");

        panelRounds16.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds16.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds16.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds16.setRoundBottomLeft(5);
        panelRounds16.setRoundBottomRight(5);
        panelRounds16.setRoundTopLeft(5);
        panelRounds16.setRoundTopRight(5);
        panelRounds16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds16MouseClicked(evt);
            }
        });

        sVGImage25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage25.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage25.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage25.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds16Layout = new javax.swing.GroupLayout(panelRounds16);
        panelRounds16.setLayout(panelRounds16Layout);
        panelRounds16Layout.setHorizontalGroup(
            panelRounds16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds16Layout.setVerticalGroup(
            panelRounds16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage25, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Imagem 5");

        jPanel107.setBackground(new java.awt.Color(50, 53, 60));

        Imagem10.setBackground(new java.awt.Color(50, 53, 60));
        Imagem10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Imagem10.setForeground(new java.awt.Color(255, 255, 255));
        Imagem10.setBorder(null);
        Imagem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imagem10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Imagem10, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel107Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Imagem10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("185x247");

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel80))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jPanel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel82))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel83))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel86))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounds16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel88)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80))
                .addGap(5, 5, 5)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82))
                .addGap(5, 5, 5)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jLabel83))
                .addGap(5, 5, 5)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jLabel86))
                .addGap(5, 5, 5)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88))
                .addGap(5, 5, 5)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRounds16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel26.add(jPanel102);
        jPanel102.setBounds(463, 1186, 339, 460);

        jLabel89.setBackground(new java.awt.Color(76, 31, 129));
        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Arquivo do Jogo");
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel89);
        jLabel89.setBounds(40, 1386, 254, 41);

        jPanel108.setBackground(new java.awt.Color(50, 53, 60));

        ArquivoJogo1.setBackground(new java.awt.Color(50, 53, 60));
        ArquivoJogo1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ArquivoJogo1.setForeground(new java.awt.Color(255, 255, 255));
        ArquivoJogo1.setBorder(null);
        ArquivoJogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArquivoJogo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ArquivoJogo1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel108Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ArquivoJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.add(jPanel108);
        jPanel108.setBounds(48, 1475, 275, 34);

        panelRounds17.setBackground(new java.awt.Color(59, 32, 91));
        panelRounds17.setMaximumSize(new java.awt.Dimension(34, 34));
        panelRounds17.setMinimumSize(new java.awt.Dimension(34, 34));
        panelRounds17.setRoundBottomLeft(5);
        panelRounds17.setRoundBottomRight(5);
        panelRounds17.setRoundTopLeft(5);
        panelRounds17.setRoundTopRight(5);
        panelRounds17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRounds17MouseClicked(evt);
            }
        });

        sVGImage26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage26.setMaximumSize(new java.awt.Dimension(30, 30));
        sVGImage26.setMinimumSize(new java.awt.Dimension(30, 30));
        sVGImage26.setPreferredSize(new java.awt.Dimension(30, 30));
        sVGImage26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRounds17Layout = new javax.swing.GroupLayout(panelRounds17);
        panelRounds17.setLayout(panelRounds17Layout);
        panelRounds17Layout.setHorizontalGroup(
            panelRounds17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRounds17Layout.setVerticalGroup(
            panelRounds17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounds17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGImage26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel26.add(panelRounds17);
        panelRounds17.setBounds(329, 1475, 36, 34);

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("185x247");
        jPanel26.add(jLabel90);
        jLabel90.setBounds(319, 1449, 54, 20);

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Jogo (Até 3 GB)");
        jPanel26.add(jLabel91);
        jLabel91.setBounds(48, 1445, 265, 25);

        publicar1.setBackground(new java.awt.Color(59, 32, 91));
        publicar1.setForeground(new java.awt.Color(255, 255, 255));
        publicar1.setText("Salvar Alterações");
        publicar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        publicar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicar1ActionPerformed(evt);
            }
        });
        jPanel26.add(publicar1);
        publicar1.setBounds(48, 1664, 317, 34);

        descartar1.setBackground(new java.awt.Color(186, 33, 33));
        descartar1.setForeground(new java.awt.Color(255, 255, 255));
        descartar1.setText("Deletar Jogo");
        descartar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel26.add(descartar1);
        descartar1.setBounds(463, 1664, 317, 34);

        jPanel23.add(jPanel26);
        jPanel26.setBounds(240, 110, 830, 1940);

        jScrollPane6.setViewportView(jPanel23);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", jPanel18);

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

        editarPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarPerfil.setMaximumSize(new java.awt.Dimension(30, 30));
        editarPerfil.setMinimumSize(new java.awt.Dimension(30, 30));
        editarPerfil.setPreferredSize(new java.awt.Dimension(30, 30));

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
                        .addComponent(editarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(editarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(193, Short.MAX_VALUE)
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
        jTabbedPane1.setSelectedIndex(5);
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

    private void btnAvancar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvancar1MouseClicked

    private void btnVoltar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltar1MouseClicked

    private void ImgCard40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard40MouseClicked

    private void ImgCard39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard39MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard39MouseClicked

    private void ImgCard38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard38MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard38MouseClicked

    private void ImgCard37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard37MouseClicked

    private void ImgCard36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard36MouseClicked

    private void ImgCard35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard35MouseClicked

    private void ImgCard34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard34MouseClicked

    private void ImgCard33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard33MouseClicked

    private void ImgCard32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard32MouseClicked

    private void ImgCard31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard31MouseClicked

    private void ImgCard30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard30MouseClicked

    private void ImgCard29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard29MouseClicked

    private void ImgCard28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard28MouseClicked

    private void ImgCard27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard27MouseClicked

    private void ImgCard26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard26MouseClicked

    private void ImgCard25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard25MouseClicked

    private void ImgCard24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard24MouseClicked

    private void ImgCard23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard23MouseClicked

    private void ImgCard22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard22MouseClicked

    private void ImgCard21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgCard21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgCard21MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jCheckBoxCustom10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCustom10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCustom10ActionPerformed

    private void precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoActionPerformed

    private void jCheckBoxCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCustom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCustom1ActionPerformed

    private void NomeJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeJogoActionPerformed

    private void requisitos9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos9ActionPerformed

    private void requisitos8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos8ActionPerformed

    private void requisitos7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos7ActionPerformed

    private void requisitos6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos6ActionPerformed

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void requisitos10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos10ActionPerformed

    private void requisitos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos5ActionPerformed

    private void requisitos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos4ActionPerformed

    private void requisitos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos3ActionPerformed

    private void requisitos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos2ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void requisitos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos1ActionPerformed

    private void CapaJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapaJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CapaJogoActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void PosterJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosterJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PosterJogoActionPerformed

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel39MouseClicked

    private void Imagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem1ActionPerformed

    private void Imagem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem2ActionPerformed

    private void Imagem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem3ActionPerformed

    private void Imagem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem4ActionPerformed

    private void Imagem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem5ActionPerformed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseClicked

    private void ArquivoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArquivoJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArquivoJogoActionPerformed

    private void publicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicarActionPerformed
        CadastrarJogo();
    }//GEN-LAST:event_publicarActionPerformed
    //ADICIONA A CAPA DO JOGO
    private void panelRounds2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds2MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[5] = ch.getSelectedFile().toString();
            CapaJogo.setText(URLs[5]);
            System.out.println(URLs[5]);
        }
    }//GEN-LAST:event_panelRounds2MouseClicked
    //ADICIONA A CAPA DO JOGO
    private void sVGImage11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sVGImage11KeyPressed
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[5] = ch.getSelectedFile().toString();
            CapaJogo.setText(URLs[5]);
            System.out.println(URLs[5]);
        }
    }//GEN-LAST:event_sVGImage11KeyPressed

    //ADICIONA O POSTER DO JOGO
    private void panelRounds3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds3MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[6] = ch.getSelectedFile().toString();
            PosterJogo.setText(URLs[6]);
            System.out.println(URLs[6]);
        }
    }//GEN-LAST:event_panelRounds3MouseClicked
    //ADICIONA O POSTER DO JOGO
    private void sVGImage12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage12MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[6] = ch.getSelectedFile().toString();
            PosterJogo.setText(URLs[6]);
            System.out.println(URLs[6]);
        }
    }//GEN-LAST:event_sVGImage12MouseClicked
    // ADICIONA O ARQUIVO DO JOGO
    private void panelRounds9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds9MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[7] = ch.getSelectedFile().toString();
            ArquivoJogo.setText(URLs[6]);
            System.out.println(URLs[7]);
        }
    }//GEN-LAST:event_panelRounds9MouseClicked
     // ADICIONA O ARQUIVO DO JOGO
    private void sVGImage18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage18MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[7] = ch.getSelectedFile().toString();
            ArquivoJogo.setText(URLs[6]);
            System.out.println(URLs[7]);
        }
    }//GEN-LAST:event_sVGImage18MouseClicked
     // ADICIONA A IMAGEM 1
    private void panelRounds4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds4MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[0] = ch.getSelectedFile().toString();
            Imagem1.setText(URLs[0]);
            System.out.println(URLs[0]);
        }
    }//GEN-LAST:event_panelRounds4MouseClicked
    // ADICIONA A IMAGEM 1
    private void sVGImage13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage13MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[0] = ch.getSelectedFile().toString();
            Imagem1.setText(URLs[0]);
            System.out.println(URLs[0]);
        }
    }//GEN-LAST:event_sVGImage13MouseClicked
    // ADICIONA A IMAGEM 2
    private void panelRounds5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds5MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[1] = ch.getSelectedFile().toString();
            Imagem2.setText(URLs[1]);
            System.out.println(URLs[1]);
        }
    }//GEN-LAST:event_panelRounds5MouseClicked

    private void sVGImage14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage14MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[1] = ch.getSelectedFile().toString();
            Imagem2.setText(URLs[1]);
            System.out.println(URLs[1]);
        }
    }//GEN-LAST:event_sVGImage14MouseClicked
    // ADICIONA A IMAGEM 3
    private void panelRounds6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds6MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[2] = ch.getSelectedFile().toString();
            Imagem3.setText(URLs[2]);
            System.out.println(URLs[2]);
        }
    }//GEN-LAST:event_panelRounds6MouseClicked

    private void sVGImage15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage15MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[2] = ch.getSelectedFile().toString();
            Imagem3.setText(URLs[2]);
            System.out.println(URLs[2]);
        }
    }//GEN-LAST:event_sVGImage15MouseClicked
    // ADICIONA A IMAGEM 4
    private void panelRounds7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds7MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[3] = ch.getSelectedFile().toString();
            Imagem4.setText(URLs[3]);
            System.out.println(URLs[3]);
        }
    }//GEN-LAST:event_panelRounds7MouseClicked

    private void sVGImage16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage16MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[3] = ch.getSelectedFile().toString();
            Imagem4.setText(URLs[3]);
            System.out.println(URLs[3]);
        }
    }//GEN-LAST:event_sVGImage16MouseClicked
    // ADICIONA A IMAGEM 5
    private void panelRounds8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds8MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[4] = ch.getSelectedFile().toString();
            Imagem5.setText(URLs[4]);
            System.out.println(URLs[4]);
        }
    }//GEN-LAST:event_panelRounds8MouseClicked

    private void sVGImage17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage17MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[4] = ch.getSelectedFile().toString();
            Imagem5.setText(URLs[4]);
            System.out.println(URLs[4]);
        }
    }//GEN-LAST:event_sVGImage17MouseClicked

 // Adiciona a Capa do jogo 
    private void sVGImage11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage11MouseClicked
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            System.out.println(ch.getSelectedFile());
            URLs[5] = ch.getSelectedFile().toString();
            CapaJogo.setText(URLs[5]);
            System.out.println(URLs[5]);
        }
    }//GEN-LAST:event_sVGImage11MouseClicked

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel53MouseClicked

    private void requisitos11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos11ActionPerformed

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel55MouseClicked

    private void requisitos12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos12ActionPerformed

    private void requisitos13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos13ActionPerformed

    private void requisitos14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos14ActionPerformed

    private void requisitos15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos15ActionPerformed

    private void requisitos16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos16ActionPerformed

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel60MouseClicked

    private void requisitos17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos17ActionPerformed

    private void requisitos18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos18ActionPerformed

    private void requisitos19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos19ActionPerformed

    private void requisitos20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisitos20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisitos20ActionPerformed

    private void NomeJogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeJogo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeJogo1ActionPerformed

    private void jCheckBoxCustom15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCustom15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCustom15ActionPerformed

    private void preco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preco1ActionPerformed

    private void jCheckBoxCustom24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCustom24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCustom24ActionPerformed

    private void jLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel73MouseClicked

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel74MouseClicked

    private void PosterJogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosterJogo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PosterJogo1ActionPerformed

    private void sVGImage19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage19MouseClicked

    private void panelRounds10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds10MouseClicked

    private void sVGImage20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage20MouseClicked

    private void sVGImage20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sVGImage20KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage20KeyPressed

    private void panelRounds11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds11MouseClicked

    private void CapaJogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapaJogo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CapaJogo1ActionPerformed

    private void Imagem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem6ActionPerformed

    private void sVGImage21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage21MouseClicked

    private void panelRounds12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds12MouseClicked

    private void sVGImage22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage22MouseClicked

    private void panelRounds13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds13MouseClicked

    private void Imagem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem7ActionPerformed

    private void Imagem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem8ActionPerformed

    private void sVGImage23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage23MouseClicked

    private void panelRounds14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds14MouseClicked

    private void sVGImage24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage24MouseClicked

    private void panelRounds15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds15MouseClicked

    private void Imagem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem9ActionPerformed

    private void sVGImage25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage25MouseClicked

    private void panelRounds16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds16MouseClicked

    private void Imagem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imagem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Imagem10ActionPerformed

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel89MouseClicked

    private void ArquivoJogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArquivoJogo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArquivoJogo1ActionPerformed

    private void sVGImage26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sVGImage26MouseClicked

    private void panelRounds17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRounds17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRounds17MouseClicked

    private void publicar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publicar1ActionPerformed

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
    
    
    //Comentei
    
    
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
            
            String pesquisa = "SELECT jogo.ID_jogo, jogo.titulo_do_jogo, imagens_jogo.URL_imagem " +
                  "FROM jogo " +
                  "JOIN imagens_jogo ON jogo.ID_jogo = imagens_jogo.ID_jogo " +
                  "WHERE imagens_jogo.tipo_imagem = 2 " +
                  "ORDER BY jogo.ID_jogo ASC LIMIT 21 OFFSET " + offset + ";";
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
    
    public void CadastrarJogo(){
        int id_jogo = 0;
        int id_desenvolvedor = 1;
        String nome = NomeJogo.getText();
        String precoString = preco.getText();
        double precojogo = Double.parseDouble(precoString);
        String sinopse = Sinopse.getText();
        String descricao = Descricao.getText();
        String Stringclassificacao = (String) Classificacao.getSelectedItem();
        if(Stringclassificacao.equals("Livre")){
            Stringclassificacao = "10";
        }
        Stringclassificacao = Stringclassificacao.substring(1);
        int classificacao = Integer.parseInt(Stringclassificacao);
        String[] ArrayRequisistos = new String[10];
        ArrayRequisistos[0] = requisitos1.getText();
        ArrayRequisistos[1] = requisitos2.getText();
        ArrayRequisistos[2] = requisitos3.getText();
        ArrayRequisistos[3] = requisitos4.getText();
        ArrayRequisistos[4] = requisitos5.getText();
        ArrayRequisistos[5] = requisitos6.getText();
        ArrayRequisistos[6] = requisitos7.getText();
        ArrayRequisistos[7] = requisitos8.getText();
        ArrayRequisistos[8] = requisitos9.getText();
        ArrayRequisistos[9] = requisitos10.getText();
        String Requisitos = ArrayRequisistos[0] + "#" + ArrayRequisistos[1] +"#"+ ArrayRequisistos[2] +"#"+ ArrayRequisistos[3] +"#"+ ArrayRequisistos[4] +"#"+ ArrayRequisistos[5] +"#"+ ArrayRequisistos[6] +"#"+ ArrayRequisistos[7] +"#"+ ArrayRequisistos[8] +"#"+ ArrayRequisistos[9] +"";
        String CapaCaminho = CapaJogo.getText();
        String PosterCaminho = PosterJogo.getText();
        String ImagemCaminho1 = Imagem1.getText();
        String ImagemCaminho2 = Imagem2.getText();
        String ImagemCaminho3 = Imagem3.getText();
        String ImagemCaminho4 = Imagem4.getText();
        String ImagemCaminho5 = Imagem5.getText();
        LocalDateTime dataPublicacao = LocalDateTime.now();
        System.out.println(dataPublicacao);
        List<Integer> categoria = new ArrayList<>();
        List<Integer> idioma = new ArrayList<>();
        
        
        if(jCheckBoxCustom10.isSelected()){
            idioma.add(1);
        }
        if(jCheckBoxCustom11.isSelected()){
            idioma.add(2);
        }
        if(jCheckBoxCustom12.isSelected()){
            idioma.add(3);
        }
        if(jCheckBoxCustom13.isSelected()){
            idioma.add(4);
        }
        if(jCheckBoxCustom14.isSelected()){
            idioma.add(5);
        }
       
        
        if(jCheckBoxCustom1.isSelected()){
            categoria.add(1);
        }
        if(jCheckBoxCustom2.isSelected()){
            categoria.add(2);
        }
        if(jCheckBoxCustom3.isSelected()){
            categoria.add(3);
        }
        if(jCheckBoxCustom4.isSelected()){
            categoria.add(4);
        }
        if(jCheckBoxCustom5.isSelected()){
            categoria.add(5);
        }
        if(jCheckBoxCustom6.isSelected()){
            categoria.add(6);
        }
        if(jCheckBoxCustom7.isSelected()){
            categoria.add(7);
        }
        if(jCheckBoxCustom8.isSelected()){
            categoria.add(8);
        }
        if(jCheckBoxCustom9.isSelected()){
            categoria.add(9);
        }
        
            try {
                // Inserir o jogo
                String insert_sql = "INSERT INTO jogo (titulo_do_jogo, descricao_jogo, data_publicacao, ID_desenvolvedor, sinopse, classificacao_indicativa, preco, requisitos) "
                + "VALUES ('" + nome + "','" + descricao + "','" + dataPublicacao + "','" + id_desenvolvedor + "','" + sinopse + "','" + classificacao + "','" + precojogo + "','" + Requisitos + "')";
                conexao.statement.executeUpdate(insert_sql);

                JOptionPane.showMessageDialog(null, "Gravação Do Jogo Realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                //Faz a recuperação do ultimo id
                String queryUltimoID = "SELECT LAST_INSERT_ID() AS ultimo_id";
                conexao.resultset = conexao.statement.executeQuery(queryUltimoID);
                if (conexao.resultset != null && conexao.resultset.next()) {
                    id_jogo = conexao.resultset.getInt("ultimo_id");
                    System.out.println("ID do jogo inserido: " + id_jogo);
                } else {
                    System.err.println("Falha ao recuperar o último ID inserido. O ResultSet está vazio ou nulo.");
                }
                
                CadastrarCategoria(id_jogo, categoria);
                CadastrarIdiomas(id_jogo, idioma);
                CadastrarImagens(id_jogo, URLs);

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "Erro na gravação: \n" + errosql.getMessage(), "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException nullEx) {
            JOptionPane.showMessageDialog(null, "Erro: Objeto nulo encontrado. Verifique a conexão ou a consulta.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            nullEx.printStackTrace();
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
    
    public void CadastrarImagens(int ID_jogo, String[] URLs){
        int TipoImagem = 0;
               for (int i = 0; i < 5; i++) {
               TipoImagem = 1; // Imagens do jogo
               String URL_imagem = URLs[0]; 
               Upload UpImagens = new Upload("http://tentreosbrothers.shop/Vinicius/Vortex/UploadImagens.php", URLs[i]);
               String NomeImagem = "http://tentreosbrothers.shop/Vinicius/Vortex/FotosJogos/"+UpImagens.nomeFile;
               System.out.println("cassio gaymer "+NomeImagem);
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
    private javax.swing.JTextField ArquivoJogo;
    private javax.swing.JTextField ArquivoJogo1;
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
    private javax.swing.JTextField CapaJogo;
    private javax.swing.JTextField CapaJogo1;
    private com.raven.swing.combobox.ComboBoxSuggestion Classificacao;
    private com.raven.swing.combobox.ComboBoxSuggestion Classificacao1;
    private javax.swing.JTextArea Descricao;
    private javax.swing.JTextArea Descricao1;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel EmailPuxado;
    private imagens.SVGImage Flag;
    private javax.swing.JTextField Imagem1;
    private javax.swing.JTextField Imagem10;
    private javax.swing.JTextField Imagem2;
    private javax.swing.JTextField Imagem3;
    private javax.swing.JTextField Imagem4;
    private javax.swing.JTextField Imagem5;
    private javax.swing.JTextField Imagem6;
    private javax.swing.JTextField Imagem7;
    private javax.swing.JTextField Imagem8;
    private javax.swing.JTextField Imagem9;
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
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField Nome2;
    private javax.swing.JTextField NomeJogo;
    private javax.swing.JTextField NomeJogo1;
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
    private javax.swing.JTextField PosterJogo;
    private javax.swing.JTextField PosterJogo1;
    private com.raven.swing.Button Salvar;
    private com.raven.swing.Button Senha;
    private javax.swing.JTextArea Sinopse;
    private javax.swing.JTextArea Sinopse1;
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
    private javax.swing.JPanel btnAvancar;
    private javax.swing.JPanel btnAvancar1;
    private javax.swing.JPanel btnVoltar;
    private javax.swing.JPanel btnVoltar1;
    private com.raven.swing.Button button1;
    private com.raven.swing.Button descartar;
    private com.raven.swing.Button descartar1;
    private imagens.SVGImage editarEmail;
    private imagens.SVGImage editarNome;
    private imagens.SVGImage editarPerfil;
    private com.raven.swing.Button excluir;
    private com.raven.Perfil.ImageAvatar imageAvatar1;
    private checkbox.JCheckBoxCustom jCheckBoxCustom1;
    private checkbox.JCheckBoxCustom jCheckBoxCustom10;
    private checkbox.JCheckBoxCustom jCheckBoxCustom11;
    private checkbox.JCheckBoxCustom jCheckBoxCustom12;
    private checkbox.JCheckBoxCustom jCheckBoxCustom13;
    private checkbox.JCheckBoxCustom jCheckBoxCustom14;
    private checkbox.JCheckBoxCustom jCheckBoxCustom15;
    private checkbox.JCheckBoxCustom jCheckBoxCustom16;
    private checkbox.JCheckBoxCustom jCheckBoxCustom17;
    private checkbox.JCheckBoxCustom jCheckBoxCustom18;
    private checkbox.JCheckBoxCustom jCheckBoxCustom19;
    private checkbox.JCheckBoxCustom jCheckBoxCustom2;
    private checkbox.JCheckBoxCustom jCheckBoxCustom20;
    private checkbox.JCheckBoxCustom jCheckBoxCustom21;
    private checkbox.JCheckBoxCustom jCheckBoxCustom22;
    private checkbox.JCheckBoxCustom jCheckBoxCustom23;
    private checkbox.JCheckBoxCustom jCheckBoxCustom24;
    private checkbox.JCheckBoxCustom jCheckBoxCustom25;
    private checkbox.JCheckBoxCustom jCheckBoxCustom26;
    private checkbox.JCheckBoxCustom jCheckBoxCustom27;
    private checkbox.JCheckBoxCustom jCheckBoxCustom28;
    private checkbox.JCheckBoxCustom jCheckBoxCustom3;
    private checkbox.JCheckBoxCustom jCheckBoxCustom4;
    private checkbox.JCheckBoxCustom jCheckBoxCustom5;
    private checkbox.JCheckBoxCustom jCheckBoxCustom6;
    private checkbox.JCheckBoxCustom jCheckBoxCustom7;
    private checkbox.JCheckBoxCustom jCheckBoxCustom8;
    private checkbox.JCheckBoxCustom jCheckBoxCustom9;
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
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
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
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
    private javax.swing.JPanel jPanel65;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField jTextField1;
    private javax.swing.JPasswordField jTextField2;
    private javax.swing.JPasswordField jTextField3;
    private javax.swing.JPasswordField jTextField5;
    private javax.swing.JPasswordField jTextField6;
    private javax.swing.JPanel ocultoPanel;
    private javax.swing.JLabel paisLabel;
    private com.raven.swing.combobox.PanelRounds panelRounds10;
    private com.raven.swing.combobox.PanelRounds panelRounds11;
    private com.raven.swing.combobox.PanelRounds panelRounds12;
    private com.raven.swing.combobox.PanelRounds panelRounds13;
    private com.raven.swing.combobox.PanelRounds panelRounds14;
    private com.raven.swing.combobox.PanelRounds panelRounds15;
    private com.raven.swing.combobox.PanelRounds panelRounds16;
    private com.raven.swing.combobox.PanelRounds panelRounds17;
    private com.raven.swing.combobox.PanelRounds panelRounds18;
    private com.raven.swing.combobox.PanelRounds panelRounds19;
    private com.raven.swing.combobox.PanelRounds panelRounds2;
    private com.raven.swing.combobox.PanelRounds panelRounds3;
    private com.raven.swing.combobox.PanelRounds panelRounds4;
    private com.raven.swing.combobox.PanelRounds panelRounds5;
    private com.raven.swing.combobox.PanelRounds panelRounds6;
    private com.raven.swing.combobox.PanelRounds panelRounds7;
    private com.raven.swing.combobox.PanelRounds panelRounds8;
    private com.raven.swing.combobox.PanelRounds panelRounds9;
    private javax.swing.JTextField preco;
    private javax.swing.JTextField preco1;
    private com.raven.swing.Button publicar;
    private com.raven.swing.Button publicar1;
    private javax.swing.JTextField requisitos1;
    private javax.swing.JTextField requisitos10;
    private javax.swing.JTextField requisitos11;
    private javax.swing.JTextField requisitos12;
    private javax.swing.JTextField requisitos13;
    private javax.swing.JTextField requisitos14;
    private javax.swing.JTextField requisitos15;
    private javax.swing.JTextField requisitos16;
    private javax.swing.JTextField requisitos17;
    private javax.swing.JTextField requisitos18;
    private javax.swing.JTextField requisitos19;
    private javax.swing.JTextField requisitos2;
    private javax.swing.JTextField requisitos20;
    private javax.swing.JTextField requisitos3;
    private javax.swing.JTextField requisitos4;
    private javax.swing.JTextField requisitos5;
    private javax.swing.JTextField requisitos6;
    private javax.swing.JTextField requisitos7;
    private javax.swing.JTextField requisitos8;
    private javax.swing.JTextField requisitos9;
    private imagens.SVGImage sVGImage1;
    private imagens.SVGImage sVGImage10;
    private imagens.SVGImage sVGImage11;
    private imagens.SVGImage sVGImage12;
    private imagens.SVGImage sVGImage13;
    private imagens.SVGImage sVGImage14;
    private imagens.SVGImage sVGImage15;
    private imagens.SVGImage sVGImage16;
    private imagens.SVGImage sVGImage17;
    private imagens.SVGImage sVGImage18;
    private imagens.SVGImage sVGImage19;
    private imagens.SVGImage sVGImage2;
    private imagens.SVGImage sVGImage20;
    private imagens.SVGImage sVGImage21;
    private imagens.SVGImage sVGImage22;
    private imagens.SVGImage sVGImage23;
    private imagens.SVGImage sVGImage24;
    private imagens.SVGImage sVGImage25;
    private imagens.SVGImage sVGImage26;
    private imagens.SVGImage sVGImage27;
    private imagens.SVGImage sVGImage28;
    private imagens.SVGImage sVGImage29;
    private imagens.SVGImage sVGImage3;
    private imagens.SVGImage sVGImage4;
    private imagens.SVGImage sVGImage5;
    private imagens.SVGImage sVGImage6;
    private imagens.SVGImage sVGImage7;
    private imagens.SVGImage sVGImage8;
    private imagens.SVGImage sVGImage9;
    private javaswingdev.SimpleTitleBar simpleTitleBar1;
    // End of variables declaration//GEN-END:variables
}
