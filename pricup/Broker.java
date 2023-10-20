/*
 * класс для Хранения дней купли продажи, сумм акций в этот день 
 */

package com.isaev.contest.pricup;

import java.util.Objects;

public class Broker {

	private int buy;
	private int sale;
	private int moneyBuy;
	private int moneySale;

	public Broker() {
	}

	public Broker(int buy, int sale, int moneyBuy, int moneySale) {
		super();
		this.buy = buy;
		this.sale = sale;
		this.moneyBuy = moneyBuy;
		this.moneySale = moneySale;
	}

	@Override
	public String toString() {
		return "Broker [buy=" + buy + ", sale=" + sale + ", moneyBuy=" + moneyBuy + ", moneySale=" + moneySale + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(buy, sale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Broker other = (Broker) obj;
		return buy == other.buy && sale == other.sale;
	}

	public int getBuy() {
		return buy;
	}

	public void setBuy(int buy) {
		this.buy = buy;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getMoneyBuy() {
		return moneyBuy;
	}

	public void setMoneyBuy(int moneyBuy) {
		this.moneyBuy = moneyBuy;
	}

	public int getMoneySale() {
		return moneySale;
	}

	public void setMoneySale(int moneySale) {
		this.moneySale = moneySale;
	}

	public int getMoney() {
		return this.moneySale - this.moneyBuy;
	}

}
