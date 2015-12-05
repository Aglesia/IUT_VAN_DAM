/**
 * Cette classe met en oeuvre l'algorithme par essai/erreur récursif du déplacement d'un cavalier sur un échiquier. A partir d'une case de
 * départ, si un chemin pour parcourir toutes les cases une seule fois est trouvé alors l'échiquier est affiché avec le parcours complet du
 * cavalier.
 */
public class Cavalier{
	// Variables globales
	/**
	 * La taille de l'échiquier en constante
	 */
	int TAILLE_ECHEC = 10;
	/**
	 * L'échiquier qui permet de visualiser les déplacements du cavalier
	 */
	int[][] damier; // [ligne][colonne]
	/**
	 * Le nombre de coups joués qui permet de numéroter chaque déplacement et de savoir si le jeu est terminé
	 */
	int numCoup;
	/**
	 * Indique si nous travaillons avec un cavalier ou un roi
	 */
	boolean roi;

	/**
	 * Methode principale
	 */
	void principal(){
		System.out.println("Lancement du programme...");
		lanceur();
		// testAfficherDamier();
		// testDonnerSuivants();
		// testEstCeValide();
	}

	///////////////////////// METHODES PRINCIPALES ////////////////////////////////////

	/**
	 * Retourne le log10 de N
	 * @param  n Valeur d'entrée
	 * @return   Log10 de la valeur entrée
	 */
	int logDix(int n){
		int retour = 0;

		// On regarde combien de division nous pouvons faire
		while(n>9){
			n/=10;
			retour++;
		}

		retour++;

		// On retourne le nombre d'itération
		return retour;
	}

	/**
	 * Affiche le damier à l'écran. Le coin supérieur gauche correspond aux coordonnées (0, 0). L'affichage consistera simplement à
	 * imprimer à l'écran TAILLE_ECHEC lignes de TAILLE_ECHEC entiers, chaque entier étant le numéro du coup joué. Chaque
	 * déplacement du cavalier sur le damier incrémente de un le numéro du coup qui commence à la valeur 1 jusqu'à TAILLE_ECHEC X
	 * TAILLE_ECHEC (lorsque le cavalier a terminé son parcours).
	 */
	void afficherDamier(){
		// On indiqueq'une valeur a été trouvée
		System.out.println("Une solution a été trouvée :");

		// On affiche le damier sous forme de tableau
		int nbchiffresMax = logDix(TAILLE_ECHEC*TAILLE_ECHEC) + 4;
		for(int i=0; i<TAILLE_ECHEC; i++){
			// On affiche les limites des cases
			for(int j=0; j<TAILLE_ECHEC; j++){
				System.out.print("+");
				for(int k=0; k<nbchiffresMax; k++)
					System.out.print("-");
			}
			// On retourne à la ligne
			System.out.println("+");

			// On affiche les limites des cases
			for(int j=0; j<TAILLE_ECHEC; j++){
				System.out.print("|");
				for(int k=0; k<nbchiffresMax; k++)
					System.out.print(" ");
			}
			// On retourne à la ligne
			System.out.println("|");

			// On affiche la ligne avec les valeurs du tableau
			for(int j=0; j<TAILLE_ECHEC; j++){
				System.out.print("|  ");
				System.out.print(damier[i][j]);
				for(int k=0; k<(nbchiffresMax-logDix(damier[i][j]))-2; k++)
					System.out.print(" ");
			}
			// On retourne à la ligne
			System.out.println("|");

			// On affiche les limites des cases
			for(int j=0; j<TAILLE_ECHEC; j++){
				System.out.print("|");
				for(int k=0; k<nbchiffresMax; k++)
					System.out.print(" ");
			}
			// On retourne à la ligne
			System.out.println("|");
		}

		// On affiche les limites de la dernière ligne
		for(int j=0; j<TAILLE_ECHEC; j++){
			System.out.print("+");
			for(int k=0; k<nbchiffresMax; k++)
				System.out.print("-");
		}
		// On retourne à la ligne
		System.out.println("+");
	}

