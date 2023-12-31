# AWS Certified Cloud Practitioner
- 이번 강의는 AWS에서 주관하는 강의로 최근에 관심이 생겨 듣게 되었다.


### AWS 클라우드 정의 및 가치 제안
- 클라우드 서비스 플랫폼 AWS는 **종량제 요금**으로 다음을 제공
    - 컴퓨팅 파워
    - 스토리지
    - 데이터베이스 서비스
    - 기타 리소스
- 리전 및 가용 영역은 기존 데이터 센터 인프라보다 가용성, 내결함성 및 확장성이 뛰어남
- AWS는 계정에 액세스 할 수 있도록 세가지 인터페이스를 지원
    - 웹 기반 AWS 관리 콘솔(모바일 앱도 해당)
    - 명령줄 인터페이스(CLI)
    - 소프트웨어 개발 키트(SDK)


### AWS 클라우드의 경제적 측면 파악
### 1.2 AWS 클라우드의 경제적 측면 파악


- 특징
    1. 종량제 요금
        1. 가변 비용 특징으로 비용 절감 가능
    2. 비용 최적화
        1. 온프레미스 환경 데이터베이스 직접 운영에 따른 비용, 인력이 필요 
        2. but, aws센터는 필요한 인프라를 사전 구축하여 서비스 제공
    3. 용량 추정 불필요
    4. 뛰어난 속도와 민첩성
        1. 필요한 리소스에 대해 몇분만에 신규리소스 확보 가능 → 온프레미스 환경에서와 차이가 보임
            1. 워크로드에 빠르게 대응가능 
    5. 몇분만에 전세계 대상으로 서비스 배포 가능
        1. 글로벌 인프라를 구축 배포하고 있음 → 24리전과 86개의 가용영역으로 서비스 제공
    6. 규모 경제 특징을 가지고 있음
        1. 수많은 고객의 사용량이 증가되고 aws는 규모에 경제를 실현 가능
        1. 수많은 고객의 사용량이 증가되고 aws는 규모에 경제를 실현 가능

### 1.3 다양한 클라우드 아키텍처 설계 원칙

1. 장애에 대비한 설계를 해야 함 
    1. 서비스 구성요소들이 단일 장애요소를 제거함으로싸 장애발생시 서비스 중단을 최소화하는 고가용성 아키텍처 설계
2. 탄력적 인프라 설계 구축
    1. 자동으로 리소스를 확대및 축소할 수 있도록
3. 마이크로 서비스 아키텍처 설계 고려
    1. 통합된 형태로 민첩하게 결합된 모놀리틱 아키텍처가 아닌 느슨하고 독립적 아키텍처로 고민

### 예시 질문1.

**컴퓨터 워크 로드**가 다양한 애플리케이션에 대해 **AWS**가 기존 데이터 센터보다 **더 경제적인 이유**는 무엇입니까? → 종량제 요금 관련 질문  <br/>
정답 : (3)

1. Amazon Elastic Compute Colud (Amazon EC2) 비용은 월 단위로 청구됩니다.
2. 고객은 Amazon EC2 인스턴스에 대해 전체 관리 액세스 권한을 보유합니다. 
3. Amazon EC2 인스턴스는 필요할때 온디맨드로 시작할 수 있습니다. 
4. 고객은 최대 워크로드를 처리하기에 충분한 인스턴스를 영구적으로 실행할 수 있습니다.

<br/>

## 도메인2 : 보안 및 규정 준수

### 2.1 AWS 공동 책임 모델 정의

- 보안은 AWS에서 최우선 순위입니다.
- 공동 책임 모델은 AWS 와 고객 간의 보안 책임을 정의합니다.
- IAM은 AWS 서비스 및 리소스에 대한 액세스를 안전하게 제어합니다.
- Amazon Inspector는 AWS 리소스의 보안을 평가합니다.
- AWS Shield는 AWS 에서 실행되는 애플리케이션을 DDoS 공격으로부터 보호합니다.
- AWS 규정 준수 프로그램은 고객이 보안 및 데이터 규정 준수를 유지하는데 도움이 됩니다. 

<br/>

### 2.2 AWS 클라우드 보안 및 규정 준수 개념 정의

- 클라우드 내부에서의 보안 관리
    - 네트워크 및 데이터 암호화, 자격 증명 및 access 관리

### 2.3 AWS 액세스 관리 기능 식별

- IAM 사용해서 사용자 그룹을 생성해 명시적 허용 권한 부여 가능
- IAM
    - aws리소스를 접근할 사용자를 생성하고 인증을 위한 암호, access key 부여를 위한 IAM를 통해 여러 사용자를 그룹화할 수 있음
    - 기본적으로 aws 접근권한이 x
    - IAM 포함된 정책 문서를 사용자그룹에 연결해야 함
    - IAM ROLE를 통해 사용자및 AWS 사용자에게 임시 기간으로 부여할 수 있으면 추가인증없이 aws에 접근 가능
    - aws 보안 강화를 위해 다양한 서비스 활용 가능
- 사용자들의 api 모두 기록하고 보안 감사에 활용 가능

<br/>

### 예시 질문2

다음 중 **AWS 공동 책임 모델**에 따른 **AWS의 책임**은 무엇입니까?

