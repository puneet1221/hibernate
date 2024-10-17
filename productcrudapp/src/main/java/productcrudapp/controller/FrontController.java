package productcrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import productcrudapp.model.Product;
import productcrudapp.service.ProductService;

@Controller
public class FrontController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/")
	public String home(Model m) {
		List<Product> products = productService.findAllProducts();
		m.addAttribute("products", products);
		return "index";

	}

	@RequestMapping(value = "/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_Product_Form";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	private RedirectView handleAddProudct(@ModelAttribute Product product, HttpServletRequest httpServletRequest,
			Model m) {
		System.out.println(product);
		String msg = productService.addProduct(product);
		m.addAttribute("msg", msg);
		RedirectView rdv = new RedirectView();
		rdv.setUrl(httpServletRequest.getContextPath() + "/");
		return rdv;

	}

	@RequestMapping(value = "delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int id, HttpServletRequest request) {
		System.out.println(id);
		RedirectView rdv = new RedirectView();
		rdv.setUrl(request.getContextPath() + "/");
		productService.deleteProduct(id);
		return rdv;
	}

	@RequestMapping(value = "/delete-all")
	public RedirectView deleteAll(HttpServletRequest request) {
		productService.deleteAll();
		RedirectView rdv = new RedirectView();
		rdv.setUrl(request.getContextPath() + "/");
		return rdv;

	}
	
	@RequestMapping(value = "/update-product/{id}")
	public String updateProduct(@PathVariable("id") int id,Model m)
	{
		Product p=productService.findProduct(id);
		m.addAttribute("product",p);
		return "update_product";
	}
	
	@RequestMapping(value="/updatedProduct",method = RequestMethod.POST)
	public RedirectView handleUpdateProductForm(@ModelAttribute Product p,HttpServletRequest request)
	{
		productService.updateProduct(p.getId(), p);
		RedirectView rdv = new RedirectView();
		rdv.setUrl(request.getContextPath() + "/");
		return rdv;
	}

}
