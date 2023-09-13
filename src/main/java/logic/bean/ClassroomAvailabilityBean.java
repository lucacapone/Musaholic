package logic.bean;

import logic.exception.SyntaxBeanException;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;

public class ClassroomAvailabilityBean implements Serializable {

    private String time;
    private String date;

    public String getTime() {
        return time;
    }

    public void setTime(String time) throws SyntaxBeanException {
        timeSyntaxCheck(time);
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws SyntaxBeanException {

        dateSyntaxCheck(date);
        this.date = date;
    }

    private void timeSyntaxCheck(String time) throws SyntaxBeanException {
        try {
            int t = Integer.parseInt(time);
            if (t < 0 || t > 23) {
                throw new SyntaxBeanException("Syntax error in time");
            }
        }
        catch (NumberFormatException exception ) {
            throw new SyntaxBeanException("number format error: input invalid") ;
        }
    }

    private void dateSyntaxCheck(String date) throws SyntaxBeanException {
        try {
            LocalDate.parse(date);
        }
        catch (DateTimeException exception ) {
            throw new SyntaxBeanException("date error: input invalid") ;
        }
    }
}


