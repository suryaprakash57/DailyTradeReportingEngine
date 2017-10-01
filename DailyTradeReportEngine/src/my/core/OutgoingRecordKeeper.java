package my.core;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import my.common.TradeMessage;

public class OutgoingRecordKeeper {

	private static final String AED = "AED";
	private static final String SAR = "SAR";

	private final Map<LocalDate, Double> capPerDay;
	private final Map<String, Double> entityAmtMap;

	public OutgoingRecordKeeper() {
		super();
		capPerDay = new HashMap<>();
		entityAmtMap = new HashMap<>();
	}

	public void addTradetoReport(TradeMessage message) {
		correctSettlementDate(message);
		double amount = calculateAmountinUSD(message);
		updateEntityRank(message, amount);
	}

	private double calculateAmountinUSD(TradeMessage message) {
		double amount = message.getPrice() * message.getUnits() * message.getAgreedFx();
		LocalDate settlementDate = message.getSettlementDate();
		if (capPerDay.containsKey(settlementDate)) {
			double previousAmt = capPerDay.get(settlementDate);
			capPerDay.put(settlementDate, amount + previousAmt); // update the
																	// amount
		} else {
			capPerDay.put(settlementDate, amount); // insert new date
		}
		return amount;
	}

	private void updateEntityRank(TradeMessage message, double amount) {
		String entity = message.getEntity().trim();
		if (entityAmtMap.containsKey(entity)) {
			double previousAmt = entityAmtMap.get(entity);
			entityAmtMap.put(entity, amount + previousAmt); // update the new
															// amount
		} else {
			entityAmtMap.put(entity, amount);
		}
	}

	private void correctSettlementDate(TradeMessage message) {

		switch (message.getCurrency()) {
		case AED:
		case SAR:
			handleAED_SAR(message);
			break;
		default:
			handleOthers(message);
		}
	}

	private void handleOthers(TradeMessage message) {
		switch (message.getInstructionDate().getDayOfWeek()) {
		case SATURDAY:
			message.setSettlementDate(message.getSettlementDate().plusDays(2));
			break;
		case SUNDAY:
			message.setSettlementDate(message.getSettlementDate().plusDays(1));
			break;
		default:
			// Do nothing
		}
	}

	private void handleAED_SAR(TradeMessage message) {
		switch (message.getInstructionDate().getDayOfWeek()) {
		case FRIDAY:
			message.setSettlementDate(message.getSettlementDate().plusDays(2));
		case SATURDAY:
			message.setSettlementDate(message.getSettlementDate().plusDays(1));
		default:
			// Do nothing
		}
	}

	/**
	 * @return the capPerDay
	 */
	public Map<LocalDate, Double> getCapPerDay() {
		return capPerDay;
	}

	/**
	 * @return the entityAmtMap
	 */
	public Map<String, Double> getEntityAmtMap() {
		return entityAmtMap;
	}
}
