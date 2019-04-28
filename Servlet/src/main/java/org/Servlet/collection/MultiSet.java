package org.Servlet.collection;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Range;
import org.Servlet.eventBus.Event;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import lombok.extern.log4j.Log4j;
//@Log4j
public class MultiSet {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Test
	public void testList() {
		Multiset<String> set=LinkedHashMultiset.create();

	       set.setCount("a",5); //添加或删除指定元素使其在集合中的数量是count
	       System.out.println(set.count("a")); //给定元素在Multiset中的计数
	     
	       for(String el:set) {
	    	   log.info(el);
	       }
	       
	}
	
	@Test
	public void testSets() {
		Set<String> set1=new HashSet<>();
		set1.add("a");
		set1.add("c");
		Set<String> set2=new HashSet<>();
		set2.add("a");
		set2.add("b");
		SetView setV=Sets.difference(set1, set2);
		log.info(""+setV);
		setV=Sets.union(set1, set2);
		log.info(""+setV);
		setV=Sets.intersection(set1, set2);
		log.info(""+setV);
		
		Optional<Event> possibleNull = Optional.fromNullable(null);
		   possibleNull.get();
	}

/*
	@Test
	public void testRange(){
		//create a range [a,b] = { x | a <= x <= b}
		Range<Integer> range1 = Range.closed(0, 9);
		System.out.print("[0,9] : ");
		printRange(range1);
		System.out.println("5 is present: " + range1.contains(5));
		System.out.println("(1,2,3) is present: " + range1.containsAll(Ints.asList(1, 2, 3)));
		System.out.println("Lower Bound: " + range1.lowerEndpoint());
		System.out.println("Upper Bound: " + range1.upperEndpoint());

		//create a range (a,b) = { x | a < x < b}
		Range<Integer> range2 = Range.open(0, 9);
		System.out.print("(0,9) : ");
		printRange(range2);

		//create a range (a,b] = { x | a < x <= b}
		Range<Integer> range3 = Range.openClosed(0, 9);
		System.out.print("(0,9] : ");
		printRange(range3);

		//create a range [a,b) = { x | a <= x < b}
		Range<Integer> range4 = Range.closedOpen(0, 9);
		System.out.print("[0,9) : ");
		printRange(range4);

		//create an open ended range (9, infinity
		Range<Integer> range5 = Range.greaterThan(9);
		System.out.println("(9,infinity) : ");
		System.out.println("Lower Bound: " + range5.lowerEndpoint());
		System.out.println("Upper Bound present: " + range5.hasUpperBound());

		Range<Integer> range6 = Range.closed(3, 5);
		printRange(range6);

		//check a subrange [3,5] in [0,9]
		System.out.println("[0,9] encloses [3,5]:" + range1.encloses(range6));

		Range<Integer> range7 = Range.closed(9, 20);
		printRange(range7);
		//check ranges to be connected
		System.out.println("[0,9] is connected [9,20]:" + range1.isConnected(range7));

		Range<Integer> range8 = Range.closed(5, 15);

		//intersection
		printRange(range1.intersection(range8));

		//span
		printRange(range1.span(range8));
	}

	private void printRange(Range<Integer> range){
		System.out.print("[ ");
		for(int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
			System.out.print(grade +" ");
		}
		System.out.println("]");
	}*/
}
