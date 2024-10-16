package view;

import controller.StudentController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent {
    private JPanel panel1;
    private JTextField digiteAquiTextField;
    private JButton deletarButton;
    private JButton cancelarButton;

    public DeleteStudent(CardLayout cardLayout, JPanel mainPanel) {
        //adição de eventos
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentController.deleteStudent(digiteAquiTextField.getText());
                digiteAquiTextField.setText("");
            }
        });
    }

    public JPanel getPanel1() {
        return this.panel1;
    }
}
