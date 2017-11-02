package za.co.openwindow.ninemensmorris.application;

import javafx.application.Application;
import javafx.stage.Stage;
import za.co.openwindow.ninemensmorris.game.BoardState;
import za.co.openwindow.ninemensmorris.game.Point;

import java.util.List;

/**
 * Created by student on 2017/10/17.
 */
public class NineMensMorrisApplication extends Application {
    
    public void start(Stage primaryStage) throws Exception {
    
    
    }
    
    
    public static void main(String[] args) {
        BoardState boardState = new BoardState();
        List<Point> neighbours = boardState.getNeighboursOfPoint(new Point(3,1));
        for (Point point : neighbours) {
            System.out.println(point.getRow() + ";" + point.getColumn());
        }
        launch(args);
    }
}
