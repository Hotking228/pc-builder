-- =====================================================
-- ПРОЦЕССОРЫ (category_id = 1)
-- =====================================================
-- Intel Core i7-14700K (product_id=1)
INSERT INTO port (product_id, port_name, portNum) VALUES
(1, 'LGA1700', 1);  -- 1 сокет

-- AMD Ryzen 7 7800X3D (product_id=2)
INSERT INTO port (product_id, port_name, portNum) VALUES
(2, 'AM5', 1);

-- =====================================================
-- МАТЕРИНСКИЕ ПЛАТЫ (category_id = 2)
-- =====================================================
-- ASUS ROG STRIX Z790-E (product_id=3)
INSERT INTO port (product_id, port_name, portNum) VALUES
(3, 'LGA1700', 1),      -- 1 сокет CPU
(3, 'DIMM_DDR5', 4),    -- 4 слота RAM
(3, 'PCIe_x16', 2),     -- 2 слота PCIe x16
(3, 'PCIe_x1', 2),      -- 2 слота PCIe x1
(3, 'M2_NVMe', 4),      -- 4 слота M.2
(3, 'SATA', 6),         -- 6 портов SATA
(3, 'CPU_FAN', 1),      -- 1 разъем для кулера CPU
(3, 'SYS_FAN', 3),      -- 3 разъема для корпусных вентиляторов
(3, 'ATX_24pin', 1),    -- 1 питание MB
(3, 'CPU_8pin', 2);     -- 2 питания CPU

-- MSI MAG B650 TOMAHAWK (product_id=4)
INSERT INTO port (product_id, port_name, portNum) VALUES
(4, 'AM5', 1),
(4, 'DIMM_DDR5', 4),
(4, 'PCIe_x16', 1),
(4, 'PCIe_x4', 1),
(4, 'PCIe_x1', 2),
(4, 'M2_NVMe', 3),
(4, 'SATA', 4),
(4, 'CPU_FAN', 1),
(4, 'SYS_FAN', 3),
(4, 'ATX_24pin', 1),
(4, 'CPU_8pin', 1);

-- Gigabyte B760M DS3H (product_id=5)
INSERT INTO port (product_id, port_name, portNum) VALUES
(5, 'LGA1700', 1),
(5, 'DIMM_DDR4', 2),
(5, 'PCIe_x16', 1),
(5, 'PCIe_x1', 2),
(5, 'M2_NVMe', 2),
(5, 'SATA', 4),
(5, 'CPU_FAN', 1),
(5, 'SYS_FAN', 2),
(5, 'ATX_24pin', 1),
(5, 'CPU_8pin', 1);

-- =====================================================
-- ОПЕРАТИВНАЯ ПАМЯТЬ (category_id = 3)
-- =====================================================
-- Kingston Fury Beast DDR5 (product_id=6)
INSERT INTO port (product_id, port_name, portNum) VALUES
(6, 'DIMM_DDR5', 1);  -- 1 планка занимает 1 слот

-- Samsung DDR4 (product_id=7)
INSERT INTO port (product_id, port_name, portNum) VALUES
(7, 'DIMM_DDR4', 1);

-- Corsair Vengeance DDR5 (product_id=8)
INSERT INTO port (product_id, port_name, portNum) VALUES
(8, 'DIMM_DDR5', 1);

-- =====================================================
-- ВИДЕОКАРТЫ (category_id = 4)
-- =====================================================
-- RTX 4080 SUPER (product_id=9)
INSERT INTO port (product_id, port_name, portNum) VALUES
(9, 'PCIe_x16', 1),     -- занимает 1 слот PCIe x16
(9, 'PCIe_8pin', 3);    -- требует 3 разъема питания

-- RX 7800 XT (product_id=10)
INSERT INTO port (product_id, port_name, portNum) VALUES
(10, 'PCIe_x16', 1),
(10, 'PCIe_8pin', 2);

-- RTX 4060 (product_id=11)
INSERT INTO port (product_id, port_name, portNum) VALUES
(11, 'PCIe_x16', 1),
(11, 'PCIe_8pin', 1);

-- =====================================================
-- НАКОПИТЕЛИ (category_id = 5)
-- =====================================================
-- Samsung 980 Pro (product_id=12) - M.2 NVMe
INSERT INTO port (product_id, port_name, portNum) VALUES
(12, 'M2_NVMe', 1);     -- занимает 1 слот M.2

