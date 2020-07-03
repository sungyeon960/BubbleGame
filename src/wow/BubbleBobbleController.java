package wow;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
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
	private List<Image> imgList;
	@FXML
	ImageView h3;
	@FXML
	ImageView h2;
	@FXML
	ImageView h1;

	private int cnt = 0;
	@FXML
	ImageView water;
	@FXML
	ImageView water1;
	@FXML
	ImageView water6;
	@FXML
	ImageView water2;
	@FXML
	ImageView water3;
	@FXML
	ImageView water4;
	@FXML
	ImageView water5;
	private int num;
	private int keyCnt;
	@FXML
	ImageView water7;
	@FXML
	ImageView water8;
	@FXML
	ImageView water9;
	@FXML
	ImageView water10;
	@FXML
	ImageView water11;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bobi.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				handleBobi(event);
			}
		});
		gostMove();
		imgList = new ArrayList<>();
		imgList.add(new Image(getClass().getResource("bobi.png").toExternalForm()));
		imgList.add(new Image(getClass().getResource("bobiBump.png").toExternalForm()));
		imgList.add(new Image(getClass().getResource("hb.png").toExternalForm()));
		imgList.add(new Image(getClass().getResource("wow.png").toExternalForm()));

	}

	public void handleBobi(KeyEvent event) {
		KeyCode keyCode = event.getCode();

		if (keyCode == KeyCode.LEFT) {
			left();
		} else if (keyCode == KeyCode.RIGHT) {
			right();
		} else if (keyCode == KeyCode.UP) {
			up();
		} else if (keyCode == KeyCode.SPACE) {
			keyCnt++;
			waterMove();
		}
		event.consume();
	}

	public void waterInit(ImageView water) {
		water.setVisible(true); // 보이기
		if (bobi.getRotate() == 180) {
			water.setLayoutX(bobi.getLayoutX() - 30);// 바비보다 30앞에
		} else if (bobi.getRotate() == 0) {
			water.setLayoutX(bobi.getLayoutX() + 30);// 바비보다 30앞에
		}
		if (bobi.getLayoutY() == 507) {
			water.setLayoutY(519);
		} else if (bobi.getLayoutY() == 387) {
			water.setLayoutY(399);
		} else if (bobi.getLayoutY() == 247) {
			water.setLayoutY(259);
		} else if (bobi.getLayoutY() == 107) {
			water.setLayoutY(119);
		}
	}

	public void waterMove() {
		// 초기화
		if (keyCnt == 1) {
			waterInit(water1);
		} else if (keyCnt == 2) {
			waterInit(water2);
		} else if (keyCnt == 3) {
			waterInit(water3);
		} else if (keyCnt == 4) {
			waterInit(water4);
		} else if (keyCnt == 5) {
			waterInit(water5);
		} else if (keyCnt == 6) {
			waterInit(water6);
		} else if (keyCnt == 7) {
			waterInit(water7);
		} else if (keyCnt == 8) {
			waterInit(water8);
		} else if (keyCnt == 9) {
			waterInit(water9);
		} else if (keyCnt == 10) {
			waterInit(water10);
		} else if (keyCnt == 11) {
			waterInit(water11);
		}

		Timer timer = new Timer();
		TimerTask water1Timer = new TimerTask() {

			@Override
			public void run() {
				waterCheck(water1);
				waterCheck(water2);
				waterCheck(water3);
				waterCheck(water4);
				waterCheck(water5);
				waterCheck(water6);
				waterCheck(water7);
				waterCheck(water8);
				waterCheck(water9);
				waterCheck(water10);
				waterCheck(water11);
			}
		};
		timer.schedule(water1Timer, 10, 200);
	}

	public void waterCheck(ImageView water) {
		long bobiBump = Math.round(bobi.getLayoutX() / 100);
		long gost1Bump = Math.round(gost1.getLayoutX() / 100);
		long gost2Bump = Math.round(gost2.getLayoutX() / 100);
		long gost3Bump = Math.round(gost3.getLayoutX() / 100);
		long gost4Bump = Math.round(gost4.getLayoutX() / 100);
		long gost5Bump = Math.round(gost5.getLayoutX() / 100);
		long water1Bump = Math.round(water1.getLayoutX() / 100);
		long water2Bump = Math.round(water2.getLayoutX() / 100);
		long water3Bump = Math.round(water3.getLayoutX() / 100);
		long water4Bump = Math.round(water4.getLayoutX() / 100);
		long water5Bump = Math.round(water5.getLayoutX() / 100);
		long water6Bump = Math.round(water6.getLayoutX() / 100);
		long water7Bump = Math.round(water7.getLayoutX() / 100);
		long water8Bump = Math.round(water8.getLayoutX() / 100);
		long water9Bump = Math.round(water9.getLayoutX() / 100);
		long water10Bump = Math.round(water10.getLayoutX() / 100);
		long water11Bump = Math.round(water11.getLayoutX() / 100);

		if (water.isVisible()) {
			if (bobi.getRotate() == 180) {
				water.setLayoutX(water.getLayoutX() - 10);
			} else if (bobi.getRotate() == 0) {
				water.setLayoutX(water.getLayoutX() + 10);
			}
			if (gost3Bump == water1Bump) {
				gost3.setImage(imgList.get(3));
				water1.setVisible(false);
			} else if (gost2Bump == water1Bump) {
				gost3.setImage(imgList.get(3));
				water1.setVisible(false);
			}

		}
	}

	public void up() {

		if (bobi.getLayoutY() > 387) {
			jump(-130, 517);
			bobi.layoutYProperty().setValue(bobi.layoutYProperty().doubleValue() + 10);
		} else if (bobi.getLayoutY() <= 387 && bobi.getLayoutY() > 247) {
			jump(-150, 397);
			bobi.layoutYProperty().setValue(bobi.layoutYProperty().doubleValue() + 10);
		} else {
			jump(-150, 257);
			bobi.layoutYProperty().setValue(bobi.layoutYProperty().doubleValue() + 10);
		}

		if ((bobi.getLayoutX() >= 88 && bobi.getLayoutX() <= 189// Ã¹Â°Ä­
				|| bobi.getLayoutX() >= 488 && bobi.getLayoutX() <= 562)) {
			jump(0, 507);
		}
		bump();
	}

	public void jump(int jumpValue, int jump) {
		bobi.setLayoutY(bobi.getLayoutY() + jumpValue);
		KeyValue keyValue = new KeyValue(bobi.layoutYProperty(), jumpValue + jump);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue);
		Timeline timeline = new Timeline(keyFrame);
		timeline.play();
	}

	public void left() {
		if (bobi.getLayoutX() <= 28) {
			bobi.setLayoutX(28);
			return;
		}
		bobi.setRotate(180);
		bobi.setLayoutX(bobi.getLayoutX() - 10);
		check();
		bump();
	}

	public void right() {
		if (bobi.getLayoutX() >= 620) {
			bobi.setLayoutX(620);
			return;
		}
		bobi.setRotate(0);
		bobi.setLayoutX(bobi.getLayoutX() + 10);
		check();
		bump();
	}

	public void bump() {
		long bobiBump = Math.round(bobi.getLayoutX() / 100);
		long gost1Bump = Math.round(gost1.getLayoutX() / 100);
		long gost2Bump = Math.round(gost2.getLayoutX() / 100);
		long gost3Bump = Math.round(gost3.getLayoutX() / 100);
		long gost4Bump = Math.round(gost4.getLayoutX() / 100);
		long gost5Bump = Math.round(gost5.getLayoutX() / 100);

		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int cnt5 = 0;
		if (bobi.getLayoutY() == 387) {
			if (gost1Bump == bobiBump) {
				if (cnt1 == 0) {
					bobi.setImage(imgList.get(1));
					cnt1++;
					cnt++;
				}
			} else {
				bobi.setImage(imgList.get(0));
			}
		}
		if (bobi.getLayoutY() == 247) {
			if (gost2Bump == bobiBump) {
				if (cnt2 == 0) {
					bobi.setImage(imgList.get(1));
					cnt2++;
					cnt++;
				}
			} else {
				bobi.setImage(imgList.get(0));
			}
		} else if (bobi.getLayoutY() == 507) {
			if (gost3Bump == bobiBump) {
				if (cnt3 == 0) {
					if (gost3.getImage() == imgList.get(3)) {
						gost3.setVisible(false);
						//드디어 죽였당!!
					} else {
						bobi.setImage(imgList.get(1));
						cnt3++;
						cnt++;
					}
				}
			} else {
				bobi.setImage(imgList.get(0));
			}
		} else if (bobi.getLayoutY() == 107) {
			if (gost4Bump == bobiBump) {
				if (cnt4 == 0) {
					bobi.setImage(imgList.get(1));
					cnt4++;
					cnt++;
				} else {
					bobi.setImage(imgList.get(0));
				}
			} else if (gost5Bump == bobiBump) {
				if (cnt5 == 0) {
					bobi.setImage(imgList.get(1));
					cnt5++;
					cnt++;
				} else {
					bobi.setImage(imgList.get(0));
				}
			}
		}
		if (cnt >= 1 && cnt <= 10) {
			h1.setImage(imgList.get(2));
		} else if (cnt > 10 && cnt <= 20) {
			h2.setImage(imgList.get(2));
		} else if (cnt > 20) {
			h3.setImage(imgList.get(2));
		}

	}

	public void check() {
		if (bobi.getLayoutX() > 88 && bobi.getLayoutX() < 189 || bobi.getLayoutX() > 488 && bobi.getLayoutX() < 562) {
			if (bobi.getLayoutY() <= 507 && bobi.getLayoutY() >= 420) {
			} else if (bobi.getLayoutY() < 420 && bobi.getLayoutY() >= 277) {
				bobi.setLayoutY(507);
			} else if (bobi.getLayoutY() < 277 && bobi.getLayoutY() >= 140) {
				bobi.setLayoutY(387);
			} else if (bobi.getLayoutY() < 140) {
				bobi.setLayoutY(247);
			}
		}
	}

	public void gostMove() {
		Timer timer = new Timer();
		TimerTask gost1Timer = new TimerTask() {

			@Override
			public void run() {
				gost1.setLayoutX(gost1.getLayoutX() - SPEED1);
				if (gost1.getLayoutX() <= 201) {
					gost1.setRotate(0);
					SPEED1 = -SPEED1;
				} else if (gost1.getLayoutX() >= 469) {
					gost1.setRotate(180);
					SPEED1 = -SPEED1;
				}

				gost5.setLayoutX(gost5.getLayoutX() - SPEED5);
				if (gost5.getLayoutX() <= 201) {
					gost5.setRotate(0);
					SPEED5 = -SPEED5;
				} else if (gost5.getLayoutX() >= 469) {
					gost5.setRotate(180);
					SPEED5 = -SPEED5;
				}

				gost3.setLayoutX(gost3.getLayoutX() - SPEED3);
				if (gost3.getLayoutX() <= 28) {
					gost3.setRotate(0);
					SPEED3 = -SPEED3;
				} else if (gost3.getLayoutX() >= 627) {
					gost3.setRotate(180);
					SPEED3 = -SPEED3;
				}

				gost2.setLayoutX(gost2.getLayoutX() + SPEED2);
				if (gost2.getLayoutX() <= 201) {
					gost2.setRotate(0);
					SPEED2 = -SPEED2;
				} else if (gost2.getLayoutX() >= 469) {
					gost2.setRotate(180);
					SPEED2 = -SPEED2;
				}

				gost4.setLayoutX(gost4.getLayoutX() + SPEED4);
				if (gost4.getLayoutX() <= 201) {
					gost4.setRotate(0);
					SPEED4 = -SPEED4;
				} else if (gost4.getLayoutX() >= 469) {
					gost4.setRotate(180);
					SPEED4 = -SPEED4;
				}
			}
		};
		timer.schedule(gost1Timer, 10, 200);
	}
}