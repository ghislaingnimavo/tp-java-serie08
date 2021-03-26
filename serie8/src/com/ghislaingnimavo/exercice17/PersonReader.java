package com.ghislaingnimavo.exercice17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
	public List<Person> readBinaryObject(String fileName) {
		List<Person> people = new ArrayList<Person>();
		int nbPeople,i=0;
		//System.out.println("ok");

		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);)
		{
			nbPeople = ois.readInt();// Le nombre de personnes contenue dans le fichier
			System.out.println(nbPeople);
			Person p;
			 for(i=0;i<nbPeople;i++)
			 {
				try
				{
					p = (Person) ois.readObject();
					people.add(p);
				} 
				catch (IOException e) 
				{
				     System.out.println(e.getMessage());
				}
			 }
		}
		 
		
		catch (IOException | ClassNotFoundException e) {
		     System.out.println(e.getMessage());

		}
		return people;
	}
}
