import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameWindow extends JFrame {
    private final JPanel contentPanel = new JPanel();
    private final ArrayList<Cell> cells = new ArrayList<>();
    private Pos2D emptyCell;
    private int cellsLeft = 15;

    public GameWindow(){
        setTitle("The 15 game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        setLocation(50, 50);
        generateCells();

        contentPanel.setLayout(new GridLayout(4, 4, 3, 3));

        for(Cell cell : cells){
            contentPanel.add(cell);
        }

        add(contentPanel);
        pack();
        setVisible(true);
    }

    public void generateCells(){
        int position = 0;

        for(int value : new GameGenerator(4)){
            int col = position % 4;
            int row = position / 4;

            Pos2D pos = new Pos2D(col, row);
            Cell cell = new Cell(pos, value);

            cell.addActionListener((ActionEvent e) -> handleClick(e.getActionCommand()));

            if(value == 0){
                emptyCell = new Pos2D(col, row);
            }

            if(cell.getIsCorrect()){
                cellsLeft--;
            }

            cells.add(cell);
            position++;
        }
    }

    public void handleClick(String actionCommand){
        Pos2D pos = Pos2D.parseString(actionCommand);

        if(((pos.getCol() == emptyCell.getCol()-1 || pos.getCol() == emptyCell.getCol()+1) && pos.getRow() == emptyCell.getRow()) ||
                ((pos.getRow() == emptyCell.getRow()-1 || pos.getRow() == emptyCell.getRow()+1) && pos.getCol() == emptyCell.getCol())){
            int clickPosition = pos.getCol() + pos.getRow() * 4;
            int emptyPosition = emptyCell.getCol() + emptyCell.getRow() * 4;

            String value = cells.get(clickPosition).getValue();
            cells.get(emptyPosition).setValue(value);
            cells.get(clickPosition).setValue("");

            emptyCell = pos;

            cellsLeft += cells.get(clickPosition).checkCorrect((clickPosition+1) == cells.get(clickPosition).getIntValue());
            cellsLeft += cells.get(emptyPosition).checkCorrect((emptyPosition+1) == cells.get(emptyPosition).getIntValue());

            if(cellsLeft == 0){
                JOptionPane.showMessageDialog(
                        this,
                        "Congratulations you have won!",
                        "Congratulations!",
                        JOptionPane.PLAIN_MESSAGE
                );
            }
        }else{
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
