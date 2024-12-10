package CollectionPracticeProblems;

import java.util.Scanner;

public class Location {
	private Scanner scanner;
	private String city;
	private double latitude;
	private double longitude;
	
	private double handleParseDoubleError(String coordinate) {
		try {
			System.out.print("Enter the city's " + coordinate + ": ");
			return Double.parseDouble(this.scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("enter a NUMBER");
			return handleParseDoubleError(coordinate);
		}
	}
	
	private String returnNameIfNotEmpty(String name) throws NameIsEmptyException {
		if (name.isEmpty() || name.isBlank()) {
			throw new NameIsEmptyException("Name can't be empty");
		}
		return name;
	}
	
	private String handleNameIsEmptyError() {
		try {
			System.out.print("Enter the city's name: ");
			return this.returnNameIfNotEmpty(this.scanner.nextLine());
		} catch (NameIsEmptyException e) {
			System.out.println(e.getMessage());
			return this.handleNameIsEmptyError();
		}
	}
	

	public String getCity() {
		return this.city;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public Location(Scanner scanner) {
		this.scanner = scanner;
		this.city = this.handleNameIsEmptyError();
		this.latitude = this.handleParseDoubleError("latitude");
		this.longitude = this.handleParseDoubleError("longitude");
	}

}
