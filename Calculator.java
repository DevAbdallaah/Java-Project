package Java_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener {
    JFrame frame = new JFrame("Calculator.");
    JPanel panel;
    JButton[] numberBtn = new JButton[10];
    JButton[] operationBtn = new JButton[10];
    JTextField textField;
    JButton clearBtn, negBtn, modBtn, divBtn, mulBtn;
    JButton subBtn, addBtn, equalBtn, delBtn, dotBtn;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        clearBtn = new JButton("Clear");
        negBtn = new JButton("'-'");
        modBtn = new JButton("%");
        divBtn = new JButton("/");
        mulBtn = new JButton("*");
        subBtn = new JButton("-");
        addBtn = new JButton("+");
        equalBtn = new JButton("=");
        delBtn = new JButton("del");
        dotBtn = new JButton(".");

        operationBtn[0] = clearBtn;
        operationBtn[1] = negBtn;
        operationBtn[2] = modBtn;
        operationBtn[3] = divBtn;
        operationBtn[4] = mulBtn;
        operationBtn[5] = subBtn;
        operationBtn[6] = addBtn;
        operationBtn[7] = equalBtn;
        operationBtn[8] = delBtn;
        operationBtn[9] = dotBtn;

        for (int i = 0; i < operationBtn.length; i++) {
            operationBtn[i].setBackground(Color.ORANGE);
            operationBtn[i].addActionListener(this);
        }
        equalBtn.setBackground(Color.BLACK);
        equalBtn.setForeground(Color.WHITE);

        for (int i = 0; i < numberBtn.length; i++) {
            numberBtn[i] = new JButton(String.valueOf(i));
            numberBtn[i].addActionListener(this);
            numberBtn[i].setFocusable(false);
        }

        panel = new JPanel(new GridLayout(5, 4, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 20));

        panel.add(operationBtn[0]);
        panel.add(operationBtn[1]);
        panel.add(operationBtn[2]);
        panel.add(operationBtn[3]);

        panel.add(numberBtn[7]);
        panel.add(numberBtn[8]);
        panel.add(numberBtn[9]);
        panel.add(operationBtn[4]);

        panel.add(numberBtn[4]);
        panel.add(numberBtn[5]);
        panel.add(numberBtn[6]);
        panel.add(operationBtn[5]);

        panel.add(numberBtn[1]);
        panel.add(numberBtn[2]);
        panel.add(numberBtn[3]);
        panel.add(operationBtn[6]);

        panel.add(operationBtn[8]);
        panel.add(numberBtn[0]);
        panel.add(operationBtn[9]);
        panel.add(operationBtn[7]);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(380, 50));
        textField.setEditable(false);

        frame.add(textField);
        frame.add(panel);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 10; i++) {
            if (ae.getSource() == numberBtn[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (ae.getSource() == clearBtn) {
            textField.setText("");
        }
        if (ae.getSource() == dotBtn) {
            textField.setText(textField.getText().concat("."));
        }
        if (ae.getSource() == addBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (ae.getSource() == subBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (ae.getSource() == mulBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (ae.getSource() == divBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (ae.getSource() == modBtn) {
            num1 = Integer.parseInt(textField.getText());
            operator = '%';
            textField.setText("");
        }

        if (ae.getSource() == equalBtn) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    int modnum = (int) num2;
                    result = num1 % modnum;
            }
            textField.setText(String.valueOf(result));
        }

        if (ae.getSource() == negBtn) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

        if (ae.getSource() == delBtn) {
            String str = textField.getText();
            textField.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textField.setText(textField.getText() + str.charAt(i));
            }
        }

    }

    public static void main(String args[]) {
        new Calculator();
    }
}