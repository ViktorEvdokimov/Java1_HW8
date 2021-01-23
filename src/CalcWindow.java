import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CalcWindow  extends JFrame {


      public CalcWindow(){
            setTitle("Calculator");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(300,300,200,300);
            setVisible(true);

            JPanel top = new JPanel();
            top.setLayout(new BorderLayout());
            JTextField textField = new JTextField();
            textField.setEditable(false);
            top.add(textField, BorderLayout.BEFORE_FIRST_LINE);

            JPanel wright = new JPanel();
            wright.setLayout(new GridLayout(4,1));
            JButton sum = new JButton("+");
            sum.addActionListener(new AbstractAction() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        String value = button.getText();
                        StringBuilder sb = new StringBuilder(textField.getText());
                        sb.append(button.getText());
                        textField.setText(sb.toString());
                  }
            });
            wright.add(sum);
            JButton minus = new JButton("-");
            minus.addActionListener(new AbstractAction() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        String value = button.getText();
                        StringBuilder sb = new StringBuilder(textField.getText());
                        sb.append(button.getText());
                        textField.setText(sb.toString());
                  }
            });
            wright.add(minus);
            JButton calculate = new JButton("=");
            calculate.addActionListener(new AbstractAction() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String[] values = textField.getText().split("\\+");
                        int sum = Integer.parseInt(values[0])+Integer.parseInt(values[1]);
                        textField.setText(String.valueOf(sum));
                  }
            });
            wright.add(calculate);
            JButton clear = new JButton("C");
            clear.addActionListener(new AbstractAction() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        textField.setText("");
                  }
            });
            wright.add(clear);

            DigitButtonListener digitButtonListener = new DigitButtonListener(textField);

            JPanel center = new JPanel();
            center.setLayout(new GridLayout(4,3));
            add(top, BorderLayout.BEFORE_FIRST_LINE);
            add(wright, BorderLayout.LINE_END);
            add(center, BorderLayout.CENTER);
            for (int i=0; i<=9; i++){
                int j = i==9 ? 0 : i+1;
                JButton digitButton = new JButton(""+j);
                digitButton.addActionListener(digitButtonListener);
                center.add(digitButton);
            }
        }


}
