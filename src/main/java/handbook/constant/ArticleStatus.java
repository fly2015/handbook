package handbook.constant;

public enum ArticleStatus {
	DISABLE(0),
	ENABLE(1);
	
	final Integer status;
	ArticleStatus(Integer status) 
	{
		this.status = status;
	}
	
	public Integer getStatus()
	{
		return status;
	}
}