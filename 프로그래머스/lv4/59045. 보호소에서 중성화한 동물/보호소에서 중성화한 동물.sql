-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.ANIMAL_TYPE,	ai.NAME
from ANIMAL_INS as ai
left join ANIMAL_OUTS as ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where ai.SEX_UPON_INTAKE != ao.SEX_UPON_OUTCOME
order by ai.ANIMAL_ID asc;