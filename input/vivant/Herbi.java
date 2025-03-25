package vivant;

public class Herbi extends Anim{
    int capacite_grossiment; 
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
}