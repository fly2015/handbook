package hanbook.util;

import java.util.HashMap;
import java.util.Map;

import handbook.constant.ArticleStatus;
import handbook.constant.StatusType;
import handbook.constant.TagStatus;
import handbook.constant.UserStatus;

public final class StatusUtils {
	private static StatusUtils uniqueInstance;
	
	private StatusUtils()
	{
	}
	
	public static StatusUtils getInstance()
	{
		if (uniqueInstance == null)
		{
			uniqueInstance = new StatusUtils();
		}
		
		return uniqueInstance;
	}
	
	public Map<Integer, String> buildStatusList(StatusType statusType)
	{
		if(StatusType.TAG.equals(statusType))
		{
			return buildTagStatusList();
		}
		
		if(StatusType.ARTICLE.equals(statusType))
		{
			return buildArticleStatusList();
		}
		
		if(StatusType.USER.equals(statusType))
		{
			return buildUserStatusList();
		}
		
		return new HashMap<Integer, String>();
	}

	private Map<Integer, String> buildUserStatusList() {
		Map<Integer, String> map = new HashMap<>();
		map.put(UserStatus.ACTIVE.getStatus(), UserStatus.ACTIVE.name());
		map.put(UserStatus.INACTIVE.getStatus(), UserStatus.INACTIVE.name());
		
		return map;
	}

	private Map<Integer, String> buildArticleStatusList() {
		Map<Integer, String> map = new HashMap<>();
		map.put(ArticleStatus.ENABLE.getStatus(), ArticleStatus.ENABLE.name());
		map.put(ArticleStatus.DISABLE.getStatus(), ArticleStatus.DISABLE.name());
		
		return map;
	}

	private Map<Integer, String> buildTagStatusList() {
		Map<Integer, String> map = new HashMap<>();
		map.put(TagStatus.ENABLE.getStatus(), TagStatus.ENABLE.name());
		map.put(TagStatus.DISABLE.getStatus(), TagStatus.DISABLE.name());
		
		return map;
	}
}
