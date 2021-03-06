create external table if not exists ${DB}.web_site
(
    web_site_sk           int4,
    web_site_id           text,
    web_rec_start_date    date,
    web_rec_end_date      date,
    web_name              text,
    web_open_date_sk      int4,
    web_close_date_sk     int4,
    web_class             text,
    web_manager           text,
    web_mkt_id            int4,
    web_mkt_class         text,
    web_mkt_desc          text,
    web_market_manager    text,
    web_company_id        int4,
    web_company_name      text,
    web_street_number     text,
    web_street_name       text,
    web_street_type       text,
    web_suite_number      text,
    web_city              text,
    web_county            text,
    web_state             text,
    web_zip               text,
    web_country           text,
    web_gmt_offset        float4,
    web_tax_percentage    float4
)
using csv with ('text.delimiter'='|') location '${DATA_LOCATION}';