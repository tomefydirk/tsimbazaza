package zoo;

import geo.*;
import vivant.*;
import java.util.Vector;
import aff.Dessin;
import java.awt.*;
import java.beans.AppletInitializer;
public class Zoo extends Rectangle{
    Secteur[] ls;
    Vector<Anim> la;
    //impl --->#[constructor]{
    public Zoo(Secteur[] ls,Vector<Anim> la,int x,int y,int width ,int height){
      super(x,y,width,height);
      this.ls=ls;
      this.la=la;
      
    }
    //}
    public int mandalo_bordure(Anim a){
      int m_x=(int)a.get_position().getX();
      int m_y=(int)a.get_position().getY();
      if(m_x==this.getX()){
        return 1;
      }else if(m_y==this.getY()){
        return 2;
      }else{
        return 0;
      }
      
    }
    public void deplacer_tous(){
      for(int i=0;i<la.size();i++){
            la.elementAt(i).deplacer();
          la.elementAt(i).mangability(this.ls,this.la);
          
      }
      for(int i=0;i<la.size();i++){
          if(((Anim)la.elementAt(i)).get_est_mort()){
              this.la.remove(i);
          }

      }
     
    }
    //impl --->#[get_field]{
      public Secteur[] get_ls(){
        return this.ls;
      }
      public Vector<Anim> get_la(){
        return this.la;
      }
    //} 

    //impl -->#[mut_field]{
    public void set_ls(Secteur[] ls){
        this.ls=ls;
    }
    public void set_la(Vector<Anim> la){
      this.la=la;
    }
  
    //}
    
     //impl --->#[inserable]{
      public void insert_into(Zoo[] lz){
        int i=0;
        while (true) {
                if(lz[i]==null){
                    break;
                }
                i+=1;
        }
        lz[i]=this;
    }
    
    // }
    //impl --->#[Debug]{
      public void afficher_la(){
        for(int i=0;i<this.la.size();i++){
          ((Anim)this.la.get(i)).afficher_debug();
        }
      }
      public void afficher_ls(){
        for(int i=0;this.ls[i]!=null;i++){
          if(ls[i] instanceof SecteurPark){
            SecteurPark lsp=(SecteurPark) ls[i];
            lsp.afficher_debug();
          }else{
            System.out.println(ls[i].get_nom() +" n'est pas un secteur park");
          }
        
       }
      }
    //}
  }