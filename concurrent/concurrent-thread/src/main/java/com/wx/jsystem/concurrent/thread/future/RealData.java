package com.wx.jsystem.concurrent.thread.future;

/**
 * 描述: <br>
 *
 * @author huangjianwei <br>
 * 创建时间: 2020/4/23 13:59 <br>
 * <p>
 * Copyright: 2013 - 2020 www.szwcyq.com Inc. All rights reserved. <br>
 * 注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的<br>
 */
public class RealData implements Data {
    private String result;
    public RealData (String queryStr){
        System.out.println("根据" + queryStr + "进行查询，这是一个很耗时的操作..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完毕，获取结果");
        result = "查询结果";
    }
    public String getRequest() {
        return result;
    }
}
