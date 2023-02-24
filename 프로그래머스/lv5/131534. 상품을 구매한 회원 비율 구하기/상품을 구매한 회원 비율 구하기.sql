select YEAR, MONTH, count(*) AS PUCHASED_USERS, round((count(*) / 
                                                       (
                                                           select count(*)
                                                           from user_info
                                                           where year(joined) = 2021
                                                       )
                                                      ), 1) as PUCHASED_RATIO
from (select DISTINCT YEAR(s.SALES_DATE) as YEAR, MONTH(s.SALES_DATE) as MONTH, i.user_id
      from ONLINE_SALE s
      join USER_INFO i
      on s.USER_ID = i.USER_ID and YEAR(i.JOINED) = "2021"
     ) o
group by YEAR, MONTH
order by YEAR, MONTH;

# SELECT YEAR, MONTH, COUNT(*) AS PUCHASED_USERS,
# 	ROUND((COUNT(*)/ (SELECT COUNT(*)
# 					FROM USER_INFO WHERE YEAR(JOINED) = 2021)), 1) AS PUCHASED_RATIO
# FROM (
#     SELECT DISTINCT YEAR(S.SALES_DATE) AS YEAR, MONTH(S.SALES_DATE) AS MONTH, U.USER_ID
#     FROM ONLINE_SALE S
#     JOIN USER_INFO U ON S.USER_ID = U.USER_ID AND YEAR(JOINED) = 2021
# ) A
# GROUP BY YEAR, MONTH
# ORDER BY YEAR, MONTH