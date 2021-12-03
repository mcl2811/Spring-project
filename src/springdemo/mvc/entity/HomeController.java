package springdemo.mvc.entity;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springdemo.mvc.service.CustomerService;
@Controller
public class HomeController {
	@Autowired
	CustomerService customerService;
	
	@Transactional
	@RequestMapping("/")
	public String showMyPage(Model theModel) {
		
		// Esto hay que hacerlo en el DAO
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		System.out.println(session);
		try
		{
		// read 
			session.beginTransaction();
			
			
			int theId= 1;
			Customer tempCustomer = session.get(Customer.class, theId);
			System.out.println(tempCustomer.getFirstName() + " " + tempCustomer.getLastName() + " " + tempCustomer.getEmail());
			
			session.getTransaction().commit();
			
		} 
		catch (HibernateException he){
			he.printStackTrace();
		} catch (NullPointerException nu){
			nu.printStackTrace();
		}
		
		factory.close();
		
		List<Customer> customerList = customerService.getCustomersService();

		theModel.addAttribute("customers", customerList);
		
		return "list-customers";
	}

}
