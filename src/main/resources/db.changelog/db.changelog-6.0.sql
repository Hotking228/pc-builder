-- Очищаем таблицу перед вставкой
TRUNCATE TABLE category_limit RESTART IDENTITY CASCADE;

-- =====================================================
-- 1. МАТЕРИНСКИЕ ПЛАТЫ (product_id = 3,4,5)
-- =====================================================

-- ASUS ROG STRIX Z790-E (id=3)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(3, 3, 4, 'memory_slots'),      -- RAM: 4 слота
(3, 5, 4,  'm2_slots'),                         -- Storage M.2: 4 шт
(3, 5, 6, 'sata_ports'),                           -- Storage SATA: 6 шт
(3, 4, 2, 'pcie_x16_slots'),                   -- GPU: 2 слота (x16)
(3, 4, 2, 'pcie_x1_slots');                     -- Доп. карты: 2 слота

-- MSI MAG B650 TOMAHAWK (id=4)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(4, 3, 4, 'memory_slots'),      -- RAM: 4 слота
(4, 5, 3, 'm2_slots'),                         -- Storage M.2: 3 шт
(4, 5, 4, 'sata_ports'),                           -- Storage SATA: 4 шт
(4, 4, 1, 'pcie_x16_slots'),                   -- GPU: 1 слот x16
(4, 4, 2, 'pcie_x1_slots');                     -- Доп. карты: 2 слота

-- Gigabyte B760M DS3H (id=5)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(5, 3, 2, 'memory_slots'),      -- RAM: 2 слота
(5, 5, 2, 'm2_slots'),                         -- Storage M.2: 2 шт
(5, 5, 4, 'sata_ports'),                           -- Storage SATA: 4 шт
(5, 4, 1, 'pcie_x16_slots'),                   -- GPU: 1 слот x16
(5, 4, 1, 'pcie_x1_slots');                     -- Доп. карты: 1 слот

-- =====================================================
-- 2. КОРПУСА (product_id = 18,19,20)
-- =====================================================

-- be quiet! Pure Base 500DX (id=18)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(18, 9, 3, 'front_fans'),    -- Fans: 3 шт
(18, 9, 2, 'top_fans'),       -- Fans: 2 шт
(18, 9, 1, 'rear_fans'),           -- Fans: 1 шт
(18, 8, 1, 'cooler_height_limit'),      -- Cooler: 1 шт
(18, 4, 1, 'gpu_length_limit'),      -- GPU: 1 шт
(18, 5, 2, 'hdd_bays'),                             -- Storage HDD: 2 шт
(18, 5, 4, 'ssd_bays');                             -- Storage SSD: 4 шт

-- NZXT H7 Flow (id=19)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(19, 9, 3, 'front_fans'),    -- Fans: 3 шт
(19, 9, 3, 'top_fans'),       -- Fans: 3 шт
(19, 9, 1, 'rear_fans'),           -- Fans: 1 шт
(19, 8, 1, 'cooler_height_limit'),      -- Cooler: 1 шт
(19, 4, 1, 'gpu_length_limit'),      -- GPU: 1 шт
(19, 5, 2, 'hdd_bays'),                             -- Storage HDD: 2 шт
(19, 5, 4, 'ssd_bays');                             -- Storage SSD: 4 шт

-- Deepcool CH370 (id=20)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(20, 9, 2, 'front_fans'),    -- Fans: 2 шт
(20, 9, 2, 'top_fans'),           -- Fans: 2 шт
(20, 9, 1, 'rear_fans'),           -- Fans: 1 шт
(20, 8, 1,  'cooler_height_limit'),      -- Cooler: 1 шт
(20, 4, 1, 'gpu_length_limit'),      -- GPU: 1 шт
(20, 5, 2, 'hdd_bays'),                             -- Storage HDD: 2 шт
(20, 5, 2, 'ssd_bays');                             -- Storage SSD: 2 шт

-- =====================================================
-- 3. БЛОКИ ПИТАНИЯ (product_id = 15,16,17)
-- =====================================================

-- be quiet! Dark Power 13 1000W (id=15)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(15, 4, 3, 'pcie_connectors'),    -- GPU: 3 шт
(15, 4, 1, '12vhpwr_connectors'),           -- GPU: 1 шт
(15, 5, 10, 'sata_connectors'),           -- Storage: 10 шт
(15, 5, 4, 'molex_connectors');         -- Fans: 4 шт

-- Corsair RM750e (id=16)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(16, 4, 2, 'pcie_connectors'),    -- GPU: 2 шт
(16, 5, 6, 'sata_connectors'),            -- Storage: 6 шт
(16, 5, 3, 'molex_connectors');         -- Fans: 3 шт

-- Chieftec Proton 600W (id=17)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(17, 4, 1, 'pcie_connectors'),    -- GPU: 1 шт
(17, 5, 4, 'sata_connectors'),            -- Storage: 4 шт
(17, 5, 2, 'molex_connectors');         -- Fans: 2 шт

-- =====================================================
-- 4. КУЛЕРЫ (product_id = 21,22,23)
-- =====================================================

-- Noctua NH-D15 (id=21)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(21, 9, 2, 'included_fans'),                   -- Fans: 2 шт
(21, 1, 1, 'cpu_support');                   -- CPU: 1 шт

-- Deepcool AK620 (id=22)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(22, 9, 2, 'included_fans');                   -- Fans: 2 шт
(22, 1, 1, 'cpu_support');                   -- CPU: 1 шт

-- Arctic Liquid Freezer III 360 (id=23)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(23, 9, 3, 'included_fans');                   -- Fans: 3 шт
(23, 1, 1, 'cpu_support');                   -- CPU: 1 шт

-- =====================================================
-- 5. ПРОЦЕССОРЫ (product_id = 1,2)
-- =====================================================

-- Intel Core i7-14700K (id=1)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(1, 3, 2, 'memory_channels'),                           -- RAM: 2 канала
(1, 8, 1, 'cooler_count');                       -- Cooler: 1 шт

-- AMD Ryzen 7 7800X3D (id=2)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(2, 3, 2, 'memory_channels'),                           -- RAM: 2 канала
(2, 8, 1, 'cooler_count');                       -- Cooler: 1 шт

-- =====================================================
-- 6. ОПЕРАТИВНАЯ ПАМЯТЬ (product_id = 6,7,8)
-- =====================================================

-- Kingston Fury Beast DDR5 32GB (id=6)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(6, 3, 2, 'modules_in_kit');                       -- RAM: 2 шт в комплекте

-- Corsair Vengeance RGB DDR5 64GB (id=8)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(8, 3, 2, 'modules_in_kit');                       -- RAM: 2 шт в комплекте

-- =====================================================
-- 7. ВИДЕОКАРТЫ (product_id = 9,10,11)
-- =====================================================

-- RTX 4080 SUPER (id=9)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(9, 4, 1, 'gpu_count');    -- GPU: 1 шт

-- RX 7800 XT (id=10)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(10, 4, 1, 'gpu_count'); -- GPU: 1 шт

-- RTX 4060 (id=11)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(11, 4, 1, 'gpu_count');   -- GPU: 1 шт