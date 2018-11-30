package src.main.java.javadatastructuresalgorithms.Algorithms;

public class MagicSquare {

	private static int[][] magicSquare;
	private static int size;
	private int sum;

	public int[][] generateSquare(int n) {
		size = n;
		magicSquare = new int[n][n];
		int i = n / 2;
		int j = n - 1;
		for (int num = 1; num <= n * n;) {
			if (i == -1 && j == n) {
				j = n - 2;
				i = 0;
			} else {
				if (j == n) {
					j = 0;
				}
				if (i < 0) {
					i = n - 1;
				}
			}
			if (magicSquare[i][j] != 0) {
				j -= 2;
				i++;
				continue;
			} else {
				magicSquare[i][j] = num++;
			}
			j++;
			i--;
		}
		sum = n * (n * n + 1) / 2;
		return magicSquare;
	}

	public void printMagicSquare() {
		int n = size;
		int i = size / 2;
		int j = size - 1;
		System.out.println("The Magic Square for " + n + ":");
		System.out.println("Sum of each row or column " + sum + ":");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(magicSquare[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int Size() {
		return size;
	}

	public int SquareSum() {
		return sum;
	}
/*
	public int[][] addMatricesBySize(Matrix a, Matrix b) {
		int size = add(a.Size(), b.Size());
		return generateSquare(size);
	}

	public int[][] subtractMatricesBySize(Matrix a, Matrix b) {
		int size = subtract(a.Size(), b.Size());
		return generateSquare(size);
	}


	public int[][] multiplyMatricesBySize(Matrix a, Matrix b) {
		int size = multiply(a.Size(), b.Size());
		return generateSquare(size);
	}

	public boolean checkOdd(int size) {
		if (size % 2 == 0) {
			return false;
		}
		return true;
	}*/
}
