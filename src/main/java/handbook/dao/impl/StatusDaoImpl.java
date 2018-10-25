package handbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import handbook.dao.StatusDao;
import handbook.dto.Status;

@Component
public class StatusDaoImpl extends AbstractDao implements StatusDao{

	@Override
	public List<Status> readStatusList(Integer isVisible, String statusType) {
		String sql = "select * from status where is_visible = ? and status_type = ?";
		List<Map<String, Object>> queryForList = jdbc.queryForList(sql, isVisible, statusType);
		
		List<Status> list = new ArrayList<Status>();
		for (Map<String, Object> map : queryForList) {
			Status status = buildStatus(map);
			list.add(status);
		}
		
		return list;
	}

	private Status buildStatus(Map<String, Object> map) {
		Status status = new Status();
		status.setStatusId(Integer.valueOf(map.get("status_id").toString()));
		status.setStatusName(map.get("status_name").toString());
		status.setStatusType(map.get("status_type").toString());
		return status;
	}

	@Override
	public Status readStatusByStatusNameAndType(Integer isVisible, String statusType, String statusName) {
		String sql = "select * from status where is_visible = ? and status_type = ? and status_name = ?";

		Map<String, Object> map = null;
		try 
		{
			map = jdbc.queryForMap(sql, isVisible, statusType, statusName);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		if (map != null && !map.isEmpty())
		{
			return buildStatus(map);
		}
		
		return null;
		
	}

}
