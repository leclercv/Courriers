package letters;

import content.TextContent;
import entity.Inhabitant;

public class RegisteredLetter extends Letter<Letter<?>>{

	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}
	
	/**
	 * @see RegisteredLetter#initCost()
	 */
	protected void initCost() {
		this.cost = 15;
	}
	
	/**
	 * @see Letter#getDescription()
	 */
	@Override
	public String getDescription() {
		return "a registered letter whose content is "+content.getDescription();
	}

	/**
	 * Send an aknowledgment
	 */
	@Override
	public void doAction() {
		TextContent text = new TextContent("aknowledgment of receipt for "+content.getDescription());
		// Make aknowledgment
		SimpleLetter aknowledgment = new SimpleLetter(receiver, sender, text);
		// Post letter
		sender.getCity().sendLetter(aknowledgment);
		
		System.out.println("-> " + receiver.getName()+" mails "+aknowledgment.getDescription()+" to "+sender.getName()+" for cost of "+aknowledgment.getCost()+" euro(s)");
		
		// If its content is a promisory not (for example), it have to make the money transfert...
		content.doAction();
	}
}
