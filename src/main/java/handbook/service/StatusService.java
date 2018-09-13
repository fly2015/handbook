package handbook.service;

import java.util.List;

import handbook.dto.Status;

public interface StatusService {
	List<Status> readStatusList(int isVisible);
}
