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
public class FutureData implements Data {
    private RealData realData ;
    private boolean isReady = false;
    public synchronized void setRealData(RealData realData) {
        //如果已经装载完毕了，就直接返回
        if(isReady){ return; }
        //如果没装载，进行装载真实对象
        this.realData = realData;
        isReady = true;
        //进行通知
        notify();
    }
    @Override
    public synchronized String getRequest() {
        //如果没装载好 程序就一直处于阻塞状态
        while(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //装载好直接获取数据即可
        return this.realData.getRequest();
    }
}
