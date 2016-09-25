package sample;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.Image;
import java.io.Serializable;

public class Animal implements Serializable {

    public static int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int ID=0;
    private int age;
    private String aType;
    private String colour;
    private boolean gender;
    private String description;
    private String name;
    private Image picture;
    private String breed;

    Category animalCat;

    public Animal(String name, String breed,int age,String description,String value,String colour,String aType,Category animalCat)
    {if(value.equals("Male"))
    {
        gender=true;
        setGender(gender);
    }
        setAge(age);
        setColour(colour);
        setName(name);

        setAType(aType);
        setDesciption(description);
        setBreed(breed);
        setCata(animalCat);

        setID(ID);
        ID++;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public void setAType(String aType)
    {
        this.aType=aType;
    }
    public void setColour(String colour)
    {
        this.colour=colour;
    }
    public void setDesciption(String description)
    {
        this.description=description;
    }
    public void setBreed(String breed)
    {
        this.breed=breed;
    }
    public void setGender(Boolean gender)
    {
        this.gender=gender;
    }
    public void setCata(Category animalCat)
    {


        this.animalCat=animalCat;
    }


    public Category getCata()
    {
        return animalCat;
    }
    public Boolean getGender()
    {
        return gender;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getAType()
    {
        return aType;
    }
    public String getColour()
    {
        return colour;
    }
    public String getDesciption()
    {
        return description;
    }
    public String getBreed()
    {
        return breed;
    }

    public String toString()
    {
        return "The animal is a "+getAType()+" .Its name is "+getName()+",its age is "+getAge()+" ,its breed is "+getBreed()+" ,it's colour is "+getColour()+". Its category is \n"
                +getCata()+" ,its gender is "+getGender()+" and its description is"+getDesciption()+" and the their ID is"+getID()+"\n";
    }
    public void print()
    {
        System.out.println(toString());
    }
}
