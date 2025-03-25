package vivant;

public class Herbi extends Anim{
    double capacite_grossiment; 
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
}