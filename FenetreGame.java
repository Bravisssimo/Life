import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;


public class FenetreGame extends JFrame implements ActionListener {
	//panels
	JPanel pan;
	JPanel panLose;
	JPanel panelGauche;
	JPanel panelCentre;
	JPanel panEnd;
	JPanel panBoutonRetourMenu;
	
	//boutons
	JButton boutonNext;
	JButton boutonSuite;
	JButton boutonRetourMenu;
	
	JLabel labelConsigne;//La consigne qui s'affichera au milieu de la fenetre
	JLabel labelPartieTerminee;
	JTextArea textAreaLose;//zone de texte dans lequel s'affichera un mot quand quelqu'un a plus de vie
	Joueur[] tableauJoueur;
	PanelJoueur[] tabPanelJoueur;//tableau de PanelJoueur qu'on affichera à gauche de la fenetre
	
	//Jeu
	consigne laConsigne;
	String univers;
	static int[][] doublons = new int[5][20];                           //tableau qui va stocker les numéros de consignes déjà tombées (20) par catégorie (5)
	int index0 = 0;
	int index1 = 0;
	int index2 = 0;
	int index3 = 0;
	int index4 = 0;
	
	//dimensions fenetre;police
	int width=1300;
	int height=700;
	Font policeConsigne;
	
