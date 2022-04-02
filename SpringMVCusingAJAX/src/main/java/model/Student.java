package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu1")
public class Student {
@Id
private int rno;
@Column
private String name;
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
