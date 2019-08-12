package com.tw.apistackbase;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class CompareTest {
	Compare compareControl = new Compare();
	@Test
	public void testWhenEasiest(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("6C");
		Puke p3 = new Puke ("9H");
		Puke p4 = new Puke ("TH");
		Puke p5 = new Puke ("KH");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("3H");
		Puke q3 = new Puke ("9H");
		Puke q4 = new Puke ("5C");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		 String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenEasiest2(){
		Puke p1 = new Puke ("3H");
		Puke p2 = new Puke ("AC");
		Puke p3 = new Puke ("2H");
		Puke p4 = new Puke ("4H");
		Puke p5 = new Puke ("KH");

		Puke q1 = new Puke ("4H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("TH");
		Puke q4 = new Puke ("JC");
		Puke q5 = new Puke ("QH");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenHavePair(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("6C");
		Puke p3 = new Puke ("9H");
		Puke p4 = new Puke ("TH");
		Puke p5 = new Puke ("KH");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("9H");
		Puke q4 = new Puke ("5C");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	@Test
	public void testWhenAllHavePair(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("5C");
		Puke p3 = new Puke ("9H");
		Puke p4 = new Puke ("TH");
		Puke p5 = new Puke ("KH");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("9H");
		Puke q4 = new Puke ("5C");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenHaveTwoPair(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("5C");
		Puke p3 = new Puke ("9H");
		Puke p4 = new Puke ("TH");
		Puke p5 = new Puke ("KH");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("4H");
		Puke q4 = new Puke ("4C");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	@Test
	public void testWhenAllHaveTwoPair(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("5C");
		Puke p3 = new Puke ("9H");
		Puke p4 = new Puke ("TH");
		Puke p5 = new Puke ("TH");

		Puke q1 = new Puke ("5H");
		Puke q2 = new Puke ("5H");
		Puke q3 = new Puke ("TH");
		Puke q4 = new Puke ("TC");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenAllHaveThreeSame(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("5C");
		Puke p3 = new Puke ("5H");
		Puke p4 = new Puke ("TH");
		Puke p5 = new Puke ("KH");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("9H");
		Puke q4 = new Puke ("9C");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenAllHaveStraight(){
		Puke p1 = new Puke ("2H");
		Puke p2 = new Puke ("3C");
		Puke p3 = new Puke ("4H");
		Puke p4 = new Puke ("5H");
		Puke p5 = new Puke ("6H");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("2C");
		Puke q4 = new Puke ("4H");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenAllHaveStraight2(){
		Puke p1 = new Puke ("2H");
		Puke p2 = new Puke ("3C");
		Puke p3 = new Puke ("4H");
		Puke p4 = new Puke ("5H");
		Puke p5 = new Puke ("6H");

		Puke q1 = new Puke ("TH");
		Puke q2 = new Puke ("JH");
		Puke q3 = new Puke ("9C");
		Puke q4 = new Puke ("QH");
		Puke q5 = new Puke ("KH");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	@Test
	public void testWhenAllHaveSamePattern(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("6C");
		Puke p3 = new Puke ("7H");
		Puke p4 = new Puke ("8H");
		Puke p5 = new Puke ("9H");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("2H");
		Puke q4 = new Puke ("4H");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	@Test
	public void testWhenAllHaveSamePattern2(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("6C");
		Puke p3 = new Puke ("7H");
		Puke p4 = new Puke ("8H");
		Puke p5 = new Puke ("9H");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("KH");
		Puke q3 = new Puke ("JH");
		Puke q4 = new Puke ("4H");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	@Test
	public void testWhenAllHaveThreeAndPair(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("5C");
		Puke p3 = new Puke ("5H");
		Puke p4 = new Puke ("8H");
		Puke p5 = new Puke ("8H");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("2H");
		Puke q4 = new Puke ("4H");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenAllHaveThreeAndPair2(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("5C");
		Puke p3 = new Puke ("5H");
		Puke p4 = new Puke ("8H");
		Puke p5 = new Puke ("8H");

		Puke q1 = new Puke ("5H");
		Puke q2 = new Puke ("5H");
		Puke q3 = new Puke ("5H");
		Puke q4 = new Puke ("TH");
		Puke q5 = new Puke ("TH");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	@Test
	public void testWhenAllHaveFour(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("5H");
		Puke p3 = new Puke ("5H");
		Puke p4 = new Puke ("8H");
		Puke p5 = new Puke ("8H");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("2H");
		Puke q4 = new Puke ("2H");
		Puke q5 = new Puke ("6K");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	@Test
	public void testWhenAllHaveStraightPattern(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("6H");
		Puke p3 = new Puke ("7H");
		Puke p4 = new Puke ("8H");
		Puke p5 = new Puke ("9H");

		Puke q1 = new Puke ("2H");
		Puke q2 = new Puke ("2H");
		Puke q3 = new Puke ("2H");
		Puke q4 = new Puke ("2H");
		Puke q5 = new Puke ("6H");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The first win!" ,result);
	}
	@Test
	public void testWhenAllHaveStraightPattern2(){
		Puke p1 = new Puke ("5H");
		Puke p2 = new Puke ("6H");
		Puke p3 = new Puke ("7H");
		Puke p4 = new Puke ("8H");
		Puke p5 = new Puke ("9H");

		Puke q1 = new Puke ("7H");
		Puke q2 = new Puke ("9H");
		Puke q3 = new Puke ("8H");
		Puke q4 = new Puke ("JH");
		Puke q5 = new Puke ("TH");
		List<Puke> first = new ArrayList<Puke>();
		List<Puke> second = new ArrayList<Puke>();;
		first.add(p1);
		first.add(p2);
		first.add(p3);
		first.add(p4);
		first.add(p5);
		second.add(q1);
		second.add(q2);
		second.add(q3);
		second.add(q4);
		second.add(q5);
		String result = compareControl.whoWin(first,second);
		Assert.assertEquals("The second win!" ,result);
	}
	}


