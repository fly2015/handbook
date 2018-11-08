package handbook.constant;

public enum TagStatus {
	DISABLE(0),
	ENABLE(1);
	
	final Integer status;
	TagStatus(Integer status) 
	{
		this.status = status;
	}
	
	public Integer getStatus()
	{
		return status;
	}
}
