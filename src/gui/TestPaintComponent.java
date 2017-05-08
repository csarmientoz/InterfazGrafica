package gui;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPaintComponent extends JFrame {

    public TestPaintComponent() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        TestPaintComponent frame = new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(1000, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}

class NewPanel extends JPanel implements ActionListener, MouseListener {

    int x;
    private Timer timer;
    private int secuencia = 0;

    public NewPanel() {
        this.addMouseListener(this);
        timer = new Timer(1, this);
        timer.start();
    }

    public Rectangle getBounds() {
        return new Rectangle(x + 20, 360, 95, 70);
    }

    public void checkCollisions() {
        Rectangle tanque = this.getBounds();
        Rectangle objeto = new Rectangle(600, 380, 100, 70);
        if (tanque.intersects(objeto)) {
            timer.stop();
        }
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);

//        Image gato = loadImage("cats.gif");
//        g.drawImage(gato, x, 360, x + 142, 440, (this.secuencia * 132), 0, (this.secuencia * 132) + 132, 80, this);
        
        Image azulito = loadImage("free_radical_game_sprites.png");
        g.drawImage(azulito, x, 360, x + 32, 392, 192+(this.secuencia * 32)+32, 192, 192+(this.secuencia*32), 192+32, this);

//        g.setColor(Color.GREEN);
//        g.fillRect(x + 100, 390, 200, 100);
//        g.setColor(Color.GRAY);
//        g.fillOval(x + 120, 490, 40, 40);
//        g.fillOval(x + 220, 490, 40, 40);
//        g.setColor(Color.lightGray);
//        g.fillRect(x + 280, 410, 140, 25);
//        g.setColor(Color.black);
//        g.drawString("01", x + 110, 405);
//        g.setColor(Color.GREEN);
//        g.fillRect(x + 600, 500, 200, 100);
//        g.setColor(Color.GRAY);
//        g.fillOval(x + 620, 600, 40, 40);
//        g.fillOval(x + 720, 600, 40, 40);
//        g.setColor(Color.lightGray);
//        g.fillRect(x + 780, 520, 140, 25);
//        g.setColor(Color.black);
//        g.drawString("02", x + 610, 515);
        g.setColor(Color.yellow);
        g.fillRect(600, 380, 100, 70);
        g.setColor(Color.BLACK);
//        g.drawString("OB 3", 815, 430);
        g.drawRect(x + 20, 360, 95, 70);

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
        System.out.println("Acaba de dar un click");
        Point mp = e.getPoint();
        if (getBounds().contains(mp)) {
            this.timer.stop();
        }
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
