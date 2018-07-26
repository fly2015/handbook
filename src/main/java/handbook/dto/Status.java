/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dto;

public class Status extends AbstractDto {
	private int statusId;
	private String statusName;
	private String statusType;
	private int isVisible;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public int getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}

}
