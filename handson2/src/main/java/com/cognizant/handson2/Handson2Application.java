package com.cognizant.handson2;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException; 


public class Handson2Application {
	private static SessionFactory factory; 
	public static void addCountry(Country obj) {
		Session session = factory.openSession();
		Transaction tx = null;
	     try {
	         tx = session.beginTransaction();
	         session.save(obj); 
	         tx.commit();
	      } catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	        e.printStackTrace();
	      } finally {
	         session.close(); 
	      }
	}
	
	public static void updateCountry(String code, String name) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         Country country = (Country)session.get(Country.class, code); 
	         country.setName(name);
			 session.update(country); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	
	public static void deleteCountry(String code) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Country country = (Country)session.get(Country.class, code); 
	         session.delete(country); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	
	public static void listCountry() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List countries = session.createQuery("FROM Country").list(); 
	         for (Iterator iterator = countries.iterator(); iterator.hasNext();){
	             Country country = (Country) iterator.next(); 
	             System.out.println("Code:" + country.getCode());
	             System.out.println("name :" + country.getName());
	          }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	public static void main(String[] args) {
		try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		Country objCountry = new Country("BZ","Brazil");
		Handson2Application.addCountry(objCountry);
		Handson2Application.listCountry();
		Handson2Application.updateCountry("IN", "INDIA");
		Handson2Application.listCountry();
		Handson2Application.deleteCountry("BZ");
		Handson2Application.listCountry();
		
	}

}
