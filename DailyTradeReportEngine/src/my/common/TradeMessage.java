package my.common;

import java.io.Serializable;
import java.time.LocalDate;

public class TradeMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6506910552048208889L;
	public static final int LOGON = 0;
	public static final int LOGOUT = 2;
	public static final int TRADE = 1;
	public static final int ACK = 3;

	private int type;
	private String entity;
	private boolean buy;
	private String currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private long units;
	private double price;
	private double agreedFx;

	public TradeMessage(int type) {
		super();
		this.type = type;
	}

	public TradeMessage(int type, String entity, boolean buy, String currency, LocalDate instructionDate,
			LocalDate settlementDate, long units, double price, double agreedFx) {
		super();
		this.type = type;
		this.entity = entity;
		this.buy = buy;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.price = price;
		this.agreedFx = agreedFx;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return the buy
	 */
	public boolean isBuy() {
		return buy;
	}

	/**
	 * @param buy
	 *            the buy to set
	 */
	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the instructionDate
	 */
	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	/**
	 * @param instructionDate
	 *            the instructionDate to set
	 */
	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	/**
	 * @return the settlementDate
	 */
	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate
	 *            the settlementDate to set
	 */
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * @return the units
	 */
	public long getUnits() {
		return units;
	}

	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnits(long units) {
		this.units = units;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the agreedFx
	 */
	public double getAgreedFx() {
		return agreedFx;
	}

	/**
	 * @param agreedFx
	 *            the agreedFx to set
	 */
	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
