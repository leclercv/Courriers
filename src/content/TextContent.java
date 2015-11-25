package content;

/**
 * Class représentant un contenu textuel.
 * @author Place Leclercq
 * 
 */

public class TextContent implements Content{

/**
 * Variable contenant le message de la lettre.
 */
	private String message;
	
/**
 * Modifie le message de la lettre.
 * @param message Le message qui doit être assigné à la lettre.
 */
	public TextContent(String message){
		this.message = message;
	}

/**
 * Renvoie le message contenu dans la lettre.
 * @return le message contenu dans la lettre.
 */
	public String getMessage() {
		return this.message;	
	}
	
/**
 * Renvoie la description du contenu de la lettre.
 * @return la description du contenu de la lettre.
 */
	public String getDescription() {
		return "";	
	}
	
}

