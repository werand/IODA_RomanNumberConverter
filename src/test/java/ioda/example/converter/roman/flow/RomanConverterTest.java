package ioda.example.converter.roman.flow;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.function.Consumer;

import org.junit.Test;

import ioda.example.converter.contract.Error;

public class RomanConverterTest {

	@Test public void XX() { 
		RomanConverter.convert("XX").peek(
				failOnError(),
				assertResult("20"));
	}

	@Test public void VI() { 
		RomanConverter.convert("VI").peek(
				failOnError(),
				assertResult("6"));
	}

	@Test public void IV() { 
		RomanConverter.convert("IV").peek(
				failOnError(),
				assertResult("4")); 
	}

	@Test public void _4() {
		RomanConverter.convert("4").peek(
						failOnError(),
						assertResult("IV"));
	}

	@Test public void _10() { 
		RomanConverter.convert("10").peek(
				failOnError(),
				assertResult("X"));
	}

	@Test public void _1998() {
		RomanConverter.convert("1998").peek(
				failOnError(),
				assertResult("MCMXCVIII"));
	}

	@Test
	public void MCMXCVIII() { 
		RomanConverter.convert("MCMXCVIII").peek(
				failOnError(),
				assertResult("1998"));
	}

	@Test public void abc_results_in_error() {
		RomanConverter.convert("abc").peek( 
				assertError("Es handelt sich nicht um eine römische Zahl! abc"),
				assertNoResult());
	}

	@Test public void groesser_3000_results_in_error() { 
		RomanConverter.convert("3001").peek(
				assertError("Ungültiger Wertebereich, Wert muss zwischen 0 und 3001 liegen: 3001"),
				assertNoResult());
	}

	@Test public void gleich_0_results_in_error() { 
		RomanConverter.convert("0").peek( 
				assertError("Ungültiger Wertebereich, Wert muss zwischen 0 und 3001 liegen: 0"),
				assertNoResult());
	}

    private static Consumer<Error> failOnError() {
        return (error) -> fail(error.getErrorMessage());
    }

    private static Consumer<Error> assertError(String expected) {
        return (result) -> assertEquals(expected, result.getErrorMessage());
    }

    private static Consumer<String> assertResult(String expected) {
		return (result) -> assertEquals(expected, result);
	}

	private static Consumer<String> assertNoResult() {
	    return (result) -> fail("Should have no result. Result: " + result);
    }
}