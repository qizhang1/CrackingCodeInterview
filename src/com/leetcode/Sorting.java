package com.leetcode;

public class Sorting {

	// only compare adjacent elements
	// "bubble" the largest up to the end
	// modified bubble sort with a flag isSorted
	// Worst O(n^2); Best O(n)
	public static void bubbleSort(int[] numbers) {
		boolean isSorted = false;
		// no more than numbers.length - 1 passes
		for (int pass = 1; pass < numbers.length && !isSorted; pass++) {
			isSorted = true;
			for (int i = 0; i < numbers.length - pass; i++) {
				if (numbers[i] > numbers[i + 1]) {
					// swap (numbers[i], numbers[i + 1])
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
					isSorted = false;
				}
			}
		}
	}

	// first block of array is maintained in sorted order <= x | x | > x
	// unsorted element is inserted into correct spot
	public static void insertSort1(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			for (int j = i; j > 0 && numbers[j] < numbers[j - 1]; j--) {
				// swap (numbers[j - 1], numbers[j])
				int temp = numbers[j - 1];
				numbers[j - 1] = numbers[j];
				numbers[j] = temp;
			}
		}
	}

	// Better insertSort: expand the "swap"
	// Worst O(n^2); Best O(n)
	public static void insertSort2(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int toInsert = numbers[i];
			int j;
			// shift to the right to clear the spot for toInsert
			for (j = i; j > 0 && toInsert < numbers[j - 1]; j--) {
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = toInsert; // insert
		}
	}

	// Select smallest or largest then move to the correct spot
	// Worst O(n^2); Best O(n^2)
	public static void selectionSort1(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			// select smallest element from unsorted part
			int minIndex = i;
			for (int j = i; j < numbers.length; j++) {
				if (numbers[j] < numbers[minIndex]) {
					minIndex = j;
				}
			}
			// swap (numbers[i], numbers[minIndex])
			int temp = numbers[i];
			numbers[i] = numbers[minIndex];
			numbers[minIndex] = temp;
		}
	}

	// recursion not recommended
	public static void selectionSort2(int[] numbers, int last) {
		if (last == 0)
			return;
		int maxIndex = 0;
		int j;
		for (j = 0; j <= last; j++) {
			if (numbers[j] > numbers[maxIndex]) {
				maxIndex = j;
			}
		}
		// swap
		int temp = numbers[last];
		numbers[last] = numbers[maxIndex];
		numbers[maxIndex] = temp;
		selectionSort2(numbers, last - 1);
	}

	// Divide-and-conquer
	// sorting is done in the merging step
	// Recursive
	public static void mergeSort1(int numbers[], int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort1(numbers, first, mid);
			mergeSort1(numbers, mid + 1, last);
			int[] temp = new int[last - first + 1]; // Primary drawback
			merge2(numbers, temp, first, mid, mid + 1, last);
		}
	}

	public static void merge1(int numbers[], int temp[], int first1, int last1,
			int first2, int last2) {
		int left = first1; // save the start position!!
		int right = first2;
		int len = last2 - first1 + 1;
		for (int i = 0; i < len; i++) {
			if (last1 >= right) {
				temp[i] = numbers[first2++];
			} else if (first2 >= left + len) {
				temp[i] = numbers[first1++];
			} else {
				temp[i] = numbers[first1] <= numbers[first2] ? numbers[first1++]
						: numbers[first2++];
			}
		}
		System.arraycopy(temp, 0, numbers, left, len);
	}

	// more readable
	public static void merge2(int numbers[], int temp[], int first1, int last1,
			int first2, int last2) {
		int left = first1; // save the start position!!
		int len = last2 - first1 + 1;
		int i;
		for (i = 0; first1 <= last1 && first2 <= last2; i++) {
			temp[i] = numbers[first1] <= numbers[first2] ? numbers[first1++]
					: numbers[first2++];
		}
		while (first1 <= last1) {
			temp[i++] = numbers[first1++];
		}

		while (first2 <= last2) {
			temp[i++] = numbers[first2++];
		}
		System.arraycopy(temp, 0, numbers, left, len);
	}

	// non-recursive, bottom up
	public static void mergeSort2(int[] numbers) {
		int len = numbers.length;
		int temp[] = new int[len]; // create auxiliary array only once
		for (int subArrayLen = 1; subArrayLen < len; subArrayLen *= 2) {
			for (int i = 0; i + subArrayLen < len; i = i + 2 * subArrayLen) {
				merge2(numbers, temp, i, i + subArrayLen - 1, i
						+ subArrayLen, Math.min(i + 2 * subArrayLen - 1, len - 1));
			}
		}
	}
	// *****************************************************************************************
	// non-comparison sort O(n)
	// Assume: numbers are non-negative with range [1, numbers.length], no duplicate
	public static void simpleBucketSort(int[] numbers) {
		int i = 0;
		while (i < numbers.length){
			if (numbers[i] != i + 1){
				//swap numbers[i] and numbers [numbers[i] - 1]
				int temp = numbers [numbers[i] - 1];
				numbers[numbers[i] - 1] = numbers[i];
				numbers[i] = temp;	
			}else{
				i++;
			}
		}	
	}
	
	// *****************************************************************************************
	// Quick sort
	public static void quickSort1(int[] numbers, int first, int last) {	
		if (first < last) {
			int pivotIndex = partition1(numbers, first, last);
			quickSort1(numbers, first, pivotIndex - 1);
			quickSort1(numbers, pivotIndex + 1, last);
		}
	}
    
	private static int partition1(int[] numbers, int left, int right) {
		int pivot = numbers[left]; // select first element as pivot (bad choice?)
		int leftUnknown = left + 1; // first is the pivot
		int rightUnknown = right;
		while (leftUnknown <= rightUnknown) {
			if (numbers[leftUnknown] >= pivot) {
				MyUtility.swap(numbers, leftUnknown, rightUnknown);
				rightUnknown--;
			} else {
				leftUnknown++;
			}
		}
		// Move the pivot to the spot between the partitioned sets.
		MyUtility.swap(numbers, left, rightUnknown);
		return rightUnknown;			
	}
	
	// *****************************************************************************************
	public static void quickSort2(int[] numbers, int left, int right) {	
		if (left < right) {
			int pivotIndex = partition2(numbers, left, right);
			quickSort2(numbers, left, pivotIndex - 1);
			quickSort2(numbers, pivotIndex + 1, right);
		}
	}
	
	private static int partition2(int[] numbers, int left, int right) {
		int pivotIndex = left;	
		int pivot = numbers[pivotIndex];
		for (int i = left + 1; i <= right; i++)
		{			
			if (numbers[i] < pivot)
			{
				numbers[pivotIndex] = numbers[i];
				numbers[i] = numbers[pivotIndex + 1];
				pivotIndex++;
			}
		}
		numbers[pivotIndex] = pivot; // reposition pivot
		return pivotIndex;
	}
	
	

	// *****************************************************************************************
	// Linear time median select algorithm 
	// Select Kth smallest element quickSelect(A, K) 
	// median = quickSelect(numbers, numbers.length/2)
	
	public static double getMedian(int[] numbers) {
		int len = numbers.length;
		if (len % 2 == 1) {
			return numbers[quickSelect(numbers, len / 2)];
		} else {
			double num1 = numbers[quickSelect(numbers, len / 2 - 1)];
			double num2 = numbers[quickSelect(numbers, len / 2)];
			return (num1 + num2) / 2.0;
		}
	}

	private static int quickSelect(int[] numbers, int k) {
		int left = 0;
		int right = numbers.length - 1;	
		while (true) {
			int pivotIndex = partition2(numbers, left, right);	
			if (pivotIndex == k) {
				return pivotIndex;
			} else if (pivotIndex > k) {
				right = pivotIndex - 1;
			} else { // pivotIndex < k
				left = pivotIndex + 1;
			}
		}
	}
	// *****************************************************************************************
	// Two sorted lists of items A and B contain n items each. 
	// Find the median of the two sorted arrays.
	// Define the median to be the nth smallest value overall.
	// Time O(logn) Space?
		public static int getMedianFrom2SortedArr1(int[] A, int lefA, int rigA, int[] B, int lefB, int rigB){
		int n = rigA - lefA + 1;
		if (n == 1) {
			return Math.min(A[lefA], B[lefB]);
		} else  if (n == 2) {
			return Math.max(Math.min(A[lefA], A[rigA]), 
					        Math.min(B[lefB], B[rigB]));
		} 
		// index
		int midA = lefA + n / 2;
		int midB = n % 2 == 1 ? (lefB + n / 2) : (lefB + n / 2 - 1);
		// median of A and B
		int m1 = A[midA];
		int m2 = B[midB];
		if (m1 == m2) {
			return m1;
		} else if (m1 > m2) {
			return getMedianFrom2SortedArr1(A, lefA, lefA + n / 2, B, midB, rigB);
		} else {
			return getMedianFrom2SortedArr1(A, lefA + n / 2, rigA, B, lefB, midB);
		}
	}
	
	// Count while merging two sorted array of size n
	// Time O(n)
	public static int getMedianFrom2SortedArr2(int[] A, int[] B){
		int n = A.length;		
		int indexA = 0;
		int indexB = 0;
		int m1 = 0;
		int m2 = 0;
		
		for (int i = 0; indexA < A.length && indexB < B.length; i++){
			if (i == n - 1){
				m1 = A[indexA] <= B[indexB] ? A[indexA++] : B[indexB++];
				continue;
			}
			if (i == n){
				m2 = A[indexA] <= B[indexB] ? A[indexA++] : B[indexB++];
				return (m1 + m2) / 2;
			}
			if (A[indexA] <= B[indexB]){
				indexA++;
			} else {
				indexB++;
			}
		}
		if (indexB == B.length){
			return (m1 + A[indexA]) / 2;
		} else {
			return (m1 + B[indexB]) / 2;
		}
	}
	
	// Given two sorted arrays A and B of size m and n respectively. 
	// Find the median of the two sorted arrays. 
	// Time O(log(m+n))
	// http://www.cnblogs.com/yuzhangcmu/p/4138184.html 
	public static double getMedianFrom2SortedArr3(int[] A, int[] B){
		int m = A.length;
		int n = B.length;
		int total = m + n;
		if (total % 2 == 1){ // odd
			return findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1); 
		} else { // even
			return (findKth(A, 0, m - 1, B, 0, n - 1, total / 2)  
                    + findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1)) / 2.0;  
		}
	}

	// return kth smallest number of two sorted array A and B of size m and n
	private static int findKth(int[] A, int lefA, int rigA, int[] B, int lefB, int rigB, int k) {
		int sizeA = rigA - lefA + 1;
		int sizeB = rigB - lefB + 1;
		if (sizeA > sizeB){
			return findKth(B, lefB, rigB, A, lefA, rigA, k); 
		}
		if (sizeA == 0){
			return B[k - 1];
		}
		if (k == 1){
			return Math.min(A[lefA], B[lefB]);
		}
		int pa = Math.min(k / 2, sizeA), pb = k - pa; 
		int m1 = A[lefA + pa - 1];
		int m2 = B[lefB + pb - 1];
	    if (m1 < m2){
	        return findKth(A, lefA + pa, rigA, B, lefB, rigB, k - pa);  
	    } else if (m1 > m2){ 
	        return findKth(A, lefA, rigA, B, lefB + pb, rigB, k - pb);  
	    } else { 
	        return m1; 
	    }
	}
}
