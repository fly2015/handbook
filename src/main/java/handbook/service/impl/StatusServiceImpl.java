package handbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handbook.dao.StatusDao;
import handbook.dto.Status;
import handbook.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{
	@Autowired
	private StatusDao dao;
	@Override
	public List<Status> readStatusList(int isVisible) {
		return dao.readStatusList(isVisible);
	}
}
