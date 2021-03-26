package com.ghislaingnimavo.exercice17;


import java.util.ArrayList;
import java.util.List;



public class Main {

	public static void main(String[] args) {
		PersonWriter pw = new PersonWriter();
		PersonReader pr = new PersonReader();
		List<Person> people = new ArrayList<Person>();
		List<Person> people2= new ArrayList<Person>();
		Person p1 = new Person("Gnimavo","Ghislain",23);
		Person p2 = new Person("Ngala","Stéphane",22);
		
		people.add(p1);
		people.add(p2);
	
		pw.writeBinaryObject(people,"files/Binaryobject");

		people2 = pr.readBinaryObject("files/Binaryobject");
		people2.forEach(person->System.out.println(person));
		

	}

}
