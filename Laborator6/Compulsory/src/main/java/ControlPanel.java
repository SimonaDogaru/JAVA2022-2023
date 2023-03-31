

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");

    //create all buttons (Load, Exit, etc.)
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {


        setLayout(new GridLayout(1, 4));
        exitBtn.addActionListener(this::exitGame);

        add(exitBtn);
        add(saveBtn);
        add(loadBtn);

    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
