/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public abstract class Case {
    private int l,c;   // les cordonnées de la case dans le plateu
    private Plateau p;  // Le plateau de la case
    private String nom; // Type de la case (Vide ou Mine)
    private Voisinnage v;  // Les Voisinnages de la case

    public Voisinnage getV() {
        return v;
    }

    public void setV(Voisinnage v) {
        this.v = v;
    }
    
    
    public String getNom(){
        return this.nom;
    }
    
    public void setNom(String n){
        this.nom=n;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Plateau getP() {
        return p;
    }

    public void setP(Plateau p) {
        this.p = p;
    }

    public Case(Plateau p,int l, int c) {
        this.l = l;
        this.c = c;
        this.p = p;
        this.nom="";
        this.v=new Voisinnage();
    }
    
    public abstract void sommeMines();
    
    public abstract void initVoisinage(); 
    
    public abstract void active();
    
    public abstract String toString();
    
    
    
    
}