	public FenetreGame (Joueur[] tab, String unUnivers){//constructeur de la Fenetre Game, prend en parametre un tableau de joueur
		
		//paramétrage de la fenêtre
		this.setTitle("Life");
        this.setSize(width,height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		this.tableauJoueur=tab;//récupère la liste des joueurs
		this.univers= unUnivers;
		
		laConsigne = new consigne(this.tableauJoueur, this.univers); 
		
		tabPanelJoueur=new PanelJoueur[tableauJoueur.length];//instanciation du tabPanelJoueur
		
		//Polices
		policeConsigne=new Font("Arial",Font.BOLD,40);
		
		
		//pan
		pan=new JPanel();
		pan.setBackground(new Color(170,200,230));
		pan.setLayout(new BorderLayout()); //L'organisation spatiale du pan est gérée grâce à un BorderLayout
		
		//panLose
		panLose=new JPanel();
		panLose.setBackground(new Color(0,0,0));
		panLose.setLayout(null);
		panLose.setSize(this.getContentPane().getWidth(),this.getContentPane().getHeight());
		
		//panEnd
		panEnd=new JPanel();
		panEnd.setBackground(new Color(0,0,0));
		panEnd.setLayout(new GridLayout(2,1));
		panEnd.setSize(this.getContentPane().getWidth(),this.getContentPane().getHeight());
		
		//pan bouton reour menu ==> contient seulement le bouton de retour menu à la fin de la partie
		panBoutonRetourMenu=new JPanel();
		panBoutonRetourMenu.setBackground(new Color(0,0,0));
		panBoutonRetourMenu.setLayout(new FlowLayout());
		
		
		
		//Panel centre
		panelCentre=new JPanel();
		panelCentre.setBackground(new Color(50,100,230));
		panelCentre.setLayout(null);
		
		
		//Panel gauche
		panelGauche=new JPanel();
		panelGauche.setPreferredSize(new Dimension(500,700));
		panelGauche.setBackground(new Color(50,150,230));
		panelGauche.setLayout(new GridLayout(10,1));//L'organisation spatiale du panel gauche est gérée grâce à un GridLayout (10lignes;1 colonne)
		
		
		pan.add(panelCentre,BorderLayout.CENTER);	//on ajoute le pancentre au centre	
		pan.add(panelGauche,BorderLayout.WEST); //on ajoute le pan gauche à gauche
		
				
		this.creationPanelJoueur(tableauJoueur); //Appel de la méthode creationPanelJoueur à partir du tableu de joueur
		addActionListenerBouton(tabPanelJoueur);


		this.setContentPane(pan);
		this.setVisible(true);
		
		//Bouton Next
		boutonNext=new JButton("NEXT");
		boutonNext.setSize(150,75);		
		boutonNext.setLocation(panelCentre.getWidth()/2-boutonNext.getWidth()/2,panelCentre.getHeight()/2-boutonNext.getHeight()/2+100);
		boutonNext.addActionListener(this);
		
		//Bouton retour menu
		boutonRetourMenu=new JButton("Retour au menu");
		boutonRetourMenu.setPreferredSize(new Dimension(200,75));
		boutonRetourMenu.setBackground(new Color(100,100,200));
		boutonRetourMenu.addActionListener(this);
		
		//Bouton Suite
		boutonSuite=new JButton("Suite");
		boutonSuite.setSize(200,100);		
		boutonSuite.setLocation(this.getContentPane().getWidth()/2-boutonSuite.getWidth()/2,this.getContentPane().getHeight()/2+150);
		boutonSuite.addActionListener(this);
		
		
		
		//Jlabel consigne
		labelConsigne=new JLabel(laConsigne.consigneAffichee);
		labelConsigne.setSize(panelCentre.getWidth(),300);
		labelConsigne.setLocation(0,0);
		labelConsigne.setHorizontalAlignment(JLabel.CENTER);
		labelConsigne.setVerticalAlignment(JLabel.CENTER);
		labelConsigne.setFont(policeConsigne);
		
		//Jlabel partieTerminée
		labelPartieTerminee=new JLabel("PARTIE TERMINEE");
		labelPartieTerminee.setSize(panelCentre.getWidth(),300);
		labelPartieTerminee.setHorizontalAlignment(JLabel.CENTER);
		labelPartieTerminee.setVerticalAlignment(JLabel.CENTER);
		labelPartieTerminee.setFont(policeConsigne);
		
		
		
		//JTextArea textAreaLoose
		textAreaLose=new JTextArea("");
		//textAreaLose.setEditable(false);
		textAreaLose.setLineWrap(true);
		textAreaLose.setSize(this.getContentPane().getWidth()*2/3,this.getContentPane().getHeight()/2);
		textAreaLose.setLocation(this.getContentPane().getWidth()/2-textAreaLose.getWidth()/2,this.getContentPane().getHeight()/4);
		//textAreaLose.setHorizontalAlignment(JTextArea.CENTER);
		//textAreaLose.setVerticalAlignment(JLabel.CENTER);
		textAreaLose.setFont(policeConsigne);
		textAreaLose.setBackground(Color.BLUE);
		textAreaLose.setForeground(Color.WHITE);
		
		panelCentre.add(boutonNext); panelCentre.add(labelConsigne);
		panLose.add(boutonSuite); panLose.add(textAreaLose);
		panBoutonRetourMenu.add(boutonRetourMenu);
		panEnd.add(labelPartieTerminee);panEnd.add(panBoutonRetourMenu);
		
		
	}
	
	//méthode de détection des clics
	public void actionPerformed (ActionEvent e){		
		detectionClicVie(e);
		int p=0;
		if(e.getSource()==boutonNext){
			if(nombreDeMort()!=0){
				affichageJoueurMort(nombreDeMort());
			}
				
				/*pan.setVisible(false);
				panLose.setVisible(true);
				this.setContentPane(panLose);*/
				
			if(nombreDeMort()>=tableauJoueur.length-1){
				//labelConsigne.setText("Partie terminee");
				pan.setVisible(false);
				panLose.setVisible(true);
				this.setContentPane(panEnd);
			}
			else if(nombreDeMort()==(tableauJoueur.length-2)){                    //Si il ne reste plus que deux personnes en vie
				labelConsigne.setText("Plus que deux joueurs en lice !");
			} else {                                                    //Si + de 2 en vie donc jeu normal
				laConsigne = new consigne(this.tableauJoueur, this.univers);
				labelConsigne.setText(laConsigne.consigneAffichee);	
			
				switch (laConsigne.type){                                //On note dans le tableau le numero de la consigne déjà passée
					
					case "Vote" :
						doublons[0][index0] = laConsigne.tirageActuel;
						index0++;
						break;
						
					case "Destin" :
						doublons[1][index1] = laConsigne.tirageActuel;
						index1++;
						break;
					
					case "Choix" :
						doublons[2][index2] = laConsigne.tirageActuel;
						index2++;
						break;
						
					case "Virus" :
						doublons[3][index3] = laConsigne.tirageActuel;
						index3++;
						break;
					
					case "Jeu" :
						doublons[4][index4] = laConsigne.tirageActuel;
						index4++;
						break;
				}	
			}
		}
		
		if(e.getSource()==boutonRetourMenu){
			FenetreAccueil start=new FenetreAccueil();
			dispose();
		}
			
		/*if(e.getSource()==boutonSuite){
			panLose.setVisible(false);
			pan.setVisible(true);
			this.setContentPane(pan);
		}
		*/
	}
	
	
	public void creationPanelJoueur(Joueur[] tab){
		for(int i=0; i<tab.length;i++){
			tabPanelJoueur[i]=new PanelJoueur(tab[i]);
			panelGauche.add(tabPanelJoueur[i]);
		}
	}
	
	
	
	//methode pour ajouter des action listener a tous les boutons "vie"
	public void addActionListenerBouton (PanelJoueur[] tab){
		for(int i=0;i<tab.length;i++){
			for(int j=0;j<tab[i].tabVie.length;j++){
				tab[i].tabVie[j].addActionListener(this);
			}				
		}
	}
	
	//méthode pour capter les clics de tous les boutons "vie" et gérer les pertes ou ajout de vie
	public void detectionClicVie(ActionEvent e){
		
		for(int i=0;i<tabPanelJoueur.length;i++){					//i correspond au panels joueurs
			for(int j=0;j<tabPanelJoueur[i].tabVie.length;j++){		//j correspond au bouton vie cliqué
				
				if(e.getSource()==tabPanelJoueur[i].tabVie[j]){

					if(tabPanelJoueur[i].joueur.vie>=j+1){
						for(int k=j;k<tabPanelJoueur[i].joueur.vie;k++){	//k correspond au nombre de vie 
							tabPanelJoueur[i].tabVie[k].setIcon(tabPanelJoueur[i].viePerdue);
						}
						tabPanelJoueur[i].joueur.vie=j;
						System.out.println(tabPanelJoueur[i].joueur.vie);
						
					}
					else if(tabPanelJoueur[i].joueur.vie<j+1){
						for(int k=tabPanelJoueur[i].joueur.vie;k<=j;k++){
							tabPanelJoueur[i].tabVie[k].setIcon(tabPanelJoueur[i].vie);
						}
						tabPanelJoueur[i].joueur.vie=j+1;
						System.out.println(tabPanelJoueur[i].joueur.vie);
					}
				
				
				}
			}
		}
	}		
	
	//Méthode pour récupérer le nombre de joueur mort
	public int nombreDeMort(){
		int p=0;
		for(int i=0;i<tableauJoueur.length;i++){
			if(tableauJoueur[i].vie==0){
				p++;
			}
		}
		return p;
	}
	
	public void affichageJoueurMort(int x){
		String[] tabJoueurMort=new String[x];
		int k=0;
		for(int i=0;i<tableauJoueur.length;i++){
			if(tableauJoueur[i].vie==0){
				tabJoueurMort[k]=tableauJoueur[i].name;
				k++;
			}
		}
		
		if(x==0){
			textAreaLose.setText(tabJoueurMort[0]+", tu as perdu");
		}
		else if(x>0){
			String plusieursJoueursMorts="";
			for(int i=0;i<tabJoueurMort.length;i++){
				plusieursJoueursMorts=plusieursJoueursMorts+tabJoueurMort[i];
			}
			textAreaLose.setText(plusieursJoueursMorts+", vous avez perdu");
		}
			
	}	
	
	 public static void main(String[]args){ //main test
		Joueur[]tab=new Joueur[3];
		Joueur pit=new Joueur("pit");
		Joueur vic=new Joueur("vic");
		Joueur lucas=new Joueur("lucas");
		tab[0]=pit;
		tab[1]=vic;
		tab[2]=lucas;
		String testUnivers= "Dikkenek";
		
        FenetreGame start=new FenetreGame(tab, testUnivers);
	}
	
	
}
