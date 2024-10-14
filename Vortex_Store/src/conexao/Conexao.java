package conexao;

import vortex_store.Error;
import javax.swing.JOptionPane;
import java.sql.*;

public class Conexao {
    // Informações do banco de dados
    final private String driver = "com.mysql.cj.jdbc.Driver";
    final private String url = "jdbc:mysql://tentreosbrothers.shop/vortex_store";
    final private String usuario = "root";
    final private String senha = "df533a9d-4426-4417-a91e-fcc55df8159f";

    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;
    
  

    // Método para conectar ao banco de dados
    //metodo mensagem, se for true exibe a mensagem de conexao estabelecida se for false não exibe nada
    public boolean conecta(boolean mensagem) {
        boolean result = true;
        try {
            // Carrega o driver JDBC e estabelece a conexão
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // Cria o statement após estabelecer a conexão
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if(mensagem == true){
                JOptionPane.showMessageDialog(null, "Conexão estabelecida", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException Driver) {
             if(mensagem == true){
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + Driver, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
             }
            result = false;
             
        } catch (SQLException Fonte) {
            //JOptionPane.showMessageDialog(null, "Fonte de dados não localizada: " + Fonte, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);      
            result = false;
            /*Error errotela = new Error();
            errotela.setVisible(true);*/
        }
        return result;
    }

    // Método para desconectar do banco de dados
    public void desconecta(boolean mensagem) {
        try {
            if (conexao != null) {
                conexao.close();
                 if(mensagem == true){
                JOptionPane.showMessageDialog(null, "Conexão com o banco fechada", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                 }
                }
        } catch (SQLException fecha) {
             if(mensagem == true){
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + fecha, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
             }
             }
    }
 
    // Método para executar uma consulta SQL
    public void executaSQL(String sql, boolean mensagem) {
        try {
            if (statement == null) {
                // Cria o statement se ele não existir
                statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            }
            resultset = statement.executeQuery(sql);
        } catch (SQLException execao) {
             if(mensagem == true){
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \nErro: " + execao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
             }
        }
    }
}
