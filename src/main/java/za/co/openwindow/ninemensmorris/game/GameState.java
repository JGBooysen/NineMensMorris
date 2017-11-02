package za.co.openwindow.ninemensmorris.game;

/**
 * Created by student on 2017/10/17.
 */
public abstract class GameState {
    
    protected BoardState theBoard;
    protected int gamePhase;

    static public final int NUM_PIECES_PER_PLAYER = 9;
    static public final int PLACING_PHASE = 1;
    static public final int MOVING_PHASE = 2;
    static public final int INVALID_SRC_POS = -1;
    static public final int UNAVAILABLE_POS = -2;
    static public final int INVALID_MOVE = -3;
    static public final int VALID_MOVE = 0;
    static protected final int MIN_NUM_PIECES = 2;
    
    
    
    public GameState () {
        theBoard = new BoardState();
        gamePhase = GameState.PLACING_PHASE;
    
    }
}
