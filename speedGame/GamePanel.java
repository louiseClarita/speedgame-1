package application;



import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/*--GamePanel

lines*/

public class GamePanel extends Pane {
	Rectangle Top =new Rectangle();

public GamePanel() {
	
	Top.setFill(Color.FIREBRICK);
	Top.setHeight(20);
	Top.setWidth(1000);
	Top.setY(50);
	Top.setX(50);
	Top.setStroke(Color.FIREBRICK);
	getChildren().add(Top);
	
	
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

	KeyFrame keyFrame1 = new KeyFrame(javafx.util.Duration.millis(10000), e -> makeNewRectangle1(line1));
	Timeline timeLine1 = new Timeline(keyFrame1);
	timeLine1.setCycleCount(Timeline.INDEFINITE);
	timeLine1.play();
	KeyFrame keyFrame = new KeyFrame(javafx.util.Duration.millis(50), e->getCoord(rectangleShape));
	Timeline animation = new Timeline(keyFrame);
	animation.setCycleCount(Timeline.INDEFINITE);
	animation.play(); 
	
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
	
	KeyFrame keyFrame22 = new KeyFrame(javafx.util.Duration.millis(100), e->getCoord(rectangleShape2));
	Timeline animation22 = new Timeline(keyFrame22);
	animation22.setCycleCount(Timeline.INDEFINITE);
	animation22.play(); 
	
	KeyFrame keyFrame2 = new KeyFrame(javafx.util.Duration.millis(6000), e -> makeNewRectangle2(line2));
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

	KeyFrame keyFrame3 = new KeyFrame(javafx.util.Duration.millis(11000), e -> makeNewRectangle3(line3));
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
	 
	KeyFrame keyFrame33 = new KeyFrame(javafx.util.Duration.millis(100), e->getCoord(rectangleShape3));
	Timeline animation33 = new Timeline(keyFrame33);
	animation33.setCycleCount(Timeline.INDEFINITE);
	animation33.play(); 
	
	
}

private void getCoord(RectangleShape r) {
  Rectangle rectangle = r.getRectangleOnly();
 /* Top.setHeight(20);
	Top.setWidth(1000);
	Top.setY(0);
	Top.setX(50);*/
	if(rectangle.localToParent(getBoundsInLocal()).intersects(Top.localToParent(getBoundsInLocal()))) {
		//CHECK
		if(r.getColor() == GameSettings.shapeColor) {
			 r.checked=true;
            if(GameSettings.lives == 1) {
            	/* JOptionPane.showMessageDialog(this, , "Game Over", JOptionPane.YES_NO_OPTION);
					System.exit(0);
			 //you have no more lives -> YOU LOSSTTTT configure later 
			 TryAgain tr = new TryAgain();
			 Scene sc = tr.getScene();
			 Main.primaryStage.setScene(sc);
			 Main.primaryStage.show();*/
			 
		}else if(GameSettings.lives > 1) {
			// you still have some lives left
			GameSettings.lives--;
		        }
		}else if(r.getColor() == GameSettings.shapeColorPressed || r.getColor() == GameSettings.shapeColorhalfPressed) {
			 r.checked=true;
			 
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
  /*
   * 
   *   
   *   
   *   SECOND METHOD :: STILL NOT FINISHED
   *   
   *   
   *   
   *   Bounds bound = r.localToParent(getBoundsInParent());
   
     Double Ycoord = bound.getCenterY();
    System.out.println("you centerY = " + Ycoord);
     // you reached top of screen (red line)
	 if( Ycoord  <= GameSettings.Top && Ycoord > 0) {
		
		 // didn't tap required clicks
		 /*r.Pressed== false && r.HalfPressed == false*/
		/* if( r.getRectangleOnly().getFill()  == GameSettings.shapeColor) {
			 System.out.println("NOT PRESSED");
			 if(GameSettings.lives == 1) {
				 r.checked=true;
				 //you have no more lives -> YOU LOSSTTTT configure later 
				 TryAgain tr = new TryAgain();
				 Scene sc = tr.getScene();
				 Main.primaryStage.setScene(sc);
				 Main.primaryStage.show();
				 
				 
				 
			 }else if(GameSettings.lives > 1 && r.getRectangleOnly().getFill()  == GameSettings.shapeColor) {
				 // you lost a life
				 r.checked=true;
				 GameSettings.lives = GameSettings.lives - 1; 
				 System.out.println(" you entered in the lost but not dead");
				 System.out.println(" lives - 1 = " + GameSettings.lives);
				 System.out.println("your color color at top line is :" + r.getColor());
				
				
			 }
			  // you still have one tap or no taps left nothing happens game continues
			 
			
			 }else if( r.getRectangleOnly().getFill() == GameSettings.shapeColorPressed || r.getRectangleOnly().getFill()  == GameSettings.shapeColorhalfPressed) {
				 r.checked=true;
				 System.out.println("your color is :" + r.getColor());
				 System.out.println("PRESSED");
				 
			 }
		
	 }
	*/	 
		 

}

private void makeNewRectangle1(Line line) {

	RectangleShape rectangleShape12 = new RectangleShape();
	this.getChildren().add(rectangleShape12.getRectangle());
	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(7000));
	pathTransition.setPath(line);
	pathTransition.setNode(rectangleShape12.getRectangle());
	pathTransition.setAutoReverse(false);
	pathTransition.setCycleCount(1);
	pathTransition.play();
	KeyFrame keyFrame = new KeyFrame(javafx.util.Duration.millis(500), e->getCoord(rectangleShape12));
	Timeline animation = new Timeline(keyFrame);
	animation.setCycleCount(Timeline.INDEFINITE);
	animation.play(); 
	KeyFrame keyFrame1 = new KeyFrame(javafx.util.Duration.millis(1), e->checkIfLost(animation,rectangleShape12));
	Timeline animation1 = new Timeline(keyFrame1);
	animation1.setCycleCount(Timeline.INDEFINITE);
	animation1.play(); 
	


	
}

private void checkIfLost(Timeline animation, RectangleShape r) {
	if( r.checked == true) {
		animation.stop();
	}
	
}

private void makeNewRectangle2(Line line) {
	
	RectangleShape rectangleShape12 = new RectangleShape();
	this.getChildren().add(rectangleShape12.getRectangle());
	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(4000));
	pathTransition.setPath(line);
	pathTransition.setNode(rectangleShape12.getRectangle());
	pathTransition.setAutoReverse(false);
	pathTransition.setCycleCount(1);
	pathTransition.play();
	KeyFrame keyFrame = new KeyFrame(javafx.util.Duration.millis(50), e->getCoord(rectangleShape12));
	Timeline animation = new Timeline(keyFrame);
	animation.setCycleCount(Timeline.INDEFINITE);
	animation.play(); 
	KeyFrame keyFrame1 = new KeyFrame(javafx.util.Duration.millis(1), e->checkIfLost(animation,rectangleShape12));
	Timeline animation1 = new Timeline(keyFrame1);
	animation1.setCycleCount(Timeline.INDEFINITE);
	animation1.play();


}
private void makeNewRectangle3(Line line) {
	
	RectangleShape rectangleShape12 = new RectangleShape();
	this.getChildren().add(rectangleShape12.getRectangle());
	PathTransition pathTransition = new PathTransition();
	pathTransition.setDuration(Duration.millis(9000));
	pathTransition.setPath(line);
	pathTransition.setNode(rectangleShape12.getRectangle());
	pathTransition.setAutoReverse(false);
	pathTransition.setCycleCount(1);
	pathTransition.play();
	KeyFrame keyFrame = new KeyFrame(javafx.util.Duration.millis(50), e->getCoord(rectangleShape12));
	Timeline animation = new Timeline(keyFrame);
	animation.setCycleCount(Timeline.INDEFINITE);
	animation.play(); 
	KeyFrame keyFrame1 = new KeyFrame(javafx.util.Duration.millis(1), e->checkIfLost(animation,rectangleShape12));
	Timeline animation1 = new Timeline(keyFrame1);
	animation1.setCycleCount(Timeline.INDEFINITE);
	animation1.play();
	
}


}
