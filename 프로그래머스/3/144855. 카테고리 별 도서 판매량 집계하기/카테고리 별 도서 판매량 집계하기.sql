select b.category as CATEGORY, sum(bs.sales) as TOTAL_SALES
from book as b
join book_sales as bs using(book_id)
where sales_date
between "2022-01-01 00:00:00" and "2022-01-31 23:59:59"
group by b.category
order by b.category;