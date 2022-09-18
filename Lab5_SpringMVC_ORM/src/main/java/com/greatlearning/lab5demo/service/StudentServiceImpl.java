package com.greatlearning.lab5demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.lab5demo.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		Transaction tx = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();
		return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theStudent);
		tx.commit();

	}

	
	
	@Override
	@Transactional
	public Student getStudent(int theId) {
		Student student = new Student();
		Transaction tx = session.beginTransaction();
		student = session.get(Student.class, theId);
		tx.commit();
		return student;
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, theId);
		session.delete(student);
		tx.commit();
	}

}
