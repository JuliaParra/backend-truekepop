-- Limpiar tablas previas (esto es opcional y debe ser lo primero si es necesario)
DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM roles;

-- Añadir la columna 'username' si no existe
ALTER TABLE users ADD COLUMN IF NOT EXISTS username VARCHAR(255);

-- Insertar roles
INSERT INTO roles (id_role, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (2, 'ROLE_ADMIN');

-- Insertar usuarios
INSERT INTO users (id_user, email, password, username) 
VALUES (1,  'user@example.com', '$2a$10$EIXZHy2uM.LlBGQKQy2mLuvB9aT6qUJn6xDuv3X0rQ8IHTG9LqF4a', 'user123');
INSERT INTO users (id_user, email, password, username) 
VALUES (2, 'manoli@example.com', '$2a$12$tjBqHbRqNTq2deiHD9ydSuJ3NXWYHQIb4q2JvqjESKZeAI5NQ00oS', 'manoli');

-- Asignar roles a los usuarios
INSERT INTO user_roles (role_id, user_id) VALUES (1, 1);  -- Asigna el rol "USER" (ROLE_ID = 1) al primer usuario
INSERT INTO user_roles (role_id, user_id) VALUES (2, 2); 

-- Insertar categorías (usando la tabla CATEGORIA)
INSERT INTO CATEGORIA (ID, NOMBRE) VALUES
(1, 'Urgente'),
(2, 'Directo'),
(3, 'Escucho Ofertas'),
(4, 'Novedades'),
(5, 'Favoritos');



-- Insertar truekes
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES, OWNER_NAME) VALUES
(1, 'Bicicleta Vintage', 'Cambio bicicleta vintage por monopatín en perfecto estado.', 'https://cdn.pixabay.com/photo/2012/12/23/00/07/bicycle-71925_1280.jpg', 'Madrid, España', 'Monopatín de alta calidad', 'trueke', 1, 25, 'Carlos Sánchez'),
(2, 'Cámara DSLR', 'Cambio cámara DSLR por equipo de fotografía profesional.', 'https://cdn.pixabay.com/photo/2016/09/30/12/02/camera-1705135_1280.jpg', 'Barcelona, España', 'Accesorios de Fotografía', 'oferta', 2, 40, 'Ana García'),
(3, 'Smartphone Samsung', 'Vendo smartphone Samsung Galaxy en excelente estado.', 'https://cdn.pixabay.com/photo/2023/01/07/05/25/smartphone-7702594_1280.jpg', 'Valencia, España', 'Accesorios para Smartphone', 'oferta', 3, 30, 'Luis Fernández'),
(4, 'Patín Eléctrico', 'Patín eléctrico usado, perfecto para desplazamientos cortos.', 'https://cdn.pixabay.com/photo/2022/08/04/16/09/electric-scooter-7365011_1280.jpg', 'Sevilla, España', 'Bicicleta o Scooter', 'trueke', 4, 15, 'María López');

-- Insertar truekes urgentes
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES, OWNER_NAME) VALUES
(5, 'Bicicleta de Montaña', 'Necesito cambiarla urgentemente por una eléctrica.', 'https://cdn.pixabay.com/photo/2017/08/08/10/17/saddle-2610930_1280.jpg', 'Granada, España', 'Bicicleta Eléctrica', 'urgente', 1, 20, 'José Pérez'),
(6, 'Set de Jardinería', 'Cambio urgente por set de herramientas eléctricas.', 'https://cdn.pixabay.com/photo/2014/05/21/18/08/gardening-tools-350087_1280.jpg', 'Alicante, España', 'Herramientas Eléctricas', 'urgente', 1, 10, 'Laura Martínez'),
(7, 'Sofá 3 Plazas', 'Urge cambio por sofá cama.', 'https://cdn.pixabay.com/photo/2017/08/06/15/44/house-2593570_1280.jpg', 'Madrid, España', 'Sofá Cama', 'urgente', 1, 15, 'Pedro Ruiz'),
(8, 'Portátil HP', 'Cambio urgente por un portátil gaming.', 'https://cdn.pixabay.com/photo/2021/12/08/19/34/laptop-6856557_1280.jpg', 'Sevilla, España', 'Portátil Gaming', 'urgente', 1, 30, 'Sofía Rodríguez');

