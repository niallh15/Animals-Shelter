package sample;

import java.time.LocalDate;
import java.util.Date;

public class Adoption extends Category  {
	private boolean neutered;
	private boolean chipped;
	private boolean vaccinated;
	private String status;
	private boolean reserved;

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	LocalDate date;

	public boolean isNeutered() {
		return neutered;
	}

	public void setNeutered(boolean neutered) {
		this.neutered = neutered;
	}

	public boolean isChipped() {
		return chipped;
	}

	public void setChipped(boolean chipped) {
		this.chipped = chipped;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}


	
	public Adoption(String status, LocalDate date, boolean chipped, boolean neutered, boolean vaccinated, boolean reserved)
	{
		super(date);
		setChipped(chipped);
		setNeutered(neutered);
		setReserved(reserved);
		setVaccinated(vaccinated);
		setStatus(status);
	}
	public String toString()
	{
		return "Animal was adopted on this date "+date+
				"\n the animal is chipped "+isChipped()+
		"\n the animal is neutered"+isNeutered()
				+"\n the animal is "+isReserved()
		+"\n the animal is chipped "+isVaccinated()
				+"\n the animals status is"+getStatus();

	}
	public void print()
	{
		System.out.println(toString());
	}
}
