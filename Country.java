package CollectionPracticeProblems;

import java.util.Scanner;

/**
 * @packageName : CollectionPracticeProblems
 * @fileNmae	: Country.java
 * @author		: mark
 * @date		: 2024.12.10
 * @description : 컬렉션 실습문제 3번에 쓸 클래스
 * ===========================================================
 * DATE				AUTHOR				NOTE
 * -----------------------------------------------------------
 * 2024.12.10		MARK KIM		FIRST CREATED
 */
public class Country {
	private Scanner scanner;
	private String countryName;
	private String capitalName;
	
	private String returnNameIfNotEmpty(String name) throws NameIsEmptyException {
		if (name.isEmpty() || name.isBlank()) {
			throw new NameIsEmptyException("Name can't be empty");
		}
		return name;
	}
	
	private String handleNameIsEmptyError(String name) {
		try {
			System.out.print("Enter the " + name + "'s name: ");
			return this.returnNameIfNotEmpty(this.scanner.nextLine());
		} catch (NameIsEmptyException e) {
			System.out.println(e.getMessage());
			return this.handleNameIsEmptyError(name);
		}
	}
	
	public String getCountryName() {
		return this.countryName;
	}
	
	public String getCapitalName() {
		return this.capitalName;
	}
	
	public Country(Scanner scanner) {
		this.scanner = scanner;
		this.countryName = handleNameIsEmptyError("country");
		if (this.countryName.toLowerCase().equals("quit")) {
			this.capitalName = "";
		} else {
			this.capitalName = handleNameIsEmptyError("capital");
		}
		
		if (this.capitalName.toLowerCase().equals("quit")) {
			this.countryName = "quit";
		}
	}
}
