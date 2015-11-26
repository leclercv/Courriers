package letters;

import content.TextContent;
import entity.Inhabitant;

/**
 * Class representant une lettre envoyee de facon enregistree.
 */
public class RegisteredLetter extends Letter<Letter<?>>{

	/**
	 * Constructeur de base d'une lettre enregistree.
	 * @param sender L'habitant ayant envoye la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content La lettre devant etre envoyee de facon enregistree.
	 */
	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}
	
	/**
	 * Initialise le cout de la lettre envoyee de facon enregistree.
	 */
	protected void initCost() {
		this.cost = 15;
	}
	
	/**
	 * Renvoie la description de la lettre.
	 * @return la description de la lettre.
	 */
	@Override
	public String getDescription() {
		return "a registered letter whose content is "+content.getDescription();
	}

	/**
	 * Effectue l'action de la lettre, y compris l'envoi d'un accuse de reception du a l'envoi enregistre de la lettre.
	 */
	@Override
	public void doAction() {
		TextContent text = new TextContent("aknowledgment of receipt for "+content.getDescription());
		
		SimpleLetter aknowledgment = new SimpleLetter(receiver, sender, text);
		
		sender.getCity().sendLetter(aknowledgment);
		
		System.out.println("-> " + receiver.getName()+" mails "+aknowledgment.getDescription()+" to "+sender.getName()+" for cost of "+aknowledgment.getCost()+" euro(s)");
		
		content.doAction();
	}
}

