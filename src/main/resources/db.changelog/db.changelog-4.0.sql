-- Очищаем таблицу перед вставкой
TRUNCATE TABLE compatibility_rule RESTART IDENTITY CASCADE;

-- =====================================================
-- 1. ПРАВИЛА ДЛЯ ПРОЦЕССОРА (source_category_id = 1)
-- =====================================================

-- Процессор -> Материнская плата: сокет должен совпадать
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (1, 2, 'EQUALS', 'socket', 'socket', NULL);

-- Процессор -> Материнская плата: поддержка памяти должна совпадать (DDR4/DDR5)
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (1, 2, 'CONTAINS', 'memory_type', 'memory_type', NULL);

-- Процессор -> Кулер: сокет должен поддерживаться кулером
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (1, 8, 'CONTAINS', 'socket', 'socket_support', NULL);

-- Процессор -> Кулер: TDP кулера должен быть >= TDP процессора
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (1, 8, 'GREATER_THAN_OR_EQUAL', 'tdp', 'tdp', NULL);

-- =====================================================
-- 2. ПРАВИЛА ДЛЯ МАТЕРИНСКОЙ ПЛАТЫ (source_category_id = 2)
-- =====================================================

-- Материнская плата -> Процессор: сокет должен совпадать (обратное правило)
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (2, 1, 'EQUALS', 'socket', 'socket', NULL);

-- Материнская плата -> Оперативная память: тип памяти должен совпадать
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (2, 3, 'EQUALS', 'memory_type', 'memory_type', NULL);

-- Материнская плата -> Оперативная память: частота памяти должна поддерживаться
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (2, 3, 'LESS_THAN_OR_EQUAL', 'max_memory_speed', 'speed', NULL);

-- Материнская плата -> Корпус: форм-фактор должен поддерживаться корпусом
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (2, 7, 'CONTAINS', 'form_factor', 'mb_support', NULL);

-- Материнская плата -> Видеокарта: версия PCIe должна быть совместима (обратное правило)
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (2, 4, 'GREATER_THAN_OR_EQUAL', 'pcie_version', 'pcie_version', NULL);

-- Материнская плата -> Накопитель M.2: поддержка NVMe/SATA (сложное правило, пока упростим)
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (2, 5, 'EQUALS', 'm2_slots_count', 'm2_slots_available', NULL);

-- =====================================================
-- 3. ПРАВИЛА ДЛЯ ОПЕРАТИВНОЙ ПАМЯТИ (source_category_id = 3)
-- =====================================================

-- Оперативная память -> Материнская плата: тип должен совпадать
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (3, 2, 'EQUALS', 'memory_type', 'memory_type', NULL);

-- Оперативная память -> Процессор: тип должен поддерживаться
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (3, 1, 'CONTAINS', 'memory_type', 'memory_type', NULL);

-- =====================================================
-- 4. ПРАВИЛА ДЛЯ ВИДЕОКАРТЫ (source_category_id = 4)
-- =====================================================

-- Видеокарта -> Материнская плата: версия PCIe должна поддерживаться
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (4, 2, 'LESS_THAN_OR_EQUAL', 'pcie_version', 'pcie_version', NULL);

-- Видеокарта -> Корпус: длина должна помещаться в корпус
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (4, 7, 'LESS_THAN_OR_EQUAL', 'length', 'max_gpu_length', NULL);

-- Видеокарта -> Блок питания: TDP видеокарты должен быть меньше мощности БП
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (4, 6, 'LESS_THAN', 'tdp', 'power', NULL);

-- Видеокарта -> Блок питания: нужные разъемы питания должны быть у БП
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (4, 6, 'CONTAINS', 'power_connectors', 'connectors_available', NULL);

-- =====================================================
-- 5. ПРАВИЛА ДЛЯ НАКОПИТЕЛЯ (source_category_id = 5)
-- =====================================================

-- Накопитель -> Материнская плата: интерфейс должен поддерживаться
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (5, 2, 'CONTAINS', 'interface', 'storage_support', NULL);

-- Накопитель -> Корпус: форм-фактор должен поддерживаться корпусом (2.5", 3.5", M.2)
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (5, 7, 'CONTAINS', 'form_factor', 'drive_bays', NULL);

-- =====================================================
-- 6. ПРАВИЛА ДЛЯ БЛОКА ПИТАНИЯ (source_category_id = 6)
-- =====================================================

-- Блок питания -> Видеокарта: мощность БП должна быть больше TDP видеокарты
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (6, 4, 'GREATER_THAN', 'power', 'tdp', NULL);

-- Блок питания -> Корпус: форм-фактор должен помещаться в корпус
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (6, 7, 'EQUALS', 'form_factor', 'psu_support', NULL);

-- =====================================================
-- 7. ПРАВИЛА ДЛЯ КОРПУСА (source_category_id = 7)
-- =====================================================

-- Корпус -> Материнская плата: поддержка форм-фактора
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (7, 2, 'CONTAINS', 'mb_support', 'form_factor', NULL);

-- Корпус -> Видеокарта: максимальная длина
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (7, 4, 'GREATER_THAN_OR_EQUAL', 'max_gpu_length', 'length', NULL);

-- Корпус -> Кулер: максимальная высота кулера
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (7, 8, 'GREATER_THAN_OR_EQUAL', 'max_cooler_height', 'height', NULL);

-- Корпус -> Блок питания: поддержка форм-фактора БП
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (7, 6, 'CONTAINS', 'psu_support', 'form_factor', NULL);

-- =====================================================
-- 8. ПРАВИЛА ДЛЯ КУЛЕРА (source_category_id = 8)
-- =====================================================

-- Кулер -> Процессор: поддержка сокета
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (8, 1, 'CONTAINS', 'socket_support', 'socket', NULL);

-- Кулер -> Корпус: высота должна помещаться
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (8, 7, 'LESS_THAN_OR_EQUAL', 'height', 'max_cooler_height', NULL);

-- =====================================================
-- 9. ПРАВИЛА ДЛЯ ВЕНТИЛЯТОРА (source_category_id = 9)
-- =====================================================

-- Вентилятор -> Корпус: размер должен подходить к посадочным местам
INSERT INTO compatibility_rule
    (source_category_id, target_category_id, operator, source_spec_key, target_spec_key, value)
VALUES
    (9, 7, 'IN', 'size', 'fan_support', NULL);