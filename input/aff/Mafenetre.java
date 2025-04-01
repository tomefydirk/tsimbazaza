package aff;

import java.awt.BorderLayout;

import javax.swing.*;

import zoo.*;
public class Mafenetre extends JFrame{
    Zoo zoo;
    Dessin d;
    boolean en_mouvement;
    public Mafenetre(Zoo zoo) {
        this.zoo=zoo;
        this.en_mouvement=false;
        setTitle("Zoo simulation");
		setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        d=new Dessin(zoo);
        add(d);
        setVisible(true);
        JButton deplacerButton=new JButton("Déplacer / Arréter");
        
            deplacerButton.addActionListener( _-> {
                dessiner_boucle();
      });
   
        add(d,BorderLayout.CENTER);
        add(deplacerButton,BorderLayout.SOUTH);
    }
    public void dessiner_boucle(){
        if(en_mouvement){
            this.en_mouvement=false;
            return;
        }else{
            en_mouvement=true;
            new Thread(()->{
                while(this.en_mouvement){
                dessiner();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
        
                } 
            }}).start();
        }
     
      
    }
    public void dessiner(){
            if(en_mouvement){
                zoo.deplacer_tous();
            }
            
            d.repaint();
            zoo.afficher_la();
           
    }
    
}
