package view.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CardInputUpdate extends JPanel {
    JPanel mainPanel = new JPanel();
    public CardInputUpdate() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Novas informações");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(new EmptyBorder(15, 0, 15, 0));

        //inputs
        JTextField name = new JTextField("Informe o nome");
        JTextField age = new JTextField("Informe a idade");
        JTextField matricula = new JTextField("Informe a matricula");
        JTextField dataMatricula = new JTextField("Informe a data de matricula");
        JTextField couser = new JTextField("Informe o curso");

        mainPanel.add(title);

        mainPanel.add(name);
        mainPanel.add(age);
        mainPanel.add(matricula);
        mainPanel.add(dataMatricula);
        mainPanel.add(couser);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
