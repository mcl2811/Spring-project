package springdemo.mvc.entity;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springdemo.mvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/showFormForAdd")
	public String showForm(Model theModel) {
// create a new customer object to be added to the Model
// so that the show form can make use of the customer object for data mapping
		Customer aCustomer = new Customer();
		theModel.addAttribute("customer", aCustomer);
		return "customer-form";
	}

	@RequestMapping("processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult, Model theModel) {
		
		if (bindingResult.hasErrors())
			return "customer-form";
		else
			customerService.addCustomer(theCustomer);
			theModel.addAttribute("customer", theCustomer);
			return "customer-confirmation";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) 
	{
	// the class below is defined in Spring API, removes leading/trailing whitespaces
	// true means set to null if all are white spaces
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	// preprocess every String form data 
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}