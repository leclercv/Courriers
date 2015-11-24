package test.entity;

import static org.junit.Assert.*;
import letters.Letter;

import org.junit.Before;
import org.junit.Test;

import content.Content;
import entity.City;
import entity.Inhabitant;

public class TestCity {

	private City city;
	
	@Before
	public void init() {
		this.city = new City("Lille");
	}
	
	@Test
	public void testSendLetter() {
		Inhabitant h1 = new Inhabitant(this.city, "h1");
		Inhabitant h2 = new Inhabitant(this.city, "h2");
		
		assertEquals(0, this.city.getPostBox().size());
		this.city.sendLetter(new MookLetter(h1, h2, new MookContent()));
		assertEquals(1, this.city.getPostBox().size());
		this.city.sendLetter(new MookLetter(h2, h1, new MookContent()));
		assertEquals(2, this.city.getPostBox().size());
	}
	
	@Test
	public void testDistributeLetter() {
		Inhabitant h1 = new Inhabitant(this.city, "h1");
		Inhabitant h2 = new Inhabitant(this.city, "h2");
		
		this.city.sendLetter(new MookLetter(h1, h2, new MookContent()));
		this.city.sendLetter(new MookLetter(h2, h1, new MookContent()));
		assertEquals(2, this.city.getPostBox().size());
		this.city.distributeLetters();
		assertEquals(0, this.city.getPostBox().size());
	}
	
	class MookContent implements Content {

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	class MookLetter extends Letter<MookContent> {

		public MookLetter(Inhabitant sender, Inhabitant receiver, MookContent content) {
			super(sender, receiver, content);
		}

		@Override
		public void doAction() {
			
		}

		@Override
		public String getDescription() {
			return "mook";
		}
		
	}
}
