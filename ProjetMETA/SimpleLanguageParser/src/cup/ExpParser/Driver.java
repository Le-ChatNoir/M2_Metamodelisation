package cup.example;

class Driver {

	public static void main(String[] args) throws Exception {
		Parser parser = new Parser();
		parser.parseString("10*3");
		System.out.println(parser.prog);
	}
	
}