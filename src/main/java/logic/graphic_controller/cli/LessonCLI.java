package logic.graphic_controller.cli;

import logic.bean.IndexChoseBean;
import logic.controller.BookingLessonController;
import logic.exception.SyntaxBeanException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static logic.graphic_controller.cli.HomeCLI.SYNTAX_ERROR;

public class LessonCLI {
    
    BookingLessonController controller;

    public LessonCLI(BookingLessonController controller) {this.controller=controller;}

    public void start() {
        System.out.println("Book Lesson / Chose Lesson:");
        Scanner scanner = new Scanner(System.in);
        List<String> listaStringhe = new ArrayList<>();
        controller.getLessonList().forEach(obj -> {
            String stringa = obj.getLesson()+"     classroom: "+controller.getClassroom().getClassroom();
            listaStringhe.add(stringa);
        });
        for(int i=0;i<listaStringhe.size();i++){
            System.out.println(i+" idTeacher:"+listaStringhe.get(i));
        }
        System.out.println("insert the index of the chosen lesson");
        IndexChoseBean indexChoseBean = new IndexChoseBean();
        try {
            indexChoseBean.setIndex(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            LessonCLI lessonCLI = new LessonCLI(controller);
            lessonCLI.start();
        }

        //check sull'imput
        (new ConfirmationCLI(controller,indexChoseBean)).start();

    }
}
