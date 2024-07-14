-- MySQL
SELECT F.FLAVOR
FROM FIRST_HALF F JOIN ICECREAM_INFO I
    ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER > 3000
    AND I.INGREDIENT_TYPE = 'fruit_based';

-- Oracle
SELECT F.FLAVOR
FROM FIRST_HALF F, ICECREAM_INFO I
WHERE F.FLAVOR = I.FLAVOR
    AND F.TOTAL_ORDER > 3000
    AND I.INGREDIENT_TYPE = 'fruit_based';
