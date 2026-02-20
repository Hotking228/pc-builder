-- Очищаем таблицы перед вставкой (если нужно)
TRUNCATE TABLE product_specification RESTART IDENTITY CASCADE;
TRUNCATE TABLE product RESTART IDENTITY CASCADE;

-- ВСТАВЛЯЕМ ПРОДУКТЫ
-- Категория 1: Процессоры (cpus)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('Intel Core i7-14700K', 'BX8071514700K', 38999, 1, 'Intel'),
('AMD Ryzen 7 7800X3D', '100-100000910WOF', 35999, 1, 'AMD');

-- Категория 2: Материнские платы (motherboards)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('ASUS ROG STRIX Z790-E GAMING WIFI', '90MB1CQ0-M0EAY0', 32999, 2, 'ASUS'),
('MSI MAG B650 TOMAHAWK WIFI', 'MAG B650 TOMAHAWK WIFI', 21999, 2, 'MSI'),
('Gigabyte B760M DS3H', 'B760M DS3H', 11999, 2, 'Gigabyte');

-- Категория 3: Оперативная память (ram)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('Kingston Fury Beast DDR5 32GB', 'KF552C40BB-32', 11999, 3, 'Kingston'),
('Samsung DDR4 16GB', 'M378A1K43CB2-CTD', 4999, 3, 'Samsung'),
('Corsair Vengeance RGB DDR5 64GB', 'CMH64GX5M2B5600C40', 27999, 3, 'Corsair');

-- Категория 4: Видеокарты (gpus)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('NVIDIA GeForce RTX 4080 SUPER', '900-1G160-2560-000', 114999, 4, 'NVIDIA'),
('AMD Radeon RX 7800 XT', '100-100000780XT', 65999, 4, 'AMD'),
('ASUS GeForce RTX 4060 Dual', 'DUAL-RTX4060-O8G', 37999, 4, 'ASUS');

-- Категория 5: Накопители (storage)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('Samsung 980 Pro 1TB NVMe', 'MZ-V8P1T0BW', 9999, 5, 'Samsung'),
('WD Blue SN580 2TB', 'WDS200T3B0E', 12499, 5, 'Western Digital'),
('Seagate BarraCuda 4TB HDD', 'ST4000DM004', 9999, 5, 'Seagate');

-- Категория 6: Блоки питания (psus)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('be quiet! Dark Power 13 1000W', 'BN332', 24999, 6, 'be quiet!'),
('Corsair RM750e', 'CP-9020263-EU', 11999, 6, 'Corsair'),
('Chieftec Proton 600W', 'BDF-600S', 4999, 6, 'Chieftec');

-- Категория 7: Корпуса (cases)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('be quiet! Pure Base 500DX', 'BGW37', 8999, 7, 'be quiet!'),
('NZXT H7 Flow', 'CC-H71FW-01', 13999, 7, 'NZXT'),
('Deepcool CH370', 'R-CH370-BK', 4999, 7, 'Deepcool');

-- Категория 8: Кулеры для процессора (cpu_coolers)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('Noctua NH-D15', 'NH-D15', 10999, 8, 'Noctua'),
('Deepcool AK620', 'R-AK620-BKNNMT-G', 5999, 8, 'Deepcool'),
('Arctic Liquid Freezer III 360', 'ACFRE00136A', 10999, 8, 'Arctic');

-- Категория 9: Корпусные вентиляторы (case_fans)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('Arctic P12 PWM PST', 'ACFAN00200A', 899, 9, 'Arctic'),
('Noctua NF-A12x25', 'NF-A12x25', 2999, 9, 'Noctua'),
('be quiet! Silent Wings 4', 'BL067', 2399, 9, 'be quiet!');