	/**
	 * A partir des cordonnées (posX, posY), cette méthode remplit le tableau "candidats" des 8 déplacements possibles du cavalier. Elle ne
	 * vérifie pas que les 8 déplacements sont valides. Cette vérification est réalisée par la méthode "estCeValide(...)". Les déplacements
	 * sont mémorisés dans un tableau à 2 entrées de taille 8 lignes X 2 colonnes. A chaque ligne correspond 1 position, sur le damier,
	 * possible (parmi 8) du cavalier après son déplacement. Une position est représentée par le couple de coordonnées (posX, posY).
	 * @param posX      la position du cavalier en X (horizontale)
	 * @param posY      la position du cavalier en Y (verticale)
	 * @param candidats tableau (8 lignes X 2 colonnes) qui mémorisent les 8 déplacements possibles du cavalier
	 */
	void donnerSuivants(int posX, int posY, int[][] candidats){
		// On remplie à la main les cases
		if(roi){
			candidats[0][0] = posX-1;
			candidats[1][0] = posX-1;
			candidats[2][0] = posX-1;
			candidats[3][0] = posX;
			candidats[4][0] = posX+1;
			candidats[5][0] = posX+1;
			candidats[6][0] = posX+1;
			candidats[7][0] = posX;
			candidats[0][1] = posY-1;
			candidats[1][1] = posY;
			candidats[2][1] = posY+1;
			candidats[3][1] = posY+1;
			candidats[4][1] = posY+1;
			candidats[5][1] = posY;
			candidats[6][1] = posY-1;
			candidats[7][1] = posY-1;
		}
		else{
			candidats[0][0] = posX-2;
			candidats[1][0] = posX-2;
			candidats[2][0] = posX-1;
			candidats[3][0] = posX+1;
			candidats[4][0] = posX+2;
			candidats[5][0] = posX+2;
			candidats[6][0] = posX+1;
			candidats[7][0] = posX-1;
			candidats[0][1] = posY-1;
			candidats[1][1] = posY+1;
			candidats[2][1] = posY+2;
			candidats[3][1] = posY+2;
			candidats[4][1] = posY+1;
			candidats[5][1] = posY-1;
			candidats[6][1] = posY-2;
			candidats[7][1] = posY-2;
		}
	}

	/**
	 * A partir des coordonnées (posX, posY) du cavalier, calculer les 8 déplacements suivants possibles par appel de la méthode «
	 * donnerSuivants(…) ». Ensuite, examiner les 8 déplacements possibles (newXi, newYi) un par un :
	 * Vérifier la validité de la coordonnée (newX, newY) à l’aide de la méthode « estCeValide(…) ».
	 * Si la coordonnée est valide, inscrire le numéro du coup joué dans la case de coordonnée (newX, newY) du tableau « damier » et
	 * incrémenter le nombre de coups.
	 * Si le nombre de coups == TAILLE_ECHEC X TAILLE_ECHEC alors la solution est trouvée et renvoyer vrai (fin de la récursivité).
	 * Sinon, à partir de cette nouvelle case valide (newX, newY), appeler à nouveau « essayer (…) » (appel récursif).
	 * Si ce nouvel appel de « essayer (…) » renvoie vrai, la solution finale est trouvée.
	 * Sinon, revenir "en arrière" en écrivant zéro dans la case aux coordonnées (newX, newY) du damier en décrémentant le nombre
	 * de coups puis examiner la case suivante parmi les 8 déplacements possibles.
	 * @param  posX la position du cavalier en X (horizontale)
	 * @param  posY la position du cavalier en Y (verticale)
	 * @return      vrai si le chemin des déplacements est trouvé
	 */
	boolean essayer(int posX, int posY){
		// On crée la valeur de retour
		boolean retour = false;

		// On incrémente le numéro de la case, et on indique qu'on est dessus
		numCoup++;
		damier[posX][posY] = numCoup;

		// Si c'est la dernière case, on retourne vrai
		if(numCoup == TAILLE_ECHEC*TAILLE_ECHEC)
			retour = true;
		else{
			// On récupère les 8 possibilités
			int[][] casesSuivantes = new int[8][2];
			donnerSuivants(posX, posY, casesSuivantes);

			// On test chaque case
			for(int i=0; i<8 && !retour; i++)
				if(estCeValide(casesSuivantes[i][0], casesSuivantes[i][1]))
					// Si c'est une case valide, on se rappelle, et on récupère le retour
					if(essayer(casesSuivantes[i][0], casesSuivantes[i][1]))
						// On met le retour à vrai
						retour = true;
		}

		// On retourne
		return retour;
	}

	/**
	 * Méthode qui renvoie vrai si la nouvelle coordonnée (ou nouveau déplacement) du cavalier est possible.
	 * Le déplacement est possible si :
	 * la nouvelle coordonnée ne sort pas du damier
	 * et la nouvelle case (newX, newY) n'a pas encore été visitée
	 * @param  newX la nouvelle coordonnée en X
	 * @param  newY la nouvelle coordonnée en Y
	 * @return      vrai si la nouvelle coordonnée (newX, newY) est valide
	 */
	boolean estCeValide(int newX, int newY){
		boolean retour = true;
		// Si ça sort du damier, on met à faux
		if(newX<0 || newX>=TAILLE_ECHEC || newY<0 || newY>=TAILLE_ECHEC)
			retour = false;

		// Si la case est déjà prise, on retourne faux
		else if(damier[newX][newY] != 0)
			retour = false;

		// On retourne le résultat
		return retour;
	}

	/**
	 * Lanceur de l'application : crée le damier à la bonne taille et positionne le cavalier sur une première case en X et en Y. Le compteur est
	 * initialisé à 1. On vérifiera que les coordonnées de la première case sont valides. La coordonnée (0, 0) correspond au coin supérieur
	 * gauche du damier. Ensuite, appeler une première fois "essayer(...)". Suite au résultat renvoyé par "essayer(...)", soit le damier est
	 * affiché car le chemin est trouvé, soit il n'y a pas de solution possible.
	 */
	void lanceur(){
		// On crée le damier
		damier = new int[TAILLE_ECHEC][TAILLE_ECHEC];
		numCoup = 0;

		// On demande quel pièce il faut jouer
		char car = SimpleInput.getChar("R pour jouer le roi, C pour le Cavalier :");
		while(car != 'C' && car != 'R' && car != 'c' && car != 'r')
			car = SimpleInput.getChar("R pour jouer le roi, C pour le Cavalier :");

		roi = (car == 'r' || car == 'R');

		// On appelle la méthode d'essaie
		if(essayer((int)(Math.random()*(TAILLE_ECHEC-1)), (int)(Math.random()*(TAILLE_ECHEC-1))))
			// S'il le faut, on affiche le damier
			afficherDamier();
		else
			System.out.println("Pas de solution");
	}

