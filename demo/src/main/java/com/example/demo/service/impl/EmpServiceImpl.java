/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;


import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONObject;
import com.example.demo.dtob.Emp;
import com.example.demo.dtob.EmpRequest;
import com.example.demo.repository.EmpDao;
import com.example.demo.service.EmpService;
import com.example.demo.util.DemoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nirbhay.p
 */
@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    EmpDao empDao;
    
    @Override
    public String saveEmp(EmpRequest empreq)
    {
        String res="";
        try{
        Emp emp=new Emp();
        emp.setAddress(empreq.getAddress());
        emp.setName(empreq.getName());
        emp.setIsActive(Boolean.FALSE);
        Emp empRes=empDao.save(emp);
        JSONObject jsonobj = new JSONObject();
        if(empRes!=null && empRes.getEmpno()>0)
        {
        jsonobj.put("responsecode", 200);
	jsonobj.put("timestamp", new Date());
	jsonobj.put("message", "OK");
        ObjectMapper mapperObj = new ObjectMapper();
	String Detail = mapperObj.writeValueAsString(empRes);
        jsonobj.put("data", new JSONObject(Detail) );
        }
        else
        {
        jsonobj.put("responsecode", 400);
	jsonobj.put("timestamp", new Date());
	jsonobj.put("message", "Failed");
        }
        res=jsonobj.toString();
        }
        catch(Exception ex)
        {
            DemoUtil resp=new DemoUtil("Exception is occurred",500,new Date());
           res=resp.toString();
        }
        return res;
    }

    @Override
    public String getEmpBYNo(Long empno) {
      String res="";
        try{
            JSONObject jsonobj = new JSONObject();
            Optional<Emp> emp= empDao.findById(empno);
            if(emp.isPresent())
            {
        jsonobj.put("responsecode", 200);
	jsonobj.put("timestamp", new Date());
	jsonobj.put("message", "OK");
        ObjectMapper mapperObj = new ObjectMapper();
	String Detail = mapperObj.writeValueAsString(emp.get());
        jsonobj.put("data", new JSONObject(Detail) );
            }
            else
            {
                jsonobj.put("responsecode", 404);
	      jsonobj.put("timestamp", new Date());
	      jsonobj.put("message", "Data not found");
            }
           res =jsonobj.toString();
        }
        catch(Exception ex)
        {
            DemoUtil resp=new DemoUtil("Exception is occurred",500,new Date());
           res=resp.toString();
        }
        return res;
    }

    @Override
    public String getAllEmp() {
       String res="";
        try{
            JSONObject jsonobj = new JSONObject();
            List<Emp> emp= empDao.findAll();
            if(emp!=null && emp.size()>0)
            {
                jsonobj.put("responsecode", 200);
	jsonobj.put("timestamp", new Date());
	jsonobj.put("message", "OK");
        ObjectMapper mapperObj = new ObjectMapper();
	String Detail = mapperObj.writeValueAsString(emp);
        jsonobj.put("data", new JSONArray(Detail) );
            }
            else
            {
                jsonobj.put("responsecode", 404);
	jsonobj.put("timestamp", new Date());
	jsonobj.put("message", "Data not found");
            }
           res =jsonobj.toString();
        }
        catch(Exception ex)
        {
            DemoUtil resp=new DemoUtil("Exception is occurred",500,new Date());
           res=resp.toString();
        }
        return res;
    }
    
}
