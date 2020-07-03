package bubbleBobble.copy;

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
		// 부딪힘 구현
//		System.out.println("bobi: " + bobi.getX());
//		System.out.println("gost3: " + gost3.getX());
//		if (bobi.getX() == gost3.getX() || bobi.getX() == gost3.getX() + 66) {
//			System.out.println("부딪혔어");
//		}
//		WaterMove();
		gostMove();
	}

	// 부딪힘
	public void bump() {
//		System.out.println("함수실행");
//		if (bobi.getX() == gost3.getX() || bobi.getX() == gost3.getX() + 66) {
//			System.out.println("부딪혔어");
//		}
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
		if (bobi.getY() >= -150) {
			jump(-150, 35); // 첫번째칸까지 점프
		}
		if (bobi.getY() < -150 && bobi.getY() >= -285) {
			jump(-20, -242); // 두번째칸까지 점프
		}
		if (bobi.getY() < -285) {
			jump(-150, -247); // 세번째칸까지 점프
		}
		System.out.println("jump" + bobi.getY());
	}

	public void jump(int jumpValue, int jump) {
//		int jumpValue = -150;// 첫번째것!
		bobi.setY(bobi.getY() + jumpValue);
		KeyValue keyValue = new KeyValue(bobi.yProperty(), jumpValue + jump);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline(keyFrame);
		timeline.play();

	}

	public void down(int downValue, int down) {
		bobi.setY(bobi.getY() - downValue);
		KeyValue keyValue = new KeyValue(bobi.yProperty(), downValue + down);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline(keyFrame);
		timeline.play();
	}

	public void left() {
		if (bobi.getX() <= -50) {// 벽에 부딪히면 더이상 가지 않음!
			bobi.setX(-50);
			return;
		}
		if (bobi.getY() == -115 || bobi.getY() == -262 || bobi.getY() == -397) {
			if (bobi.getX() >= 15 && bobi.getX() <= 90) {
				down(-10, 10);// 첫번째칸
			}
			if (bobi.getX() >= 410 && bobi.getX() <= 490) {
				down(-10, 10);// 두번째칸
			}
		}
//		System.out.println("x: "+ bobi.getX()+" y: "+bobi.getY());//-115

		bobi.setRotate(180);
		bobi.setX(bobi.getX() - 10);
		bobi.rotateProperty();
	}

	public void right() {
		if (bobi.getX() >= 540) {
			bobi.setX(540);
			return;
		}
		if (bobi.getY() == -115 || bobi.getY() == -262 || bobi.getY() == -397) {
			if (bobi.getX() >= 15 && bobi.getX() <= 90) {
				down(-10, 10);// 첫번째칸
			}
			if (bobi.getX() >= 410 && bobi.getX() <= 490) {
				down(-10, 10);// 두번째칸
			}
		}
		bobi.setRotate(0);
		bobi.setX(bobi.getX() + 10);
	}

	public void gostMove() {
		Timer timer = new Timer();
		TimerTask gost1Timer = new TimerTask() {
			@Override
			public void run() {
				// 못해
				waterDrop.setX(waterDrop.getX() + 10);
				waterDrop.setLayoutX(waterDrop.getX() + 10);
				System.out.println(waterDrop.getLayoutX());// 160
				System.out.println(gost3.getX());// -140
				if (waterDrop.getLayoutX() - 20 == -gost3.getX()) {
					System.out.println("만남");
				}
				if (gost1.getX() <= -250) {
					gost1.setX(gost1.getX() + SPEED1);
					gost1.setRotate(0);
					SPEED1 = -SPEED1;
				}
				if (gost1.getX() >= -250) {
					gost1.setX(gost1.getX() - SPEED1);
					if (gost1.getX() >= 0) {
						gost1.setRotate(180);
						SPEED1 = -SPEED1;
					}
				}
				if (gost2.getX() >= 110) {
					gost2.setX(gost2.getX() - SPEED2);
					gost2.setRotate(180);
					SPEED2 = -SPEED2;
				}
				if (gost2.getX() <= 110) {
					gost2.setX(gost2.getX() + SPEED2);
					if (gost2.getX() <= -150) {
						gost2.setRotate(0);
						SPEED2 = -SPEED2;
					}
				}
				if (gost3.getX() >= 190) {
					gost3.setX(gost3.getX() + SPEED3);
					gost3.setRotate(180);
					SPEED3 = -SPEED3;
				} else if (gost3.getX() <= 190) {
					gost3.setX(gost3.getX() - SPEED3);
					if (gost3.getX() <= -410) {
						gost3.setRotate(0);
						SPEED3 = -SPEED3;
					}

				}
				if (gost4.getX() >= 210) {
					gost4.setX(gost4.getX() - SPEED4);
					gost4.setRotate(180);
					SPEED4 = -SPEED4;
				} else if (gost4.getX() <= 210) {
					gost4.setX(gost4.getX() + SPEED4);
					if (gost4.getX() <= -60) {
						gost4.setRotate(0);
						SPEED4 = -SPEED4;
					}
				}
				if (gost5.getX() >= 40) {
					gost5.setX(gost5.getX() + SPEED5);
					gost5.setRotate(180);
					SPEED5 = -SPEED5;
				} else if (gost5.getX() <= 40) {
					gost5.setX(gost5.getX() - SPEED5);
					if (gost5.getX() <= -210) {
						gost5.setRotate(0);
						SPEED5 = -SPEED5;
					}
				}
			}

		};

		timer.schedule(gost1Timer, 10, 200);
	}
}
