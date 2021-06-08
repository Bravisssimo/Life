public class consigne {


	String type;
	String consigneAffichee;
	int tirageActuel;                                                   //va servir a repérer quelles consignes sont déjà tombées au cours de la partie
	String[] tableauVote = new String[10];
	String[] tableauDestin = new String[15];
	String[] tableauJeu = new String[13];
	String[] tableauVirus = new String[10];
	String[] tableauChoix = new String[10];
	
	
	//la méthode pour tirer au hasard un/des joueur(s). Elle prend en paramètre le tableau de joueurs ainsi que le nombre de joueurs demandés
	public String[] trouverJoueurs (Joueur[] tab, int nbJoueurs){
		
		int tirage = (int)(Math.random()*tab.length);
		boolean refaireTirage = true;                                   //true si le joueur est mort (on refait le tirage), false sinon (on sélectionne ce joueur)
		String[] resultatNoms = new String[nbJoueurs];                  //le tableau de noms de joueurs, celui qu'on va retourner in fine
		
		while (refaireTirage == true){                                  //trouve un joueur, on répète le tirage tant que celui-ci n'est pas vivant
			refaireTirage = false;
			if (tab[tirage].vivant == false){                              //on utilise l'attribut booléen "mort" du joueur
				tirage = (int)(Math.random()*tab.length);
				refaireTirage = true;
			}
			else {                                                      //le joueur est vivant, on inscrit son nom dans resultatNoms
				resultatNoms[0] = tab[tirage].name;
			}
		}
		if (nbJoueurs == 1){                                            //si on avait besoin que d'un seul joueur, la méthode est finie
			return resultatNoms;
		}
		else {                                                          //si on a besoin de plusieurs joueurs, on en sélectionne un nouveau qui n'a pas déjà été sélectionné et qui est vivant
			tirage = (int)(Math.random()*tab.length);
			refaireTirage = true;
			while (refaireTirage == true){
				refaireTirage = false;
				if (tab[tirage].vivant == false || tab[tirage].name == resultatNoms[0]){
					tirage = (int)(Math.random()*tab.length);
					refaireTirage = true;
				}
				else {
					resultatNoms[1] = tab[tirage].name;
				}
			}
			if (nbJoueurs == 2){
				return resultatNoms;
			}
			else {
				tirage = (int)(Math.random()*tab.length);
				refaireTirage = true;
				while (refaireTirage == true){
					refaireTirage = false;
					if (tab[tirage].vivant == false || tab[tirage].name == resultatNoms[0] || tab[tirage].name == resultatNoms[1]){
						tirage = (int)(Math.random()*tab.length);
						refaireTirage = true;
					}
					else {
						resultatNoms[2] = tab[tirage].name;
					}
				}
				return resultatNoms;
			}
		}
	}
	
	public consigne (Joueur[] tabJoueurs, String univers){
		//System.out.println("constructeur de consigne lance");
		
		switch (univers){
			
			case "Dikkenek":
		
		//Catégorie Vote	
		String[] T0vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[0] = T0vDikk[0]+", choisis le meilleur cuistot entre"+T0vDikk[1]+"et"+T0vDikk[2]+", il récupère 3 vies";
		String[] T1vDikk = trouverJoueurs(tabJoueurs, 3); 
		tableauVote[1] =  " ......";
		String[] T2vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[2] =  " ......";
		String[] T3vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[3] =  " ......";
		String[] T4vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[4] = " ......";
		String[] T5vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[5] =  " ......";
		String[] T6vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[6] =  " ......";
		String[] T7vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[7] =  " ......";
		String[] T8vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[8] =  " ......";
		String[] T9vDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVote[9] =  " ......";
		
		//Catégorie Destin	
		String[] T0dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[0] = T0dDikk[0]+", choisis le meilleur cuistot entre"+T0dDikk[1]+"et"+T0dDikk[2]+", il récupère 3 vies";
		String[] T1dDikk = trouverJoueurs(tabJoueurs, 3); 
		tableauDestin[1] =  " gab la suceuse";
		String[] T2dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[2] =  " ......";
		String[] T3dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[3] =  " ......";
		String[] T4dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[4] = " ......";
		String[] T5dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[5] =  " ......";
		String[] T6dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[6] =  " ......";
		String[] T7dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[7] =  " ......";
		String[] T8dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[8] =  " ......";
		String[] T9dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[9] =  " ......";
		String[] T10dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[10] =  " ......";
		String[] T11dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[11] =  " ......";
		String[] T12dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[12] =  " ......";
		String[] T13dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[13] =  " ......";
		String[] T14dDikk = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[14] =  " ......";
		
		//Catégorie Choix	
		String[] T0cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[0] = T0cDikk[0]+", choisis le meilleur cuistot entre"+T0cDikk[1]+"et"+T0cDikk[2]+", il récupère 3 vies";
		String[] T1cDikk = trouverJoueurs(tabJoueurs, 3); 
		tableauChoix[1] =  ".......";
		String[] T2cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[2] =  " ......";
		String[] T3cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[3] =  " ......";
		String[] T4cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[4] = " ......";
		String[] T5cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[5] =  " ......";
		String[] T6cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[6] =  " ......";
		String[] T7cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[7] =  " ......";
		String[] T8cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[8] =  " ......";
		String[] T9cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[9] =  " ......";
		/*String[] T10cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[10] =  " ......";
		String[] T11cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[11] =  " ......";
		String[] T12cDikk = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[12] =  " ......";*/
		
		//Catégorie Virus	
		String[] T0viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[0] = T0viDikk[0]+", choisis le meilleur cuistot entre"+T0viDikk[1]+"et"+T0viDikk[2]+", il récupère 3 vies";
		String[] T1viDikk = trouverJoueurs(tabJoueurs, 3); 
		tableauVirus[1] =  ".......";
		String[] T2viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[2] =  " ......";
		String[] T3viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[3] =  " ......";
		String[] T4viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[4] = " ......";
		String[] T5viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[5] =  " ......";
		String[] T6viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[6] =  " ......";
		String[] T7viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[7] =  " ......";
		String[] T8viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[8] =  " ......";
		String[] T9viDikk = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[9] =  " ......";
		
		//Catégorie Jeu	
		String[] T0jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[0] = T0jDikk[0]+", choisis le meilleur cuistot entre"+T0jDikk[1]+"et"+T0jDikk[2]+", il récupère 3 vies";
		String[] T1jDikk = trouverJoueurs(tabJoueurs, 3); 
		tableauJeu[1] =  " ......";
		String[] T2jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[2] =  " ......";
		String[] T3jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[3] =  " ......";
		String[] T4jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[4] = " ......";
		String[] T5jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[5] =  " ......";
		String[] T6jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[6] =  " ......";
		String[] T7jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[7] =  " ......";
		String[] T8jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[8] =  " ......";
		String[] T9jDikk = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[9] =  " ......";
		break;
			
			case "Harry Potter":
			
		//Catégorie Vote	
		String[] T0vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[0] = T0vHp[0]+", choisis le meilleur cuistot entre"+T0vHp[1]+"et"+T0vHp[2]+", il récupère 3 vies";
		String[] T1vHp = trouverJoueurs(tabJoueurs, 3); 
		tableauVote[1] =  ".......";
		String[] T2vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[2] =  " ......";
		String[] T3vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[3] =  " ......";
		String[] T4vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[4] = " ......";
		String[] T5vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[5] =  " ......";
		String[] T6vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[6] =  " ......";
		String[] T7vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[7] =  " ......";
		String[] T8vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[8] =  " ......";
		String[] T9vHp = trouverJoueurs(tabJoueurs, 3);
		tableauVote[9] =  " ......";
		
		//Catégorie Destin	
		String[] T0dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[0] = T0dHp[0]+", choisis le meilleur cuistot entre"+T0dHp[1]+"et"+T0dHp[2]+", il récupère 3 vies";
		String[] T1dHp = trouverJoueurs(tabJoueurs, 3); 
		tableauDestin[1] =  " ......";
		String[] T2dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[2] =  " ......";
		String[] T3dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[3] =  " ......";
		String[] T4dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[4] = " ......";
		String[] T5dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[5] =  " ......";
		String[] T6dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[6] =  " ......";
		String[] T7dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[7] =  " ......";
		String[] T8dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[8] =  " ......";
		String[] T9dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[9] =  " ......";
		String[] T10dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[10] =  " ......";
		String[] T11dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[11] =  " ......";
		String[] T12dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[12] =  " ......";
		String[] T13dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[13] =  " ......";
		String[] T14dHp = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[14] =  " ......";
		
		//Catégorie Choix	
		String[] T0cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[0] = T0cHp[0]+", choisis le meilleur cuistot entre"+T0cHp[1]+"et"+T0cHp[2]+", il récupère 3 vies";
		String[] T1cHp = trouverJoueurs(tabJoueurs, 3); 
		tableauChoix[1] =  " .......";
		String[] T2cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[2] =  " ......";
		String[] T3cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[3] =  " ......";
		String[] T4cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[4] = " ......";
		String[] T5cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[5] =  " ......";
		String[] T6cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[6] =  " ......";
		String[] T7cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[7] =  " ......";
		String[] T8cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[8] =  " ......";
		String[] T9cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[9] =  " ......";
		/*String[] T10cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[10] =  " ......";
		String[] T11cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[11] =  " ......";
		String[] T12cHp = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[12] =  " ......";*/
		
		//Catégorie Virus	
		String[] T0viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[0] = T0viHp[0]+", choisis le meilleur cuistot entre"+T0viHp[1]+"et"+T0viHp[2]+", il récupère 3 vies";
		String[] T1viHp = trouverJoueurs(tabJoueurs, 3); 
		tableauVirus[1] =  ".......";
		String[] T2viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[2] =  " ......";
		String[] T3viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[3] =  " ......";
		String[] T4viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[4] = " ......";
		String[] T5viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[5] =  " ......";
		String[] T6viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[6] =  " ......";
		String[] T7viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[7] =  " ......";
		String[] T8viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[8] =  " ......";
		String[] T9viHp = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[9] =  " ......";
		
		//Catégorie Jeu	
		String[] T0jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[0] = T0jHp[0]+", choisis le meilleur cuistot entre"+T0jHp[1]+"et"+T0jHp[2]+", il récupère 3 vies";
		String[] T1jHp = trouverJoueurs(tabJoueurs, 3); 
		tableauJeu[1] =  "......";
		String[] T2jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[2] =  " ......";
		String[] T3jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[3] =  " ......";
		String[] T4jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[4] = " ......";
		String[] T5jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[5] =  " ......";
		String[] T6jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[6] =  " ......";
		String[] T7jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[7] =  " ......";
		String[] T8jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[8] =  " ......";
		String[] T9jHp = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[9] =  " ......";
		break;
			
			case "This Is Disco":
			
		//Catégorie Vote	
		String[] T0vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[0] = T0vTid[0]+", choisis le meilleur cuistot entre"+T0vTid[1]+"et"+T0vTid[2]+", il récupère 3 vies";
		String[] T1vTid = trouverJoueurs(tabJoueurs, 3); 
		tableauVote[1] =  " ......";
		String[] T2vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[2] =  " ......";
		String[] T3vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[3] =  " ......";
		String[] T4vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[4] = " ......";
		String[] T5vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[5] =  " ......";
		String[] T6vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[6] =  " ......";
		String[] T7vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[7] =  " ......";
		String[] T8vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[8] =  " ......";
		String[] T9vTid = trouverJoueurs(tabJoueurs, 3);
		tableauVote[9] =  " ......";
		
		//Catégorie Destin	
		String[] T0dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[0] = T0dTid[0]+", choisis le meilleur cuistot entre"+T0dTid[1]+"et"+T0dTid[2]+", il récupère 3 vies";
		String[] T1dTid = trouverJoueurs(tabJoueurs, 3); 
		tableauDestin[1] =  ".......";
		String[] T2dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[2] =  " ......";
		String[] T3dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[3] =  " ......";
		String[] T4dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[4] = " ......";
		String[] T5dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[5] =  " ......";
		String[] T6dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[6] =  " ......";
		String[] T7dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[7] =  " ......";
		String[] T8dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[8] =  " ......";
		String[] T9dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[9] =  " ......";
		String[] T10dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[10] =  " ......";
		String[] T11dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[11] =  " ......";
		String[] T12dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[12] =  " ......";
		String[] T13dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[13] =  " ......";
		String[] T14dTid = trouverJoueurs(tabJoueurs, 3);
		tableauDestin[14] =  " ......";
		
		//Catégorie Choix	
		String[] T0cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[0] = T0cTid[0]+", choisis le meilleur cuistot entre"+T0cTid[1]+"et"+T0cTid[2]+", il récupère 3 vies";
		String[] T1cTid = trouverJoueurs(tabJoueurs, 3); 
		tableauChoix[1] =  "........";
		String[] T2cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[2] =  " ......";
		String[] T3cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[3] =  " ......";
		String[] T4cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[4] = " ......";
		String[] T5cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[5] =  " ......";
		String[] T6cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[6] =  " ......";
		String[] T7cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[7] =  " ......";
		String[] T8cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[8] =  " ......";
		String[] T9cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[9] =  " ......";
		String[] T10cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[10] =  " ......";
		String[] T11cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[11] =  " ......";
		String[] T12cTid = trouverJoueurs(tabJoueurs, 3);
		tableauChoix[12] =  " ......";
		
		//Catégorie Virus	
		String[] T0viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[0] = T0viTid[0]+", choisis le meilleur cuistot entre"+T0viTid[1]+"et"+T0viTid[2]+", il récupère 3 vies";
		String[] T1viTid = trouverJoueurs(tabJoueurs, 3); 
		tableauVirus[1] =  ".......";
		String[] T2viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[2] =  " ......";
		String[] T3viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[3] =  " ......";
		String[] T4viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[4] = " ......";
		String[] T5viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[5] =  " ......";
		String[] T6viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[6] =  " ......";
		String[] T7viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[7] =  " ......";
		String[] T8viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[8] =  " ......";
		String[] T9viTid = trouverJoueurs(tabJoueurs, 3);
		tableauVirus[9] =  " ......";
		
		//Catégorie Jeu	
		String[] T0jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[0] = T0jTid[0]+", choisis le meilleur cuistot entre"+T0jTid[1]+"et"+T0jTid[2]+", il récupère 3 vies";
		String[] T1jTid = trouverJoueurs(tabJoueurs, 3); 
		tableauJeu[1] =  " .......";
		String[] T2jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[2] =  " ......";
		String[] T3jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[3] =  " ......";
		String[] T4jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[4] = " ......";
		String[] T5jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[5] =  " ......";
		String[] T6jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[6] =  " ......";
		String[] T7jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[7] =  " ......";
		String[] T8jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[8] =  " ......";
		String[] T9jTid = trouverJoueurs(tabJoueurs, 3);
		tableauJeu[9] =  " ......";
		break;
		}
		updateConsigne();
	}
	
	public static String theme (){
		//Tirage pour trouver la catégorie	
		int tirageCategorie = (int)(Math.random()*100);
		
		//Désignation de la catégorie
		String indicateur;
		if (tirageCategorie<20){
			indicateur = "Destin";
			System.out.println("destin");}
		else if (tirageCategorie<40){
			indicateur = "Choix";
			System.out.println("Choix");}
		else if (tirageCategorie<60){
			indicateur = "Jeu";
			System.out.println("Jeu");}
		else if (tirageCategorie<80){
			indicateur = "Vote";
			System.out.println("Vote");}
		else{
			indicateur = "Virus";
			System.out.println("Virus");
		}
		return indicateur;
	}
	
	//Méthode pour trouver la consigne
	public String trouverConsigne () {
		System.out.println("méthode trouverConsigne lancee");
		
		boolean initiateur = true;                                      //Permet de rentrer pour la première fois dans le while
		boolean deja = false;                                           //true si consigne déjà passée, false sinon
		int tirageConsigne;                  
		String enonceConsigne="";
			
		//Appel de la méthode de la catégorie choisie
		switch (this.type){

			case "Destin":
			    
			    tirageConsigne = (int)(Math.random()*tableauDestin.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on réinitialise le booléen initiateur
					deja = false;                                       //on réinitialise le booléen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est déjà tombé on le refait
					for(int i=0; i<FenetreGame.doublons[1].length; i++){                                     
						if (tirageConsigne == FenetreGame.doublons[1][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauDestin.length);
						}
					}
				}
				enonceConsigne = tableauDestin[tirageConsigne];
				tirageActuel = tirageConsigne;
				break;
		
			case "Choix":
				
				tirageConsigne = (int)(Math.random()*tableauChoix.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on réinitialise le booléen initiateur
					deja = false;                                       //on réinitialise le booléen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est déjà tombé on le refait
					for(int i=0; i<FenetreGame.doublons[2].length; i++){                                     
						if (tirageConsigne == FenetreGame.doublons[2][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauChoix.length);
						}
					}
				}
				enonceConsigne = tableauChoix[tirageConsigne];
				tirageActuel = tirageConsigne;
				break; 
		        
			case "Jeu":
				
				tirageConsigne = (int)(Math.random()*tableauJeu.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on réinitialise le booléen initiateur
					deja = false;                                       //on réinitialise le booléen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est déjà tombé on le refait
					for(int i=0; i<FenetreGame.doublons[4].length; i++){                                     
						if (tirageConsigne == FenetreGame.doublons[4][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauJeu.length);
						}
					}
				}
				enonceConsigne = tableauJeu[tirageConsigne];
				tirageActuel = tirageConsigne;
				break; 
				
			case "Vote":
				
				tirageConsigne = (int)(Math.random()*tableauVote.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on réinitialise le booléen initiateur
					deja = false;                                       //on réinitialise le booléen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est déjà tombé on le refait
					for(int i=0; i<FenetreGame.doublons[0].length; i++){                                     
						if (tirageConsigne == FenetreGame.doublons[0][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauVote.length);
						}
					}
				}
				enonceConsigne = tableauVote[tirageConsigne];
				tirageActuel = tirageConsigne;
				break; 
		
			case "Virus":
				
				tirageConsigne = (int)(Math.random()*tableauVirus.length);
				while (initiateur == true || deja == true){             
					initiateur = false;                                 //on réinitialise le booléen initiateur
					deja = false;                                       //on réinitialise le booléen deja
					//On parcourt la ligne correspondante au thème dans le tableau de doublons, et si le tirage est déjà tombé on le refait
					for(int i=0; i<FenetreGame.doublons[3].length; i++){                                     
						if (tirageConsigne == FenetreGame.doublons[3][i]){
							deja = true;
							tirageConsigne = (int)(Math.random()*tableauVirus.length);
						}
					}
				}
				enonceConsigne = tableauVirus[tirageConsigne];
				tirageActuel = tirageConsigne;
				break;             
		    
		    //Si problème et que aucune catégorie
			default:
			System.out.println("probleme de choix de la categorie");  			
		}
		
		return enonceConsigne;
    }
    
    public void updateConsigne(){
		this.type=theme();
		this.consigneAffichee=trouverConsigne();
	}
	
}
