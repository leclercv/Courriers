package letters;

import entity.Inhabitant;

/**
 * Class representant une lettre a envoyer de facon urgente.
 */
public class UrgentLetter extends Letter<Letter<?>> {
	
	/**
	 * Constructeur de base d'une lettre a envoyer de facon urgente.
	 * @param sender L'habitant ayant envoye la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content La lettre a envoyer de facon urgente.
	 */
	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}
	
	/**
	 * Initialise le cout initial de la lettre.
	 */
	protected void initCost() {
		cost = content.getCost()*2;
	}

	/**
	 * Renvoie la description de la lettre.
	 * @return la description de la lettre.
	 */
	@Override
	public String getDescription() {
		return "an urgent letter whose content is "+content.getDescription();
	}

	/**
	 * Effectue l'action necessaire a la reception de la lettre envoyee de facon urgente.
	 */
	@Override
	public void doAction() {
		content.doAction();
	}
}
