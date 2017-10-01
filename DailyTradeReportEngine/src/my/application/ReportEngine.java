package my.application;

import java.io.IOException;
import java.net.UnknownHostException;

import my.core.ConnectionManager;
import my.core.MessageProcessor;
import my.core.ReportManager;

public class ReportEngine {

	private static ReportManager reportManager;
	private static ConnectionManager conMgr;
	private static MessageProcessor processor;

	public static void main(String[] args) throws UnknownHostException, IOException {
		launch();
	}

	private static void launch() throws UnknownHostException, IOException {
		initialize();
		connectToProvider();
		start();
	}

	private static void initialize() {
		reportManager = new ReportManager();
		conMgr = new ConnectionManager("localhost", 9090);
		processor = new MessageProcessor(reportManager, conMgr);
	}

	private static void connectToProvider() throws UnknownHostException, IOException {
		conMgr.openConnection();
		processor.initiliazeStream();
	}

	private static void start() {
		processor.start();
	}

}
