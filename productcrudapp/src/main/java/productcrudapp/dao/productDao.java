package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.modal.Product;

@Component
public class productDao {
	
	@Autowired
	private  HibernateTemplate hibernatetemplate;
	
	
	//create
	@Transactional
	public void createProduct(Product product)
	{
		
		
		this.hibernatetemplate.saveOrUpdate(product);
	}
	
	//get all product
	@Transactional
		public List<Product> getproducts()
		
		{
			List<Product> products=this.hibernatetemplate.loadAll(Product.class);
			System.out.println(products);
			return products;
		}
	
	//delete single
	@Transactional
	public void deleteproduct(int pid)
	{
		Product p=this.hibernatetemplate.load(Product.class,pid);
		this.hibernatetemplate.delete(p);
		
	}
	
	//get single product
	public Product getproduct(int pid)
	{
	
		 return this.hibernatetemplate.get(Product.class, pid);
	
	}

}
