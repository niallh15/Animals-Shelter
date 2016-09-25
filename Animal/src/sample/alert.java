package sample; /**
 * Created by niall on 03/05/2016.
 */
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class alert {


    public static void display() {
            Stage window = new Stage();

            //Block events to other windows
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Error");
            window.setMinWidth(250);

            Label label = new Label();
            label.setText("Please fill out all text fields");
            Button closeButton = new Button("Close this window");
            closeButton.setOnAction(e -> window.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton);
            layout.setAlignment(Pos.CENTER);

            //Display window and wait for it to be closed before returning
            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();
        }


}
