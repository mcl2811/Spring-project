package springdemo.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springdemo.mvc.entity.Customer;

@Component
public class customerDAO {
//@Autowired
//SessionFactory factory;

	public List<Customer> getCustomerList() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		List<Customer> results = new ArrayList();
		try
		{
		// read 
			session.beginTransaction();
				
			Query query = session.createQuery("SELECT E FROM Customer E");
			results = query.list();
			for (Customer c : results) {
				System.out.println(c);
			}
			
			session.getTransaction().commit();
			
		} 
		catch (HibernateException he){
			he.printStackTrace();
		} catch (NullPointerException nu){
			nu.printStackTrace();
		}
		return results;
	}
	
	public String addCustomer(Customer customer) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try
		{
		// read 
			session.beginTransaction();
				
			session.saveOrUpdate(customer);
			
			session.getTransaction().commit();
			
		} 
		catch (HibernateException he){
			he.printStackTrace();
		} catch (NullPointerException nu){
			nu.printStackTrace();
		}
		return "New customer added";
	}
	
	public String deleteCustomer(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try
		{
		// read
			session.beginTransaction();
				
			int customerID = id;
			Customer myCustomer = session.get(Customer.class, customerID);
			session.delete(myCustomer);
			
			session.getTransaction().commit();
			
		} 
		catch (HibernateException he){
			he.printStackTrace();
		} catch (NullPointerException nu){
			nu.printStackTrace();
		}
		return "Customer deleted";
	}
	
	public String updateCustomer(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try
		{
		// read 
			session.beginTransaction();
			int customerID = id;	
			Customer myCustomer = session.get(Customer.class, customerID);
			session.update(myCustomer);
			
			session.getTransaction().commit();
			
		} 
		catch (HibernateException he){
			he.printStackTrace();
		} catch (NullPointerException nu){
			nu.printStackTrace();
		}
		return "Customer updated";
	}
	
	public Customer getCustomer(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		Customer customer = new Customer();
		try
		{
		// read 
			session.beginTransaction();
				
			// customer = (Customer)session.createQuery("from Customer where id = '" + id + "'").getResultList().get(0);
			customer = session.get(Customer.class, id);
			
			session.getTransaction().commit();
			
		} 
		catch (HibernateException he){
			he.printStackTrace();
		} catch (NullPointerException nu){
			nu.printStackTrace();
		}
		return customer;
	}
	
}
