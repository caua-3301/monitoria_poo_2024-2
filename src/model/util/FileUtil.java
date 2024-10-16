package model.util;

import model.entities.Student;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String PATH_TO_DATABASE = "src/model/database/students.txt";
    private static final int MAX_SIZE = 5;

    private static final int ID_CAMP = 1;

    public static String findById(String id) {
        List<String> students = findAll();

        students = students.stream().filter(student -> {
            String[] aux = student.split(",");

            if (aux.length > 1 && aux[ID_CAMP].contains(id)) {
                return true;
            }
            return false;
        }).toList();

        //retorna o estudante pelo id
        return !students.isEmpty() ? students.get(0) : null;
    }

    public static List<String> findAll() {
        List<String> students = new ArrayList<>();

        //lendo todos os registros do "banco de dados"
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_DATABASE))) {
            String aux = reader.readLine();

            while (aux != null) {
                students.add(aux);
                aux = reader.readLine();
            }
        } catch (IOException error) {
            System.out.println("Erro ao carregar todos:" + error.getMessage());
        }
        return students;
    }

    //salvando um único aluno
    public static boolean save(Student student) {
        //pegando todos os registros para adicionar o novo aluno nele e salvá-lo novamente
        List<String> oldStudents = findAll();

        //adição do novo aluno
        oldStudents.add(student.toString());

        //salvando no banco
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_DATABASE))) {
            //iterando sobre a lista e salvando no arquivo
            oldStudents.forEach(currentStudent -> {
                try {
                    writer.write(currentStudent);
                    writer.newLine();
                } catch (IOException error) {
                    throw new RuntimeException(error);
                }
            });

            return true;
        } catch (IOException error) {
            System.out.println("Erro ao salvar: " + error.getMessage());
        }
        return false;
    }

    //salva uma lista de alunos
    public static void saveAll(List<String> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_DATABASE))) {
            //iterando sobre a lista e salvando no arquivo
            students.forEach(currentStudent -> {
                try {
                    writer.write(currentStudent);
                    writer.newLine();
                } catch (IOException error) {
                    throw new RuntimeException(error);
                }
            });
        } catch (IOException error) {
            System.out.println("Erro ao salvar: " + error.getMessage());
        }
    }

    //atualiza um registro de aluno
    public static void update(Student student, String id) {
        List<String> students = findAll();

        //substitundo o registro do aluno com id informado pelo novo aluno
        List<String> newStudents = students.stream().map(currentStudent -> {
            String[] aux = currentStudent.split(",");
            if (aux.length > 1 && aux[ID_CAMP].contains(id)) {
                return student.toString();
            }
            return currentStudent;
        }).toList();

        JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        saveAll(newStudents);
    }

    public static void delete(String id) {
        List<String> students = findAll();
        List<String> newStudents = new ArrayList<>();

        String[] aux = new String[MAX_SIZE];

        for (String student : students) {
            aux = student.split(",");

            if (aux.length > 1 && !aux[1].contains(id)) {
                newStudents.add(student);
            }
        }

        saveAll(newStudents);
    }
}
