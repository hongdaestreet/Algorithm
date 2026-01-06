-- https://school.programmers.co.kr/learn/courses/30/lessons/131124
-- 서브쿼리로 최빈값 구하기

SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE M
JOIN REST_REVIEW R ON M.MEMBER_ID = R.MEMBER_ID
WHERE R.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    HAVING COUNT(*) = (  -- 최대값 구하기
        SELECT MAX(cnt)
        FROM (
            SELECT MEMBER_ID, COUNT(*) AS cnt
            FROM REST_REVIEW
            GROUP BY MEMBER_ID
        ) T
    )
)

ORDER BY R.REVIEW_DATE, R.REVIEW_TEXT;
