create or replace function total_purchase(sale_i in int)
   return number
   is total_purchase_value int;
begin
   select SUM(details_shop_prices.shop_price)
       into total_purchase_value
   from sales inner join sold_details on sold_details.sale_id = sales.id
   inner join details on details.id = sold_details.detail_id
   inner join details_shop_prices on details_shop_prices.detail_type_id = details.detail_type_id
   where sales.id = sale_i;
   return total_purchase_value;
end;