-- WD Blue SN580 (product_id=13) - M.2 NVMe
INSERT INTO port (product_id, port_name, portNum) VALUES
(13, 'M2_NVMe', 1);

-- Seagate BarraCuda (product_id=14) - SATA HDD
INSERT INTO port (product_id, port_name, portNum) VALUES
(14, 'SATA', 1),        -- занимает 1 SATA порт
(14, 'SATA_power', 1);  -- требует 1 питание SATA

-- =====================================================
-- БЛОКИ ПИТАНИЯ (category_id = 6)
-- =====================================================
-- be quiet! Dark Power 13 (product_id=15)
INSERT INTO port (product_id, port_name, portNum) VALUES
(15, 'ATX_24pin', 1),
(15, 'CPU_8pin', 2),
(15, 'PCIe_8pin', 3),
(15, 'SATA_power', 6),
(15, 'Molex', 2);

-- Corsair RM750e (product_id=16)
INSERT INTO port (product_id, port_name, portNum) VALUES
(16, 'ATX_24pin', 1),
(16, 'CPU_8pin', 2),
(16, 'PCIe_8pin', 2),
(16, 'SATA_power', 4),
(16, 'Molex', 2);

-- Chieftec Proton 600W (product_id=17)
INSERT INTO port (product_id, port_name, portNum) VALUES
(17, 'ATX_24pin', 1),
(17, 'CPU_4pin', 1),
(17, 'PCIe_6pin', 1),
(17, 'SATA_power', 3),
(17, 'Molex', 2);

-- =====================================================
-- КОРПУСА (category_id = 7)
-- =====================================================
-- be quiet! Pure Base 500DX (product_id=18)
INSERT INTO port (product_id, port_name, portNum) VALUES
(18, 'ATX', 1),         -- поддерживает форм-фактор ATX
(18, 'mATX', 1),        -- поддерживает mATX
(18, 'ITX', 1),         -- поддерживает ITX
(18, '120mm_fan', 6),   -- 6 мест для 120мм вентиляторов
(18, 'Drive_bay_35', 2), -- 2 отсека для 3.5" HDD
(18, 'Drive_bay_25', 4); -- 4 отсека для 2.5" SSD

-- NZXT H7 Flow (product_id=19)
INSERT INTO port (product_id, port_name, portNum) VALUES
(19, 'ATX', 1),
(19, 'mATX', 1),
(19, 'ITX', 1),
(19, '120mm_fan', 7),   -- 7 мест для вентиляторов
(19, 'Drive_bay_35', 2),
(19, 'Drive_bay_25', 4);

-- Deepcool CH370 (product_id=20)
INSERT INTO port (product_id, port_name, portNum) VALUES
(20, 'mATX', 1),
(20, 'ITX', 1),
(20, '120mm_fan', 5),   -- 5 мест для вентиляторов
(20, 'Drive_bay_35', 2),
(20, 'Drive_bay_25', 2);

-- =====================================================
-- КУЛЕРЫ (category_id = 8)
-- =====================================================
-- Noctua NH-D15 (product_id=21)
INSERT INTO port (product_id, port_name, portNum) VALUES
(21, 'LGA1700', 1),
(21, 'LGA1200', 1),
(21, 'AM5', 1),
(21, 'AM4', 1),
(21, 'CPU_FAN', 1);     -- требует 1 разъем для вентилятора

-- Deepcool AK620 (product_id=22)
INSERT INTO port (product_id, port_name, portNum) VALUES
(22, 'LGA1700', 1),
(22, 'LGA1200', 1),
(22, 'AM5', 1),
(22, 'AM4', 1),
(22, 'CPU_FAN', 1);

-- Arctic Liquid Freezer III 360 (product_id=23)
INSERT INTO port (product_id, port_name, portNum) VALUES
(23, 'LGA1700', 1),
(23, 'LGA1200', 1),
(23, 'AM5', 1),
(23, 'AM4', 1),
(23, 'CPU_FAN', 1),
(23, 'AIO_PUMP', 1),
(23, '120mm_fan', 3);   -- 3 вентилятора на радиаторе

-- =====================================================
-- ВЕНТИЛЯТОРЫ (category_id = 9)
-- =====================================================
-- Arctic P12 (product_id=24)
INSERT INTO port (product_id, port_name, portNum) VALUES
(24, '120mm_fan', 1),   -- занимает 1 место в корпусе
(24, 'SYS_FAN', 1);     -- требует 1 разъем на MB

