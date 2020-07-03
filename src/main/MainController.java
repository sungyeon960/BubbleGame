package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class MainController implements Initializable {

	@FXML
	ImageView logoimg;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void startAction() throws IOException {
		Parent root = FXMLLoader.load(getClass().
				getResource("../mainSecond/MainSecond.fxml"));
		Scene scene = new Scene(root);
		Stage window = new Stage();
		window.setScene(scene);
		window.show();

		window = (Stage) (logoimg.getScene().getWindow());
		window.close();
	}
}
