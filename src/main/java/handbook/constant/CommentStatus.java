package handbook.constant;

public enum CommentStatus {
	DISABLE(0),
	ENABLE(1);
	
	final Integer status;
	CommentStatus(Integer status) 
	{
		this.status = status;
	}
	
	public Integer getStatus()
	{
		return status;
	}
}
