package personnel;

public interface Passerelle 
{
	public interface Passerelle {
    GestionPersonnel getGestionPersonnel() throws SauvegardeImpossible;
    void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible;
    int insert(Ligue ligue) throws SauvegardeImpossible;
    int select(Ligue ligue) throws SauvegardeImpossible;
    int update(Ligue ligue) throws SauvegardeImpossible;
    int delete(Ligue ligue) throws SauvegardeImpossible;
    int insert(Employe employe) throws SauvegardeImpossible;
    int select(Employe employe) throws SauvegardeImpossible;
    int update(Employe employe) throws SauvegardeImpossible;
    int delete(Employe employe) throws SauvegardeImpossible;
}
}
