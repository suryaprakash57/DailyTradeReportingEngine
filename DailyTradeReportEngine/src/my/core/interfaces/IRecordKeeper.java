package my.core.interfaces;

import java.time.LocalDate;
import java.util.Map;

import my.common.TradeMessage;

public interface IRecordKeeper {

	void addTradetoReport(TradeMessage message);

	Map<LocalDate, Double> getCapPerDay();

	Map<String, Double> getEntityAmtMap();

}
