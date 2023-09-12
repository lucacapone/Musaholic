package logic.model;

import java.time.LocalDate;

public class TeacherLesson {

    private String idTeacher;

    private String name;
    private LocalDate date;
    private String musicalInstrument;
    private int price;
    private int time;

    public TeacherLesson(String idTeacher, String name, LocalDate date, String musicalInstrument, int price, int time) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.date = date;
        this.musicalInstrument = musicalInstrument;
        this.price = price;
        this.time = time;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMusicalInstrument() {
        return musicalInstrument;
    }

    public void setMusicalInstrument(String musicalInstrument) {
        this.musicalInstrument = musicalInstrument;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getAll(){ return idTeacher+"-"+name+"-"+date.toString()+"-"+musicalInstrument+"-"+String.valueOf(price)+"-"+String.valueOf(time);}
    public String getLesson(){ return idTeacher+"   teacher:  "+name+"     price:   "+String.valueOf(price)+"€";}

}
