/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vortex_store;

import conexao.Conexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.sql.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import vortex_store.TelaPrincipal;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import javax.swing.event.DocumentListener;
import javax.swing.*;

/**
 *
 * @author vinic
 */
public class Cadastro extends javax.swing.JFrame {
    Conexao con_cliente;
    /**
     * Creates new form Cadastro
     */
    
    /*Criando a váriavel ano formatado que guardará o dia, mes e ano do comboBox no metódo atualizarData() 
      e formatará a data para incluir na query presente no botão*/
    private String anoformatado;
    
    
    public Cadastro() {
        initComponents();
        con_cliente = new Conexao(); 
        con_cliente.conecta(false);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/logos/VortexIcon3.png"));
        setIconImage(icon.getImage());
       
        // Listener para quando o mês for alterado
        Mes.addActionListener(e -> atualizarData());

        // Listener para quando o ano for alterado
        Ano.addActionListener(e -> atualizarData());
        
        Mes.setSelectedItem("Janeiro");  // Define o mês como Janeiro
        atualizarData();  // Chama o método para preencher os dias
             
    }
    
    public void atualizarData(){
        String mes = (String) Mes.getSelectedItem();
        int ano = Integer.parseInt(Ano.getSelectedItem().toString());
        
            // Verificar se as seleções são válidas
         // Verificar se as seleções são válidas
        if (mes == null || ano <= 0) {
            return; // Se não há mês ou o ano não é válido, sai da função
        }


        int diaSelecionado = Dia.getSelectedItem() != null ? Integer.parseInt(Dia.getSelectedItem().toString()) : 1;

        Dia.removeAllItems(); // Limpa os dias antes de repopular

        int maxDias = 0; // Inicializa a variável dia
        
       // Transformando o mês em número e determinando a quantidade de dias
        switch (mes) {
            case "Janeiro":
                mes = "1";
                maxDias = 31;
                break;
            case "Fevereiro":
                mes = "2";
                // Verifica se é ano bissexto
                if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                    maxDias = 29;
                } else {
                    maxDias = 28;
                }
                break;
            case "Março":
                mes = "3";
                maxDias = 31;
                break;
            case "Abril":
                mes = "4";
                maxDias = 30;
                break;
            case "Maio":
                mes = "5";
                maxDias = 31;
                break;
            case "Junho":
                mes = "6";
                maxDias = 30;
                break;
            case "Julho":
                mes = "7";
                maxDias = 31;
                break;
            case "Agosto":
                mes = "8";
                maxDias = 31;
                break;
            case "Setembro":
                mes = "9";
                maxDias = 30;
                break;
            case "Outubro":
                mes = "10";
                maxDias = 31;
                break;
            case "Novembro":
                mes = "11";
                maxDias = 30;
                break;
            case "Dezembro":
                mes = "12";
                maxDias = 31;
                break;
            default:
                maxDias = 31; // Se mês não reconhecido, assume 31 dias (safeguard)
                break;
        }

            
            for(int i=1; i<=maxDias;i++){
            Dia.addItem(String.valueOf(i));
            }
            
                    // Verifica se o dia anteriormente selecionado ainda é válido
            if (diaSelecionado <= maxDias) {
                Dia.setSelectedItem(String.valueOf(diaSelecionado)); // Seleciona o dia anterior
            } else {
                Dia.setSelectedIndex(maxDias - 1); // Seleciona o último dia do mês, se o anterior for inválido
            }
            
             // Define o ano formatado (a data deve ser formatada corretamente)
              anoformatado = String.format("%04d-%s-%02d", ano, mes, Integer.parseInt(Dia.getSelectedItem().toString()));
    
