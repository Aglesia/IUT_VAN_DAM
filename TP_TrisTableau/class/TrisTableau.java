/**
 * Cette classe effectue des opérations plus complexes sur un tableaux d'entiers : recherche dichotomique, tris, etc. 
 * La taille d'un tableau est
 * par définition le nombre TOTAL de cases = tab.length. 
 * Un tableau d'entiers créé possède nbElem élements qui ne correspond pas
 * forcément à la taille du tableau. 
 * Il faut donc toujours considéré que nbElem <= tab.length (= taille)
 */
public class TrisTableau{
	/**
	 * Le point d'entrée du programme.
	 */
	void principal(){
		//testTriSimpleEtVeriftri();
		testRechercheDichoEfficacite();
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

		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else
			// On teste toutes les cases
			for(i=0; i<nbElem && retour==-1; i++)
				// Si la valeur est présente dans la case actuelle
				if(leTab[i] == aRech)
					// On enregistre la valeur de la case
					retour = i;

		// On affiche le nombre d'itérations
		System.out.println("Nb Itération : "+i);

		// On retourne la valeur (-1 si non trouvé)
		return retour;
	}

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode simple : l'élément minimum est placé en
	 * début de tableau (efficacité en n carré).On suppose que le tableau passé en paramètre est créé
	 * et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pasêtre vérifié.
	 * @param leTab  [description]
	 * @param nbElem [description]
	 */
	void triSimple(int[] leTab, int nbElem){
		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else
			// On parcour le tableau
			for(int i=0; i<nbElem; i++)
				for(int j=0; j<nbElem-1; j++)
					// On échange les cases si besoin
					if(leTab[j]>leTab[j+1])
						echange(leTab, nbElem, j, j+1);
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

		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else

			// On parcour le tableau
			for(int i=0; i<nbElem && trie; i++)
				// On recherche une case plus petite, à la suite du tableau
				for(int j=i; j<nbElem && trie; j++)
					if(leTab[i]>leTab[j])
						trie = false;

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
		int noCaseRel = nbElem-1;
		int retour = -1;
		int iteration = 0;

		// On vérifie les paramètres
		if(nbElem>leTab.length)
			System.out.println("nbElem sort des limites");
		else{
			// On lance la recherche
			while(leTab[noCaseAbs+noCaseRel]!=aRech && noCaseRel>1){
				noCaseRel = (int)(noCaseRel/2);

				// On sélectionne la case minimum
				if(leTab[noCaseAbs+noCaseRel]<aRech)
					noCaseAbs += noCaseRel;

				// On compte le nombre d'itération
				iteration++;

				// DEBUG
				System.out.println("Iteration : "+iteration+" | Abs="+noCaseAbs+" | Rel="+noCaseRel+" | valeur="+leTab[noCaseAbs+noCaseRel]);
			}
		}

		// On regarde si la valeur a été trouvée
		if(leTab[noCaseAbs+noCaseRel]==aRech)
			retour = noCaseAbs+noCaseRel;

		// On affiche le nombre d'itération
		System.out.println("nb Iterations : "+iteration);

		// On retourne la valeur (-1 si non trouvé)
		return retour;
	}

///////////////////////////////////// METHODES DE TEST /////////////////////////////////////////

	/**
	 * [testTriSimpleEtVeriftri description]
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
	 * [testRechercheDichoEfficacite description]
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
		System.out.println("\nTest avec la seconde methode : ");
		rechercheDicho(grandTableau, 1000000, 999995);
		System.out.println("Execute en "+(System.currentTimeMillis()-tempsDebut)+".\n\n");
	}

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
		rechercheSeq(grandTableau, 1000000, 999999);
		System.out.println("Execute en "+(System.currentTimeMillis()-tempsDebut)+".\n\n");
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