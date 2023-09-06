package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {
    private StudentListFileDatasource datasource;

    @BeforeEach
    public void setUp(){
        datasource = new StudentListFileDatasource("data", "test.csv");
    }

    @Test
    public void testWriteData(){
        StudentList studentsToWrite = new StudentList();
        studentsToWrite.addNewStudent("6xxxxxxxx", "Lisa", 90.0);
        studentsToWrite.addNewStudent("6xxxxxxx1", "Love", 60.0);

        datasource.writeData(studentsToWrite);
        StudentList studentsRead = datasource.readData();
        assertEquals(2, studentsRead.getStudents().size());
    }

    @Test
    public void testReadData(){
        StudentList students = datasource.readData();
        assertEquals("6xxxxxxxx", students.getStudents().get(0).getId());
        assertEquals("6xxxxxxx1", students.getStudents().get(1).getId());
        assertEquals("Lisa", students.getStudents().get(0).getName());
        assertEquals("Love", students.getStudents().get(1).getName());
        assertEquals(90.0, students.getStudents().get(0).getScore(), 0.01);
        assertEquals(60.0, students.getStudents().get(1).getScore(), 0.01);

    }

}