CREATE DATABASE IF NOT EXISTS CINES;
USE CINES;

CREATE TABLE IF NOT EXISTS CINES.categorias (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS CINES.artistas (
	dni BIGINT PRIMARY KEY,
    nombre VARCHAR (70) NOT NULL,
    apellido Varchar(70) NULL,
    tipo VARCHAR(50),
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS CINES.peliculas (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) UNIQUE NOT NULL,
    sipnosis TEXT,
    duracion INT NOT NULL,
    categoria_id BIGINT,
    CONSTRAINT categorias_fk_peliculas FOREIGN KEY (categoria_id) REFERENCES categorias(id)
    on delete cascade
    on update cascade
);

CREATE TABLE IF NOT EXISTS CINES.obras (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    descripcion TEXT,
    duracion INT NOT NULL,
    categoria_id BIGINT,
    CONSTRAINT categorias_fk_obras FOREIGN KEY (categoria_id) REFERENCES categorias(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS CINES.eventos_urbanos (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR (200) NOT NULL,
    descripcion TEXT,
    fecha DATE NOT NULL,
    lugar VARCHAR (200) NOT NULL,
    categoria_id BIGINT,
    CONSTRAINT categoria_fk_eventos_urbanos FOREIGN KEY (categoria_id) REFERENCES categorias(id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS CINES.participaciones (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    artista_dni BIGINT,
    tipo_evento ENUM('pelicula', 'obra', 'evento'),
    evento_id BIGINT,
    CONSTRAINT artista_participaciones FOREIGN KEY (artista_dni) REFERENCES artistas(dni)
    ON DELETE CASCADE
);

INSERT INTO categorias (nombre) VALUES
('Acción'),
('Comedia'),
('Drama'),
('Terror'),
('Ciencia Ficción'),
('Romance'),
('Documental'),
('Animación'),
('Musical'),
('Thriller'),
('Fantasía'),
('Aventura');

INSERT INTO artistas (dni, nombre, apellido, tipo, descripcion) VALUES
(75839410, 'Carlos', 'Méndez', 'Actor', 'Actor colombiano de cine y teatro'),
(80427139, 'Laura', 'González', 'Actriz', 'Actriz de drama y televisión'),
(71920384, 'Samuel', 'Rojas', 'Cantante', 'Artista urbano y cantante de reggaetón'),
(69374820, 'Andrea', 'Silva', 'Bailarina', 'Bailarina contemporánea'),
(76839275, 'Mario', 'Torres', 'Mago', 'Mago profesional con shows callejeros'),
(78293160, 'Valentina', 'Pérez', 'Actriz', 'Actriz de comedia y teatro musical'),
(71592047, 'Santiago', 'Ruiz', 'Rapero', 'Freestyler y rapero urbano'),
(79910345, 'Camila', 'Romero', 'Pintora', 'Artista plástica y muralista'),
(78345612, 'David', 'Martínez', 'Actor', 'Actor de películas independientes'),
(74718290, 'Isabela', 'León', 'Actriz', 'Actriz de telenovelas y teatro'),
(73491822, 'Julián', 'Castro', 'Músico', 'Instrumentista callejero'),
(79013248, 'Manuela', 'Díaz', 'Performista', 'Artista de performance urbano');

INSERT INTO peliculas (titulo, sipnosis, duracion, categoria_id) VALUES
('El Último Viaje', 'Una odisea espacial más allá del sistema solar', 120, 5),
('Amor de Barrio', 'Romance urbano entre dos mundos opuestos', 95, 6),
('Ríe que Ríe', 'Una comedia absurda sobre la vida moderna', 100, 2),
('Bajo Tierra', 'Thriller psicológico en un búnker abandonado', 110, 10),
('El Despertar', 'Drama existencial sobre la vida después del coma', 115, 3),
('Calle 13: La Película', 'Documental musical de artistas urbanos', 80, 7),
('Sombra Letal', 'Asesinos silenciosos al acecho', 105, 1),
('Horizonte Perdido', 'Exploradores en un mundo paralelo', 130, 11),
('Terror en el Lago', 'Un grupo de amigos enfrentan una maldición', 90, 4),
('Conexión Virtual', 'Un hacker descubre un complot global', 125, 5),
('Ritmo Urbano', 'Historias cruzadas en una ciudad musical', 100, 8),
('Noche de Gala', 'Un musical de teatro con sorpresas', 110, 9);

INSERT INTO obras (titulo, descripcion, duracion, categoria_id) VALUES
('Voces Silenciadas', 'Obra teatral sobre los derechos humanos', 90, 3),
('El Puente', 'Drama familiar entre generaciones opuestas', 95, 3),
('Luz Roja', 'Performance contemporáneo con luces y sombras', 80, 9),
('Eco del Silencio', 'Obra de teatro sin diálogo verbal', 75, 7),
('La Última Nota', 'Musical inspirado en artistas urbanos', 100, 9),
('Raíces', 'Obra sobre la identidad cultural latinoamericana', 85, 11),
('Mujer de Fuego', 'Teatro feminista con danza', 95, 6),
('Ciudad Sombra', 'Thriller social con escenografía minimalista', 100, 10),
('Ruptura', 'Obra contemporánea con elementos visuales digitales', 90, 8),
('Reflejos', 'Monólogo introspectivo', 60, 3),
('Callejón', 'Historias entrecruzadas en una ciudad marginal', 105, 1),
('Camino de Luz', 'Obra inspiradora de superación personal', 100, 12);

INSERT INTO eventos_urbanos (titulo, descripcion, fecha, lugar, categoria_id) VALUES
('Festival de Callejeros', 'Evento masivo de arte urbano en espacios abiertos', '2025-07-10', 'Plaza Bolívar', 1),
('Noche de Freestyle', 'Batalla de raperos en vivo', '2025-08-05', 'Parque de los Deseos', 2),
('Arte al Paso', 'Pintura en vivo en estaciones de TransMilenio', '2025-07-15', 'Calle 72', 3),
('Break & Beats', 'Encuentro de breakdance y DJ locales', '2025-07-20', 'Centro Cultural La Media Torta', 4),
('Mural Fest', 'Intervención artística de muros', '2025-07-12', 'Ciudad Salitre', 5),
('Cine Callejero', 'Proyección de cortos en espacio público', '2025-07-25', 'Plaza San Victorino', 6),
('Teatro Rodante', 'Obra itinerante en diferentes barrios', '2025-07-30', 'Barrios Unidos', 7),
('Ritmo Local', 'Festival de música urbana', '2025-08-02', 'Parque Simón Bolívar', 8),
('Performance Abierto', 'Expresiones urbanas libres', '2025-07-18', 'Zona T', 9),
('Lectura Libre', 'Narraciones y poesía urbana', '2025-07-22', 'Universidad Nacional', 10),
('Danza en la Calle', 'Talleres abiertos de danza contemporánea', '2025-07-28', 'La Candelaria', 11),
('Arte Nocturno', 'Exposición de arte con luz y sombra', '2025-08-01', 'Zona Rosa', 12);

INSERT INTO participaciones (artista_dni, tipo_evento, evento_id) VALUES
(69374820, 'pelicula', 1),
(71592047, 'pelicula', 2),
(71920384, 'evento', 1),
(73491822, 'evento', 4),
(74718290, 'obra', 3),
(75839410, 'obra', 5),
(76839275, 'evento', 2),
(78293160, 'evento', 3),
(78345612, 'pelicula', 4),
(79013248, 'obra', 6),
(79910345, 'evento', 7),
(80427139, 'pelicula', 6);

/*
select * from artistas;
select peliculas.*, categorias.nombre from peliculas
left join categorias on peliculas.categoria_id = categorias.id
order by categorias.id asc;