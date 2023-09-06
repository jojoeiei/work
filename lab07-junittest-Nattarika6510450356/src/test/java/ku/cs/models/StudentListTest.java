package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class StudentListTest {

    @Test
    @DisplayName("ทดสอบเพิ่มนิสิต")
    void testAddNewStudent(){
        StudentList s = new StudentList();
        s.addNewStudent("6xxxxxxxx", "Lisa");
        assertEquals("Lisa", s.findStudentById("6xxxxxxxx").getName());
    }

    @Test
    @DisplayName("ทดสอบเพิ่มนิสิต2")
    void testAddNewStudentt(){
        StudentList s = new StudentList();
        s.addNewStudent("6xxxxxxxx", "Lisa", 100);
        assertEquals("Lisa", s.findStudentById("6xxxxxxxx").getName());
    }

    @Test
    @DisplayName("ทดสอบหานิสิตจากไอดี")
    void testFindStudentById(){
        StudentList s = new StudentList();
        s.addNewStudent("6xxxxxxxx", "Lisa");
        assertEquals("Lisa", s.findStudentById("6xxxxxxxx").getName());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนน")
    void testGiveScoreToId(){
        StudentList s = new StudentList();
        s.addNewStudent("6xxxxxxxx", "Lisa");
        s.giveScoreToId("6xxxxxxxx", 50);
        assertEquals(50, s.findStudentById("6xxxxxxxx").getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดจากไอดี")
    void testViewGradeOfId(){
        StudentList s = new StudentList();
        String id = "6xxxxxxxx";
        String grade = s.viewGradeOfId(id);
        assertNull(grade);
    }
}