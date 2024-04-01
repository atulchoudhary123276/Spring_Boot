package com.tag;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Random;

public class RandomNumberTag extends SimpleTagSupport {
    private int min;  //attribute  1
    private int max;   //attribute 2
    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }
    @Override
    public void doTag() throws IOException {
        Random rand = new Random();
        int randomNumber = rand.nextInt((max - min) + 1) + min;
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
                out.write(Integer.toString(randomNumber));
    }
}

