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
	public List<Status> readStatusList(Integer isVisible) {
		String sql = "select * from status where is_visible = ?";
		List<Map<String, Object>> queryForList = jdbc.queryForList(sql, isVisible);
		
		List<Status> list = new ArrayList<Status>();
		for (Map<String, Object> map : queryForList) {
			Status status = new Status();
			status.setStatusId(Integer.valueOf(map.get("status_id").toString()));
			status.setStatusName(map.get("status_name").toString());
			status.setStatusType(map.get("status_type").toString());
			list.add(status);
		}
		
		return list;
	}

}
