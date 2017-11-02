package za.co.openwindow.ninemensmorris.game;

/**
 * Created by student on 2017/10/17.
 */
public class Point {
    
    private int row;
    private int column;
    
    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    
    
    public void setRow() {
        this.row = row;
    }
    
    public void setColumn() {
        this.column = column;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return  column;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Point point = (Point) o;
        
        if (row != point.row) return false;
        return column == point.column;
    }
    
    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
