
package com.example.demo.dtob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nirbhay.p
 */
@Entity
@Table(name = "employee")
public class Emp {
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empno")
	private Long empno;
        
        @Column(name = "name", nullable = false)
        private String name;
        
        @Column
        private String address;
        
        @Column(name = "is_active")
        private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive)
    {
        this.isActive = isActive;
    }
    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) 
    {
        this.empno = empno;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }     
}
