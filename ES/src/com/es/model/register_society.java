package com.es.model;

import java.io.FileOutputStream;

public class register_society {

	private String role,state,city,area,address,landmark,pincode,society_name,society_type,name_of_wings,
	total_number_of_house,name,email,phone_no,gender,id_proof,id_number,id_upload;
	private int imgpath;
	private FileOutputStream id_upload1;

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getSociety_name() {
		return society_name;
	}

	public void setSociety_name(String society_name) {
		this.society_name = society_name;
	}

	public String getSociety_type() {
		return society_type;
	}

	public void setSociety_type(String society_type) {
		this.society_type = society_type;
	}

	/*
	 * public String getNo_of_wings() { return no_of_wings; }
	 * 
	 * public void setNo_of_wings(String no_of_wings) { this.no_of_wings =
	 * no_of_wings; }
	 */
	public String getName_of_wings() {
		return name_of_wings;
	}

	public void setName_of_wings(String name_of_wings) {
		this.name_of_wings = name_of_wings;
	}

	public String getTotal_number_of_house() {
		return total_number_of_house;
	}

	public void setTotal_number_of_house(String total_number_of_house) {
		this.total_number_of_house = total_number_of_house;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId_proof() {
		return id_proof;
	}

	public void setId_proof(String id_proof) {
		this.id_proof = id_proof;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getId_upload() {
		return id_upload;
	}

	public void setId_upload(String id_upload) {
		this.id_upload = id_upload;
	}

	public int getImgpath() {
		return imgpath;
	}

	public void setImgpath(int imgpath) {
		this.imgpath = imgpath;
	}

	public FileOutputStream getId_upload1() {
		return id_upload1;
	}

	public void setId_upload1(FileOutputStream id_upload1) {
		this.id_upload1 = id_upload1;
	}
}
