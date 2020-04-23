package com.wx.jsystem.concurrent.thread.masterworker;

import java.util.Random;

/**
 * 描述: <br>
 *
 * @author huangjianwei <br>
 * 创建时间: 2020/4/23 15:21 <br>
 * <p>
 * Copyright: 2013 - 2020 www.szwcyq.com Inc. All rights reserved. <br>
 * 注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的<br>
 */
public class Main {

    public static void main(String[] args) {
        Master master=new Master(new Worker(),10);

        Random r = new Random();
        for(int i = 1; i <= 100; i++){
            Task t = new Task();
            t.setId(i);
            t.setPrice(r.nextInt(1000));
            master.submit(t);
        }
        master.execute();
        long start = System.currentTimeMillis();

        while(true){
            if(master.isComplete()){
                long end = System.currentTimeMillis() - start;
                int priceResult = master.getResult();
                System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
                break;
            }
        }

    }
}
