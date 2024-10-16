package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel mainPanel;
    private JButton visualizarAlunosButton;
    private JButton cadastrarAlunoButton;
    private JButton editarAlunoButton;
    private JButton deletarButton;

    public Home(CardLayout cardLayout, JPanel mainLayout) {
        //adição de eventos
        cadastrarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //utilizando o carLayout e Pane principal para transição
                cardLayout.show(mainLayout, "RegisterStudent");
            }
        });

        //visualizar estudantes
        visualizarAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gerando uma nova instancia dos componenetes para atualização dos dados na exibição
                mainLayout.add(new ListStudents(cardLayout, mainLayout).getMainPanel(), "ListStudents");
                cardLayout.show(mainLayout, "ListStudents");
            }
        });

        //atualização dos estudantes
        editarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainLayout, "Update");
            }
        });

        //dela de remoção
        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainLayout, "Delete");
            }
        });
    }

    //disponibilizando uma referência do panel dessa tela para meu controlador principal
    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
