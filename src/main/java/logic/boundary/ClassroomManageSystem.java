package logic.boundary;

import logic.bean.ClassroomAvailabilityBean;
import logic.bean.FreeClassroomBean;
import logic.exception.SyntaxBeanException;

import java.util.Random;
import java.time.LocalDate;

public class ClassroomManageSystem {


    public FreeClassroomBean findFreeClassroom(ClassroomAvailabilityBean classroomAvailabilityBean) throws SyntaxBeanException {
        LocalDate date = LocalDate.parse(classroomAvailabilityBean.getDate());
        int time = Integer.parseInt(classroomAvailabilityBean.getTime());
        //simulo API
        String classroom = getClassroom(date,time);

        FreeClassroomBean freeClassroomBean = new FreeClassroomBean();
        freeClassroomBean.setClassroom(classroom);
        return freeClassroomBean;

    }

    public String getClassroom(LocalDate d,int t){
        Random random = new Random();
        // Genera due numeri casuali tra 0 e 9
        int numero1 = random.nextInt(8)+ t%2; // Genera un numero casuale tra 0 e 9
        int numero2 = random.nextInt(8)+ d.getDayOfMonth()%2; // Genera un secondo numero casuale tra 0 e 9

        // Crea la stringa classe casuale
        return String.format("A%d%d", numero1, numero2);
    }
}
