package gui;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
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
        frame.setSize(1300, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}

class NewPanel extends JPanel implements ActionListener, MouseListener {

    int x;
    private Timer timer;
    
   

    public NewPanel() {
        this.addMouseListener(this);
        timer = new Timer(1, this);
        timer.start();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x+100,85,100,100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(x + 100, 500, 200, 100);
        g.setColor(Color.GRAY);
        g.fillOval(x + 120, 600, 40, 40);
        g.fillOval(x + 220, 600, 40, 40);
        g.setColor(Color.lightGray);
        g.fillRect(x + 280, 520, 140, 25);
        g.setColor(Color.black);
        g.drawString("01", x + 110, 515);

        g.setColor(Color.GREEN);
        g.fillRect(x + 600, 500, 200, 100);
        g.setColor(Color.GRAY);
        g.fillOval(x + 620, 600, 40, 40);
        g.fillOval(x + 720, 600, 40, 40);
        g.setColor(Color.lightGray);
        g.fillRect(x + 780, 520, 140, 25);
        g.setColor(Color.black);
        g.drawString("02", x + 610, 515);

        g.setColor(Color.yellow);
        g.fillRect(x + 1000, 570, 100, 70);
        g.setColor(Color.BLACK);
        g.drawString("OB 3", x + 1010, 585);
        
        g.drawRect(x+100,85,100,100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Acaba de dar un click");
        Point mp = e.getPoint();
        if(getBounds().contains(mp)){
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
