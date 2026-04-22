START TRANSACTION;

-- ⚠️ Limpieza previa (evita duplicados y errores FK)
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE `user`;
TRUNCATE TABLE `lawyer`;
TRUNCATE TABLE `role`;

SET FOREIGN_KEY_CHECKS = 1;

-- 1) Roles (SIN ID manual)
INSERT INTO `role` (`name`) VALUES
('ADMIN'),
('LAWYER');

-- 2) Lawyers
INSERT INTO `lawyer` (
  `firstName`,
  `lastName`,
  `phone`,
  `barAssociationNumber`,
  `specialization`
) VALUES
('Laura', 'Martinez', '600111222', 'ICAM-10001', 'Civil'),
('Carlos', 'Ruiz', '600222333', 'ICAM-10002', 'Mercantil'),
('Elena', 'Santos', '600333444', 'ICAM-10003', 'Laboral'),
('Javier', 'Lopez', '600444555', 'ICAM-10004', 'Penal');

-- 3) Users
-- IMPORTANTE: asumimos IDs generados automáticamente:
-- roles: 1=ADMIN, 2=PRINCIPAL_LAWYER, 3=LAWYER
-- lawyers: 1..4

INSERT INTO `user` (
  `username`,
  `email`,
  `password`,
  `enabled`,
  `role_id`,
  `lawyer_id`
) VALUES
('admin.laura', 'laura.admin@legaltrack.com', '$2a$10$7QJ8nQ7Y2y8I2Q6kJv0Qx.hv/6V6XQx6x6j2f2M5s8QnY3gF4xJGa', true, 1, 1),
('carlos.principal', 'carlos.principal@legaltrack.com', '$2a$10$6x9dG9t8Jf7YbP0nM9l6COjM3m7g1SxwN2r8V1pL0zD3uQ9eB0s1K', true, 1, 2),
('elena.lawyer', 'elena.lawyer@legaltrack.com', '$2a$10$8fR5m2Vq4kY7nL1zX0s9AOr5B2tJ6hM8wQ1pE3cD7uN4aF2gH9jLq', true, 2, 3),
('javier.lawyer', 'javier.lawyer@legaltrack.com', '$2a$10$5bN2xL8pQ3mV7tR1yH6eKOz4C9dJ2sW0uF5aG8kM1nP3qR6tY9uI.', true, 2, 4);

COMMIT;