
CREATE TABLE port(
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT,
    port_name VARCHAR(50),
    portNum INT
);

ALTER TABLE port
ADD CONSTRAINT fk_port_product
FOREIGN KEY (product_id)
REFERENCES product(id);

CREATE TABLE connection_rule(
    id BIGSERIAL PRIMARY KEY,
    source_category_id BIGINT REFERENCES product_category(id),
    target_category_id BIGINT,
    port_name VARCHAR(50),

    FOREIGN KEY (target_category_id) REFERENCES product_category(id)
);

