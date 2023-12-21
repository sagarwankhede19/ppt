package com.example.one;

public class StudentEntity {

	private int studentId;
	private String studentName;
	private long mobileNumber;

	public StudentEntity() {

	}

	public StudentEntity(int studentId, String studentName, int mobileNumber) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", mobileNumber="
				+ mobileNumber + "]";
	}

}
