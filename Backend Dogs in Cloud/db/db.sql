CREATE TABLE users(
	id BIGSERIAL PRIMARY KEY,
	email VARCHAR(255) NOT NULL UNIQUE,
	name VARCHAR(120) NOT NULL, 
	lastname VARCHAR(120) NOT NULL,
	dni VARCHAR(120) NOT NULL,
	edad VARCHAR(120) NOT NULL,
	phone VARCHAR(80) NULL,
	image VARCHAR(255) NULL,
	password VARCHAR (255) NOT NULL,
	is_available BOOLEAN NULL,
	session_token VARCHAR(255) NULL,
	created_at TIMESTAMP (0) NOT NULL,
	updated_at TIMESTAMP (0) NOT NULL
);

INSERT INTO users(
	email,
	name,
	lastname,
	dni,
    edad,
	password,
	created_at,
	updated_at
)
VALUES(
	'ricardo@gmail.com',
	'Ricardo',
	'Gonzales',
	'72177185',
    '24',
	'1234',
	'2022-01-13',
	'2022-01-13'
);