package sample;

import java.time.LocalDate;
import java.util.Date;

public class Lost extends Category {
	private String location;
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Lost(LocalDate date, String location, Person person)
	{
		super(date);
		setLocation(location);
		setContact(person);
		
	}
	

	public String toString()
	{
		return "Animal lost in "+getLocation()+" on this date "+getDate();
	}
	public void print()
	{
		System.out.println(toString());
	}
}
