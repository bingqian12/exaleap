/**
  * Copyright 2018 bejson.com 
  */
package ai.exaleap.common.vo.report;
import java.util.List;

/**
 * Auto-generated: 2018-09-19 23:53:33
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MaintenanceRecord {

    private List<RecordList> recordList;
    private String getRecordTime;
    private int isExist;
    public void setRecordList(List<RecordList> recordList) {
         this.recordList = recordList;
     }
     public List<RecordList> getRecordList() {
         return recordList;
     }

    public void setGetRecordTime(String getRecordTime) {
         this.getRecordTime = getRecordTime;
     }
     public String getGetRecordTime() {
         return getRecordTime;
     }

    public void setIsExist(int isExist) {
         this.isExist = isExist;
     }
     public int getIsExist() {
         return isExist;
     }

}