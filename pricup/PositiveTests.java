/*
 * Задача из "Яндекс контест" лето 2023
 * Дано стоимость акций - в виде массивов, нужно произвести 1-2 купли-продажи
 * С наилучшим результатом
 */
package com.isaev.contest.pricup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class PositiveTests {
	@Test
	public void test1() {
		int[] mas = new int[] { 1, 4, 2, 3, 3, 5 };
		Set<Broker> set = Pricup.getSetBroker(mas);
		Set<Broker> expectedSet = new HashSet<Broker>();
		expectedSet.add(new Broker(0, 1, 1, 4));
		expectedSet.add(new Broker(2, 5, 2, 5));
		assertEquals(expectedSet, set);
	}

	@Test
	public void test2() {
		int[] mas = new int[] { 3, 2, 2 };
		Set<Broker> set = Pricup.getSetBroker(mas);
		Set<Broker> expectedSet = new HashSet<Broker>();
		expectedSet.add(new Broker(0, 0, 0, 0));
		assertEquals(expectedSet, set);
	}

	@Test
	public void test3() {
		int[] mas = new int[] { 3, 5, 9, 10, 2, 3, 29, 1, 2, 4, 5, 1, 22 };
		Set<Broker> set = Pricup.getSetBroker(mas);
		Set<Broker> expectedSet = new HashSet<Broker>();
		expectedSet.add(new Broker(4, 6, 2, 29));
		expectedSet.add(new Broker(11, 12, 1, 22));
		assertEquals(expectedSet, set);
	}

	@Test
	public void test4() {
		int[] mas = new int[] { 10, 5, 5, 7, 6 };
		Set<Broker> set = Pricup.getSetBroker(mas);
		Set<Broker> expectedSet = new HashSet<Broker>();
		expectedSet.add(new Broker(0, 0, 0, 0));
		expectedSet.add(new Broker(2, 3, 5, 7));
		assertEquals(expectedSet, set);
	}

	@Test
	public void test5() {
		int[] mas = new int[] { 3, 4, 6, 5, 7, 9, 1 };
		Set<Broker> set = Pricup.getSetBroker(mas);
		Set<Broker> expectedSet = new HashSet<Broker>();

		expectedSet.add(new Broker(3, 5, 5, 9));
		expectedSet.add(new Broker(0, 2, 3, 6));

		assertEquals(expectedSet, set);
	}

	@Test
	public void test6() {
		int[] mas = new int[] { 5, 6, 7, 9, 8, 9, 12, 11, 13, 14, 13, 11, 15, 4, 5, 7 };
		Set<Broker> set = Pricup.getSetBroker(mas);
		Set<Broker> expectedSet = new HashSet<>();
		expectedSet.add(new Broker(11, 12, 11, 15));
		expectedSet.add(new Broker(0, 9, 5, 14));
		assertEquals(expectedSet, set);
	}

	@Test
	public void test7() {
		int[] mas = new int[] { 6, 7, 5, 8, 10, 8, 9, 12, 9 };
		Set<Broker> set = Pricup.getSetBroker(mas);
		Set<Broker> expectedSet = new HashSet<>();
		expectedSet.add(new Broker(5, 7, 8, 12));
		expectedSet.add(new Broker(2, 4, 5, 10));
		assertEquals(expectedSet, set);
	}

}
