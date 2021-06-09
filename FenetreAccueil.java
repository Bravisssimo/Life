import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class FenetreAccueil extends JFrame implements ActionListener {
			
	//Attributs fenêtre
	int height=700;
    int width=1000;
    JPanel pan;
    JPanel conteneurJoueur;
    JPanel listeJoueur;
    JPanel universPanel;

     //polices   
    Font police1;
    Font police2;
    
    //Boutons
    JButton plus;
    JButton moins;
    JButton start;
    
    ButtonGroup groupeUnivers;
    
    JToggleButton dikkenekUnivers;
    JToggleButton harryPotterUnivers;
    JToggleButton thisIsDiscoUnivers;
    
    //Labels
    JLabel joueur;
    JLabel indicateurJoueurs;
    
    //Champs de texte pour rentrer les noms des joueurs
    JTextField textfieldJoueur1;
    JTextField textfieldJoueur2;
    JTextField textfieldJoueur3;
    JTextField textfieldJoueur4;
    JTextField textfieldJoueur5;
    JTextField textfieldJoueur6;
    JTextField textfieldJoueur7;
    JTextField textfieldJoueur8;
    JTextField textfieldJoueur9;
    JTextField textfieldJoueur10;
    
    int espacement=50; //espacement pour le JTextField


    JTextField[] listeTextfield; //tableau de champs de texte dans lequel on placera tous les champs de texte
    
    int nombreDeJoueur;
    String univers;
    
          
    public FenetreAccueil(){ //constructeur
		
		//implémentation des polices
		police1=new Font("Arial",Font.BOLD,28);
		police2=new Font("Arial",Font.BOLD,36);
		

		
		this.nombreDeJoueur=3;//on commence par défaut avec 3 joueurs
		univers = "";
		
		//paramètrage de la fenêtre
		this.setTitle("Life");
        this.setSize(width,height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);//pas de layout : placement des composants en absolu (pas bien)
		this.setResizable(false);
		
		//pan
		pan=new JPanel();
		pan.setBackground(Color.RED);
		pan.setLayout(null);
		this.setContentPane(pan);
		
		
		//conteneurJoueur
		conteneurJoueur=new JPanel();
		conteneurJoueur.setLayout(null);
		conteneurJoueur.setSize(1000,80);
		conteneurJoueur.setLocation(0,0);
		conteneurJoueur.setBackground(new Color(230,200,120));
		
		//listeJoueur (panel central dans lequel apparaitront les champs de texte pour les noms de joueur)
		listeJoueur=new JPanel();
		listeJoueur.setLayout(null);
		listeJoueur.setSize(200,600);
		listeJoueur.setLocation(width/2-listeJoueur.getWidth()/2,150);
		listeJoueur.setBackground(new Color(230,250,120));
		
		//universPanel (pour ranger les boutons de choix de l'univers)
		universPanel=new JPanel();
		universPanel.setLayout(new GridLayout(3,1));
		universPanel.setSize(150,300);
		universPanel.setLocation(100,height/2-universPanel.getHeight()/2);
		universPanel.setBackground(new Color(100,50,120));
		
		
		//bouton plus
		
		plus=new JButton(new ImageIcon("plus.png"));
		plus.setSize(40,70);
		plus.setLocation(550,0);
        plus.setBorder(null);
        plus.setBorderPainted(false);
        plus.setContentAreaFilled(false);
        plus.setOpaque(false);
        plus.addActionListener(this);//on ajoute un action listener pour capter les clics dessus
        
        
        //bouton moins
		moins=new JButton(new ImageIcon("moins.png"));
		moins.setSize(40,70);
		moins.setLocation(440,0);
        moins.setBorder(null);
        moins.setBorderPainted(false);
        moins.setContentAreaFilled(false);
        moins.setOpaque(false);
        moins.addActionListener(this);
        
        //bouton start
        start=new JButton(new ImageIcon("start.png"));
		start.setSize(155,82);
		start.setLocation(650,height/2);
        start.setBorder(null);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        start.setOpaque(false);
        start.addActionListener(this);
        
        
        
        //boutons univers
        
        
        dikkenekUnivers=new JToggleButton("Dikkenek");
        dikkenekUnivers.setBackground(new Color(150,150,250));
        dikkenekUnivers.addActionListener(this);
        harryPotterUnivers=new JToggleButton("Harry Potter");
        harryPotterUnivers.setBackground(new Color(150,150,250));
        harryPotterUnivers.addActionListener(this);
        thisIsDiscoUnivers=new JToggleButton("This Is Disco");
        thisIsDiscoUnivers.setBackground(new Color(150,150,250));
        thisIsDiscoUnivers.addActionListener(this);
        
        groupeUnivers=new ButtonGroup();
        
        groupeUnivers.add(dikkenekUnivers);
        groupeUnivers.add(harryPotterUnivers);
        groupeUnivers.add(thisIsDiscoUnivers);
        
        universPanel.add(dikkenekUnivers);
        universPanel.add(harryPotterUnivers);
        universPanel.add(thisIsDiscoUnivers);
        
        //label choisissez nbre de joeuur
        joueur=new JLabel("Nombre de joueurs :");
        joueur.setFont(police2);
        joueur.setSize(600,70);
        joueur.setLocation(50,0);
        
        //label indicateur joueurs
        
		indicateurJoueurs=new JLabel(String.valueOf(nombreDeJoueur)); //il affiche le nombre de joueur initial (3)
		indicateurJoueurs.setFont(police2);
		indicateurJoueurs.setSize(40,70);
		indicateurJoueurs.setLocation(505,0);
		
		//instanciation des textfield
		textfieldJoueur1=new JTextField();
		textfieldJoueur1.setBounds(10,20,listeJoueur.getWidth()-20,20);
		
		textfieldJoueur2=new JTextField();
		textfieldJoueur2.setBounds(10,textfieldJoueur1.getY()+espacement,listeJoueur.getWidth()-20,20); //on place chaque champs de texte en dessous du précédent
		
		textfieldJoueur3=new JTextField();
		textfieldJoueur3.setBounds(10,textfieldJoueur2.getY()+espacement,listeJoueur.getWidth()-20,20);
		//textfieldJoueur3.setVisible(false);
		
		textfieldJoueur4=new JTextField();
		textfieldJoueur4.setBounds(10,textfieldJoueur3.getY()+espacement,listeJoueur.getWidth()-20,20);
		textfieldJoueur4.setVisible(false);
		
		textfieldJoueur5=new JTextField();
		textfieldJoueur5.setBounds(10,textfieldJoueur4.getY()+espacement,listeJoueur.getWidth()-20,20);
		textfieldJoueur5.setVisible(false);
		
		textfieldJoueur6=new JTextField();
		textfieldJoueur6.setBounds(10,textfieldJoueur5.getY()+espacement,listeJoueur.getWidth()-20,20);
		textfieldJoueur6.setVisible(false);
		
		textfieldJoueur7=new JTextField();
		textfieldJoueur7.setBounds(10,textfieldJoueur6.getY()+espacement,listeJoueur.getWidth()-20,20);
		textfieldJoueur7.setVisible(false);
				
		textfieldJoueur8=new JTextField();
		textfieldJoueur8.setBounds(10,textfieldJoueur7.getY()+espacement,listeJoueur.getWidth()-20,20);
		textfieldJoueur8.setVisible(false);
		
		textfieldJoueur9=new JTextField();
		textfieldJoueur9.setBounds(10,textfieldJoueur8.getY()+espacement,listeJoueur.getWidth()-20,20);
		textfieldJoueur9.setVisible(false);
		
		textfieldJoueur10=new JTextField();
		textfieldJoueur10.setBounds(10,textfieldJoueur9.getY()+espacement,listeJoueur.getWidth()-20,20);
		textfieldJoueur10.setVisible(false); 
		//donc 10 joueurs max
		
		//instanciation du tableau de textfield et ajout des jTextfield au tableau
		listeTextfield=new JTextField[10];
		
		listeTextfield[0]=textfieldJoueur1;
		listeTextfield[1]=textfieldJoueur2;
		listeTextfield[2]=textfieldJoueur3;
		listeTextfield[3]=textfieldJoueur4;
		listeTextfield[4]=textfieldJoueur5;
		listeTextfield[5]=textfieldJoueur6;
		listeTextfield[6]=textfieldJoueur7;
		listeTextfield[7]=textfieldJoueur8;
		listeTextfield[8]=textfieldJoueur9;
		listeTextfield[9]=textfieldJoueur10;

        
        //ajout des boutons et des panels a pan
        conteneurJoueur.add(plus); conteneurJoueur.add(moins); conteneurJoueur.add(indicateurJoueurs); conteneurJoueur.add(joueur);
        for (int i=0;i<10;i++){
			listeJoueur.add(listeTextfield[i]); 
		}
        pan.add(conteneurJoueur); pan.add(listeJoueur); pan.add(universPanel);
        pan.add(start);
        
        
        this.setContentPane(pan);

        this.setVisible(true);

		
	}
    
    public void actionPerformed (ActionEvent e){ //methode pour récupérer les clic sur les boutons par exemple
       if(e.getSource()==plus){
			gestionPlus();
        }
       if(e.getSource()==moins){
            gestionMoins();
        } 
       if(e.getSource()==start){
		   nouvellePartie();
	   }
	   if(e.getSource()==dikkenekUnivers){
		   univers="Dikkenek";
		   System.out.println("dikkenek choisi");
	   }
	   if(e.getSource()==harryPotterUnivers){
		   univers="Harry Potter";
	   }
	   if(e.getSource()==thisIsDiscoUnivers){
		   univers="This is Disco";
	   }
        
    }
    
    public void gestionPlus(){//méthode pour gérer l'appui sur le bouton Plus
		if(nombreDeJoueur<10){ //si le nombre de joueur est inférieru à 10, on en rajoute 1.
			nombreDeJoueur=nombreDeJoueur+1;
			//listeJoueur.add(listeTextfield[nombreDeJoueur-1]);
			listeTextfield[nombreDeJoueur-1].setVisible(true); //on affiche le champs de texte associé au nouveau joueur
			//listeJoueur.revalidate(); //on raffraichit le panel contenant les textfield
			//listeJoueur.repaint();
		}
		else{
			nombreDeJoueur=nombreDeJoueur;
		}
		indicateurJoueurs.setText(String.valueOf(nombreDeJoueur)); //on met à jouer l'affichage du nombre de joueur
		//indicateurJoueurs.validate();
	}
	
	public void gestionMoins(){ //méthode pour gérer l'appui sur le bouton Moins
		if(nombreDeJoueur>3){
			nombreDeJoueur=nombreDeJoueur-1;
			listeTextfield[nombreDeJoueur].setVisible(false);
			/*listeJoueur.revalidate();
			listeJoueur.repaint();*/
		}
		else{
			nombreDeJoueur=nombreDeJoueur;
		}
		indicateurJoueurs.setText(String.valueOf(nombreDeJoueur));
	}
	
	public void nouvellePartie(){//méthode pour lancer la fenêtre jeu lorsqu'on clique sur Start
		boolean full=true ;
		for(int l=0;l<nombreDeJoueur;l++){
			if(listeTextfield[l].getText().equals("")){
				full=false;
				l=nombreDeJoueur;
				System.out.println("nom de joueur vide");
			}
			else{
				full=true;
			}
		}
		if(full==true && univers.equals("")==false){
			//System.out.println("full true et theme non vide");
			Joueur[] tableauJoueur=new Joueur[nombreDeJoueur]; //on créé un tableau de joueur
			for(int i=0;i<nombreDeJoueur;i++){
				tableauJoueur[i]=new Joueur(listeTextfield[i].getText());
			}
			FenetreGame game=new FenetreGame(tableauJoueur, univers);//on construit la fenetre Jeu avec le tableau de joueur
			dispose();
		}
			
			
		/*for(int i=0;i<=nombreDeJoueur;i++){
			System.out.println(tableauJoueur[i].name);
		}*/
	}
    
    public static void main(String[]args){//lance une partie à l'exécution
        FenetreAccueil start=new FenetreAccueil();

    }
			
}

