package handbook.constant;

public enum UserStatus {
	INACTIVE(0),
	ACTIVE(1);
	
	final Integer status;
	UserStatus(Integer status) 
	{
		this.status = status;
	}
	
	public Integer getStatus()
	{
		return status;
	}
}
