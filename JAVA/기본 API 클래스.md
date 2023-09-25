# 기본 API 클래스
## API란?
- 라이브러리(library)라고 부르기도 하는데, 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음

#### API 도큐먼트
- 쉽게 API를 찾아 이용할 수 있도록 문서화한 것
- HTML 페이지로 작성되어 있기 때문에 웹 브라우저를 열고 오라클에서 제공하는 다음 URL을 방문하면 불 수 있다.  
<https://docs.oracle.com/javase/8/docs/api/index.html>
<br/><br/>

## java.lang과 java.util 패키지
1. java.lang 패키지
    - <b>자바 프로그램의 기본적인 클래스를 담고 있는 패키지</b>이다. 그렇기 때문에 java.lang 패키지에 있는 클래스와 인터페이스는 import 없이 사용할 수 있다.

    | 클래스 | 용도 |
    |:------:| :------:|
    | Object | 자바 클래스의 <b>최상위</b> 클래스로 사용|
    | System | 표준 입력 장치(키보드)로부터 데이터를 입력받을 때 사용<br/> 표준 출력장치(모니터)로 출력하기 위해 사용 <br/> 자바 가상 기계를 종료시킬때 사용 <br/> 쓰레기 수집기를 실행 요청할 때 사용 |
    | Class | 클래스를 메모리로 로딩할 때 사용 |
    | String | 문자열을 저장하고 여러 가지 정보를 얻을 때 사용 |
    | StringBuffer, StringBuilder  | 문자열을 저장하고 내부 문자열을 조작할 때 사용 |
    |  Math | 수학 함수를 이용할 때 사용 |
    | Wrapper | 기본 타입의 데이터를 갖는 객체를 만들때 사용 <br/> 문자열을 기본 타입으로 변환할 때 사용 <br/> 입력값 검사에 사용 |

<br/>

2. java.util 패키지
    - 자바 프로그램 개발에 조미료 같은 역할을 하는 클래스 

    | 클래스 | 용도 |
    | :---: | :-----:|
    | Arrays | 배열을 조작(비교, 복사, 정렬, 찾기) 할때 사용 |
    | Calendar | 운영체제의 날짜와 시간을 얻을 때 사용 |
    | Date | 날짜와 시간 정보를 저장하는 클래스 | 
    | Objects | 객체 비교, 널(null) 여부 등을 조사할때 사용 | 
    | StringTokenizer | 특정 문자로 구분된 문자열을 뽑아낼때 사용 |
    | Random | 난수를 얻을 때 사용 |

<br/>

## Object 클래스 ##
- 자바의 모든 클래스는 Object 클래스의 자식이거나 자손 클래스다.
- 자바의 최상위 부모 클래스에 해당

1.  객체 비교 (equals())
    - equals() 메소드의 매개 타입은 Object인데, 이것은 모든 객체가 매개값으로 대입될 수 있다  
        why? Object가 최상위 타입이므로 모든 객체는 Object 타입으로 자동 타입 변환 
    - Object클래스의 equals() 메소드는 비교 연산자인 ==과 동일한 결과를 리턴한다. 두 객체가 동일한 객체라면 true를 리턴하고 그렇지 않으면 false를 리턴
    ```java
    Object obj1 = new Object();
    Object obj2 = new Object();

    boolean result = obj1.equals(obj2); 

    boolean result = (obj1 == obj2) // 결과 동일 
    ```
    - equals() 메소드를 재정의할 때에는 매개값(비교 객체)이 기준 객체와 동일한 타입의 객체인지 먼저 확인해야한다.  
    Object 타입의 매개변수는 모든 객체가 매개값으로 제공될 수 있기 때문에 instanceof 연산자로 기준 객체와 동일한 타입인지 제일 먼저 확인해야한다.  
    만약 비교 객체가 다른 타입이라면 equals() 메소드는 false를 리턴해야 한다. 비교 객체가 동일한 타입이라면 기준 객체 타입으로 강제 타입 변환해서 필드값이 동일한지 검사하면 된다. 
    ```java
    public class Member{
        public String id;
        public Member(String id){
            this.id = id;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Member){ // 매개값이 Member 타입인지 확인
                Member member = (Member) obj; // Member 타입으로 강제 타입 변환하고 id 필드 값이 동일한지 검사한 후, 동일하다면 true 리턴
                if(id.equals(member.id)){
                    return true;
                }
            }
            return false; // 매개값이 Member 타입이 아니거나 id 필드 값이 다른 경우 false 리턴 
        }
    }
    ```
