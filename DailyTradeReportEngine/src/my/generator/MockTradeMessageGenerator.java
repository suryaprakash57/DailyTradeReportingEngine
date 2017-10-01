package my.generator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

import my.common.TradeMessage;

public class MockTradeMessageGenerator {

	private static ObjectOutputStream os;
	private static ObjectInputStream is;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket ss = new ServerSocket(9090);
		Socket socket = ss.accept();
		os = new ObjectOutputStream(socket.getOutputStream());
		is = new ObjectInputStream(socket.getInputStream());

		os.writeObject(new TradeMessage(TradeMessage.LOGON));
	
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "FOO", true, "SGP", LocalDate.now(), LocalDate.now(),
					200, 100.25, 0.55));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "BAR", true, "AED", LocalDate.now(), LocalDate.now().plusDays(2),
					450, 150.5, 0.22));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "ANT", false, "GBP", LocalDate.now(), LocalDate.now().minusDays(2),
					145, 230.5, 0.15));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DEST", true, "GBP", LocalDate.now(), LocalDate.now().minusDays(3),
					4500, 820.5, 0.25));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DES", true, "USD", LocalDate.now(), LocalDate.now().plusDays(3),
					190, 920.5, 0.35));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "AND", false, "USD", LocalDate.now(), LocalDate.now().minusDays(4),
					10030, 2780.5, 0.45));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "ANT", true, "GBP", LocalDate.now(), LocalDate.now().plusDays(2),
					800, 210.5, 0.55));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DESA", true, "AED", LocalDate.now(), LocalDate.now().minusDays(2),
					320, 420.5, 0.65));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "XYZ", true, "SAR", LocalDate.now(), LocalDate.now().plusDays(5),
					540, 450.5, 0.75));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "XYZ", true, "AED", LocalDate.now(), LocalDate.now().minusDays(7),
					760, 670.5, 0.85));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "NATW", true, "CHR", LocalDate.now(), LocalDate.now().plusDays(6),
					340, 900.5, 0.95));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "ESPN", true, "YEN", LocalDate.now(), LocalDate.now().minusDays(7),
					760, 540.5, 0.05));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "TED", true, "SGD", LocalDate.now(), LocalDate.now().plusDays(6),
					490, 770.5, 0.15));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DES", false, "CAD", LocalDate.now(), LocalDate.now().minusDays(4),
					9000, 560.5, 0.25));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "NED", true, "GBP", LocalDate.now(), LocalDate.now().plusDays(5),
					1120, 760.5, 0.35));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "POS", false, "USD", LocalDate.now(), LocalDate.now().minusDays(4),
					1200, 98.5, 0.45));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "PES", false, "EURO", LocalDate.now(), LocalDate.now().plusDays(6),
					1700, 670.5, 0.55));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "POS", true, "USD", LocalDate.now(), LocalDate.now().minusDays(7),
					1500, 870.5, 0.65));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "PES", true, "ASD", LocalDate.now(), LocalDate.now().plusDays(2),
					1300, 670.5, 0.75));
			is.readObject(); // Waiting for Acknowledgment

			os.writeObject(new TradeMessage(TradeMessage.TRADE, "FOO", true, "YEN", LocalDate.now(), LocalDate.now().minusDays(1),
					1030, 870.5, 0.85));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "BAR", true, "GBP", LocalDate.now(), LocalDate.now().plusDays(1),
					1020, 850.5, 0.95));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "ANT", false, "GBP", LocalDate.now(), LocalDate.now().minusDays(4),
					1432, 450.5, 0.95));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DEST", true, "USD", LocalDate.now(), LocalDate.now().plusDays(3),
					1200, 760.5, 0.85));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DES", true, "RY", LocalDate.now(), LocalDate.now().minusDays(2),
					1042, 450.5, 0.75));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "AND", false, "RY", LocalDate.now(), LocalDate.now().plusDays(1),
					1024, 560.5, 0.65));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "ANT", true, "AED", LocalDate.now(), LocalDate.now().minusDays(5),
					102340, 874.5, 0.55));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DESA", true, "GBP", LocalDate.now(), LocalDate.now().plusDays(2),
					1020, 540.5, 0.65));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "XYZ", true, "USD", LocalDate.now(), LocalDate.now().minusDays(1),
					12400, 760.5, 0.55));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "XYZ", true, "CAD", LocalDate.now(), LocalDate.now().plusDays(2),
					14300, 340.5, 0.325));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "NATW", true, "CAD", LocalDate.now(), LocalDate.now().minusDays(1),
					15400, 654.5, 0.4355));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "ESPN", true, "SGD", LocalDate.now(), LocalDate.now().plusDays(1),
					14300, 654.5, 0.5675));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "TED", true, "PLN", LocalDate.now(), LocalDate.now().minusDays(6),
					13500, 745.5, 0.545));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "DES", false, "CHR", LocalDate.now(), LocalDate.now().minusDays(3),
					1600, 654.5, 0.5));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "NED", true, "FUR", LocalDate.now(), LocalDate.now().plusDays(2),
					1800, 748.5, 0.755));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "POS", false, "USD", LocalDate.now(), LocalDate.now().minusDays(1),
					1900, 874.5, 0.545));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "PES", false, "AED", LocalDate.now(), LocalDate.now().plusDays(2),
					15400, 653.5, 0.455));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "POS", true, "GBP", LocalDate.now(), LocalDate.now().plusDays(9),
					17600, 560.5, 0.35));
			is.readObject(); // Waiting for Acknowledgment
			os.writeObject(new TradeMessage(TradeMessage.TRADE, "PES", true, "USD", LocalDate.now(), LocalDate.now().minusDays(9),
					19800, 940.5, 0.655));
			is.readObject(); // Waiting for Acknowledgment
			
		os.writeObject(new TradeMessage(TradeMessage.LOGOUT));
		is.readObject(); // Waiting for Acknowledgment
		ss.close();
	}

}
