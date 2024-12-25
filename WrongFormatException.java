package CollectionPracticeProblems;

/**
 * @packageName : CollectionPracticeProblems
 * @fileNmae	: WrongFormatException.java
 * @author		: mark
 * @date		: 2024.12.10
 * @description : 입력한 문자열의 채계가 틀렸을때 나타나는 오류
 * ===========================================================
 * DATE				AUTHOR				NOTE
 * -----------------------------------------------------------
 * 2024.12.10		MARK KIM		FIRST CREATED
 */
class WrongFormatException extends Exception {
	private static final long serialVersionUID = -8717741554587401673L;

	public WrongFormatException(String message) {
		super(message);
	}
}
