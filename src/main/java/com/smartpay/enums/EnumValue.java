package com.smartpay.enums;

public class EnumValue {

	public enum UserRole {
		ADMIN(1, "ADMIN"), MERCHANT(2, "MERCHANT"), DISTRIBUTOR(3, "DISTRIBUTOR");

		private final Integer roleId;
		private final String roleName;

		private UserRole(Integer roleId, String roleName) {
			this.roleId = roleId;
			this.roleName = roleName;
		}

		public Integer getRoleId() {
			return roleId;
		}

		public String getRoleName() {
			return roleName;
		}

	}

	public enum UserPrivilege {
		CREATE(1, "CREATE"), READ(2, "READ"), UPDATE(3, "UPDATE"), DELETE(4, "DELETE");

		private final Integer privilegeId;
		private final String privilegeName;

		private UserPrivilege(Integer privilegeId, String privilegeName) {
			this.privilegeId = privilegeId;
			this.privilegeName = privilegeName;
		}

		public Integer getPrivilegeId() {
			return privilegeId;
		}

		public String getPrivilegeName() {
			return privilegeName;
		}

	}
	
	public enum BankingServiceStatus{
		YES,
		NO
		
	}
	
	public enum IsActive{
		
		ACTIVE,
		INACTIVE
	}

}
