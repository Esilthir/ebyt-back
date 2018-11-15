package formation.dta.ebytback.model;

public enum EnumRole {

	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_USER("ROLE_USER");
	
	private String role;
	
	private EnumRole(String s) {
		this.role = s;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
