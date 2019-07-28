/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.util;

import java.util.Date;

/**
 *
 * @author nirbhay.p
 */
public class DemoUtil {
    private String message;
    
    private Integer responsecode;
    private Date timestamp;

      public DemoUtil()
      {
          
      }
    public DemoUtil(String message, Integer responsecode, Date timestamp) {
        this.message = message;
        this.responsecode = responsecode;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(Integer responsecode) {
        this.responsecode = responsecode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
        
}
