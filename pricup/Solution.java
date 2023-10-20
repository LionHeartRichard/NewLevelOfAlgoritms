/*
 * Это решение сХожей задачи - НЕ МОЕ - взял с leetCode
 * но в данном примере можно совершать количество покупок = k
 * и выХодные данные другие - выдает максималную сумму
 * переоринтировать под свою задачу не вышло
 * оставил тут для дальнейшего изучения...
 */

package com.isaev.contest.pricup;

import java.util.Arrays;

public class Solution {

	public int maxPro(int[] prices, int index, int k, int buy, int dp[][][]) {
		if (k == 0 || index >= prices.length) {
			return 0;
		}
		if (dp[index][k - 1][buy] != -1) {
			return dp[index][k - 1][buy];
		}

		if (buy == 1) {
			dp[index][k - 1][buy] = Math.max(prices[index] + maxPro(prices, index + 1, k - 1, 0, dp),
					maxPro(prices, index + 1, k, 1, dp));
		} else {
			dp[index][k - 1][buy] = Math.max(-prices[index] + maxPro(prices, index + 1, k, 1, dp),
					maxPro(prices, index + 1, k, 0, dp));
		}

		return dp[index][k - 1][buy];

	}

	public int maxProfit(int k, int[] prices) {

		int dp[][][] = new int[prices.length][k][2];
		for (int[][] d1 : dp) {
			for (int[] d2 : d1) {
				Arrays.fill(d2, -1);
			}
		}
		maxPro(prices, 0, k, 0, dp);
		return dp[0][k - 1][0];
	}

	public int[][][] maxProfitGetMas(int k, int[] prices) {

		int dp[][][] = new int[prices.length][k][2];
		for (int[][] d1 : dp) {
			for (int[] d2 : d1) {
				Arrays.fill(d2, -1);
			}
		}
		maxPro(prices, 0, k, 0, dp);
		return dp;
	}

}
