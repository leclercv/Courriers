package test.letter;

import static org.junit.Assert.*;
import letters.Letter;
import letters.UrgentLetter;

import org.junit.Test;

import content.Content;

import entity.Inhabitant;

public class TestUrgentLetter extends TestLetter {

	@Override
	protected Letter<?> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new UrgentLetter(sender, receiver, new MookLetter(sender, receiver, new MookContent()));
	}

	@Override
	protected void testDoActionForThisLetter() {
		MookLetter mookLetter = (MookLetter) this.letter.getContent();
		
		assertEquals(4998, this.letter.getSender().getBalance(), 0);
		assertFalse(mookLetter.actionDone);
		this.letter.doAction();
		assertTrue(mookLetter.actionDone);
	}
	
	class MookContent implements Content {

		@Override
		public String getDescription() {
			return "";
		}
		
	}
	
	class MookLetter extends Letter<MookContent> {

		private boolean actionDone;
		
		public MookLetter(Inhabitant sender, Inhabitant receiver, MookContent content) {
			super(sender, receiver, content);
			this.actionDone = false;
		}

		@Override
		public String getDescription() {
			return "";
		}

		@Override
		public void doAction() {
			this.actionDone = true;
		}
		
	}
}
