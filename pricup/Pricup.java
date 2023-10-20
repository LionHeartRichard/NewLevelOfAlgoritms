/*
 * планировался алгоритм разделяй и властвуй
 * поэтому закешировал сет
 * но по итогу не смог придумать достойный рекурсивный алгоритм с последующим слиянием данныХ
 * поэтому использовал другой подХод который более читаемый и понятный
 */

package com.isaev.contest.pricup;

import java.util.Set;
import java.util.HashSet;

public class Pricup {

	private static Set<Broker> setCash = new HashSet<Broker>();

	private static Set<Broker> getResult(Set<Broker> set) {
		Set<Broker> copy = new HashSet<Broker>(set);
		int maxMoney = -1;
		Broker max1 = new Broker();
		Broker max2 = new Broker();
		for (Broker b : set) {
			if (b.getMoney() > maxMoney) {
				max1 = b;
				maxMoney = b.getMoney();
			}
		}
		for (Broker a : set) {
			for (Broker b : copy) {
				if (a != b) {
					if ((a.getBuy() < b.getBuy() && a.getSale() < b.getBuy())
							|| (a.getBuy() > b.getSale() && a.getSale() > b.getSale())) {
						if (a.getMoney() + b.getMoney() > maxMoney) {
							max1 = a;
							max2 = b;
							maxMoney = a.getMoney() + b.getMoney();
						}
					}
				}
			}
		}
		Set<Broker> result = new HashSet<Broker>();
		if (max1 != null) {
			result.add(max1);
		}
		if (max2 != null) {
			result.add(max2);
		}
		return result;
	}

	public static Set<Broker> getSetBroker(int[] mas) {
		setCash.clear();
		int begin = 0;
		int end = mas.length;
		while (begin < end) {
			getBroker(mas, begin, end);
			begin++;
		}
		begin = 0;
		while (begin < end) {
			getBroker(mas, begin, end);
			end--;
		}
		return setCash = getResult(setCash);
	}

	private static void getBroker(int[] mas, int begin, int end) {

		Broker broker = new Broker();
		int max = -1;
		int min = Integer.MAX_VALUE;
		int j = -1, k = -1;

		for (int i = begin; i < end; i++) {
			if (mas[i] > max) {
				max = mas[i];
				j = i;
			}
		}

		for (int i = begin; i < end; i++) {
			if (mas[i] < min && j > i) {
				min = mas[i];
				k = i;
			}
		}

		if (max > min) {
			broker.setBuy(k);
			broker.setMoneyBuy(mas[k]);
			broker.setSale(j);
			broker.setMoneySale(mas[j]);

			setCash.add(broker);
		}
	}

}
