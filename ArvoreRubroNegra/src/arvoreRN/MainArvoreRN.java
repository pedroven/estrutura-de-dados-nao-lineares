package arvoreRN;

public class MainArvoreRN {

	public static void main(String[] args) {
        ArvoreRN arn = new ArvoreRN();

        /// teste 1 ///
        arn.insert(null, 1);
        arn.insert(arn.root(), 2);
        arn.insert(arn.root(), 3);
        arn.insert(arn.root(), 4);
        arn.insert(arn.root(), 5);
        arn.insert(arn.root(), 6);
        arn.insert(arn.root(), 7);
        arn.insert(arn.root(), 8);
        arn.insert(arn.root(), 9);
        arn.insert(arn.root(), 10);
        arn.remove(arn.search(10, arn.root()));
        arn.remove(arn.search(9, arn.root()));
        System.out.println(arn.mostraArvore());
        arn.remove(arn.search(7, arn.root()));
        arn.remove(arn.search(5, arn.root()));
        System.out.println(arn.mostraArvore());
        arn.remove(arn.search(1, arn.root()));
        System.out.println(arn.mostraArvore());
        arn.remove(arn.search(2, arn.root()));
        System.out.println(arn.mostraArvore());
        arn.remove(arn.search(3, arn.root()));
        //System.out.println(arn.mostraArvore());
        // arn.remove(arn.search(1, arn.root()));
        // arn.remove(arn.search(2, arn.root()));
        // arn.remove(arn.search(3, arn.root()));
        // System.out.println(arn.mostraArvore());
        // arn.remove(arn.search(4, arn.root()));
        // System.out.println(arn.mostraArvore());
        // arn.remove(arn.search(5, arn.root()));
        // arn.remove(arn.search(6, arn.root()));
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

        /// teste 3 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), 20);
        // arn.insert(arn.root(), 30);
        //arn.remove(arn.search(10, arn.root()));

        /// teste 4 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), 5);
        // arn.insert(arn.root(), -5);
        // arn.insert(arn.root(), 7);
        // arn.insert(arn.root(), 30);
        // arn.insert(arn.root(), 20);
        // arn.insert(arn.root(), 38);
        // arn.insert(arn.root(), 32);
        // arn.insert(arn.root(), 41);
        // arn.insert(arn.root(), 35);
        // arn.remove(arn.search(30, arn.root()));

        // teste 5 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), -10);
        // arn.insert(arn.root(), 30);
        // arn.insert(arn.root(), 20);
        // arn.insert(arn.root(), 38);
        // arn.insert(arn.root(), 19);
        // arn.remove(arn.search(19, arn.root()));
        // arn.remove(arn.search(10, arn.root()));

        // teste 6 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), -10);
        // arn.insert(arn.root(), 30);
        // arn.insert(arn.root(), 25);
        // arn.insert(arn.root(), 40);
        // arn.remove(arn.search(-10, arn.root()));

        /// teste 7 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), -10);
        // arn.insert(arn.root(), 30);
        // arn.insert(arn.root(), 1);
        // arn.insert(arn.root(), 100);
        // arn.remove(arn.search(100, arn.root()));
        // arn.remove(arn.search(1, arn.root()));
        // arn.remove(arn.search(-10, arn.root()));

        /// teste 8 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), -30);
        // arn.insert(arn.root(), 50);
        // arn.insert(arn.root(), -40);
        // arn.insert(arn.root(), 30);
        // arn.insert(arn.root(), 70);
        // arn.insert(arn.root(), -20);
        // arn.insert(arn.root(), 15);
        // arn.insert(arn.root(), 40);
        // arn.insert(arn.root(), -1);
        // arn.remove(arn.search(-1, arn.root()));
        // arn.insert(arn.root(), 14);
        // arn.remove(arn.search(14, arn.root()));
        // arn.remove(arn.search(-40, arn.root()));

        /// teste 9 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), -10);
        // arn.insert(arn.root(), 40);
        // arn.insert(arn.root(), -20);
        // arn.insert(arn.root(), -5);
        // arn.insert(arn.root(), 20);
        // arn.insert(arn.root(), 60);
        // arn.insert(arn.root(), 50);
        // arn.insert(arn.root(), 80);
        // arn.insert(arn.root(), -1);
        // arn.insert(arn.root(), -6);
        // arn.insert(arn.root(), -8);
        // arn.remove(arn.search(-8, arn.root()));
        // arn.insert(arn.root(), 1);
        // arn.remove(arn.search(-1, arn.root()));
        // arn.remove(arn.search(1, arn.root()));
        // arn.remove(arn.search(-6, arn.root()));
        // arn.insert(arn.root(), 100);
        // arn.remove(arn.search(100, arn.root()));
        // arn.remove(arn.search(10, arn.root()));

        /// teste 10 ///
        // arn.insert(null, 10);
        // arn.insert(arn.root(), 20);
        // arn.insert(arn.root(), 30);
        // arn.insert(arn.root(), 25);
        // arn.insert(arn.root(), 26);
        // arn.insert(arn.root(), 27);
        //arn.insert(arn.root(), 5);
        //arn.insert(arn.root(), 6);
        //arn.insert(arn.root(), 7);
        //arn.insert(arn.root(), 8);
        //arn.insert(arn.root(), 9);
        //arn.remove(arn.search(8, arn.root()));
        //arn.remove(arn.search(2, arn.root()));

        System.out.println(arn.mostraArvore());
	}

}
