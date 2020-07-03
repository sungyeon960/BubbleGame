package bubbleBobble.copy.copy;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class BubbleBobbleController implements Initializable {
	@FXML
	ImageView bobi;
	@FXML
	ImageView waterDrop;
	@FXML
	ImageView gost1;
	@FXML
	ImageView gost2;
	@FXML
	ImageView gost3;
	@FXML
	ImageView gost4;
	@FXML
	ImageView gost5;
	private int SPEED1 = 10;
	private int SPEED2 = 10;
	private int SPEED3 = 10;
	private int SPEED4 = 10;
	private int SPEED5 = 10;
	@FXML
	AnchorPane bobiAll;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bobi.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				handleBobi(event);
			}
		});
		gostMove();
	}

	// 좌우로 움직이기 구현완료
	public void handleBobi(KeyEvent event) {
		KeyCode keyCode = event.getCode();

		if (keyCode == KeyCode.LEFT) {
			left();
		} else if (keyCode == KeyCode.RIGHT) {
			right();
		} else if (keyCode == KeyCode.UP) {
			up();
		}
		event.consume();
	}

	public void up() {
		if (bobi.getLayoutY() > 356) {
			jump(-150, 180); // 첫번째칸까지 점프
		}
		if (bobi.getLayoutY() <= 356 && bobi.getLayoutY() > 186) {
			jump(-20, 80);
		}
		if (bobi.getLayoutY() <= 186 && bobi.getLayoutY() > 37) {
			jump(-125, 190); // 세번째칸까지 점프
		}
		if (bobi.getLayoutY() <= 37) {
			bobi.setLayoutY(42);
		}
		System.out.println("jump" + bobi.getLayoutY());
	}

	public void jump(int jumpValue, int jump) {
		bobi.setLayoutY(bobi.getLayoutY() + jumpValue);
		KeyValue keyValue = new KeyValue(bobi.yProperty(), jumpValue + jump);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline(keyFrame);
		timeline.play();

	}

	public void down(int downValue, int down) {
		bobi.setLayoutY(bobi.getLayoutY() - downValue);
		KeyValue keyValue = new KeyValue(bobi.yProperty(), downValue + down);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline(keyFrame);
		timeline.play();
	}

	public void left() {
		System.out.println(bobi.getLayoutY());
		if (bobi.getLayoutX() <= 28) {
			bobi.setLayoutX(28);
			return;
		}
		bobi.setRotate(180);
		bobi.setLayoutX(bobi.getLayoutX() - 10);
		check();
	}

	public void right() {
		if (bobi.getLayoutX() >= 620) {
			bobi.setLayoutX(620);
			return;
		}
		bobi.setRotate(0);
		bobi.setLayoutX(bobi.getLayoutX() + 10);
		check();
	}

	public void check() {
		if (bobi.getLayoutY() >= 357 && bobi.getLayoutY() < 507) {
			if (bobi.getLayoutX() >= 88 && bobi.getLayoutX() <= 188) {
				bobi.setLayoutY(507-24);
				System.out.println(bobi.getLayoutY());
			}
		}
		if (bobi.getLayoutY() >= 187 && bobi.getLayoutY() < 357) {
			if (bobi.getLayoutX() >= 88 && bobi.getLayoutX() <= 188) {
				bobi.setLayoutY(507-50);
				System.out.println(bobi.getLayoutY());
			}
		}
		if (bobi.getLayoutY() < 187) {
			if (bobi.getLayoutX() >= 88 && bobi.getLayoutX() <= 188) {
				bobi.setLayoutY(507-50);
				System.out.println(bobi.getLayoutY());
			}
		}
	}

	public void gostMove() {
//		Timer timer = new Timer();
//		TimerTask gost1Timer = new TimerTask() {
//			@Override
//			public void run() {
//				// 못해
//				if (waterDrop.getLayoutX() - 20 == -gost3.getX()) {
//					System.out.println("만남");
//				}
//				if (gost1.getX() <= -250) {
//					gost1.setX(gost1.getX() + SPEED1);
//					gost1.setRotate(0);
//					SPEED1 = -SPEED1;
//				}
//				if (gost1.getX() >= -250) {
//					gost1.setX(gost1.getX() - SPEED1);
//					if (gost1.getX() >= 0) {
//						gost1.setRotate(180);
//						SPEED1 = -SPEED1;
//					}
//				}
//				if (gost2.getX() >= 110) {
//					gost2.setX(gost2.getX() - SPEED2);
//					gost2.setRotate(180);
//					SPEED2 = -SPEED2;
//				}
//				if (gost2.getX() <= 110) {
//					gost2.setX(gost2.getX() + SPEED2);
//					if (gost2.getX() <= -150) {
//						gost2.setRotate(0);
//						SPEED2 = -SPEED2;
//					}
//				}
//				if (gost3.getX() >= 190) {
//					gost3.setX(gost3.getX() + SPEED3);
//					gost3.setRotate(180);
//					SPEED3 = -SPEED3;
//				} else if (gost3.getX() <= 190) {
//					gost3.setX(gost3.getX() - SPEED3);
//					if (gost3.getX() <= -410) {
//						gost3.setRotate(0);
//						SPEED3 = -SPEED3;
//					}
//
//				}
//				if (gost4.getX() >= 210) {
//					gost4.setX(gost4.getX() - SPEED4);
//					gost4.setRotate(180);
//					SPEED4 = -SPEED4;
//				} else if (gost4.getX() <= 210) {
//					gost4.setX(gost4.getX() + SPEED4);
//					if (gost4.getX() <= -60) {
//						gost4.setRotate(0);
//						SPEED4 = -SPEED4;
//					}
//				}
//				if (gost5.getX() >= 40) {
//					gost5.setX(gost5.getX() + SPEED5);
//					gost5.setRotate(180);
//					SPEED5 = -SPEED5;
//				} else if (gost5.getX() <= 40) {
//					gost5.setX(gost5.getX() - SPEED5);
//					if (gost5.getX() <= -210) {
//						gost5.setRotate(0);
//						SPEED5 = -SPEED5;
//					}
//				}
//			}
//
//		};
//
//		timer.schedule(gost1Timer, 10, 200);
	}
}
