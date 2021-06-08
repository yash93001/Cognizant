package com.cognizant.handson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException; 


public class Handson3Application {




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
		
		public static void updateCountry(int code, String name) {
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
		
		public static void deleteCountry(int code) {
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
		         factory = new Configuration().
		                   configure().
		                   addAnnotatedClass(Country.class).
		                   buildSessionFactory();
		      } catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }

			Country objCountry = new Country();
			objCountry.setName("Brazil");
			Handson3Application.addCountry(objCountry);
			Handson3Application.listCountry();

			
		}
		

}
