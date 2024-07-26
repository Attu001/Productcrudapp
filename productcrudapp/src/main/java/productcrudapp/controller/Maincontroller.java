package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.productDao;
import productcrudapp.modal.Product;

@Controller
public class Maincontroller {
		
	@Autowired
	private productDao productdao;
	
		@RequestMapping("/")
		public String home(Model m) {
			try {
			List<Product> products = productdao.getproducts();
			System.out.println(products);
			System.out.println("index url");
		m.addAttribute("product",products);
			return "index";
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("not loaded");
			}
			
			return "index";
		}
		
		
		
		
		
		//addproduct form
		@RequestMapping("/add-product")
		public String addProduct(Model m) 
		{
			
			m.addAttribute("title","ADD PRODUCT");
			return "add_product";
		}
		
		
		
		
		
		
		//handle add product form
		@RequestMapping(value="/handle_product",method=RequestMethod.POST)
		public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request )
		{
			System.out.println(product);
			productdao.createProduct(product);
			RedirectView redirectview= new RedirectView();
			redirectview.setUrl(request.getContextPath()+"/");
			return redirectview;
		}
		
		
		
		//delete handler
		@RequestMapping("/delete/{productId}")
		public RedirectView deleteproduct(@PathVariable("productId") int productId, HttpServletRequest request)
		{
			this.productdao.deleteproduct(productId);
			RedirectView redirectview= new RedirectView();
			redirectview.setUrl(request.getContextPath()+"/");
			return redirectview;
		}
		
		//update handler
		@RequestMapping("/update/{productId}")
		public String updateform(@PathVariable("productId") int pid, Model model)
		{
			Product product=this.productdao.getproduct(pid);
			product.getName(); // Eagerly load the name property
		    product.getDescription(); // Eagerly load the description property
		    product.getPrice(); // Eagerly load the price property
		    System.out.println(product);
			model.addAttribute("product",product);
			return "update_form";
		}
		
}
