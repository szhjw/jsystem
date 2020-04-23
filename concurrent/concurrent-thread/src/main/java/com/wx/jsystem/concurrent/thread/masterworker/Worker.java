package com.wx.jsystem.concurrent.thread.masterworker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 描述: <br>
 *
 * @author huangjianwei <br>
 * 创建时间: 2020/4/23 15:22 <br>
 * <p>
 * Copyright: 2013 - 2020 www.szwcyq.com Inc. All rights reserved. <br>
 * 注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的<br>
 */
public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> workQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while(true){
            Task input = this.workQueue.poll();
            if(input == null) break;
            Object output = handle(input);
            this.resultMap.put(Integer.toString(input.getId()), output);
        }
    }

    private Object handle(Task input) {
        Object output = null;
        try {
            //处理任务的耗时。。 比如说进行操作数据库。。。
            Thread.sleep(500);
            output = input.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }


}
