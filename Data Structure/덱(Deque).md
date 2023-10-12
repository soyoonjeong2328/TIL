## 개념
<center> 

![덱](/img/deque.jpg) 
</center>

- 큐의 양쪽에서 데이터를 넣고 뺄 수 있는 형태의 자료구조
- Deque의 앞족으로 데이터를 넣고 뒤쪽에서 빼면 Queue처럼 사용할 수 있고, 앞쪽에서 넣고 다시 앞쪽에서 빼면 Stack처럼 사용 가능 


## 사용법
### 생성
- LinkedBlockingQueue 
    - FIFO 순서를 가지며, Linked nodes을 기반
    - Queue의 head는 오래된 데이터, Queue에서 꺼낼때 head값을 가져온다.
    - Queue의 tail은 최신 데이터, Queue에 넣을때 tail에 붙인다.
    - Capacity를 지정할 수 있고, 하지 않을 경우 Integer.MAX_VALUE

```java
Deque<String> deque1 = new ArrayDeque<>(); // 가장 기본적
Deque<String> strArrBlockQueue = new ArrayBlockingQueue<>();
Deque<String> deque2 = new LinkedBlockingDeque<>();
Deque<String> deque3 = new ConcurrentLinkedDeque<>();
Deque<String> linkedList = new LinkedList<>();
```

<br/>

### 추가 및 제거
1. 추가 
<center>

![추가](/img/deque%20add.png)
</center>

- 앞부분 추가 : addFirst() / offerFirst()
- 뒷부분 추가 : addLast() / add() / offerLast() / offer()

    > add와 offer의 차이점? <br/>
    - add : illegalStateException발생
    - offer : 큐가 가득차서 더이상 추가할 수 없는 경우 false 반환하고, 요소가 추가되면 true를 반환하며 특정 예외 throw 하지 않음 

<br/>

2. 삭제
<center>

![](/img/deque%20remove.png)
</center>

- 앞 부분 삭제 : remove() / removeFirst() / pollFirst() / poll()
- 뒷 부분 삭제 : removeLast() / pollLast()

    > remove 와 poll의 차이점?
    - remove : 큐가 비었을때 삭제시 예외 발생
    - poll : 큐가 비어있을때 삭제시 null 반환

<br/>

3. 값 확인
<center>

![](/img/deque%20check.png)
</center>

- 앞 부분 읽기 : getFirst() / peekFirst() / peek()
- 뒷 부분 읽기 : getLast() / peekLast()
    
    > get과 peek 차이점? 
    - get()  : 해당 값 return 하고 실패 시 Exception 발생
    - peek() : 기본적으로 해당 값을 반환한다는 점에서 get과 비슷하지만, 실패시 null을 return

<br/>

## 시간 복잡도

| 삽입/ 삭제 | 탐색 | 
| --------- | ------- |
| O(1) | O(1) |

<br/>

## 순회 구현
```java
Deque<String> deque1 = new ArrayDeque<>();
Deque<String> deque2 = new LinkedBlockingDeque<>();
Deque<String> deque3 = new ConcurrentLinkedDeque<>();
Deque<String> linkedList = new LinkedList<>();

// for 문을 이용한 순회
for (String elem : deque1) {
  System.out.println(elem);
}

// Iterator를 이용한 순회
Iterator<String> iterator = deque1.iterator();
while (iterator.hasNext()) {
  String elem = iterator.next();
  System.out.println(elem);
}

// 역순순회 
Iterator<String> reverseIterator = deque1.descendingIterator();
while (reverseIterator.hasNext()) {
  String elem = reverseIterator.next();
  System.out.println(elem);
}
```
