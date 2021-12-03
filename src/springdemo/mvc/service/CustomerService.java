package springdemo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdemo.mvc.dao.customerDAO;
import springdemo.mvc.entity.Customer;

@Service
public class CustomerService {
@Autowired
private customerDAO customerDAO;

public List<Customer> getCustomersService(){
	List<Customer> listCustomers = customerDAO.getCustomerList();
	return listCustomers;
}
}
