package sample;

import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;


import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main extends Application {

    static ArrayList<Person> people = new ArrayList<Person>();
    String name;
    private Stage window;
    private Scene sceneHome;
    String cata;
    TableView<Animal> table;
    TextField personName2;
    TextField personAddress2;
    TextField animalType;
    TextField breed2;
    private TextField descrText;
    Category cata2;
    LocalDate date;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        sceneHome = new Scene(layout(), 1500, 750);

        sceneHome.getStylesheets().add("style.css");
        window.setScene(sceneHome);


        window.setTitle("Niall Animal Shelter");
        window.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    public BorderPane layout() throws IOException {

        BorderPane border = new BorderPane();

        File file = new File("doge.jpg");
        Image image = new Image(file.toURI().toString());


        Menu fileMenu = new Menu("File");


        MenuItem home = new MenuItem("Home");
        fileMenu.setOnAction(e -> border.setCenter(homePane()));
        fileMenu.getItems().add(home);
        MenuItem save = new MenuItem("Save");
        save.setOnAction(e ->{
            try {
                writeFileAll();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.writeFileAll();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.writeFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.writeFileAdopted();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.writeFileFound();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        fileMenu.getItems().add(save);

        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem load =new MenuItem("Load");
        load.setOnAction(e ->{
            try {
                readFileAll();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.readFileAll();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.readFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.readFileAdopted();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                AnimalList.readFileFound();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        fileMenu.getItems().add(load);
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
            closeProgram();
        });
        fileMenu.getItems().add(exit);


        Menu foundMenu = new Menu("Found");
        MenuItem addRemove = new MenuItem("Add/Remove");
        addRemove.setOnAction(e -> {


            cata = "Found ";
            border.setCenter(addGridPaneAnimal(border, cata));
        });
        foundMenu.getItems().add(addRemove);

        GridPane grid2 = new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(0, 10, 0, 10));

        MenuItem foundDisplay = new MenuItem("Displayfound");
        foundDisplay.setOnAction(e -> {
            cata = "Display Found Table";
            border.setCenter(displayFound(border));

        });
        foundMenu.getItems().add(foundDisplay);

        Menu lostMenu = new Menu("Lost");

        GridPane grid3 = new GridPane();
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(0, 10, 0, 10));


        MenuItem lostAdd = new MenuItem("lost add/remove");
        lostAdd.setOnAction(e -> {
            cata = "Lost";
            border.setCenter(addGridPaneAnimal(border, cata));
        });
        lostMenu.getItems().add(lostAdd);

        MenuItem lostDisplay = new MenuItem("Display lost");
        lostDisplay.setOnAction(e -> border.setCenter(displayLost(border)));
        lostMenu.getItems().add(lostDisplay);


        Menu adoptedMenu = new Menu("Adopted");
        MenuItem adoptedAdd = new MenuItem("Adopted Add/remove");
        adoptedAdd.setOnAction(e -> {
            cata = "adopted";
            border.setCenter(addGridPaneAnimalAdopted(border, cata));
        });
        adoptedMenu.getItems().add(adoptedAdd);

        MenuItem adoptedDisplay = new MenuItem("Adopted display");
        adoptedDisplay.setOnAction(e -> border.setCenter(displayAdopted(border)));
        adoptedMenu.getItems().add(adoptedDisplay);

        Menu generalMenu = new Menu("General Reports");
        MenuItem display = new MenuItem("Display general");
        display.setOnAction(e -> border.setCenter(displayGeneral(border)));
        generalMenu.getItems().add(display);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, foundMenu, lostMenu, adoptedMenu, generalMenu);
        border.setTop(menuBar);

        ImageView theImageView = new ImageView(image);
        theImageView.setFitHeight(720);
        theImageView.setFitWidth(1400);
        border.setCenter(theImageView);


        //This is the main set up for the basic animal questions


        return border;
    }

    private void closeProgram() {
        window.close();
    }

    public GridPane addGridPane(BorderPane border, LocalDate date, String locale, String catagory, String value, String name, String breed2, int age, String descr, String animalColour, String animalType) {

        GridPane personGrid = new GridPane();
        personGrid.setHgap(10);
        personGrid.setVgap(10);
        personGrid.setPadding(new Insets(0, 10, 0, 10));

       /* BackgroundImage myBI= new BackgroundImage(new Image("catdog.jpg",1400,720,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
//then you set to your node
        personGrid.setBackground(new Background(myBI));
*/
        Text welcomePerson = new Text("Add Person details");
        welcomePerson.setFont(Font.font("Vivaldi", FontWeight.BOLD, 48));
        welcomePerson.setFill(Color.WHITE);
        personGrid.add(welcomePerson, 5, 1);

        Text personName = new Text("Enter the persons name: ");
        personName.setFont(Font.font("Arial", 30));
        personName.setFill(Color.WHITE);
        personName2 = new TextField();
        personGrid.add(personName, 3, 3);
        personGrid.add(personName2, 3, 4);


        Text personAddress = new Text("Enter the persons address: ");
        personAddress.setFont(Font.font("Arial", 30));
        personAddress.setFill(Color.WHITE);
        personAddress2 = new TextField();
        personGrid.add(personAddress, 3, 6);
        personGrid.add(personAddress2, 3, 7);

        Text personPhone = new Text("Enter the persons phone: ");
        personPhone.setFont(Font.font("Arial", 30));
        personPhone.setFill(Color.WHITE);
        TextField personPhone2 = new TextField();
        personGrid.add(personPhone, 3, 9);
        personGrid.add(personPhone2, 3, 10);

        Text personEmail = new Text("Enter in the person email: ");
        personEmail.setFont(Font.font("Arial", 30));
        personEmail.setFill(Color.WHITE);
        TextField personEmail2 = new TextField();
        personGrid.add(personEmail, 3, 12);
        personGrid.add(personEmail2, 3, 13);


        System.out.print(catagory);
        System.out.print(catagory);
        if (catagory == "Found ") {
            Button buttonAdd = new Button("Add");
            personGrid.add(buttonAdd, 3, 24);

            Button buttonAddNew = new Button("Add another");
            buttonAddNew.setOnAction(e -> border.setCenter(addGridPaneAnimal(border, catagory)));

            personGrid.add(buttonAddNew,4,24);

            buttonAdd.setOnAction(e -> {
                boolean nameV=validateText(personName2.getText());
                boolean locale2=validateText(personAddress2.getText());
                boolean bree=validateText(personPhone2.getText());
                boolean desc=validateText(personEmail2.getText());
                if(nameV==true &&locale2==true&&bree==true&&desc==true) {
                    Person person = new Person(personName2.getText(), personAddress2.getText(), personPhone2.getText(), personEmail2.getText());
                    people.add(person);


                    System.out.println(person.toString());

                    cata2 = new Found(date, locale, person);
                    Animal animal = new Animal(name, breed2, age, descr, value, animalColour, animalType, cata2);
                    people.add(person);
                    AnimalList.addAnimal(animal);
                    AnimalList.addFoundList(animal);
                    AnimalList.printListFound();

                }
                else
                {
                    alert.display();
                }
            });
        } else if (catagory == "Lost") {
            Button buttonAdd = new Button("Add");

            personGrid.add(buttonAdd, 3, 24);

            Button buttonAddNew = new Button("Add another");
            buttonAddNew.setOnAction(e ->  border.setCenter(addGridPaneAnimal(border, catagory)));

            personGrid.add(buttonAddNew,4,24);
            buttonAdd.setOnAction(e -> {
                boolean nameV=validateText(personName2.getText());
                boolean locale2=validateText(personAddress2.getText());
                boolean bree=validateText(personPhone2.getText());
                boolean desc=validateText(personEmail2.getText());
                if(nameV==true &&locale2==true&&bree==true&&desc==true) {
                    Person person = new Person(personName2.getText(), personAddress2.getText(), personPhone2.getText(), personEmail2.getText());
                    people.add(person);

                    people.add(person);
                    System.out.println(person.toString());

                    cata2 = new Lost(date, locale, person);
                    Animal animal = new Animal(name, breed2, age, descr, value, animalColour, animalType, cata2);

                    AnimalList.addAnimal(animal);
                    AnimalList.addLostList(animal);
                    AnimalList.printListLost();

                }
                else{
                    alert.display();
                }
            });
        }


        return personGrid;

    }

    public GridPane homePane() {

        GridPane root = new GridPane();
        File file = new File("doge.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView theImageView = new ImageView(image);
        theImageView.setFitHeight(720);
        theImageView.setFitWidth(1400);


        root.getChildren().addAll(theImageView);


        return root;

    }

    public GridPane addGridPaneAnimal(BorderPane border, String catagory) {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        /*BackgroundImage myBI= new BackgroundImage(new Image("adventure.jpg",1400,720,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
//then you set to your node
        grid.setBackground(new Background(myBI));
*/

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        Text welcome = new Text(catagory);
        welcome.setFont(Font.font("Vivaldi", FontWeight.BOLD, 48));
        welcome.setFill(Color.WHITE);
        grid.add(welcome, 4, 1);

        Text aType = new Text("Animal Type: ");
        aType.setFont(Font.font("Arial", 30));
        aType.setFill(Color.WHITE);
        animalType = new TextField();
        grid.add(aType, 2, 3);
        grid.add(animalType, 2, 4);


        Text age = new Text("Animal age:");
        age.setFont(Font.font("Arial", 30));
        age.setFill(Color.WHITE);
        TextField animalAge = new TextField();

        grid.add(age, 5, 5);
        grid.add(animalAge, 5, 6);

        Text breed1 = new Text("Breed: ");
        breed1.setFont(Font.font("Arial", 30));
        breed1.setFill(Color.WHITE);
        breed2 = new TextField();
        grid.add(breed1, 2, 5);
        grid.add(breed2, 2, 6);

        Text name1 = new Text("Animal Name: ");
        name1.setFont(Font.font("Arial", 30));
        name1.setFill(Color.WHITE);
        TextField nameText = new TextField();

        name = nameText.getText();
        grid.add(name1, 2, 7);
        grid.add(nameText, 2, 8);

        Text descr = new Text("Description: ");
        descr.setFont(Font.font("Arial", 30));
        descr.setFill(Color.WHITE);
        descrText = new TextField();
        grid.add(descr, 5, 3);
        grid.add(descrText, 5, 4);

        Text location = new Text("Location " + catagory + ": ");
        location.setFont(Font.font("Arial", 30));
        location.setFill(Color.WHITE);
        TextField locale = new TextField();
        grid.add(location, 5, 7);
        grid.add(locale, 5, 8);

        Text gender1 = new Text("Animal gender: ");
        gender1.setFont(Font.font("Arial", 30));
        gender1.setFill(Color.WHITE);
        choiceBox.getItems().addAll("Male", "Female");
        grid.add(gender1, 2, 9);
        grid.add(choiceBox, 2, 10);

        Text colour1 = new Text("Animal Colour ");
        colour1.setFont(Font.font("Arial", 30));
        colour1.setFill(Color.WHITE);
        TextField animalColour = new TextField();
        grid.add(colour1, 5, 9);
        grid.add(animalColour, 5, 10);


        Text remove = new Text("Remove an animal: ");
        remove.setFont(Font.font("Arial", 30));
        remove.setFill(Color.WHITE);
        TextField remove1 = new TextField();
        grid.add(remove, 8, 3);
        grid.add(remove1, 8, 4);


        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(event -> {
            date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });
        grid.add(datePicker, 8, 6);


        Button goPerson = new Button("Continue to person");

        goPerson.setOnAction(e -> {
            boolean name=validateText(nameText.getText());
            boolean locale2=validateText(locale.getText());
            boolean bree=validateText(breed2.getText());
            boolean desc=validateText(descrText.getText());
            boolean type=validateText(aType.getText());
            boolean color=validateText(colour1.getText());
            boolean intCheck=isInt(animalAge.getText());
            if(name==true &&locale2==true&&bree==true&&desc==true&&type==true&&color==true&&intCheck) {
                border.setCenter(addGridPane(border, date, locale.getText(), catagory, choiceBox.getValue(), nameText.getText(), breed2.getText(), Integer.parseInt(animalAge.getText()), descrText.getText(), animalColour.getText(), animalType.getText()));
            }else
                alert.display();
        });

        grid.add(goPerson, 5, 24);


        Button buttonRemove = new Button("Remove");

        buttonRemove.setOnAction(e -> {
            if(catagory.equals("Found "))
            {
                AnimalList.removeFound(remove1.getText());
                AnimalList.remove(remove1.getText());
            }
            else if(catagory.equals("Lost")){
                AnimalList.removeLost(remove1.getText());
                AnimalList.remove(remove1.getText());
            }
        });

        grid.add(buttonRemove, 4, 24);




        return grid;

    }

    public GridPane addGridPaneAnimalAdopted(BorderPane border, String catagory) {


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        ChoiceBox<String> choiceBox = new ChoiceBox<>();


        final boolean[] vaccinated = {false};
        final boolean[] chipped2 = {false};
        final boolean[] reserved2 = {false};
        final boolean[] neutered2 = {false};


        Text welcome = new Text(catagory);
        welcome.setFont(Font.font("Vivaldi", FontWeight.BOLD, 48));
        grid.add(welcome, 4, 1);

        Text aType = new Text("Animal Type: ");
        aType.setFont(Font.font("Arial", 30));
        aType.setFill(Color.WHITE);
        animalType = new TextField();
        grid.add(aType, 2, 3);
        grid.add(animalType, 2, 4);


        Text age = new Text("Animal age:");
        age.setFont(Font.font("Arial", 30));
        age.setFill(Color.WHITE);
        TextField animalAge = new TextField();
        grid.add(age, 5, 5);
        grid.add(animalAge, 5, 6);

        Text breed1 = new Text("Breed: ");
        breed1.setFont(Font.font("Arial", 30));
        breed1.setFill(Color.WHITE);
        breed2 = new TextField();
        grid.add(breed1, 2, 5);
        grid.add(breed2, 2, 6);

        Text name1 = new Text("Animal Name: ");
        name1.setFont(Font.font("Arial", 30));
        name1.setFill(Color.WHITE);
        TextField nameText = new TextField();
        name = nameText.getText();
        grid.add(name1, 2, 7);
        grid.add(nameText, 2, 8);

        Text descr = new Text("Description: ");
        descr.setFont(Font.font("Arial", 30));
        descr.setFill(Color.WHITE);
        descrText = new TextField();
        grid.add(descr, 5, 3);
        grid.add(descrText, 5, 4);


        Text gender1 = new Text("Animal gender: ");
        gender1.setFont(Font.font("Arial", 30));
        gender1.setFill(Color.WHITE);
        choiceBox.getItems().addAll("Male", "Female");
        grid.add(gender1, 2, 9);
        grid.add(choiceBox, 2, 10);

        Text colour1 = new Text("Animal Colour ");
        colour1.setFont(Font.font("Arial", 30));
        colour1.setFill(Color.WHITE);
        TextField animalColour = new TextField();
        grid.add(colour1, 5, 9);
        grid.add(animalColour, 5, 10);


        Text remove = new Text("Remove an animal: ");
        remove.setFont(Font.font("Arial", 30));
        remove.setFill(Color.WHITE);
        TextField remove1 = new TextField();
        grid.add(remove, 8, 3);
        grid.add(remove1, 8, 4);

        ToggleGroup group = new ToggleGroup();

        Text neutered = new Text("Neutered");
        neutered.setFont(Font.font("Arial", 30));
        neutered.setFill(Color.WHITE);
        grid.add(neutered, 9, 3);
        RadioButton option = new RadioButton("True");
        option.setToggleGroup(group);
        grid.add(option, 10, 3);


        ToggleGroup group2 = new ToggleGroup();
        Text chipped = new Text("Chipped");
        chipped.setFill(Color.WHITE);
        chipped.setFont(Font.font("Arial", 30));
        grid.add(chipped, 9, 5);
        RadioButton optionChip = new RadioButton("True");
        optionChip.setToggleGroup(group2);
        grid.add(optionChip, 10, 5);


        ToggleGroup group3 = new ToggleGroup();
        Text vaccin = new Text("Vacinatated");
        vaccin.setFont(Font.font("Arial", 30));
        vaccin.setFill(Color.WHITE);
        grid.add(vaccin, 9, 8);
        RadioButton vaccinButton = new RadioButton("True");
        vaccinButton.setToggleGroup(group3);
        grid.add(vaccinButton, 10, 8);



        ToggleGroup group4 = new ToggleGroup();
        Text reserved = new Text("Reserved");
        reserved.setFont(Font.font("Arial", 30));
        reserved.setFill(Color.WHITE);
        grid.add(reserved, 9, 10);
        RadioButton reservedButton = new RadioButton("True");
        reservedButton.setToggleGroup(group4);
        grid.add(reservedButton, 10, 10);

        ChoiceBox choiceBox2 = new ChoiceBox();
        Text status = new Text("Animal status ");
        status.setFont(Font.font("Arial", 30));
        status.setFill(Color.WHITE);
        choiceBox2.getItems().addAll("Training", "Ready");
        grid.add(status, 9, 12);
        grid.add(choiceBox2, 10, 12);

        group2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (group2.getSelectedToggle() != null) {
                    chipped2[0] = true;
                }

            }
        });
        group4.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (group4.getSelectedToggle() != null) {
                    reserved2[0] = true;
                }

            }
        });
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    neutered2[0] = true;
                }

            }
        });
        group3.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (group3.getSelectedToggle() != null) {
                    vaccinated[0] = true;
                }

            }
        });

        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(event -> {
            date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });
        grid.add(datePicker, 8, 6);

        Button buttonAdd = new Button("Add");


        buttonAdd.setOnAction(e -> {

            boolean name=validateText(nameText.getText());;
            boolean bree=validateText(breed2.getText());
            boolean desc=validateText(descrText.getText());
            boolean type=validateText(aType.getText());
            boolean color=validateText(colour1.getText());
            boolean intCheck=isInt(animalAge.getText());
            if(name==true &&bree==true&&desc==true&&type==true&&color==true&&intCheck) {
                cata2 = new Adoption((String) choiceBox2.getValue(), datePicker.getValue(), chipped2[0], neutered2[0], vaccinated[0], reserved2[0]);
                Animal animal = new Animal(nameText.getText(), breed2.getText(), Integer.parseInt(animalAge.getText()), descrText.getText(), choiceBox.getValue(), animalColour.getText(), animalType.getText(), cata2);
                AnimalList.addAnimal(animal);
                AnimalList.addAdoptedList(animal);
            }
            else{
                alert.display();
            }


        });
        grid.add(buttonAdd, 4, 25);
        Button buttonRemove = new Button("Remove");
        buttonRemove.setOnAction(e ->{
            AnimalList.removeAdopted(remove1.getText());
        });
        grid.add(buttonRemove, 4, 24);


        return grid;

    }



    public GridPane displayLost(BorderPane border) {
        final TextArea tArea = new TextArea();
        ArrayList<Animal> animal = AnimalList.getAnimalLost();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        Text findLocale = new Text("Enter animal location:");
        findLocale.setFont(Font.font("Arial", 20));
        findLocale.setFill(Color.WHITE);
        TextField findLocale1 = new TextField();
        grid.add(findLocale, 8, 3);
        grid.add(findLocale1, 8, 4);
        Label locationLost = new Label("Check to see if the animal was lost in a certain location");
        Button buttonDisplay = new Button("Check");
        grid.add(buttonDisplay, 8, 9);
        buttonDisplay.setMinWidth(50.00);
        grid.add(locationLost, 8, 8);
        buttonDisplay.setOnAction(e -> {
            for (int i = 0; i < animal.size(); i++) {
                Animal a = animal.get(i);
                if (a.getCata() instanceof Lost) {
                    Lost lol = (Lost) a.getCata();

                    if (lol.getLocation().equals(findLocale1.getText())) {
                        tArea.appendText(a.toString() + "\n");
                    }
                }
            }
        });

        Text findlocaleDate = new Text("Pick a date:");
        findlocaleDate.setFont(Font.font("Arial", 20));
        findlocaleDate.setFill(Color.WHITE);
        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(event -> {
            date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });
        grid.add(findlocaleDate, 8, 6);
        grid.add(datePicker, 8, 7);

        tArea.setEditable(false);

        tArea.setPrefSize(600, 200);
        tArea.setWrapText(true);
        Label locationLostDate = new Label("Check to see if the animal was lost in a certain location and on a specific date");
        Button buttonDisplay2 = new Button("Check");
        buttonDisplay2.setMinWidth(50);
        grid.add(buttonDisplay2, 10, 9);
        grid.add(locationLostDate, 10, 8);
        buttonDisplay2.setOnAction(e -> {

            for (int i = 0; i < animal.size(); i++) {
                Animal a = animal.get(i);
                if (a.getCata() instanceof Lost) {
                    Lost lol = (Lost) a.getCata();

                    if (lol.getLocation().equals(findLocale1.getText()) && lol.getDate().equals(datePicker.getValue())) {
                        tArea.appendText(a.toString() + "\n");


                    }
                }
            }

        });
        Button clear = new Button("Clear");
        clear.setOnAction(e -> tArea.clear());
        grid.add(clear, 8, 20);
        grid.add(tArea, 8, 14);

        return grid;
    }

    public GridPane displayFound(BorderPane border) {
        final TextArea tArea2 = new TextArea();
        ArrayList<Animal> animal = AnimalList.getFoundAnimal();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        Text findLocale = new Text("Enter animal location:");
        findLocale.setFont(Font.font("Arial", 20));
        findLocale.setFill(Color.WHITE);
        TextField findLocale1 = new TextField();
        grid.add(findLocale, 8, 3);
        grid.add(findLocale1, 8, 4);

        Button buttonDisplay = new Button("Check");
        buttonDisplay.setOnAction(e -> {
            for (int i = 0; i < animal.size(); i++) {
                Animal a = animal.get(i);
                if (a.getCata() instanceof Found) {
                    Found lol = (Found) a.getCata();

                    if (lol.getLocation().equals(findLocale1.getText())) {
                        tArea2.appendText(a.toString() + "\n");
                    }
                }
            }
        });

        Text findlocaleDate = new Text("Pick a start date:");
        findlocaleDate.setFont(Font.font("Arial", 20));
        findlocaleDate.setFill(Color.WHITE);
        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(event -> {
            date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });
        grid.add(findlocaleDate, 8, 6);
        grid.add(datePicker, 8, 7);

        Text findlocaleDate2 = new Text("Pick an end date:");
        findlocaleDate2.setFont(Font.font("Arial", 20));
        findlocaleDate2.setFill(Color.WHITE);
        DatePicker datePicker2 = new DatePicker();
        datePicker2.setOnAction(event -> {
            date = datePicker2.getValue();
            System.out.println("Selected date: " + date);
        });
        grid.add(findlocaleDate2, 10, 6);
        grid.add(datePicker2, 10, 7);
        Label certainLoc = new Label("Check for animals in a certain location");
        grid.add(certainLoc, 10, 11);
        grid.add(buttonDisplay, 10, 12);
        Button buttonDisplay2 = new Button("Check");
        buttonDisplay2.setOnAction(e -> {

            for (int i = 0; i < animal.size(); i++) {
                Animal a = animal.get(i);
                if (a.getCata() instanceof Found) {
                    Found lol = (Found) a.getCata();
                    for (LocalDate date = datePicker.getValue(); !date.isAfter(datePicker2.getValue()); date = date.plusDays(1)) {
                        if (lol.getLocation().equals(findLocale1.getText())) {
                            tArea2.appendText(a.toString() + "\n");

                        }
                    }
                }
            }
        });
        Label localeDate = new Label("Find an animal between dates and location");
        grid.add(localeDate, 8, 11);
        grid.add(buttonDisplay2, 8, 12);
        Button buttonDisplay3 = new Button("Check gender");
        Label checkGen = new Label("Find an animal between dates and organised by gender");
        grid.add(checkGen, 12, 11);
        grid.add(buttonDisplay3, 12, 12);
        buttonDisplay3.setOnAction(e -> {
            ArrayList<Animal> gen = AnimalList.sortGenderFound();

            for (int i = 0; i < gen.size(); i++) {
                Animal a = gen.get(i);
                if (a.getCata() instanceof Found) {
                    //Found lol = (Found) a.getCata();
                    for (LocalDate date = datePicker.getValue(); !date.isAfter(datePicker2.getValue()); date = date.plusDays(1)) {
                        tArea2.appendText(a.toString() + "\n");


                    }
                }
            }
        });
        tArea2.setEditable(false);

        tArea2.setPrefSize(600, 200);
        tArea2.setWrapText(true);
        grid.add(tArea2, 8, 14);

        Button clear = new Button("Clear");
        clear.setOnAction(e -> tArea2.clear());
        grid.add(clear, 8, 20);
        return grid;
    }

    public GridPane displayAdopted(BorderPane border) {
        final TextArea tArea3 = new TextArea();
        ArrayList<Animal> animal = AnimalList.getAnimalAdopted();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));


        Label ageSort = new Label("Sort adopted animals by age");
        Button buttonDisplay = new Button("sort age");
        buttonDisplay.setOnAction(e -> {
            ArrayList sort = AnimalList.sortAge();
            tArea3.appendText(sort + "\n");
            System.out.println(sort);

        });

        Button buttonDisplay2 = new Button("sort name");
        Label nameSort = new Label("Sort adopted animals by Name");
        buttonDisplay2.setOnAction(e -> {
            ArrayList sort2 = AnimalList.sortName();
            tArea3.appendText(sort2 + "\n");
            System.out.println(sort2);
        });
        Label statSort = new Label("Display all in training animals");
        Button buttonDisplay3 = new Button("sort status");
        buttonDisplay3.setOnAction(e -> {

            for (int i = 0; i < animal.size(); i++) {
                Animal a = animal.get(i);
                if (a.getCata() instanceof Adoption) {
                    Adoption lol = (Adoption) a.getCata();

                    if (lol.getStatus().equals("Training")) {
                        tArea3.appendText(a.toString() + "\n");


                    }
                }
            }
        });

        Button clear = new Button("Clear");
        clear.setOnAction(e -> tArea3.clear());

        grid.add(ageSort, 8, 3);
        grid.add(buttonDisplay, 8, 4);
        grid.add(nameSort, 10, 3);
        grid.add(buttonDisplay2, 10, 4);
        grid.add(statSort, 12, 3);
        grid.add(buttonDisplay3, 12, 4);
        grid.add(clear, 8, 20);
        grid.add(tArea3, 8, 14);


        return grid;
    }

    public GridPane displayGeneral(BorderPane border) {
        final TextArea tArea3 = new TextArea();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));


        Label displaySpon = new Label("Display all people");
        Button buttonDisplay = new Button("Display");
        buttonDisplay.setOnAction(e -> tArea3.appendText(people + "\n"));

        Button buttonDisplay2 = new Button("sort name");
        Label allAnimal = new Label("Sort adopted animals by Name");
        buttonDisplay2.setOnAction(e -> {
            ArrayList allAni = AnimalList.sortAgeAll();
            tArea3.appendText(allAni + "\n");
        });

        Button clear = new Button("Clear");
        clear.setOnAction(e -> tArea3.clear());

        grid.add(displaySpon, 8, 3);
        grid.add(buttonDisplay, 8, 4);
        grid.add(allAnimal, 10, 3);
        grid.add(buttonDisplay2, 10, 4);

        grid.add(clear, 8, 20);
        grid.add(tArea3, 8, 14);


        return grid;
    }
    public static void writeFileAll() throws IOException {

        try
        {
            FileOutputStream fileOut = new FileOutputStream("people.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(people);

            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in people.txt");
        }catch(IOException i)
        {
            i.printStackTrace();
        }


    }
    public static void readFileAll() throws IOException{

        try
        {
            FileInputStream fileIn = new FileInputStream("people.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            people = (ArrayList<Person>) in.readObject();
            in.close();
            fileIn.close();
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
    public boolean validateText(String input){
        if (input!=null&&input.length()!=0){

            return true;
        }
        else{

            return false;


        }
    }
    private boolean isInt(String input){
        try{
            int age = Integer.parseInt(input);
            System.out.println("User is: " + age);
            return true;
        }catch(NumberFormatException e){

            return false;
        }
    }



}


