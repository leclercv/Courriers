package test.letter;

import static org.junit.Assert.*;
import letters.Letter;
import letters.PromisoryNote;
import letters.ThanksLetter;
import content.MoneyContent;
import entity.City;
import entity.Inhabitant;

public class TestPromisoryNote extends TestLetter {

	@Override
	protected Letter<?> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new PromisoryNote(sender, receiver, new MoneyContent(5));
	}

	@Override
	protected void testDoActionForThisLetter() {
		City city = this.letter.getSender().getCity();
		assertEquals(4999, this.letter.getSender().getBalance(), 0);
		assertEquals(5000, this.letter.getReceiver().getBalance(), 0);
		this.letter.doAction();
		assertEquals(4992.99, this.letter.getSender().getBalance(), 2);
		assertEquals(5004, this.letter.getReceiver().getBalance(), 0);
		
		assertTrue(city.getPostBox().contains(new ThanksLetter(letter.getReceiver(), letter.getSender(), (PromisoryNote) letter)));
	}

}
