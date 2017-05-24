package GUIEventos;

import javax.swing.*;

public class UseOptionPanes {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog(null, "What´s your name?");

        int choice = JOptionPane.showConfirmDialog(null, "Do you like Cake " + name + "?");

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "of course! who doesn´t ?");
        } else {
            JOptionPane.showMessageDialog(null, "We'll have to agree to disagree");
        }
    }
}
