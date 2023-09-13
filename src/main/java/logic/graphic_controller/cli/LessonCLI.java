package logic.graphic_controller.cli;

import logic.controller.BookingLessonController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println(listaStringhe.get(i));
        }
        System.out.println("insert idTeacher of the lesson you chose");
        String id = "";
        id = scanner.nextLine();
        //check sull'imput
        System.out.println("insert Name Surname teacher of the lesson you chose");
        String teacher = "";
        teacher = scanner.nextLine();
        //check sull'imput
        (new ConfirmationCLI(controller,id,teacher)).start();

    }
}
