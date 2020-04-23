package com.wx.jsystem.concurrent.thread.future;

/**
 * 描述: <br>
 *
 * @author huangjianwei <br>
 * 创建时间: 2020/4/23 13:55 <br>
 * <p>
 * Copyright: 2013 - 2020 www.szwcyq.com Inc. All rights reserved. <br>
 * 注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的<br>
 */
public class Main {
    public static void main(String[] args) {
        FutureClient fc = new FutureClient();
        Data data = fc.request("请求参数");
        System.out.println("请求发送成功!");
        System.out.println("做其他的事情...");

        String result = data.getRequest();
        System.out.println(result);
    }
}
