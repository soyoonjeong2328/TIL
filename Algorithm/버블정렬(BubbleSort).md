## 개념
- 서로 **인접한** 두 원소의 대소를 비교하여, 조건의 맞지 않다면 자리를 교환하며 정렬하는 알고리즘 

<br/>

## 정렬 과정
1. 앞에서부터 인접한 데이터 값을 비교한다.
2. 현재 데이터와 다음 데이터를 비교한다.
3. 만약 다음 데이터가 더 작하면 위치를 바꾸고 아니라면 그대로 둔다.
4. 다음 데이터로 이동하여 값을 비교한다.

    ![](/img/버블정렬.png)

    - 회전 : 배열 크기 -1번 수행
    - 비교 연산 : 배열 크기 - 라운드 횟수

<br/>

## 구현
```java
public class bubbleSort {
    static void bubbleSort(int[] arr){
        for(int i=0;i <arr.length; i++){
            for(int j=1; j<arr.length - i ; j++){
                if(arr[j-1] > arr[j]){
                    // swap
                    swap(arr, j);
                }
            }

            System.out.print((i+1)+"회차 : ");
            for(int value : arr){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static void swap(int[] arr, int j){
        int temp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j] = temp;
        System.out.println("swap : " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{5,4,1,3,2});
    }
}

// 결과 
swap : [4, 5, 1, 3, 2]
swap : [4, 1, 5, 3, 2]
swap : [4, 1, 3, 5, 2]
swap : [4, 1, 3, 2, 5]
1회차 : 4 1 3 2 5 
swap : [1, 4, 3, 2, 5]
swap : [1, 3, 4, 2, 5]
swap : [1, 3, 2, 4, 5]
2회차 : 1 3 2 4 5 
swap : [1, 2, 3, 4, 5]
3회차 : 1 2 3 4 5 
4회차 : 1 2 3 4 5 
5회차 : 1 2 3 4 5 
```