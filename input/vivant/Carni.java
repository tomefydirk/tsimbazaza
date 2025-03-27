package vivant;

import java.util.Vector;

import geo.Point;

public class Carni extends Anim{
    double dist_fatal;

    //impl --->#[constructor]{
        public Carni(String nom,double poid,double poid_max,Point position,double dist_fatal){
            super(nom, poid, poid_max, position);
            this.dist_fatal=dist_fatal;
        }
    //}
    public void manger(Anim proix){   
        if(Anim.distance(proix , this)<=dist_fatal){
        if(this.poid < poid_max){
            this.poid += proix.poid/10.0;   
            if(this.poid>this.poid_max){
                this.poid=this.poid_max;
            }
         }else{
            return;
         }
        }
    
    }
    public boolean mangeable(Anim la){
        if(distance(this, la)<=this.dist_fatal && la.poid<this.poid){
            return true;
        }else{
            return false;
        }
    }
    public Anim premier_mangeable(Vector<Anim> la){
        for(int i=0;i<la.size();i++){
            if(this.mangeable((Anim)la.elementAt(i)) && !this.equals_to((Anim)la.elementAt(i))){
                    return (Anim)la.elementAt(i);
            }
        }
        return null;
    }
    public Anim plus_mangeable(Vector<Anim> la){
        if(la==null){
            System.out.println("vous manipulez un tableau de liste d'animal vide !!!");
            return null;
        }
        Anim min_dis=premier_mangeable(la);
        if(min_dis==null){
            return null;
        }else{
            for(int i=0;i<la.size();i++){
                  double a=distance(this ,(Anim) la.elementAt(i));
                 
                  double b=distance(this, min_dis);
                  
                      if(a<b  && ((Anim)la.elementAt(i)).poid<this.poid && !this.equals_to((Anim)la.elementAt(i)) && !((Anim)la.elementAt(i)).est_mort){
                          min_dis=(Anim)la.elementAt(i);
                      }else{
                          continue;
                      }
              }
        }
       
        return min_dis;
    }
    public void manger_plus_proche(Vector<Anim> list_proix){
        Anim a=this.plus_mangeable(list_proix);
        this.manger(a);
    }
    //impl --->#[get_field]{
    public double get_dist_fatal(){
        return this.dist_fatal;
    }
    //}

    //impl -->#[mut_field]{
    public void set_dist_fatal(double dist_fatal){
        this.dist_fatal=dist_fatal;
    }
    //}

    //impl --->#[inserable]{
        public void insert_into(Carni[] lc){
            int i=0;
            while (true) {
                    if(lc[i]==null){
                        break;
                    }
                    i+=1;
            }
            lc[i]=this;
        }
        
        // }
}