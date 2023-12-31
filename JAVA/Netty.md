## Netty

- 네이티브 시스템 소켓 라이브러리가 제공하는 **블로킹 함수만 제공**
    - 다수의 클라이언트를 관리하려면 클라이언트 소켓마다 새로운 스레드를 할당해야함
    - 여러 스레드가 입출력 데이터를 무한정 대기하는 상태가 유지될 수 있고, 이는 곧 리소스에 대한 낭비로 이어질 수 있음.
- 네이티브 소켓 라이브러리에는 오래전부터 네트워크 리소스 사용률을 세부적으로 제어할 수 있는 논블로킹(non-blocking)호출이 포함되어 있음 

1. Bootstrap
    - Netty의 스레드를 생성하고, 소켓을 오픈하는 등 Netty를 구동하기 위한 부트스트래핑을 위해 사용하는 클래스
2. EventLoopGroup
    - EventLoop들의 그룹.
    - 여러개의 EventLoop은 하나의 그룹으로 모아져, 같은 그룹에 속한 EventLoop들은 스레드와 같은 몇몇 리소스들을 공유
3. EventLoop
    - 새로운 이벤트를 반복적으로 확인하는 루프
4. SocketChannel
    - SocketChannel은 TCP 연결을 대표.
    - 네트워크 프로그램에서 Server나 Client가 Netty를 사용한다면, 머신 사이에서 데이터를 전달하는 과정은 SocketChannel을 통해 이뤄진다.