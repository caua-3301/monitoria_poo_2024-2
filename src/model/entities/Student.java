package model.entities;

import java.util.Date;

public class Student {
    private String name;
    //será o ID da minha entidade
    private String registration;
    private String course;
    private int age;

    //O IDEAL SERIA REALIZAR A LÓGICA DE CONVERSÃO ENTRE STRING -> DATA, devido ao tempo, essa abordagem foi escolhida
    private String registrationDate;

    public Student(String name, String registration, String course, int age, String registrationDate) {
        this.name = name;
        this.registration = registration;
        this.course = course;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return name + "," + registration + "," + course + "," + age + "," + registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
