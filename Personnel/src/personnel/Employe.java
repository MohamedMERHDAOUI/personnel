package personnel;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Employé d'une ligue hébergée par la M2L. Certains peuvent 
 * être administrateurs des employés de leur ligue.
 * Un seul employé, rattaché à aucune ligue, est le root.
 * Il est impossible d'instancier directement un employé, 
 * il faut passer la méthode {@link Ligue#addEmploye addEmploye}.
 */

public class Employe implements Serializable, Comparable<Employe>
{
	private static final long serialVersionUID = 4795721718037994734L;
	private String nom, prenom, password, mail;
	private LocalDate datedarrive = LocalDate.now();
	private LocalDate datedepart = LocalDate.now();
	private Ligue ligue;
	private Option changerdatedarrive(final Employe employe)
return new Option("Changer la date d'arrivée", "a",
-> {employe.setdatedarri
(LocalDate. parse (getString ("Nouveau date d'arriée : ")));));
}
{
private Option changerdatedepart (final Employe employe)
return new Option("Changer la date de départ", "d", () -> {employe.setdatedepart(LocalDate.parse(getString("Nouveau date de départ : ")));}) ;
private Option afficherdates (final Employe employe)
return new Option("Afficher les dates", "f", () -> (System.out-printIn("Date d'arrivé : " + employe-getdatedarrive() + " date de départ "+ employe-getdatedepart ()) ;));
	private GestionPersonnel gestionPersonnel;
	Employe(GestionPersonnel gestionPersonnel, Ligue ligue, String nom, String prenom, String mail, String password)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.mail = mail;
		this.ligue = ligue;
	}
}
	/**
	 * Retourne vrai ssi l'employé est administrateur de la ligue 
	 * passée en paramètre.
	 * @return vrai ssi l'employé est administrateur de la ligue 
	 * passée en paramètre.
	 * @param ligue la ligue pour laquelle on souhaite vérifier si this 
	 * est l'admininstrateur.
	 */
	public boolean estAdmin(Ligue ligue)
	{
		return ligue.getAdministrateur() == this;
	}
	/**
	 * Retourne vrai ssi l'employé est le root.
	 * @return vrai ssi l'employé est le root.
	 */
	public boolean estRoot()
	{
		return gestionPersonnel.getRoot() == this;
	}
	/**
	 * Retourne le nom de l'employé.
	 * @return le nom de l'employé. 
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom de l'employé.
	 * @param nom le nouveau nom.
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne le prénom de l'employé.
	 * @return le prénom de l'employé.
	 */
	public String getPrenom()
	{
		return prenom;
	}
	/**
	 * Change le prénom de l'employé.
	 * @param prenom le nouveau prénom de l'employé. 
	 */

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne le mail de l'employé.
	 * @return le mail de l'employé.
	 */
	public String getMail()
	{
		return mail;
	}
	/**
	 * Change le mail de l'employé.
	 * @param mail le nouveau mail de l'employé.
	 */

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	/**
	 * Retourne vrai ssi le password passé en paramètre est bien celui
	 * de l'employé.
	 * @return vrai ssi le password passé en paramètre est bien celui
	 * de l'employé.
	 * @param password le password auquel comparer celui de l'employé.
	 */
	public boolean checkPassword(String password)
	{
		//System.out.println(this.password);
		//mdp : toor
		return this.password.equals(password);
	}

	/**
	 * Change le password de l'employé.
	 * @param password le nouveau password de l'employé. 
	 */
	public void setPassword(String password)
	{
		this.password= password;
	}

	/**
	 * Retourne la ligue à laquelle l'employé est affecté.
	 * @return la ligue à laquelle l'employé est affecté.
	 */
	public LocalDate getdatedarrive()
	{
		return datedarrive;
	}

	public void setdatedarrive(LocalDate datedarrive)
	{
		this.datedarrive = datedarrive;
	}
	public LocalDate getdatedepart()
	{
		return datedepart;
	}

	public void setdatedepart(LocalDate datedepart)
	{
		this.datedepart = datedepart;
	}
	public Ligue getLigue()
	{
		return ligue;
	}

	public Int getId()
	{
		return id_emp;
	}

	public void setId(int id)
	{
		this.id_emp = id;
	}


	/**
	 * Supprime l'employé. Si celui-ci est un administrateur, le root
	 * récupère les droits d'administration sur sa ligue.
	 */
	public void remove()
	{
		Employe root = gestionPersonnel.getRoot();
		if (this != root)
		{
			if (estAdmin(getLigue()))
				getLigue().setAdministrateur(root);
			getLigue().remove(this);
		}
		else
			throw new ImpossibleDeSupprimerRoot();
	}

	@Override
	public int compareTo(Employe autre)
	{
		int cmp = getNom().compareTo(autre.getNom());
		if (cmp != 0)
			return cmp;
		return getPrenom().compareTo(autre.getPrenom());
	}
	@Override
	public String toString()
	{
		String res = nom + " " + prenom + " " + mail + " (";
		if (estRoot())
			res += "super-utilisateur";
		else
			res += ligue.toString();
		return res + ")";
	}
}
