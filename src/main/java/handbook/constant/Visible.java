package handbook.constant;

public enum Visible {
	IS_VISIBLE(1),
	IS_NOT_VISIBLE(0);
	
	private final Integer visible;

	Visible(Integer visible)
	{
		this.visible = visible;
	}
	
	
	public Integer getVisibleType()
	{
		return visible;
	}
	
}
