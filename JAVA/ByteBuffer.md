## ByteBuffer
- 바이트 데이터를 저장하고 읽는 저장소
- 배열을 멤버변수로 가지고 있고, 배열에 대한 읽기&쓰기 지원

### 생성

1. allocate
    - 해당 메소드를 통해 생성된 버퍼는 JVM의 힙영역에 버퍼를 할당
    - 일반적으로 자바에서 버퍼를 할당할때 사용하는 메소드
2. allocateDirect
    - JVM의 힙 영역이 아닌 운영체제의 커널 영역에 바이트 버퍼를 생성
3. wrap
    - 입력된 바이트 배열을 사용하여 버퍼를 생성
    - 내부적으로 HeapByteBuffer를 통해 생성하며, 입력에 사용된 바이트 배열이 변경되면 wrap를 사용해서 생성된 바이트 버퍼도 변경

→ get 혹은 put 메소드를 사용하면 position의 값이 같이 공유된다.

<br/>

### 위치 속성 변경 메소드

1. flip()
    - 쓰기 모드를 읽기 모드로 변경
    - 현재 버퍼위치를 0으로 설정하고 limit를 이전 버퍼 위치로 설정
    - 버퍼를 재사용하기 위해 clear()하고 데이터를 버퍼에 쓴 후 flip()으로 재사용 범위를 지정한 후 버퍼에서 데이터 읽음
    
    ```java
    공식문서
    public final Buffer flip(){
    	limit = position;
    	position = 0;
    	mark = -1;
    	return this
    }
    ```
    
2. rewind()
    - 현재 버퍼 위치를 0으로 설정 (position 속성 초기화)
    - mark 값 -1, 읽었던 데이터를 다시 읽을 때 사용
    
    ```java
    공식문서
    public final BUffer rewind(){
    	position = 0;
    	mark = -1;
    	return this
    }
    ```
    
3. mark()
    - 현재 position의 위치에 mark를 놓는다.
4. reset()
    - position을 mark 위치로 가져다 놓는다.
5. clear()
    - limit는 capacity로 position은 0으로 mark는 사라짐
6. compact()
    - position ~ limit 데이터가 0으로 복사되고 position은 복사된 데이터 다음으로 이동, 그 외 데이터는 유지

<br/>

### 데이터 쓰기

1. compact()
    - 남아 있는 데이터를 첫부분으로 복사
2. clear()
    - 데이터를 지워버리는 것
3. remaining()
    - 쓰기 모드 일때 얼마나 데이터를 더 쓸 수 있는지, 아니면 읽기 모드 일때 데이터를 얼마나 더 읽을 수 있는지 확인

<br/>

### ByteBuffer  ⇔ String

- 문자열을 파일이나 네트워크로 전송하려면 특정 문자셋(UTF-9, EUC-KR)으로 인코딩하여 ByteBuffer로 변환해야함 