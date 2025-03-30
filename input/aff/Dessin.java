package aff;
import javax.swing.*;
import java.awt.*;
public class Dessin extends JPanel
{
	int x=100;
	int y=40;
	public void paint(Graphics gP)
	{
		
		Graphics2D g = (Graphics2D) gP;
		super.paint(g);
		
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 10, 10);
	//	g.fill(new Rectangle(80, 80, 250, 250));
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