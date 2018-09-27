/**
  * Copyright 2018 bejson.com 
  */
package com.jzg.svsp.common.vo.report;
import java.util.List;

/**
 * Auto-generated: 2018-09-19 23:53:33
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ReportDetail {

    private String checkProject;
    private List<CheckItems> checkItems;
    private String diagrammaticLink;
    public void setCheckProject(String checkProject) {
         this.checkProject = checkProject;
     }
     public String getCheckProject() {
         return checkProject;
     }

    public void setCheckItems(List<CheckItems> checkItems) {
         this.checkItems = checkItems;
     }
     public List<CheckItems> getCheckItems() {
         return checkItems;
     }

    public void setDiagrammaticLink(String diagrammaticLink) {
         this.diagrammaticLink = diagrammaticLink;
     }
     public String getDiagrammaticLink() {
         return diagrammaticLink;
     }

}