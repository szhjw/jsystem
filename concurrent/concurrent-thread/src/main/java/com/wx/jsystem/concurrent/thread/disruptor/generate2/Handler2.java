package com.wx.jsystem.concurrent.thread.disruptor.generate2;

import com.lmax.disruptor.EventHandler;
import com.wx.jsystem.concurrent.thread.disruptor.generate1.Trade;

public class Handler2 implements EventHandler<Trade> {
	  
    @Override  
    public void onEvent(Trade event, long sequence,  boolean endOfBatch) throws Exception {  
    	System.out.println("handler2: set price");
    	event.setPrice(17.0);
    	Thread.sleep(1000);
    }  
      
}  