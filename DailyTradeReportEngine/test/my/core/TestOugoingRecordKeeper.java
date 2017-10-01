package my.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import my.common.TradeMessage;

public class TestOugoingRecordKeeper {

	private static final String ENTITY = "FOO";
	private static final double DELTA = 0;
	private IncomingRecordKeeper inRecKeeper;
	private int units;
	private double price;
	private double agreedFx;
	private double amountinUSD;
	private TradeMessage trade;
	private TradeMessage aedTrade;
	LocalDate friday = LocalDate.parse("2017/10/06", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	LocalDate saturday = LocalDate.parse("2017/10/07", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	LocalDate sunday = LocalDate.parse("2017/10/08", DateTimeFormatter.ofPattern("yyyy/MM/dd"));

	@Before
	public void setUp() {
		inRecKeeper = new IncomingRecordKeeper();
		units = 200;
		 price = 100.22;
		 agreedFx = 0.55;
		 amountinUSD = units*price*agreedFx;
		trade = new TradeMessage(TradeMessage.TRADE, ENTITY, true, "GBP", friday, friday,
				units, price, agreedFx);
		aedTrade = new TradeMessage(TradeMessage.TRADE, ENTITY, true, "AED", saturday, saturday,
				units, price, agreedFx);
	}
	
	@Test
	public void testCalculateAmountinUSD() {
		
		Assert.assertEquals(amountinUSD, inRecKeeper.calculateAmountinUSD(trade), DELTA);
		
		Map<LocalDate, Double> capMap = inRecKeeper.getCapPerDay();
		
		Assert.assertEquals(amountinUSD, capMap.get(friday), DELTA);
		
	}
	
	
	@Test
	public void testUpdateEntityRank() {
		Assert.assertNull(inRecKeeper.getEntityAmtMap().get(ENTITY));
		
		inRecKeeper.updateEntityRank(trade, amountinUSD);
		
		Assert.assertEquals(amountinUSD, inRecKeeper.getEntityAmtMap().get(ENTITY), DELTA);
		
		inRecKeeper.updateEntityRank(aedTrade, amountinUSD);
		
		Assert.assertEquals(2*amountinUSD, inRecKeeper.getEntityAmtMap().get(ENTITY), DELTA);
	}
	
	@Test
	public void testCorrectSettlementDate() {
		inRecKeeper.correctSettlementDate(trade);
		Assert.assertEquals(friday, trade.getSettlementDate());
		
		inRecKeeper.correctSettlementDate(aedTrade);
		Assert.assertEquals(sunday, aedTrade.getSettlementDate());
	}
}
