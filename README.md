# GraphQL 예제 프로젝트

## 테스트 방법

### 1. GraphiQL 사용하기

- 기본 URL: http://localhost:8080/graphiql
- Query와 Mutation 모두 GraphiQL에서 테스트 가능 합니다.
- 설정 활성화: application.yml 에 `spring.graphql.graphiql.enabled=true` 추가

### 2. Postman 사용하기

- `http://localhost:8080/graphql` 엔드포인트로 POST 요청 전송
- Body에 JSON 형식으로 Query 작성:

    ```json
    // 다건 조회
    {
      getBooks(size: 10) {
         title
         author
         publicId
      }
    }
  
    // 단건 조회
    {
        getBook(publicId: "1") {
            title
            author
            publicId
        }
    }
  
    // 신규 생성
    mutation {
      createBook(author: "빠숑파파", title: "따라하며 배우는 GraphQL") {
          title
          author
          publicId
      }
    }
    ```

## GraphQL 작성 시 주의사항

### 1. 스키마 정의 필수

- `src/main/resources/graphql/schema.graphqls` 파일에 스키마 정의 필요
- 스키마는 SDL(Schema Definition Language)로 작성
- 모든 GraphQL 서버는 Query 타입이 필수적으로 필요

### 2. Controller와 스키마 일치

- 컨트롤러에서 정의한 메서드와 스키마의 필드명, 타입이 일치해야 함
- `@QueryMapping`, `@MutationMapping` 어노테이션 사용
- 인자는 `@Argument` 어노테이션으로 매핑

### 3. 테스트 데이터 준비

- H2 데이터베이스 초기화를 위한 schema.sql, data.sql 파일 작성
- 초기화 순서 설정: spring.jpa.defer-datasource-initialization=true

## TO-DO List
- Validation 및 예외 핸들링
- Security 