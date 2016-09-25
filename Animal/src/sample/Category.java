package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Category implements Serializable {
	//private
	Person contact;

	public void setDate(LocalDate date) {
		this.date = date;
	}

	LocalDate date;

	public Category(Date date) {
	}


	public Person getContact() {
		return contact;
	}
	public void setContact(Person contact) {
		this.contact = contact;
	}
	public LocalDate getDate() {
		return date;
	}

	public Category(LocalDate date){
		setDate(date);
		setContact(contact);

	}
	public String toString()
	{
		return getContact()+""+getDate();
	}
	public void print()
	{
		System.out.println(toString());
	}
}
