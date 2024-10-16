package view;

import controller.StudentController;
import model.entities.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudent {
    private JPanel panel1;
    private JTextField digiteAquiTextField;
    private JButton verificarButton;
    private JButton cancelarButton;

    public UpdateStudent(CardLayout cardLayout, JPanel mainPanel) {
        //adição dos eventos
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //passando o id digitado no textLabel
                StudentController.updateStudent(digiteAquiTextField.getText());
                digiteAquiTextField.setText("");
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });
    }

    public JPanel getPanel1() {
        return this.panel1;
    }
}
