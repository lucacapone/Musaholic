package logic.boundary;

import logic.bean.ClassroomAvailabilityBean;
import logic.bean.FreeClassroomBean;
import logic.exception.SyntaxBeanException;

import java.time.LocalDate;

public class ClassroomManageSystem {


    public FreeClassroomBean findFreeClassroom(ClassroomAvailabilityBean classroomAvailabilityBean) throws SyntaxBeanException {
        LocalDate date = LocalDate.parse(classroomAvailabilityBean.getDate());
        int time = Integer.parseInt(classroomAvailabilityBean.getTime());
        //simulate API
        String classroom = getClassroom(date, time);

        FreeClassroomBean freeClassroomBean = new FreeClassroomBean();
        freeClassroomBean.setClassroom(classroom);
        return freeClassroomBean;

    }

    public String getClassroom(LocalDate d, int t) {
        //Generate two random numbers between 0 and 9
        int numero1 = t % 10; // Generate a random numbers between 0 and 9
        int numero2 = d.getDayOfMonth() % 10; //Generate a random numbers between 0 and 9
        if (d.getDayOfMonth() == 25 && d.getMonthValue() == 12) {
            return "";
        }

        // Create the random class string
        return String.format("A%d%d", numero1, numero2);
    }
}
