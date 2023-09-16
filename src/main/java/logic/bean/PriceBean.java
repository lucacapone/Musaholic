package logic.bean;

import logic.exception.SyntaxBeanException;

import java.io.Serializable;

public class PriceBean implements Serializable {

    private String price = "";

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) throws SyntaxBeanException {

        syntaxCheck(price);
        this.price = price;
    }

    private void syntaxCheck(String price) throws SyntaxBeanException {
        try {
            double p = Double.parseDouble(price);

            if (p < 0) {
                throw new SyntaxBeanException("Syntax error in price");
            }
        } catch (NumberFormatException exception) {
            throw new SyntaxBeanException("number format error: input invalid");
        }
    }


}
