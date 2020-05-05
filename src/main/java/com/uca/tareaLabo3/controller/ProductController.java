package com.uca.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.tareaLabo3.domain.Product;

@Controller
public class ProductController {
	
private List<Product> products = new ArrayList<Product>();
	
	@GetMapping("/productos")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		products.add(new Product(0, "Call Of Duty", 30));
		products.add(new Product(1, "Crash Bandicoot", 8));
		products.add(new Product(2, "Animal Croassing", 70));
		products.add(new Product(3, "World War Z", 2));
		products.add(new Product(4, "Super Smash Bros", 73));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("productos", products);

		return mav;	
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", products.get(product.getId()).getNombre());
		
		if(products.get(product.getId()).getCantidad() >= product.getCantidad() && product.getCantidad() > 0) { mav.setViewName("compra"); }
		else {
			mav.setViewName("error");
		}
		return mav;
	}
	
}
