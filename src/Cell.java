import javax.swing.*;

public class Cell extends JButton {
    private Pos2D pos;
    private String value;

    public Cell(Pos2D pos, int value){
        this.pos = pos;
        this.setValue(value);
        this.setActionCommand(pos.toString());
    }

    public void setPos(Pos2D pos){
        this.pos = pos;
    }

    public Pos2D getPos(){
        return pos;
    }

    public void setValue(int value){
        if(value == 0){
            this.value = "";
        }else{
            this.value = String.valueOf(value);
        }

        super.setText(this.value);
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
