-- 코드를 입력하세요
SELECT p.PRODUCT_ID, p.PRODUCT_NAME, sum(p.PRICE * o.amount) as TOTAL_SALES
from FOOD_PRODUCT as p
join (select * 
      from FOOD_ORDER
      where PRODUCE_DATE like '2022-05%'
     ) as o
on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID