// 
// Decompiled by Procyon v0.5.36
// 

package aula8_3QQSM;

import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.image.BufferedImage;
import java.awt.Image;

public class ImageUtil
{
    private static BufferedImage createResizedCopy(final Image originalImage, final int scaledWidth, final int scaledHeight, final boolean preserveAlpha) {
        final int imageType = preserveAlpha ? 1 : 2;
        final BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        final Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }
    
    public static ImageIcon resize(final ImageIcon original, final int height, final int width) {
        return new ImageIcon(createResizedCopy(original.getImage(), width, height, true));
    }
}
