SELECT DAY, SUM(total_bill) AS revenue_daily
FROM TIPS
GROUP BY DAY
HAVING SUM(total_bill) > 1000
ORDER BY revenue_daily DESC;
