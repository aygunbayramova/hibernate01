package com.iktex.clients;

import com.iktex.models.*;
import com.iktex.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CourseApiClient {
    public static void main(String[] args) {

        Student sturent1=new Student("Aygun", LocalDate.of(1986,5,10),"Azerbaijan","Female");
        Student sturent2=new Student("Sevinc", LocalDate.of(1985,10,8),"Azerbaijan","Female");

        Course course1=new Course("Hibernate","hb01",9.8);
        Course course2=new Course("Core Java","java",8.0);

        course1.getStudentList().add(sturent1);
        sturent1.getCourseList().add(course1);

        course1.getStudentList().add(sturent2);
        sturent2.getCourseList().add(course1);

        course2.getStudentList().add(sturent2);
        sturent2.getCourseList().add(course2);

        Instructor instructor1=new PermamentInstructor("Koray Guney", "Turkey", "0123", 10000);
        Instructor instructor2=new VisitingResearcher("Ali Akin", "Turkey", "4564564", 200);

        instructor1.getCourseList().add(course1);
        course1.setInstructor(instructor1);

        instructor2.getCourseList().add(course2);
        course2.setInstructor(instructor2);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(course1);
            em.persist(course2);

            em.persist(instructor1);
            em.persist(instructor2);

            em.persist(sturent1);
            em.persist(sturent2);

            em.getTransaction().commit();
            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

}
