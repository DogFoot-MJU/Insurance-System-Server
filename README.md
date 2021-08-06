# 보험사 시스템 구축

## 개요

- 명지대학교 2021년 1학기 분산프로그래밍 기말 프로젝트로 제출한 프로젝트입니다.
- 서버 레포지토리와 안드로이드 레포지토리로 나뉘어져 있습니다.
- 현재 레포지토리는 서버 레포지토리이며 안드로이드 레포지토리는 아래 주소에서 확인 가능합니다.
- [안드로이드 레포지토리](https://github.com/DogFoot-MJU/Insurance-System-App)

## 팀원

|담당|이름(직책)|
|:---:|:---:|
|Server|이서현(팀장)|
|Android|김정우(팀원), 신동욱(팀원)|

## 팀 소통
- `Jira`를 통해 역할을 할당했고 진행 상황을 팀원 모두 확인할 수 있도록했습니다.
- `Slack`과 `Jira`를 연동하여 Jira의 알람 기능 부재 문제를 해소했습니다.
- `Postman`에 팀원으로 초대하여 API를 확인하고 테스트해볼 수 있도록 했습니다.

## 개발환경

|분류|항목|
|:---:|---|
|Language|`Java`|
|Framework|`Spring Boot`|
|DB|`MySql`|
|Library|`Spring Security`, `Java-Jwt`, `Spring Data Jpa`, `Lombok`, `Java Mail Sendar`, `Validation`, `Gson`, `Commons IO`, `Commons Lang3`, `Jasypt`|
|Build|`Maven`|

## 주요기능

### 회원가입

- 이메일 인증을 통해 회원가입을 할 수 있습니다.
- 가입 신청한 메일에서 '인증 확인' a태그를 클릭하면 회원가입이 완료됩니다.

### 보안관련

- `Spring Security`와 `JWT`를 이용하여 인증과 인가를 구현했습니다.
- 패스워드는 `Bcript`로 암호화하여 저장했습니다.
- `Jasypt`를 이용하여 `application.yml`의 주요 정보를 암호화했습니다.

### 상담

- 유저는 상담메뉴를 통해 보험상품을 상담받을 수 있습니다.
- 유저는 나의 문의내역 리스트에서 문의 결과를 확인할 수 있습니다.
- 보험 판매자(직책)는 유저의 문의 리스트를 확인할 수 있으며, 답장할 수 있습니다.

### 보험 개발
- 개발할 수 있는 보험의 종류는 자동차, 운전자, 화재, 여행 총 4가지 보험 상품을 개발할 수 있습니다.
- 보험 개발은 다음과 같은 단계를 거치게 됩니다.
- 기획(보험설계자) - 설계(보험설계자) - 인가(UW) - 승인(금융감독원)
- 보험 설계자는 기획서를 제출하여 기획단계를 진행합니다.
- 보험 설계자는 설계단계에서 보험의 세부 내용을 작성합니다.
- UW는 인가 단계에서 인수정책을 수립합니다.
- 금융감독원이 승인을 하게 되면 보험상품으로 등록됩니다.

### 보험 상품
- 자동차, 운전자, 화재, 여행의 판매 가능한 보험 리스트를 확인할 수 있습니다.
- 각 보험에 대해 상세 내용을 확인할 수 있습니다.
- 유저는 보험료를 계산해볼 수 있습니다.
- 보험을 신청하게 되면 적법심사 대상 리스트에 등록됩니다.
- UW가 계약 내용을 상세히 확인할 수 있으며 계약을 승인하거나 거절할 수 있습니다.

### 보상
- 보험 가입자는 보상(사고접수)을 신청할 수 있습니다.
- 사고 접수에는 사고와 관련된 서류를 첨부해야합니다.
- 보상관리자는 사고 접수 내역 리스트를 확인할 수 있습니다.
- 보상관리자는 사고 접수 내역을 상세히 확인할 수 있으며, 보상을 지급하거나 거절할 수 있습니다.