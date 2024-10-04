-- Insertar roles

INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
;

-- Insertar usuarios
INSERT INTO users (id_user, email, PASSWORD) VALUES
(1, 'manoli@example.com', '$2a$12$94zEKKFf.nTMYJcaHUADoOsQpyDo/.6T.JHMmUb7P35PAOPNC6ZjK');

-- Asignar roles a usuarios (usando la tabla USER_ROLES)
INSERT INTO USER_ROLES (ROLE_ID, USER_ID) VALUES (2, 1);

-- Insertar categorías (usando la tabla CATEGORIA)
INSERT INTO CATEGORIA (ID, NOMBRE) VALUES
(1, 'Urgente'),
(2, 'Directo'),
(3, 'Escucho Ofertas'),
(4, 'Novedades'),
(5, 'Favoritos');

-- Insertar truekes
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES) VALUES
(1, 'Bicicleta Vintage', 'Cambio bicicleta vintage por monopatín en perfecto estado.', '/src/assets/images/caravana.jpg', 'Madrid, España', 'Monopatín de alta calidad', 'trueke', 1, 25),
(2, 'Cámara DSLR', 'Cambio cámara DSLR por equipo de fotografía profesional.', '/src/assets/images/caravana.jpg', 'Barcelona, España', 'Accesorios de Fotografía', 'oferta', 2, 40),
(3, 'Smartphone Samsung', 'Vendo smartphone Samsung Galaxy en excelente estado.', '/src/assets/images/caravana.jpg', 'Valencia, España', 'Accesorios para Smartphone', 'oferta', 3, 30),
(4, 'Patín Eléctrico', 'Patín eléctrico usado, perfecto para desplazamientos cortos.', '/src/assets/images/caravana.jpg', 'Sevilla, España', 'Bicicleta o Scooter', 'trueke', 4, 15);

-- Insertar truekes urgentes
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES) VALUES
(5, 'Bicicleta de Montaña', 'Necesito cambiarla urgentemente por una eléctrica.', '/src/assets/images/caravana.jpg', 'Granada, España', 'Bicicleta Eléctrica', 'urgente', 1, 20),
(6, 'Set de Jardinería', 'Cambio urgente por set de herramientas eléctricas.', '/src/assets/images/caravana.jpg', 'Alicante, España', 'Herramientas Eléctricas', 'urgente', 1, 10),
(7, 'Sofá 3 Plazas', 'Urge cambio por sofá cama.', '/src/assets/images/caravana.jpg', 'Madrid, España', 'Sofá Cama', 'urgente', 1, 15),
(8, 'Portátil HP', 'Cambio urgente por un portátil gaming.', '/src/assets/images/caravana.jpg', 'Sevilla, España', 'Portátil Gaming', 'urgente', 1, 30);

-- Insertar truekes directos
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES) VALUES
(9, 'Patinete Eléctrico', 'Cambio directo por bicicleta.', '/src/assets/images/caravana.jpg', 'Málaga, España', 'Bicicleta', 'directo', 2, 18),
(10, 'Colección de Libros', 'Cambio directo por cómics clásicos.', '/src/assets/images/caravana.jpg', 'Valencia, España', 'Cómics Clásicos', 'directo', 2, 12),
(11, 'Guitarra Eléctrica', 'Cambio directo por teclado musical.', '/src/assets/images/caravana.jpg', 'Barcelona, España', 'Teclado Musical', 'directo', 2, 25),
(12, 'Consola de Videojuegos', 'Cambio directo por juegos para PS5.', '/src/assets/images/caravana.jpg', 'Madrid, España', 'Juegos PS5', 'directo', 2, 35);

-- Insertar truekes de ofertas
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES) VALUES
(13, 'Cámara Reflex', 'Escucho ofertas, cambio por equipo fotográfico.', '/src/assets/images/caravana.jpg', 'Bilbao, España', 'Equipo Fotográfico', 'oferta', 3, 28),
(14, 'Altavoces Bluetooth', 'Escucho ofertas, cambio por auriculares.', '/src/assets/images/caravana.jpg', 'Sevilla, España', 'Auriculares', 'oferta', 3, 22),
(15, 'Lámpara Vintage', 'Escucho ofertas, cambio por lámpara de pie moderna.', '/src/assets/images/caravana.jpg', 'Granada, España', 'Lámpara de Pie', 'oferta', 3, 17),
(16, 'Reloj Inteligente', 'Escucho ofertas, cambio por accesorios deportivos.', '/src/assets/images/caravana.jpg', 'Valencia, España', 'Accesorios Deportivos', 'oferta', 3, 33);

-- Insertar truekes de novedades
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES) VALUES
(17, 'Mesa de Centro', 'Nuevo trueke: mesa de centro por estantería.', '/src/assets/images/caravana.jpg', 'Madrid, España', 'Estantería', 'novedades', 4, 14),
(18, 'Set de Camping', 'Nuevo trueke: set de camping por tienda de campaña.', '/src/assets/images/caravana.jpg', 'Barcelona, España', 'Tienda de Campaña', 'novedades', 4, 19),
(19, 'Tablet Samsung', 'Nuevo trueke: tablet por e-reader.', '/src/assets/images/caravana.jpg', 'Valencia, España', 'E-Reader', 'novedades', 4, 25),
(20, 'Cafetera Espresso', 'Nuevo trueke: cafetera por licuadora.', '/src/assets/images/caravana.jpg', 'Sevilla, España', 'Licuadora', 'novedades', 4, 31);

-- Insertar truekes favoritos
INSERT INTO TRUEKE (ID, NAME, DESCRIPTION, IMAGE, LOCATION, DESIRED_ITEM, TYPE, CATEGORIA_ID, LIKES) VALUES
(21, 'Silla Gaming', 'Favorito: cambio por escritorio ajustable.', '/src/assets/images/caravana.jpg', 'Murcia, España', 'Escritorio Ajustable', 'favoritos', 5, 50),
(22, 'Cámara GoPro', 'Favorito: cambio por cámara deportiva.', '/src/assets/images/caravana.jpg', 'Bilbao, España', 'Cámara Deportiva', 'favoritos', 5, 47),
(23, 'Barbacoa Portátil', 'Favorito: cambio por utensilios de cocina.', '/src/assets/images/caravana.jpg', 'Madrid, España', 'Utensilios de Cocina', 'favoritos', 5, 38),
(24, 'Monitor Curvo', 'Favorito: cambio por monitor ultra wide.', '/src/assets/images/caravana.jpg', 'Valencia, España', 'Monitor Ultra Wide', 'favoritos', 5, 42);

-- Insertar registros en la tabla 'USER_FAVORITES'
INSERT INTO USER_FAVORITES (USER_ID, TRUEKE_ID) VALUES
(1, 1),
(1, 2);
