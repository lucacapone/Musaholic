import logic.boundary.ClassroomManageSystem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestClassroomManageSystem {
    @Test
     void  testGetClassroomAtChristmas(){
        //verify that the result is an empty string or requesting a classroom for christmasday
        LocalDate day = LocalDate.of(LocalDate.now().getYear(), 12, 25);;
        int time = 12;
        ClassroomManageSystem classroomManageSystem = new ClassroomManageSystem();
        assertEquals("",classroomManageSystem.getClassroom(day,time));
    }
}
