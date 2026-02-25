-- =====================================================
-- 1. ПРОЦЕССОРЫ (product_id = 1,2)
-- =====================================================

-- Intel Core i7-14700K (id=1)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(1, 3, 2,  'memory_channels'),           -- RAM: 2 канала
(1, 3, 128,  'max_memory_capacity'),    -- RAM: до 128ГБ
(1, 3, 1,  'memory_types_supported'),      -- RAM: DDR4/DDR5
(1, 8, 1,  'cooler_count'),                    -- Cooler: 1 шт
(1, 4, 1,  'integrated_gpu');               -- GPU: 1 встроенное

-- AMD Ryzen 7 7800X3D (id=2)
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(2, 3, 2, 'memory_channels'),           -- RAM: 2 канала
(2, 3, 128, 'max_memory_capacity'),    -- RAM: до 128ГБ
(2, 3, 1, 'memory_types_supported'),      -- RAM: DDR5 только
(2, 8, 1, 'cooler_count'),                    -- Cooler: 1 шт
(2, 4, 1, 'integrated_gpu');       -- GPU: 1 встроенное

-- =====================================================
-- 2. Добавим недостающие лимиты для других продуктов
-- =====================================================

-- Материнская плата ASUS Z790 (id=3) - ДОПОЛНИТЕЛЬНЫЕ ЛИМИТЫ
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(3, 1, 1, 'cpu_count'),                    -- CPU: 1 шт
(3, 1, 1, 'cpu_generations'),     -- CPU: 12-14 gen
(3, 3, 128, 'max_ram_capacity');           -- RAM: до 128ГБ

-- Материнская плата MSI B650 (id=4) - ДОПОЛНИТЕЛЬНЫЕ ЛИМИТЫ
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(4, 1, 1, 'cpu_count'),                    -- CPU: 1 шт
(4, 1, 1, 'cpu_generations'),     -- CPU: Ryzen 7000
(4, 3, 128, 'max_ram_capacity');           -- RAM: до 128ГБ

-- Материнская плата Gigabyte B760M (id=5) - ДОПОЛНИТЕЛЬНЫЕ ЛИМИТЫ
INSERT INTO category_limit (product_id, category_id, max_count, spec_key) VALUES
(5, 1, 1, 'cpu_count'),                    -- CPU: 1 шт
(5, 1, 1, 'cpu_generations'),     -- CPU: 12-14 gen
(5, 3, 64, 'max_ram_capacity');            -- RAM: до 64ГБ