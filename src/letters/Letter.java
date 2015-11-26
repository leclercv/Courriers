package letters;
import java.util.Random;

import content.Content;
import entity.Inhabitant;

/**
 * Class representant une lettre.
 * @author Place Leclercq
 *
 * @param <C> Le type de contenu de la lettre.
 */
public abstract class Letter<C extends Content> implements Content{
	protected int id;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected int cost;
	protected C content;
	
	/**
	 * Constructeur de base d'une nouvelle lettre.
	 * @param sender L'habitant ayant envoye la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content Le contenu de la lettre.
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		Random r = new Random();
		this.id = r.nextInt(10000);
		this.initCost();
	}
	
	/**
	 * Initialise le cout initial d'une lettre.
	 */
	protected void initCost() {
		this.cost = 1;		
	}
	
	/**
	 * Renvoie le contenu de la lettre.
	 * @return le contenu de la lettre.
	 */
	public C getContent() {
		return this.content;	
	}
	
	/**
	 * Renvoie le cout de la lettre.
	 * @return le cout de la lettre.
	 */
	public int getCost() {
		return this.cost;	
	}
	
	/**
	 * Effectue l'action necessaire a  la reception de la lettre.
	 */
	public abstract void doAction();
	
	/**
	 * Renvoie l'habitant ayant envoye la lettre.
	 * @return l'habitant ayant envoye la lettre.
	 */
	public Inhabitant getSender() {
		return this.sender;
	}
	
	/**
	 * Renvoie le destinataire de la lettre.
	 * @return le destinataire de la lettre.
	 */
	public Inhabitant getReceiver() {
		return this.receiver;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + cost;
		result = prime * result
				+ ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (cost != other.cost)
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}
}
