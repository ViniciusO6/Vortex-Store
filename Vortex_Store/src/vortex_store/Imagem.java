import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Imagem {
    public static void main(String[] args) {
        // Criar o JFrame
        JFrame frame = new JFrame("Atualizar JLabel com Imagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        // Criar o JLabel existente (sem imagem inicialmente)
        JLabel label = new JLabel("Imagem será carregada aqui");
        label.setHorizontalAlignment(JLabel.CENTER);
        
        // Adicionar o JLabel ao JFrame
        frame.add(label, BorderLayout.CENTER);
        
        // Tornar o JFrame visível
        frame.setVisible(true);

        try {
            // URL da imagem
            URL imageUrl = new URL("http://tentreosbrothers.shop/imagens/ETEC.png");

            // Carregar a imagem da URL
            Image image = ImageIO.read(imageUrl);

            // Atualizar o JLabel existente com a nova imagem
            label.setIcon(new ImageIcon(image));
            label.setText(""); // Remover o texto, se quiser apenas a imagem
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}