1. 타사 애플리케이션 구성
2. 물리적 하드웨어 유지 관리
3. 애플리케이션 액세스 및 데이터 보안
4. 사용자 지정 Amazon Machine Images(AMIs) 관리

### 예시 질문3

고객은 AWS 인프라에서 금지된 작업에 대한 정보를 어디에서 찾을 수 있습니까?

1. AWS Trusted Advisor
    1. 아키텍처가 aws 모범 사례를 따를 수 있도록 권장 사례 파악
2. AWS Identity 및 Access Management (IAM)
    1. AWS 서비스 배포된 리소스에 대한 액세스 관리
3. AWS 빌링 콘솔
    1. AWS 서비스 비용에 대해 추적하고 리소스에 내역 확인 
4. AWS 이용 제한 정책
    1. 정책 페이지에 방문하면 제한 사용자를 파악할 수 있음

답 : (4)

<br/>

### 예시 질문4

시스템 관리자가 사용자의 **AWS 관리 콘솔에 로그인 보안 계층**을 추가하려면 어떻게 해야 합니까?

1. AWS Cloud Directory 사용
    1. active 디렉터리 등 다양한 디렉토리 관리
2. AWS Identity 및 Access Management(IAM) 역할 감사
    1. 추적 및 로깅을 위해 활성화 가능 
3. 다중 인증(MFA) 활성화 → 2차 인증 구현 가능 전용 MFA 장치 등 사용 가능 
4. AWS CloudTrail 활성화

답 : (3)

<br/>

## 도메인 3 : 기술

### 3.1 AWS 클라우드에서의 배포 및 운영 방법론 정의

- aws 기반 리소스를 웹 기반 관리 콘솔 등 총 3가지 종류 인터페이스 지원
- 코드형 인프라 개념에 대해 알아야함
    - 배포하고자하는 리소스를 json ,yaml 형태로 코드를 작성한 뒤 원하는 리전에 손쉽게 배포하거나 업데이트 가능
    - aws cloud formation 사용
- 다양한 클라우드 배포 유형에 대해 알고 있으면 좋다.
- aws 기반 환경에서 구성하기 위해 클라우드 배포 모델 사용하거나, 클라우드 배포모델은 온프레미스 를 같이 사용해서 하이브리드 형식으로 사용할 수 도 있음

<br/>

### 3.3 핵심 AWS 서비스

| Amazon CloudWatch | 클라우드 리소스 및 애플리케이션에 대한 완벽한 가시성 확보 |
| --- | --- |
| Elastic Load Balacing Auto Scaling | 수요에 따라 확장되는 고가용성 애플리케이션 배포 |
| AWS Database Services | 관리 오버헤드 없이 SQL 또는 NoSQL 데이터베이스 실행 |
| AWS CloudFormation | 반복 가능한 인프라를 프로그래밍 방식으로 배포 |
| AWS Elastic Beanstalk | 가능한 가장 간단한 방법으로 애플리케이션 배포 |
| AWS Direct Connect | 사내에서 AWS로 전용 네트워크 연결 프로비저닝 |
| Amazon Route 53 | 가용성과 확장성이 뛰어난 도메인 이름 시스템(DNS) 웹 서비스 실행 |
| AWS Lambda | 서버 관리 없이 코드 실행 |
| Amazon CloudFront | 대규모로 확장되고 전 세계적으로 사용 가능한 네트워크를 통해 콘텐츠 제공 |

<br/>

### 3.4 기술 지원을 위한 리소스

### 예시 질문 5

**지연 시간이 짧은 전송**을 보장하기 위해 Amazon CloudFront가 사용하는 AWS 글로벌 인프라의 구성 요소는 무엇입니까?

1. AWS 리전 
2. AWS 엣지 로케이션
3. AWS 가용 영역
4. Amazon Virtual Private Cloud(Amazon VPC) → 가상 네트워크를 구성할 수 있는 서비스

답 : (2)

<br/>

### 예시 질문 6

회사에서 **AWS 내에 가상 네트워크**를 생성할 수 있도록 지원하는 AWS 네트워킹 서비스는 무엇입니까?

1. AWS Config 
    1. 배포한 aws 리소스가 보안, 규정준수에 충족하는 지 확인
2. Amazon Route 53
    1. aws 네트워크 환경에서의 DNS 서비스 환경
3. AWS Direct Connect
    1. aws와 온프레미스 데이터 센터간의 전용 회선 제공
4. Amazon Virtual Private Cloud(Amazon VPC)

답 : (4)

### 예시 질문 7

Amazon Elastic Compute Cloud(Amazon EC2) 인스턴스가 종료될때 **API를 호출한 사용자를 식별**할 수 있는 서비스는 무엇입니까?

1. Amazon CloudWatch : aws 기반으로 배포된 인프라 및 어플리케이션에 대해 모니터링하고 성능 값 기록 
2. AWS CloudTrail
    1. 모든 api 호출하고 기록 
3. AWS X-Ray : 마이크로 서비스 아키텍처 환경에서 애플리케이션 성능 추적하고 병목 현상 모니터링 
4. AWS Identity 및 Access Management(AWS IAM) : aws 서비스와 배포된 aws access 관리

답 : (2)