package test.letter;

import static org.junit.Assert.*;
import letters.Letter;
import letters.SimpleLetter;
import content.TextContent;
import entity.Inhabitant;

public class TestSimpleLetter extends TestLetter {

	@Override
	protected Letter<?> createLetter(Inhabitant sender, Inhabitant receiver) {
		MookTextContent content = new MookTextContent();
		return new SimpleLetter(sender, receiver, content);
	}

	@Override
	protected void testDoActionForThisLetter() {
		MookTextContent contentLetter = (MookTextContent)this.letter.getContent();
		assertFalse(contentLetter.messageReaded);
		this.letter.doAction();
		assertTrue(contentLetter.messageReaded);
		assertEquals(4999, this.letter.getSender().getBalance(), 0);
	}

	class MookTextContent extends TextContent {

		private boolean messageReaded;
		
		public MookTextContent() {
			super("");
			this.messageReaded = false;
		}
		
		@Override
		public String getMessage() {
			this.messageReaded = true;
			return super.getMessage();
		}
		
	}
}
