package za.co.openwindow.ninemensmorris.game;

import javafx.scene.control.Cell;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2017/10/17.
 */
public class BoardState {
    
    static public final int NUM_POSITIONS_OF_BOARD = 24; //this would dissapear with MIN/MAX board Map
    public static final int MIN = 0;
    public static final int MAX = 6;
    //i.e a board of 3 x 3 BUT then to create 3 squares of them for a full board? With ABSDEFG + 1234567
    
    static public final int NUM_MILL_COMBINATIONS = 16;
    static public final int NUM_POSITIONS_IN_EACH_MILL = 3;
    
    private List<Edge> edges;
    
    private Map<Point, Token> boardPositions;
    private Map<Point, Token> millCombinations;
    private int numOfPiecesPlayer1;
    private int numOfPiecesPlayer2;
    private int numberOfTotalPiecesPlaced;
    
    public BoardState() {
        boardPositions = new HashMap<Point, Token>();
        
        boardPositions.put(new Point(0,0), Token.NO_PLAYER);
        boardPositions.put(new Point(0,3), Token.NO_PLAYER);
        boardPositions.put(new Point(0,6), Token.NO_PLAYER);
        boardPositions.put(new Point(1,1), Token.NO_PLAYER);
        boardPositions.put(new Point(1,3), Token.NO_PLAYER);
        boardPositions.put(new Point(1,5), Token.NO_PLAYER);
        boardPositions.put(new Point(2,2), Token.NO_PLAYER);
        boardPositions.put(new Point(2,3), Token.NO_PLAYER);
        boardPositions.put(new Point(2,4), Token.NO_PLAYER);
        boardPositions.put(new Point(3,0), Token.NO_PLAYER);
        boardPositions.put(new Point(3,1), Token.NO_PLAYER);
        boardPositions.put(new Point(3,2), Token.NO_PLAYER);
        boardPositions.put(new Point(3,4), Token.NO_PLAYER);
        boardPositions.put(new Point(3,5), Token.NO_PLAYER);
        boardPositions.put(new Point(3,6), Token.NO_PLAYER);
        boardPositions.put(new Point(4,2), Token.NO_PLAYER);
        boardPositions.put(new Point(4,3), Token.NO_PLAYER);
        boardPositions.put(new Point(4,4), Token.NO_PLAYER);
        boardPositions.put(new Point(5,1), Token.NO_PLAYER);
        boardPositions.put(new Point(5,3), Token.NO_PLAYER);
        boardPositions.put(new Point(5,5), Token.NO_PLAYER);
        boardPositions.put(new Point(6,0), Token.NO_PLAYER);
        boardPositions.put(new Point(6,3), Token.NO_PLAYER);
        boardPositions.put(new Point(6,6), Token.NO_PLAYER);
        
        edges = new LinkedList<Edge>();
        
        edges.add(new Edge(new Point(0, 0), new Point(0, 3)));
        edges.add(new Edge(new Point(0, 3), new Point(0, 6)));
        edges.add(new Edge(new Point(1, 1), new Point(1, 3)));
        edges.add(new Edge(new Point(1, 3), new Point(1, 5)));
        edges.add(new Edge(new Point(2, 2), new Point(2, 3)));
        edges.add(new Edge(new Point(2, 3), new Point(2, 4)));
        edges.add(new Edge(new Point(3, 0), new Point(3, 1)));
        edges.add(new Edge(new Point(3, 1), new Point(3, 2)));
        edges.add(new Edge(new Point(3, 4), new Point(3, 5)));
        edges.add(new Edge(new Point(3, 5), new Point(3, 6)));
        edges.add(new Edge(new Point(4, 2), new Point(4, 3)));
        edges.add(new Edge(new Point(4, 3), new Point(4, 4)));
        edges.add(new Edge(new Point(5, 1), new Point(5, 3)));
        edges.add(new Edge(new Point(5, 3), new Point(5, 5)));
        edges.add(new Edge(new Point(6, 0), new Point(6, 3)));
        edges.add(new Edge(new Point(6, 3), new Point(6, 6)));
        edges.add(new Edge(new Point(0, 0), new Point(3, 0)));
        edges.add(new Edge(new Point(3, 0), new Point(6, 0)));
        edges.add(new Edge(new Point(1, 1), new Point(3, 1)));
        edges.add(new Edge(new Point(3, 1), new Point(5, 1)));
        edges.add(new Edge(new Point(2, 2), new Point(3, 2)));
        edges.add(new Edge(new Point(3, 2), new Point(4, 2)));
        edges.add(new Edge(new Point(0, 3), new Point(1, 3)));
        edges.add(new Edge(new Point(1, 3), new Point(2, 3)));
        edges.add(new Edge(new Point(4, 3), new Point(5, 3)));
        edges.add(new Edge(new Point(5, 3), new Point(6, 3)));
        edges.add(new Edge(new Point(2, 4), new Point(3, 4)));
        edges.add(new Edge(new Point(3, 4), new Point(4, 4)));
        edges.add(new Edge(new Point(1, 5), new Point(3, 5)));
        edges.add(new Edge(new Point(3, 5), new Point(5, 5)));
        edges.add(new Edge(new Point(0, 6), new Point(3, 6)));
        edges.add(new Edge(new Point(3, 6), new Point(6, 6)));
        
        List<Point> links = getNeighboursOfPoint(new Point(3, 1));
    }
    
    public List<Point> getNeighboursOfPoint(Point point) {
        List<Point> neighbours = new LinkedList<Point>();
        for (Edge edge : edges) {
            if (edge.isConnectedTo(point)) {
                neighbours.add(edge.getOpposite(point));
            }
        }
        return neighbours;
    }
    
    public Token getTokenAtPosition(Point point) {
        if (boardPositions.keySet().contains(point)) {
            return boardPositions.get(point);
        } else {
            return Token.OFFBOARD;
        }
    }
    
    

//    public BoardState() {
//        boardPositions = new Position[BoardState.NUM_POSITIONS_OF_BOARD];
//        numOfPiecesPlayer1 = 0;
//        numOfPiecesPlayer2 = 0;
//        numberOfTotalPiecesPlaced = 0;
//        initBoard();
//        initMillCombinations();
//    }
    
    public Position getPosition(int posIndex) throws GameException {
        if (posIndex >= 0 && posIndex < BoardState.NUM_POSITIONS_OF_BOARD) {
            return null; // boardPositions in map;
        } else {
            throw new GameException(" " + getClass().getName() + " - Invalid Board Position Index: " + posIndex);
        }
    }
    
    // todo: Implement this
    public boolean positionIsFree() {
        return false;
    }
    
    public int incNumPiecesOfPlayer(Token player) throws GameException {
        if(player == Token.PLAYER_1) {
            return ++ numOfPiecesPlayer1;
        } else if (player == Token.PLAYER_2) {
            return ++ numOfPiecesPlayer2;
        } else {
            throw new GameException(" " + getClass().getName() + " - Invalid Player Token: " + player);
        }
    }

    
    // todo: Implement this
    public int getNumberOfPiecesOfPlayer() {
        return 0;
    }
    
    
    private void initBoard() {
    
    }
    
    private void initMillCombinations() {
    
    }
}
