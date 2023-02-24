-- 코드를 입력하세요
SELECT a.FLAVOR
from FIRST_HALF as a
left join (select FLAVOR, sum(total_order) as total_order
           from july
           group by FLAVOR
          ) as b
on a.flavor = b.flavor
order by (a.total_order + b.total_order) desc
limit 3