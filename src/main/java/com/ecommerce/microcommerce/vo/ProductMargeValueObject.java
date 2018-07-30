package com.ecommerce.microcommerce.vo;

import com.ecommerce.microcommerce.model.Product;

public class ProductMargeValueObject {

	public Product product;
	public int marge;

	
	public ProductMargeValueObject(Product product, int marge) {
		super();
		this.product = product;
		this.marge = marge;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getMarge() {
		return marge;
	}

	public void setMarge(int marge) {
		this.marge = marge;
	}

}
