package logic.model;

import java.time.LocalDate;

public class Lesson {
    private String idStudent;
    private LocalDate date;
    private String musicalInstrument;
    private int price;
    private String idTeacher;
    private String teacher;
    private String classroom;
    private int time;

    public String getIdStudent() {

        return idStudent;
    }

    public LocalDate getDate() {

        return date;
    }

    public String getMusicalInstrument() {

        return musicalInstrument;
    }

    public int getPrice() {

        return price;
    }

    public String getIdTeacher() {

        return idTeacher;
    }

    public String getTeacher() {

        return teacher;
    }

    public String getClassroom() {

        return classroom;
    }

    public int getTime() {

        return time;
    }

    public String getAll() {
        return idStudent + "-" + date.toString() + "-" + musicalInstrument + "-" + price + "-" + idTeacher + "-" + teacher + "-" + classroom + "-" + time;
    }


    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMusicalInstrument(String musicalInstrument) {
        this.musicalInstrument = musicalInstrument;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
