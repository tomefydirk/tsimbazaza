package zoo;

import geo.*;
import vivant.*;
public class Zoo {
    Secteur[] ls;
    Anim[] la;
    public void deplacer_tous(){
      for(int i=0;la[i]!=null;i++){
            la[i].mangability(this.ls);
      }
    }
}