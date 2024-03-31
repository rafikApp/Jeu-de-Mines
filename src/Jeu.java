/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */

public class Jeu {
    private Plateau p;  // Le plateau du jeu
    
    
    public Jeu(){
        p=new Plateau(0,0, 0);
        
    }
   
    
    public int getNiveau(){
        int x;
        System.out.print("Choisissez le niveau de jeu (1,2,3…) :  ");
            do{
                x=Lire.i();
                if(x>9)
                    System.out.println("Le niveau doit être inférieur a 9");
            }while(x>9);    
           
               
        return x;
    }
    public int getL(){
        int x;
        System.out.print("\n entrer le nombre de ligne de votre Tableau :  ");
        x=Lire.i();
        return x;
    }
    public int getC(){
        int x;
        System.out.print("\n entrer le nombre de cologne de votre tableau:  ");
        x=Lire.i();
        System.out.println();
        return x;
    }
    public void jeu(){
        int i,j; // Declaration de deux entiers i et j pour stocker les cordonnées choisi par l'utilisateur
     
       int n=this.getNiveau(); // La récuperation du niveau de jeu en appelant la methode getNiveau
       int l= this.getL(); // La récuperation du nombre de lignes 
        int c=this.getC();  // La récuperation du nombre de colonnes
        
        this.p=new Plateau(l, c, n); // Initialisation du plateau de jeu
        
        this.p.placerLesmines();  // l'emplacement des mines dans le plateau
        
        
        // Boucle afin d'initialiser le tableau des voisinnages de chaque case du plateau
          for(int t=0;t<this.p.getNl();t++){ 
            for(int a=0;a<this.p.getNc();a++){
                this.p.getT(t, a).initVoisinage();
            }
         }
          
        // Boucle qui sert a modifier la somme de chaque case vide par le nombre de mines dans les cases adjacentes
         for(int t=0;t<this.p.getNl();t++){
            for(int a=0;a<this.p.getNc();a++){
                
             this.p.getT(t, a).sommeMines();
            }
            } 
         
         System.out.println("Vous devez trouver " +this.p.getNbMine()+" mines");
         
         // Affichage du plateau
         for(int t=0; t<this.p.getNl();t++){
            for(int a=0; a<this.p.getNc();a++){
                System.out.print("[ "+t+":"+a+" ]");
                }
            System.out.println();
            }
        System.out.println(); 
       
        
        do{ 
               
                //System.out.print("Choix d'une case au format <ligne:colonne>");
                
                do{
                     System.out.println("Veuillez jouer pour le coup "+(this.p.getCoup())+"\n");
                     System.out.println("Entrer la ligne :");
                    i=Lire.i();
                     System.out.println("Entrer la colonne :");
                    j=Lire.i();
                    if(i>l || j>c){
                         System.out.println("Erreur");
                    }
                       
                }while(i>l || j>c);
                
                p.getT(i, j).active(); // L'activation de la case choisi par l'utilisateur
                System.out.println(p.toString(i, j));    // Appel a la methode toString    
        }while(!this.p.getTerminer());
    
    }
    /*public String toString(){
        String res="";
        p.toString();
        if()
    }*/
       
        
    
}
