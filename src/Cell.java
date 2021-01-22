import javax.swing.*;

public class Cell extends JButton {
    private int x;
    private int y;
    private String value;

    public Cell(){

    }

    public Cell(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.setValue(value);
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public void setValue(int value){
        if(value == 0){
            this.value = "";
        }else{
            this.value = String.valueOf(value);
        }

    }

    public String getValue(){
        return value;
    }
}
