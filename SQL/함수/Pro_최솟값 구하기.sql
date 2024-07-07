-- MySQL
SELECT MIN(DATETIME) AS '시간'
FROM ANIMAL_INS;

-- Oracle
-- 오라클에서 문자열은 "쌍따옴표"로 묶는다. → '홑따옴표'로 묶으면 에러
SELECT MIN(DATETIME) AS "시간"
FROM ANIMAL_INS;
