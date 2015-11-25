package letters;

import content.TextContent;
import entity.Inhabitant;

/**
 * Class représentant une lettre de remerciement émise à la réception d'une lettre de promesse.
 */
public class ThanksLetter extends SimpleLetter {

	/**
	 * Constructeur de base d'une lettre de remerciement.
	 * @param sender L'habitant ayant envoyé la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param attachment La lettre de promesse pour laquelle sont formulés les remerciements.
	 */
	public ThanksLetter(Inhabitant sender, Inhabitant reciever, PromisoryNote attachment) {
		super(sender, reciever, new TextContent("thanks for a promissory note letter whose content is a money content ("+attachment.getContent().getAmount()+")"));
	}

	/**
	 * Renvoie la description de la lettre.
	 * @return la description de la lettre.
	 */
	@Override
	public String getDescription() {
		return "a thanks letter whose content is a text ("+content.getMessage()+")";
	}

	/**
	 * Effectue l'action nécessaire à la réception de la lettre (Aucune action requise à la réception d'une lettre de remerciement.)
	 */
	@Override
	public void doAction() {
		
	}
}
