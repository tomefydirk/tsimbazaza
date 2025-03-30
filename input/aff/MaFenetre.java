package aff;
import javax.swing.*;
import java.awt.*;
public class MaFenetre extends JFrame
{
	JTextField isa1=new JTextField(10);
	JButton bt=new JButton();
	JTextField isa2=new JTextField(10);
	JTextField valiny=new JTextField(10);
	
	
	public MaFenetre() throws Exception
	{
		setTitle("piment cafe");
		setSize(700,700);
		//bt.setText("ajouter");
		add(isa1);
		add(isa2);
		add(valiny);
		Dessin d=new Dessin();
		d.setLayout(new FlowLayout());
		add(d);
		
		//add(bt);
	//	bt.addMouseListener(new Ecoute(this));
		setVisible(true);

	}
	
      
}