<br/>

2. 객체 해시코드(hashCode())
    - 객체를 식별할 하나의 정수값
    - Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해서 해시코드를 만들어 리턴하기 때문에 객체마다 다른 값을 가지고 있다. 
     ```java
    public class Member{
        public String id;
        public Member(String id){
            this.id = id;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Member){ // 매개값이 Member 타입인지 확인
                Member member = (Member) obj; // Member 타입으로 강제 타입 변환하고 id 필드 값이 동일한지 검사한 후, 동일하다면 true 리턴
                if(id.equals(member.id)){
                    return true;
                }
            }
            return false; // 매개값이 Member 타입이 아니거나 id 필드 값이 다른 경우 false 리턴 
        }

        @Override
        public int hashCode(){
            return id.hashCode(); // id가 동일한 물자일 경우 같은 해시코드 리턴
        }
    }
    ```
    - 객체의 동등 비교를 위해서 Object의 equals() 메소드만 재정의하지 말고 hashCode() 메소드도 재정의해서 논리적 동등 객체일 경우 동일한 해시코드가 리턴되도록 해야 한다. 
<br/>

3. 객체 문자 정보(toString())
    - 객체를 문자열로 표현한 값
    - Object 하위 클래스는 toString() 메소드를 재정의(오버라이딩)하여 간결하고 유익한 정보를 리턴하도록 되어 있다. 
    ```java
    public class SmartPhone{
        private String company;
        private String os;

        public SmartPhone(String company, String os){
            this.compony = company;
            this.os = os;
        }

        @Override
        public String toString(){
            return company + ", " + os; // toString() 재정의 
        }
    }
    ```
    ```java
    public class SmartPhoneExam{
        public static void main(Stirng[] args){
            SmartPhone phone = new SmartPhone("구글" , "안드로이드");

            String strObj = phone.toString();
            System.out.println(strObj);

            System.out.println(phone); // phone.toString()을 자동 호출해서 리턴값을 얻은 후 출력
        }
    }
    [출력]
    구글, 안드로이드
    구글, 안드로이드
    ```
<br/>

4. 객체 복제(clone()) 
- 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것
-  객체를 복제하는 이유 ? 
    - 원본 객체를 안전하게 보호하기 위해서
        - 신뢰하지 않는 영역으로 원본 객체를 넘겨 작업할 경우 원본 객체의 데이터가 훼손될 수 있기 때문에 복제된 객체를 만들어 신뢰하지 않는 영역으로 넘기는 것이 좋다. 복제된 객체의 데이터가 훼손되더라도 원본 객체는 아무런 영향을 받지 않기 때문에 안전하게 데이터를 보호할 수 있게 된다.  <br/><br/>
- 4.1) 얕은 복제(thin clone)
    - 단순히 필드값을 복사해서 객체를 복제하는 것 
    - 필드가 기본타입일 경우 값의 복사가 일어나고, 필드가 참조타입일 경우 객체의 번지가 복사된다. 
    - Object클래스의 clone() 메소드를 사용하되, 리턴타입이 Object이므로 적절한 타입으로 형변환하여 사용 

- 4.2) 깊은 복제(deep clone)
    - 참조하고 있는 객체도 복제하는것
    - Object의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 작성해야 한다. 
<br/><br/>

5. 객체 소멸자(finalize())
    - 기본적으로 실행 내용이 없으며, 만약 객체가 소멸되기 전에 마지막으로 사용했던 자원(데이터 연결, 파일 등)을 닫고 싶거나, 중요한 데이터를 저장하고 싶다면 Object의 finalize()를 재정의 가능 

<br/>

## Objects 클래스 ##
- 객체 비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 Object의 유틸리티 클래스. 

1. 객체 비교 (compare(T a, T b, Comparator<T>c))
    - 두 객체의 비교자(COmparator)로 비교해서 int 값 리턴 
    ```java
    class StudentComparator implements Comparator<Student>{
        @Override
        public int Compare(Student a, Student b){
            if(a.sno < b.sno) return -1;
            else if (a.sno == b.sno) return 0;
            else return 1; 
        }
    }
    ```
