package time;

public class Date {
    private int j;
    private int m;
    private int a;
    private int h;
    private int min;
    private int s;
    //impl -->#[constructor] {
    public Date(int j,int m,int a,int h,int min,int s){
        this.j=j;
        this.m=m;
        this.a=a;
        this.h=h;
        this.min=min;
        this.s=s;
    }
    // }
    public int  into_sec(){
        return this.j*86400+3600*this.h+60*this.min+this.s;
    }
    public Date from_sec(int total_sec){
       int  j = total_sec / (24 * 3600);
        total_sec %= (24 * 3600); 

       int  h = total_sec / 3600;
        total_sec %= 3600; 

      int   min = total_sec / 60;
        total_sec %= 60;

      int   s = total_sec;
      return new Date(j, 0,0, h, min, s);
    }
    public Date duree(Date limit){
        int diff=limit.into_sec()-this.into_sec();
        return from_sec(diff);
    }

    // impl --->#[Debug]{
    public String into_string(){
        return "Jour: "+this.j+" / m:"+this.m+" / a: "+this.a+"  "+" "+this.h +"h-"+this.min+"m-"+this.s+"s";
    }
    public String into_string_h_m_s(){
        return this.h +"h-"+this.min+"m-"+this.s+"s";
    }
    public void afficher(){
        System.out.println(this.into_string());
    }
    public void afficher_h_m_s(){
        System.out.println(this.into_string_h_m_s());
    }
    // }

    //impl ---> #[get_field] {
    public int get_jour(){
        return this.j;
    }
    public int get_an(){
        return this.a;
    }
    public int get_min(){
        return this.min;
    }
    public int get_month(){
        return this.m;
    }
    public int get_sec(){
        return this.s;
    }
    public int get_hour(){
        return this.h;
    }
    // }

    //impl ---> #[mut_field]{
    public void set_jour(int j){
        this.j=j;
    }
    public void  set_an(int a){
       this.a=a;
    }
    public void set_min(int min){
        this.min=min;
    }
    public void set_month(int m){
        this.m=m;   
    }
    public void set_sec(int s){
        this.s=s;
    }

    public void set_hour(int h){
      this.h=h;
    }
    // }

    //impl --> #[inserable] {
    public void insert_into(Date[] ld){
        int i=0;
        while (true) {
            if(ld[i]==null){
                break;
            }
            i++;
        }
        ld[i]=this;
    }

    public void replace_into(Date[] ld,int index){
        ld[index]=this;
    }    
}
