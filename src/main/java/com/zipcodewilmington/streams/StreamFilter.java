package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
	private final Stream<Person> personStream;
	public final String startingCharacter;

	/**
	 * No arg constructor
	 */ //TODO - construct person stream of 100 person objects; 
	//startingCharacter is a random capital letter
	public StreamFilter() {	
		this.personStream = PersonFactory.createPersonStream(100);
		this.startingCharacter = RandomUtils.createCharacter('A', 'Z').toString();
		}

	/**
	 * @param people - Array of person objects
	 * @param startingCharacter - character to filter by
	 */ //TODO
	public StreamFilter(Person[] people, Character startingCharacter) {
		this(Arrays.stream(people), startingCharacter);
	}

	/**
	 * @param people - List of person objects
	 * @param startingCharacter - character to filter by
	 */ //TODO
	public StreamFilter(List<Person> people, Character startingCharacter) {
		this(people.stream(), startingCharacter);
	}


	/**
	 * @param people - Stream of person objects
	 * @param startingCharacter - character to filter by
	 */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
	public StreamFilter(Stream<Person> people, Character startingCharacter) {
		this.personStream = people;
		this.startingCharacter = startingCharacter.toString();
	}


	/**
	 * Using multi-line lambda syntax
	 * @return a list of person object whose name starts with `this.startingCharacter`
	 */ //TODO
	public List<Person> toListMultiLine() {
		return this
		.personStream
		.filter(p -> p.name.substring(0, 1)==startingCharacter)
		.collect(Collectors.toList());
	}


	/**
	 * Using one-line lambda syntax
	 * @return a list of person objects whose name starts with `this.startingCharacter`
	 */ //TODO
	public List<Person> toListOneLine() {
		return toListMultiLine();
	}


	/**
	 * Using one-line lambda syntax
	 * @return an array of person object whose name starts with `this.startingCharacter`
	 */ //TODO
	public Person[] toArrayOneLine() {
		return toArrayMultiLine();
	}


	/**
	 * Using multi-line lambda syntax
	 * @return an array of person object whose name starts with `this.startingCharacter`
	 */ //TODO
	public Person[] toArrayMultiLine() {
		int size = (int) personStream
				.filter(p -> p.name.substring(0, 1)==startingCharacter)
				.count();
		return this.personStream
				.filter(p -> p.name.substring(0, 1)==startingCharacter)
				.toArray(s -> new Person[size]);
	}

}
