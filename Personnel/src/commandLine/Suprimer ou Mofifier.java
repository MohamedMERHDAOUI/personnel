package iteration2;

import java.util.Scanner;


public class selection {

public static void main(String[] args) {


String[] employes = {"Employé 1", "Employé 2", "Employé 3"};

Scanner scanner = new Scanner(System.in);


while (true) {

System.out.println("Sélectionnez un employé (ou tapez 'q' pour quitter) :");


for (int i = 0; i < employes.length; i++) {

System.out.println((i + 1) + ". " + employes[i]);

}


String choix = scanner.nextLine();

if (choix.equals("q")) {

System.out.println("Au revoir !");

break;

}

try {

int selection = Integer.parseInt(choix);

if (selection >= 1 && selection <= employes.length) {

String employeSelectionne = employes[selection - 1];

System.out.println("Vous avez sélectionné : " + employeSelectionne);

System.out.println("Que voulez-vous faire avec cet employé ?");

System.out.println("1 pour Modifier");

System.out.println("2 pour Supprimer");

String choixAction = scanner.nextLine();

if (choixAction.equals("1")) {

System.out.println("Vous avez choisi de modifier l'employé " + employeSelectionne);

} else if (choixAction.equals("2")) {

System.out.println("Vous avez choisi de supprimer l'employé " + employeSelectionne);

} else {

System.out.println("Invalide");

}

} else {

System.out.println("Choisissez un nombre entre 1 et " + employes.length);

}

} catch (NumberFormatException e) {

System.out.println("Veuillez choisir un nombre valide.");

}

}



scanner.close();

}

}