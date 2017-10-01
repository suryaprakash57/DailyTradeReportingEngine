package my.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionManager {

	
	private ObjectOutputStream os;
	private ObjectInputStream is;
	private final String hostname;
	private final int port;
	private Socket clientSocket;

	
	
	public ConnectionManager(String hostname, int port) {
		super();
		this.hostname = hostname;
		this.port = port;
	}



	/**
	 * Opens connection with the Market
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void openConnection() throws UnknownHostException, IOException
	{
		clientSocket = new Socket(hostname, port);
		System.out.println("Connection successful.");
		os = new ObjectOutputStream(clientSocket.getOutputStream());
		is = new ObjectInputStream(clientSocket.getInputStream());
		
		
	}
	
	/**
	 * Closes socket with the Market
	 * @throws IOException
	 */
	public void closeConnection() throws IOException
	{
		clientSocket.close();
	}



	/**
	 * @return the ObjectOutputStream
	 */
	public ObjectOutputStream getObjectOutputStream() {
		return os;
	}



	/**
	 * @return the ObjectInputStream
	 */
	public ObjectInputStream getObjectInputStream() {
		return is;
	}
	
	
	
}
