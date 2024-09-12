CREATE TABLE IF NOT EXISTS students(
        id  UUID PRIMARY KEY NOT NULL,
        nom VARCHAR(40) NOT NULL,
        prenom VARCHAR(50) NOT NULL,
        dateNaiss VARCHAR(20) NOT NULL,
        filiere VARCHAR(80) NOT NULL,
        niveau VARCHAR(10) NOT NULL,
        email VARCHAR(50) NOT NULL UNIQUE,
        sexe VARCHAR(6) NOT NULL CHECK(sexe='MALE' OR sexe='FEMALE' OR sexe='Male' OR sexe='Female')
)