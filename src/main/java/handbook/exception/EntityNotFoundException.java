package handbook.exception;

public class EntityNotFoundException extends Exception {
	private static final long serialVersionUID = 6124546343369440637L;
	
	public EntityNotFoundException(String message)
	{
		super(message);
	}
}
