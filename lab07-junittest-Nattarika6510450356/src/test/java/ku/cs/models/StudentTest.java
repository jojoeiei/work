package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Assertions เป็นการเปรียบเทียบค่า


class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อนักเรียน")
    void testChangeName(){
        Student s = new Student("6xxxxxxxxx", "StudentNewName");
        s.changeName("Love"); // เรียกให้เปลี่ยนชื่อ
        assertEquals("Love", s.getName());
    }

    @Test
    @DisplayName("ทดสอบรหัสนิสิต")
    void testIsId(){
        Student s = new Student("6xxxxxxxxx", "StudentId");
        s.isId("6xxxxxxxxx"); // ตั้งตัวแปรเก็บค่า actual (มี หรือ ไม่มีก็ได้)
        assertEquals("6xxxxxxxxx", s.getId());
    }

}