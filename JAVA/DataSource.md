## DataSource
- javax.sql.DataSource라는 인터페이스는 Connection Pool을 관리하는 목적으로 사용되는 객체
- Application에서는 이 DataSource 인터페이스를 통해 Connection을 얻어오고 반납하는 등의 작업을 구현해야함
    
    👉 Connection Pool을 어플리케이션단에서 어떻게 관리할지를 구현하는 인터페이스
    
- 기존의 DriverManager를 이용한 방식은 내부적으로 static한 필드 사용 → 스레드 환경에서 바람직하지 않음 → 되도록 DataSource사용
- DriverManager를 통해 DB 커넥션을 얻는 것보다 더 좋은 기법을 제공

<br/>

- 장점
    - DataSource는 서버에서 관리하기 때문에 DB나 JDBC 드라이버 변경이 수월
    - Connection, Statement 객체를 pooling할 수 있으며 분산 트랜잭션을 다룰 수 있음
        - DataSource는 자체적으로 Connection Pool 기능을 구현