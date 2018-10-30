/**
 * Copyright 2018 bejson.com
 */
package com.jzg.svsp.common.vo.report;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Auto-generated: 2018-09-19 23:53:33
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CheckItems {

    private List<JSONObject> defectValueList;
    private String checkItemName;

    public void setDefectValueList(List<JSONObject> defectValueList) {
        this.defectValueList = defectValueList;
    }

    public List<JSONObject> getDefectValueList() {
        return defectValueList;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }

    public String getCheckItemName() {
        return checkItemName;
    }

}