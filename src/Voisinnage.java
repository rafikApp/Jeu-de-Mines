/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class Voisinnage {
    Case[] t;  // Tableau de type Case qui sert a stocker les cases voisinnes (adjacentes) de la première Case
   
    
    public Voisinnage(){
   
        t=new Case[9];
        t[0]=null;
         t[1]=null;
          t[2]=null;
           t[3]=null;
            t[4]=null;
             t[5]=null;
              t[6]=null;
               t[7]=null;
                t[8]=null; 
    }
    public void setT(Case c,int i) {
        this.t[i] = c;
    }
    public Case getT(int i) {
        return t[i];
    }
    
  
       

}
