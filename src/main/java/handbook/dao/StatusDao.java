package handbook.dao;

import java.util.List;

import handbook.dto.Status;

public interface StatusDao {
	List<Status> readStatusList(int isVisible);
}
