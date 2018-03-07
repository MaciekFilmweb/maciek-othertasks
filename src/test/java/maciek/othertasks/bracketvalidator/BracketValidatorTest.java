package maciek.othertasks.bracketvalidator;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracketValidatorTest {
	
	private BracketValidator validator = new BracketValidator();
	
	@Test
	public void test() throws Exception {
		assertTrue(validator.validate("(([34[34]])234)"));
		assertTrue(validator.validate("([([()])])"));
		assertTrue(validator.validate(""));
		
		assertFalse(validator.validate("([6)"));
		assertFalse(validator.validate("(]"));
		assertFalse(validator.validate("))))))"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgument() {
		validator.validate("abc");
	}

}
