import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by san on 9/24/15.
 */
public class Frame extends JFrame {
    public Frame() throws HeadlessException {
        super("Квадратное уравнение");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panel());
        this.setVisible(true);
        this.setSize(300, 100);
        this.setResizable(false);

    }
}

class Panel extends JPanel{
    private JLabel label1, label2, label3, labelX1, labelX2;
    private JTextField fieldA, fieldB, fieldC, fieldX1, fieldX2;
    private JButton buttonResult;
    Panel(){
        this.setLayout(new FlowLayout());
        label1 = new JLabel("x²+");
        label2 = new JLabel("x+");
        label3 = new JLabel("=0");

        labelX1 = new JLabel("X1=");
        labelX2 = new JLabel("X2=");

        fieldA = new JTextField(2);
        fieldB = new JTextField(2);
        fieldC = new JTextField(2);

        fieldA.setHorizontalAlignment(JTextField.CENTER);
        fieldB.setHorizontalAlignment(JTextField.CENTER);
        fieldC.setHorizontalAlignment(JTextField.CENTER);

        fieldX1 = new JTextField(9);
        fieldX2 = new JTextField(9);

        fieldX1.setEditable(false);
        fieldX2.setEditable(false);

        buttonResult = new JButton("Посчитать");

        buttonResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(fieldA.getText());
                int b = Integer.parseInt(fieldB.getText());
                int c = Integer.parseInt(fieldC.getText());

                Equation equation = new Equation(a, b, c);

                String x1 = String.valueOf(equation.getX1());
                String x2 = String.valueOf(equation.getX2());
                if(equation.haveSolution == false) {
                    x1 = x2 = "Корня нет";
                }
                fieldX1.setText(x1);
                fieldX2.setText(x2);
            }
        });

        Component[] componentsQueue = {fieldA, label1, fieldB, label2, fieldC, label3,
                buttonResult, labelX1, fieldX1, labelX2, fieldX2};
        for(Component currentComponent : componentsQueue) this.add(currentComponent);


    }
}