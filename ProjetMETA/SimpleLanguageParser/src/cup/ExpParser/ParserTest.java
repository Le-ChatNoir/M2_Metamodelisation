package cup.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import SLMetaModel.*;
import backEnd.Calculator;

class ParserTest {

	@Test
	void test() {
		Parser parser = new Parser();
		try {
			parser.parseString("30-7");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calculator calc = new Calculator();
		parser.prog.get(0).accept(calc);
		System.out.println(((IntExp)calc.result()).getVal());
		assertTrue(((IntExp)calc.result()).getVal() == 23);
	}

}
