package amazon.Models.Objects;

public class AmazonUser {

	private String userName;
	private String userEmailAddress;
	private String userPassword;

	public AmazonUser(String userName, String userEmailAddress, String userPassword) {

		this.userName = userName;
		this.userEmailAddress = userEmailAddress;
		this.userPassword = userPassword;

	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNameCapitalized() {
		return userName.toUpperCase();
	}
}
