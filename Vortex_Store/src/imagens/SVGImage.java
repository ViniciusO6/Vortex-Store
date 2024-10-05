package imagens;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class SVGImage extends JLabel {
    private FlatSVGIcon svgIcon;
            
    public void setSvgImage(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }

    void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}