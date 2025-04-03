package aff;

import javax.swing.JButton;

public class BoutonDep extends JButton{
    Mafenetre f;
    BoutonDep(Mafenetre f){
        super("Déplacer");
        this.f=f;
        this.addActionListener( _->{
            f.dessiner_2();
      });
    }
}
