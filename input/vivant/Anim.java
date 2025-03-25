package vivant;
import time.*;
import zoo.Zoo;
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
    public void mangability(Secteur[] ls,Anim[] la){
        for(int i=0;ls[i]!=null;i++){
            if(this.est_dans(ls[i])){
                if(this instanceof Herbi){
                    Herbi h=(Herbi) this;
                    h.manger(); 
                }else if(this instanceof Carni){
                    Carni c=(Carni) this;
                    Anim proix=c.plus_mangeable(la);
                    c.manger(proix);
                    Zoo.delete_animal(proix, la);
                }else{
                    continue;
                }          
            }
        }
    }
    public boolean equals_to(Anim autre){
        if(autre==this){
            return true;
        }else{
            return false;
        }
    }
    public static double distance(Anim a1,Anim a2){
        return Point.distance(a1.position, a2.position);
    }
    public Anim plus_proche(Anim[] la){
        if(la==null){
            System.out.println("vous manipulez un tableau de liste d'animal vide !!!");
            return null;
        }
        Anim min_dis=la[0];
        for(int i=0;la[i]!=null;i++){
                if(distance(this, la[i])<distance(this, min_dis)){
                    min_dis=la[i];
                }
        }
        return min_dis;
    }
   
}