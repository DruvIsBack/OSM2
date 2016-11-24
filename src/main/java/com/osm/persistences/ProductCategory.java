package com.osm.persistences;

import javax.persistence.*;

import com.osm.persistences.ProductSubCategory;

import java.util.List;

@Entity
@Table
public class ProductCategory{
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String pic;

	@OneToMany(mappedBy = "productCategory")
	private List<ProductSubCategory> productSubCategory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String param) {
		this.pic = param;
	}

	public List<ProductSubCategory> getProductSubCategory() {
	    return productSubCategory;
	}

	public void setProductSubCategory(List<ProductSubCategory> param) {
	    this.productSubCategory = param;
	}

}