<br/>

2. 동등 비교 (equals()와 deepEquals())
    - equals() :  a와 b 모두 null일 경우 true를 리턴 
    - deepEquals() : a 와 b가 서로 다른 배열일 경우, 항목 값이 모두 같으면 true 리턴. 

3. 해시코드 생성(hash(), hashCode())
    - hash() 
        - 매개값으로 주어진 값들을 이용해서 해시 코드를 생성하는 역할
        - 주어진 매개값들로 배열을 생성하고 Arrays.hashCode(Object[])를 호출해서 해시코드를 얻고 이 값을 리턴.
        - 클래스가 hashCode()를 재정의할때 리턴값을 생성하기 위해 사용하면 좋다.
    - hashCode()
        - 객체의 hashCode를 리턴
        - 일반적으로 각 객체의 주소값을 변환하여 생성한 객체의 고유한 정수 값

4. 널 여부 조사(isNull(), nonNull(), requireNonNull())
    - isNull(Object obj)
        - 매개값이 Null일 경우 true 리턴
    - nonNUll(Object obj)
        - 매개값이 not null일 경우 true 리턴
    - requireNonNUll()
        - 오버로딩 첫번째 매개값이 not null이면 첫번째 매개값을 리턴하고, null이면 모두 NullPointerException을 발생시키고, 두번째 매개값은 NullPointerException의 예외 메시지를 제공

5. 객체 문자 정보(toString())
    - 첫번째 매개값이 not null이면 toString()으로 얻은 값을 리턴하고, nulll이면 "null" 또는 두번째 매개값인 nullDefault를 리턴.
    ```java
    public class ToStringExam{
        public static void main(String[] args){
            String str1 = "김사과";
            String str2 = null;

            System.out.println(Objects.toString(str1));
            System.out.println(Objects.toString(str2));
            System.out.println(Objects.toString(str2, "이름이 없습니다."));
        }
    }
    [결과]
    김사과
    null
    이름이 없습니다.
    ```
<br/><br/>

## System 클래스 
- 모든 필드와 메소드는 정적(static) 필드와 정적(static) 메소드로 구성되어 있다.
1. 프로그램 종료(exit())
    - 현재 실행하고 있는 프로세스를 강제 종료 시키는 역할
    - int 매개값을 지정하도록 되어 있는데, 이 값을 종료 상태값이라고 한다. 일반적으로 정상 종료일 경우 0으로 지정하고 비정상 종료일 경우 0 이외의 다른 값을 준다. 
<br/><br/>

2. 쓰레기 수집기 실행(gc())
    - System.gc() 메소드가 호출되면 쓰레기 수집기가 바로 실행되는 것은 아니고, JVM은 빠른 시간 내에 실행시키기 위해 노력한다.

<br/><br/>

3. 현재 시각 읽기 (currentTimeMillis(), nanoTime())
    - currentTimeMillis() 메소드와 nanoTime() 메소드는 컴퓨터의 시계로부터 현재 시간을 읽어서 밀리세컨드(1/1000초) 단위와 나노세컨드 단위의 long 값을 리턴.
    ```java
    public class SystemTimeExam{
        public static void main(String[] args){
            logn time1 = System.nanoTime();

            int sum = 0;
            for(int i=1; i <= 1000000; i++){
                sum += i;
            }
        }

        long time2 = System.nanoTime();

        System.out.println("1~1000000까지의 합 : " + sum);
        System.out.println("계산에 " + (time2-time1) + "나노초가 소요되었습니다.");

    }
    [결과]
    1~1000000까지의 합 : 1784293664
    계산에 1589545 나노초가 소요되었습니다.
    ```
<br/>

## Class 클래스
- 클래스와 인터페이스의 메타 데이터를 java.lang 패키지에 소속된 Class 클래스로 관리한다.  
메타 데이터란? 클래스의 이름, 생성자 정보, 필드 정보, 메소드 정보를 말한다.

1. Class 객체 얻기(getClass(), forName())
    - 해당 클래스로 객체를 생성했을 때만 사용할 수 있는데, 객체를 생성하기 전에 직접 Class 객체를 얻을 수도 있다.  
    Class는 생성자를 감추고 있기 때문에 new 연산자로 객체를 만들 수 없고, 정적 메소드인 forName()을 이용해야 한다.
    - forName() : 클래스 전체 이름(패키지가 포함된 이름)을 매개값으로 받고 class 객체를 리턴

