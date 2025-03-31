package aff;
import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import zoo.Zoo;
import data.*;
import geo.*;
import vivant.*;
public class Dessin extends JPanel
{
	int x=100;
	int y=40;
    Data my_data;
	//impl --->#[constructor]{
	public Dessin(Data my_data){
		super();
		this.my_data=my_data;
	}
	//}

	//impl--->#[fonction utilitaire]{
	public Anim get_anim_zoo(int index){
			return this.my_data.get_zoo().get_la().elementAt(index);
	}
	public  void afficher_anim(Graphics2D g,Anim a){
			
		int my_x = (int)(a.get_position().getX() );
		int my_y = (int)(a.get_position().getY() );
		g.drawString(a.get_nom(), my_x, my_y);
		g.setColor(new Color(0,0,0));
			if(a instanceof Carni){
				Carni c=(Carni)a;
				int dst=(int)c.get_dist_fatal();
				my_x=my_x-dst/2;
				my_y=my_y-dst/2;
				g.setColor(new Color(223, 33, 65,180));
				g.fillOval(my_x, my_y,(int) dst,(int) dst);
		

			}else if(a instanceof Herbi){
				g.setColor(new Color(150, 240, 110,89));
				g.fillRect(my_x-2, my_y-2, 4, 4);
			

			}
			
			
			
			
			
			
			
		
			try{
				Thread.sleep(1);
			}
			catch(Exception e)
			{
				
			}
			System.out.println("a");
			repaint();
			//get_anim_zoo(i).get_position().set_x(get_anim_zoo(i).get_position().getX()+1);
			//get_anim_zoo(i).get_position().set_y(get_anim_zoo(i).get_position().getY()+1);
		}
	
	
	//}
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
		my_data.get_zoo().deplacer_tous(this, g);
   //  g.drawString("Carinivore :nom", x-1, y-1);
		
	}
    
}