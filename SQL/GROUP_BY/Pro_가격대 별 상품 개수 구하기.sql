-- ORACLE
-- 나머지 연산(PRICE % 10000) : MOD(PRICE, 10000)
-- 몫 연산(PRICT / 10000) : TRUNC(PRICE / 10000)
SELECT TRUNC(PRICE / 10000)*10000 AS PRICE_GROUP, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY TRUNC(PRICE / 10000)
ORDER BY PRICE_GROUP;
