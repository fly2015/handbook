/**
 * @author fr.quochien@gmail.com
 * @date Jul 26, 2018
 */
package handbook.dto;

public class Role extends AbstractDto{
	private Integer roleId;
	private String roleName;
	private String roleNameSlug;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNameSlug() {
		return roleNameSlug;
	}

	public void setRoleNameSlug(String roleNameSlug) {
		this.roleNameSlug = roleNameSlug;
	}
}
