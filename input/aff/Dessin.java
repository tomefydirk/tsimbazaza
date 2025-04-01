package aff;
import javax.swing.*;
import java.awt.*;
import zoo.Zoo;
import geo.*;
import vivant.*;
public class Dessin extends JPanel
{
	Zoo zoo;
	
	//impl --->#[constructor]{
	public Dessin(Zoo zoo){
		super();
		this.zoo=zoo;
	}
	//}

	public void afficher_sec(Graphics g){
		for(int i=0;zoo.get_ls()[i]!=null;i++){
			Secteur a=zoo.get_ls()[i];
			g.setColor(Color.pink);
			g.drawRect((int)(a.x * 10) ,(int) (a.y *10),(int)(a.width *10), (int)(a.height *10));
			g.setColor(Color.black);
			g.drawString(a.get_nom(), (int)(a.x * 10) + (int)a.width *5, (int)(a.y * 10) + (int)a.height *5);
		}
	}
	public void afficher_anim(Graphics g){
		g.setColor(new Color(255, 215, 215,200));
		g.setColor(Color.black);
		g.drawRect(zoo.x * 10, zoo.y * 10, zoo.width * 10, zoo.height * 10);
	
		afficher_sec(g);
		for(Anim a : zoo.get_la()){
				if(a!=null && a.get_poid()>0){
					if(a instanceof Carni){
						g.setColor(Color.RED);
					}else if(a instanceof Herbi){
						g.setColor(Color.GREEN);
					}
				}
				int x=(int) a.get_position().getX() *10;
				int y=(int) a.get_position().getY() *10;

				g.fillOval(x, y, 10, 10);
				g.setColor(new Color(0,0,0));
				g.drawString(a.get_nom(), x, y);
		}
	}
	public void paint(Graphics gP)
	{
		
		Graphics2D g = (Graphics2D) gP;
		super.paint(g);
		
		afficher_anim(g);
	}
    
}
