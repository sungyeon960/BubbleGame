package jumpex;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class jumpController implements Initializable {
	@FXML
	ImageView bobi;
//	private double posY; // 오브젝트의 초기 높이
//	private float gravity; // 중력가속도
//	private float jumpPower; // 점프력
//	private float jumpTime; // 점프 이후 경과시간
	private KeyCode keyCode;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bobi.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				handleImgBuby(event);
			}
		});
//
//		posY = bobi.getY();
//		gravity = 9.8f;
//		jumpPower = 15.0f;
//		jumpTime = 0.0f;
	}

	public void jump() {
		bobi.setY(bobi.getY() - 30);
		KeyValue keyValue = new KeyValue(bobi.yProperty(), +30);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline(keyFrame);
		timeline.play();
//	}
//		// y=-a*x+b //a중력가속도, b초기점프속도
//		// 적분하여 y = (-a/2)*x*x + (b*x) // x점프시간, y높이
//		float height = ((-gravity) / 2) * jumpTime * jumpTime + (jumpPower * jumpTime);
//		bobi.setX(bobi.getX());
//		bobi.setY(bobi.getY() + height);
//		jumpTime += 10;
//
//		if (height < 0.0f) {
//			jumpTime = 0.0f;
//			bobi.setX(bobi.getX());
//			bobi.setY(bobi.getY());
//		}
	}

	public void handleImgBuby(KeyEvent event) {
		keyCode = event.getCode();
		System.out.println(keyCode);
		if (keyCode == KeyCode.LEFT) {
			bobi.setRotate(0);
			bobi.setX(bobi.getX() - 10);
		} else if (keyCode == KeyCode.RIGHT) {
			bobi.setRotate(180);
			bobi.setX(bobi.getX() + 10);
		} else if (keyCode == KeyCode.UP) {
			jump();
		} else if (keyCode == KeyCode.DOWN) {
			bobi.setY(bobi.getY() + 20);
		}
		event.consume();
	}

}
