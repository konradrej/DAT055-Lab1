import javax.swing.*;

public class Cell extends JButton {
    private int col;
    private int row;
    private String value;

    public Cell(){

    }

    public Cell(int col, int row, int value){
        this.col = col;
        this.row = row;
        this.setValue(value);
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getCol(){
        return col;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getRow(){
        return row;
    }

    public void setValue(int value){
        if(value == 0){
            this.value = "";
        }else{
            this.value = String.valueOf(value);
        }

        super.setText(this.value);
    }

    public String getValue(){
        return value;
    }
}
