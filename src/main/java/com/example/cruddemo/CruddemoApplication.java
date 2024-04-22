package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            //createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Usuwanie wszystkich studentów");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Liczba usuniętych wierszy: "+numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
    int studentId=3;
        System.out.println("Usuwanie studenta z ID: "+ studentId);
        studentDAO.delete(studentId);
        System.out.println("Usunieto studenta");


    }

    private void updateStudent(StudentDAO studentDAO) {
        //Szukanie studenta w zaleznosci od Id
        int studentId = 1;
        System.out.println("Wuszukiwanie studenta z Id: "+ studentId);
        Student theStudent = studentDAO.findById(1);

        //Zmiana imienia
        System.out.println("Zmiana imienia");
        theStudent.setFirstName("Mark");

        //Aktualizacja studenta w db
        System.out.println("Aktualizacja...");
        studentDAO.update(theStudent);

        //Wyswietlanie

        System.out.println("Zaktualizowany student: "+ theStudent);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
    //Tworzenie listy studentow
        List<Student> listOfStudents = studentDAO.findByLastName("wetr");
    //Wyswietlanie studentow
        for(Student tempStudent : listOfStudents){
            System.out.println(tempStudent);
        }
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //Tworzenie kilku studentow
        System.out.println("Tworzenie 3 studentow");
        Student tempStudent1 = new Student("John","asd","john@asd.com");
        Student tempStudent2 = new Student("Jonny","sdf","jonny@asd.com");
        Student tempStudent3 = new Student("Vladimir","wetr","vladimir@asd.com");



        //Zapisanie studentow do db
        System.out.println("Zapisywanie studentów");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        //Tworzenie studenta
        System.out.println("Tworzenie nowego studenta");
        Student tempStudent = new Student("Paul","hjk","paul@asd.com");

        //Zapisanie do db

        System.out.println("Zapisywanie studenta");
        studentDAO.save(tempStudent);

        //Wyswietlanie

        System.out.println("Zapisywanie studenta"+ tempStudent.getId());
    }

    private void readStudent(StudentDAO studentDAO){
        //Tworzenie studenta
        System.out.println("Tworzenie nowego studenta");
        Student tempStudent = new Student("Patrick","eldorado","eldorado@asd.com");
        //Zapisanie w db
        System.out.println("Zapisywanie studenta");
        studentDAO.save(tempStudent);
        //Wyswitlanie id studenta
        int theId = tempStudent.getId();
        System.out.println("Zapisywanie studenta:"+theId);

        //Wyszukanie studenta z db
        Student myStudent = studentDAO.findById(theId);

        //Wyswietlanie studenta
        System.out.println("Znaleziono studenta z Id"+ myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO){
        //Tworzenie listy studentow
        List<Student> theStudents = studentDAO.findAll();

        //Wyswietlanie

        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
