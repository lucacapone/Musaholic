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
        String classroom = getClassroom(date,time);

        FreeClassroomBean freeClassroomBean = new FreeClassroomBean();
        freeClassroomBean.setClassroom(classroom);
        return freeClassroomBean;

    }

    public String getClassroom(LocalDate d,int t){
        // Genera due numeri casuali tra 0 e 9
        int numero1 = t%10; // Genera un numero casuale tra 0 e 9
        int numero2 = d.getDayOfMonth()%10; // Genera un secondo numero casuale tra 0 e 9

        // Crea la stringa classe casuale
        return String.format("A%d%d", numero1, numero2);
    }
}
