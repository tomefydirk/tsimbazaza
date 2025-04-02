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
	int echelle;
	Zoo zoo;
	
	//impl --->#[constructor]{
	public Dessin(Zoo zoo,int marg_x,int marg_y,int echelle){
		super();
		this.zoo=zoo;
		this.marg_x=marg_x;
		this.marg_y=marg_y;
		this.echelle=echelle;
		zoo.set_echelle(echelle);
	}
	//}

	public void afficher_sec(Graphics g){
		for(int i=0;zoo.get_ls()[i]!=null;i++){
			Secteur a=zoo.get_ls()[i];
			  double vertete_sec = ((SecteurPark)a).get_vertete();
			  double vertete_color=(  vertete_sec * (255) ) /100;
			  if(vertete_color<10 && vertete_sec>0.001){
				vertete_color=25;
			  }
			  if((int)vertete_sec!=0){
				g.setColor(new Color(0 , 255 ,0,(int) vertete_color ));

			  }else{
				g.setColor(new Color(255 , 255 ,0,(int) vertete_color +30));

			  }
			  			  g.fillRect(this.marg_x+ (int)(a.x * echelle), this.marg_y+(int) (a.y *echelle),(int)(a.width *echelle), (int)(a.height *echelle));
			  
			   
			
			g.setColor(Color.black);
			g.drawString(a.get_nom(),this.marg_x + (int)(a.x * echelle) + (int)a.width * (echelle)/2,this.marg_y+ (int)(a.y * echelle) + (int)a.height *(echelle)/2);
		}
	}
	public static void set_intensite_anim(Anim a,int gr){
		a.set_intensite(gr);
	}
	public void afficher_anim(Graphics g){
		g.setColor(new Color(255, 215, 215,200));
		g.setColor(Color.black);
		g.drawRect(zoo.x * echelle + this.marg_x, zoo.y * echelle + this.marg_y, zoo.width * echelle, zoo.height * echelle);
	
		afficher_sec(g);
		for(Anim a : zoo.get_la()){
				if(a!=null && a.get_poid()>0){
					if(a instanceof Carni){
						g.setColor(Color.RED);
					}else if(a instanceof Herbi){
						g.setColor(Color.GREEN);
					}
				}
				int x=(int) a.get_position().getX() * echelle;
				int y=(int) a.get_position().getY() * echelle;

				int gr=(int) ((a.get_poid())/10 ) + 30;
				Dessin.set_intensite_anim(a, gr);
				System.out.println(a.get_intensite());
				g.fillOval(x  + this.marg_x  , y + this.marg_y  , a.get_intensite() ,a.get_intensite());
				g.setColor(new Color(0,0,0));
				g.drawString(a.get_nom(), x  + this.marg_x,  y  + this.marg_y);
		}
	}
	public void paint(Graphics gP)
	{
		
		Graphics2D g = (Graphics2D) gP;
		super.paint(g);
		
		afficher_anim(g);
	}
    
}
