-- https://school.programmers.co.kr/learn/courses/30/lessons/301649
-- AI 도움받음
-- 1. WITH는 서브쿼리 느낌(임시 테이블)

WITH ranked AS (
    SELECT
        ID,
        ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS rn,
        COUNT(*) OVER () AS total
    FROM ECOLI_DATA
)

SELECT
    ID,
    CASE
        WHEN rn <= total * 0.25 THEN 'CRITICAL'
        WHEN rn <= total * 0.5 THEN 'HIGH'
        WHEN rn <= total * 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM ranked
ORDER BY ID;
