## 개념
- 현재 비교하고자 하는 target 과 그 이전의 원소들과 비교하며 자리를 교환하는 정렬 방법

<br/>

## 특징
1. 안정적인 정렬(Stable Sort) : 같은 값의 원소들은 정렬 과정에서 상대적인 순서가 변경되지 않습니다.
2. 제자리 정렬(In-place Sort) : 추가적인 메모리를 사용하지 않고 입력 배열 안에서 정렬이 이루어진다.
3. 시간 복잡도
    
    
    | 평균 | O(n^2) |
    | --- | --- |
    | 최악 | O(n^2) |
    | 최선 | O(n) |
4. 적응 정렬(Adaptive Sort) : 이미 정렬된 부분에 대해서는 빠르게 수행할 수 있는 특징이 있다.
5. 교환 비용 
    1. 삽입 정렬은 원소들을 올바른 위치에 삽입하는 과정에서 교환을 수행하게 된다.
    
    만약 교환비용이 높은 상황에서 정렬이 필요하다면 다른 정렬 알고리즘을 사용하는 것을 고려해야 한다.

<br/>

## 정렬 방법
- 앞에서부터 해당 원소가 위치할 곳을 탐색하고 해당 위치에 삽입하는 것
1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다.(첫번째 타겟은 두번째 원소부터 시작)
2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환
3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복 

![Untitled](/img/삽입정렬.png)

<br/>

## 구현
1. 삽입 정렬 구현
    ```java
    public class InsertionSort {
        public static void insertionSort(int[] a){
            insertionSort(a, a.length);
        }

        private static void insertionSort(int[] a, int size){

            for(int i=1; i<size; i++){
                int target = a[i];

                int j = i-1;

                while (j >=0 && target < a[j]){
                    a[j+1] = a[j];
                    j--;
                }

                a[j+1] = target;


                for (int value : a) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }

        }

        public static void main(String[] args) {
            int[] arr = {3,9,2,7,5,4,8,0};
            insertionSort(arr);
        }
    }

    // 결과
    3 9 2 7 5 4 8 0 
    2 3 9 7 5 4 8 0 
    2 3 7 9 5 4 8 0 
    2 3 5 7 9 4 8 0 
    2 3 4 5 7 9 8 0 
    2 3 4 5 7 8 9 0 
    0 2 3 4 5 7 8 9
    ```

<br/>

2. 이진 삽입 정렬(Binary Insertion Sort)
    - 정렬되어야 할 배열의 각 요소를 적절한 위치에 삽입하는  알고리즘
    - **이진 검색을 사용**하여 적절한 삽입 위치를 빠르게 찾아내는 것
    ```java
    public class binaryInsertionSort {
        public static void sort(int[] arr){
            for(int i=1; i<arr.length; i++){
                int key = arr[i];
                int index = binarySearch(arr, key, 0, i-1);

                // 원소를 오른쪽으로 이동하여 key 값을 적절한 위치에 삽입할 공간을 만듦
                System.arraycopy(arr, index, arr, index+1, i-index);

                // key 값을 적절한 위치에 삽입
                arr[index] = key;


                for(int value : arr){
                    System.out.print( value + " ");
                }
                System.out.println();
            }
        }

        private static int binarySearch(int[] arr, int key, int low, int high){
            while (low <= high){
                int mid = (low + high)/2;
                if(arr[mid] < key){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }
            return low;
        }

        public static void main(String[] args) {
            int[] arr = {3, 5, 8, 6, 0, 1, 7, 4};
            sort(arr);
        }
    }

    // 결과
    3 5 8 6 0 1 7 4 
    3 5 8 6 0 1 7 4 
    3 5 6 8 0 1 7 4 
    0 3 5 6 8 1 7 4 
    0 1 3 5 6 8 7 4 
    0 1 3 5 6 7 8 4 
    0 1 3 4 5 6 7 8
    ```