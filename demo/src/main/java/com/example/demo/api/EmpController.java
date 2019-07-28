/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.api;

import com.example.demo.dtob.EmpRequest;
import com.example.demo.service.EmpService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nirbhay.p
 */
@RestController
public class EmpController {
    
    @Autowired
    EmpService empService;
    
    @PostMapping("/saveEmployeeDetails")
	public String saveEmp(@RequestBody EmpRequest empReq,
			HttpServletRequest request) 
        {
		
		return empService.saveEmp(empReq);

	}
        
        @GetMapping("/getEmpBYNo/{empno}")
        public String getEmpBYNo(@PathVariable Long empno)
        {
            return empService.getEmpBYNo(empno);
        }
        
        @GetMapping("/getAllEmp")
        public String getAllEmp()
        {
            return empService.getAllEmp();
        }
    
}
