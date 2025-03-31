package aff;
import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import zoo.Zoo;
import data.*;
public class Dessin extends JPanel
{
	int x=100;
	int y=40;
    Data my_data;
	//impl --->#[get_field]{
		public Data get_data(){
			return this.my_data;
		}
	//}

	//impl --->#[set_field]{
		public void set_data(Data my_data){
			this.my_data=my_data;
		}
	//}
	public void paint(Graphics gP)
	{
		
		Graphics2D g = (Graphics2D) gP;
		super.paint(g);
	
     g.drawString("Carinivore :nom", x-1, y-1);
     g.setColor(new Color(21,32, 123, 130));
     g.setColor(new Color(221,122, 123, 100));
    g.fillOval(x, y, 100, 100);
    
		int i=1;
		repaint();

		try{
			Thread.sleep(20);
		}
		catch(Exception e)
		{
			
		}
		System.out.println("bonjou");
		x++;
		y++;
		
		
	}
    
}