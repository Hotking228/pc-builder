-- =====================================================
-- ТЕРМОПАСТЫ (product_id = 28-31)
-- =====================================================
-- Arctic MX-6 (id=28)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(28, 'thermal_conductivity', '7.5'),      -- Вт/мК
(28, 'volume', '4'),                       -- граммы
(28, 'composition', 'Carbon Micro-Particles'),
(28, 'application_method', 'spatula'),
(28, 'electrical_conductivity', 'false');  -- не проводит ток

-- Thermal Grizzly Kryonaut (id=29)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(29, 'thermal_conductivity', '12.5'),
(29, 'volume', '1'),
(29, 'composition', 'Zinc Oxide'),
(29, 'application_method', 'spatula'),
(29, 'electrical_conductivity', 'false');

-- Noctua NT-H1 (id=30)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(30, 'thermal_conductivity', '8.5'),
(30, 'volume', '3.5'),
(30, 'composition', 'Metal Oxide'),
(30, 'application_method', 'syringe'),
(30, 'electrical_conductivity', 'false');

-- Thermalright TF8 (id=31)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(31, 'thermal_conductivity', '13.8'),
(31, 'volume', '2'),
(31, 'composition', 'Carbon-Based'),
(31, 'application_method', 'syringe'),
(31, 'electrical_conductivity', 'false');

-- =====================================================
-- ЗВУКОВЫЕ КАРТЫ (product_id = 32-36)
-- =====================================================
-- Creative Sound Blaster AE-5 (id=32)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(32, 'interface', 'PCIe'),
(32, 'bit_depth', '32'),
(32, 'sample_rate', '384'),
(32, 'snr', '122'),                        -- дБ
(32, 'outputs', '5.1'),
(32, 'headphone_amp', 'true'),
(32, 'chipset', 'Sound Core3D');

-- ASUS Xonar SE (id=33)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(33, 'interface', 'PCIe'),
(33, 'bit_depth', '24'),
(33, 'sample_rate', '192'),
(33, 'snr', '116'),
(33, 'outputs', '7.1'),
(33, 'headphone_amp', 'false'),
(33, 'chipset', 'C-Media 6620A');

-- Creative Sound BlasterX G6 (id=34)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(34, 'interface', 'USB'),
(34, 'bit_depth', '32'),
(34, 'sample_rate', '384'),
(34, 'snr', '130'),
(34, 'outputs', '7.1'),
(34, 'headphone_amp', 'true'),
(34, 'chipset', 'Sound Core3D');

-- EVGA Nu Audio (id=35)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(35, 'interface', 'PCIe'),
(35, 'bit_depth', '24'),
(35, 'sample_rate', '192'),
(35, 'snr', '124'),
(35, 'outputs', '7.1'),
(35, 'headphone_amp', 'true'),
(35, 'chipset', 'XMOS');

-- =====================================================
-- СЕТЕВЫЕ КАРТЫ (product_id = 36-38)
-- =====================================================
-- ASUS PCE-AX3000 (id=36)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(36, 'interface', 'PCIe'),
(36, 'wifi_standard', 'WiFi 6'),
(36, 'max_speed', '3000'),                  -- Мбит/с
(36, 'frequency', '2.4,5'),
(36, 'bluetooth', '5.0'),
(36, 'antenna_count', '2');

-- TP-Link Archer TX50E (id=37)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(37, 'interface', 'PCIe'),
(37, 'wifi_standard', 'WiFi 6'),
(37, 'max_speed', '2400'),
(37, 'frequency', '2.4,5'),
(37, 'bluetooth', '5.0'),
(37, 'antenna_count', '2');

-- Intel Gigabit CT (id=38)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(38, 'interface', 'PCIe'),
(38, 'type', 'Ethernet'),
(38, 'max_speed', '1000'),                  -- 1 Гбит/с
(38, 'chipset', 'Intel 82574L');

-- TP-Link UE300 (id=39)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(39, 'interface', 'USB 3.0'),
(39, 'type', 'Ethernet'),
(39, 'max_speed', '1000'),
(39, 'chipset', 'Realtek RTL8153');

-- =====================================================
-- КОНТРОЛЛЕРЫ (product_id = 40-42)
-- =====================================================
-- ASUS Hyper M.2 x16 (id=40)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(40, 'interface', 'PCIe 3.0 x16'),
(40, 'type', 'M.2 NVMe'),
(40, 'ports', '4'),
(40, 'raid_support', 'true'),
(40, 'chipset', 'ASMedia');

-- SilverStone EC04-P (id=41)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(41, 'interface', 'PCIe 2.0 x1'),
(41, 'type', 'USB 3.0'),
(41, 'ports', '4'),
(41, 'internal_ports', '2'),
(41, 'chipset', 'NEC');

-- SYBA SI-PEX40064 (id=42)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(42, 'interface', 'PCIe 2.0 x1'),
(42, 'type', 'SATA III'),
(42, 'ports', '4'),
(42, 'raid_support', 'false'),
(42, 'chipset', 'Marvell 88SE9215');

-- StarTech PEXSAT34 (id=43)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(43, 'interface', 'PCIe 2.0 x2'),
(43, 'type', 'eSATA'),
(43, 'ports', '4'),
(43, 'raid_support', 'true'),
(43, 'chipset', 'Marvell');

-- =====================================================
-- ОПТИЧЕСКИЕ ПРИВОДЫ (product_id = 44-46)
-- =====================================================
-- ASUS DRW-24D5MT (id=44)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(44, 'interface', 'SATA'),
(44, 'type', 'DVD-RW'),
(44, 'formats', 'DVD±R, DVD±RW, CD-R, CD-RW'),
(44, 'read_speed_dvd', '16x'),
(44, 'write_speed_dvd', '24x'),
(44, 'form_factor', '5.25"');

-- LG WH14NS40 (id=45)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(45, 'interface', 'SATA'),
(45, 'type', 'Blu-ray RW'),
(45, 'formats', 'BD-R, BD-RE, DVD±R, DVD±RW, CD-R, CD-RW'),
(45, 'read_speed_bd', '14x'),
(45, 'write_speed_bd', '14x'),
(45, 'form_factor', '5.25"');

-- Pioneer BDR-212DBK (id=46)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(46, 'interface', 'SATA'),
(46, 'type', 'Blu-ray RW'),
(46, 'formats', 'BD-R, BD-RE, DVD±R, DVD±RW, CD-R, CD-RW'),
(46, 'read_speed_bd', '16x'),
(46, 'write_speed_bd', '16x'),
(46, 'form_factor', '5.25"');

-- Apple USB SuperDrive (id=47)
INSERT INTO product_specification (product_id, spec_key, spec_value) VALUES
(47, 'interface', 'USB'),
(47, 'type', 'DVD-RW'),
(47, 'formats', 'DVD±R, DVD±RW, CD-R, CD-RW'),
(47, 'form_factor', 'external');