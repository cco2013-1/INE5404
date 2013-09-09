CREATE TABLE dados_pessoais (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	nome TEXT,
	cpf TEXT,
	rg TEXT,
	data_nasc TEXT
);

CREATE TABLE dados_contato (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	tel_fixo TEXT,
	tel_cel TEXT,
	email TEXT
);

CREATE TABLE profissional (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	id_dados_pessoais INTEGER,
	id_dados_contato INTEGER,
	FOREIGN KEY(id_dados_pessoais) REFERENCES dados_pessoais(id),
	FOREIGN KEY(id_dados_contato) REFERENCES dados_contato(id)
);

CREATE TABLE paciente (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	id_dados_pessoais INTEGER,
	id_dados_contato INTEGER,
	FOREIGN KEY(id_dados_pessoais) REFERENCES dados_pessoais(id),
	FOREIGN KEY(id_dados_contato) REFERENCES dados_contato(id)
);

CREATE TABLE sala (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	nome TEXT
);

CREATE TABLE especialidade (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	descricao TEXT
);

CREATE TABLE tratamento (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	descricao TEXT,
	id_especialidade INTEGER,
	FOREIGN KEY(id_especialidade) REFERENCES especialidade(id)
);

CREATE TABLE horario (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	horario_inicio TEXT,
	horario_fim TEXT,
	id_profissional INTEGER,
	id_tratamento INTEGER,
	id_sala INTEGER,
	comentarios TEXT,
	FOREIGN KEY(id_profissional) REFERENCES profissional(id),
	FOREIGN KEY(id_tratamento) REFERENCES tratamento(id),
	FOREIGN KEY(id_sala) REFERENCES sala(id)
);

CREATE TABLE paciente_horario (
	id_horario INTEGER,
	id_paciente INTEGER,
	FOREIGN KEY(id_horario) REFERENCES horario(id),
	FOREIGN KEY(id_paciente) REFERENCES paciente(id)
);