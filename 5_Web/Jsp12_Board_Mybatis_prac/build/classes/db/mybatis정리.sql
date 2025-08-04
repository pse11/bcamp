1. 설정 파일 작성(config.xml)
- db 연결 정보, alias, mapper 파일 위치 등을 적음.

2. mapper xml 작성
- sql 쿼리 작성
- 어떤 id로 불러올지, 파라미터 타입, 결과 타입 지정.

3.인터페이스 mapper 작성
- xml과 연결되는 인터페이스
- sql을 메서드처럼 호출 가능

4. sqlsessionFactory 생성 -> SqlSession 열기 -> Mapper 호출
- SqlSessionFactory 를 통해 DB 세션 열고
- Mapper를 통해 SQL 실행(select, insert, update, delete)
- 끝나면 session.commit() (insert/update/delete)하고 close()