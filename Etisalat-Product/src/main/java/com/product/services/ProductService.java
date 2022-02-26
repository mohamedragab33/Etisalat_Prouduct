package com.product.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.models.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	@PersistenceContext
	private EntityManager em;

	public List<Product> getAllProducts() {
		List<Object[]> result = em.createNamedStoredProcedureQuery("GET_ALL_PRODUCTS").getResultList();
		return mapResultWithProuduct(result);
	}

	public Product getProductById(int id) {
		List<Object[]> result = em.createNamedStoredProcedureQuery("GET_PPRODUCT_BY_ID").setParameter("pn_id", id)
				.getResultList();
		return mapResultWithProuduct(result).get(0);
	}

	public void saveOrUpdateProduct(Product product) {
		StoredProcedureQuery function = em.createNamedStoredProcedureQuery("CREATE_NEW_PRODUCT")
				.setParameter("pn_name", product.getName()).setParameter("pn_weight", product.getWeight())
				.setParameter("pn_price", product.getPrice()).setParameter("pn_avilable", product.getAvilable())
				.setParameter("pn_description", product.getDescription())
				.setParameter("pn_properties", product.getProperties());

		function.execute();
	}

	public void delete(int id) {
		StoredProcedureQuery function = em.createNamedStoredProcedureQuery("DELETE_PPRODUCT_BY_ID")
				.setParameter("pn_id", id);
		function.execute();
	}

	public void update(Product product, int productId) {
		StoredProcedureQuery function = em.createNamedStoredProcedureQuery("UPDATE_PRODUCT_BY_ID")
				.setParameter("pn_id", product.getId()).setParameter("pn_name", product.getName())
				.setParameter("pn_weight", product.getWeight()).setParameter("pn_price", product.getPrice())
				.setParameter("pn_avilable", product.getAvilable())
				.setParameter("pn_description", product.getDescription())
				.setParameter("pn_properties", product.getProperties());
		function.execute();
	}

	private List<Product> mapResultWithProuduct(List<Object[]> result) {
		List<Product> products = new ArrayList<Product>();
		result.stream().forEach((record) -> {
			Product product = new Product();
			product.setId((Integer) record[0]);
			product.setName((String) record[1]);
			product.setWeight((double) record[2]);
			product.setPrice((double) record[3]);
			product.setAvilable((Integer) record[4]);
			product.setDescription((String) record[5]);
			product.setProperties((String) record[6]);
			product.setCreateDate((Date) record[7]);
			products.add(product);
		});
		return products;

	}

}
