import logic.bean.TimeBean;
import logic.exception.SyntaxBeanException;
import org.junit.jupiter.api.Test;

public class TestTimeBean {
    @Test
    public void testSetTimeOutOfRange(){
        TimeBean timeBean = new TimeBean();
        try{
            timeBean.setTime("24");
        }
        catch (SyntaxBeanException ex){
            assert(true);
        }
    }
}
