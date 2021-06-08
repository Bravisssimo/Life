import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

public class PanelJoueur extends JPanel{//COnstructeur d'un panneau PanelJoueur qui extend la classe JPanl
	
	Joueur joueur;
	
	JPanel panelVie;//JPanel, au sein du PanelJoueur, qui contiendra toutes les boutons de vie
	JLabel nomJoueur;//pour l'affichage du nom du joueur
	ImageIcon vie;
	ImageIcon viePerdue;
	JButton[] tabVie; //tableau de bouton dans lequel seront ajouté les 10 boutons vie
	Dimension dimensionVie;
	
	//Déclaration de 10 boutons vie
	JButton vie1;
	JButton vie2;
	JButton vie3;
	JButton vie4;
	JButton vie5;
	JButton vie6;
	JButton vie7;
	JButton vie8;
	JButton vie9;
	JButton vie10;
	JButton vie11;
	JButton vie12;
	JButton vie13;
	JButton vie14;
	JButton vie15;
	JButton vie16;
	JButton vie17;
	JButton vie18;
	JButton vie19;
	JButton vie20;
	
	public PanelJoueur(Joueur j){//constructeur du PanelJoueur
		
		joueur=j;
		dimensionVie=new Dimension(20,20);
		
		vie= new ImageIcon(new ImageIcon("vie.png").getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT));//instanciation de l'image vie
		viePerdue=new ImageIcon(new ImageIcon("viePerdue.png").getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT));//instanciation de l'image vie perdue
	
		
		this.setLayout(new GridLayout(2,1)); //L'organisation spatiale du PanelJoueur est gérée grâce à un GridLayout (2ignes;1colonne)
		this.setOpaque(false);
		
		nomJoueur=new JLabel(j.name); //le nom qui s'affichera dans le Panel est le nom du joueur pris dans le constructeur 
		nomJoueur.setHorizontalAlignment(JLabel.CENTER);
		nomJoueur.setVerticalAlignment(JLabel.BOTTOM);
		nomJoueur.setPreferredSize(dimensionVie);
		
	
		this.add(nomJoueur); //on ajoute le label nomJoueur au panel
		
		
		panelVie=new JPanel();
		panelVie.setBackground(Color.RED);
		panelVie.setLayout(new FlowLayout());//L'organisation spatiale du panelVie est gérée grâce à un FlowLayout (insertion des objets les un après les autres sur une ligne)
		
		//Instanciation de tous les boutons vie
		vie1=new JButton(vie); 
		vie2=new JButton(vie); 
		vie3=new JButton(vie); 
		vie4=new JButton(vie); 
		vie5=new JButton(vie); 
		vie6=new JButton(vie); 
		vie7=new JButton(vie); 
		vie8=new JButton(vie); 
		vie9=new JButton(vie); 
		vie10=new JButton(vie);
		vie11=new JButton(vie);
		vie12=new JButton(vie);
		vie13=new JButton(vie);
		vie14=new JButton(vie);
		vie15=new JButton(vie);
		vie16=new JButton(vie);
		vie17=new JButton(vie);
		vie18=new JButton(vie);
		vie19=new JButton(vie);
		vie20=new JButton(vie);
		
		//On range tous ces boutons dans un tableau
		tabVie=new JButton[20];
		tabVie[0]=vie1;
		tabVie[1]=vie2;
		tabVie[2]=vie3;
		tabVie[3]=vie4;
		tabVie[4]=vie5;
		tabVie[5]=vie6;
		tabVie[6]=vie7;
		tabVie[7]=vie8;
		tabVie[8]=vie9;
		tabVie[9]=vie10;
		tabVie[10]=vie11;
		tabVie[11]=vie12;
		tabVie[12]=vie13;
		tabVie[13]=vie14;
		tabVie[14]=vie15;
		tabVie[15]=vie16;
		tabVie[16]=vie17;
		tabVie[17]=vie18;
		tabVie[18]=vie19;
		tabVie[19]=vie20;
		
		for(int i=0;i<=19;i++){//pour tous les boutons du tableau, on paramètre leur affichage et on les ajoute au PanelVie
			tabVie[i].setPreferredSize(dimensionVie);
			tabVie[i].setBorder(null);
			tabVie[i].setBorderPainted(false);
			tabVie[i].setContentAreaFilled(false);
			tabVie[i].setOpaque(false);
			panelVie.add(tabVie[i]);
		}
		
		this.add(panelVie,BorderLayout.SOUTH); //On ajoute le panelVie au PanelJoueur, en bas
	       
	}

}
