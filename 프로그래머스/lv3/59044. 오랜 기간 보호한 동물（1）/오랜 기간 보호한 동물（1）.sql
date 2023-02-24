-- 코드를 입력하세요
SELECT ai.name, ai.datetime
from ANIMAL_INS as ai
left join ANIMAL_OUTS as ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where ao.ANIMAL_ID is null
order by ai.datetime
limit 3;