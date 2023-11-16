## 개념
- 우선순위를 가진 데이터들을 저장하는 큐를 의미
- 큐에 추가된 순서와 상관없이 먼저 생성된 객체가 먼저 나오도록 되어 있는 큐(FIFO 구조)
- 이진 트리 구조로 구현 되어 있음

## 특징
1. 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조
2. 내부 요소는 힙으로 구성되어 있어 **이진트리 구조**로 이루어져 있다.
3. 내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)
4. 우선순위를 중요시해야 하는 상황엥서 주로 쓰인다.

## 선언
```java
// 낮은 숫자가 우선 순위인 int형 우선순위 큐 선언
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// 높은 숫자가 우선 순위인 int형 우선순위 큐 선언
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```


## 메서드
| 메서드 | 설명 | 
| :---: | :---: |
| boolean add(E e) | 큐에 요소를 추가하고 성공적으로 추가되면 true를 반환 | 
|void clear() | 큐의 모든 요소를 제거 |
| Comparator<? super E> comparator() | 큐에서 사용되는 컴패레이터를 반환. 컴패레이터가 없으면 null을 반환 | 
| boolean contains(Object o) | 큐에 지정된 요소가 포함되어 있는지 확인 | 
| Iterator<E> iterator() | 큐의 요소를 반복하는데 사용할 수 있는 이터레이터를 반환 | 
| boolean offer(E e) | 큐에 지정된 요소를 추가하고, 추가에 성공하면 true를 반환 | 
| E peek() | 큐에서 가장 높은 우선순위의 요소를 반환하거나 큐가 비어있으면 null을 반환 | 
| E poll() | 큐에서 가장 높은 우선순위의 요소를 제거하고 반환하거나 큐가 비어있으면 null을 반환 | 
| boolean remove(Object o) | 큐에서 지정된 요소를 제거하고 성공적으로 제거되면 true를 반환 |
| int size() | 큐에 있는 요소의 수를 반환 |
<br/>

## 구현
```java
import java.util.Comparator;
import java.util.PriorityQueue;
 
class Student {
    int mathScore; // 수학점수
    int engScore;  // 영어점수
 
    public Student(int mathScore, int engScore){
        this.mathScore = mathScore;
        this.engScore = engScore;
    }
}
// 클래스 객체의 우선순위를 위한 클래스
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.mathScore == o2.mathScore) {
            return o2.engScore - o1.engScore;
        } else {
            return o1.mathScore - o2.mathScore;
        }
    }
}
 
public class Example {
 
    public static void main(String[] args) {
 
        // 클래스 객체에 대한 우선순위 기준 제공
        PriorityQueue<Student> pQ = new PriorityQueue<>(1, new StudentComparator());
 
        pQ.offer(new Student(70, 50));  // 우선순위 큐에 클래스 객체를 추가
        pQ.offer(new Student(60, 50));  // 우선순위 큐에 클래스 객체를 추가
        pQ.offer(new Student(70, 40));  // 우선순위 큐에 클래스 객체를 추가
 
        while (!pQ.isEmpty()) {
            Student s = pQ.poll();
            System.out.printf("Student\'s MathScore and engScore: %d, %d \n", s.mathScore, s.engScore);
        }
    }
}
```