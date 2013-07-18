package co.yellowbricks.bggclient.request;

public class BggServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public BggServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
