package com.demo;

import java.util.Date;

import jakarta.persistence.*;



public class A_AddAccounts {

	public static void main(String[] args) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountPU");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx=em.getTransaction();
		
		try {
			tx.begin();
			
			Account account=new Account("pooja", 1000.00);
			Account account2=new Account("kavita", 1000.00);
			
			em.persist(account2);
			em.persist(account);
			
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		em.close();
		emf.close();
	}
}
