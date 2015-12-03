/**
 * Cette classe effectue des opérations plus complexes sur un tableaux d'entiers : recherche dichotomique, tris, etc. 
 * La taille d'un tableau est
 * par définition le nombre TOTAL de cases = tab.length. 
 * Un tableau d'entiers créé possède nbElem élements qui ne correspond pas
 * forcément à la taille du tableau. 
 * Il faut donc toujours considéré que nbElem <= tab.length (= taille)
 */
public class TrisTableau{
	// Variable globale, compteur du nombre d'opérations
	long cpt;

	/**
	 * Le point d'entrée du programme.
	 */
	void principal(){
		testTriSimpleEtVeriftri();
	}

	/**
	 * Remplace dans le tableau passé en paramètre une case tirée au hasard entre 0 et (nbElem-1) par
	 * une nouvelle valeur "newInt". On suppose que le tableau passé en paramètre est créé et possède
	 * au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 * @param leTab  [description]
	 * @param nbElem [description]
	 * @param newInt [description]
	 */
	void remplacerAuHasard(int[] leTab, int nbElem, int newInt){
		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else{
			// On crée la valeur aléatoire
			int caseTableau = (int)(Math.random() * (nbElem-1));

			// On remplace la case
			leTab[caseTableau] = newInt;
		}
	}

	/**
	 * Recherche séquentielle d'une valeur dans un tableau. La valeur à rechercher peut exister en plusieurs exemplaires mais la recherche
	 * s'arrête dès qu'une première valeur est trouvée. On suppose que le tableau passé en paramètre est créé et possède au moins une
	 * valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 * @param  leTab  [description]
	 * @param  nbElem [description]
	 * @param  aRech  [description]
	 * @return        [description]
	 */
	int rechercheSeq(int[] leTab, int nbElem, int aRech){
		int retour = -1;
		int i=0;
		cpt = 0;

		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else
			// On teste toutes les cases
			for(i=0; i<nbElem && retour==-1; i++){
				// On incrémente le nombre d'itération
				cpt++;

				// Si la valeur est présente dans la case actuelle
				if(leTab[i] == aRech)
					// On enregistre la valeur de la case
					retour = i;
			}

		// On retourne la valeur (-1 si non trouvé)
		return retour;
	}

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri rapide (QuickSort). On suppose que le tableau passé en paramètre est
	 * créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié. Cette méthode appelle triRapideRec(...) qui elle
	 * effectue réellement le tri rapide selon la méthode de séparation récursive.
	 * @param leTab  [description]
	 * @param nbElem [description]
	 */
	void triRapide(int[] leTab, int nbElem){

	}

	/**
	 * Méthode de tri récursive selon le principe de séparation. La méthode s'appelle elle-même sur les tableaux gauche et droite par
	 * rapport à un pivot
	 * @param tab    [description]
	 * @param indL   [description]
	 * @param nbElem [description]
	 */
	void triRapideRec(int[] tab, int indL, int indR){

	}

