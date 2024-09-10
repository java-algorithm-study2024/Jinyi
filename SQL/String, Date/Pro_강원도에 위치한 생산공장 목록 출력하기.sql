-- ORACLE
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE SUBSTR(ADDRESS, 1, 3) = '강원도'
ORDER BY FACTORY_ID;

/*
    SUBSTR(컬럼명, 시작위치, 자를 길이)
    SUBSTR(컬럼명, 시작위치) = 시작위치 ~ 끝까지 자름
*/
