package EscenarioPractica;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Adventure extends JFrame {

    public Adventure() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        Adventure frame = new Adventure();
        frame.setTitle("Aventura");
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    class NewPanel extends JPanel implements ActionListener, MouseListener {

        int x;
        int y;
        private Timer timer;
        private int secuencia = 0;

        public NewPanel() {
            this.addMouseListener(this);
            //addKeyListener(new TAdapter());
            setFocusable(true);
            timer = new Timer(70, this);
            timer.start();

        }

        public void checkCollisions() {

        }

        public Image loadImage(String imageName) {
            ImageIcon ii = new ImageIcon(imageName);
            Image image = ii.getImage();
            return image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image fondo = loadImage("blue_background.png");
            for (int i = 0; i < 50; i++) {
                g.drawImage(fondo, i * 20, 0, null);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            x += 1;

            if (this.secuencia == 2) {
                this.secuencia = 0;
            } else {
                this.secuencia++;
            }

            repaint();

            checkCollisions();

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

}
