-- https://school.programmers.co.kr/learn/courses/30/lessons/293261
-- Groupby는 관련 함수를 써야 함
SELECT I.ID, N.FISH_NAME, I.LENGTH
FROM FISH_INFO I JOIN FISH_NAME_INFO N
ON I.FISH_TYPE = N.FISH_TYPE
WHERE (I.FISH_TYPE, I.LENGTH) IN
    (SELECT FISH_TYPE, MAX(LENGTH)
     FROM FISH_INFO
     GROUP BY FISH_TYPE
    )   
