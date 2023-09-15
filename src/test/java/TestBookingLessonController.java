
import logic.bean.DateBean;
import logic.bean.MusicalInstrumentBean;
import logic.bean.PriceBean;
import logic.bean.TimeBean;
import logic.controller.BookingLessonController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBookingLessonController {

    @Test
    public void testCheckLessonDetails() {

        BookingLessonController bookingLessonController = new BookingLessonController();
        DateBean dateBean = new DateBean();
        MusicalInstrumentBean musicalInstrumentBean = new MusicalInstrumentBean();
        PriceBean priceBean = new PriceBean();
        TimeBean timeBean = new TimeBean();
        assertEquals(false, bookingLessonController.checkLessonDetails(dateBean, musicalInstrumentBean, priceBean, timeBean));

    }


}

