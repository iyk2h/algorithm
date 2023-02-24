-- 코드를 입력하세요
SELECT b.BOOK_ID as BOOK_ID, a.AUTHOR_NAME as AUTHOR_NAME, date_format(b.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from Book as b 
join AUTHOR as a 
ON b.AUTHOR_ID = a.AUTHOR_ID
where b.Category = '경제' 
order by PUBLISHED_DATE;