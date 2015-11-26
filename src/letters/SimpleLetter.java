package letters;

import content.TextContent;
import entity.Inhabitant;

/**
 * Class representant une lettre simple avec un contenu textuel.
 */
public class SimpleLetter extends Letter<TextContent>
{

	/**
	 * Constructeur de base d'une lettre simple a contenu textuel.
	 * @param sender L'habitant ayant envoye la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content Le contenu de la lettre.
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, TextContent content) {
		super(sender, receiver, content);
	}
	
	/**
	 * Initialise le cout de la lettre.
	 */
	protected void initCost() {
		this.cost = 1;
	}

	/**
	 * Effectue l'action necessaire a la reception de la lettre.
	 */
	@Override
	public void doAction() {
		this.content.getMessage();
	}
	
	/**
	 * Renvoie la description de la lettre.
	 * @return la description de la lettre.
	 */
	@Override
	public String getDescription() {
		return "a simple letter whose content is a text ("+content.getMessage()+")";
	}
}
