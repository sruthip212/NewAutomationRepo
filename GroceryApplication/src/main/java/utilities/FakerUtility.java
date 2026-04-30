package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;

public class FakerUtility {

	public String generateName() {
		Faker faker = new Faker();
		return faker.name().fullName();

	}

	public String generateAddress() {
		Faker faker = new Faker();
		return faker.address().toString();
	}

	public String generatePhone() {
		Faker faker = new Faker();
		return faker.phoneNumber().toString();
	}

	public String generateEmail() {
		Faker faker = new Faker();
		return faker.internet().emailAddress().toString();
	}

	public Number generateRandomNumber() {
		Faker faker = new Faker();
		return faker.number();

	}

	public String generateCity() {
		Faker faker = new Faker();
		return faker.address().cityName();
	}

	public String generateBuildingNumber() {
		Faker faker = new Faker();
		return faker.address().buildingNumber();
	}
}