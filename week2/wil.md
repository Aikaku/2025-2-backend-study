## <백엔드 스터디 2주차 WIL>

### 1. 이번주 스터디 목표
* Controller와 Service를 구현해본다.

---

### 2. 오늘의 키워드
* 계층형 아키텍처와 컨트롤러, 서비스

---

### 3. 정리

**1) Spring의 핵심 설계: 계층형 아키텍처(Layered Architecture)**


- 다음과 같은 구조이다. 
  - **Browser** ↔ **Controller** ↔ **Service** ↔ **Repository(DAO)** ↔ **DB**
- 각 계층은 역할이 확실하게 구분되어 있고 서로 직접 연결되지 않고 단계적으로 통신한다.
  - 계층 구조에 **사이클**이 없다.
- 계층 간 데이터 교환을 위해 **DTO** 를 사용한다.
- 구성 요소별 역할:
  - **Controller** : 클라이언트 요청을 받고 응답을 반환하는 계층 (입출력 담당)
  - **Service** : 비즈니스 로직을 수행하는 계층 (실질적인 처리 담당)
  - **Repository(DAO)** : DB 접근 및 데이터 저장/조회 담당
  - **Domain(Entity)** : DB 테이블과 매핑되는 핵심 객체, 비즈니스 데이터 자체를 표현

**2) Controller Layer 와 Service Layer**

- 패키지 구조는 크게 두 가지 방식이 있다.
  1. **계층형 구조 (Layer-based)**  
     - 계층 별로 패키지를 구분 (controller, service, repository 등)
  2. **도메인형 구조 (Domain-based)**  
     - 각 도메인별로 관련된 클래스(Controller, Service 등)를 함께 관리  
     - 유지보수성과 확장성이 높아 실제 프로젝트에서는 이 방식을 많이 사용

- **Controller Layer**
  - 클라이언트의 HTTP 요청을 가장 먼저 받는 계층
  - URL(endpoint)별로 메서드를 매핑하여 요청을 처리
  - DTO를 통해 입력/출력 데이터를 주고받음
  - `@Controller`, `@ResponseBody`, `@RestController`, `@RequestBody` 등의 어노테이션 사용
    - `@ResponseBody`는 컨트롤러의 메서드 반환값을 View(HTML 파일)로 해석하지 않고  그대로 HTTP 응답 본문(Response Body)에 담아 전송하도록 하는 어노테이션이다.
    - `@RequestBody`는 클라이언트가 전송한 HTTP 요청 본문(Request Body)의 JSON 데이터를  자바 객체로 변환해주는 어노테이션이다. 
    - `@RestController`는 `@Controller`+`@ResponseBody`이다.
  - 상태 코드 (Status Code) 활용  
    - `200 OK` : 요청 성공  
    - `201 Created` : 데이터 생성 성공  
    - `204 No Content` : 삭제 후 응답 데이터 없음  
    - `400 Bad Request` : 잘못된 요청  
    - `404 Not Found` : 데이터 없음  
    - `500 Internal Server Error` : 서버 오류  

- **Service Layer**
  - 비즈니스 로직을 수행하는 핵심 계층
  - Controller와 Repository 사이의 중간 다리 역할
  - 데이터 조회, 검증, 계산, 트랜잭션(원자성) 처리 등 담당
  - `@Transactional` 어노테이션으로 원자성 보장  

**3) 스프링 빈 & 의존성 주입**


- **스프링 빈(Spring Bean)** 
  - 스프링 컨테이너에 객체를 등록해놓고 관리한다. 
  - 애플리케이션 전역에서 공용으로 사용됨  
  - `@Component`, `@Controller`, `@Service`, `@Repository` 등이 모두 Bean 등록 대상  
    - **컴포넌트 스캔(@ComponentScan)** 을 사용해 어떤 클래스가 스프링 빈인지 찾아 자동 등록하거나 **컴포넌트(@Component)** 를 붙여서 이 친구가 스프링 빈이다라는 것을 명시해준다.
    - 혹은 설정 파일을 작성하여 수동 등록한다.

- **의존성 주입(Dependency Injection, DI)**  
  - 필요한 객체를 직접 생성하지 않고, 외부(Spring Container)에서 주입받는 방식  
  - 메모리 효율성과 유지보수성 향상  
  - 주요 방법:
    - **생성자 주입 (Constructor Injection)**  
       - `@Autowired`는 생성자에 필요한 의존성을 주입해준다. 만약 생성자가 한개이면 생략이 가능하다. 
       - `@RequiredArgsConstructor`는 클래스 내에 생성자에 `final`로 선언된 인자를 넣어 자동으로 만들어준다.

---

### 4. 느낀점
- Controller와 Service 계층을 구현하면서 단순히 코드를 따라 쓰기보다 왜 이런 구조로 동작하는지를 이해하며 공부해야겠다고 느꼈다.

---

### 5. 다음 스터디 목표
- JPA와 레포지토리