	///////////////////////////////////////////// METHODES DE TEST ////////////////////////////////////////////////////

	/**
	 * Test de la méthode afficherDamier()
	 */
	void testAfficherDamier(){
		// On test avec des 0
		System.out.println("### Test de afficherDamier() ###\nOn test avec un tableau rempli de 0");
		afficherDamier();

		// On test avec un tableau trié, de 0 à TAILLE_ECHEC²
		for(int i=0; i<TAILLE_ECHEC; i++)
			for(int j=0; j<TAILLE_ECHEC; j++)
				damier[i][j] = (i*TAILLE_ECHEC)+j+1;
		System.out.println("\nOn test avec un tableau rempli de valeur de 1 à TAILLE_ECHEC, rangé");
		afficherDamier();
		System.out.println("Fin du test de afficherDamier()\n\n");
	}

	/**
	 * Test de la méthode donnerSuivants()
	 */
	void testDonnerSuivants(){
		// On crée un tableau pour la méthode
		int[][] tab = new int[8][2];
		// On initialise le plateau à 0
		for(int i=0; i<TAILLE_ECHEC; i++)
			for(int j=0; j<TAILLE_ECHEC; j++)
				damier[i][j] = 0;

		// On appèle la methode, pour remplir le plateau à partir du centre
		System.out.println("### Test de donnerSuivants() ###\nTest classique");
		donnerSuivants((int)(TAILLE_ECHEC)/2, (int)(TAILLE_ECHEC)/2, tab);
		damier[(int)(TAILLE_ECHEC)/2][(int)(TAILLE_ECHEC)/2] = 10;
		// On représentes les cases possible, sur le plateau
		for(int i=0; i<8; i++)
			damier[tab[i][0]][tab[i][1]] = 90;

		// On affiche le plateau
		afficherDamier();

		System.out.println("Fin de test de donnerSuivants()\n\n");
	}

	/**
	 * Test de la méthode essayer()
	 */
	void testEssayer(){
		// 
	}

	/**
	 * Test de la méthode estCeValide()
	 */
	void testEstCeValide(){
		// On crée un tableau pour la méthode
		int[][] tab = new int[8][2];

		// On test sur un damier vide
		for(int i=0; i<TAILLE_ECHEC; i++)
			for(int j=0; j<TAILLE_ECHEC; j++)
				damier[i][j] = 0;
		System.out.println("### Test de estCeValide() ###\nTest avec un damier vide, sans sortie de limite");
		donnerSuivants((int)(TAILLE_ECHEC)/2, (int)(TAILLE_ECHEC)/2, tab);
		for(int i=0; i<8; i++)
			if(estCeValide(tab[i][0], tab[i][1]))
				System.out.println("Pour les coordonnées ("+tab[i][0]+", "+tab[i][1]+"), la case est bonne.");
			else
				System.out.println("Pour les coordonnées ("+tab[i][0]+", "+tab[i][1]+"), la case n'est pas bonne.");

		// On test sur un damier plein
		for(int i=0; i<TAILLE_ECHEC; i++)
			for(int j=0; j<TAILLE_ECHEC; j++)
				damier[i][j] = 1;
		System.out.println("\nTest avec un damier plein, sans sortie de limite");
		donnerSuivants((int)(TAILLE_ECHEC)/2, (int)(TAILLE_ECHEC)/2, tab);
		for(int i=0; i<8; i++)
			if(estCeValide(tab[i][0], tab[i][1]))
				System.out.println("Pour les coordonnées ("+tab[i][0]+", "+tab[i][1]+"), la case est bonne.");
			else
				System.out.println("Pour les coordonnées ("+tab[i][0]+", "+tab[i][1]+"), la case n'est pas bonne.");

		// On test en dehors des limites du damier
		for(int i=0; i<TAILLE_ECHEC; i++)
			for(int j=0; j<TAILLE_ECHEC; j++)
				damier[i][j] = 0;
		System.out.println("\nTest avec un damier vide, avec sortie de limite");
		donnerSuivants(1, 0, tab);
		for(int i=0; i<8; i++)
			if(estCeValide(tab[i][0], tab[i][1]))
				System.out.println("Pour les coordonnées ("+tab[i][0]+", "+tab[i][1]+"), la case est bonne.");
			else
				System.out.println("Pour les coordonnées ("+tab[i][0]+", "+tab[i][1]+"), la case n'est pas bonne.");

		System.out.println("Fin de test de estCeValide()\n\n");
	}
}