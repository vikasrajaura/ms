CREATE TABLE PRODUCT_TBL (
    product_id   VARCHAR(128)      NOT NULL,
    product_name    VARCHAR(256)      NOT NULL,
    product_category        VARCHAR(256)      NOT NULL,
    price      NUMBER(20)           NOT NULL,
    PRIMARY KEY (product_id)
);