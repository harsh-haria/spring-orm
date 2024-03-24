package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public int insert(Student student) {
        int result = (int) this.hibernateTemplate.save(student);
        return result;
    }
    
    public Student getStudent(int studentId) {
    	Student student = this.hibernateTemplate.get(Student.class,studentId);
    	return student;
    }
    
    public List<Student> getAllStudents() {
    	List<Student> students = this.hibernateTemplate.loadAll(Student.class);
    	return students;
    }
    
    @Transactional
    public void deleteStudent(int studentId) {
    	Student student = this.hibernateTemplate.get(Student.class, studentId);
    	this.hibernateTemplate.delete(student);
    	return;
    }
    
    @Transactional
    public void updateStudent(Student student) {
    	this.hibernateTemplate.update(student);
    	return;
    }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
    
}
