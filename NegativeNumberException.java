package CollectionPracticeProblems;

/**
 * @packageName : CollectionPracticeProblems
 * @fileNmae	: NegativeNumberException.java
 * @author		: mark
 * @date		: 2024.12.10
 * @description : 입력한 정수가 음수면 나타나는 오류
 * ===========================================================
 * DATE				AUTHOR				NOTE
 * -----------------------------------------------------------
 * 2024.12.10		MARK KIM		FIRST CREATED
 */
public class NegativeNumberException extends Exception {
	public NegativeNumberException(String message) {
		super(message);
	}
}
