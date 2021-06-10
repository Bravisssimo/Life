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
	static int[][] doublons = new int[5][20];                           //tableau qui va stocker les numéros de consignes déjà tombées (20) par catégorie (5)
	int compteurDestin = 0;                                             //compteurs de consignes déjà tombées par catégorie
	int compteurChoix = 0;
	int compteurVirus = 0;
	int compteurJeu = 0;
	int compteurVote = 0;
	
	//dimensions fenetre;police
	int width=1300;
	int height=700;
	Font policeConsigne;
	
	//consignes
	String[][] tableauVote = new String[10][2];
	String[][] tableauDestin = new String[15][2];
	String[][] tableauChoix = new String[10][2];
	String[][] tableauVirus = new String[10][2];
	String[][] tableauJeu = new String[10][2];
	String j1;
	String j2;
	String j3;
	
	public FenetreGame (Joueur[] tab, String unUnivers){                //constructeur de la Fenetre Game, prend en parametre un tableau de joueur
		
		for(int i=0; i<doublons[0].length; i++){                        //on initialise les valeurs de doublons à 100, sinon elles sont comptées comme le chiffre 0 et ça pose pb
		doublons[0][i] = 100;
		doublons[1][i] = 100;
		doublons[2][i] = 100;
		doublons[3][i] = 100;
		doublons[4][i] = 100;
		}
		
		//paramétrage de la fenêtre
		this.setTitle("Life");
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(true);
		
		this.tableauJoueur=tab;//récupère la liste des joueurs
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
		pan.add(panelGauche,BorderLayout.WEST); //on ajoute le pan gauche à hauche
			
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
		labelConsigne=new JLabel();
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
		
																		//Etablissement de la base de données en fonction de l'univers sélectionné
		switch (unUnivers){                                             //Déclaration consigne : la consigne dans la 1ère dimension, le nombre de joueurs contenus dans la 2nde.
			
			case "Dikkenek":
		
		//Categorie Vote	
		tableauVote[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauVote[0][1] = "trois";
		tableauVote[1][0] = "Votez tous pour la personne la plus timide et faites-lui un compliment, elle gagne deux vies"; tableauVote[1][1] = "zero";
		tableauVote[2][0] = ", choisis la personne avec laquelle t'aurais peur de te retrouver en pleine forêt la nuit (3 vies perdues) entre ces deux-la : "; tableauVote[2][1] = "trois";
		tableauVote[3][0] = "On vote tous pour faire perdre 2 vies a la personne designee !"; tableauVote[3][1] = "zero";
		tableauVote[4][0] = ", tout le monde vote : en haut pour te faire gagner 2 vies, en bas pour te les faire perdre !"; tableauVote[4][1] = "un";
		tableauVote[5][0] = " ......"; tableauVote[5][1] = "zero";
		tableauVote[6][0] = " ......"; tableauVote[6][1] = "zero";
		tableauVote[7][0] = " ......"; tableauVote[7][1] = "zero";
		tableauVote[8][0] = " ......"; tableauVote[8][1] = "zero";
		tableauVote[9][0] = " ......"; tableauVote[9][1] = "zero";
		
		//Categorie Destin	

		tableauDestin[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauDestin[0][1] = "trois";
 		tableauDestin[1][0] = " ......"; tableauDestin[1][1] = "zero";
		tableauDestin[2][0] = " ......"; tableauDestin[2][1] = "zero";
		tableauDestin[3][0] = " ......"; tableauDestin[3][1] = "zero";
		tableauDestin[4][0] = " ......"; tableauDestin[4][1] = "zero";
		tableauDestin[5][0] = " ......"; tableauDestin[5][1] = "zero";
		tableauDestin[6][0] = " ......"; tableauDestin[6][1] = "zero";
		tableauDestin[7][0] = " ......"; tableauDestin[7][1] = "zero";
		tableauDestin[8][0] = " ......"; tableauDestin[8][1] = "zero";
		tableauDestin[9][0] = " ......"; tableauDestin[9][1] = "zero";
		tableauDestin[10][0] = " ......"; tableauDestin[10][1] = "zero";
		tableauDestin[11][0] = " ......"; tableauDestin[11][1] = "zero";
		tableauDestin[12][0] = " ......"; tableauDestin[12][1] = "zero";
		tableauDestin[13][0] = " ......"; tableauDestin[13][1] = "zero";
		tableauDestin[14][0] = " ......"; tableauDestin[14][1] = "zero";
		
		//Categorie Choix	
		tableauChoix[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauChoix[0][1] = "trois";
		tableauChoix[1][0] = " ......"; tableauChoix[1][1] = "zero";
		tableauChoix[2][0] = " ......"; tableauChoix[2][1] = "zero";
		tableauChoix[3][0] = " ......"; tableauChoix[3][1] = "zero";
		tableauChoix[4][0] = " ......"; tableauChoix[4][1] = "zero";
		tableauChoix[5][0] = " ......"; tableauChoix[5][1] = "zero";
		tableauChoix[6][0] = " ......"; tableauChoix[6][1] = "zero";
		tableauChoix[7][0] = " ......"; tableauChoix[7][1] = "zero";
		tableauChoix[8][0] = " ......"; tableauChoix[8][1] = "zero";
		tableauChoix[9][0] = " ......"; tableauChoix[9][1] = "zero";
		
		//Categorie Virus	
		tableauVirus[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauVirus[0][1] = "trois";
		tableauVirus[1][0] = " ......"; tableauVirus[1][1] = "zero";
		tableauVirus[2][0] = " ......"; tableauVirus[2][1] = "zero";
		tableauVirus[3][0] = " ......"; tableauVirus[3][1] = "zero";
		tableauVirus[4][0] = " ......"; tableauVirus[4][1] = "zero";
		tableauVirus[5][0] = " ......"; tableauVirus[5][1] = "zero";
		tableauVirus[6][0] = " ......"; tableauVirus[6][1] = "zero";
		tableauVirus[7][0] = " ......"; tableauVirus[7][1] = "zero";
		tableauVirus[8][0] = " ......"; tableauVirus[8][1] = "zero";
		tableauVirus[9][0] = " ......"; tableauVirus[9][1] = "zero";
		
		//Categorie Jeu	
		tableauJeu[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauJeu[0][1] = "trois";
		tableauJeu[1][0] = " ......"; tableauJeu[1][1] = "zero";
		tableauJeu[2][0] = " ......"; tableauJeu[2][1] = "zero";
		tableauJeu[3][0] = " ......"; tableauJeu[3][1] = "zero";
		tableauJeu[4][0] = " ......"; tableauJeu[4][1] = "zero";
		tableauJeu[5][0] = " ......"; tableauJeu[5][1] = "zero";
		tableauJeu[6][0] = " ......"; tableauJeu[6][1] = "zero";
		tableauJeu[7][0] = " ......"; tableauJeu[7][1] = "zero";
		tableauJeu[8][0] = " ......"; tableauJeu[8][1] = "zero";
		tableauJeu[9][0] = " ......"; tableauJeu[9][1] = "zero";
		break;
			
			case "Harry Potter":
			
		//Categorie Vote	
		tableauVote[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauVote[0][1] = "trois";
		tableauVote[1][0] = "Votez tous pour la personne la plus timide et faites-lui un compliment, elle gagne deux vies"; tableauVote[1][1] = "zero";
		tableauVote[2][0] = ", choisis la personne avec laquelle t'aurais peur de te retrouver en pleine forêt la nuit (3 vies perdues) entre ces deux-la : "; tableauVote[2][1] = "trois";
		tableauVote[3][0] = "On vote tous pour faire perdre 2 vies a la personne designee !"; tableauVote[3][1] = "zero";
		tableauVote[4][0] = ", tout le monde vote : en haut pour te faire gagner 2 vies, en bas pour te les faire perdre !"; tableauVote[4][1] = "un";
		tableauVote[5][0] = " ......"; tableauVote[5][1] = "zero";
		tableauVote[6][0] = " ......"; tableauVote[6][1] = "zero";
		tableauVote[7][0] = " ......"; tableauVote[7][1] = "zero";
		tableauVote[8][0] = " ......"; tableauVote[8][1] = "zero";
		tableauVote[9][0] = " ......"; tableauVote[9][1] = "zero";
		
		//Categorie Destin	

		tableauDestin[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauDestin[0][1] = "trois";
 		tableauDestin[1][0] = " ......"; tableauDestin[1][1] = "zero";
		tableauDestin[2][0] = " ......"; tableauDestin[2][1] = "zero";
		tableauDestin[3][0] = " ......"; tableauDestin[3][1] = "zero";
		tableauDestin[4][0] = " ......"; tableauDestin[4][1] = "zero";
		tableauDestin[5][0] = " ......"; tableauDestin[5][1] = "zero";
		tableauDestin[6][0] = " ......"; tableauDestin[6][1] = "zero";
		tableauDestin[7][0] = " ......"; tableauDestin[7][1] = "zero";
		tableauDestin[8][0] = " ......"; tableauDestin[8][1] = "zero";
		tableauDestin[9][0] = " ......"; tableauDestin[9][1] = "zero";
		tableauDestin[10][0] = " ......"; tableauDestin[10][1] = "zero";
		tableauDestin[11][0] = " ......"; tableauDestin[11][1] = "zero";
		tableauDestin[12][0] = " ......"; tableauDestin[12][1] = "zero";
		tableauDestin[13][0] = " ......"; tableauDestin[13][1] = "zero";
		tableauDestin[14][0] = " ......"; tableauDestin[14][1] = "zero";
		
		//Categorie Choix	
		tableauChoix[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauChoix[0][1] = "trois";
		tableauChoix[1][0] = " ......"; tableauChoix[1][1] = "zero";
		tableauChoix[2][0] = " ......"; tableauChoix[2][1] = "zero";
		tableauChoix[3][0] = " ......"; tableauChoix[3][1] = "zero";
		tableauChoix[4][0] = " ......"; tableauChoix[4][1] = "zero";
		tableauChoix[5][0] = " ......"; tableauChoix[5][1] = "zero";
		tableauChoix[6][0] = " ......"; tableauChoix[6][1] = "zero";
		tableauChoix[7][0] = " ......"; tableauChoix[7][1] = "zero";
		tableauChoix[8][0] = " ......"; tableauChoix[8][1] = "zero";
		tableauChoix[9][0] = " ......"; tableauChoix[9][1] = "zero";
		
		//Categorie Virus	
		tableauVirus[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauVirus[0][1] = "trois";
		tableauVirus[1][0] = " ......"; tableauVirus[1][1] = "zero";
		tableauVirus[2][0] = " ......"; tableauVirus[2][1] = "zero";
		tableauVirus[3][0] = " ......"; tableauVirus[3][1] = "zero";
		tableauVirus[4][0] = " ......"; tableauVirus[4][1] = "zero";
		tableauVirus[5][0] = " ......"; tableauVirus[5][1] = "zero";
		tableauVirus[6][0] = " ......"; tableauVirus[6][1] = "zero";
		tableauVirus[7][0] = " ......"; tableauVirus[7][1] = "zero";
		tableauVirus[8][0] = " ......"; tableauVirus[8][1] = "zero";
		tableauVirus[9][0] = " ......"; tableauVirus[9][1] = "zero";
		
		//Categorie Jeu	
		tableauJeu[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauJeu[0][1] = "trois";
		tableauJeu[1][0] = " ......"; tableauJeu[1][1] = "zero";
		tableauJeu[2][0] = " ......"; tableauJeu[2][1] = "zero";
		tableauJeu[3][0] = " ......"; tableauJeu[3][1] = "zero";
		tableauJeu[4][0] = " ......"; tableauJeu[4][1] = "zero";
		tableauJeu[5][0] = " ......"; tableauJeu[5][1] = "zero";
		tableauJeu[6][0] = " ......"; tableauJeu[6][1] = "zero";
		tableauJeu[7][0] = " ......"; tableauJeu[7][1] = "zero";
		tableauJeu[8][0] = " ......"; tableauJeu[8][1] = "zero";
		tableauJeu[9][0] = " ......"; tableauJeu[9][1] = "zero";
		break;
			
			case "This Is Disco":
			
		//Categorie Vote	
		tableauVote[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauVote[0][1] = "trois";
		tableauVote[1][0] = "Votez tous pour la personne la plus timide et faites-lui un compliment, elle gagne deux vies"; tableauVote[1][1] = "zero";
		tableauVote[2][0] = ", choisis la personne avec laquelle t'aurais peur de te retrouver en pleine forêt la nuit (3 vies perdues) entre ces deux-la : "; tableauVote[2][1] = "trois";
		tableauVote[3][0] = "On vote tous pour faire perdre 2 vies a la personne designee !"; tableauVote[3][1] = "zero";
		tableauVote[4][0] = ", tout le monde vote : en haut pour te faire gagner 2 vies, en bas pour te les faire perdre !"; tableauVote[4][1] = "un";
		tableauVote[5][0] = " ......"; tableauVote[5][1] = "zero";
		tableauVote[6][0] = " ......"; tableauVote[6][1] = "zero";
		tableauVote[7][0] = " ......"; tableauVote[7][1] = "zero";
		tableauVote[8][0] = " ......"; tableauVote[8][1] = "zero";
		tableauVote[9][0] = " ......"; tableauVote[9][1] = "zero";
		
		//Categorie Destin	

		tableauDestin[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauDestin[0][1] = "trois";
 		tableauDestin[1][0] = " ......"; tableauDestin[1][1] = "zero";
		tableauDestin[2][0] = " ......"; tableauDestin[2][1] = "zero";
		tableauDestin[3][0] = " ......"; tableauDestin[3][1] = "zero";
		tableauDestin[4][0] = " ......"; tableauDestin[4][1] = "zero";
		tableauDestin[5][0] = " ......"; tableauDestin[5][1] = "zero";
		tableauDestin[6][0] = " ......"; tableauDestin[6][1] = "zero";
		tableauDestin[7][0] = " ......"; tableauDestin[7][1] = "zero";
		tableauDestin[8][0] = " ......"; tableauDestin[8][1] = "zero";
		tableauDestin[9][0] = " ......"; tableauDestin[9][1] = "zero";
		tableauDestin[10][0] = " ......"; tableauDestin[10][1] = "zero";
		tableauDestin[11][0] = " ......"; tableauDestin[11][1] = "zero";
		tableauDestin[12][0] = " ......"; tableauDestin[12][1] = "zero";
		tableauDestin[13][0] = " ......"; tableauDestin[13][1] = "zero";
		tableauDestin[14][0] = " ......"; tableauDestin[14][1] = "zero";
		
		//Categorie Choix	
		tableauChoix[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauChoix[0][1] = "trois";
		tableauChoix[1][0] = " ......"; tableauChoix[1][1] = "zero";
		tableauChoix[2][0] = " ......"; tableauChoix[2][1] = "zero";
		tableauChoix[3][0] = " ......"; tableauChoix[3][1] = "zero";
		tableauChoix[4][0] = " ......"; tableauChoix[4][1] = "zero";
		tableauChoix[5][0] = " ......"; tableauChoix[5][1] = "zero";
		tableauChoix[6][0] = " ......"; tableauChoix[6][1] = "zero";
		tableauChoix[7][0] = " ......"; tableauChoix[7][1] = "zero";
		tableauChoix[8][0] = " ......"; tableauChoix[8][1] = "zero";
		tableauChoix[9][0] = " ......"; tableauChoix[9][1] = "zero";
		
		//Categorie Virus	
		tableauVirus[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauVirus[0][1] = "trois";
		tableauVirus[1][0] = " ......"; tableauVirus[1][1] = "zero";
		tableauVirus[2][0] = " ......"; tableauVirus[2][1] = "zero";
		tableauVirus[3][0] = " ......"; tableauVirus[3][1] = "zero";
		tableauVirus[4][0] = " ......"; tableauVirus[4][1] = "zero";
		tableauVirus[5][0] = " ......"; tableauVirus[5][1] = "zero";
		tableauVirus[6][0] = " ......"; tableauVirus[6][1] = "zero";
		tableauVirus[7][0] = " ......"; tableauVirus[7][1] = "zero";
		tableauVirus[8][0] = " ......"; tableauVirus[8][1] = "zero";
		tableauVirus[9][0] = " ......"; tableauVirus[9][1] = "zero";
		
		//Categorie Jeu	
		tableauJeu[0][0] = ", choisis le meilleur cuistot (qui recuperera 3 vies) entre ces deux-la : "; tableauJeu[0][1] = "trois";
		tableauJeu[1][0] = " ......"; tableauJeu[1][1] = "zero";
		tableauJeu[2][0] = " ......"; tableauJeu[2][1] = "zero";
		tableauJeu[3][0] = " ......"; tableauJeu[3][1] = "zero";
		tableauJeu[4][0] = " ......"; tableauJeu[4][1] = "zero";
		tableauJeu[5][0] = " ......"; tableauJeu[5][1] = "zero";
		tableauJeu[6][0] = " ......"; tableauJeu[6][1] = "zero";
		tableauJeu[7][0] = " ......"; tableauJeu[7][1] = "zero";
		tableauJeu[8][0] = " ......"; tableauJeu[8][1] = "zero";
		tableauJeu[9][0] = " ......"; tableauJeu[9][1] = "zero";
		break;
		}
	}
	
	public static String theme (){                                      //Méthode du Tirage pour trouver la catégorie
			
		int tirageCategorie = (int)(Math.random()*100);
		String indicateur;
		if (tirageCategorie<20){
			indicateur = "Destin";
		}
		else if (tirageCategorie<40){
			indicateur = "Choix";
		}
		else if (tirageCategorie<60){
			indicateur = "Jeu";
		}
		else if (tirageCategorie<80){
			indicateur = "Vote";
		}
		else{
			indicateur = "Virus";
		}
		return indicateur;
	}
	
	public String trouverJoueur (Joueur[] tab){ 
		
		int tirage = (int)(Math.random()*tab.length);
		boolean refaireTirage = true;                                   //true si le joueur est mort (on refait le tirage), false sinon (on sélectionne ce joueur)
		
		while (refaireTirage == true){                                  //trouve un joueur, on répète le tirage tant que celui-ci n'est pas vivant
			refaireTirage = false;
			if (tab[tirage].vivant == false){                           //on utilise l'attribut booléen "vivant" du joueur
				tirage = (int)(Math.random()*tab.length);
				refaireTirage = true;
			}                                                     
		}
		return tab[tirage].name;
	}
	
	//Méthode pour trouver la consigne
	public String trouverConsigne () {
			
		boolean initiateur = true;                                      //Permet de rentrer pour la première fois dans le while
		boolean deja = false;                                           //true si consigne déjà passée, false sinon
		int tirageConsigne;                 
		String[] duoConsigne = {"",""};		
		String choixTheme = "Vote";

		switch (choixTheme){

			case "Destin":
			    
			    tirageConsigne = (int)(Math.random()*tableauDestin.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on reinitialise le booleen initiateur
					deja = false;                                       //on reinitialise le booleen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est dejà tombe on le refait
					for(int i=0; i<doublons[1].length; i++){                                     
						if (tirageConsigne == doublons[1][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauDestin.length);
						}
					}
				}
				duoConsigne = tableauDestin[tirageConsigne];
				doublons[1][compteurDestin] = tirageConsigne;
				compteurDestin++;
				if(compteurDestin == doublons[1].length){             //On réinitialise le tableau de doublons, ça permet de continuer la partie même si les questions se répètent
					for(int i=0;i<doublons[1].length;i++){
						doublons[1][i] = 100;
					}
				}
				break;
		
			case "Choix":
				
				tirageConsigne = (int)(Math.random()*tableauChoix.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on reinitialise le booleen initiateur
					deja = false;                                       //on reinitialise le booleen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est dejà tombe on le refait
					for(int i=0; i<doublons[2].length; i++){                                     
						if (tirageConsigne == doublons[2][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauChoix.length);
						}
					}
				}
				duoConsigne = tableauChoix[tirageConsigne];
				doublons[2][compteurChoix] = tirageConsigne;
				compteurChoix++;
				if(compteurChoix == doublons[2].length){             //On réinitialise le tableau de doublons, ça permet de continuer la partie même si les questions se répètent
					for(int i=0;i<doublons[2].length;i++){
						doublons[2][i] = 100;
					}
				}
				break; 
		        
			case "Jeu":
				
				tirageConsigne = (int)(Math.random()*tableauJeu.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on reinitialise le booleen initiateur
					deja = false;                                       //on reinitialise le booleen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est dejà tombe on le refait
					for(int i=0; i<doublons[4].length; i++){                                     
						if (tirageConsigne == doublons[4][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauJeu.length);
						}
					}
				}
				duoConsigne = tableauJeu[tirageConsigne];
				doublons[4][compteurJeu] = tirageConsigne;
				compteurJeu++;
				if(compteurJeu == doublons[4].length){             //On réinitialise le tableau de doublons, ça permet de continuer la partie même si les questions se répètent
					for(int i=0;i<doublons[4].length;i++){
						doublons[4][i] = 100;
					}
				}
				break; 
				
			case "Vote":
				
				tirageConsigne = (int)(Math.random()*tableauVote.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on reinitialise le booleen initiateur
					deja = false;                                       //on reinitialise le booleen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est dejà tombe on le refait
					for(int i=0; i<doublons[0].length; i++){                                     
						if (tirageConsigne == doublons[0][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauVote.length);
						}
					}
				}
				duoConsigne = tableauVote[tirageConsigne];
				doublons[0][compteurVote] = tirageConsigne;
				compteurVote++;
				if(compteurVote == doublons[0].length){             //On réinitialise le tableau de doublons, ça permet de continuer la partie même si les questions se répètent
					for(int i=0;i<doublons[0].length;i++){
						doublons[0][i] = 100;
					}
				}
				break; 
		
			case "Virus":
				
				tirageConsigne = (int)(Math.random()*tableauVirus.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on reinitialise le booleen initiateur
					deja = false;                                       //on reinitialise le booleen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est dejà tombe on le refait
					for(int i=0; i<doublons[3].length; i++){                                     
						if (tirageConsigne == doublons[3][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauVirus.length);
						}
					}
				}
				duoConsigne = tableauVirus[tirageConsigne];
				doublons[3][compteurVirus] = tirageConsigne;
				compteurVirus++;
				if(compteurVirus == doublons[3].length){             //On réinitialise le tableau de doublons, ça permet de continuer la partie même si les questions se répètent
					for(int i=0;i<doublons[3].length;i++){
						doublons[3][i] = 100;
					}
				}
				break;             
		    
		    //Si problème et que aucune categorie correspondante
			default:
			System.out.println("probleme de choix de la categorie");  			
		}
		
		//Débugeur
		/*System.out.println("Destin : "+compteurDestin+" / "+tableauDestin.length);
		System.out.println("Choix : "+compteurChoix+" / "+tableauChoix.length);
		System.out.println("Vote : "+compteurVote+" / "+tableauVote.length);
		System.out.println("Jeu : "+compteurJeu+" / "+tableauJeu.length);
		System.out.println("Virus : "+compteurVirus+" / "+tableauVirus.length);
		System.out.println("  ");*/
		
		//remplir la consigne choisie avec les joueurs
		if (duoConsigne[1]=="zero")
			return duoConsigne[0];
		else if (duoConsigne[1]=="un"){
			duoConsigne[0] = trouverJoueur(tableauJoueur)+duoConsigne[0];
		} else if (duoConsigne[1]=="deux"){
			j1 = trouverJoueur(tableauJoueur);
			j2 = trouverJoueur(tableauJoueur);
			while (j2 == j1){
				j2 = trouverJoueur(tableauJoueur);
			}
			duoConsigne[0] = j1+duoConsigne[0]+j2;
		} else if (duoConsigne[1]=="trois"){
			j1 = trouverJoueur(tableauJoueur);
			j2 = trouverJoueur(tableauJoueur);
			while (j2 == j1){
				j2 = trouverJoueur(tableauJoueur);
			}
			j3 = trouverJoueur(tableauJoueur);
			while (j3 == j1 || j3 == j2){
				j3 = trouverJoueur(tableauJoueur);
			}
			duoConsigne[0] = j1+duoConsigne[0]+j2+" et "+j3;
		}
		return duoConsigne[0];                                          //On renvoit la consigne remplie avec les joueurs sous forme de chaîne de caractères
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
			} else {                                                              //Si + de 2 en vie donc jeu normal
				labelConsigne.setText(trouverConsigne());	
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
			textAreaLose.setText(tabJoueurMort[0]+",tu as perdu, bois un cul-sec");
		}
		else if(x>0){
			String plusieursJoueursMorts="";
			for(int i=0;i<tabJoueurMort.length;i++){
				plusieursJoueursMorts=plusieursJoueursMorts+tabJoueurMort[i];
			}
			textAreaLose.setText(plusieursJoueursMorts+",vous avez perdu, buvez un cul-sec");
		}
	}	
	
	 /*public static void main(String[]args){ //main test
		Joueur[]tab=new Joueur[3];
		Joueur pit=new Joueur("pit");
		Joueur vic=new Joueur("vic");
		Joueur lucas=new Joueur("lucas");
		tab[0]=pit;
		tab[1]=vic;
		tab[2]=lucas;
		String testUnivers= "Dikkenek";
		
        FenetreGame start=new FenetreGame(tab, testUnivers);
	}*/	
}
