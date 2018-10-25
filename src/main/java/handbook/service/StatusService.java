package handbook.service;

import java.util.List;

import handbook.dto.Status;

public interface StatusService {
	List<Status> readStatusList(int isVisible, String statusType);
	Status readStatusByStatusNameAndType(Integer isVisible, String StatusType, String statusName);
}
