public class Pos2D {
    private final int col;
    private final int row;

    public Pos2D(int col, int row){
        this.col = col;
        this.row = row;
    }

    public int getCol(){
        return this.col;
    }

    public int getRow(){
        return this.row;
    }

    public String toString(){
        return this.col+","+this.row;
    }

    public static Pos2D parseString(String toParse){
        String[] values = toParse.split(",");

        int col = Integer.parseInt(values[0]);
        int row = Integer.parseInt(values[1]);

        return new Pos2D(col, row);
    }
}
