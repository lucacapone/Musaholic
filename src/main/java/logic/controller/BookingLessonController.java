package logic.controller;

import logic.bean.DateBean;
import logic.bean.MusicalInstrumentBean;
import logic.bean.PriceBean;
import logic.bean.TimeBean;
import logic.model.Lesson;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class BookingLessonController {
    private Lesson lesson;
    public BookingLessonController(){
        this.lesson = new Lesson("",LocalDate.now(),"",-1,"","","",-1);
    }
    public void setBooking(DateBean d, MusicalInstrumentBean m, PriceBean p, TimeBean t){
        this.setDate(d);
        this.setPrice(p);
        this.setTime(t);
        this.setMusicalInstrument(m);



    }
    public boolean checkLessonDetails(DateBean dateBean, MusicalInstrumentBean musicalInstrumentBean, PriceBean priceBean, TimeBean timeBean){
        String date = dateBean.getDate();
        String musicalInstrument = musicalInstrumentBean.getMusicalInstrument();
        String price = priceBean.getPrice();
        String time = timeBean.getTime();
        return !Objects.equals(date, "") && !Objects.equals(musicalInstrument, "") && !Objects.equals(price, "") && !Objects.equals(time, "");
    }

    private void setDate(DateBean dateBean) {
        LocalDate date = LocalDate.parse(dateBean.getDate());
        this.lesson.setDate(date);
    }

    private void setMusicalInstrument(MusicalInstrumentBean musicalInstrumentBean) {
        this.lesson.setMusicalInstrument(musicalInstrumentBean.getMusicalInstrument());
    }

    private void setPrice(PriceBean priceBean) {
        int price = Integer.parseInt(priceBean.getPrice());
        this.lesson.setPrice(price);
    }

    private void setTime(TimeBean timeBean) {
        int time = Integer.parseInt(timeBean.getTime());
        this.lesson.setTime(time);
    }
}
