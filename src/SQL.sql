-- Table des devises
CREATE TABLE devises (
    devise_id int PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(3) NOT NULL
);

-- Table des comptes
CREATE TABLE comptes (
    compte_id int PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    second_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    creation_date DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    devise_id INT REFERENCES devises(devise_id) 
);

-- Table des transactions
CREATE TABLE transactions (
    transation_id int PRIMARY KEY,
    status BOOLEAN NOT NULL,
    compte_id INT REFERENCES comptes(compte_id)
);


--INSERT

INSERT INTO devises (devise_id, name, code) VALUES
    (1, 'Euro', 'EUR'),
    (2, 'Dollar américain', 'USD'),
    (3, 'Livre sterling', 'GBP');

INSERT INTO comptes (compte_id, first_name, second_name, age, creation_date, email, password, devise_id) VALUES
    (1, 'John', 'Doe', 30, '2023-01-01', 'john.doe@email.com', 'password123', 1), -- Référence à Euro
    (2, 'Alice', 'Smith', 25, '2023-02-15', 'alice.smith@email.com', 'securePwd', 2), -- Référence à Dollar américain
    (3, 'Bob', 'Johnson', 35, '2023-03-10', 'bob.johnson@email.com', 'mySecret', 3); -- Référence à Livre sterling

INSERT INTO transactions (transation_id, status, compte_id) VALUES
    (1, true, 1), 
    (2, false, 2),
    (3, true, 3); 
