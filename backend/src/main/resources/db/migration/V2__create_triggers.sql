create or replace trigger supplier_guarantee_check
   before insert or update
   on guarantees
   for each row
declare
   row_count_firms   int;
   row_count_dealers int;
begin
   select count(*) into row_count_firms from firms where :new.supplier_id = firms.id;
   if row_count_firms = 0
   then
       select count(*) into row_count_dealers from dealers where :new.supplier_id = dealers.id;
       if row_count_dealers = 0
       then
           RAISE_APPLICATION_ERROR(-20000, 'not a firm or dealer');
       end if;
   end if;
end;
/
create or replace trigger check_details_amount_in_cell
   before insert
   on details
   for each row
declare
   detail_amount_in_cell int;
begin
   if :new.cell_id is not null
   then
       select count(*) into detail_amount_in_cell from details where cell_id = :new.cell_id;
       if detail_amount_in_cell >= 5
       then
           RAISE_APPLICATION_ERROR(-20001, 'cell is full');
       end if;
   end if;
end;
/
create or replace trigger check_refunds
   before insert or update
   on refunds
   for each row
declare
   delivery_d       date;
   detail_t_id      int;
   guarantee_months int;
begin
   select deliveries.delivery_date
   into delivery_d
   from deliveries
            inner join details on details.delivery_id = deliveries.id
   where :new.detail_id = details.id;

   select details.detail_type_id
   into detail_t_id
   from details
   where details.id = :new.detail_id;

   select (
       select guarantees.guarantee_months
       from guarantees
                inner join suppliers on suppliers.id = guarantees.supplier_id
                inner join deliveries on deliveries.supplier_id = suppliers.id
                inner join details on details.delivery_id = deliveries.id
       where :new.detail_id = details.id
         and details.detail_type_id = detail_t_id
         and guarantees.detail_type_id = detail_t_id
       ) into guarantee_months from dual;

   if guarantee_months is null
   then
       guarantee_months := 0;
   end if;

   if :new.supplier_refund_date is not null
   then
       if MONTHS_BETWEEN(:new.supplier_refund_date, delivery_d) > guarantee_months
       then
           RAISE_APPLICATION_ERROR(-20002, 'warranty expired');
       end if;
   end if;
end;
/
create or replace trigger check_refunds_dates
   before insert or update
   on refunds
   for each row
begin
   if :new.supplier_refund_date is not null
   then
       if :new.customer_refund_date > :new.supplier_refund_date
       then
           RAISE_APPLICATION_ERROR(-20003, 'wrong dates');
       end if;
   end if;
end;
/
create or replace trigger check_dates_in_delivery
   before insert or update
   on deliveries
   for each row
begin
   if :new.delivery_date is not null
   then
       if :new.formation_date > :new.delivery_date
       then
           RAISE_APPLICATION_ERROR(-20004, 'wrong dates');
       end if;
   end if;
end;
/
create or replace trigger delivery_custom_check
   before insert or update
   on customs
   for each row
declare
   delivery_formation_date date;
begin
   select deliveries.formation_date
   into delivery_formation_date
   from deliveries
   where deliveries.id = :new.delivery_id;

   if delivery_formation_date > :new.clearance_date
   then
       RAISE_APPLICATION_ERROR(-20005, 'wrong dates');
   end if;
end;