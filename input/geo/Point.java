package geo;
public class Point{
    private double  x;
    private double y;

    //impl ---> #[constructor] {
    public Point(double x,double y){
        this.x=x;
        this.y=y;
        
      }
    // }
    public boolean appartient_sec_part(Point born_inf,Point born_sup){
        return this.x>=born_inf.x && this.x<=born_sup.x && this.y>=born_inf.y && this.y<=born_sup.y;
        
    }
    public boolean appartient_sec(Secteur s){
        Point[] born=s.get_borne();
        return this.appartient_sec_part(born[0],born[1]);
    }
    double fabs(double nb){
        if(nb>=0){
            return nb;
        }else{
            return -nb;
        }
    }
    //impl --->#[PartialEq] {
    public boolean equal(Point autre){
       return fabs(autre.x-this.x)<0.00001 && fabs(autre.y-this.y)<0.00001;
        
    }
    // }

    // impl --->#[Debug] {
    public String into_string(){
        return "{ x: "+this.x+" ; y: "+this.y+" }";
    }
    public void afficher(){
        System.out.println(this.into_string());
    }
    // }

    //impl -->#[get_field] {
    public double get_x(){
        return this.x;
    }
    public double get_y(){
        return this.y;
    }
    // }

    //impl -->#[mut_field] {
    public void set_x(Double x){
        this.x=x;
    }
    public void set_y(Double y){
        this.y=y;
    }
    // }

    //impl --> #[inserable] {
        public void insert_into(Point[] ld){
            int i=0;
            while (true) {
                if(ld[i]==null){
                    break;
                }
                i++;
            }
            ld[i]=this;
        }
    
        public void replace_into(Point[] ld,int index){
            ld[index]=this;
        }
    // }  
} 