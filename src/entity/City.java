package entity;

import java.util.ArrayList;
import java.util.List;

import letters.Letter;

/**
 * Class to manage a city
 * @author dubois bellamy
 *
 */
public class City
{
	private ArrayList<Letter<?>> postbox;
	private String name;
	
	/**
	 * Constructor of a new city
	 * @param name
	 */
	public City(String name) {
		this.name = name;
		this.postbox = new ArrayList<Letter<?>>();
	}
	
	/**
	 * Add the letter in the post box letter of this city
	 * @param letter the letter to add in the post box
	 */
	public void sendLetter(Letter<?> letter) {
		this.postbox.add(letter);
		letter.getSender().sendLetter(letter);
	}
	
	/**
	 * Distribute all letters
	 */
	@SuppressWarnings("unchecked")
	public void distributeLetters() {
		List<Letter<?>> mailman = (List<Letter<?>>) postbox.clone();
		this.postbox.clear();
		
		for(Letter<?> letter : mailman) {
			letter.getReceiver().receiveLetter(letter);
		}
	}
	
	/**
	 * Get the name of this city
	 * @return the name of this city
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the post box of this city
	 * @return the post box of this city
	 */
	public List<Letter<?>> getPostBox() {
		return this.postbox;
	}
	
}

