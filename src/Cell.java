import javax.swing.*;

public class Cell extends JButton {
    private Pos2D pos;
    private String value;
    private Boolean isCorrect;

    public Cell(Pos2D pos, int value){
        this.pos = pos;
        this.setValue(value);
        this.setActionCommand(pos.toString());

        int position = pos.getCol() + pos.getRow() * 4 + 1;
        isCorrect = (position == value);
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
        super.setText(this.value);
    }

    public String getValue(){
        return value;
    }

    public int getIntValue(){
        if(value.equals("")){
            return 0;
        }else{
            return Integer.parseInt(value);
        }
    }

    public Boolean getIsCorrect(){
        return isCorrect;
    }

    public int checkCorrect(Boolean isCorrect){
        if(this.isCorrect != isCorrect && !isCorrect){
            this.isCorrect = false;
            return 1;
        }else if(this.isCorrect != isCorrect && isCorrect){
            this.isCorrect = true;
            return -1;
        }else{
            return 0;
        }
    }
}
