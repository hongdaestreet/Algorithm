-- https://school.programmers.co.kr/learn/courses/30/lessons/59407
-- SQL에서는 IS NOT NULL 해야함 (~ISNULL(col) 안됨XXX)

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID


