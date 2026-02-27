-- =====================================================
-- ПРАВИЛА ДЛЯ ТЕРМОПАСТ (category_id = 15)
-- =====================================================
-- Термопаста совместима со всеми процессорами и кулерами (всегда)
-- Но можно добавить правило "не проводит ток" для жидкого металла

-- =====================================================
-- ПРАВИЛА ДЛЯ ЗВУКОВЫХ КАРТ (category_id = 16)
-- =====================================================
-- Звуковая карта -> Материнская плата: интерфейс должен поддерживаться
INSERT INTO compatibility_rule (source_category_id, target_category_id, operator, source_spec_key, target_spec_key) VALUES
(11, 2, 'IN', 'interface', 'pcie_slots');  -- PCIe/USB

-- =====================================================
-- ПРАВИЛА ДЛЯ СЕТЕВЫХ КАРТ (category_id = 17)
-- =====================================================
-- Сетевая карта -> Материнская плата: интерфейс
INSERT INTO compatibility_rule (source_category_id, target_category_id, operator, source_spec_key, target_spec_key) VALUES
(12, 2, 'IN', 'interface', 'pcie_slots');  -- PCIe/USB

-- =====================================================
-- ПРАВИЛА ДЛЯ КОНТРОЛЛЕРОВ (category_id = 18)
-- =====================================================
-- Контроллер -> Материнская плата: интерфейс
INSERT INTO compatibility_rule (source_category_id, target_category_id, operator, source_spec_key, target_spec_key) VALUES
(13, 2, 'IN', 'interface', 'pcie_slots');

-- Контроллер SATA -> Материнская плата (дополнительные порты всегда ок)

-- =====================================================
-- ПРАВИЛА ДЛЯ ОПТИЧЕСКИХ ПРИВОДОВ (category_id = 19)
-- =====================================================
-- Привод -> Корпус: форм-фактор 5.25" должен поддерживаться
INSERT INTO compatibility_rule (source_category_id, target_category_id, operator, source_spec_key, target_spec_key) VALUES
(14, 7, 'IN', 'form_factor', 'drive_bays_525');

-- Привод -> Материнская плата: интерфейс SATA/USB
INSERT INTO compatibility_rule (source_category_id, target_category_id, operator, source_spec_key, target_spec_key) VALUES
(14, 2, 'IN', 'interface', 'memory_interface');