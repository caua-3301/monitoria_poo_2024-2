package controller;

import view.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainController extends JFrame {
    //definindo o CardLayout e o JPane principal para a aplicação
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel;

    //método responsável pela adição dos "Panes" das outras telas da aplicação
    private void loadReferencesInCardLayout() {
        //adicionando a referencia da home
        //para todos os componenetes relacionados são fornecidos duas referencia, uma do card e outra do pane principal
        mainPanel.add(new Home(cardLayout, mainPanel).getMainPanel(), "Home");

        //adicionando referência da página de cadastro de aluno
        mainPanel.add(new RegisterStudent(cardLayout, mainPanel).getMainPanel(), "RegisterStudent");

        //referencia da página de exibiçãp
        mainPanel.add(new ListStudents(cardLayout, mainPanel).getMainPanel(), "ListStudents");

        //adicionando referencia da página de atualização
        mainPanel.add(new UpdateStudent(cardLayout, mainPanel).getPanel1(), "Update");

        //adicionando referencia da página para deleção
        mainPanel.add(new DeleteStudent(cardLayout, mainPanel).getPanel1(), "Delete");

    }
    public MainController() {
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        loadReferencesInCardLayout();

        //definindo prorpriedades do JFrame
        setSize(530, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        //adição do pane principal
        add(mainPanel);

        setVisible(true);
    }
}
