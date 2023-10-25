## 개념
- <u>분할 정복 알고리즘</u>의 하나로, 평균적으로 **매우 빠른 수행 속도를 자랑**하는 정렬 방법
    - 문제를 작은 2개의 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 원래의 문제를 해결하는 전략
    - 분할 정복 방법은 대개 순화


## 과정
1. **피벗(Pivot)** 을 하나 선택한다.
2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다.
    
    왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾는다.
    
3. 양방향에서 찾은 두원소를 교환
4. 왼쪽에서 탐색하는 위치와 오른족에서 탐색하는 위치가 엇갈리지 않을때까지 2번으로 돌아가 위 과정 반복
5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가 해당 부분리스트의 길이가 1이 아닐때까지 1번 과정 반복 (Divide : 분할)
6. 인접한 부분리스트끼리 합친다(Conqure : 정복)

<img src="/img/퀵정렬.png" width="300" height="300">
<br/>

### 구현
```java
public class quickSort {
    public static void quickSort(int[] arr){
        sort(arr, 0 , arr.length-1);

        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr, int low, int high){
        if (low >= high) return;

        int mid = partition(arr, low ,high);
        sort(arr, low, mid-1);
        sort(arr, mid, high);
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[(low + high) / 2];

        while (low <= high){
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
            if(low <= high){
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        return low;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        quickSort(new int[]{5, 3, 8, 4, 9, 1, 6, 2, 7});
    }
}

실행 결과
1 2 3 4 5 6 7 8 9 

```