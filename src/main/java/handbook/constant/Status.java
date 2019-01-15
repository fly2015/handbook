package handbook.constant;

public enum Status {
	DISABLE(0),
	ENABLE(1),
	
	INACTIVE(0),
	ACTIVE(1),
	
	INVISIBLE(0),
	VISIBLE(1);
	
	final Integer status;
	Status(Integer status) 
	{
		this.status = status;
	}
	
	public Integer getStatus()
	{
		return status;
	}
}
