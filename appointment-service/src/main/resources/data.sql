CREATE TABLE IF NOT EXISTS appointment (
                                           id SERIAL PRIMARY KEY,
                                           appointment_date DATE,
                                           time TIME,
                                           doctor_name VARCHAR(255),
    patient_name VARCHAR(255),
    doctor_id INT,
    patient_id INT,
    status VARCHAR(50)
    );

INSERT INTO appointment (appointment_date, time, doctor_name, patient_name, doctor_id, patient_id, status)
VALUES
    ('2025-03-01', '09:00:00', 'Dr. Smith', 'John Doe', 1, 1, 'Scheduled');
