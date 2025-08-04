--1.  직급이 'J2'이면서 200만원 이상 받는 직원 이거나,
--  직급이 'J7' 인 사원의 사번, 사원명, 직급코드, 급여
--  정보 조회하기
SELECT * FROM EMPLOYEE;
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE='J2' AND SALARY>=2000000 OR JOB_CODE='J7';



--2.  직급이 'J7' 이거나 'J2'이면서 급여를 200만원 이상
--  받는 직원의 사번, 사원명, 직급코드, 급여, 연봉을
--  조회하시오.
SELECT EMP_ID 사번, EMP_NAME 사원명, JOB_CODE 직급코드, SALARY 급여, (SALARY+NVL(SALARY*BONUS,0))*12 연봉
FROM EMPLOYEE
WHERE JOB_CODE='J7' OR (JOB_CODE='J2' AND SALARY >=2000000);



-- 3. EMPLOYEE 테이블에서
-- 모든 사원의 사번, 사원명, 이메일, 주민번호를
-- 조회하여 사원 목록표를 만들고자 한다.
-- 이 때, 이메일은 '@' 전 까지, 
-- 주민번호는 7번째 자리 이후 '*' 처리를 하여
-- 조회 하시오.
SELECT EMP_ID, EMP_NAME, 
		SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1),
		REPLACE(EMP_NO,SUBSTR(EMP_NO,8),'*******')
FROM EMPLOYEE;



--4. 직원명과 주민번호를 조회함
--  단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
--  예 : 홍길동 771120-1******
SELECT EMP_NAME,
		REPLACE(EMP_NO,SUBSTR(EMP_NO,9),'******')
FROM EMPLOYEE;


--5. 직원명, 직급코드, 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임
SELECT EMP_NAME, JOB_CODE,
		TO_CHAR( (SALARY+NVL(SALARY*BONUS,0))*12,'L999,999,999')
FROM EMPLOYEE;


--6. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 
--   수 조회함.
--   사번 사원명 부서코드 입사일
SELECT COUNT(*)
FROM EMPLOYEE
WHERE (DEPT_CODE='D5' OR DEPT_CODE='D9')
  AND EXTRACT(YEAR FROM HIRE_DATE)='2004';

--7. 직원명, 부서코드, 생년월일, 나이(만) 조회
--   단, 생년월일은 주민번호에서 추출해서, 
--   ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
--  (이상한 날짜 값이 들어간 사원들은 WHERE 조건절을 이용하여 제외)
SELECT EMP_NAME 직원명, DEPT_CODE 부서코드,
		CONCAT(CONCAT(SUBSTR(EMP_NO,1,2)||'년',SUBSTR(EMP_NO,3,2)||'월'),SUBSTR(EMP_NO,5,2)||'일') 생년월일,
		EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6),'RRMMDD')) 나이
FROM EMPLOYEE
WHERE EMP_ID NOT IN('200','201','214');


--8. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
--  아래의 년도에 입사한 인원수를 조회하시오.
--  => to_char, decode, sum 사용
--
--	-------------------------------------------------------------
--	전체직원수   2001년   2002년   2003년   2004년
--	-------------------------------------------------------------
SELECT COUNT(*) 전체직원수,
		COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY/MM/DD'),1,4),'2001',1)) "2001년",
		COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY/MM/DD'),1,4),'2002',1)) "2002년",
		COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY/MM/DD'),1,4),'2003',1)) "2003년",
		COUNT(DECODE(SUBSTR(TO_CHAR(HIRE_DATE,'YYYY/MM/DD'),1,4),'2004',1)) "2004년"
FROM EMPLOYEE;

--9.  부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회함
--  => case 사용
--   부서코드 기준 오름차순 정렬함.
SELECT EMP_NAME, DEPT_CODE,
		CASE 
		WHEN DEPT_CODE='D5' THEN '총무부'
		WHEN DEPT_CODE='D6' THEN '기획부'
		WHEN DEPT_CODE='D9' THEN '영업부'
		END 
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D6','D9')
ORDER BY DEPT_CODE ASC;

