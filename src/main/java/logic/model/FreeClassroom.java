package logic.model;

import java.time.LocalDate;

public class FreeClassroom {

    private String classroom;

    public FreeClassroom(String classroom) {

        this.classroom = classroom;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
