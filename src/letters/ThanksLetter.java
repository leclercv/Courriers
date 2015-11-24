package letters;

import content.TextContent;
import entity.Inhabitant;

public class ThanksLetter extends SimpleLetter {

	public ThanksLetter(Inhabitant sender, Inhabitant reciever, PromisoryNote attachment) {
		super(sender, reciever, new TextContent("thanks for a promissory note letter whose content is a money content ("+attachment.getContent().getAmount()+")"));
	}

	@Override
	public String getDescription() {
		return "a thanks letter whose content is a text ("+content.getMessage()+")";
	}

	@Override
	public void doAction() {
		
	}
}
