import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameWindow extends JFrame {
    private final JPanel contentPanel = new JPanel();
    private final ArrayList<Cell> cells = new ArrayList<>();
    private Pos2D emptyCell;

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

            cells.add(cell);
            position++;
        }
    }

    public void handleClick(String actionCommand){
        Pos2D pos = Pos2D.parseString(actionCommand);

        System.out.println(pos.toString());
    }
}
