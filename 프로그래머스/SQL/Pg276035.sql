-- https://school.programmers.co.kr/learn/courses/30/lessons/276035
-- 8M / AI
-- 1.비트 포함은 A&B != 0으로 계산하면 됨 2.카테고리 중복 포함이면 한명뽑아야 하니까 DISTINCT 사용 
SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM (SELECT *
      FROM SKILLCODES
      WHERE CATEGORY LIKE 'Front End') S
JOIN DEVELOPERS D
ON S.CODE & D.SKILL_CODE != 0
ORDER BY D.ID
