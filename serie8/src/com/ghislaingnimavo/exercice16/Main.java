package com.ghislaingnimavo.exercice16;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		PersonWriter pw = new PersonWriter();
		PersonReader pr = new PersonReader();
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("Maysa","Morais",29);
		Person p2 = new Person("Gnimavo","Ghislain",29);
		Person p3 = new Person("Ngala","Stephane",62);
		
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		pw.writeBinaryFields(people,"files/Binary");

		List<Person> people2 = new ArrayList<Person>();
		people2 = pr.readBinaryFields("files/Binary");
		people2.forEach(person->System.out.println(person));
		

		
		
		
	}

}