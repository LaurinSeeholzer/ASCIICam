package org.example;

import com.github.sarxos.webcam.Webcam;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.AlphaComposite;
import java.awt.image.BufferedImage;

public class App {
    private static final String CHARACTERS = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";

    public static void main(String[] args) throws Exception {
        Webcam webcam = Webcam.getDefault();
        if (webcam == null) {
            System.out.println("No webcam detected!");
            return;
        }
        webcam.open();

        int width = 150;
        int height = 75;

        while (true) {
            BufferedImage frame = webcam.getImage();
            if (frame == null) continue;
            BufferedImage resized = resizeImage(frame, width, height);
            StringBuilder sb = new StringBuilder();

            for (int y = 0; y < resized.getHeight(); y++) {
                for (int x = 0; x < resized.getWidth(); x++) {
                    Color c = new Color(resized.getRGB(x, y));
                    int avg = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                    int idx = avg * (CHARACTERS.length() - 1) / 255;
                    sb.append(CHARACTERS.charAt(idx)).append(CHARACTERS.charAt(idx));
                }
                sb.append("\n");
            }

            System.out.print("\u001b[H\u001b[2J"); // clear console
            System.out.flush();
            System.out.println(sb.toString());

            Thread.sleep(100); // ~10 fps
        }
    }

    private static BufferedImage resizeImage(BufferedImage image, int width, int height) {
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resized.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(image.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        g.dispose();
        return resized;
    }
}
