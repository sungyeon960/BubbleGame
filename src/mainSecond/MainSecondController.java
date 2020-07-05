package mainSecond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class MainSecondController implements Initializable {

	@FXML
	ImageView image;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void startAction() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../wow/BubbleBobble.fxml"));
		Scene scene = new Scene(root);
		Stage window = new Stage();
		window.setScene(scene);
		window.show();

		window = (Stage) (image.getScene().getWindow());
		window.close();
	}
}
