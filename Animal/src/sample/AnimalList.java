package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class AnimalList {


	public static ArrayList<Animal> getAnimal() {
		return animalAll;
	}
	public static ArrayList<Animal> getFoundAnimal() {
		return animalFound;
	}

	public static void setAnimal(ArrayList<Animal> animal) {
		AnimalList.animalAll = animal;
	}

	private static	ArrayList<Animal> animalAll = new ArrayList<Animal>();

	public static ArrayList<Animal> getAnimalLost() {
		return animalLost;
	}

	public static void setAnimalLost(ArrayList<Animal> animalLost) {
		AnimalList.animalLost = animalLost;
	}

	private static	ArrayList<Animal> animalLost = new ArrayList<Animal>();

	public static void setAnimalFound(ArrayList<Animal> animalFound) {
		AnimalList.animalFound = animalFound;
	}

	private static	ArrayList<Animal> animalFound = new ArrayList<Animal>();
    private static	ArrayList<Animal> animalAdopted = new ArrayList<Animal>();

	public static ArrayList<Animal> getAnimalAdopted() {
		return animalAdopted;
	}

	public static void setAnimalAdopted(ArrayList<Animal> animalAdopted) {
		AnimalList.animalAdopted = animalAdopted;
	}

	public AnimalList()
	{
		setAnimalAdopted(animalAdopted);
		setAnimal(animalAll);
		setAnimalFound(animalFound);
		setAnimalLost(animalLost);

	}

	public static int size()
	{
		return animalAll.size();
	}

    public static void addAnimal(Animal animals)
    {

                animalAll.add(animals);

    }


	public static void remove(String myAnimal){
		for(int i =0; i<animalLost.size();i++)
		{
			String name=animalLost.get(i).getName();
			if(name.equals(myAnimal));
			//animalAll.remove();
		}
	}
	public static void removeFound(String animal){
		for(int i =0; i<animalFound.size();i++)
		{
			String name=animalFound.get(i).getName();
			if(name.equals(animal)) {
				animalFound.remove(i);
			}
		}
	}
	public static void removeLost(String animal){
		for(int i =0; i<animalLost.size();i++)
		{
			String name=animalLost.get(i).getName();
			if(name.equals(animal)) {
				animalLost.remove(i);
			}
		}

	}
	public static void removeAdopted(String myAnimal){
		Animal animal= null;

			animalAdopted.remove(animal.getName().equals(myAnimal));

	}
	public static void addLostList(Animal animal)
	{

                animalLost.add(animal);

	}
	public static void addFoundList(Animal animal)
	{


                animalFound.add(animal);



	}
	public static void addAdoptedList(Animal animal)
	{


                animalAdopted.add(animal);


	}
    public static void printListCata()
    {

        for(Animal animals:animalLost)
        {
            animals.print();
        }

    }

	public static void printListFound()
	{

		for(Animal animals:animalFound)
		{
			animals.print();
		}

	}
	public static void printListLost()
	{

		for(Animal animals:animalLost)
		{
			animals.print();
		}

	}
	public static void printListAdopted()
	{

		for(Animal animals:animalAdopted)
		{
			animals.print();
		}

	}

	public static ArrayList sortName(){
		Collections.sort(animalAdopted, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
		return  animalAdopted;
	}

	public static ArrayList sortAge(){
		Collections.sort(animalAdopted, (a, b) -> a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1);
		return animalAdopted;
	}


	public static ArrayList sortGender(){
		Collections.sort(animalAdopted, (a, b) -> (a.getGender() == true && b.getGender() == false ? -1 : a.getGender() == b.getGender() ? 0 : 1));
		return  animalAdopted;
	}
	public static ArrayList sortGenderFound(){
		Collections.sort(animalFound, (a, b) -> (a.getGender() == true && b.getGender() == false ? -1 : a.getGender() == b.getGender() ? 0 : 1));
		return  animalFound;
	}
	public static ArrayList sortAgeAll(){
		Collections.sort(animalAll, (a, b) -> a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1);
		return animalAll;
	}
	public static void writeFile() throws IOException {
		ArrayList<Animal> animal = AnimalList.getAnimalLost();
		try
		{
			FileOutputStream fileOut = new FileOutputStream("lost.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

				out.writeObject(animal);

			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in lost.txt");
		}catch(IOException i)
		{
			i.printStackTrace();
		}


	}
	public static void readFile() throws IOException{
		ArrayList<Animal> animal = AnimalList.getAnimalLost();
		try
		{
			FileInputStream fileIn = new FileInputStream("lost.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			animal = (ArrayList<Animal>) in.readObject();
			in.close();
			fileIn.close();
			animalLost=animal;
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("class not found");
			c.printStackTrace();
			return;
		}
	}
	public static void writeFileFound() throws IOException {
		ArrayList<Animal> animal = AnimalList.getFoundAnimal();
		try
		{
			FileOutputStream fileOut = new FileOutputStream("found.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(animal);

			out.close();
			fileOut.close();
			System.out.printf("\nSerialized data is saved in found.txt");
		}catch(IOException i)
		{
			i.printStackTrace();
		}


	}
	public static void readFileFound() throws IOException{
		ArrayList<Animal> animal = AnimalList.getFoundAnimal();
		try
		{
			FileInputStream fileIn = new FileInputStream("found.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			animal = (ArrayList<Animal>) in.readObject();
			in.close();
			fileIn.close();
			animalFound=animal;
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("class not found");
			c.printStackTrace();
			return;
		}
	}
	public static void writeFileAdopted() throws IOException {
		ArrayList<Animal> animal = AnimalList.getFoundAnimal();
		try
		{
			FileOutputStream fileOut = new FileOutputStream("adopted.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(animal);

			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in adopted.txt");
		}catch(IOException i)
		{
			i.printStackTrace();
		}


	}
	public static void readFileAdopted() throws IOException{
		ArrayList<Animal> animal = AnimalList.getAnimalAdopted();
		try
		{
			FileInputStream fileIn = new FileInputStream("adopted.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			animal = (ArrayList<Animal>) in.readObject();
			in.close();
			fileIn.close();
			animalAdopted=animal;
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("class not adopted");
			c.printStackTrace();
			return;
		}
	}
	public static void writeFileAll() throws IOException {
		ArrayList<Animal> animal = AnimalList.getAnimal();
		try
		{
			FileOutputStream fileOut = new FileOutputStream("animals.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(animal);

			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in animals.txt");
		}catch(IOException i)
		{
			i.printStackTrace();
		}


	}
	public static void readFileAll() throws IOException{
		ArrayList<Animal> animal = AnimalList.getAnimal();
		try
		{
			FileInputStream fileIn = new FileInputStream("animals.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			animal = (ArrayList<Animal>) in.readObject();
			in.close();
			fileIn.close();
			animalAll=animal;
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("class not found");
			c.printStackTrace();
			return;
		}
	}

}