-- Noctua NF-A12x25 (product_id=25)
INSERT INTO port (product_id, port_name, portNum) VALUES
(25, '120mm_fan', 1),
(25, 'SYS_FAN', 1);

-- be quiet! Silent Wings 4 (product_id=26)
INSERT INTO port (product_id, port_name, portNum) VALUES
(26, '120mm_fan', 1),
(26, 'SYS_FAN', 1);


-- Термопасты занимают место между CPU и кулером, но физических портов не имеют
-- Добавим специальный порт "thermal_interface" для совместимости
INSERT INTO port (product_id, port_name, portNum) VALUES
(28, 'thermal_interface', 1),  -- Arctic MX-6
(29, 'thermal_interface', 1),  -- Thermal Grizzly Kryonaut
(30, 'thermal_interface', 1),  -- Noctua NT-H1
(31, 'thermal_interface', 1);  -- Thermalright TF8

-- Creative Sound Blaster AE-5 (32)
INSERT INTO port (product_id, port_name, portNum) VALUES
(32, 'PCIe_x1', 1),     -- занимает 1 слот PCIe x1
(32, 'SYS_FAN', 1);     -- может требовать питание (опционально)

-- ASUS Xonar SE (33)
INSERT INTO port (product_id, port_name, portNum) VALUES
(33, 'PCIe_x1', 1);

-- Creative Sound BlasterX G6 (34) - внешняя USB
INSERT INTO port (product_id, port_name, portNum) VALUES
(34, 'USB', 1);         -- подключается по USB

-- EVGA Nu Audio (35)
INSERT INTO port (product_id, port_name, portNum) VALUES
(35, 'PCIe_x1', 1),
(35, 'PCIe_6pin', 1);   -- требует дополнительное питание

-- ASUS PCE-AX3000 (36) - PCIe Wi-Fi
INSERT INTO port (product_id, port_name, portNum) VALUES
(36, 'PCIe_x1', 1);

-- TP-Link Archer TX50E (37) - PCIe Wi-Fi
INSERT INTO port (product_id, port_name, portNum) VALUES
(37, 'PCIe_x1', 1);

-- Intel Gigabit CT (38) - PCIe Ethernet
INSERT INTO port (product_id, port_name, portNum) VALUES
(38, 'PCIe_x1', 1);

-- TP-Link UE300 (39) - USB Ethernet
INSERT INTO port (product_id, port_name, portNum) VALUES
(39, 'USB', 1);

-- ASUS Hyper M.2 x16 (40) - PCIe плата с 4 M.2 слотами
INSERT INTO port (product_id, port_name, portNum) VALUES
(40, 'PCIe_x16', 1),    -- занимает 1 слот PCIe x16
(40, 'M2_NVMe', 4);     -- предоставляет 4 слота M.2

-- SilverStone EC04-P (41) - PCIe USB контроллер
INSERT INTO port (product_id, port_name, portNum) VALUES
(41, 'PCIe_x1', 1),
(41, 'USB', 4);         -- предоставляет 4 USB порта

-- SYBA SI-PEX40064 (42) - PCIe SATA контроллер
INSERT INTO port (product_id, port_name, portNum) VALUES
(42, 'PCIe_x1', 1),
(42, 'SATA', 4);        -- предоставляет 4 SATA порта

-- StarTech PEXSAT34 (43) - PCIe SATA контроллер
INSERT INTO port (product_id, port_name, portNum) VALUES
(43, 'PCIe_x2', 1),
(43, 'SATA', 4);

-- ASUS DRW-24D5MT (44) - DVD-RW
INSERT INTO port (product_id, port_name, portNum) VALUES
(44, 'SATA', 1),        -- интерфейс SATA
(44, 'SATA_power', 1),  -- питание SATA
(44, 'Drive_bay_525', 1); -- занимает отсек 5.25"

-- LG WH14NS40 (45) - Blu-ray
INSERT INTO port (product_id, port_name, portNum) VALUES
(45, 'SATA', 1),
(45, 'SATA_power', 1),
(45, 'Drive_bay_525', 1);

-- Pioneer BDR-212DBK (46) - Blu-ray
INSERT INTO port (product_id, port_name, portNum) VALUES
(46, 'SATA', 1),
(46, 'SATA_power', 1),
(46, 'Drive_bay_525', 1);

-- Apple USB SuperDrive (47) - внешний DVD
INSERT INTO port (product_id, port_name, portNum) VALUES
(47, 'USB', 1);         -- подключается по USB