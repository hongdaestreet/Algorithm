-- https://school.programmers.co.kr/learn/courses/30/lessons/273711
-- GPT 도움받음
-- 부모(테이블) P를 만들고 자식 T를 만들어서 부모에게 필터를 거는 SELF JOIN 사용

SELECT C.ITEM_ID, C.ITEM_NAME, C.RARITY 
FROM ITEM_TREE T
INNER JOIN ITEM_INFO P ON P.ITEM_ID = T.PARENT_ITEM_ID  -- 부모 테이블
INNER JOIN ITEM_INFO C ON C.ITEM_ID = T.ITEM_ID         -- 자식 테이블
WHERE P.RARITY='RARE'
ORDER BY C.ITEM_ID DESC;


