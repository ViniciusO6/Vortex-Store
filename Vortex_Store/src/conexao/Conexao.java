package conexao;

import javax.swing.JOptionPane;
import java.sql.*;

public class Conexao {

    final private String driver = "com.mysql.cj.jdbc.Driver"; // Definição do Driver
    final private String url = "jdbc:mysql://191.180.167.91:3306/vortex_store"; // Acesso ao bd "k_bom" no servidor
    final private String usuario = "root";
    final private String senha = "server323"; // Adicione sua senha se houver
    private Connection conexao;

    public boolean conecta() {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + Driver, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizada: " + Fonte, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        return result;
    }

    public void desconecta() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o banco: " + fecha, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Connection getConnection() {
        return this.conexao; // Método para retornar a conexão
}
}