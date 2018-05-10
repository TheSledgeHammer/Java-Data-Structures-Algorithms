package eclispe;

public class Matrix {
	
	private static int[][] magicSquare;
	private static int size;
	private int Sum;
	private int n;
	public int[][] generateSquare(int n) {
		setN(n);
		//size = n;
		magicSquare = new int[n][n];
		int i = n/2;
		int j = n-1;
		for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n) //3rd condition
            {
                j = n-2;
                i = 0;
            }
            else
            {
                //1st condition helper if next number 
                // goes to out of square's right side
                if (j == n)
                    j = 0;
                     
                //1st condition helper if next number is 
                // goes to out of square's upper side
                if (i < 0)
                    i=n-1;
            }
             
            //2nd condition
            if (magicSquare[i][j] != 0) 
            {
                j -= 2;
                i++;
                continue;
            }
            else
                //set number
                magicSquare[i][j] = num++;
                 
            //1st condition
            j++;  i--;
        }
  
        // print magic square
		Sum = n*(n*n+1)/2;
		/*
        System.out.println("The Magic Square for "+n+":");
        System.out.println("Sum of each row or column "+ Sum +":");
       
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++)
                System.out.print(magicSquare[i][j]+" ");
            System.out.println();
        }
        */
        return magicSquare;
	}
	
	public void printMatrix() {
		// print magic square
		int n = size;
		int i = size/2;
		int j = size-1;
		System.out.println("The Magic Square for " + n + ":");
		System.out.println("Sum of each row or column " + Sum + ":");
		for(i = 0; i < n; i++) {
            for(j = 0; j < n; j++)
                System.out.print(magicSquare[i][j] + " ");
            System.out.println();
        }
	}
	
	public void setN(int n) {
		this.n = n;
		size = n;
	}
	
	public int getN() {
		return n;
	}
	
	public int Size() {
		return size;
	}
	
	public int MatrixSum() {
		return Sum;
	}
	
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
	
	private boolean checkOdd(int size) {
		if(size % 2 == 0) {
			return false;
		}
		return true;
	}
	
	private int add(int thisSize, int otherSize) {
		Matrix other = new Matrix();
		otherSize = other.Size();
		thisSize = this.Size();
		int newSize = thisSize + otherSize;
		if(!checkOdd(newSize)) {
			return newSize + 1;
		}
		return newSize;
	}
	
	public int subtract(int thisSize, int otherSize) {
		Matrix other = new Matrix();
		otherSize = other.Size();
		thisSize = this.Size();
		if(thisSize >= otherSize) {
			int newSize = thisSize - otherSize;
			if(!checkOdd(newSize)) {
				newSize = newSize + 1;
				return newSize;
			}
		}
		if(thisSize < otherSize) {
			int newSize = otherSize - thisSize;
			if(!checkOdd(newSize)) {
				newSize = newSize + 1;
				return newSize;
			}
		}
		return 0;
	}
	
	private int multiply(int thisSize, int otherSize) {
		Matrix other = new Matrix();
		otherSize = other.Size();
		thisSize = this.Size();
		int newSize = thisSize * otherSize;
		if(!checkOdd(newSize)) {
			newSize = newSize + 1;
		}
		return newSize;
	}
	

}
