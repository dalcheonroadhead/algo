-- 코드를 작성해주세요

select count(*) as FISH_COUNT 
from FISH_INFO
where 1=1
AND substr(time, 1, 4) = '2021';
