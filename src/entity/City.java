package entity;

import java.util.ArrayList;
import java.util.List;

import letters.Letter;

/**
 * Class representant une ville.
 * @author Place Leclercq
 *
 */
public class City
{
	private ArrayList<Letter<?>> postbox;
	private String name;
	
	/**
	 * Constructeur de base d'une ville.
	 * @param name Le nom de la ville.
	 */
	public City(String name) {
		this.name = name;
		this.postbox = new ArrayList<Letter<?>>();
	}
	
	/**
	 * Ajoute la lettre au bureau de poste de la ville.
	 * @param letter La lettre devant etre delivree dans la ville.
	 */
	public void sendLetter(Letter<?> letter) {
		this.postbox.add(letter);
		letter.getSender().sendLetter(letter);
	}
	
	/**
	 * Distribue l'ensemble des lettres devant etre distribuee dans la ville.
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
	 * Renvoie le nom de la ville.
	 * @return le nom de la ville.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Renvoie le bureau de poste de la ville.
	 * @return le bureau de poste de la ville.
	 */
	public List<Letter<?>> getPostBox() {
		return this.postbox;
	}
	
}

