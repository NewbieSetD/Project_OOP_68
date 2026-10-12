import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiGame extends JFrame{

    GuiGame(){
        set_up();
        add(new GamePanel());
        //add(new Button("Hi"));
    }
    private void set_up(){
        setTitle("Game");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}