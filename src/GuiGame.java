import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiGame extends JFrame{

    GuiGame(){
        set_up();
    }
    private void set_up(){
        setTitle("Game");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
    }
}