	/**
	 * Cette méthode renvoie l’indice de séparation du tableau en 2 parties par placement du pivot à la bonne case.
	 * @param  tab  [description]
	 * @param  indL [description]
	 * @param  indR [description]
	 * @return      [description]
	 */
	int separer(int[] tab, int indL, int indR){

	}

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri à bulles : tant que le tableau n'est pas trié, permuter le contenu de 2
	 * cases successives si leTab[i] > leTab[i+1]. On suppose que le tableau passé en paramètre est créé et possède au moins une valeur
	 * (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 * @param leTab  [description]
	 * @param nbElem [description]
	 */
	void triABulles(int[] leTab, int nbElem){
		cpt = 0;

		// Tant que le tableau n'est pas trié
		while(!verifTri(leTab, nbElem))
			// On parcour le tableau
			for(int i=0; i<nbElem-1; i++){
				// On regarde si les cases doivent être permutées
				if(leTab[i]>leTab[i+1])
					echange(leTab, i, i+1);
				// On incrémente le nombre d'itération
				cpt++;
			}
	}

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode simple : l'élément minimum est placé en
	 * début de tableau (efficacité en n carré).On suppose que le tableau passé en paramètre est créé
	 * et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pasêtre vérifié.
	 * @param leTab  [description]
	 * @param nbElem [description]
	 */
	void triSimple(int[] leTab, int nbElem){
		int i=0,p,k,min;
		cpt = 0;
		if(leTab==null)
			System.out.println("le tableau n'est pas initialisé");
		else if(nbElem > leTab.length)
			System.out.println("le tableau est hors limites");
		else
			// On parcourt tout le tableau, case par case
			// On regarde qui est le plus petit par rapport aux dernières cases (entre i et nbElem)
			// On inverse la case minimum avec la case i
			// A partir de là, toutes les cases entre 0 et i sont triées.
			// On incrémente i, et on recommence
			for(i=0, i<(nbElem-1), i++){
				// On défini le minimum de base
				min=leTab[i];
				k=i;
				// Pour chaque case, on regarde qui est le minimum
				for(p=i; p<nbElem; p++){
					// On incrémente le nombre d'itération
					cpt++;

					// On regarde si la case est la plus petite
					if(leTab[p]<min){
						min=leTab[p];
						k=p;
					}
				}
				// On inverse le minimum actuel (k) avec la case actuelle (i) (compris ? xD)
				leTab[k] += leTab[i];
				leTab[i] = leTab[k]-leTab[i];
				leTab[k] = leTab[k]-leTab[i];
			}
	}

	/**
	 * Vérifie que le tableau passé en paramètre est trié par ordre croissant des valeurs. On suppose que
	 * le tableau passé en paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc
	 * pas être vérifié.
	 * @param  leTab  [description]
	 * @param  nbElem [description]
	 * @return        [description]
	 */
	boolean verifTri(int[] leTab, int nbElem){
		boolean trie = true;
		cpt=0;

		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else

			// On parcour le tableau
			for(int i=0; i<nbElem && trie; i++)
				// On recherche une case plus petite, à la suite du tableau
				for(int j=i; j<nbElem && trie; j++){
					// On incrémente le nombre d'itération
					cpt++;

					// On regarde s'il est toujours trié
					if(leTab[i]>leTab[j])
						trie = false;
				}

		// On retourne le résultat
		return trie;
	}

	/**
	 * Recherche dichotomique d'une valeur dans un tableau. On suppose que le tableau est trié par ordre croissant. La valeur à
	 * rechercher peut exister en plusieurs exemplaires, dans ce cas, c'est la valeur à l'indice le + faible qui sera trouvé. On suppose
	 * également que le tableau passé en paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être
	 * vérifié.
	 * @param  leTab  [description]
	 * @param  nbElem [description]
	 * @param  aRech  [description]
	 * @return        [description]
	 */
	int rechercheDicho(int[] leTab, int nbElem, int aRech){
		// On crée les variables
		int noCaseAbs = 0;
		int noCaseRel = nbElem;
		int retour = -1;
		cpt = 0;

		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else{
			// On lance la recherche
			while(leTab[noCaseAbs+noCaseRel]!=aRech && noCaseRel<1){
				noCaseRel = (int)(noCaseRel/2);

				// On sélectionne la case minimum
				if(leTab[noCaseAbs+noCaseRel]<aRech)
					noCaseAbs += noCaseRel;

				// On compte le nombre d'itération
				cpt++;
			}
		}

		// On regarde si la valeur a été trouvée
		if(leTab[noCaseAbs+noCaseRel]==aRech)
			retour = noCaseAbs+noCaseRel;

		// On retourne la valeur (-1 si non trouvé)
		return retour;
	}

	/**
	 * Echange les contenus des cases du tableau passé en paramètre, cases identifiées par les indices ind1 et ind2.
	 * @param leTab [description]
	 * @param ind1  [description]
	 * @param ind2  [description]
	 */
	void echange(int[] leTab, int ind1, int ind2){
		// On fait l'échange
		leTab[ind1] += leTab[ind2];
		leTab[ind2] = leTab[ind1] - leTab[ind2];
		leTab[ind1] = leTab[ind1] - leTab[ind2];
	}

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri par comptage de fréquences. On suppose que le tableau passé en
	 * paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 * @param  leTab  [description]
	 * @param  nbElem [description]
	 * @return        [description]
	 */
	int[] triParComptageFreq(int[] leTab, int nbElem){

	}

	/**
	 * A partir d'un tableau initial passé en paramètre "leTab", cette méthode renvoie un nouveau tableau "tabFreq" d'entiers où chaque
	 * case contient la fréquence d'apparition des valeurs dans le tableau initial. Pour simplifier, on suppose que le tableau initial ne contient
	 * que des entiers compris entre 0 et max (>0). Dès lors le tableau "tabFreq" se compose de (max+1) cases et chaque case "i"
	 * (0<=i<=max) contient le nombre de fois que l'entier "i" apparait dans le tableau initial. On suppose que le tableau passé en
	 * paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié. Par contre, on vérifiera que le
	 * max du tableau initial est > 0 et que le min est >= 0. Dans le cas contraire, renvoyer un tableau "null".
	 * @param  leTab  [description]
	 * @param  nbElem [description]
	 * @return        [description]
	 */
	int[] creerTabFreq(int[] leTab, int nbElem){
		// On crée le tableau
		int[] retour = null;
		boolean valeursOK = true;
		int max = 0;
		cpt = 0;

		// On vérifie que les valeurs sont >=0
		for(int i=0; i<nbElem && valeursOK; i++){
			if(leTab[i]<0)
				valeurOK = 0;
			// On vérifie le max
			if(leTab[i]>max)
				max = leTab[i];
		}

		// On vérifie que tout est bon
		if(max==0 || !valeurOK)
			System.out.println("Les valeurs ne sont pas assez grandes");
		else{
			// On initialise le tableau
			retour = new int[max];
			// Pour chaque case, on regarde la fréquence
			for(int i=0; i<max; i++)
				for(int j=0; j<nbElem; j++){
					// On incrémente le nombre d'itération
					cpt++;
					// On compte le nombre d'apparition d'une valeur
					if(leTab[j] = i)
						retour[i]++;
				}
		}
		// On retourne l'adresse du tableau
		return retour;
	}

	/**
	 * Affiche le contenu d'un sous-tableau entre 2 indices (indL, indR) donnés.
	 * @param leTab [description]
	 * @param indL  [description]
	 * @param indR  [description]
	 */
	void afficherSousTab(int[] leTab, int indL, int indR){
		// On vérifie les paramètres
		if(leTab==null)
			System.out.println("Le tableau n'est pas initialise");
		else if(indL<0 || indL>leTab.length || indR<0 || indR>leTab.length || indL>=indR)
			System.out.println("Indices en dehors des limites");
		else
			// On crée le sous-tableau
			int[] sousTab = new int[indR-indL];

			// On fait la copie, et on affiche son contenue
			for(int i=indL; i<indR; i++)
				sousTab[i-indL] = leTab[i];
			afficherTab(leTab, leTab.length);
	}


///////////////////////////////////// METHODES DE TEST /////////////////////////////////////////

	/**
	 * Test des méthodes triSimple et verifTri
	 */
	void testTriSimpleEtVeriftri(){
		// On crée les variables necessaires
		int[] leTab = new int[3];
		leTab[0] = 3;
		leTab[1] = 1;
		leTab[2] = 9;

		// On test avec un tableau normal
		System.out.println("Debut du test de triSimple() et de verifTri()...");
		System.out.println("Test avec un tableau normal :");
		triSimple(leTab, 3);
		if(verifTri(leTab, 3))
			System.out.println("Le tableau est bien trie");
		else
			System.out.println("Une erreur s'est produite lors du trie...");

		// On vérifie un trie avec un tableau non trié
		System.out.println("\nOn teste la procédure verifTri(), avec un tableau non trié");
		leTab[0] = 3;
		leTab[1] = 1;
		leTab[2] = 9;

		if(!verifTri(leTab, 3))
			System.out.println("La procédure fonctionne");
		else
			System.out.println("Une erreur s'est produite lors de la vérification du trie...");

		// On termine ce test
		System.out.println("Fin des tests de tri\n\n");
	}

	/**
	 * [testRechercheDicho description]
	 */
	void testRechercheDicho(){

	}

	/**
	 * [testRechercheSeq description]
	 */
	void testRechercheSeq(){

	}

	/**
	 * Test de la méthode triRapide
	 */
	void testTriRapide(){

	}

	/**
	 * Test de la méthode de séparation
	 */
	void testSeparer(){

	}

	/**
	 * Test de la méthode rechercheSeq
	 */
	void testRechercheDicho(){

	}

	/**
	 * Test de la méthode rechercheSeq
	 */
	void testRechercheSeq(){

	}

	/**
	 * Test de la méthode creerTabFreq
	 */
	void testCreerTabFreq(){

	}

	/**
	 * Test de la méthode triParComptageFreq
	 */
	void testTriParComptageFreq(){

	}

	/**
	 * Test de la méthode triABulles
	 */
	void testTriABulles(){

	}

	//////////////////////////////// TEST DES EFFICACITES //////////////////////////////////////////

	/**
	 * [testRechercheSeqEfficacite description]
	 */
	void testRechercheSeqEfficacite(){
		// On lance le test
		System.out.println("On teste la procédure de rechercheSeq()");
		
		// On crée le tableau trié
		int[] grandTableau = new int[1000000];
		for(int i=0; i<1000000; i++)
			grandTableau[i] = i;

		// On test avec la première méthode :
		long tempsDebut = System.currentTimeMillis();
		System.out.println("Test avec la recherche séquentielle : ");
		rechercheSeq(grandTableau, 1000000, 555555);
		System.out.println("Execute en "+(System.currentTimeMillis()-tempsDebut)+".\n\n");
	}

	/**
	 * Test de l'efficacité de la méthode rechercheDicho
	 */
	void testRechercheDichoEfficacite(){
		// On lance le test
		System.out.println("On teste la procédure de rechercheDicho()");
		
		// On crée le tableau trié
		int[] grandTableau = new int[1000000];
		for(int i=0; i<1000000; i++)
			grandTableau[i] = i;

		// On test avec la seconde methode
		long tempsDebut = System.currentTimeMillis();
		System.out.println("\nTest avec la recherche dichotomique");
		rechercheDicho(grandTableau, 1000000, 999999);
		// On affiche le nombre d'itération
		System.out.println("nb Iterations : "+iteration);
		System.out.println("Execute en "+(System.currentTimeMillis()-tempsDebut)+".\n\n");
	}

	/**
	 * Test de l'efficacité de la méthode triParComptageFreq
	 */
	void testTriParComptageFreqEfficacite(){

	}

	/**
	 * Test de l'efficacité de la méthode triABulles
	 */
	void testTriABullesEfficacite(){

	}

	/**
	 * Test de l'efficacité de la méthode triSimple
	 */
	void testTriSimpleEfficacite(){

	}

	/**
	 * Test de l'efficacité de la méthode triRapide
	 */
	void testTriRapideEfficacite(){

	}

	/**
	 * Test de l'efficacité de la méthode rechercheSeq
	 */
	void testRechercheSeqEfficacite(){

	}

/////////////////////////////////// METHODES DEJA CREEES ///////////////////////////////////////

	/**
	 * Echange les contenus des cases du tableau passe en parametre, cases identifiees par les indices ind1 et ind2.  Verifier que les indices
	 * ind1 et ind2 sont bien compris entre zero et (nbElem-1), sinon afficher un message d'erreur.
	 * @param leTab  le tableau
	 * @param nbElem le nombre d'entiers presents dans le tableau
	 * @param ind1   numero de la premiere case a echanger
	 * @param ind2   numero de la deuxieme case a echanger
	 */
	void echange(int[] leTab, int nbElem, int ind1, int ind2){
		// On verifie les parametres
		if(leTab==null)
			System.out.println("Tableau non initialise");
		else if(nbElem<1 || nbElem>leTab.length)
			System.out.println("nbElem hors des limites");
		else if(ind1<0 || ind1>=nbElem)
			System.out.println("ind1 hors des limmites");
		else if(ind2<0 || ind2>=nbElem)
			System.out.println("ind1 hors des limmites");
		else{
			// On inverse les valeurs
			leTab[ind1] += leTab[ind2];
			leTab[ind2] = leTab[ind1] - leTab[ind2];
			leTab[ind1] = leTab[ind1] - leTab[ind2];
		}
	}

	/**
	 * Affiche le contenu des nbElem cases d'un tableau une par une. Tenir compte du cas particulier ou le tableau n'est pas cree.
	 * @param leTab  le tableau a afficher
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void afficherTab(int[] leTab, int nbElem){
		// On verifie les parametres
		if(leTab==null)
			System.out.println("Tableau non initialise...");
		else if(nbElem<1 || nbElem>leTab.length)
			System.out.println("Nombre d'element en dehors des limites");
		else // Tout est OK, on commence a travailler sur le tableau
			for (int i=0; i<nbElem; i++)
				System.out.println("L'element n°" + i + " du tableau vaut : " + leTab[i]);
	}
}

// Compil  : javac -d ../class ../src/TrisTableau.java
// execut  : java Start SimplesTableau
// Javadoc : javadoc -private -d ../JavaDoc ../src/TrisTableau.java
