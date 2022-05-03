CREATE TABLE IF NOT EXISTS types(
    id INTEGER UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS categories (
    id INTEGER UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
    id INTEGER UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    image VARCHAR(200) NOT NULL,
    weight FLOAT NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY(category_id) REFERENCES categories(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS addresses(
    id INTEGER UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    street VARCHAR(100) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(200) NOT NULL,
    district VARCHAR(100) NOT NULL,
    zip_code INTEGER NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS users(
    id INTEGER UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    phone VARCHAR(11) NOT NULL,
    role ENUM('customer', 'employee', 'admin'),
    address_id INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY(address_id) REFERENCES addresses(id)
);

CREATE TABLE IF NOT EXISTS tickets(
    id INTEGER UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(500) NOT NULL,
    state VARCHAR(30) NOT NULL,
    solution VARCHAR(500), # Pode ser null pois se for um elogio, não existe solução
    product_id INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY(product_id) REFERENCES products(id) ON DELETE CASCADE,
    type_id INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY(type_id) REFERENCES types(id) ON DELETE CASCADE,
    user_id INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

INSERT INTO users (name, surname, email, password, cpf, phone, role, address_id) VALUES 
  ('Bob','Brown','bob@gmail.com','senhacliente',1234567890,41999887,'customer',1),
  ('Mary','Brown','mary@gmail.com','senhafuncionario',1234567890,41999887,'employee',2),
  ('Peter','Brown','peter@gmail.com','senhaadmin',1234567890,41999887,'admin',3);
  
INSERT INTO addresses (street, number, complement, district, zip_code, city, state) VALUES 
  ('Rua uma','123','nenhum','Centro',80000123,'Curitiba','Paraná'),
  ('Rua duas','456','nenhum','Centro',80000123,'Florianópolis','Santa Catarina'),
  ('Rua três','789','nenhum','Centro',80000123,'São Paulo','São Paulo');