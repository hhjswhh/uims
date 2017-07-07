package com.sdu.uims.vo;

public class User {
	private String phone;
	private String img;
	private String name;
	private String sex;
	private String mail;
	private String addr;
	private String password;
	private String type;
	private String deleteState;
	public User(){
		
	}
	public User(String phone,String img,String name,String password,String type,String sex,String mail,String addr,String deleteState){
		this.addr=addr;
		this.phone=phone;
		this.img=img;
		this.name=name;
		this.sex=sex;
		this.mail=mail;
		this.password=password;
		this.type=type;
		this.deleteState=deleteState;
	}
	public User(String phone,String password,String type){
		this.phone=phone;
		this.password=password;
		this.type=type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}
}
