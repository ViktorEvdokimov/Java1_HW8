import javax.swing.*;

public class Calc {
    Window window;
    public Calc() {
        window = new Window();
    }

    private class Window extends JFrame {
        private Window(){
            setTitle("Calculator");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(300,300,400,400);
            setVisible(true);
        }
    }
}
