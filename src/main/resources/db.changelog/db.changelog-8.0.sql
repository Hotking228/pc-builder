-- Термопасты (category_id = 10)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('Arctic MX-6', 'MX6-4G', 1299, 10, 'Arctic'),
('Thermal Grizzly Kryonaut', 'TG-K-001', 1599, 10, 'Thermal Grizzly'),
('Noctua NT-H1', 'NT-H1-3.5g', 999, 10, 'Noctua'),
('Thermalright TF8', 'TF8-2G', 899, 10, 'Thermalright');

-- Звуковые карты (category_id = 11)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('Creative Sound Blaster AE-5', 'SB-AE-5', 14999, 11, 'Creative'),
('ASUS Xonar SE', 'XONAR-SE', 3999, 11, 'ASUS'),
('Creative Sound BlasterX G6', 'SBX-G6', 13999, 11, 'Creative'),
('EVGA Nu Audio', '424-01-2421', 21499, 11, 'EVGA');

-- Сетевые карты (category_id = 12)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('ASUS PCE-AX3000', 'PCE-AX3000', 4599, 12, 'ASUS'),
('TP-Link Archer TX50E', 'TX50E', 3999, 12, 'TP-Link'),
('Intel Gigabit CT Desktop', 'EXPI9301CT', 2499, 12, 'Intel'),
('TP-Link UE300', 'UE300', 1299, 12, 'TP-Link');  -- USB адаптер

-- Контроллеры (category_id = 13)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('ASUS Hyper M.2 x11', 'HYPER-M2-X11', 5999, 13, 'ASUS'),
('SilverStone EC04-P', 'SST-EC04-P', 2499, 13, 'SilverStone'),
('SYBA SI-PEX40064', 'SI-PEX40064', 3499, 13, 'SYBA'),
('StarTech PEXSAT34', 'PEXSAT34', 4999, 13, 'StarTech');

-- Оптические приводы (category_id = 14)
INSERT INTO product (name, vendor_code, price, category_id, manufacturer) VALUES
('ASUS DRW-24D5MT', 'DRW-24D5MT', 2149, 14, 'ASUS'),
('LG WH14NS40', 'WH14NS40', 5499, 14, 'LG'),
('Pioneer BDR-212DBK', 'BDR-212DBK', 11499, 14, 'Pioneer'),
('Apple USB SuperDrive', 'MD564ZM/A', 7999, 14, 'Apple');