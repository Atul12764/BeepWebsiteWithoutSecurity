package com.checkbeep.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "address")

public class Address {
	
	public Address() {
		super();
	}
	@Column(name="address_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String fullName;
    private String address;
    private String postcode;
    private String city;
    private String state;
    private String country;
    private String mobileNo;
    private byte isPermanent;
    
    @OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_users_id")
 	private Users users;
    
   
    
    
	public Address(String fullName, String address, String postcode, String city, String state, String country,
			String mobileNo, byte isPermanent) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.mobileNo = mobileNo;
		this.isPermanent = isPermanent;
	}
	
	
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    
    @Column(name="full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="postcode")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="mobile_no")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name="is_permanent")
	public byte getIsPermanent() {
		return isPermanent;
	}

	public void setIsPermanent(byte isPermanent) {
		this.isPermanent = isPermanent;
	}
	
	

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", fullName=" + fullName + ", address=" + address + ", postcode=" + postcode
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", mobileNo=" + mobileNo
				+ ", isPermanent=" + isPermanent + "]";
	}
    
    
    
    
    

}
