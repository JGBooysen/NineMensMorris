package za.co.openwindow.ninemensmorris.game;

import sun.tools.jstat.Token;

/**
 * Created by student on 2017/10/17.
 */
public abstract class Player {

    protected String name;
    protected int gamesWon;
    protected int numPieces;
    protected int numPiecesOnBoard;
    protected Token playerToken;
    
    protected Player() {
        gamesWon = 0;
        numPiecesOnBoard = 0;
    }
    
    protected Player(Token player, int numPiecesPerPlayer) throws GameException {
        /*
        this();
        if (player != Token.PLAYER_1 && player != Token.PLAYER_2) {
            throw new GameException(" " + getClass().getName() + " invalid player token " + player);
        } else {
            numPieces = numPiecesPerPlayer;
            playerToken = player;
        }
        */
    }
    
    public void reset() {
        numPiecesOnBoard = 0;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public  int getNumPiecesOnBoard() {
        return numPiecesOnBoard;
    }
    
    public int getNumPiecesLeftToPlace() {
        return (numPieces - numPiecesOnBoard);
    }
    
    public Token getPlayerToken() {
        return playerToken;
    }
    
    public abstract boolean isAI();
    
}
