package Symonenko.V;

import Symonenko.V.controller.*;
import Symonenko.V.model.*;
import Symonenko.V.utils.JsonManager;

import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        University university = run.createTypicalUniversity();
        run.printUniversityStructure(university);

        // Шлях до файлу JSON
        String filePath = "university.json";

        // Записуємо університет у файл у форматі JSON
        try {
            JsonManager jsonManager = new JsonManager();
            jsonManager.writeUniversityToFile(university, filePath);
            System.out.println("Університет успішно записано в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Помилка при запису університету в файл: " + e.getMessage());
        }

        // Читаємо університет з файлу JSON
        try {
            JsonManager jsonManager = new JsonManager();
            University restoredUniversity = jsonManager.readUniversityFromFile(filePath);
            System.out.println("Університет успішно прочитано з файлу: " + filePath);
            run.printUniversityStructure(restoredUniversity);
        } catch (IOException e) {
            System.err.println("Помилка при читанні університету з файлу: " + e.getMessage());
        }
    }

    public University createTypicalUniversity() {
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();

        // Створення директора університету
        Human universityHead = new Human("Volodymyr", "Symonenko", "Andreyovych", Sex.MALE) {};

        // Створення університету
        University university = universityCreator.createUniversity("NTU(DP)", universityHead);

        // Створення факультету університету
        Human facultyHead = new Human("Kyrylo", "Bublyk", "Olegovych", Sex.MALE) {};
        Faculty faculty = facultyCreator.createFaculty("Faculty of Computer Informatics", facultyHead);

        // Створення кафедри університету
        Human departmentHead = new Human("Angelina", "Jolie", "Voight", Sex.FEMALE) {};
        Department department = departmentCreator.createDepartment("Department of System Analysis", departmentHead);

        // Створення групи університету
        Human groupHead = new Human("Leonardo", "Wilhelm", "DiCaprio", Sex.MALE) {};
        Group group = groupCreator.createGroup("Group 124-21-1", groupHead);

        // Додавання студентів
        group.addStudent(studentCreator.createStudent("Christopher", "Robert", "Evans", Sex.MALE));
        group.addStudent(studentCreator.createStudent("Scarlett", "Ingrid", "Johansson", Sex.FEMALE));

        // Додавання підрозділів
        department.addGroup(group);
        faculty.addDepartment(department);
        university.addFaculty(faculty);

        return university;
    }

    public void printUniversityStructure(University university) {
        System.out.println("Університет: " + university.getName());

        Human universityHead = university.getHead();
        if (universityHead != null) {
            System.out.println("Голова університету: " + universityHead.getFullName());
        } else {
            System.out.println("Голова університету не встановлений.");
        }

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\tФакультет: " + faculty.getName());
            Human facultyHead = faculty.getHead();
            if (facultyHead != null) {
                System.out.println("\tГолова факультету: " + facultyHead.getFullName());
            } else {
                System.out.println("\tГолова факультету не встановлений.");
            }

            for (Department department : faculty.getDepartments()) {
                System.out.println("\t\tКафедра: " + department.getName());
                Human departmentHead = department.getHead();
                if (departmentHead != null) {
                    System.out.println("\t\tГолова кафедри: " + departmentHead.getFullName());
                } else {
                    System.out.println("\t\tГолова кафедри не встановлений.");
                }

                for (Group group : department.getGroups()) {
                    System.out.println("\t\t\tГрупа: " + group.getName());
                    Human groupHead = group.getHead();
                    if (groupHead != null) {
                        System.out.println("\t\t\tСтароста групи: " + groupHead.getFullName());
                    } else {
                        System.out.println("\t\t\tСтароста групи не встановлений.");
                    }

                    System.out.println("\t\t\tСтуденти:");
                    for (Student student : group.getStudents()) {
                        System.out.println("\t\t\t\t- " + student.getFullName() + " (" + student.getGender() + ")");
                    }
                }
            }
        }
    }
}