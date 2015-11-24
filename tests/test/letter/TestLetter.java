package test.letter;

import letters.Letter;

import org.junit.Before;
import org.junit.Test;

import entity.City;
import entity.Inhabitant;

public abstract class TestLetter {

	protected Letter<?> letter;
	
	@Before
	public void init() {
		City city = new City("Lille");
		Inhabitant sender = new Inhabitant(city, "timoleon");
		Inhabitant receiver = new Inhabitant(city, "yoda");
		this.letter = this.createLetter(sender, receiver);
	}
	
	protected abstract Letter<?> createLetter(Inhabitant sender, Inhabitant receiver);
	protected abstract void testDoActionForThisLetter();
	
	@Test
	public void testDoAction() {
		testDoActionForThisLetter();
	}

}
