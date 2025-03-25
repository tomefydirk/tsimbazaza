package zoo;

import geo.*;
import vivant.*;
public class Zoo {
    Secteur[] ls;
    Anim[] la;
    public void deplacer_tous(){
      for(int i=0;la[i]!=null;i++){
            la[i].deplacer();
            la[i].mangability(this.ls,this.la);
      }
    }
    public static int find_indice_animal(Anim a,Anim[] la){
      for(int i=0;la[i]!=null;i++){
          if(a.equals_to(la[i])){
              return i;
          }
      }
      return -1;
    }
    public static void delete_animal_indice(int indice,Anim[] la){
            if(indice==-1){
              System.out.println("L'anima l'existe pas dans la liste");
              return;
            }else if(indice>=la.length){
               System.out.println("Erreur l'indice i dans delete animal dépasse la taille de la");
                return;
            }else if(la[indice]==null){
              System.out.println("Erreur l'indice i dans delete animal est null");
              return;
            }else if(la[indice+1]==null){
              la[indice]=null;
              return;
            }else{
              for(int i=indice+1;la[i]!=null;i++){
                    la[i-1]=la[i];  
              }
               return;
            }   
    
    }
    public static void delete_animal(Anim a,Anim[] la){
        int i=find_indice_animal(a,la);
        delete_animal_indice(i,la);
    }
    //impl --->#[get_field]{
      public Secteur[] get_ls(){
        return this.ls;
      }
      public Anim[] get_la(){
        return this.la;
      }
    //} 

    //impl -->#[mut_field]{
    public void set_ls(Secteur[] ls){
        this.ls=ls;
    }
    public void set_la(Anim[] la){
      this.la=la;
    }
  
    //}

  
  }