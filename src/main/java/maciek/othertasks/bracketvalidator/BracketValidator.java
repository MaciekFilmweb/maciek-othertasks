package maciek.othertasks.bracketvalidator;

import java.util.Deque;
import java.util.LinkedList;

import com.google.common.base.Preconditions;

public class BracketValidator {
	
	public boolean validate(String string) {
		Preconditions.checkArgument(string.matches("[\\(\\)\\[\\]0-9]*"));
		
		Deque<Character> bracketStack = new LinkedList<>();
		
		for (char ch : string.toCharArray()) {
			switch (ch) {
			case '(':
			case '[':
				bracketStack.push(ch);
				break;
			case ')':
				if (bracketStack.isEmpty()) {
					return false;
				}
				if (bracketStack.pop() != '(') {
					return false;
				}
				break;
			case ']':
				if (bracketStack.isEmpty()) {
					return false;
				}
				if (bracketStack.pop() != '[') {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		if (new BracketValidator().validate(args[0])) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

}
