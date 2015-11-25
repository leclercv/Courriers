package entity;

/**
 * Class représentant le compte en banque d'un habitant.
 * @author Place Leclercq
 *
 */
public class Account{
	private int balance;
	
	/**
	 * Constructeur de base d'un compte en banque.
	 * @param établit le montant initial du compte en banque au moment de son ouverture.
	 */
	public Account(int balance) {
		this.balance = balance;
	}
	
	/**
	 * Renvoie le montant d'argent disponible sur le compte en banque.
	 * @return le montant d'argent disponible sur le compte en banque.
	 */
	public int getBalance() {
		return this.balance;	
	}
	
	/**
	 * Retire un montant d'argent du compte en banque.
	 * @param le montant d'argent devant être retiré du compte en banque.
	 */
	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}
	
	/**
	 * Ajoute un montant d'argent à ce compte en banque.
	 * @param le montant d'argent devant être ajouté au compte en banque.
	 */
	public void credit(int amount) {
		this.balance = this.balance + amount;
	}
	
}

