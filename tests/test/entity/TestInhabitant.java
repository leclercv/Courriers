package test.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.City;
import entity.Inhabitant;

public class TestInhabitant {
	
	private Inhabitant habitant;
	
	@Before
	public void init() {
		City city = new City("Lille");
		habitant = new Inhabitant(city, "Timoleon");
	}
	
	@Test
	public void testCreateInhabitant() {
		assertEquals(5000.0, this.habitant.getBalance(), 0);
		assertEquals("Timoleon", this.habitant.getName());
	}
	
	@Test
	public void testWithDraw() {
		this.habitant.withdraw(100);
		assertEquals(4900.0, this.habitant.getBalance(), 0);
		this.habitant.withdraw(5000);
		assertEquals(-100.0, this.habitant.getBalance(), 0);
	}
	
	@Test
	public void testCredit() {
		this.habitant.credit(100);
		assertEquals(5100.0, this.habitant.getBalance(), 0);
		this.habitant.credit(200);
		assertEquals(5300.0, this.habitant.getBalance(), 0);
	}

}
