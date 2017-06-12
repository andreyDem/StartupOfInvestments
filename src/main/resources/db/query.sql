SELECT * FROM investments, projects
WHERE investments.ID = investments_projects.ID_INVESTMENTS and projects.ID = investments_projects.ID_PROJECT