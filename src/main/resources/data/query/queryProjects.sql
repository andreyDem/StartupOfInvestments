# CREATE
INSERT INTO projects  (NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, ID_USER) VALUES (?, ?, ?, ?, ?);

# FIND_BY_ID
SELECT USERS.NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, USERS.NAME
FROM projects PROJECTS
  JOIN users USERS ON PROJECTS.ID_USER = USERS.ID
WHERE PROJECTS.ID = ?;

# FIND_BY_NAME
SELECT USERS.NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, USERS.NAME
FROM projects PROJECTS
  JOIN users USERS ON PROJECTS.ID_USER = USERS.ID
WHERE PROJECTS.NAME = ?;

# UPDATE
UPDATE projects SET NAME = ?, SOLUTION = ?, FINAL_COST = ?, ASSEMBLE_COST = ?, ID_USER = ? WHERE ID = ?;

# DELETE
DELETE FROM projects WHERE ID = ?;

# FIND_ALL
SELECT * FROM projects;

# GET_LAST_INSERTED
SELECT LAST_INSERT_ID()