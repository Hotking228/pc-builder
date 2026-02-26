-- ХАРАКТЕРИСТИКИ ДЛЯ ПРОЦЕССОРОВ
-- Intel Core i7-14700K (id=1)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(1, 'socket', 'LGA1700'),
(1, 'cores', '20'),
(1, 'threads', '28'),
(1, 'base_clock', '3.4'),
(1, 'boost_clock', '5.6'),
(1, 'tdp', '125'),
(1, 'integrated_gpu', 'true'),
(1, 'memory_type', 'DDR5-5600, DDR4-3200'),
(1, 'architecture', 'Raptor Lake Refresh');

-- AMD Ryzen 7 7800X3D (id=2)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(2, 'socket', 'AM5'),
(2, 'cores', '8'),
(2, 'threads', '16'),
(2, 'base_clock', '4.2'),
(2, 'boost_clock', '5.0'),
(2, 'tdp', '120'),
(2, 'integrated_gpu', 'true'),
(2, 'memory_type', 'DDR5-5200'),
(2, 'architecture', 'Zen 4');

-- ХАРАКТЕРИСТИКИ ДЛЯ МАТЕРИНСКИХ ПЛАТ
-- ASUS ROG STRIX Z790-E (id=3)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(3, 'socket', 'LGA1700'),
(3, 'chipset', 'Z790'),
(3, 'form_factor', 'ATX'),
(3, 'memory_type', 'DDR5'),
(3, 'memory_slots', '4'),
(3, 'max_memory', '128'),
(3, 'pcie_version', '5.0'),
(3, 'wifi', 'true'),
(3, 'm2_slots_count', '4');

INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(3, 'max_memory_speed', '5600'),
(4, 'max_memory_speed', '5600'),
(5, 'max_memory_speed', '2666');

INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(3, 'm2_slots_available', 'true'),
(4, 'm2_slots_available', 'false'),
(5, 'm2_slots_available', 'true');

INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(3, 'memory_form_factor', 'M2, 3.5"'),
(4, 'memory_form_factor', 'M2, 3.5"'),
(5, 'memory_form_factor', '3.5"');

INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(3, 'memory_interface', 'SATA, NVMe'),
(4, 'memory_interface', 'SATA, NVMe'),
(5, 'memory_interface', 'SATA');

-- MSI MAG B650 TOMAHAWK (id=4)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(4, 'socket', 'AM5'),
(4, 'chipset', 'B650'),
(4, 'form_factor', 'ATX'),
(4, 'memory_type', 'DDR5'),
(4, 'memory_slots', '4'),
(4, 'max_memory', '128'),
(4, 'pcie_version', '4.0'),
(4, 'wifi', 'true'),
(4, 'm2_slots_count', '3');

-- Gigabyte B760M DS3H (id=5)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(5, 'socket', 'LGA1700'),
(5, 'chipset', 'B760'),
(5, 'form_factor', 'mATX'),
(5, 'memory_type', 'DDR4'),
(5, 'memory_slots', '2'),
(5, 'max_memory', '64'),
(5, 'pcie_version', '4.0'),
(5, 'wifi', 'false'),
(5, 'm2_slots_count', '2');

-- ХАРАКТЕРИСТИКИ ДЛЯ ОПЕРАТИВНОЙ ПАМЯТИ
-- Kingston Fury Beast DDR5 32GB (id=6)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(6, 'memory_type', 'DDR5'),
(6, 'capacity', '32'),
(6, 'speed', '5600'),
(6, 'form_factor', 'DIMM'),
(6, 'cas_latency', '40'),
(6, 'voltage', '1.25');

-- Samsung DDR4 16GB (id=7)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(7, 'memory_type', 'DDR4'),
(7, 'capacity', '16'),
(7, 'speed', '2666'),
(7, 'form_factor', 'DIMM'),
(7, 'cas_latency', '19'),
(7, 'voltage', '1.2');

-- Corsair Vengeance RGB DDR5 64GB (id=8)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(8, 'memory_type', 'DDR5'),
(8, 'capacity', '64'),
(8, 'speed', '5600'),
(8, 'form_factor', 'DIMM'),
(8, 'cas_latency', '40'),
(8, 'voltage', '1.25');

-- ХАРАКТЕРИСТИКИ ДЛЯ ВИДЕОКАРТ
-- RTX 4080 SUPER (id=9)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(9, 'chipset', 'NVIDIA'),
(9, 'model', 'RTX 4080 SUPER'),
(9, 'memory_size', '16'),
(9, 'memory_type', 'GDDR6X'),
(9, 'tdp', '320'),
(9, 'power_connectors', '12VHPWR'),
(9, 'length', '310'),
(9, 'pcie_version', '4.0');

-- RX 7800 XT (id=10)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(10, 'chipset', 'AMD'),
(10, 'model', 'RX 7800 XT'),
(10, 'memory_size', '16'),
(10, 'memory_type', 'GDDR6'),
(10, 'tdp', '263'),
(10, 'power_connectors', '2x8-pin'),
(10, 'length', '280'),
(10, 'pcie_version', '4.0');

