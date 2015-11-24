package letters;
import content.Content;
import entity.Inhabitant;

/**
 * Class to manage the letters
 * @author dubois bellamy
 *
 * @param <C> The content type of this letter
 */
public abstract class Letter<C extends Content> implements Content{
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected int cost;
	protected C content;
	
	/**
	 * Constructor of a new letter
	 * @param sender The inhabitant who's sent the letter
	 * @param receiver the inhabitant who's received the letter 
	 * @param content the content of this letter
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.initCost();
		sender.getCity().sendLetter(this);
	}
	
	protected void initCost() {
		this.cost = 1;		
	}
	
	/**
	 * Get the content of this letter
	 * @return the content of this letter
	 */
	public C getContent() {
		return this.content;	
	}
	
	/**
	 * Get the cost of this letter
	 * @return the cost of this letter
	 */
	public int getCost() {
		return this.cost;	
	}
	
	/**
	 * Do the action of this letter
	 */
	public abstract void doAction();
	
	/**
	 * Get the sender of this letter
	 * @return the sender of this letter
	 */
	public Inhabitant getSender() {
		return this.sender;
	}
	
	/**
	 * Get the receiver of this letter
	 * @return the receiver of this letter
	 */
	public Inhabitant getReceiver() {
		return this.receiver;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

