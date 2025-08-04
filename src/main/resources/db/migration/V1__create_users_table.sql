-- Criação da tabela
CREATE TABLE tb_users (
    id BINARY(16) NOT NULL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Inserção de usuários iniciais
INSERT INTO tb_users (id, username, email) VALUES
  (UNHEX(REPLACE('11111111-1111-1111-1111-111111111111', '-', '')), 'alice', 'alice@example.com'),
  (UNHEX(REPLACE('22222222-2222-2222-2222-222222222222', '-', '')), 'bob', 'bob@example.com'),
  (UNHEX(REPLACE('33333333-3333-3333-3333-333333333333', '-', '')), 'carol', 'carol@example.com'),
  (UNHEX(REPLACE('44444444-4444-4444-4444-444444444444', '-', '')), 'dave', 'dave@example.com'),
  (UNHEX(REPLACE('55555555-5555-5555-5555-555555555555', '-', '')), 'eve', 'eve@example.com');
