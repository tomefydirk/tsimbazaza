package vivant;

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
        if(this.poid<poid_max){
            this.poid+=(proix.poid/10);   
            if(this.poid>this.poid_max){
                this.poid=this.poid_max;
            }
         }else{
            return;
         }
        }
    
    }
    public Anim plus_mangeable(Anim[] la){
        if(la==null){
            System.out.println("vous manipulez un tableau de liste d'animal vide !!!");
            return null;
        }
        Anim min_dis=la[0];
        for(int i=0;la[i]!=null;i++){
                if(distance(this, la[i])<distance(this, min_dis)  && la[i].poid<this.poid){
                    min_dis=la[i];
                }
        }
        if(min_dis.poid<this.poid){
            return null;
        }
        return min_dis;
    }
    public void manger_plus_proche(Anim[] list_proix){
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