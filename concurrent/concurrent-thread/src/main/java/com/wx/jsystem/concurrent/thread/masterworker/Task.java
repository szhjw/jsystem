package com.wx.jsystem.concurrent.thread.masterworker;

/**
 * 描述: <br>
 *
 * @author huangjianwei <br>
 * 创建时间: 2020/4/23 15:22 <br>
 * <p>
 * Copyright: 2013 - 2020 www.szwcyq.com Inc. All rights reserved. <br>
 * 注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的<br>
 */
public class Task {

    private int id;
    private int price ;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
