
package FrameObj;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SimpleFrame2 {
    public static void main(String[] args){
    
    JFrame frame = new JFrame();
    Image icon= Toolkit.getDefaultToolkit().getImage("icon.gif");
    frame.setIconImage(icon);
    JPanel panel = (JPanel) frame.getContentPane();
    panel.setBackground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(300, 120));
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(dim.width/2-frame.getSize().width/2,
            dim.height/2-frame.getSize().height/2);
    frame.setTitle("A frame");
    frame.setVisible(true);
    
    JButton button1 = new JButton();
    button1.setText("I am a button.");
    button1.setBackground(Color.BLUE);
    frame.setLayout(new FlowLayout());
    frame.add(button1);
    
     JButton button2 = new JButton();
    button2.setText("Click me.");
    button2.setBackground(Color.RED);
    frame.setLayout(new FlowLayout());
    frame.add(button1);
    
    frame.setVisible(true);
    
    
    
    
    }
}
