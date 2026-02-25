CREATE TABLE category_limit(
    id SERIAL PRIMARY KEY,
    category_id BIGINT,
    product_id BIGINT,
    max_count INT,
    spec_key VARCHAR(255)
);