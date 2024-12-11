package CollectionPracticeProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * @packageName : CollectionPracticeProblems
 * @fileNmae	: CollectionPracticeProblems.java
 * @author		: mark
 * @date		: 2024.12.10
 * @description : 컬렉션 실습문제
 * ===========================================================
 * DATE				AUTHOR				NOTE
 * -----------------------------------------------------------
 * 2024.12.10		MARK KIM		FIRST CREATED
 */
public class CollectionPracticeProblems {
	private Scanner scanner;

	public CollectionPracticeProblems() {
		this.scanner = new Scanner(System.in);
	}

	// 사용자가 정수가 아닌 문자열이나 문자를 입력하면 나타나는 오류를 처리하는 재귀 method
	private int handleParseIntError() {
		try {
			return Integer.parseInt(this.scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.print("enter a NUMBER: ");
			return handleParseIntError();
		}
	}

	// 사용자가 소수가 아닌 문자열이나 문자를 입력하면 나타나는 오류를 처리하는 재귀 method
	private double handleParseDoubleError() {
		try {
			return Double.parseDouble(this.scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.print("enter a NUMBER: ");
			return handleParseDoubleError();
		}
	}

	// number가 -1보다작으면 NegativeNumberException 오류를 던지는 method
	private int returnIfNotSmallerThanNegativeOne(int number) throws NegativeNumberException {
		if (number < -1) {
			throw new NegativeNumberException("Number is less than -1");
		}
		return number;
	}

	// -1 이상인 정수를 입력받을때까지 실행되는 재귀 method
	private int handleNegativeNumberError() {
		System.out.print("Number: ");
		try {
			return returnIfNotSmallerThanNegativeOne(handleParseIntError());
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
			return handleNegativeNumberError();
		}
	}

	// letterGrade가 "A", "B", "C", "D", "F" 아니면 오류를 던지는 method
	private String returnStringIfIsAGrade(String letterGrade) throws NotALetterGradeException {
		switch (letterGrade.toUpperCase()) {
		case "A", "B", "C", "D", "F":
			return letterGrade;
		default:
			throw new NotALetterGradeException("Not a letter grade");
		}
	}

	// letterGrade에 해당되는 GPA를 반환하는 method
	private int returnLetterGradeGPAScore(String letterGrade) {
		switch (letterGrade.toUpperCase()) {
		case "A":
			return 4;
		case "B":
			return 3;
		case "C":
			return 2;
		case "D":
			return 1;
		default:
			return 0;
		}
	}

	// 입력한 점수가 "A", "B", "C", "D", "F"일때까지 실행되는 재귀 method
	private String handleNonGradeStringError(int number) {
		try {
			System.out.print("Grade " + number + ": ");
			return returnStringIfIsAGrade(this.scanner.nextLine());
		} catch (NotALetterGradeException e) {
			System.out.println(e.getMessage());
			return handleNonGradeStringError(number);
		}
	}

	// countryAndPopulation에 ","없거나 "quit"가 아니면 오류를 던지는 method
	private String returnCountryAndPopulationIfFormatIsCorrect(String countryAndPopulation)
			throws WrongFormatException {
		if (countryAndPopulation.contains(",")) {
			return countryAndPopulation;
		} else if (countryAndPopulation.equals("quit")) {
			return countryAndPopulation;
		}
		throw new WrongFormatException("Follow format when inputting country and population ex. (Korea, 1)");
	}

	// 입력한 나라와 인구 문자열의 체재가 맞을때까지 실행되는 재귀 method
	private String handleCountryAndPopulationFormatError() {
		try {
			System.out.print("Country and population: ");
			return returnCountryAndPopulationIfFormatIsCorrect(this.scanner.nextLine());
		} catch (WrongFormatException e) {
			System.out.println(e.getMessage());
			return handleCountryAndPopulationFormatError();
		}
	}

	// Student class instance를 만들고 반환하는 method
	private Student createStudent(int studentNumber, boolean onlyNameAndGPA) {
		System.out.println("Student number " + studentNumber);
		return new Student(this.scanner, onlyNameAndGPA);
	}

	// Location class instance를 만들고 반환하는 method
	private Location createLocation(int locationNumber) {
		System.out.println("Location " + locationNumber);
		return new Location(this.scanner);
	}

	private void printAnswer(int problemNumber) {
		switch (problemNumber) {
		case 1:
			System.out.println("Enter numbers greater than -1 for problem 1. Enter \"-1\" to stop adding");
			System.out.println("1. " + problem1());
			break;
		case 2:
			System.out.println("Enter your 6 letter grades");
			System.out.println("2. " + problem2());
			break;
		case 3:
			System.out.println(
					"Enter a country and its population in this format (Korea, 1). To stop adding countries, enter \"quit\"");
			System.out.println("3. " + problem3());
			break;
		case 4:
			System.out.println("4.");
			problem4();
			break;
		case 5:
			System.out.println("5. Enter the information of 4 students");
			problem5();
			break;
		case 6:
			System.out.println("6. Enter 4 cities with their latitude and longitude");
			problem6();
			break;
		case 7:
			System.out.println("7. " + problem7());
			break;
		case 8:
			problem8();
			break;
		case 9:
			problem9();
			break;
		default:
			System.out.println("there are only 9 problems");
			startProgram();
		}
	}

	private void printAll() {
		for (int i = 1; i < 10; i++) {
			printAnswer(i);
		}
	}

	void startProgram() {
		System.out.print(
				"Please enter the question number you'd like to test. If you'd like to test all questions, type \"all\": ");
		String testingPreference = this.scanner.nextLine();
		if (testingPreference.toLowerCase().equals("all")) {
			printAll();
		} else {
			try {
				int number = Integer.parseInt(testingPreference);
				printAnswer(number);
			} catch (NumberFormatException e) {
				System.out.println("enter a number or \"all\"");
				startProgram();
			}
		}
		this.scanner.close();
	}

	// 1. Scanner 클래스로 -1이 입력될 때까지 양의 정수를 입력받아 벡터에 저장하고 벡터를 검색하여 가장 큰 수를 출력하는 프로그램을
	// 작성하라.
	int problem1() {
		// 입력한 정수를 대입받을 정수형 변수
		int inputNumber;
		// 가장 큰정수를 대입받을 정수형 변수
		int biggestNumber = 0;
		// 입력한 정수들을 저장할 Vector형 변수
		Vector<Integer> numbers = new Vector<Integer>();

		// shouldContinue가 true면 반복하는 do while문
		do {
			// inputNumber에 입력한 정수를 대입
			inputNumber = handleNegativeNumberError();
			// inputNumber가 -1이면 shouldContinue에 false 대입
			if (inputNumber == -1) {
				break;
			}
			// numbers에 inputNumber 저
			numbers.add(inputNumber);
		} while (true);
		// numbers에 있는 정수들을 하나하나씩 number에 반복하면서 대입
		for (int number : numbers) {
			// number가 biggestNumber보다 크면 biggestNumber에 number대입
			if (number > biggestNumber) {
				biggestNumber = number;
			}
		}
		// biggestNumber 반환
		return biggestNumber;
	}

	int problem1v2() {
		// 입력한 정수를 대입받을 정수형 변수
		int inputNumber;
		// 입력한 정수들을 저장할 Vector형 변수
		Vector<Integer> numbers = new Vector<Integer>();

		// shouldContinue가 true면 반복하는 do while문
		do {
			// inputNumber에 입력한 정수를 대입
			inputNumber = handleNegativeNumberError();
			// inputNumber가 -1이면 shouldContinue에 false 대입
			if (inputNumber == -1) {
				break;
			}
			// numbers에 inputNumber 저
			numbers.add(inputNumber);
		} while (true);

		// Collections의 max method로 numbers의 최대값 바환
		return Collections.max(numbers);
	}

	// 2. Scanner 클래스를 사용하여 6개 학점('A', 'B', 'C', 'D', 'F')을 문자로 입력받아 ArrayList에
	// 저장하고, ArrayList를 검색하여 학점을 점수(A=4.0, B=3.0, C=2.0, D=1.0, F=0)로 변환하여 평균을 출력하는
	// 프로그램을 작성하라.
	double problem2() {
		// 입력한 점수를 대입받을 문자열 변수
		String letterGrade;
		// 입력한 점수들을 저장할 ArrayList 변수
		ArrayList<String> letterGradesArrayList = new ArrayList<String>();
		// GPA들의 합을 대입할 double 변수
		double sumOfGPAs = 0;
		// 6번 반복하면서 letterGradesArrayList에 입력한 점수를 저장
		for (int i = 0; i < 6; i++) {
			letterGrade = handleNonGradeStringError(i + 1);
			letterGradesArrayList.add(letterGrade);
		}
		// letterGradesArrayList에 저장된 정수 개수만큼 반복하면서 점수를 GPA로 변환한후 변환된 점수를 sumOfGPAs에 더한다
		for (int i = 0; i < letterGradesArrayList.size(); i++) {
			letterGradesArrayList.set(i, String.valueOf(returnLetterGradeGPAScore(letterGradesArrayList.get(i))));
			sumOfGPAs += Integer.parseInt(letterGradesArrayList.get(i));
		}
		// 평균 반환
		return sumOfGPAs / 6;
	}

	// 3. "그만"이 입력될 때까지 나라 이름과 인구를 입력받아 저장하고, 다시 나라 이름을 입력받아 인구를 출력하는 프로그램을 작성하라. 다음
	// 해시맵을 이용하라.
	String problem3() {
		// 입력받은 나라 이름과 인구 문자열을 대입받을 문자열 변수
		String entry;
		// 찾아보고싶은 나라 이름을 대입받을 문자열 변수
		String countryToLookUp;
		// 입력받은 나라 이름과 인구 문자열을 배열로 변환한후 대입받을 문자열 변수
		String[] countryAndPopulation;
		// 나라 이름과 인구를 저장할 HashMap 변수
		HashMap<String, String> countriesAndPopulationDictionaryHashMap = new HashMap<String, String>();

		// shouldContinue가 true면 반복
		while (true) {
			// entry에 입력받은 나라 이름과 인구를 대입
			entry = handleCountryAndPopulationFormatError();
			// entry가 "quit"면 shouldContinue에 false를 대입
			if (entry.equals("quit")) {
				break;
				// 아니면
			} else {
				// entry를 배열로 변환한후 countryAndPopulation에 대입
				countryAndPopulation = entry.replaceAll(" ", "").split(",");
				// countriesAndPopulationDictionaryHashMap에 나라 이름과 인구를 저장
				countriesAndPopulationDictionaryHashMap.put(countryAndPopulation[0], countryAndPopulation[1]);
			}
		}
		System.out.println("Contries in database");
		// 저장된 나라 이름들을 출력
		System.out.println(countriesAndPopulationDictionaryHashMap.keySet());
		System.out.print("Country to look up: ");
		// countryToLookUp에 찾아보고싶은 나라 이름을 대입
		countryToLookUp = this.scanner.nextLine();
		// countryToLookUp가 countriesAndPopulationDictionaryHashMap에 있으면 나라 이름과 인구를 반환
		if (countriesAndPopulationDictionaryHashMap.containsKey(countryToLookUp)) {
			return countryToLookUp + ": " + countriesAndPopulationDictionaryHashMap.get(countryToLookUp);
		}
		// 없으면 "No country in database" 반환
		return "No country in database";
	}

	// 4. Vector 컬렉션을 이용하여 강수량의 평균을 유지 관리하는 프로그램을 작성하라. 강수량을 입력하면 벡터에 추가하고 현재 입력된 모든
	// 강수량과 평균을 출력한다.
	void problem4() {
		// 입력한 강수량을 대입받을 정수 변수
		int precipitation = 0;
		// 입력한 강수량들을 저장할 Vector 변수
		Vector<Integer> precipitationLevels = new Vector<>();
		// precipitation이 0이 아니면 반복하는 do while문
		do {
			System.out.print("Enter precipitation (enter 0 to terminate program): ");
			// precipitation에 입력한 강수량을 대입
			precipitation = handleParseIntError();
			// precipitation이 0이면 while문을 끗낸다
			if (precipitation == 0) {
				break;
			}
			// precipitationLevels에 precipitation 저장
			precipitationLevels.add(precipitation);
			// 입력된 모든 강수량과 평균을 출력
			System.out.println("Entered precipitation levels: " + precipitationLevels.toString());
			System.out.println("Current precipitation average: "
					+ (precipitationLevels.stream().mapToInt(Integer::valueOf).sum() / precipitationLevels.size()));
		} while (precipitation != 0);
	}

	/*
	 * 5. 하나의 학생 정보를 나타내는 Student 클래스에는 이름, 학과, 학번, 학점 평균을 저장하는 필드가 있다. 학생마다 Student
	 * 객체를 생성하고 4명의 학생 정보를 ArrayList 컬렉션에 저장한 후에, ArrayList의 모든 학생(4명) 정보를 출력하고 학생
	 * 이름을 입력받아 해당 학생의 학점 평균을 출력하는 프로그램을 작성하라.
	 */
	void problem5() {
		// 입력한 한생들을 저장할 ArrayList 변수
		ArrayList<Student> students = new ArrayList<Student>(4);
		// 찾아보고 싶은 학생 이름을 대입받을 문자열 변수
		String studentToLookUp = "";

		// 4번 반복하면서 Student instance를 만들고 만든 Student instance를 students에 저장
		for (int i = 0; i < 4; i++) {
			students.add(createStudent(i + 1, false));
		}
		// 모든 학생 정보를 출력
		students.forEach(
				student -> System.out.println(student.getName() + ", " + student.getConcentration() + ", " + student.getGrade() + ", " + student.getGPA())
		);
		
		// 찾아보고 싶은 학생 이름을 studentToLookUp에 대입
		while (!studentToLookUp.equals("quit")) {
			System.out.print("Enter the name of the student to look up: ");
			studentToLookUp = this.scanner.nextLine();
			// 찾아보고 싶은 학생 이름과 GPA 출력
			for (Student student : students) {
				if (student.getName().equals(studentToLookUp)) {
					System.out.println("Student: " + studentToLookUp + " GPA: " + student.getGPA());
				}
			}
		}
	}

	/*
	 * 6. 도시 이름, 위도, 경도 정보를 가진 Location 클래스를 작성하고, 도시 이름을 '키'로 하는 HashMap<String,
	 * Location> 컬렉션을 만들고, 사용자로부터 입력 받아 4개의 도시를 저장하라. 그리고 도시 이름으로 검색하는 프로그램을 작성하라.
	 */
	void problem6() {
		// 도시들을 저장할 HashMap 변수
		HashMap<String, Location> cities = new HashMap<String, Location>();
		// 도시 class를 반복하면서 저장할 변수
		Location location;
		// 도시의 이름을 반복하면서 저장할 변수
		String cityName;

		// 4번 반복하면서 location에 Location class를 대입하고 location.city와 location을 cities에 저장
		System.out.println("Enter the name of the city to look up");
		for (int i = 0; i < 4; i++) {
			location = createLocation(i + 1);
			cities.put(location.getCity(), location);
		}
		// shouldContinue가 true면 반
		System.out.println("Enter the name of the city to look up. Enter \"quit\" to terminate program: ");
		while (true) {
			// 찾아볼 도시이름을 cityName에 대입
			System.out.print("City name: ");
			cityName = this.scanner.nextLine();
			// cityName이 "quit"면 프로그램 종료
			if (cityName.toLowerCase().equals("quit")) {
				System.out.println("Terminating program");
				return;
			}
			// location에 도시를 cities에서 찾아서 대입 (cities에 도시가없으면 null이 대입됨)
			location = cities.get(cityName);
			// location이 null이면 cityName + " is not in the database" 출력
			if (location == null) {
				System.out.println(cityName + " is not in the database");
			// 아니면 도시 정보 출력
			} else {
				System.out.println("City: " + location.getCity() + " Latitude: " + location.getLatitude() + " Longitude: " + location.getLongitude());
			}
		}
	}

	// 7. 이름과 학점(4.5만점)을 5개 입력받아 해시맵에 저장하고, 장학생 선발 기준을 입력 받아 장학생 명단을 출력하라.
	String problem7() {
		// 학생 이름과 학점을 저장할 HashMap 변수
		HashMap<String, Double> students = new HashMap<String, Double>();
		// 학생을 반복하면서 만들때 대입받을 변수
		Student student;
		// 장학생 이름들을 합해서 출력할 문자열 변수
		String studentsQualifiedForScholarship = "Students ";
		// 장학생 선발 기준을 대입받을 변수
		double minimumGPA;

		// 5변 반복하면서 Student instance를 만들고 student에 대입후 students에 저장
		for (int i = 0; i < 5; i++) {
			student = createStudent(i + 1, true);
			students.put(student.getName(), student.getGPA());
		}

		// 장학생 선발 기준을 minimumGPA에 대입
		System.out.print("Enter the minimum GPA to qualify for a scholarship: ");
		minimumGPA = handleParseDoubleError();

		// students에 저장된 student를 반복하면서 registeredStudents에 대입
		for (Map.Entry<String, Double> registeredStudents : students.entrySet()) {
			String name = registeredStudents.getKey();
			Double gpa = registeredStudents.getValue();
			// registeredStudents의 gpa가 minimumGPA이상이면
			// studentsQualifiedForScholarshiptString에 이름을 더한다
			if (gpa >= minimumGPA) {
				studentsQualifiedForScholarship += studentsQualifiedForScholarship.equals("Students ") ? name : ", " + name;
			}
		}
		// 장학생들의 이름 반환
		return studentsQualifiedForScholarship + " are qualified for a scholarship";
	}

	// 8. 고객의 이름과 포인트 점수를 관리하는 프로그램을 해시맵을 이용하여 작성하라. 프로그램은 고객의 이름과 포인트를 함께 저장 관리하는데,
	// 포인트는 추가될 때마다 누적하여 저장된다.
	void problem8() {
		// 고객들의 이름과 점수를 저장할 HashMap 변수
		HashMap<String, Integer> customers = new HashMap<String, Integer>();
		// 입력받은 고객의 이름과 점수 문자열을 이름과 점수로 나눠서 저장할 문자열 변수
		String[] customerNameAndScoreList = new String[2];
		// 입력받은 고객의 이름과 점수 문자열을 대입받을 문자열 변수
		String customerNameAndScore;
		// 고객의 이름을 대입받을 문자열 변수
		String customerName = "";
		// 고객의 점수를 대입받을 정수 변수
		int customerScore = 0;

		System.out.println("8.");
		while (true) {
			// didEnterCorrectFormat가 false면
			while (true) {
				// customerNameAndScore에 고객의 이름과 점수를 대입
				System.out.print("Enter customenr's name and score (ex Mark 30): ");
				customerNameAndScore = this.scanner.nextLine();
				// customerNameAndScore를 이름과 점수를 나눠서 배열을 만들고 customerNameAndScoreList에 대입
				customerNameAndScoreList = customerNameAndScore.split(" ");
				// customerName에 customerNameAndScoreList[0] (고객의 이름 아니면 "quit") 대입
				customerName = customerNameAndScoreList[0];
				// customerName이 "quit"면 프로그램 종료
				if (customerName.toLowerCase().equals("quit")) {
					System.out.println("Terminating program");
					break;
				}
				// customerNameAndScoreList[0] (점수)가 정수가아니면 예외처리
				try {
					// customerNameAndScoreList[0] (점수)가 정수면 didEnterCorrectFormat에 true 대입
					customerScore = Integer.parseInt(customerNameAndScoreList[1]);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Enter a number for the score");
				}
			}

			if (!customerName.toLowerCase().equals("quit")) {
				// 고객이 customers에 없으면 이름과 점수를 customers저장
				if (customers.get(customerName) == null) {
					customers.put(customerName, customerScore);
					// 고객이 customers에 있으면 점수에 새로운 점수를 더한다
				} else {
					customers.put(customerName, customers.get(customerName) + customerScore);
				}
				// 고객들 출력
				customers.forEach((key, value) -> System.out.print("(" + key + "," + value + ")"));
				System.out.println();
			} else {
				break;
			}
		}
	}

	// 9. 나라와 수도 맞추기 게임의 실행 예시는 다음과 같다.
	// (1) 나라 이름(country)과 수도(capital)로 구성된 Nation 클래스를 작성하고 Vector 컬렉션을 이용하여 프로그램을
	// 작성하라.
	void problem9() {
		// 나라의 수도를 무작위 순서로 물어볼수있게 쓰는 Random 변수
		Random random = new Random();
		// Country instance를 생성할때 대입받을 Country 변수
		Country country;
		// 나라와 수도를 변수로 가지고 있는 Country instance들을 저장할 Vector 변수
		Vector<Country> countries = new Vector<Country>();
		// 게임할때 입력받은 수도 이름을 대입받을 변수
		String capitalName;
		// 게임할때 이미 정답을 받은 나라인지 채크할때 쓰는 HashMap 변수 (수도를 맟추면 나라이름을 key로 true를 value로 저장)
		HashMap<String, Boolean> correctlyAnsweredCountries = new HashMap<String, Boolean>();
		// 입력한 나라가 countries에 이미 있는지 여부하는 불린
		boolean isInCountries = false;

		System.out.println("9.");
		while (true) {
			System.out.println("There are currently " + countries.size() + " countries in the list");
			System.out.print("Press 1 to add a country. Press 2 to start quiz. Press 3 to quit: ");
			// 입력받은 정수를 switch로 처리
			switch (handleParseIntError()) {
			case 1:
				while (true) {
					// Country instance를 생성한후 country에 대입
					country = new Country(this.scanner);
					// country의 이름이 "quit"면 while 탈출
					if (country.getCountryName().equals("quit")) {
						break;
					}
					for (Country savedCountry : countries) {
						// countries에 country가 이미 있으면 isInCountries에 true 대입 그리고 "(나라 이름) is already in
						// the list" 출력
						if (savedCountry.getCountryName().equals(country.getCountryName())) {
							isInCountries = true;
							System.out.println(country.getCountryName() + " is already in the list");
							break;
						}
					}
					// !isInCountries가 true면 countries에 저장 아니면 isInCountries에 false대입
					if (!isInCountries) {
						countries.add(country);
					} else {
						isInCountries = false;
					}
				}
				break;
			case 2:
				// countries에 저장된 나라들의 개수만큼 반복
				for (int i = 0; i < countries.size(); i++) {
					// country에 물어볼 나라를 대입 (난수를 이용해 countries에서 무작위로 나라를 고른다)
					country = countries.get(random.nextInt(countries.size()));
					// correctlyAnsweredCountries에 고른 나라가 없으면 (아직 맞추지 못햇다는 뜻)
					if (correctlyAnsweredCountries.get(country.getCountryName()) == null) {
						System.out.print("What is the capital of " + country.getCountryName() + "?: ");
						// capitalName에 입력한 수도이름 아니면 "quit" 대입
						capitalName = this.scanner.nextLine();
						// capitalName이 "quit"이면 for문 탈출
						if (capitalName.equals("quit")) {
							break;
							// 아니면 capitalName이 고른 나라의 수도와 같으면 correctlyAnsweredCountries에 저장하고 "correct" 출력
						} else if (capitalName.equals(country.getCapitalName())) {
							correctlyAnsweredCountries.put(country.getCountryName(), true);
							System.out.println("correct");
							// 아니면 i에서 1을 빼고 "incorrect" 출력
						} else {
							i--;
							System.out.println("incorrect");
						}
						// 있으면 i에서 1을 뺀다
					} else {
						i--;
					}
				}
				// 게임 끗난 후 correctlyAnsweredCountries 초기화
				correctlyAnsweredCountries = new HashMap<String, Boolean>();
				break;
			case 3:
				// "Terminating program" 출력후 프로그렘 종료
				System.out.println("Terminating program");
				System.exit(0);
			default:
				System.out.println("Enter 1, 2, or 3");
				break;
			}
		}

	}

	public static void main(String[] args) {
		CollectionPracticeProblems problems = new CollectionPracticeProblems();
		problems.startProgram();
	}
}
