package sample;

import java.time.LocalDate;
import java.util.Date;

public class Found extends Category  {
private String location;


	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	LocalDate date;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	Person person;
	
	public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

	public Found(LocalDate date, String location, Person person)
	{
		super(date);

		//super(date);
		setLocation(location);
		setPerson(person);
		
	}
	
	public String toString()
	{
		return "Animal found in "+getLocation()+" on this date "+getDate()+"  "+getPerson();
	}
	public void print()
	{
		System.out.println(toString());
	}
}
