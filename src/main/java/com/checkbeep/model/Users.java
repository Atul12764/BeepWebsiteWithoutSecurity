package com.checkbeep.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "users")

public class Users {
	
	public Users() {
		super();
	}
	@Column(name="user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateOfBirth;
	
    private String mobileNo;
    private String password;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateOfCreation;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;
    
    private String userType;
    
    
    public Users(String firstName, String lastName, String emailId,Date dateOfBirth,
    		String mobileNo,String password,Date dateOfCreation,Date updatedDate,String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.dateOfBirth=dateOfBirth;
        this.mobileNo=mobileNo;
        this.password=password;
        this.dateOfCreation=dateOfCreation;
        this.updatedDate=updatedDate;
        this.userType=userType;
   }
    
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Column(name = "email_id",unique = true)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
    }
    
    @Column(name = "mobile_no")
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    @Column(name = "passowrd")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "date_of_creation")
    public Date getDateOfCreation() {
        return dateOfCreation;
    }
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation=dateOfCreation;
    }
    
    @Column(name = "updated_date")
    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate=updatedDate;
    }
    
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType= userType;
    }
    
	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", dateOfCreation=" + dateOfCreation + ", updatedDate=" + updatedDate + ", userType=" + userType
				+ "]";
	}
    

}
