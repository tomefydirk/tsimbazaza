package aff;

import java.awt.BorderLayout;

import javax.swing.*;

import data.Data;
import zoo.*;
public class ZooGui extends JFrame{
    Zoo zoo;
    Dessin d;
    public ZooGui(Zoo zoo) {
        this.zoo=zoo;
        setTitle("piment cafe");
		setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        d=new Dessin(Data.get_zoo());
        add(d);
        setVisible(true);
        JButton deplacerButton=new JButton("Déplacer les animaux");
       
        add(d,BorderLayout.CENTER);
        add(deplacerButton,BorderLayout.SOUTH);
    }
    
}