2. <span style="color:red"><b>리플렉션 </b></span>
    - 구체적인 클래스 타입을 알지 못하여 그 클래스의 메소드와 타입 그리고 변수들을 접근할 수 있도록 해주는 API
    - 컴파일 시간(Compile Time)이 아닌 실행 시간(Run Time)에 동적으로 특정 클래스의 정보를 추출해 낼 수 있는 프로그래밍 기법 

    ### 사용방법 ###
    ```java
    Class c = Class.forName("클래스 이름");

    // 메소드
    Method[] m = c.getMethods();

    // 필드
    Field[] f= c.getFields();

    // 구조체
    Constructor[] cs = c.getConstructors();
    Class[] inter = c.getInterfaces();
    Class superClass = c.getSuperclass();
    ```
    - 자바 클래스 파일은 프로그램 생성시 힙영역에 저장된다. 그래서 클래스 이름만 알고 있다면 언제든 이 영역에 들어가서 클래스 정보를 가져올 수 있다.

3. 동적 객체 생성(newInstance())
    - 기본 생성자를 호출해서 객체를 생성하기 때문에 반드시 클래스에 기본 생성자가 존재해야 한다.  
    만약에 매개 변수가 있는 생성자를 호출하고 싶다면 리플렉션으로 Constructor 객체를 얻어 newInstance() 메소드를 호출하면 된다.
<br/><br/>

## String 클래스
1. 문자 추출(charAt())
    - 매개값으로 주어진 인덱스의 문자를 리턴  
    (인덱스는 0부터 문자열길이 -1)
    ```java
    public class Exam{
        public static void main(String[] args){
            String ssn = "010624-1230123";
            char sex = ssn.charAt(7);

            switch(sex){
                case '1':
                case '3':
                    System.out.println("남자");
                    break;
                case '2':
                case '4':
                    System.out.println("여자");
                    break;
            }
        }
    }

    [결과]
    남자
    ```
    <br/>

2. 문자열 비교(equals())
    - String 객체의 문자열만 비교하고 싶다면 == 연산자 대신 equals() 메소드 사용
    ```java
    public class Exam{
        public static void main(String[] args){
            String strVar1 = new String("김사과");
            String strVar2 = "김사과";

            if(strVar1 == StrVar2){
                System.out.println("같은 String 객체 참조");
            }else{
                System.out.println("다른 String 객체 참조");
            }

            if(strVar1.equals(strVar2)){
                System.out.println("같은 문자열 가짐");
            }else{
                System.out.println("다른 문자열 가짐");
            }
        }
    }

    [결과]
    다른 String 객체 잠조
    같은 문자열 가짐
    ```
<br/>

3. 바이트 배열로 변환(getBytes())
    - 시스템의 기본 문자셋으로 인코딩된 바이트 배열을 리턴
    ```java
    byte[] bytes = "문자열".getBytes();
    byte[] bytes = "문자열".getBytes(Charset charset);
    ```
<br/>

4. 문자열 찾기(indexOf())
    - 매개값으로 주어진 문자열이 시작되는 인덱스를 리턴  

5. 문자열 길이(length())
    - 문자열의 길이(문자수) 리턴
6. 문자열 대치(replace())
    - 첫번째 매개값인 문자열을 찾아 두번째 매개값인 문자열로 대치한 새로운 문자열을 생성하고 리턴
7. 문자열 잘라내기(substring())
    - 주어진 인덱스에서 문자열 추출
    #### 사용방법 ####
    - substring(시작, 끝) : 주어진 시작과 끝 인덱스 사이의 문자열 추출
    - substring(int beginIndex) : 주어진 인덱스부터 끝까지 문자열 추출
8. 알파벳 소•대문자 변경
    - toLowerCase() : 문자열을 모두 소문자로 변경
    - toUpperCase() : 문자열을 모두 대문자로 변경 