-- RTX 4060 (id=11)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(11, 'chipset', 'NVIDIA'),
(11, 'model', 'RTX 4060'),
(11, 'memory_size', '8'),
(11, 'memory_type', 'GDDR6'),
(11, 'tdp', '115'),
(11, 'power_connectors', '8-pin'),
(11, 'length', '227'),
(11, 'pcie_version', '4.0');

-- ХАРАКТЕРИСТИКИ ДЛЯ НАКОПИТЕЛЕЙ
-- Samsung 980 Pro 1TB (id=12)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(12, 'type', 'SSD'),
(12, 'form_factor', 'M.2'),
(12, 'interface', 'NVMe'),
(12, 'capacity', '1024'),
(12, 'read_speed', '7000'),
(12, 'write_speed', '5000'),
(12, 'technology', 'TLC');

-- WD Blue SN580 2TB (id=13)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(13, 'type', 'SSD'),
(13, 'form_factor', 'M.2'),
(13, 'interface', 'NVMe'),
(13, 'capacity', '2048'),
(13, 'read_speed', '4150'),
(13, 'write_speed', '4150'),
(13, 'technology', 'TLC');

-- Seagate BarraCuda 4TB HDD (id=14)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(14, 'type', 'HDD'),
(14, 'form_factor', '3.5"'),
(14, 'interface', 'SATA'),
(14, 'capacity', '4000'),
(14, 'rpm', '5400'),
(14, 'cache', '256');

INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(12, 'm2_slots_available', ''),
(13, 'm2_slots_available', ''),
(14, 'm2_slots_available', '');

-- ХАРАКТЕРИСТИКИ ДЛЯ БЛОКОВ ПИТАНИЯ
-- be quiet! Dark Power 13 1000W (id=15)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(15, 'power', '1000'),
(15, 'form_factor', 'ATX'),
(15, 'efficiency', '80+ Titanium'),
(15, 'modular', 'full'),
(15, 'fan_size', '135');

-- Corsair RM750e (id=16)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(16, 'power', '750'),
(16, 'form_factor', 'ATX'),
(16, 'efficiency', '80+ Gold'),
(16, 'modular', 'full'),
(16, 'fan_size', '120');

-- Chieftec Proton 600W (id=17)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(17, 'power', '600'),
(17, 'form_factor', 'ATX'),
(17, 'efficiency', '80+ Bronze'),
(17, 'modular', 'no'),
(17, 'fan_size', '120');

-- ХАРАКТЕРИСТИКИ ДЛЯ КОРПУСОВ
-- be quiet! Pure Base 500DX (id=18)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(18, 'form_factor', 'Mid Tower'),
(18, 'mb_support', 'ATX, mATX, ITX'),
(18, 'max_gpu_length', '369'),
(18, 'max_cooler_height', '190'),
(18, 'included_fans', '3');

-- NZXT H7 Flow (id=19)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(19, 'form_factor', 'Mid Tower'),
(19, 'mb_support', 'ATX, mATX, ITX'),
(19, 'max_gpu_length', '400'),
(19, 'max_cooler_height', '185'),
(19, 'included_fans', '2');

-- Deepcool CH370 (id=20)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(20, 'form_factor', 'Mid Tower'),
(20, 'mb_support', 'mATX, ITX'),
(20, 'max_gpu_length', '330'),
(20, 'max_cooler_height', '160'),
(20, 'included_fans', '2');

-- ХАРАКТЕРИСТИКИ ДЛЯ КУЛЕРОВ
-- Noctua NH-D15 (id=21)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(21, 'type', 'air'),
(21, 'socket_support', 'LGA1700, LGA1200, AM5, AM4'),
(21, 'tdp', '220'),
(21, 'height', '165'),
(21, 'fan_count', '2'),
(21, 'noise_level', '24.6');

-- Deepcool AK620 (id=22)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(22, 'type', 'air'),
(22, 'socket_support', 'LGA1700, LGA1200, AM5, AM4'),
(22, 'tdp', '260'),
(22, 'height', '160'),
(22, 'fan_count', '2'),
(22, 'noise_level', '28');

-- Arctic Liquid Freezer III 360 (id=23)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(23, 'type', 'liquid'),
(23, 'socket_support', 'LGA1700, LGA1200, AM5, AM4'),
(23, 'tdp', '300'),
(23, 'radiator_size', '360'),
(23, 'fan_count', '3');

-- ХАРАКТЕРИСТИКИ ДЛЯ ВЕНТИЛЯТОРОВ
-- Arctic P12 PWM PST (id=24)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(24, 'size', '120'),
(24, 'speed', '1800'),
(24, 'airflow', '56.3'),
(24, 'noise', '22.5'),
(24, 'bearing', 'fluid');

-- Noctua NF-A12x25 (id=25)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(25, 'size', '120'),
(25, 'speed', '2000'),
(25, 'airflow', '60.1'),
(25, 'noise', '22.6'),
(25, 'bearing', 'SSO2');

-- be quiet! Silent Wings 4 (id=26)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(26, 'size', '120'),
(26, 'speed', '1600'),
(26, 'airflow', '48.7'),
(26, 'noise', '18.9'),
(26, 'bearing', 'rifle');