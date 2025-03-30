package aff;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.*;
public class Ecoute implements MouseMotionListener,MouseListener
{
	MaFenetre f;
	
	public Ecoute(MaFenetre j)
	{
		f=j;
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}
	 
	 public void mouseExited(MouseEvent e) {
		System.out.println("mouseExcited");
	 }
	 
	 public void mousePressed(MouseEvent e) 
	 {
		System.out.println("mousePressed "+e.getX() +" y = "+e.getY()+ "dragged = "+e.MOUSE_DRAGGED);
	 }
	 
	 public void mouseReleased(MouseEvent e) 
	 {
		System.out.println("mouseRelassed");
	 }
	 
	 public void mouseClicked(MouseEvent e) 
	 {
	 	f.valiny.setText(f.isa1.getText()+f.isa2.getText());
		System.out.println("mouseClicked dhiuzahduiazhiduh");
	 }
	 public void mouseMoved(MouseEvent e) 
	 {
		System.out.println("MouseMoved");
	 }
	 public void mouseDragged(MouseEvent e) {
        System.out.println("Draggg "+e.getX()+" et "+e.getY());  
	}
}