9. 문자열 앞뒤 공백 잘라내기(trim())
    - 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴
    ```java
    public class Exam{
        publist static void main(String[] args){
            String tel1 = "  02";
            String tel2 = "123  ";
            String tel3 = "      1234       ";

            Stromg tel = tel1.trim() + tel2.trim() + tel3.trim();
            System.out.println(tel);
        }
    }
    [결과]
    021231234
    ```
10. 문자열 변환(valueOf())
    - 기본 타입의 값을 문자열로 변환하는 기능 
<br/><br/>

## StringTokenizer 클래스
 1. split() 메소드
    - 정규 표현식을 구분자로 해서 문자열을 분리한 후, 배열에 저장하고 리턴한다.
    ```java
    String[] result = "문자열".split("정규표현식");
    ```
    ```java
    public class Exam{
        public static void main(String[] args){
            String text = "홍길동&김사과, 바나나, 김자바-오렌지";

            String[] names = text.split("&|,|-");

            for(String name : names){ // 향상된 for문 
                System.out.println(name);
            }
        }
    }
    ```
<br/>

2. StringTokenizer 클래스
    - 문자열이 한 종류의 구분자로 연결되어 있을 경우, StringTokenizer 클래스를 사용하면 손쉽게 문자열(토큰:token)을 분리해낼 수 있다.
    - 객체 생성시, 첫번째 매개값으로 전체 문자열을 주고, 두번째 매개값으로 구분자를 주면 된다.
    ```java
    StringTokenizer st = new StringTokenizer("문자열", "구분자");
    ```
    ```java
    public class Exam{
        public static void main(String[] args){
            String text = "홍길동/김사과/오렌지";

            // 전체 토큰 수를 얻어 for문 돌기
            StringTokenizer st = new StringTokenizer(text, "/");
            int countTokens = st.countTokens();
            for(int i=0; i<countTokens; i++){
                String token = st.nextToken();
                System.out.println(token);
            }

            System.out.println();

            // 남아 있는 토큰 확인 후 while문으로 루핑
            st = new StringTokenizer(text, "/");
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                System.out.println(token);
            }
        }
    }
    ```
<br/>

## StringBuffer, StringBuilder 클래스
-  두 클래스는 내부 버퍼(buffer : 데이터를 임시로 저장하는 메모리)에 문자열을 저장해 두고, 그 안에서 추가, 수정, 삭제 작업을 할 수 있도록 설계되어있다.   
<br/>

## StringBuffer 와 StringBuilder 차이점
    - String("불변" 속성을 가짐)
        - 짧은 문자열을 더할 경우
        - 문자열 연산이 적고 멀티 스레드 환경일 경우
    - StringBuffer ("가변" 속성)
        - 스레드에 안전한 프로그램이 필요할 때나, 개발중인 시스템의 부분이 스레드에 안전한지 모를경우
        - 문자열 연산이 많고 멀티 스레드 환경일 경우
    - StringBuilder ("가변" 속성)
        - 스레드에 안전한지 여부가 전혀 관계없는 프로그램을 개발할 경우
        - 문자열 연산이 많고 단일 스레드 이거나 동기화를 고려하지 않아도 되는경우
    👉🏻 문자열의 추가, 수정, 삭제가 빈번하게 발생할 경우라면 StringBuffer/StringBuilder을 사용 
    👉🏻 가장 큰 차이점은?
        - 동기화의 유무로써, StringBuffer는 동기화 키워드를 지원하여 멀티 쓰레드 환경에서 안전하다는 점  
        (참고, String도 불변성을 가지기때문에 마찬가지로 멀티쓰레드 환경에서 안전성을 가짐)  
        (반대로, StringBuilder는 동기화 지원하지 않기 때문에 멀티 쓰레드 환경에서 사용하는 것은 적합하지 않지만 동기화를 고려하지 않는 만큼 단일 쓰레드에서의 성능은 StringBuffer보다 뛰어남)
<br/><br/>

## 정규 표현식
| 기호 | 설명 |
| :----:|:---:|
| [] | [abc]  : a,b,c 중 하나의 문자 <br> [^abc] : a,b,c 이외의 하나의 문자 <br> [a-zA-z] : a~z, A~Z 중 하나의 문자 |
| \d | 한 개의 숫자, [0-9]와 동일 | 
| \s | 공백 |
|\w | 한 개의 알파벳 또는 한개의 숫자, [a-zA-z_0-9]와 동일 |
| ? | 없음 또는 한개 | 
| * | 없음 또는 한개 이상 |
| + | 한개 이상 |
| {n} | 정확히 n개 | 
| {n,} | 최소한 n개 | 
| {n,m} | n개에서부터 m개까지 | 
| () | 그룹핑 | 
<br/>

