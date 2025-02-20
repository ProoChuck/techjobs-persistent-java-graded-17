--Part 1
--CREATE TABLE job (
--  id INT,
--  employer VARCHAR(255),
--  name VARCHAR(255),
--  skills VARCHAR(255)
--);

SELECT
   COLUMN_NAME,
   DATA_TYPE
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'job';
--Part 2
SELECT name
FROM employer
WHERE location = "St. Louis City";
--Part 3
DROP TABLE job;
--Part 4
SELECT * FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;