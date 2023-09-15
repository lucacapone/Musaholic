import logic.bean.TimeBean;
import logic.exception.SyntaxBeanException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

class TestTimeBean {
    @Test
     void testSetTimeOutOfRange(){
        TimeBean timeBean = new TimeBean();

        // Verifica che impostare il tempo su "24" generi un'eccezione SyntaxBeanException
        assertThrows(SyntaxBeanException.class, () -> {
            timeBean.setTime("24");
        });
    }
}
