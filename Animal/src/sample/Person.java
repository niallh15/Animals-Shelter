package sample;

import java.io.Serializable;

public class Person implements Serializable {

	String name;
	String address;
	String phone;
	String email;

	public Person(String name,String address,String phone,String email)
	{
		setName(name);
		setAddress(address);
		setPhone(phone);
		setEmail(email);
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getName()
	{
		return name;
		
	}
	public String getAddress()
	{
		return address;
		
	}
	public String getPhone()
	{
		return phone;
		
	}
	public String getEmail()
	{
		return email;
		
	}
	public String toString()
	{
		return "The persons name is "+getName()+" and their address is "+getAddress()+".Their phone number is "+getPhone()+" and their email is "+getEmail()+"\n";
	}
	public void print()
	{
		System.out.println(toString());
	}
}
