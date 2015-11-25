package letters;

import content.TextContent;
import entity.Inhabitant;

/**
 * Class représentant une lettre simple avec un contenu textuel.
 */
public class SimpleLetter extends Letter<TextContent>
{

	/**
	 * Constructeur de base d'une lettre simple à contenu textuel.
	 * @param sender L'habitant ayant envoyé la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content Le contenu de la lettre.
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, TextContent content) {
		super(sender, receiver, content);
	}
	
	/**
	 * Initialise le coût de la lettre.
	 */
	protected void initCost() {
		this.cost = 1;
	}

	/**
	 * Effectue l'action nécessaire à la réception de la lettre.
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

