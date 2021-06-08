public class Joueur {
	String name;
	String statut;
	int tauxDeVm;
	int vie;
	int classement;
	boolean vivant;
	boolean oldVivant;
	
	public Joueur (String name){
		this.name=name;
		statut="neutre";//?
		tauxDeVm=0;
		oldVivant=true;
		vivant=true;
		vie=20;
		classement=1;
	}
	
		
}
