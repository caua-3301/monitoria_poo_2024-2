package view;

import controller.StudentController;
import model.entities.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterStudent {
    private JPanel mainPanel;
    private JTextField nome;
    private JTextField matricula;
    private JTextField curso;
    private JTextField idade;
    private JTextField dataMatricula;
    private JButton sairButton;
    private JButton cadastrarButton;
    private JLabel subLabel;

    public RegisterStudent(CardLayout cardLayout, JPanel mainPanel) {
        //ajustes no estilo
        subLabel.setBorder(new EmptyBorder(10, 0, 35, 0));

        //adição de eventos
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });

        //ação de salvar novo aluno
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //separando os dados que foram informados
                Student student = new Student(nome.getText(), matricula.getText(), curso.getText(), Integer.parseInt(idade.getText()), dataMatricula.getText());

                // se estiver correto, os campos são limpos
                if (StudentController.saveStudent(student)) {
                    nome.setText("");
                    matricula.setText("");
                    curso.setText("");
                    idade.setText("");
                    dataMatricula.setText("");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
