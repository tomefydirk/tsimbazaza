package aff;

import java.awt.BorderLayout;

import javax.swing.*;
import zoo.*;
public class ZooGui extends JFrame{
    Zoo zoo;
    Dessin Cpanel;
    
    public ZooGui(Zoo zoo) {
        this.zoo=zoo;
        setTitle("piment cafe");
		setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Dessin d=new Dessin(zoo);
    }
    
}
