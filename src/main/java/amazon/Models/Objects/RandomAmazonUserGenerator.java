package amazon.Models.Objects;

import com.github.javafaker.Faker;

public class RandomAmazonUserGenerator {

	private Faker fakerObject = new Faker();
	private AmazonUser amazonUser;

	public AmazonUser generateRandomAmazonUser() {
		amazonUser = new AmazonUser(generateRandomAmazonUserName(),

				generateRandomEmailAddress(), generateRandomPassword());
		return amazonUser;

	}

	private String generateRandomAmazonUserName() {
		return fakerObject.name().toString();
	}

	public String generateRandomMobileNumber() {
		return fakerObject.numerify("012########");
	}

	private String generateRandomEmailAddress() {
		return fakerObject.bothify("????##@gmail.com");
	}

	private String generateRandomPassword() {
		return fakerObject.numerify("1######");
	}

}
