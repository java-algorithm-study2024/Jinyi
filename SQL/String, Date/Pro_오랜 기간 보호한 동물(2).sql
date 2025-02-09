-- ORACLE
SELECT ANIMAL_ID, NAME
FROM (SELECT O.ANIMAL_ID, O.NAME, O.DATETIME - I.DATETIME AS DAY
    FROM ANIMAL_INS I, ANIMAL_OUTS O
    WHERE I.ANIMAL_ID = O.ANIMAL_ID
    ORDER BY DAY DESC)
WHERE ROWNUM <= 2;
