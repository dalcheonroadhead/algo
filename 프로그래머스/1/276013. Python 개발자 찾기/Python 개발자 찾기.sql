-- 코드를 작성해주세요

SELECT 
d.ID,
d.EMAIL,
d.FIRST_NAME,
d.LAST_NAME
FROM DEVELOPER_INFOS d
WHERE 'Python' IN (SKILL_1, SKILL_2, SKILL_3)
ORDER BY ID
ASC;