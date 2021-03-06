create external table if not exists ${DB}.catalog_returns
(
    cr_returned_date_sk       int4,
    cr_returned_time_sk       int4,
    cr_item_sk                int4,
    cr_refunded_customer_sk   int4,
    cr_refunded_cdemo_sk      int4,
    cr_refunded_hdemo_sk      int4,
    cr_refunded_addr_sk       int4,
    cr_returning_customer_sk  int4,
    cr_returning_cdemo_sk     int4,
    cr_returning_hdemo_sk     int4,
    cr_returning_addr_sk      int4,
    cr_call_center_sk         int4,
    cr_catalog_page_sk        int4,
    cr_ship_mode_sk           int4,
    cr_warehouse_sk           int4,
    cr_reason_sk              int4,
    cr_order_number           int4,
    cr_return_quantity        int4,
    cr_return_amount          float4,
    cr_return_tax             float4,
    cr_return_amt_inc_tax     float4,
    cr_fee                    float4,
    cr_return_ship_cost       float4,
    cr_refunded_cash          float4,
    cr_reversed_charge        float4,
    cr_store_credit           float4,
    cr_net_loss               float4
)
using csv with ('text.delimiter'='|') location '${DATA_LOCATION}';
