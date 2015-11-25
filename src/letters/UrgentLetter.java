package letters;

import entity.Inhabitant;

/**
 * Class représentant une lettre à envoyer de façon urgente.
 */
public class UrgentLetter extends Letter<Letter<?>> {
	
	/**
	 * Constructeur de base d'une lettre à envoyer de façon urgente.
	 * @param sender L'habitant ayant envoyé la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content La lettre à envoyer de façon urgente.
	 */
	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}
	
	/**
	 * Initialise le coût initial de la lettre.
	 */
	protected void initCost() {
		cost = 2;
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
	 * Effectue l'action nécessaire à la réception de la lettre envoyée de façon urgente.
	 */
	@Override
	public void doAction() {
		content.doAction();
	}
}
