package in.co.rays.project_3.dto;

import java.util.Date;

public class CartDTO extends BaseDTO {

	private String customerName;
	private String product;
	private Date transaction;
	private String quantity;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getTransaction() {
		return transaction;
	}

	public void setTransaction(Date transaction) {
		this.transaction = transaction;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