-- Insertar truekes directos
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES, OWNER_NAME) VALUES
(9, 'Moto de 50cc', 'Cambio directo por bicicleta.', 'https://cdn.pixabay.com/photo/2015/08/27/09/06/bike-909690_1280.jpg', 'Málaga, España', 'Bicicleta', 'directo', 2, 18, 'David Jiménez'),
(10, 'Colección de Libros', 'Cambio directo por cómics clásicos.', 'https://cdn.pixabay.com/photo/2016/02/16/21/07/books-1204029_1280.jpg', 'Valencia, España', 'Cómics Clásicos', 'directo', 2, 12, 'Claudia Martínez'),
(11, 'Guitarra Eléctrica', 'Cambio directo por teclado musical.', 'https://cdn.pixabay.com/photo/2017/08/06/07/28/guitar-2589863_1280.jpg', 'Barcelona, España', 'Teclado Musical', 'directo', 2, 25, 'Fernando López'),
(12, 'Consola de Videojuegos', 'Cambio directo por juegos para PS5.', 'v', 'Madrid, España', 'Juegos PS5', 'directo', 2, 35, 'Lucía Moreno');

-- Insertar truekes de ofertas
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES, OWNER_NAME) VALUES
(13, 'Cámara Reflex', 'Escucho ofertas, cambio por equipo fotográfico.', 'https://cdn.pixabay.com/photo/2020/11/05/23/48/camera-5716511_1280.jpg', 'Bilbao, España', 'Equipo Fotográfico', 'oferta', 3, 28, 'Isabel Herrera'),
(14, 'Altavoces Bluetooth', 'Escucho ofertas, cambio por auriculares.', 'https://cdn.pixabay.com/photo/2016/11/29/04/40/accessories-1867368_1280.jpg', 'Sevilla, España', 'Auriculares', 'oferta', 3, 22, 'Javier González'),
(15, 'Lámpara Vintage', 'Escucho ofertas, cambio por lámpara de pie moderna.', 'https://cdn.pixabay.com/photo/2020/01/01/17/40/lamp-4734053_960_720.jpg', 'Granada, España', 'Lámpara de Pie', 'oferta', 3, 17, 'Patricia Ruiz'),
(16, 'Reloj Inteligente', 'Escucho ofertas, cambio por accesorios deportivos.', 'https://cdn.pixabay.com/photo/2023/10/07/14/24/smartwatch-8300238_1280.jpg', 'Valencia, España', 'Accesorios Deportivos', 'oferta', 3, 33, 'Raúl Álvarez');

-- Insertar truekes de novedades
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES, OWNER_NAME) VALUES
(17, 'Mesa de Centro', 'Nuevo trueke: mesa de centro por estantería.', 'https://cdn.pixabay.com/photo/2017/03/03/13/12/solid-2113987_1280.jpg', 'Madrid, España', 'Estantería', 'novedades', 4, 14, 'Marta Sánchez'),
(18, 'Set de Camping', 'Nuevo trueke: set de camping por tienda de campaña.', 'https://cdn.pixabay.com/photo/2012/10/05/01/44/sleeping-bag-59653_960_720.jpg', 'Barcelona, España', 'Tienda de Campaña', 'novedades', 4, 19, 'Fernando López'),
(19, 'Tablet Samsung', 'Nuevo trueke: tablet por e-reader.', 'https://cdn.pixabay.com/photo/2014/11/12/15/48/apple-528461_1280.jpg', 'Valencia, España', 'E-Reader', 'novedades', 4, 25, 'Alicia Gómez'),
(20, 'Cafetera Espresso', 'Nuevo trueke: cafetera por licuadora.', 'https://cdn.pixabay.com/photo/2022/09/14/18/32/cafe-7454951_1280.jpg', 'Sevilla, España', 'Licuadora', 'novedades', 4, 31, 'David Sánchez');

-- Insertar truekes favoritos
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES, OWNER_NAME) VALUES
(21, 'Silla Gaming', 'Favorito: cambio por escritorio ajustable.', '/src/assets/images/caravana.jpg', 'Murcia, España', 'Escritorio Ajustable', 'favoritos', 5, 50, 'José Fernández'),
(22, 'Cámara GoPro', 'Favorito: cambio por cámara deportiva.', '/src/assets/images/caravana.jpg', 'Bilbao, España', 'Cámara Deportiva', 'favoritos', 5, 47, 'Clara Martínez'),
(23, 'Barbacoa Portátil', 'Favorito: cambio por utensilios de cocina.', '/src/assets/images/caravana.jpg', 'Madrid, España', 'Utensilios de Cocina', 'favoritos', 5, 38, 'Laura Pérez'),
(24, 'Monitor Curvo', 'Favorito: cambio por monitor ultra wide.', '/src/assets/images/caravana.jpg', 'Valencia, España', 'Monitor Ultra Wide', 'favoritos', 5, 42, 'Santiago López');

-- Insertar registros en la tabla 'USER_FAVORITES'
INSERT INTO USER_FAVORITES (USER_ID, TRUEKE_ID) VALUES
(1, 1),
(1, 2);
