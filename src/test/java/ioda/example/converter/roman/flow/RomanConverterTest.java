package ioda.example.converter.roman.flow;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

import ioda.example.converter.roman.flow.RomanConverter;

public class RomanConverterTest {

	@Test
	public void XX() { RomanConverter.convert("XX", assertEquals("20"), Assert::fail); }

	@Test
	public void VI() { RomanConverter.convert("VI", assertEquals("6"), Assert::fail); }

	@Test
	public void IV() { RomanConverter.convert("IV", assertEquals("4"), Assert::fail); }

	@Test
	public void _4() { RomanConverter.convert("4", assertEquals("IV"), Assert::fail); }

	@Test
	public void _10() { RomanConverter.convert("10", assertEquals("X"), Assert::fail); }

	@Test
	public void _1998() { RomanConverter.convert("1998", assertEquals("MCMXCVIII"), Assert::fail); }

	@Test
	public void MCMXCVIII() { RomanConverter.convert("MCMXCVIII", assertEquals("1998"), Assert::fail); }

	@Test
	public void abc_results_in_error() { 
		RomanConverter.convert("abc", 
				Assert::fail,
				(error) -> Assert.assertEquals("Es handelt sich nicht um eine römische Zahl! abc", error));
	}

	@Test
	public void groesser_3000_results_in_error() { 
		RomanConverter.convert("3001", 
				Assert::fail,
				(error) -> Assert.assertEquals("Ungültiger Wertebereich, Wert muss zwischen 0 und 3001 liegen: 3001", error));
	}

	@Test
	public void gleich_0_results_in_error() { 
		RomanConverter.convert("0", 
				Assert::fail,
				(error) -> Assert.assertEquals("Ungültiger Wertebereich, Wert muss zwischen 0 und 3001 liegen: 0", error));
	}

	private Consumer<String> assertEquals(String expected) {
		return (result) -> Assert.assertEquals(expected, result);
	}
	
}