package CollectionPracticeProblems;

import java.util.Scanner;

/**
 * @packageName : CollectionPracticeProblems
 * @fileNmae	: Student.java
 * @author		: mark
 * @date		: 2024.12.10
 * @description : 컬렉션 실습문제 5랑 7번에 쓸 클래스
 * ===========================================================
 * DATE				AUTHOR				NOTE
 * -----------------------------------------------------------
 * 2024.12.10		MARK KIM		FIRST CREATED
 */
public class Student {
	private Scanner scanner;
	private String name;
	private String concentration;
	private int grade;
	private double gpa;
	
	private int handleParseIntError() {
		try {
			return Integer.parseInt(this.scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.print("enter a NUMBER: ");
			return this.handleParseIntError();
		}
	}
	
	private double handleParseDoubleError() {
		try {
			return Double.parseDouble(this.scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.print("enter a NUMBER: ");
			return this.handleParseDoubleError();
		}
	}
	
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
	
	private int returnGradeIfGreaterThanZero(int grade) throws NegativeNumberException {
		if (grade <= 0) {
			throw new NegativeNumberException("Grade must be greater than 0");
		}
		return grade;
	}
	
	private int handleGradeIsLessThanZeroOrEqualToError() {
		try {
			System.out.print("Enter the studet's grade: ");
			return this.returnGradeIfGreaterThanZero(handleParseIntError());
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
			return this.handleGradeIsLessThanZeroOrEqualToError();
		}
	}
	
	private double returnGPAIfGreaterThanZero(double gpa) throws NegativeNumberException {
		if (gpa <= 0) {
			throw new NegativeNumberException("GPA must be greater than 0");
		}
		return gpa;
	}
	
	private double handleGPAIsLessThanZeroOrEqualToError() {
		try {
			System.out.print("Enter the student's GPA: ");
			return this.returnGPAIfGreaterThanZero(handleParseDoubleError());
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
			return this.handleGPAIsLessThanZeroOrEqualToError();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getConcentration() {
		return this.concentration;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	@Override
	public String toString() {
		return this.getName() + ", " + this.getConcentration() + ", " + this.getGrade() + ", " + this.getGPA();
	}
	
	public Student(Scanner scanner, boolean onlyNameAndGPA) {
		this.scanner = scanner;
		this.name = this.handleNameIsEmptyError("student");
		this.concentration = onlyNameAndGPA ? "" : this.handleNameIsEmptyError("concentration");
		this.grade = onlyNameAndGPA? 0 : this.handleGradeIsLessThanZeroOrEqualToError();
		this.gpa = this.handleGPAIsLessThanZeroOrEqualToError();
	}
}
