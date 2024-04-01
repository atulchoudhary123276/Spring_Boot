package com.tag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            //task ... tag
            JspWriter out= pageContext.getOut();
            out.println("<h>this is my custom tag");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
