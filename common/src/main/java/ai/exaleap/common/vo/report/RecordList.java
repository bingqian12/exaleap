/**
  * Copyright 2018 bejson.com 
  */
package ai.exaleap.common.vo.report;
import java.util.Date;

/**
 * Auto-generated: 2018-09-19 23:53:33
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RecordList {

    private Date date;
    private String type;
    private String content;
    private int mileage;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

    public void setMileage(int mileage) {
         this.mileage = mileage;
     }
     public int getMileage() {
         return mileage;
     }

}