            System.out.println("Ano Formatado: "+anoformatado);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void resetBordas(String tipo) {
    Border defaultBorder = BorderFactory.createLineBorder(Color.decode("#333333"), 1, true); // Define a borda original
    textoErro.setText(""); // Limpa a mensagem de erro, se necessário
 
    if (tipo.equals("email")){
        erroEmail.setText("");
        jPanel7.setBorder(defaultBorder);
    }
    else if(tipo.equals("senha")){
        erroSenha.setText("");
        jPanel10.setBorder(defaultBorder);
    }
    else if(tipo.equals("nome")){
        erroNome.setText("");
        jPanel8.setBorder(defaultBorder);
    }
    else{
         erroEmail.setText("");
         jPanel7.setBorder(defaultBorder);
         erroSenha.setText("");
         jPanel7.setBorder(defaultBorder);
         erroNome.setText("");
         jPanel8.setBorder(defaultBorder);
    }
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEstado2 = new com.raven.swing.combobox.ComboBoxSuggestion();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txtPais = new com.raven.swing.combobox.ComboBoxSuggestion();
        jLabel9 = new javax.swing.JLabel();
        button2 = new com.raven.swing.Button();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Dia = new com.raven.swing.combobox.ComboBoxSuggestion();
        Mes = new com.raven.swing.combobox.ComboBoxSuggestion();
        Ano = new com.raven.swing.combobox.ComboBoxSuggestion();
        textoErro = new javax.swing.JLabel();
        erroSenha = new javax.swing.JLabel();
        erroNome = new javax.swing.JLabel();
        erroEmail = new javax.swing.JLabel();

        txtEstado2.setBackground(new java.awt.Color(50, 53, 60));
        txtEstado2.setBorder(null);
        txtEstado2.setEditable(false);
        txtEstado2.setForeground(new java.awt.Color(255, 255, 255));
        txtEstado2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC  ", "AL  ", "AM  ", "AP  ", "BA  ", "CE  ", "DF  ", "ES  ", "GO  ", "MA  ", "MG  ", "MS  ", "MT  ", "PA  ", "PB  ", "PE  ", "PI  ", "PR  ", "RJ  ", "RN  ", "RO  ", "RR  ", "RS  ", "SC  ", "SE  ", "SP  ", "TO" }));
        txtEstado2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(27, 30, 43));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CADASTRE-SE");

        jPanel7.setBackground(new java.awt.Color(50, 53, 60));

        txtEmail.setBackground(new java.awt.Color(50, 53, 60));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(null);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-mail");

        jPanel8.setBackground(new java.awt.Color(50, 53, 60));

        txtNome.setBackground(new java.awt.Color(50, 53, 60));
        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setForeground(new java.awt.Color(255, 255, 255));
        txtNome.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nome de usuário");

        jPanel10.setBackground(new java.awt.Color(50, 53, 60));

