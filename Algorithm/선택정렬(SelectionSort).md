## 개념
- 버블 정렬과 유사한 알고리즘으로, 해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘
- **제자리 정렬(in-place sorting)** 알고리즘의 하나
    - 입력 배열(정렬되지 않은 값들) 이외에 다른 추가 메모리를 요구하지 않는 정렬 방법


## 정렬과정
1. 주어진 배열 중 최소 값을 찾는다.
2. 그 값을 맨앞에 위치한 값과 교체(swap)
3. 가장 앞에 있는 데이터의 위치를 변경해 (index++) 남은 정렬 부분의 범위를 축소
4. 전체 데이터 크기만큼 index가 커질때까지, 즉 남은 정렬 부분이 없을때까지 반복
![](/img/선택정렬.png)

<br/>

## 구현
```java
public class selectionSort {
    static void selectionSort(int[] arr){
        // 1. 위치 선택
        for(int i=0; i<arr.length-1; i++){
            int indexMin = i;
            // 2. i+1번째 원소부터 선택한 위치의 값과 비교 시작
            for(int j=i+1; j<arr.length; j++){
                // 3. 오름 차순이므로 현재 선택한 자리에 있는 값보다 순회하고 있는 값이 작으면 위치 갱신
                if(arr[j] < arr[indexMin]){
                    indexMin = j;
                }
            }

            // swap
            swap(arr, indexMin, i);

            for(int value : arr){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static void swap(int[] arr, int indexMin, int i){
        int temp = arr[indexMin];
        arr[indexMin] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        selectionSort(new int[]{22, 50 ,17 , 25, 18 , 44, 32, 39 , 29});
    }
}

// 결과
1회차 : 17 50 22 25 18 44 32 39 29 
2회차 : 17 18 22 25 50 44 32 39 29 
3회차 : 17 18 22 25 50 44 32 39 29 
4회차 : 17 18 22 25 50 44 32 39 29 
5회차 : 17 18 22 25 29 44 32 39 50 
6회차 : 17 18 22 25 29 32 44 39 50 
7회차 : 17 18 22 25 29 32 39 44 50 
8회차 : 17 18 22 25 29 32 39 44 50
```