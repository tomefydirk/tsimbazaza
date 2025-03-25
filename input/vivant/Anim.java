package vivant;
import time.*;
import geo.*;
public class Anim{
    String nom;
    Date  dns;
    char sex;
    Point position;
    Point dp;
    double poid;
    double poid_max;
    public void deplacer(){
        this.position=Point.add(this.position,this.dp);
    }
    public boolean est_dans(Secteur a){
        if(this.position.appartient_sec(a)){
            return true;
        }else{
            return false;
        }
    }
    public void mangability(Secteur[] ls){
        for(int i=0;ls[i]!=null;i++){
            if(this.est_dans(ls[i])){
                if(this instanceof Herbi){
                    Herbi h=(Herbi) this;
                    h.manger(); 
                }          
            }
        }
    }
   
}