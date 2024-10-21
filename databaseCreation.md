database creation

```sql
CREATE TABLE tipo_alimento (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE unidade_media (
    id SERIAL PRIMARY KEY,
    unidade_media VARCHAR(10) NOT NULL
);

CREATE TABLE alimento (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    tipo_alimento_id INT NOT NULL,
    CONSTRAINT fk_tipo_alimento FOREIGN KEY (tipo_alimento_id) REFERENCES tipo_alimento (id)
);

CREATE TABLE nutriente (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    unidade_media_id INT NOT NULL,
    CONSTRAINT fk_unidade_media FOREIGN KEY (unidade_media_id) REFERENCES unidade_media (id)
);

CREATE TABLE alimento_nutriente (
    id SERIAL PRIMARY KEY,
    alimento_id INT NOT NULL,
    nutriente_id INT NOT NULL,
    valor DOUBLE PRECISION NOT NULL,
    CONSTRAINT fk_alimento FOREIGN KEY (alimento_id) REFERENCES alimento (id),
    CONSTRAINT fk_nutriente FOREIGN KEY (nutriente_id) REFERENCES nutriente (id)
);