package CollectionPracticeProblems;

/**
 * @packageName : CollectionPracticeProblems
 * @fileNmae	: NotALetterGradeException.java
 * @author		: mark
 * @date		: 2024.12.10
 * @description : 입력한 점수가이 A,B,C,D,F가 아니면 나타나는 오류
 * ===========================================================
 * DATE				AUTHOR				NOTE
 * -----------------------------------------------------------
 * 2024.12.10		MARK KIM		FIRST CREATED
 */
class NotALetterGradeException extends Exception {
	public NotALetterGradeException(String message) {
		super(message);
	}
}