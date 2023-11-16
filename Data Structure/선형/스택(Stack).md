## 개념
<img src="/img/stack.png" width="400" height="400" >

- 먼저 들어간 자료가 나중에 나오는 후입선출, LIFO(Last In Firt Out) 구조
- **선형구조**를 가짐
    - 자료 간의 관계가 1대 1의 관계를 가짐
- 시스템 해킹에서 버퍼오버플로우 취약점을 이용한 공격할때 스택 메모리 영역에서 함
- 그래프의 `깊이 우선 탐색 (DFS)`에서 사용
- `재귀적(Recurision) 함수 호출`시 사용


<br/>

## stack 클래스 메서드
- push : 스택에서 가장 위에  element 추가
- pop : 스택에 가장 위에 있는 element 제거
- peek : 스택에 가장 위 element 반환
- clear : 전체 값 제거

📍 pop()와 peek() 차이
- pop()은 스택의 맨 위에서 개체를 꺼낸 후 제거, peek()는 제거하지 않고 개체 값 반환

<br/>

## 구현
- 스택은 보통 **연결리스트(LinkedList)로 구현**된다.
- 문제의 종류에 따라 배열보다 스택에 데이터를 저장하는 것이 더 좋은 방법
    - 배열과 달리 스택은 상수 시간에 i번재 항목에 접근 불가
    - 스택에서 데이터를 추가하거나 상제하는 연산은 상수 시간에 가능
    - 배열처럼 원소들을 하나씩 옆으로 밀어줄 필요 x
- 배열을 이용한 stack 구현
    - top 변수는 배열의 가장 마지막으로 저장된 요소의 index 저장

<br/>

## 사용법
```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(1); 
stack.pop();
stack.clear(); 
```


