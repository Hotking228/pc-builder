-- =====================================================
-- ПРАВИЛА ПОДКЛЮЧЕНИЯ
-- =====================================================

-- Процессор -> Материнская плата
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(1, 2, 'LGA1700'),
(1, 2, 'AM5');

-- Кулер -> Процессор
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(8, 1, 'LGA1700'),
(8, 1, 'AM5'),
(8, 1, 'AM4'),
(8, 1, 'LGA1200');

-- Кулер -> Материнская плата (питание)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(8, 2, 'CPU_FAN'),
(8, 2, 'AIO_PUMP');

-- Оперативная память -> Материнская плата
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(3, 2, 'DIMM_DDR5'),
(3, 2, 'DIMM_DDR4');

-- Видеокарта -> Материнская плата
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(4, 2, 'PCIe_x16');

-- Видеокарта -> Блок питания
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(4, 6, 'PCIe_8pin'),
(4, 6, 'PCIe_6pin');

-- Накопители -> Материнская плата
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(5, 2, 'M2_NVMe'),
(5, 2, 'SATA');

-- Накопители -> Блок питания
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(5, 6, 'SATA_power');

-- Блок питания -> Материнская плата
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(6, 2, 'ATX_24pin'),
(6, 2, 'CPU_8pin'),
(6, 2, 'CPU_4pin');

-- Корпус -> Материнская плата (поддержка форм-фактора)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(7, 2, 'ATX'),
(7, 2, 'mATX'),
(7, 2, 'ITX');

-- Вентиляторы -> Корпус
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(9, 7, '120mm_fan');

-- Вентиляторы -> Материнская плата
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(9, 2, 'SYS_FAN');

-- Материнская плата -> Корпус (установка)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(2, 7, 'ATX'),
(2, 7, 'mATX'),
(2, 7, 'ITX');

-- =====================================================
-- КАТЕГОРИЯ 10: Термопасты (thermal_pastes)
-- =====================================================
-- Термопаста (10) -> Процессор (1)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(10, 1, 'thermal_interface');

-- Термопаста (10) -> Кулер (8)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(10, 8, 'thermal_interface');

-- =====================================================
-- КАТЕГОРИЯ 11: Звуковые карты (sound_cards)
-- =====================================================
-- Звуковая карта (11) -> Материнская плата (2)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(11, 2, 'PCIe_x1'),
(11, 2, 'USB');

-- Звуковая карта (11) -> Блок питания (6) (для моделей с доп. питанием)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(11, 6, 'PCIe_6pin');

-- =====================================================
-- КАТЕГОРИЯ 12: Сетевые карты (network_cards)
-- =====================================================
-- Сетевая карта (12) -> Материнская плата (2)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(12, 2, 'PCIe_x1'),
(12, 2, 'USB');

-- =====================================================
-- КАТЕГОРИЯ 13: Контроллеры (controllers)
-- =====================================================
-- Контроллер (13) -> Материнская плата (2)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(13, 2, 'PCIe_x1'),
(13, 2, 'PCIe_x2'),
(13, 2, 'PCIe_x4'),
(13, 2, 'PCIe_x16');

-- Контроллер (13) -> Блок питания (6) (если требует питания)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(13, 6, 'SATA_power'),
(13, 6, 'Molex');

-- Контроллер предоставляет новые порты (это уже в port таблице)
-- Но правила для подключения к контроллеру:
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
-- Накопители (5) могут подключаться к SATA контроллеру (13)
(5, 13, 'SATA'),
-- Накопители (5) могут подключаться к M.2 контроллеру (13)
(5, 13, 'M2_NVMe'),

-- =====================================================
-- КАТЕГОРИЯ 14: Оптические приводы (optical_drives)
-- =====================================================
-- Привод (14) -> Материнская плата (2)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(14, 2, 'SATA'),
(14, 2, 'USB');

-- Привод (14) -> Блок питания (6)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(14, 6, 'SATA_power');

-- Привод (14) -> Корпус (7)
INSERT INTO connection_rule (source_category_id, target_category_id, port_name) VALUES
(14, 7, 'Drive_bay_525');