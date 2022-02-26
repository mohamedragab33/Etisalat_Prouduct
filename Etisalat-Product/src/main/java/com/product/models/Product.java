package com.product.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Products")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "GET_ALL_PRODUCTS",procedureName = "GET_ALL_PRODUCTS"),
@NamedStoredProcedureQuery(name = "GET_PPRODUCT_BY_ID", procedureName = "GET_PPRODUCT_BY_ID",
          parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_id",type=Integer.class)}),
@NamedStoredProcedureQuery(name = "CREATE_NEW_PRODUCT", procedureName = "CREATE_NEW_PRODUCT",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_name",type=String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_weight",type=Double.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_price",type=Double.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_avilable",type=Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_description",type=String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_properties",type=String.class),		
}),
@NamedStoredProcedureQuery(name = "UPDATE_PRODUCT_BY_ID", procedureName = "UPDATE_PRODUCT_BY_ID",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_id",type=Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_name",type=String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_weight",type=Double.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_price",type=Double.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_avilable",type=Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_description",type=String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_properties",type=String.class),		
}),
@NamedStoredProcedureQuery(name = "DELETE_PPRODUCT_BY_ID", procedureName = "DELETE_PPRODUCT_BY_ID",
parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "pn_id",type=Integer.class)})
})



public class Product {
	@Id
	@Column(name = "Product_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "Product_Name", length = 255, nullable = false)
	private String name;

	@Column(name = "Product_Weight", nullable = true)
	private double weight;

	@Column(name = "Product_Price", nullable = false)
	private double price;

	@Column(name = "Avilable", nullable = false)
	@ColumnDefault("1")
	private int avilable;

	@Column(name = "Description", length = 500, nullable = true)
	private String description;

	@Column(name = "Properties", length = 500, nullable = true)
	private String properties;

	@CreationTimestamp
	@Column(name = "Create_Date", nullable = true)
	private Date createDate;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getAvilable() {
		return avilable;
	}

	public void setAvilable(int avilable) {
		this.avilable = avilable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

}
