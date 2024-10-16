package controller;

import model.entities.Student;
import model.util.FileUtil;
import view.components.CardInputUpdate;

import javax.swing.*;
import java.util.List;

public class StudentController {

    //método que prepara os dados para serem exibidos na tabela, basicamente ele "converte" a lista de Strings em uma matriz
    public static String[][] getDataToTable() {
        List<String> students = FileUtil.findAll();

        int row = 0;

        //possui x linhas e apenas uma coluna
        String[][] dataToTable = new String[students.size()][1];

        //para cada aluno (registro no arquivo), é preparado uma array para ele (studen.split), e depois, é adicionado com item da matriz
        for (String student : students) {
            dataToTable[row] = student.split(",");
            row+=1;
        }
        return dataToTable;
    }

    public static boolean saveStudent(Student student) {
        if (FileUtil.save(student)) {
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static void updateStudent(String id) {
        //verificando se o user existe
        String student = FileUtil.findById(id);

        if (student != null) {
            JPanel panelToShow = new CardInputUpdate().getMainPanel();
            JOptionPane.showMessageDialog(null, panelToShow, "Novas informações", JOptionPane.INFORMATION_MESSAGE);

            JTextField name = (JTextField) panelToShow.getComponent(1);
            JTextField age = (JTextField) panelToShow.getComponent(2);
            JTextField matricula = (JTextField) panelToShow.getComponent(3);
            JTextField dataMatricula = (JTextField) panelToShow.getComponent(4);
            JTextField curso = (JTextField) panelToShow.getComponent(5);

            FileUtil.update(new Student(name.getText(), matricula.getText(), curso.getText(), Integer.parseInt(age.getText()), dataMatricula.getText()), id);

        }
        else {
            JOptionPane.showMessageDialog(null, "O usuário com esse id não está cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void deleteStudent(String id) {
        String student = FileUtil.findById(id);

        if (student != null) {
            FileUtil.delete(id);
            JOptionPane.showMessageDialog(null, "Estudante deletado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Estudante não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
