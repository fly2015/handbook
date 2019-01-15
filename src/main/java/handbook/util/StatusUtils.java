package handbook.util;

import java.util.HashMap;
import java.util.Map;

import handbook.constant.Status;
import handbook.constant.StatusType;

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
		if(StatusType.USER.equals(statusType))
		{
			return buildUserStatusList();
		}
		
		return buildStatusList();
	}

	private Map<Integer, String> buildUserStatusList() {
		Map<Integer, String> map = new HashMap<>();
		map.put(Status.ACTIVE.getStatus(), Status.ACTIVE.name());
		map.put(Status.INACTIVE.getStatus(), Status.INACTIVE.name());
		
		return map;
	}

	private Map<Integer, String> buildStatusList() {
		Map<Integer, String> map = new HashMap<>();
		map.put(Status.ENABLE.getStatus(), Status.ENABLE.name());
		map.put(Status.DISABLE.getStatus(), Status.DISABLE.name());
		
		return map;
	}
}
