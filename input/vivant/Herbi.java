package vivant;

import geo.Point;

public class Herbi extends Anim{
    double capacite_grossiment; 
    //impl --->#[constructor]{
        public Herbi(String nom,double poid,double poid_max,Point position,double capacite_grossiment){
            super(nom, poid, poid_max, position);
            this.capacite_grossiment=capacite_grossiment;
        }
    //}
    public void manger(){
        if(this.poid<poid_max){
            this.poid+=capacite_grossiment;   
            if(this.poid>this.poid_max){
                this.poid=this.poid_max;
            }
        }else{
            return;
        }
       
    }
    //impl --->#[get_field]{
        public double get_gr_capacity(){
            return this.capacite_grossiment;
        }
    //}

    //impl -->#[mut_field]{
        public void set_gr_capacity(double capacite_grossiment){
            this.capacite_grossiment=capacite_grossiment;
        }
    //}

    //impl --->#[inserable]{
    public void insert_into(Herbi[] lh){
        int i=0;
        while (true) {
                if(lh[i]==null){
                    break;
                }
                i+=1;
        }
        lh[i]=this;
    }
    
    // }

   
}