### 예시
Q. 02-123-1234 또는 010-1234-5678같은 전화번호 정규 표현식
```java
(02|010)-\d{3,4}-\d{4}
```
|기호 | 설명 |
| :----: | :----:|
| (02 | 010) | 02 또는 010 |
| - | - 포함 |
|\d{3,4} | 3자리 또는 4자리 숫자 |
| - | - 포함 |
| \d{4} | 4자리 숫자 |
<br/>

## Pattern 클래스
- 정규 표현식을 검증하는 기능은 java.util.regex.Pattern 클래스의 정적 메소드인 matches() 메소드가 제공 
```java
boolean result = Pattern.matches("정규식", "검증할 문자열");
```
<br/>

## Arrays 클래스
- 배열 조작 기능을 가지고 있다.  
배열 조작이란? 배열의 복사, 항목 정렬, 항목 검색과 같은 기능을 말한다.  
단순 배열 복사는 System.arraycopy() 메소드를 사용할 수 있으나, Arrays는 추가적으로 항목 정렬, 항목 검색, 항목 비교와 같은 기능을 제공
<br/><br/>
1. 배열 복사
    - copyOf(원본 배열, 복사할 길이)
        - 원본 배열의 0번 인덱스에서 복사할 길이만큼 복사한 타겟 배열을 리턴하는데, 복사할 길이는 원본 배열의 길이보다 커도 되며, 타겟 배열의 길이가 된다. 
    - copyOfRange(원본 배열, 시작 인덱스, 끝 인덱스)
        - 원본 배열의 시작 인덱스에서 끝 인덱스까지 복사한 배열 리턴
        - 시작 인덱스는 포함되지만, 끝 인덱스는 포함되지 않는다.
    ```java
    public class Exam{
        public static void main(String[] args){
            char[] arr1 = {'J', 'A', 'V', 'A'};

            // 방법1
            char[] arr2 = Arrays.copyOf(arr1, arr1.length); // arr1 전체를 arr2로 복사
            System.out.println(Arrays.toString(arr2));

            // 방법2
            char[] arr3 = Arrays.copyOfRange(arr1, 1, 3); // arr[1] ~ arr[2]를 arr3[0] ~ arr[1]로 복사
            System.out.println(Arrays.toString(arr3));

            // 방법3
            char[] arr4= new char[arr1.length];
            System.arraycopy(arr1, 0, arr4, 0, arr1.length); // arr1 전체를 arr4로 복사
            for(int i=0; i< arr4.length; i++){
                System.out.println("arr4[" + i + "]=" + arr4[i]);
            }
        }
    }
    [결과]
    [J,A,V,A]
    [A,V]
    arr4[0] = J
    arr4[1] = A
    arr4[2] = V
    arr4[3] = A 
    ```
<br/>

2. 배열 항목 비교
    - equals() : 1차 항목의 값만 비교 
    - deepEquals() : 1차 항목이 서로 다른 배열을 참조할 경우 중첩된 배열의 항목까지 비교 
<br/>

3. 배열 항목 정렬
    - 기본 타입 또는 String 배열은 Arrays.sort() 메소드의 매개값으로 지정해주면 자동으로 오름차순 정렬이 된다.  
    사용자 정의 클래스 타입일 경우에는 클래스가 Comparable 인터페이스를 구현하고 있어야 정렬이 된다. 
