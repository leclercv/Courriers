package letters;

import content.TextContent;
import entity.Inhabitant;


public class SimpleLetter extends Letter<TextContent>
{

	public SimpleLetter(Inhabitant sender, Inhabitant reciever,	TextContent content) {
		super(sender, reciever, content);
	}
	
	/**
	 * @see Letter#initCost()
	 */
	protected void initCost() {
		this.cost = 1;
	}

	/**
	 * @see Letter#doAction()
	 */
	@Override
	public void doAction() {
		this.content.getMessage();
	}
	
	/**
	 * @see Letter#getDescription()
	 */
	@Override
	public String getDescription() {
		return "a simple letter whose content is a text ("+content.getMessage()+")";
	}
}

