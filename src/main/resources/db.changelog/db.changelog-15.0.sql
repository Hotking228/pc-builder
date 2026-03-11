CREATE TABLE possible_ports(
    id BIGSERIAL PRIMARY KEY,
    category_id BIGINT REFERENCES product_category (id),
    port_name VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    is_required BOOLEAN DEFAULT FALSE,
    UNIQUE(category_id, port_name)
);

-- =====================================================
-- КАТЕГОРИЯ 1: Процессоры (cpus)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(1, 'LGA1700', 'Сокет для Intel 12-14 поколения', false),
(1, 'LGA1200', 'Сокет для Intel 10-11 поколения', false),
(1, 'AM5', 'Сокет для AMD Ryzen 7000', false),
(1, 'AM4', 'Сокет для AMD Ryzen (старые)', false),
(1, 'thermal_interface', 'Место нанесения термопасты', true);

-- =====================================================
-- КАТЕГОРИЯ 2: Материнские платы (motherboards)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
-- Сокеты
(2, 'LGA1700', 'Сокет для Intel', false),
(2, 'LGA1200', 'Сокет для Intel', false),
(2, 'AM5', 'Сокет для AMD', false),
(2, 'AM4', 'Сокет для AMD', false),
-- Слоты RAM
(2, 'DIMM_DDR5', 'Слот для DDR5', false),
(2, 'DIMM_DDR4', 'Слот для DDR4', false),
-- Слоты расширения
(2, 'PCIe_x16', 'Слот PCIe x16', false),
(2, 'PCIe_x8', 'Слот PCIe x8', false),
(2, 'PCIe_x4', 'Слот PCIe x4', false),
(2, 'PCIe_x1', 'Слот PCIe x1', false),
(2, 'PCI', 'Старый слот PCI', false),
-- Разъёмы для накопителей
(2, 'M2_NVMe', 'Слот M.2 для NVMe', false),
(2, 'M2_SATA', 'Слот M.2 для SATA', false),
(2, 'SATA', 'Порт SATA', false),
-- Разъёмы питания
(2, 'ATX_24pin', 'Основное питание', true),
(2, 'CPU_8pin', 'Питание процессора', false),
(2, 'CPU_4pin', 'Питание процессора', false),
-- Разъёмы для кулеров
(2, 'CPU_FAN', 'Разъём для кулера CPU', true),
(2, 'SYS_FAN', 'Разъём для корпусного вентилятора', false),
(2, 'AIO_PUMP', 'Разъём для помпы СЖО', false),
-- Разъёмы передней панели
(2, 'USB_3.0_header', 'Разъём USB 3.0 на корпусе', false),
(2, 'USB_2.0_header', 'Разъём USB 2.0 на корпусе', false),
(2, 'Audio_header', 'Разъём аудио на корпусе', false);

-- =====================================================
-- КАТЕГОРИЯ 3: Оперативная память (ram)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(3, 'DIMM_DDR5', 'Модуль DDR5', true),
(3, 'DIMM_DDR4', 'Модуль DDR4', true);

-- =====================================================
-- КАТЕГОРИЯ 4: Видеокарты (gpus)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(4, 'PCIe_x16', 'Интерфейс подключения', true),
(4, 'PCIe_8pin', 'Питание 8-pin', false),
(4, 'PCIe_6pin', 'Питание 6-pin', false);

-- =====================================================
-- КАТЕГОРИЯ 5: Накопители (storage)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(5, 'M2_NVMe', 'M.2 NVMe', false),
(5, 'M2_SATA', 'M.2 SATA', false),
(5, 'SATA', 'SATA интерфейс', false),
(5, 'SATA_power', 'Питание SATA', true);

-- =====================================================
-- КАТЕГОРИЯ 6: Блоки питания (psus)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(6, 'ATX_24pin', 'Питание MB', true),
(6, 'CPU_8pin', 'Питание CPU', false),
(6, 'CPU_4pin', 'Питание CPU', false),
(6, 'PCIe_8pin', 'Питание GPU', false),
(6, 'PCIe_6pin', 'Питание GPU', false),
(6, 'SATA_power', 'Питание SATA', false),
(6, 'Molex', 'Питание Molex', false);

-- =====================================================
-- КАТЕГОРИЯ 7: Корпуса (cases)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
-- Поддержка форм-факторов
(7, 'ATX', 'Поддержка ATX', false),
(7, 'mATX', 'Поддержка mATX', false),
(7, 'ITX', 'Поддержка ITX', false),
-- Места для вентиляторов
(7, '120mm_fan', 'Место для 120мм вентилятора', false),
(7, '140mm_fan', 'Место для 140мм вентилятора', false),
-- Отсеки для дисков
(7, 'Drive_bay_35', 'Отсек для 3.5" диска', false),
(7, 'Drive_bay_25', 'Отсек для 2.5" диска', false),
(7, 'Drive_bay_525', 'Отсек для 5.25" привода', false);

-- =====================================================
-- КАТЕГОРИЯ 8: Кулеры (cpu_coolers)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(8, 'LGA1700', 'Поддержка сокета Intel', false),
(8, 'LGA1200', 'Поддержка сокета Intel', false),
(8, 'AM5', 'Поддержка сокета AMD', false),
(8, 'AM4', 'Поддержка сокета AMD', false),
(8, 'CPU_FAN', 'Разъём питания', true),
(8, 'AIO_PUMP', 'Разъём помпы', false);

-- =====================================================
-- КАТЕГОРИЯ 9: Вентиляторы (case_fans)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(9, '120mm_fan', 'Размер 120мм', true),
(9, '140mm_fan', 'Размер 140мм', false),
(9, 'SYS_FAN', 'Разъём питания', true);

-- =====================================================
-- КАТЕГОРИЯ 10: Термопасты (thermal_pastes)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(10, 'thermal_interface', 'Термоинтерфейс', true);

-- =====================================================
-- КАТЕГОРИЯ 11: Звуковые карты (sound_cards)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(11, 'PCIe_x1', 'Интерфейс PCIe', false),
(11, 'USB', 'Интерфейс USB', false),
(11, 'PCIe_6pin', 'Дополнительное питание', false);

-- =====================================================
-- КАТЕГОРИЯ 12: Сетевые карты (network_cards)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(12, 'PCIe_x1', 'Интерфейс PCIe', false),
(12, 'USB', 'Интерфейс USB', false);

-- =====================================================
-- КАТЕГОРИЯ 13: Контроллеры (controllers)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(13, 'PCIe_x1', 'Интерфейс PCIe', false),
(13, 'PCIe_x4', 'Интерфейс PCIe x4', false),
(13, 'PCIe_x16', 'Интерфейс PCIe x16', false),
(13, 'SATA', 'Порты SATA (предоставляет)', false),
(13, 'M2_NVMe', 'Слоты M.2 (предоставляет)', false),
(13, 'USB', 'Порты USB (предоставляет)', false),
(13, 'SATA_power', 'Питание', false),
(13, 'Molex', 'Питание', false);

-- =====================================================
-- КАТЕГОРИЯ 14: Оптические приводы (optical_drives)
-- =====================================================
INSERT INTO possible_ports (category_id, port_name, description, is_required) VALUES
(14, 'SATA', 'Интерфейс SATA', false),
(14, 'USB', 'Интерфейс USB', false),
(14, 'SATA_power', 'Питание SATA', true),
(14, 'Drive_bay_525', 'Отсек 5.25"', false);