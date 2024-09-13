package in.co.rays.project_3.dto;


public class CustomerDTO extends BaseDTO {
	
	
	private String clintName ;
	private String location ;
	private Long contactNumber;
	private String importance ;

	
	public String getClintName() {
		return clintName;
	}

	public void setClintName(String clintName) {
		this.clintName = clintName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return importance;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return importance;
	}

}
