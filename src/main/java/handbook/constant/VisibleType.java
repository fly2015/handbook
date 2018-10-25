package handbook.constant;

public enum VisibleType {
	IS_VISIBLE(1),
	IS_NOT_VISIBLE(0);
	
	private final Integer visible;

	VisibleType(Integer visible)
	{
		this.visible = visible;
	}
	
	
	public Integer getVisibleType()
	{
		return visible;
	}
	
}