        txtSenha.setBackground(new java.awt.Color(50, 53, 60));
        txtSenha.setForeground(new java.awt.Color(255, 255, 255));
        txtSenha.setBorder(null);
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSenha))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Senha");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data de nascimento");

        jPanel12.setBackground(new java.awt.Color(50, 53, 60));

        txtPais.setBackground(new java.awt.Color(50, 53, 60));
        txtPais.setBorder(null);
        txtPais.setEditable(false);
        txtPais.setForeground(new java.awt.Color(255, 255, 255));
        txtPais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brasil", "Argentina", "Paraguai", "Uruguai", "Bolivia" }));
        txtPais.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPais, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPais, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("País de residência");

        button2.setBackground(new java.awt.Color(59, 32, 91));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Cadastrar");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        button2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(143, 101, 189));
        jLabel10.setText("Já tem uma conta?");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        Dia.setBackground(new java.awt.Color(50, 53, 60));
        Dia.setBorder(null);
        Dia.setEditable(false);
        Dia.setForeground(new java.awt.Color(255, 255, 255));
        Dia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Mes.setBackground(new java.awt.Color(50, 53, 60));
        Mes.setBorder(null);
        Mes.setEditable(false);
        Mes.setForeground(new java.awt.Color(255, 255, 255));
        Mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro", " " }));
        Mes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Ano.setBackground(new java.awt.Color(50, 53, 60));
        Ano.setBorder(null);
        Ano.setEditable(false);
        Ano.setForeground(new java.awt.Color(255, 255, 255));
        Ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", " " }));
        Ano.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        textoErro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        textoErro.setForeground(new java.awt.Color(231, 53, 65));

        erroSenha.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        erroSenha.setForeground(new java.awt.Color(231, 53, 65));
        erroSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        erroNome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        erroNome.setForeground(new java.awt.Color(231, 53, 65));
        erroNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        erroEmail.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        erroEmail.setForeground(new java.awt.Color(231, 53, 65));
        erroEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textoErro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(erroNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(erroSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(109, 109, 109)
                                .addComponent(erroEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(erroEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(erroNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(erroSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dia, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(Mes, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(Ano, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(textoErro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        
        String email = txtEmail.getText();
        String nome = txtNome.getText();
        String senha= txtSenha.getText();
        String pais = (String) txtPais.getSelectedItem();
        System.out.println(senha+"");
        
        Color borderColor = Color.decode("#dc2a2a"); 

              
           // Verifica se os campos estão vazios
    if (email.trim().isEmpty() || senha.trim().isEmpty() || nome.trim().isEmpty()) {
        Border redBorder = BorderFactory.createLineBorder(borderColor, 2, true);
        if (email.trim().isEmpty()) {
            jPanel7.setBorder(redBorder); // Destaca o campo do email
            erroEmail.setText("Preencha o campo de email!");
            
            txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    String tipo="email";
                    resetBordas(tipo);
                }
            }); 
        }
        if (senha.trim().isEmpty()) {
            jPanel10.setBorder(redBorder); // Destaca o campo da senha
            erroSenha.setText("Preencha o campo de senha!");
            
            txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    String tipo="senha";
                    resetBordas(tipo);
                }
            }); 
        }
        if (nome.trim().isEmpty()) {
            jPanel8.setBorder(redBorder); // Destaca o campo da senha
            erroNome.setText("Preencha o campo de nome!");
            
            txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    String tipo="nome";
                    resetBordas(tipo);
                }
            }); 
        }
        
        
        return; // Para o processamento, não tenta fazer login
    } else{
        erroEmail.setText("");
        erroSenha.setText("");
        erroNome.setText("");
    }
      

                       
        
        try{
            String insert_sql="insert into cliente (email, nome, senha, data_nasc, pais, foto_perfil) values ('" +email+ "','" +nome+"','" +senha+ "','" +anoformatado+ "','" +pais+ "','" +null+ "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravação Realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            Cadastrado();
            con_cliente.resultset.first();
         
        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n "+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        AbrirTela();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed
    
    public void verificarDatas(){
        
        
    }
    
    
     private void abrirSuavemente() {
        new Thread(() -> {
            try {
                for (float i = 0.0f; i <= 1.0f; i += 0.05f) {
                    setOpacity(i);  // Aumenta a opacidade da janela
                    Thread.sleep(50); // Aguarda 50ms para criar o efeito de transição suave
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
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
        
        
         private void Cadastrado() {
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
            Login tela = new Login();
            tela.setVisible(true);
            setVisible(false);
        }).start();
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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.combobox.ComboBoxSuggestion Ano;
    private com.raven.swing.combobox.ComboBoxSuggestion Dia;
    private com.raven.swing.combobox.ComboBoxSuggestion Mes;
    private com.raven.swing.Button button2;
    private javax.swing.JLabel erroEmail;
    private javax.swing.JLabel erroNome;
    private javax.swing.JLabel erroSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel textoErro;
    private javax.swing.JTextField txtEmail;
    private com.raven.swing.combobox.ComboBoxSuggestion txtEstado2;
    private javax.swing.JTextField txtNome;
    private com.raven.swing.combobox.ComboBoxSuggestion txtPais;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
