package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Formelrad Application
 *
 * @author Peter Rutschmann, modified by Samuel Dubler & Josua Koglin
 * @version 1.0 - 25.11.18
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();

			// Creating an image
			Image image = new Image(new FileInputStream("bin\\application\\formelradelektronik.gif"));
			ImageView imageView = new ImageView(image);
			imageView.setX(10);
			imageView.setY(10);
			imageView.setFitHeight(300);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			root.getChildren().add(imageView);

			Label lbleistung = new Label("Leistung:");
			lbleistung.relocate(10, 285);
			lbleistung.setFont(Font.font(15));
			root.getChildren().add(lbleistung);

			TextField txLeistung = new TextField();
			txLeistung.relocate(100, 285);
			txLeistung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txLeistung);

			Label lblSpannung = new Label("Spannung:");
			lblSpannung.relocate(10, 325);
			lblSpannung.setFont(Font.font(15));
			root.getChildren().add(lblSpannung);

			TextField txSpannung = new TextField();
			txSpannung.relocate(100, 325);
			txSpannung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txSpannung);

			Label lblStrom = new Label("Strom:");
			lblStrom.relocate(10, 365);
			lblStrom.setFont(Font.font(15));
			root.getChildren().add(lblStrom);

			TextField txStrom = new TextField();
			txStrom.relocate(100, 365);
			txStrom.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txStrom);

			Label lblWiderstand = new Label("Widerstand:");
			lblWiderstand.relocate(10, 405);
			lblWiderstand.setFont(Font.font(15));
			root.getChildren().add(lblWiderstand);

			TextField txWiderstand = new TextField();
			txWiderstand.relocate(100, 405);
			txWiderstand.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txWiderstand);

			Button btnBerechnen = new Button();
			btnBerechnen.relocate(100, 445);
			btnBerechnen.setText("Berechnen");
			root.getChildren().add(btnBerechnen);
			
			Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Achtung");
            alert.setContentText("Bitte geben Sie genau 2 Werte ein!");
			
			btnBerechnen.setOnAction(e -> {
				double leistung = 0.0;
				double spannung = 0.0;
				double strom = 0.0;
				double widerstand = 0.0;
				double counter = 0;
				boolean leistungSet = false;
				boolean spannungSet = false;
				boolean stromSet = false;
				boolean widerstandSet = false;
				txLeistung.setStyle("-fx-text-fill: black;");
				txSpannung.setStyle("-fx-text-fill: black;");
				txStrom.setStyle("-fx-text-fill: black;");
				txWiderstand.setStyle("-fx-text-fill: black;");
				if(!txLeistung.getText().isEmpty()) {
					leistung=Double.parseDouble(txLeistung.getText());
					leistungSet=true;
					counter++;
				}
				if(!txSpannung.getText().isEmpty()) {
					spannung=Double.parseDouble(txSpannung.getText());
					spannungSet=true;
					counter++;
				}
				if(!txStrom.getText().isEmpty()) {
					strom=Double.parseDouble(txStrom.getText());
					stromSet=true;
					counter++;
				}
				if(!txWiderstand.getText().isEmpty()) {
					widerstand=Double.parseDouble(txWiderstand.getText());
					widerstandSet=true;
					counter++;
				}
				if (counter != 2) {
                    alert.showAndWait();
                } else {
					Calculator myCalculator = new Calculator(
							leistung,
							spannung,
							strom,
							widerstand);
					System.out.print("Vorher:  ");
					System.out.println(myCalculator.toString());
					myCalculator.calculate();
					System.out.print("Nachher: ");
					System.out.println(myCalculator.toString());
					if(!leistungSet) {
						txLeistung.setText(Double.toString(myCalculator.getLeistung()));
						txLeistung.setStyle("-fx-text-fill: red;");
					}
					if(!spannungSet) {
						txSpannung.setText(Double.toString(myCalculator.getSpannung()));
						txSpannung.setStyle("-fx-text-fill: red;");
					}
					if(!stromSet) {	
						txStrom.setText(Double.toString(myCalculator.getStrom()));
						txStrom.setStyle("-fx-text-fill: red;");
					}
					if(!widerstandSet) {
						txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
						txWiderstand.setStyle("-fx-text-fill: red;");
					}
				}
			});

			Scene scene = new Scene(root, 330, 490);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
