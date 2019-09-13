package arvoreRN;

public class MainArvoreRN {

	public static void main(String[] args) {
        ArvoreRN arn = new ArvoreRN();

        /// teste 1 ///
        // arn.insert(null, 1);
        // arn.insert(arn.root(), 2);
        // arn.insert(arn.root(), 3);
        // arn.insert(arn.root(), 4);
        // arn.insert(arn.root(), 5);
        // arn.insert(arn.root(), 6);
        // arn.insert(arn.root(), 7);
        // arn.insert(arn.root(), 8);
        // arn.insert(arn.root(), 9);

        /// teste 2 ///
        // arn.insert(null, 30);
        // arn.insert(arn.root(), 13);
        // arn.insert(arn.root(), 53);
        // arn.insert(arn.root(), 8);
        // arn.insert(arn.root(), 23);
        // arn.insert(arn.root(), 43);
        // arn.insert(arn.root(), 83);
        // arn.insert(arn.root(), 63);
        // arn.insert(arn.root(), 93);
        // arn.insert(arn.root(), 96);

        System.out.println(arn.mostraArvore());
	}

}
