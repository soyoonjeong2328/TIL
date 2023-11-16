## 개념
<img src="/img/queue.png" width="400" height="400" >

- FIFO(First In First Out) 형태로 먼저 들어온 데이터가 가장 먼저 나가는 구조
- 그래프의 넓이 우선 탐색(BFS)에서 사용
- 컴퓨터 버퍼에서 주로 사용
- Enqueue : 큐 맨뒤에 데이터 추가
- Dequeue : 큐 맨앞 데이터 추가

## 종류
1. 선형 큐(Linear Queue)
<p align="center"> <img src="/img/선형큐.png" width="400" height="400"> </p>

2. 원형 큐(Circular Queue)
<p align="center"> <img src="/img/원형큐.png" width="400" height="400"> </p>


- 원형 큐에도 **일차원 배열**을 사용
- 별도의 isEmpty, isFull 함수를 구현하지 않고, 큐에 삽입 및 삭제시 큐가 꽉찼는지, 비었는지 확인할 수 있도록 하였음
- enQueue 연산시 rear+1하여 데이터를 새로 넣는다.
    - rear +1이 front와 같으면 꽉차있다고 판단
- 데이터 추가시 rear가 1칸 움직인다. 단 (rear+1) % (일차원배열의 크기)만큼 움직인다.
- 데이터 삭제시 front가 움직인다. front도 (rear+1) % (일차원 배열의 크기)만큼 움직인다.

3. 링크드 큐(연결 리스트로 구현한 큐)


## 사용법
```java
import java.util.LinkedList;
import java.util.Queue;

// 큐는 LinkedList 활용 
Queue<Integer> queue = new LinkedList<>();

queue.add(); // 값 추가
queue.offer(); // 값 추가 

queue.poll(); // 첫번째 값을 반환하고 비어있다면 null
queue.remove(); // 첫번째 값 제거
queue.clear(); // 초기화 
```


## 시간 복잡도

| 연산 | 복잡도 |
| ------ | ------- |
| insert | O(1) |
| delete | O(1) |
| select | O(n) |


## 자바 큐 종류
- 멀티 스레드 환경에서 Queue는 생산 및 소비의 구조에 필수적인 자료구조
1. ArrayBlockingQueue
    - 저장할 데이터의 크기가 정해져 있는 FIFO 기반의 링크 노드를 사용하는 블로킹 큐
    - 꽉 찼을때 추가 block, 비었을때 추출 block
    - 선택적으로 공평성 정책을 두어 block한 thread들의 순차적 대기열 생성


2. LinkedBlockingQueue
    - 선택적으로 Bound가 가능한 Linked list로 구현한 큐
    - capacity를 초기에 정해주지 않는 경우 Integer.MAX_VALUE로 자동 설정
    - 용량을 초과하지 않는 한에서 node는 동적으로 삽입시 생성되며 초과시 block
    - Linked Queue는 일반적으로 배열 기반 큐 보다 동시성 app에서 높은 Throughput을 가짐

3. PriorityBlockingQueue
    - 저장되는 데이터의 크기가 정해져 있지 않고, 객체의 생성순서에 따라서 순서가 저장되는 블로킹
    - 입력 무제한(unbounded)으로 기본 설꼐가 되었기 때문에 추가 작업 수행 중  fail이 나면 이것은 자원이 고갈 났다는 뜻
    - null element 및 non-comparable object를 수용하지 않으며 natural ordering을 지원한다(ClassCastException발생)

4. SynchronousQueue
    - Queue 내부로의 insert 작업이 다른 스레드의 remove 작업과 반드시 동시에 일어나야 한다.
        
        (서로 대칭 되는 작업이 없을 경우 생길때까지 wait)
        
    - 이 Queue는 내부 용량을 지니지 않는다
        - null값도 수용x
    - remove될때만 새로운 element가 insert되므로 추출(Peek함수)을 할 수 없다.
        
        반대로, 다른 스레드가 remove를 시도하지 않는 이상 삽입을 할 수도 없다.
        
    - Queue의 head는 최초 삽입 시도를 한 Thread의 삽입element가 된다.
    - poll()을 수행하였을시 Queue에 삽입 시도를 한 thread가 없다면 null반환