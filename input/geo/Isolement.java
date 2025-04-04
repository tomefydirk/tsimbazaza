package geo;

import vivant.Anim;

public class Isolement extends Secteur{
            int echelle;
      public Isolement(int x,int y,int width,int height,int echelle){
        super("Isolement", x, y, width, height);
        this.echelle=echelle;
      }
      public int mandalo_bordure(Anim a){
      int m_x=(int)a.get_position().getX();
      int m_y=(int)a.get_position().getY();
      int tavy=a.get_intensite() / this.echelle;

      if((m_x==this.getX() || m_x +tavy== this.getX() + (this.width) ) && (m_y==this.getY() || m_y +tavy==this.getY() +(this.height))){
        return 3;
       
      }else if(m_x==this.getX() || m_x  +tavy== this.getX() +(this.width)){
        return 1;

      }else if(m_y==this.getY() || m_y  +tavy==this.getY() + (this.height)){
      
        return 2;
      }else {
        return 0;
      }
      
      
    } 
    public void arranger_deplacement(Anim a){
        if(this.mandalo_bordure(a)==1){
          a.oppose_dpX();
        }
         if(this.mandalo_bordure(a)==2){
          a.oppose_dpY();
        }
  
        if(this.mandalo_bordure(a)==3){
          a.oppose_dpX();
          a.oppose_dpY();
        }
          }  
}
