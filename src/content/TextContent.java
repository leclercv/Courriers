package content;

public class TextContent implements Content{

	private String message;
	
	public TextContent(String message){
		this.message = message;
	}

	public String getMessage() {
		return this.message;	
	}
	
	public String getDescription() {
		return "";	
	}
	
}

