package content;

/**
 * Class to manage the money content
 * @author dubois bellamy
 *
 */
public class MoneyContent implements Content {
	private int amount;
	
	/**
	 * Constructor of a new money content
	 * @param amount the money in this content
	 */
	public MoneyContent(int amount) {
		this.amount = amount;
	}
	
	/**
	 * @see Content#getDescription()
	 */
	public String getDescription() {
		return "";
	}
	
	/**
	 * Get the amount of this content
	 * @return the amount of this content
	 */
	public int getAmount() {
		return this.amount;
	}

}
