/**
  * Copyright 2018 bejson.com 
  */
package com.jzg.svsp.common.vo.report;
import com.jzg.svsp.common.vo.BaseVo;

import java.util.List;

/**
 * Auto-generated: 2018-09-19 23:53:33
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data implements BaseVo{

    private ProcedureDetail procedureDetail;
    private List<CarConfig> carConfig;
    private RemainingValue remainingValue;
    private String orderNum;
    private String jzgOrderNum;
    private MaintenanceRecord maintenanceRecord;
    private List<String> additionalPic;
    private BasicDetail basicDetail;
    private List<ReportDetail> reportDetail;
    private ReportLink reportLink;
    private ResultDetail resultDetail;
    private List<String> procedurePic;
    private List<BasicPic> basicPic;
    public void setProcedureDetail(ProcedureDetail procedureDetail) {
         this.procedureDetail = procedureDetail;
     }
     public ProcedureDetail getProcedureDetail() {
         return procedureDetail;
     }

    public void setCarConfig(List<CarConfig> carConfig) {
         this.carConfig = carConfig;
     }
     public List<CarConfig> getCarConfig() {
         return carConfig;
     }

    public void setRemainingValue(RemainingValue remainingValue) {
         this.remainingValue = remainingValue;
     }
     public RemainingValue getRemainingValue() {
         return remainingValue;
     }

    public void setOrderNum(String orderNum) {
         this.orderNum = orderNum;
     }
     public String getOrderNum() {
         return orderNum;
     }

    public void setJzgOrderNum(String jzgOrderNum) {
         this.jzgOrderNum = jzgOrderNum;
     }
     public String getJzgOrderNum() {
         return jzgOrderNum;
     }

    public void setMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
         this.maintenanceRecord = maintenanceRecord;
     }
     public MaintenanceRecord getMaintenanceRecord() {
         return maintenanceRecord;
     }

    public void setAdditionalPic(List<String> additionalPic) {
         this.additionalPic = additionalPic;
     }
     public List<String> getAdditionalPic() {
         return additionalPic;
     }

    public void setBasicDetail(BasicDetail basicDetail) {
         this.basicDetail = basicDetail;
     }
     public BasicDetail getBasicDetail() {
         return basicDetail;
     }

    public void setReportDetail(List<ReportDetail> reportDetail) {
         this.reportDetail = reportDetail;
     }
     public List<ReportDetail> getReportDetail() {
         return reportDetail;
     }

    public void setReportLink(ReportLink reportLink) {
         this.reportLink = reportLink;
     }
     public ReportLink getReportLink() {
         return reportLink;
     }

    public void setResultDetail(ResultDetail resultDetail) {
         this.resultDetail = resultDetail;
     }
     public ResultDetail getResultDetail() {
         return resultDetail;
     }

    public void setProcedurePic(List<String> procedurePic) {
         this.procedurePic = procedurePic;
     }
     public List<String> getProcedurePic() {
         return procedurePic;
     }

    public void setBasicPic(List<BasicPic> basicPic) {
         this.basicPic = basicPic;
     }
     public List<BasicPic> getBasicPic() {
         return basicPic;
     }

}