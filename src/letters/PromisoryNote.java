package letters;

import content.Content;
import content.MoneyContent;
import entity.Inhabitant;

/**
 * Class representant une lettre de promesse ayant un contenu de type monnetaire.
 */

public class PromisoryNote extends Letter<MoneyContent> {

/**
	 * Constructeur de base d'une lettre de promesse.
	 * @param sender L'habitant ayant envoye la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content Le contenu monnetaire de la lettre.
	 */
	public PromisoryNote(Inhabitant sender, Inhabitant receiver, MoneyContent content) {
		super(sender, receiver, content);
	}
	
	/**
	 * Initialise le cout de la lettre.
	 */
	protected void initCost() {
		this.cost = 1 + (int) content.getAmount()/100;
	}

	/**
	 * Renvoie la description de la lettre de promesse.
	 * @return la description de la lettre de promesse.
	 */
	public String getDescription() {
		return "a promisory note letter whose content is money content ("+content.getAmount()+")";
	}

	/**
	 * Effectue l'action a la reception de la lettre de promesse, c'est a dire recevoir l'argent de la lettre, puis envoyer une lettre de remerciement a l'emetteur.
	 */
	@Override
	public void doAction() {
		sender.withdraw(content.getAmount());
		receiver.credit(content.getAmount());
		
		System.out.println("  - "+content.getAmount()+" euros are debited from "+sender.getName()+" account whose balance is now "+sender.getBalance()+" euros");
		System.out.println("  + "+receiver.getName()+" account is credited with "+content.getAmount()+" euros; Its balance is now "+receiver.getBalance()+" euros");
		
		ThanksLetter thanks = new ThanksLetter(receiver, sender, this);
		
		receiver.sendLetter(thanks);
		
		System.out.println("-> " + receiver.getName()+" mails "+thanks.getDescription()+" to "+sender.getName()+" for cost of "+thanks.getCost()+" euro(s)");
	}
}
