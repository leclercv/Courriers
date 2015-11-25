package content;

/**
 * Class représentant un contenu de type monnétaire.
 * @author Place Leclercq
 *
 */
public class MoneyContent implements Content {
	private int amount;
	
	/**
	 * Constructeur de base d'un MoneyContent.
	 * @param amount Le montant d'argent contenu dans la lettre.
	 */
	public MoneyContent(int amount) {
		this.amount = amount;
	}
	
	/**
	 * Renvoie la description du contenu de la lettre.
	 * @return la description du contenu de la lettre.
	 */
	public String getDescription() {
		return "";
	}
	
	/**
	 * Renvoie le montant du contenu de la lettre.
	 * @return le montant du contenu de la lettre.
	 */
	public int getAmount() {
		return this.amount;
	}

}
