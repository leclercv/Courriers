package entity;

import java.util.ArrayList;
import java.util.Random;

import letters.Letter;
import letters.PromisoryNote;
import letters.RegisteredLetter;
import letters.SimpleLetter;
import letters.UrgentLetter;
import content.MoneyContent;
import content.TextContent;

/**
 * Class représentant un habitant.
 * @author Place Leclercq
 *
 */
public class Inhabitant {
	private String name;
	private Account account;
	private City city;
	private static Random random;
	private ArrayList<Letter<?>> receiveLetters;
	
	/**
	 * Constructeur de base d'un habitant
	 * @param city La ville où vit cet habitant.
	 * @param name Le nom de cet habitant.
	 */
	public Inhabitant(City city, String name) {
		this.name = name;
		this.city = city;
		this.account = new Account(5000);
		random = new Random();
		recieveLetters = new ArrayList<>();
	}
	
	/**
	 * Génère une lettre aléatoire.
	 * @param receiver L'habitant auquel la lettre est destinée.
	 * @return Renvoie la lettre générée.
	 */
	public Letter<?> makeLetter(Inhabitant receiver){
		Letter<?> simpleContentLetter = null;
		Letter<?> complexeLetter = null;
		Letter<?> finalLetter = null;
		
		// Sélectionne aléatoirement le type de lettre générée.
		switch(random.nextInt(2)){
		// Lettre simple
		case 0 :
			simpleContentLetter = new SimpleLetter(this, receiver, new TextContent("bla bla"));
			account.withdraw(1);
			break;
			
		// Lettre de promesse
		case 1 :
			int amount = 50;
			if(this.getBalance() > 0) amount = random.nextInt(this.getBalance());
			simpleContentLetter = new PromisoryNote(this, receiver, new MoneyContent(amount));
			break;
		}
		
		// Sélectionne aléatoirement le type d'envoi de la lettre générée.
		switch(random.nextInt(3)){
		// Lettre enregistrée
		case 0 :
			complexeLetter = new RegisteredLetter(this, receiver, simpleContentLetter);
			break;
			
		// Lettre urgente
		case 1 :
			complexeLetter = new UrgentLetter(this, receiver, simpleContentLetter);
			break;
		// Pas d'envoi spécial
		case 2 :
			complexeLetter = simpleContentLetter;
			break;
		}
		
		// Sélectionne aléatoire le deuxième type d'envoi de la lettre générée.
		switch(random.nextInt(3)){
		// Lettre enregistrée
		case 0 :
			finalLetter = new RegisteredLetter(this, receiver, complexeLetter);
			break;
			
		// Lettre urgente
		case 1 :
			finalLetter = new UrgentLetter(this, receiver, complexeLetter);
			break;
		// Pas d'envoi spécial
		case 2 :
			finalLetter = complexeLetter;
			break;
		}
		
		return finalLetter;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inhabitant other = (Inhabitant) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Envoie une lettre de la part de cet habitant.
	 * @param letter La lettre à envoyer
	 */
	public void sendLetter(Letter<?> letter) {
		if(this.account.getBalance() >= letter.getCost())
			account.withdraw(letter.getCost());
		else
			System.out.println("# "+letter.getSender()+" try to send a letter whose cost "+letter.getCost()+" but his balance is "+account.getBalance()+" euros");
	}
	
	/**
	 * Reçoit la lettre et effectue l'action nécessaire.
	 * @param letter La lettre reçue par l'habitant.
	 */
	public void receiveLetter(Letter<?> letter) {
		recieveLetters.add(letter);
	}
	
	/**
	 * Renvoie la ville de l'habitant.
	 * @return la ville de l'habitant.
	 */
	public City getCity() {
		return this.city;	
	}
	
	/**
	 * Renvoie le nom de l'habitant.
	 * @return le nom de l'habitant.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Renvoie le montant du compte en banque de l'habitant.
	 * @return le montant du compte en banque de l'habitant.
	 */
	public int getBalance() {
		return this.account.getBalance();	
	}
	
	/**
	 * Retire un montant du compte en banque de l'habitant.
	 * @param amount Le montant à retirer du compte de l'habitant.
	 */
	public void withdraw(int amount) {
		this.account.withdraw(amount);
	}
	
	/**
	 * Ajoute un montant au compte de l'habitant.
	 * @param amount Le montant à ajouter au compte de l'habitant.
	 */
	public void credit(int amount) {
		this.account.credit(amount);
	}

	/**
	 * @return Les lettres reçues par cet habitant.
	 */
	public ArrayList<Letter<?>> getReceiveLetters() {
		return receiveLetters;
	}

	/**
	 * @param receiveLetters Les lettres qui doivent être délivrée à cet habitant.
	 */
	public void setReceiveLetters(ArrayList<Letter<?>> receiveLetters) {
		this.receiveLetters = receiveLetters;
	}
	
}

