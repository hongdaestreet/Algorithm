-- https://school.programmers.co.kr/learn/courses/30/lessons/299307
-- 1. SQL에서 조건을 따라 새로운 컬럼을 만들 때에는 CASE WHEN을 사용

SELECT ID,
    CASE
        WHEN SIZE_OF_COLONY > 1000 THEN 'HIGH'
        WHEN SIZE_OF_COLONY > 100 THEN 'MEDIUM'
        ELSE 'LOW'
        END AS SIZE
FROM ECOLI_DATA
ORDER BY ID;
