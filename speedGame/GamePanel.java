package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/*--GamePanel

lines*/

public class GamePanel extends Pane {
public GamePanel() {
	//1st rectangle
	RectangleShape rectangleShape = new RectangleShape();
	Line line1 = new Line();
	line1.setStartX(400); 
	line1.setStartY(900);
	line1.setEndX(400);
	line1.setEndY(-210);
	getChildren().add(line1);
	getChildren().add(rectangleShape.getRectangle());

	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(7000));
	pathTransition.setPath(line1);
	pathTransition.setNode(rectangleShape.getRectangle());
	pathTransition.setAutoReverse(false);
	pathTransition.play();
	pathTransition.setCycleCount(1); 

	KeyFrame keyFrame1 = new KeyFrame(javafx.util.Duration.millis(6000), e -> makeNewRectangle1(line1));
	Timeline timeLine1 = new Timeline(keyFrame1);
	timeLine1.setCycleCount(Timeline.INDEFINITE);
	timeLine1.play();
	
	
	// 2nd rectangle
	RectangleShape rectangleShape2 = new RectangleShape();
	Line line2 = new Line();
	line2.setStartX(600);
	line2.setStartY(900);
	line2.setEndX(600);
	line2.setEndY(-210);
	
	
	getChildren().add(line2);
	getChildren().add(rectangleShape2.getRectangle());

	
	
	PathTransition pathTransition2 = new PathTransition();
	pathTransition2.setDuration(Duration.millis(4000));
	pathTransition2.setPath(line2);
	pathTransition2.setNode(rectangleShape2.getRectangle());
	pathTransition2.setCycleCount(1);
	pathTransition2.setAutoReverse(false);
	pathTransition2.play();
	KeyFrame keyFrame2 = new KeyFrame(javafx.util.Duration.millis(7000), e -> makeNewRectangle2(line2));
	Timeline timeLine2 = new Timeline(keyFrame2);
	timeLine2.setCycleCount(Timeline.INDEFINITE);
	timeLine2.play();
	
	//3rd rectangle
	RectangleShape rectangleShape3 = new RectangleShape();
	
	Line line3 = new Line();
	line3.setStartX(800);
	line3.setStartY(900);
	line3.setEndX(800);
	line3.setEndY(-210);
	
	
	getChildren().add(line3);
	getChildren().add(rectangleShape3.getRectangle());

	KeyFrame keyFrame3 = new KeyFrame(javafx.util.Duration.millis(8000), e -> makeNewRectangle3(line3));
	Timeline timeLine3 = new Timeline(keyFrame3);
	timeLine3.setCycleCount(Timeline.INDEFINITE);
	timeLine3.play();
	
	PathTransition pathTransition3 = new PathTransition();
	pathTransition3.setDuration(Duration.millis(9000));
	pathTransition3.setPath(line3);
	pathTransition3.setNode(rectangleShape3.getRectangle());
	pathTransition3.setCycleCount(1);
	pathTransition3.setAutoReverse(false);
	pathTransition3.play();
}

private void makeNewRectangle1(Line line) {
	System.out.println(" NEW rectangle ");
	RectangleShape rectangleShape12 = new RectangleShape();
	this.getChildren().add(rectangleShape12.getRectangle());
	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(6000));
	pathTransition.setPath(line);
	pathTransition.setNode(rectangleShape12.getRectangle());
	pathTransition.setAutoReverse(false);
	pathTransition.setCycleCount(1);
	pathTransition.play();
	
}

private void makeNewRectangle2(Line line) {
	System.out.println(" NEW rectangle ");
	RectangleShape rectangleShape12 = new RectangleShape();
	this.getChildren().add(rectangleShape12.getRectangle());
	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(7000));
	pathTransition.setPath(line);
	pathTransition.setNode(rectangleShape12.getRectangle());
	pathTransition.setAutoReverse(false);
	pathTransition.setCycleCount(1);
	pathTransition.play();
	
}
private void makeNewRectangle3(Line line) {
	System.out.println(" NEW rectangle ");
	RectangleShape rectangleShape12 = new RectangleShape();
	this.getChildren().add(rectangleShape12.getRectangle());
	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(8000));
	pathTransition.setPath(line);
	pathTransition.setNode(rectangleShape12.getRectangle());
	pathTransition.setAutoReverse(false);
	pathTransition.setCycleCount(1);
	pathTransition.play();
	
}
}
