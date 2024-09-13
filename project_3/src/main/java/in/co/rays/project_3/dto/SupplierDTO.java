package in.co.rays.project_3.dto;

public class SupplierDTO extends BaseDTO{
	
	private String customer ;
	private String CustomerId ;
	private Long ammount ;
	private Integer sesionId ;
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
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public Long getAmmount() {
		return ammount;
	}
	public void setAmmount(Long ammount) {
		this.ammount = ammount;
	}
	public Integer getSesionId() {
		return sesionId;
	}
	public void setSesionId(Integer sesionId) {
		this.sesionId = sesionId;
	}
	

}
