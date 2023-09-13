CREATE TABLE records (
--- in sql server change `AUTO_INCREMENT` to `IDENTITY(1,1)`
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    points INT
);