package CollectionPracticeProblems;

/**
 * @packageName : CollectionPracticeProblems
 * @fileNmae	: NameIsEmptyException.java
 * @author		: mark
 * @date		: 2024.12.10
 * @description : 입력한 문자열이 비어있으면 나타나는 오류
 * ===========================================================
 * DATE				AUTHOR				NOTE
 * -----------------------------------------------------------
 * 2024.12.10		MARK KIM		FIRST CREATED
 */
public class NameIsEmptyException extends Exception {
	private static final long serialVersionUID = 1848119116825768024L;

	public NameIsEmptyException(String message) {
		super(message);
	}
}
