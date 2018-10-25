package handbook.dao;

import java.util.List;

import handbook.dto.Status;

public interface StatusDao {
	List<Status> readStatusList(Integer isVisible, String statusType);
	Status readStatusByStatusNameAndType(Integer isVisible, String StatusType, String statusName);
}
