package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.student;

public class studentdao {
	EntityManagerFactory m = Persistence.createEntityManagerFactory("dev");
	EntityManager e = m.createEntityManager();
	EntityTransaction t = e.getTransaction();
	
	public void save(student std){
		t.begin();
		e.persist(std);
		t.commit();
	}
	
	public List<student> fetchAll(){
		return e.createQuery("select x from student x").getResultList();
	}
	
	public student find(int id){
		return e.find(student.class,id);
	}
}
