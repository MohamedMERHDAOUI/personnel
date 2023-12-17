// package testsUnitaires;

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;
// import personnel.*;

// class TestLigue {
//     Passerelle jdbc = new JDBC(); // Création d'une instance de la classe JDBC

//     @Test
//     void testInsertionLigue() throws SauvegardeImpossible {
//         Ligue ligue = new Ligue();
//         ligue.setNom("TestLigue"); // Création d'une ligue pour l'insertion

//         int insertedId = jdbc.insert(ligue); // Appel de la méthode insert

//         assertTrue(insertedId > 0); // Vérifie si l'insertion a réussi

//         // Ici, tu peux éventuellement récupérer la ligue depuis la base de données
//         // et vérifier si les données insérées correspondent à celles que tu attends
//     }
// }

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import personnel.Ligue;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;



class TestLigue {

    @Test
    void testInsertionLigue() throws SauvegardeImpossible {
        Passerelle jdbcMock = Mockito.mock(Passerelle.class);
        
        // Définition du comportement du mock pour l'insertion
        Mockito.when(jdbcMock.insert(Mockito.any(Ligue.class))).thenReturn(1); // Simule une insertion réussie
        
        Ligue ligue = new Ligue();
        ligue.setNom("TestLigue"); // Création d'une ligue pour l'insertion

        int insertedId = jdbcMock.insert(ligue); // Appel de la méthode insert du mock

        assertTrue(insertedId > 0); // Vérifie si l'insertion a réussi
    }
}

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;

// import personnel.*;

// class testLigue 
// {
// 	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
// 	@Test
// 	void createLigue() throws SauvegardeImpossible
// 	{
// 		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
// 		assertEquals("Fléchettes", ligue.getNom());
// 	}

	// @Test
	// void addEmploye() throws SauvegardeImpossible
	// {
	// 	Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
	// 	Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
	// 	assertEquals(employe, ligue.getEmployes().first());
	// }
// }


// package testsUnitaires;

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;

// import personnel.*;

// class testtLigue 
// {
//     @Test
//     void testCreateLigue() throws SauvegardeImpossible {
//         GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
//         Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
//         assertNotNull(ligue);
//         assertEquals("Fléchettes", ligue.getNom());
//         // Vérifie si la ligue a été ajoutée à la base de données
//         // ...
//     }

    // @Test
    // void testUpdateLigue() throws SauvegardeImpossible {
    //     GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
    //     Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
    //     ligue.setNom("NouveauNom");
    //     assertEquals("NouveauNom", ligue.getNom());
    //     // Met à jour le nom de la ligue dans la base de données et vérifie si la modification est correcte
    //     // ...
    // }

    // @Test
    // void testDeleteLigue() throws SauvegardeImpossible {
    //     GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
    //     Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
    //     // Supprime la ligue de la base de données
    //     // Vérifie que la ligue n'existe plus dans la base de données
    //     // ...
    // }

    // D'autres tests spécifiques à la classe Ligue
// }
