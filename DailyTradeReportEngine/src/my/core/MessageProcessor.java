package my.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import my.common.TradeMessage;

public class MessageProcessor {

	private ConnectionManager conMgr;
	private boolean shutDown;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private ReportManager reportManager;

	public MessageProcessor(ReportManager reportManager, ConnectionManager conMgr) {
		this.reportManager = reportManager;
		this.conMgr = conMgr;
	}

	public void initiliazeStream() {
		os = conMgr.getObjectOutputStream();
		is = conMgr.getObjectInputStream();
	}

	public void start() {
		while (!shutDown) {
			try {
				TradeMessage message = (TradeMessage) is.readObject();
				handleMessage(message);
			} catch (Exception e) {
				e.printStackTrace();
				shutDown = true;
			}
		}
	}

	private void handleMessage(TradeMessage message) throws IOException {
		switch (message.getType()) {
		case TradeMessage.LOGON:
			System.out.println("Logon Received!!!");
			sendAck();
			break;
		case TradeMessage.TRADE:
			reportManager.processMessage(message);
			sendAck();
			break;
		case TradeMessage.LOGOUT:
			sendAck();
			conMgr.closeConnection();
			shutDown = true;
			reportManager.displayReport();
			break;
		default:
			System.out.println("Invalid message.");

		}
	}

	private void sendAck() throws IOException {
		os.writeObject(new TradeMessage(TradeMessage.ACK));
	}

}
