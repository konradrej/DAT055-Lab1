import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame("ImageViewer");
        JPanel panel = new JPanel();

        ArrayList<Cell> cells = new ArrayList<>();
        GameGenerator generator = new GameGenerator(4);

        int j = 0, k = 0;
        for(int i : generator){
            Cell cell = new Cell(j++, k, i);
            cell.setVisible(true);
            cells.add(cell);

            if(j == 4){
                k++;
                j = 0;
            }
        }

        for(Cell cell : cells){
            panel.add(cell);
        }

        frame.setPreferredSize(new Dimension(600, 600));
        panel.setVisible(true);
        panel.setLayout(new GridLayout(4,4,3,3));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
