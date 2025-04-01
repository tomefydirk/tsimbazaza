package aff;
import javax.swing.*;
import java.awt.*;
import zoo.Zoo;
import geo.*;
import vivant.*;
public class Dessin extends JPanel
{
	int marg_x;
	int marg_y;
	Zoo zoo;
	
	//impl --->#[constructor]{
	public Dessin(Zoo zoo,int marg_x,int marg_y){
		super();
		this.zoo=zoo;
		this.marg_x=marg_x;
		this.marg_y=marg_y;
	}
	//}

	public void afficher_sec(Graphics g){
		for(int i=0;zoo.get_ls()[i]!=null;i++){
			Secteur a=zoo.get_ls()[i];
	
			  double vertete=( ((SecteurPark)a).get_vertete() * (255) ) /100;
			  if(((SecteurPark)a).get_vertete()<10){
				vertete=25;
			  }
			  g.setColor(new Color(0 , 255 ,0,(int) vertete ));
			  g.fillRect(this.marg_x+(int)(a.x * 10), this.marg_y+(int) (a.y *10),(int)(a.width *10), (int)(a.height *10));
			  
			   
			
			g.setColor(Color.black);
			g.drawString(a.get_nom(),this.marg_x +(int)(a.x * 10) + (int)a.width *5,this.marg_y+ (int)(a.y * 10) + (int)a.height *5);
		}
	}
	public void afficher_anim(Graphics g){
		g.setColor(new Color(255, 215, 215,200));
		g.setColor(Color.black);
		g.drawRect(zoo.x * 10 +this.marg_x, zoo.y * 10 +this.marg_y, zoo.width * 10, zoo.height * 10);
	
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
				g.drawString(a.get_nom(), x+this.marg_x, y+this.marg_y);
		}
	}
	public void paint(Graphics gP)
	{
		
		Graphics2D g = (Graphics2D) gP;
		super.paint(g);
		
		afficher_anim(g);
	}
    
}
