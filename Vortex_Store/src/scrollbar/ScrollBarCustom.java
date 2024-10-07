
package scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;


public class ScrollBarCustom extends JScrollBar{
    
    public ScrollBarCustom (){
    
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(76,31,129));
        setBackground(new Color(27,30,43));
    }
}
