package com.spring.orm.dao;

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

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
    
}
