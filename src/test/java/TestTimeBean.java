import logic.bean.TimeBean;
import logic.exception.SyntaxBeanException;
import org.junit.jupiter.api.Test;

 class TestTimeBean {
    @Test
     void testSetTimeOutOfRange(){
        TimeBean timeBean = new TimeBean();
        try{
            timeBean.setTime("24");
            assert(false);
        }
        catch (SyntaxBeanException ex){
            assert(true);
        }
    }
}
