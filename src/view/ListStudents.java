package view;

import controller.StudentController;
import model.util.FileUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListStudents {
    private JPanel mainPanel;
    private JTable mainTable;
    private JButton sairButton;
    private JScrollPane mainScroll;

    public ListStudents(CardLayout cardLayout, JPanel mainPanel) {
        //configurações da minha tabela
        String[] column = {"NOME", "MATRICULA", "CURSO", "IDADE", "DATA NASC"};
        String[][] dataToTable = StudentController.getDataToTable();

        mainTable.setModel(new DefaultTableModel(dataToTable, column));

        //definições do scrollPane
        mainScroll.setViewportView(mainTable);

        //adição de eventos
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
