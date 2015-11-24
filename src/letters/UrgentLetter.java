package letters;

import entity.Inhabitant;

public class UrgentLetter extends Letter<Letter<?>> {
	
	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}
	
	protected void initCost() {
		cost = 2;
	}

	@Override
	public String getDescription() {
		return "an urgent letter whose content is "+content.getDescription();
	}

	@Override
	public void doAction() {
		content.doAction();
	}
}
