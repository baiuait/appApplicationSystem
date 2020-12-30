package cn.appManager.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式转换
 */
public class DateFormatTag extends SimpleTagSupport {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String dataFormat = "";
        if(date != null){
            dataFormat = new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        JspWriter out =getJspContext().getOut();
        out.print(dataFormat);
    }
}
