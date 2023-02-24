-- 코드를 입력하세요
SELECT cc.car_id, cc.car_type, ROUND(cc.DAILY_FEE * 30 * ((100-cp.discount_rate) / 100)) AS FEE
from CAR_RENTAL_COMPANY_CAR as cc
left join CAR_RENTAL_COMPANY_RENTAL_HISTORY as ch 
on cc.CAR_ID = ch.CAR_ID
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as cp
on cc.CAR_TYPE = cp.CAR_TYPE
where cp.duration_type='30일 이상' and cc.car_id not in ( 
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where END_DATE > '2022-11-01' AND START_DATE < '2022-12-01')
group by cc.car_id
having cc.car_type in ('세단', 'SUV') and (FEE > 500000 and FEE < 2000000)
order by FEE desc, cc.car_type, cc.car_id desc
;
