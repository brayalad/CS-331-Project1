	import java.util.Random;
	import java.util.Scanner;

	

	public class SortingAlgorithms {

		public static Scanner input = new Scanner(System.in);
		public static Random rand = new Random();
		
		public static void main(String[] args) {
			
			
			while(true) {
				
				System.out.println("Enter the task you would like to execute: \n" +  
						   "1. Sorting Algorithims (Task #1) \n" + 
						   "2. Matrix Multiplication (Task #2)");
				
				switch(input.nextInt()) {
				
				case 1: task1();
						break;
						
				case 2: task2();
						break;
				
				}
				
				
			}

		}

		
		public static void task1() {
			
			long initTime = 0;
			long finalTime = 0;
			System.out.print("Enter size of list: ");
			int[] list = new int[input.nextInt()];
			

			for (int i = 0; i < list.length; ++i) 
				list[i] = rand.nextInt(1000);
			
			System.out.println("Enter the sorting algorithim you would like to use: \n" +  
							   "1. Exchange Sort\n" + 
							   "2. Merge Sort\n" + 
							   "3. Quick Sort");
			
			
			
			switch(input.nextInt()) {
			
			case 1: initTime = System.currentTimeMillis();
					list = exchangeSort(list);
					finalTime = System.currentTimeMillis();
					break;
			
			case 2: initTime = System.currentTimeMillis();
					list = mergeSort(list);
					finalTime = System.currentTimeMillis();
					break;
			
			case 3: initTime = System.currentTimeMillis();
					list = quickSort(list);
					finalTime = System.currentTimeMillis();
					break;
			
			}
			
			
			System.out.println("\n" + (finalTime - initTime));
			
		}
		
		
		public static void task2(){
			
			long initTime = 0;
			long finalTime = 0;
			System.out.print("Enter size of matrix: ");
			int n = input.nextInt();
			
			int[][] matrix1 = new int[n][n];
			int[][] matrix2 = new int[n][n];
			int[][] results = new int[n][n];
		       for (int i = 0; i < matrix1.length; i++) {
		           for (int j = 0; j < matrix1[0].length; j++) {
		               matrix1[i][j] = rand.nextInt(10);
		           } 
		       }
		       
		       for (int i = 0; i < matrix2.length; i++) {
		           for (int j = 0; j < matrix2[0].length; j++) {
		               matrix2[i][j] = rand.nextInt(10);
		           } 
		       }
		       
		       System.out.println("Enter the matrix multiplication algorithim you would like to use: \n" +  
		    		   			  "1. Standard Matrix Multiplication\n" + 
					              "2. Strassen Matrix Multiplication");
			
		       
		       switch(input.nextInt()) {
				
				case 1: initTime = System.currentTimeMillis();
						results = standardMatrix(n,matrix1, matrix2,results);
						finalTime = System.currentTimeMillis();
						break;
				
				case 2: initTime = System.currentTimeMillis();
						results = strassenMatrix(n,matrix1, matrix2);
						finalTime = System.currentTimeMillis();
						break;
				
		
				
				}
		       
		       System.out.println("\n" + (finalTime - initTime));
		       
		       
		       
		}
		
		
		
		
		
		
		
		
		
		public static int[] quickSort(int[] numbers) {

			quickSortHelper(numbers, 0, numbers.length - 1);

			return numbers;
		}

		private static void quickSortHelper(int[] numbers, int init, int last) {

			if ((last - init) < 1 || (last < 0)) {
				return;
			}

			int pivotIndex = partitionList(numbers, init, last);

			quickSortHelper(numbers, init, pivotIndex - 1);
			quickSortHelper(numbers, pivotIndex + 1, last);

		}

		private static int partitionList(int[] numbers, int init, int last) {
			int lastAssignedPos = init;

			for (int i = init; i < last; ++i) {
				if (numbers[i] < numbers[last]) {
					swap(numbers, lastAssignedPos, i);
					++lastAssignedPos;
				}
			}

			swap(numbers, last, lastAssignedPos);
			return lastAssignedPos;
		}

		
		
		public static int[] mergeSort(int[] numbers) {
			
			
			
			return mergeSortHelper(numbers, 0, numbers.length - 1);
		}

		private static int[] mergeSortHelper(int[] numbers, int init, int last) {
			if ((last - init) == 0) {
				return new int[] { numbers[last] };
			}

			int mid = (last + init) / 2;

			int[] subList1 = mergeSortHelper(numbers, init, mid);
			int[] subList2 = mergeSortHelper(numbers, mid + 1, last);

			return merge(subList1, subList2);
		}

		private static int[] merge(int[] subList1, int[] subList2) {
			int[] result = new int[subList1.length + subList2.length];
			int sub1First = 0;
			int sub2First = 0;

			for (int i = 0; i < result.length; ++i) {
				if (sub1First == subList1.length) {
					result[i] = subList2[sub2First++];
				} else if (sub2First == subList2.length) {
					result[i] = subList1[sub1First++];
				} else if (subList1[sub1First] <= subList2[sub2First]) {
					result[i] = subList1[sub1First++];
				} else {
					result[i] = subList2[sub2First++];
				}
			}

			return result;
		}

		

		public static int[] exchangeSort (int [] numbers )
		{
		     
		     for (int i = 0; i < numbers.length - 1; i ++ )  
		     {
		          for (int j = i + 1; j < numbers.length; j ++ )
		          {
		               if( numbers[ i ] > numbers[ j ] )        
		               {
		                       swap(numbers, i, j); 
		                }           
		          }
		     }
		     
		     return numbers;
		}
	
		private static void swap(int[] numbers, int i, int j) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}

		
		
		public static int[][] standardMatrix(int n, int[][] A, int[][] B, int [][]results){
			
			for(int i = 0; i < n; i++) {
				
				for(int j = 0; j < n; j++) {
					
					results[i][j] = 0;
					for(int k = 0; k < n; k++) {
						results[i][j] = results[i][j] + (A[i][k]*B[k][j]);
					}
					
				}
				
			}
			
			
			
			return results;
		}
		
		
		
		
		
		
		public static int[][] strassenMatrix(int n, int[][] A, int[][] B){
		
			int[][] results = new int[n][n];
			
			if(n==1)
				results[0][0] = A[0][0]*B[0][0];
			else {
				
				int [][] A11 = new int[(n/2)][(n/2)];
				int [][] A12 = new int[(n/2)][(n/2)];
				int [][] A21 = new int[(n/2)][(n/2)];
				int [][] A22 = new int[(n/2)][(n/2)];
				int [][] B11 = new int[(n/2)][(n/2)];
				int [][] B12 = new int[(n/2)][(n/2)];
				int [][] B21 = new int[(n/2)][(n/2)];
				int [][] B22 = new int[(n/2)][(n/2)];
				
				split(A,A11,0,0);
				split(A,A12,0,(n/2));
				split(A,A21,(n/2),0);
				split(A,A22,(n/2),(n/2));
				split(B,B11,0,0);
				split(B,B12,0,(n/2));
				split(B,B21,(n/2),0);
				split(B,B22,(n/2),(n/2));
			
				int [][] M1 = strassenMatrix((n/2),addMatrix(A11, A22), addMatrix(B11, B22));
	            int [][] M2 = strassenMatrix((n/2),addMatrix(A21, A22), B11);
	            int [][] M3 = strassenMatrix((n/2),A11, subtractMatrix(B12, B22));
	            int [][] M4 = strassenMatrix((n/2),A22, subtractMatrix(B21, B11));
	            int [][] M5 = strassenMatrix((n/2),addMatrix(A11, A12), B22);
	            int [][] M6 = strassenMatrix((n/2),subtractMatrix(A21, A11), addMatrix(B11, B12));
	            int [][] M7 = strassenMatrix((n/2),subtractMatrix(A12, A22), addMatrix(B21, B22));
	            
	            int [][] C11 = addMatrix(subtractMatrix(addMatrix(M1, M4), M5), M7);
	            int [][] C12 = addMatrix(M3, M5);
	            int [][] C21 = addMatrix(M2, M4);
	            int [][] C22 = addMatrix(subtractMatrix(addMatrix(M1, M3), M2), M6);
	            
	            
	            
	            join(C11, results, 0 , 0);
	            join(C12, results, 0 , (n/2));
	            join(C21, results, (n/2), 0);
	            join(C22, results, (n/2), (n/2));
	            
	            
			}
			
			
		
			return results;
		}
		
		
		public static void split(int[][]parent, int[][]child, int iB, int jB) {
			
			for(int i1 = 0, i2 = iB; i1 < child.length; i1++,i2++) {
				
				for(int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) {
				
					child[i1][j1] = parent[i2][j2];
				}
			}
			
		}
		
		public static void join(int[][] child, int[][] parent, int iB, int jB) {
	
	        for(int i1 = 0, i2 = iB; i1 < child.length; i1++, i2++) {
	            for(int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) {
	            	
	            	parent[i2][j2] = child[i1][j1];
	          
	            	
	            }
	        }    
	      
	    }
		public static int[][] subtractMatrix(int[][] A, int[][] B)
	    {
	        int n = A.length;
	        int[][] C = new int[n][n];
	        for (int i = 0; i < n; i++)
	            for (int j = 0; j < n; j++)
	                C[i][j] = A[i][j] - B[i][j];
	        return C;
	    }
		
		public static int[][] addMatrix(int[][] A, int[][] B)
	    {
	        int n = A.length;
	        int[][] C = new int[n][n];
	        for (int i = 0; i < n; i++)
	            for (int j = 0; j < n; j++)
	                C[i][j] = A[i][j] + B[i][j];
	        return C;
	    }
		
		public static void printMatrix(int[][] numbers) {
			
			 System.out.println("Product of A and B is");
		       for (int i = 0; i < numbers.length; i++) {
		           for (int j = 0; j < numbers[0].length; j++) {
		               System.out.print(numbers[i][j] + " ");
		           }
		           System.out.println();
		       }
			
		}
		
		
		
		
		
		
		
		
		
		public static void printList(int[] numbers) {
			
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			
		}
		

		

}
	

