CREATE TABLE medical_records (
id BIGSERIAL PRIMARY KEY,patient_id BIGINT NOT NULL,diagnosis TEXT NOT NULL,treatment TEXT,record_date TIMESTAMP NOT NULL DEFAULT NOW(),
FOREIGN KEY (patient_id) REFERENCES patients(id)
);