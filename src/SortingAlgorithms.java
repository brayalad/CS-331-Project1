	import java.util.Random;
	import java.util.Scanner;

	

	public class SortingAlgorithms { //Java class containing the various algorithims

		public static Scanner input = new Scanner(System.in); //Scanner for user input
		public static Random rand = new Random(); //Random class to generate random numbers for the list of numbers
		
		public static void main(String[] args) { //The java programs main method
			
			
			while(true) { //while loop that will run program until user terminates the program
				
				System.out.println("Enter the task you would like to execute: \n" +  //The program options for the user
						   "1. Sorting Algorithims (Task #1) \n" +                   //Option 1 runs task 1
						   "2. Matrix Multiplication (Task #2)");                    //Option 2 runs task 2
				
				switch(input.nextInt()) { //Takes input from user to see what task to run
				
				case 1: task1(); //runs task 1
						break;
						
				case 2: task2(); //runs task 2
						break;
				
				default: System.out.println("Please Enter Valid Input"); //runs if inputed input is invalid
						break;
				
				}
				
				
			}

		}

		
		public static void task1() { //runs task 1 which deals with sorting algorithims
			
			long initTime = 0; //Initialize the start time for counter in milliseconds
			long finalTime = 0; //Initialize the final time for counter in milliseconds
			System.out.print("Enter size of list: "); //Prompts user for size of list
			int[] numbers = new int[input.nextInt()]; //creates new list of size the user inputed
			

			for (int i = 0; i < numbers.length; i++) //for loop runs for the whole size of the numbers list
				numbers[i] = rand.nextInt(1000000); //Every iteration sets the current index to a random number
			
			System.out.println("Enter the sorting algorithim you would like to use: \n" +  //Informs user of sorting algorithim options
							   "1. Exchange Sort\n" +                                      //Option 1 runs Excnahge Sort
							   "2. Merge Sort\n" + 										   //Option 2 runs Merge Sort
							   "3. Quick Sort");										   //Option 3 runs Quick Sort
			
			
			
			switch(input.nextInt()) { //Prompts user for input to choose sorting algorithim
			
			case 1: initTime = System.currentTimeMillis(); //Sets start time to current time in milliseconds
					numbers = runExchangeSort(numbers); //Runs exchange sort
					finalTime = System.currentTimeMillis(); //Sets final time to current time in milliseconds
					break;
			
			case 2: initTime = System.currentTimeMillis(); //Sets start time to current time in milliseconds
					numbers = runMergeSort(numbers); //Runs Merge Sort
					finalTime = System.currentTimeMillis(); //Sets final time to current time in milliseconds
					break;
			
			case 3: initTime = System.currentTimeMillis(); //Sets start time to current time in milliseconds
					numbers = runQuickSort(numbers); //Runs Quick Sort
					finalTime = System.currentTimeMillis(); //Sets final time to current time in milliseconds
					break;
			
			}
			
			
			System.out.println("Run Time: " + (finalTime - initTime) + " milliseconds\n"); //prints out total run time in milliseconds
			
		}
		
		
		public static void task2(){ //runs task 2 dealing with matrix multiplication
			
			long initTime = 0; //Initialize the start time for counter in milliseconds
			long finalTime = 0;  //Initialize the final time for counter in milliseconds
			System.out.print("Enter size of matrix: "); //Prompts user to enter size of matrix
			int n = input.nextInt(); //Size of matrix is set to user input
			
			int[][] matrix1 = new int[n][n]; //First matrix is made 
			int[][] matrix2 = new int[n][n]; //Second Matrix is made
			int[][] results = new int[n][n]; //results matrix is made
		       for (int i = 0; i < matrix1.length; i++) { //for loop runs for size of matrix
		           for (int j = 0; j < matrix1[0].length; j++) { //nested for loop runs for size of matrix
		               matrix1[i][j] = rand.nextInt(1000); //each iteration the index is net to random number
		           } 
		       }
		       
		       for (int i = 0; i < matrix2.length; i++) { //for loop runs for size of matrix
		           for (int j = 0; j < matrix2[0].length; j++) { //nested for loop runs for size of matrix
		               matrix2[i][j] = rand.nextInt(1000); //each iteration the index is net to random number
		           } 
		       }
		       
		       System.out.println("Enter the matrix multiplication algorithim you would like to use: \n" +  //Informs user of multipliation options
		    		   			  "1. Standard Matrix Multiplication\n" + 									//Option 1 runs Standard Matrix Multiplication
					              "2. Strassen Matrix Multiplication");										//Option 2 runs Strassen Matrix Multipliation
			
		       
		       switch(input.nextInt()) { //User chooses method to run
				
				case 1: initTime = System.currentTimeMillis(); //Sets start time to current time in milliseconds
						results = standardMatrix(n,matrix1, matrix2,results); //runs standard matrix multiplication
						finalTime = System.currentTimeMillis(); //Sets final time to current time in milliseconds
						break;
				
				case 2: initTime = System.currentTimeMillis();//Sets start time to current time in milliseconds
						results = strassenMatrix(n,matrix1, matrix2); //runs strassen's matrix multiplication
						finalTime = System.currentTimeMillis();//Sets final time to current time in milliseconds
						break;
				
		
				
				}
		       
		       System.out.println("RunTime: " + (finalTime - initTime) + " milliseconds\n");  //prints out total run time in milliseconds
		       
		       
		       
		}
		
		
		public static int[] runQuickSort(int[] numbers) { //Sets up to run quick sort

			quickSort(numbers, 0, numbers.length - 1); //Runs quick sort algorithim

			return numbers; //returns sorted list of numbers
		}

		private static void quickSort(int[] numbers, int init, int last) { //quick sort algorithim

			if ((last - init) < 1 || (last < 0)) {
				
			}

			int pivotIndex = partitionList(numbers, init, last); //the list is partiioned

			quickSort(numbers, init, pivotIndex - 1); //recursive run of quicksort with partioned list to left of pivot
			quickSort(numbers, pivotIndex + 1, last); //recursive run of quicksort with partioned list to right of pivot

		}

		private static int partitionList(int[] numbers, int init, int last) { //partitioning of list 
			int pivot = init; //Setting pivot to first number in list

			for (int i = init; i < last; i++) { //for loop running for size of list
				if (numbers[i] < numbers[last]) { //checking if current index is less then last number in list
					swap(numbers, pivot, i); //swaping the last assigned pivot with the current element
					++pivot; //increasepivot by 1
				}
			}

			swap(numbers, last, pivot); //swap the last element of partiion with pivot
			return pivot; //returns the pivot index
		}

		
		
		public static int[] runMergeSort(int[] numbers) { //runs merge sort algorithim
			
			return mergeSort(numbers, 0, numbers.length - 1); //returns an array of numbers sorted using merge sort
		}

		private static int[] mergeSort(int[] numbers, int init, int last) { //merge sort algorithim
			if ((last - init) == 0) { //checks if size of array is 1. if yes array is already sorted
				return new int[] { numbers[last] }; //returns the sorted array which was already sorted since it only contained one elements
			}

			int mid = (last + init) / 2; //sets the mid intetger to the size of the array divided by 2

			int[] subList1 = mergeSort(numbers, init, mid); //creates a sub array that is half the size of orignial array
			int[] subList2 = mergeSort(numbers, mid + 1, last); //creates a sub array that is half the size of orignial array

			return merge(subList1, subList2); //returns the result of merging the two sub arrays together
		}

		private static int[] merge(int[] subList1, int[] subList2) { //merges two sublist together into one list
			int[] result = new int[subList1.length + subList2.length]; //the result arrya is initilzed and made to be the size of sublist 1 and sublist 2 combined
			int sub1First = 0; //first index if sublist 1 initialized
			int sub2First = 0; //first index of sublist 2 initialezed

			for (int i = 0; i < result.length; i++) { //for loop running for the length of the result array
				if (sub1First == subList1.length) { //checks if the current index for first sub array is equal to its length
					result[i] = subList2[sub2First++]; //sets the remaining indexes of results array to the second sub array
				} else if (sub2First == subList2.length) { //checks if the current index for second sub array is equal to its length
					result[i] = subList1[sub1First++]; //sets the remaining indexes of results array to the first sub array
				} else if (subList1[sub1First] <= subList2[sub2First]) { //checks if the current element in sub array 1 is less than are equal to the current element in sub array 2
					result[i] = subList1[sub1First++]; //sets current result element equal to the current sublist 1 elements
				} else { //checks if the current element in sub array 1 is less than are equal to the current element in sub array 2
					result[i] = subList2[sub2First++];//sets current result element equal to the current sublist 2 elements
				}
			}

			return result; //returns the result array which is sublist 1 and sublist 2 merged in sorted order
		}

		
		public static int[] runExchangeSort(int[] numbers) { //runs exchange sort
			
			return exchangeSort(numbers); //returns an array that was sorted using exchange sort
			
		}
		
		
		public static int[] exchangeSort (int [] numbers ) //The exchange sort algorithim
		{
		     
		     for (int i=0;i<numbers.length-1; i++ )  //For loop that runs for the size of the array
		     {
		          for (int j=i+1;j<numbers.length;j++) //Nested forloop that runs for the size of the array and size of first for loop
		          {
		               if(numbers[i]>numbers[j] )    //Checks if the first current element is greater than the next element    
		               {
		                       swap(numbers, i, j); //swaps the current element with the next element
		                }           
		          }
		     }
		     
		     return numbers; //returns the array inputed now sorted
		}
	
		private static void swap(int[] numbers, int i, int j) { //method to swap to elements with each other
			int temp = numbers[i]; //temparary integer to hold value of first number
			numbers[i] = numbers[j]; //sets value of first element in list equal to the second number of the list
			numbers[j] = temp; //sets the value of the second element equal to the temporary elements which stored the value of the fist element
		}

		
		
		public static int[][] standardMatrix(int n, int[][] A, int[][] B, int [][]results){ //standard matrix multiplication algorithim
			
			for(int i = 0; i < n; i++) { //for lopp that runs for the size of the matrices
				
				for(int j = 0; j < n; j++) { //nested for loop runs for size of matrices and the for loop
					
					results[i][j] = 0; //value of current element in results matrix is initilized
					for(int k = 0; k < n; k++) { //nest for loop within a nested for loop running for the size of the matrices and the length of the two other foor loops
						results[i][j] = results[i][j] + (A[i][k]*B[k][j]); //sets the curent index of results matrix to the sum if its current value and the product of the current first and second matrices together
					}
					
				}
				
			}
			
			
			
			return results; //returns the maultiplied result matrix
		}
		
		
		
		
		
		
		public static int[][] strassenMatrix(int n, int[][] A, int[][] B){ //Strassen's method for matix multiplication
		
			int[][] results = new int[n][n]; //results matirx is initiliex to the size of the two input matricies
			
			if(n==1) //checks if the size of the matices is 1
				results[0][0] = A[0][0]*B[0][0]; //multiplies the matrices the standard way
			else {// if not any of the above, Strassens atirx multiplication executes
				
				int [][] A11 = new int[(n/2)][(n/2)]; //Initializing First Sub Matrix of the First inputed matrix set to a fourth the original size
				int [][] A12 = new int[(n/2)][(n/2)]; //Initializing Second Sub Matrix of the First inputed matrix set to a fourth the original size 
				int [][] A21 = new int[(n/2)][(n/2)]; //Initializing Third Sub Matrix of the First inputed matrix set to a fourth the original size
				int [][] A22 = new int[(n/2)][(n/2)]; //Initializing Fourth Sub Matrix of the First inputed matrix set to a fourth the original size
				int [][] B11 = new int[(n/2)][(n/2)]; //Initializing First Sub Matrix of the Second inputed matrix set to a fourth the original size
				int [][] B12 = new int[(n/2)][(n/2)]; //Initializing Second Sub Matrix of the Second inputed matrix set to a fourth the original size
				int [][] B21 = new int[(n/2)][(n/2)]; //Initializing Third Sub Matrix of the Second inputed matrix set to a fourth the original size
				int [][] B22 = new int[(n/2)][(n/2)]; //Initializing Fourth Sub Matrix of the Second inputed matrix set to a fourth the original size
				
				split(A,A11,0,0); //Splitting the contents of first matrix into 4 and copying it into its first sub matrix
				split(A,A12,0,(n/2)); //Splitting the contents of first matrix into 4 and copying it into its second sub matrix
				split(A,A21,(n/2),0); //Splitting the contents of first matrix into 4 and copying it into its third sub matrix
				split(A,A22,(n/2),(n/2)); //Splitting the contents of first matrix into 4 and copying it into its fourth sub matrix
				split(B,B11,0,0); //Splitting the contents of second matrix into 4 and copying it into its first sub matrix
				split(B,B12,0,(n/2)); //Splitting the contents of second matrix into 4 and copying it into its second sub matrix
				split(B,B21,(n/2),0); //Splitting the contents of second matrix into 4 and copying it into its third sub matrix
				split(B,B22,(n/2),(n/2)); //Splitting the contents of second matrix into 4 and copying it into its fourth sub matrix
			
				int [][] P1 = strassenMatrix((n/2),addMatrix(A11, A22), addMatrix(B11, B22)); //initilizing matrix P1 to the product of the sum of the first and fourth sub matrices of matrix on and the sum of the first and fourth sub matrices of matrix 2
	            int [][] P2 = strassenMatrix((n/2),addMatrix(A21, A22), B11); //initializing matrix P2 to the product of the sum of the third and fourth sub matrices of matrix 1 and the first sub matrix of matrix 2
	            int [][] P3 = strassenMatrix((n/2),A11, subtractMatrix(B12, B22)); //initilizing matrix P3 to the product of the first sub matrix of the first matrix with the difference of the second and fourth sub matrices of the second matrix
	            int [][] P4 = strassenMatrix((n/2),A22, subtractMatrix(B21, B11)); //initilizing matrix P4 to the product of the fourth sub matrix of the first matrix with the difference of the third and first sub matrices of the second matrix
	            int [][] P5 = strassenMatrix((n/2),addMatrix(A11, A12), B22); //intializing matrix P5 to the product of the sum of the first and second sub matrices of the first matrix with the fourth submatrix of the second matrix
	            int [][] P6 = strassenMatrix((n/2),subtractMatrix(A21, A11), addMatrix(B11, B12)); //initilzing matrix P6 to the product of the differenece of the third and first sub matrices of the first matrix with the sum of the first and second submatrices of the second matrix
	            int [][] P7 = strassenMatrix((n/2),subtractMatrix(A12, A22), addMatrix(B21, B22)); //initialzing matrix P7 to the product of the differenece of the second and fourth sub matrices of the first matrix to the sum of the third and fourth sub matrices of the second matrix
	            
	            int [][] C11 = addMatrix(subtractMatrix(addMatrix(P1, P4), P5), P7); //initilizes matrix C11 to the sum of the difference of the sum if P1 and P4 with P5 with P7
	            int [][] C12 = addMatrix(P3, P5); //Initilizes matrix C12 with the sum of matirx P3 and P5
	            int [][] C21 = addMatrix(P2, P4); //Initializes matrix C21 to the sum of matrix P2 and P4
	            int [][] C22 = addMatrix(subtractMatrix(addMatrix(P1, P3), P2), P6); //initilizes matrix C22 to the sum of the difference of the sum if P1 and P3 with P2 with P6
	            
	            
	            
	            join(C11, results, 0 , 0); //copies matrix C11 into the upper left part of the result matrix
	            join(C12, results, 0 , (n/2)); //copies matrix C12 into the upper right part of the result matrix
	            join(C21, results, (n/2), 0); //copies matrix C21 into the lower left part of the result matrix
	            join(C22, results, (n/2), (n/2)); //copies matrix C22 into the lower right part of the result matrix
	            
	            
			}
			
			
		
			return results; //returns the resulted matrix 
		}
		
		
		public static void split(int[][]parent, int[][]child, int iB, int jB) { //Method that splits a matrix into sub matrix
			
			for(int i1 = 0, i2 = iB; i1 < child.length; i1++,i2++) {//for loop that runs for size of matrix
				
				for(int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) { //nested forr loop that runs for size of matrix and first for loop
				
					child[i1][j1] = parent[i2][j2]; //setting current element of sub matrix to the partitioned part of the orignal matrix
				}
			}
			
		}
		
		public static void join(int[][] child, int[][] parent, int iB, int jB) { //Method that coppies a sub matrix into part of a larger matrix
	
	        for(int i1 = 0, i2 = iB; i1 < child.length; i1++, i2++) { //loop that runs for size of matrix
	            for(int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) { //nested for loop that runs for size of matrix and the for loop above
	            	
	            	parent[i2][j2] = child[i1][j1]; //sets the current element of the larger matrix to the elements of the sub matrix
	          
	            	
	            }
	        }    
	      
	    }
		public static int[][] subtractMatrix(int[][] A, int[][] B) //method subtracts matrices
	    {
	        int n = A.length; // length of the matrices
	        int[][] C = new int[n][n]; //new result matrix initilized to size of the inputed matrices
	        for (int i = 0; i < n; i++)//for loop running for size of matrix
	            for (int j = 0; j < n; j++)//nested for loop running for size of matrix and above for loop
	                C[i][j] = A[i][j] - B[i][j]; //sets the current element of the result matrix to the difference of the current elements of the first and second matrices
	        return C; //returns the result matrix
	    }
		
		public static int[][] addMatrix(int[][] A, int[][] B)
	    {
	        int n = A.length; // length of the matrices
	        int[][] C = new int[n][n]; //new result matrix initilized to size of the inputed matrices
	        for (int i = 0; i < n; i++) //for loop running for size of matrix
	            for (int j = 0; j < n; j++) //nested for loop running for size of matrix and above for loop
	                C[i][j] = A[i][j] + B[i][j]; //sets the current element of the result matrix to the sum of the current elements of the first and second matrices
	        return C; //returns the result matrix
	    }
		
		public static void printMatrix(int[][] numbers) { //prints inputed matrix
			

		       for (int i = 0; i < numbers.length; i++) { //for loop running for size of matrix
		           for (int j = 0; j < numbers[0].length; j++) { //nested for loop running for size of matrix and above for loop
		               System.out.print(numbers[i][j] + " "); //prints out current element of the matrix
		           }
		           System.out.println();//prints a space
		       }
			
		}
		
		
		
		public static void printList(int[] numbers) { //prints inputed array
			
			for(int i = 0; i < numbers.length; i++) { //loop running for size of the array
				System.out.print(numbers[i] + " "); //prints the current element of the array
			}
			
		}
		

		

}
	

