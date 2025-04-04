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
	//impl --->[reajust]{
		public void drawRect_ajst(Graphics g,int x, int y,int width ,int height){
			g.drawRect(x*this.echelle+this.marg_x, y*this.echelle+this.marg_y, width*this.echelle, height*this.echelle);
		}
		public void fillRect_ajst(Graphics g,int x, int y,int width ,int height){
			g.fillRect(x*this.echelle+this.marg_x, y*this.echelle+this.marg_y, width*this.echelle, height*this.echelle);
		}
		public void fillOval_ajst(Graphics g,int x, int y,int width ,int height){
			g.fillOval(x*this.echelle+this.marg_x, y*this.echelle+this.marg_y, width*this.echelle, height*this.echelle);
		}
		public void drawString_ajst(Graphics g,String nom,int x ,int y){
			g.drawString(nom,x*this.echelle+this.marg_x,y*this.echelle+this.marg_y);
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
			  			  fillRect_ajst(g,(int) a.x, (int) a.y,(int) a.width,(int) a.height)	;		  
			   
			
			g.setColor(Color.black);
			g.drawString(a.get_nom(),this.marg_x + (int)(a.x * echelle) + (int)a.width * (echelle)/2,this.marg_y+ (int)(a.y * echelle) + (int)a.height *(echelle)/2);
		}
	}
	public void afficher_Isolement(Graphics g){
		g.setColor(new Color(255,0,0,90));
		fillRect_ajst(g,(int)this.zoo.get_SI().getX(),(int) this.zoo.get_SI().getY(),(int) this.zoo.get_SI().getWidth(),(int) this.zoo.get_SI().getHeight());
	}
	public static void set_intensite_anim(Anim a,int gr){
		a.set_intensite(gr);
	}
	public void afficher_anim(Graphics g){
		g.setColor(new Color(255, 215, 215,200));
		g.setColor(Color.black);
		
		drawRect_ajst(g, zoo.x, zoo.y,zoo.width ,zoo.height);
		afficher_Isolement(g);
		afficher_sec(g);
		for(Anim a : zoo.get_la()){
				if(a!=null && a.get_poid()>0){
					if(a instanceof Carni){
						g.setColor(Color.RED);
					}else if(a instanceof Herbi){
						g.setColor(Color.GREEN);
					}
				}
				
				// intensite sur l'ecran en fonction du poid {
				int gr=(int) ((a.get_poid())/10 ) + 30;
				//}

				Dessin.set_intensite_anim(a, gr);
				int x=(int) a.get_position().getX() ;
				int y=(int) a.get_position().getY() ;

				
				
				fillOval_ajst(g, x, y, a.get_intensite()/echelle, a.get_intensite()/echelle);
				g.setColor(new Color(0,0,0));
				drawString_ajst(g, a.get_nom(),x, y);
				
		}
	}
	public void paint(Graphics gP)
	{
		
		Graphics2D g = (Graphics2D) gP;
		super.paint(g);
		
		afficher_anim(g);
	}
    
}
