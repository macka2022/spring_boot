CREATE  TYPE sexe AS ENUM ('MALE' , 'FEMALE');
ALTER TABLE students ALTER COLUMN sexe TYPE sexe USING sexe::sexe;
