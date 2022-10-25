CREATE TABLE PRODUCT_ENTITY(
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    CREATED_AT DATETIME,
    LAST_MODIFIED_AT DATETIME,
    IMAGES VARCHAR(MAX),
    TITLE VARCHAR(255),
    CATEGORY VARCHAR(100),
    DETAIL_CATEGORY VARCHAR(100),
    PRODUCT_STATE VARCHAR(50),
    IMMEDIATE_PURCHASE_PRICE INT,
    LOWEST_PRICE_AUCTION INT,
    CONTENTS VARCHAR(1000),
    PRIMARY KEY(ID)
);

CREATE TABLE FILE_ENTITY(
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    CREATED_AT DATETIME,
    LAST_MODIFIED_AT DATETIME,
    FILE_NAME VARCHAR(255),
    SIZE BIGINT(20),
    MIME_TYPE VARCHAR(255)
)