4. 배열 항목 검색 
    - 배열 항목에서 특정 값이 위치한 인덱스를 얻어오는 것
    - 배열 항목을 검색하려면 먼저 Arrays.sort() 메소드로 항목들을 오름차순으로 정렬한 후, Arrays.binarySearch() 메소드로 항목을 찾아야 한다.
    ```java
    public class Exam{
        public static void main(String[] args){
            // 기본 타입값 검색
            int[] scores = {99, 97, 98};
            Arrays.sort(scores);
            int index = Arrays.binarySearch(scores,99);
            System.out.println("찾은 인덱스 : " + index);

            // 문자열 검색
            String[] names = {"홍길동", "김사과" , "오렌지"};
            Arrays.sort(names);
            index = Arrays.binarySearch(names, "홍길동");
            System.out.println("찾은 인덱스 : " + index);

            // 객체 검색
            Member m1 = new Member("홍길동");
            Member m2 = new Member("김사과");
            Member m3 = new Member("오렌지");
            Member[] members = {m1, m2, m3};
            Arrays.sort(members);
            index = Arrays.binarySearch(members, m1);
            System.out.println("찾은 인덱스 : " + index);
        }
    }
    [결과]
    찾은 인덱스 : 2
    찾은 인덱스 : 2
    찾은 인덱스 : 2
    ```
<br/>

## Wrapper(포장) 클래스
- 자바는 기본 타입(byte, char, short, int, long, float, double, boolean)의 값을 갖는 객체를 생성할 수 있다. 이런 객체를 포장객체라 하는데, 그 이유는 기본 타입의 값을 내부에 두고 포장하기 때문이다.  
포장 객체의 특징은 포장하고 있는 기본 타입 값은 외부에서 변경할 수 없다. 만약 내부의 값을 변경하고 싶다면 새로운 포장 객체를 만들어야 한다. 

### 박생(Boxing)과 언박싱(Unboxing)
- 박싱(Boxing) : 기본 타입의 값을 포장 객체로 만드는 과정
- 언박싱(Unboxing) : 포장 객체에서 기본 타입의 값을 얻어내는 과정 
```java
public class Exam{
    public static void main(String[] args){
        // Boxing
        Integer obj1 = new Integer(100);
        Integer obj2 = new Integer("200");
        Integer obj3 = Integer.valueOf("300");

        // Unboxing -> 기본타입명 + Value() 메소드 호출
        int value1 = obj1.intValue();
        int value2 = obj2.intValue();
        int value3 = obj3.intValue();

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}
[결과]
100
200
300
```
<br/>

### 자동 박싱과 언박싱
- 자동 박싱 : 포장 클래스 타입에 기본값이 대입될 경우 발생
    ```java
    Integer obj = 100; // 자동 박싱
    ```
<br/>

- 자동 언박싱 : 기본 타입에 포장 객체가 대입될 경우 발생
    ```java
    Integer obj = new Integer(200);
    int value1 = obj; // 자동 언박싱
    int value2 = obj + 100; // 자동 언박싱
    ```
<br/>

### 포장 값 비교
- 내부 값을 비교하기 위해 == 와 != 연산자를 사용할 수 없다.  
이 연산자는 내부의 값을 비교하는 것이 아니라 포장 객체의 참조를 비교하기 때문이다.
👉🏻 포장 클래스의 equals() 메소드는 내부의 값을 비교하도록 오버라이딩 되어 있다.
<br/><br/>

## Math 클래스
- Math 클래스가 제공하는 메소드는 모두 정적(static)이므로 Math 클래스로 바로 사용 가능.
1. round() 메소드
    - 항상 소수점 첫째 자리에서 반올림해서 정수값 리턴
2. Math.random() 메소드
    - 0.0과 1.0 사이의 범위에 속하는 하나의 double 타입의 값을 리턴
<br/><br/>

## Random 클래스
- boolean, int, long, float, double 난수를 얻을 수 있다.
- 종자값(seed)를 설정할 수 있다.
    - 종자값ㅇ: 난수를 만드는 알고리즘에 사용되는 값으로 종자값이 같으면 같은 난수를 얻는다.
<br/><br/>

## Date 클래스
- 날짜를 표현하는 클래스
- 객체 간에 날짜 정보를 주고 받을때 주로 사용
<br/><br/>

## 포맷팅(Fomatting) 메소드
- 날짜와 시간을 포맷팅된 문자열로 변환시키는 메소드

|클래스 | 리턴 타입 | 메소드(매개 변수) |
|:-----------:|:----:|:--------:|
| LocalDate <br/> LocalTime <br/> LocalDateTime <br/> ZonedDatetime | String | format(DateTimeFOrmatter formatter) | 
```java
public class Exan{
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTImeFormatter.ofPattern("yyyy년 M월 ddlf a h시 m분");
        String nowString = now.format(dateTimeFormatter);
        System.out.println(nowString);
    }
}
```