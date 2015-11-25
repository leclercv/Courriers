package letters;
import content.Content;
import entity.Inhabitant;

/**
 * Class représentant une lettre.
 * @author Place Leclercq
 *
 * @param <C> Le type de contenu de la lettre.
 */
public abstract class Letter<C extends Content> implements Content{
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected int cost;
	protected C content;
	
	/**
	 * Constructeur de base d'une nouvelle lettre.
	 * @param sender L'habitant ayant envoyé la lettre.
	 * @param receiver L'habitant destinataire de la lettre.
	 * @param content Le contenu de la lettre.
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.initCost();
		sender.getCity().sendLetter(this);
	}
	
	/**
	 * Initialise le coût initial d'une lettre.
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
	 * Renvoie le coût de la lettre.
	 * @return le coût de la lettre.
	 */
	public int getCost() {
		return this.cost;	
	}
	
	/**
	 * Effectue l'action nécessaire à la réception de la lettre.
	 */
	public abstract void doAction();
	
	/**
	 * Renvoie l'habitant ayant envoyé la lettre.
	 * @return l'habitant ayant envoyé la lettre.
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

