package com.wx.jsystem.concurrent.thread.future;

/**
 * 描述: <br>
 *
 * @author huangjianwei <br>
 * 创建时间: 2020/4/23 13:56 <br>
 * <p>
 * Copyright: 2013 - 2020 www.szwcyq.com Inc. All rights reserved. <br>
 * 注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的<br>
 */
public class FutureClient {

    public Data request(final String queryStr){
        //1 我想要一个代理对象（Data接口的实现类）先返回给发送请求的客户端，告诉他请求已经接收到，可以做其他的事情
        final FutureData futureData = new FutureData();
        //2 启动一个新的线程，去加载真实的数据，传递给这个代理对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                //3 这个新的线程可以去慢慢的加载真实对象，然后传递给代理对象
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }
}
