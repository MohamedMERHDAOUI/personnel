package testsunitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testEmploye
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();

	@Test
	void createEmploye() throws SauvegardeImpossible
	{
		Employe employe = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", employe.getNom);
		
	}
	
	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Employe employe = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		assertTrue(employe.estRoot());
		assertEquals(employe, employe.getEmployes().first());
	}
	
	