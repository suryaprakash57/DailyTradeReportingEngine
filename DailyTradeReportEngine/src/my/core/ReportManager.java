package my.core;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import my.common.TradeMessage;
import my.common.Utils;
import my.core.interfaces.IRecordKeeper;

public class ReportManager {

	private final String INDENT_SPACE = "                                       ";

	private IRecordKeeper inRecordKeeper;
	private IRecordKeeper outRecordKeeper;

	public ReportManager() {
		inRecordKeeper = new IncomingRecordKeeper();
		outRecordKeeper = new OutgoingRecordKeeper();
	}

	public void processMessage(TradeMessage message) {
		if (message.isBuy()) {
			outRecordKeeper.addTradetoReport(message);
		} else {
			inRecordKeeper.addTradetoReport(message);
		}
	}

	public void displayReport() {
		Set<LocalDate> dates = new TreeSet<>();
		Map<LocalDate, Double> inRecords = inRecordKeeper.getCapPerDay();
		Map<LocalDate, Double> outRecords = outRecordKeeper.getCapPerDay();
		dates.addAll(inRecords.keySet());
		dates.addAll(outRecords.keySet());
		displayAmountDaywise(inRecords, outRecords, dates);

		Set<String> inRankList = Utils.rankEntity(inRecordKeeper.getEntityAmtMap());
		Set<String> outRankList = Utils.rankEntity(outRecordKeeper.getEntityAmtMap());

		if (inRankList.size() > outRankList.size()) {
			displayRankList(inRankList, outRankList);
		} else {
			displayRankList(outRankList, inRankList);
		}
	}

	private void displayAmountDaywise(Map<LocalDate, Double> inRecords, Map<LocalDate, Double> outRecords,
			Set<LocalDate> dates) {
		DecimalFormat df = new DecimalFormat("#.####");

		System.out.println("<--------------------------Report------------------------------>");
		System.out.println("Settlement Date       Incoming Amount           Outgoing Amount");
		for (LocalDate date : dates) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
			String dateStr = date.format(formatter);
			System.out.print(dateStr + "           ");
			if (inRecords.containsKey(date)) {
				int digits = String.valueOf(df.format(inRecords.get(date))).length();
				System.out.print(df.format(inRecords.get(date)) + INDENT_SPACE.substring(0, 26 - digits)); // alignment
																											// stuff
			} else {
				System.out.print("-" + INDENT_SPACE.substring(0, 26 - 1));// alignment
																			// stuff
			}
			if (outRecords.containsKey(date)) {
				System.out.println(df.format(outRecords.get(date)));
			} else {
				System.out.println("-");
			}
		}
	}

	private void displayRankList(Set<String> largeRankList, Set<String> smallerRankList) {
		int rank = 0;
		Iterator<String> itr = smallerRankList.iterator();
		System.out.println("\n<-------------------------Rankings----------------------------->");
		System.out.println("Rank            Incoming                   Outgoing");
		for (String entity : largeRankList) {
			int digits = String.valueOf(++rank).length();
			System.out.print(rank + INDENT_SPACE.substring(0, 16 - digits));// alignment
																			// stuff
			System.out.print(entity + INDENT_SPACE.substring(0, 27 - entity.length()));// alignment
																						// stuff
			if (itr.hasNext()) {
				System.out.println(itr.next());
			} else {
				System.out.println("-");
			}
		}
	}
}
