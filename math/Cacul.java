package math;

public class Cacul {
    public static double my_fabs(double nb){
        
            if(nb>=0){
                return nb;
            }else{
                return -nb;
            }
        
    }
    public static double my_sqrt(double nb){
        double xn=nb/2;
        double epsilon=0.000001;
        while (true) {
            xn=(xn+(nb/xn))/2.0;
            double c=(xn*xn)-nb;
            if(my_fabs(c)<epsilon){
                break;
            }              
        }
        return xn;
    }
}
