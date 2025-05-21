## DDD 프로젝트 구조

src/main/java/com/example/
├── application/            # 애플리케이션 서비스 계층
│   ├── service/
│   │   └── auth/
│   └── dto/                # 데이터 전송 객체
├── domain/                 # 도메인 계층
│   ├── user/               # 사용자 도메인
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── exception/
│   │   └── service/
│   └── common/             # 공통 도메인
├── infrastructure/         # 인프라 계층
│   ├── config/             # 설정
│   ├── security/           # 보안 관련
│   └── persistence/        # 영속성 계층
└── presentation/           # 프레젠테이션 계층
├── controller/
├── advice/
└── validator/