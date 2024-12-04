package javaswingdev;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImageReajust extends JComponent {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    private Icon icon;
    private int borderSize;

    @Override
        protected void paintComponent(Graphics grphcs) {
            if (icon != null) {
                int width = getWidth();
                int height = getHeight();
                int squareSize = Math.min(width, height);
                int x = (width - squareSize) / 2;
                int y = (height - squareSize) / 2;
                int border = borderSize * 2;
                squareSize -= border;

                // Obter o tamanho da imagem
                BufferedImage img = new BufferedImage(squareSize, squareSize, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2_img = img.createGraphics();
                g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Obter a imagem original
                Image originalImage = toImage(icon);
                int iw = originalImage.getWidth(null);
                int ih = originalImage.getHeight(null);

                // Calcular a escala para manter a proporção
                double xScale = (double) squareSize / iw;
                double yScale = (double) squareSize / ih;
                double scale = Math.min(xScale, yScale);

                int scaledWidth = (int) (scale * iw);
                int scaledHeight = (int) (scale * ih);
                int xOffset = (squareSize - scaledWidth) / 2;
                int yOffset = (squareSize - scaledHeight) / 2;

                // Desenhar a imagem ajustada
                g2_img.drawImage(originalImage, xOffset, yOffset, scaledWidth, scaledHeight, null);
                g2_img.dispose();

                Graphics2D g2 = (Graphics2D) grphcs;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (borderSize > 0) {
                    g2.setColor(getForeground());
                    g2.fillRect(x, y, squareSize + border, squareSize + border); // Desenhar o quadrado da borda
                }
                if (isOpaque()) {
                    g2.setColor(getBackground());
                    g2.fillRect(x + borderSize, y + borderSize, squareSize, squareSize); // Preencher o fundo do quadrado
                }
                g2.drawImage(img, x + borderSize, y + borderSize, null); // Desenhar a imagem ajustada
            }
            super.paintComponent(grphcs);
        }

    private Rectangle getAutoSize(Icon image, int size) {
        int w = size;
        int h = size;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int cw = size;
        int ch =size;
        int x = (cw - width) / 2;
        int y = (ch - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}
