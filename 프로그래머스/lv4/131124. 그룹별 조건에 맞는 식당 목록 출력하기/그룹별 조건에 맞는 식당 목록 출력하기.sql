select A.MEMBER_NAME as MEMBER_NAME, B.REVIEW_TEXT as REVIEW_TEXT, date_format(B.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE A join REST_REVIEW B
on A.MEMBER_ID = B.MEMBER_ID
where A.MEMBER_ID = (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(*) desc limit 1
)
order by REVIEW_DATE asc, REVIEW_TEXT;
