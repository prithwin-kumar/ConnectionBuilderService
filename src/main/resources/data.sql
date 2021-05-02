DROP TABLE IF EXISTS flight_schedule;

CREATE TABLE flight_schedule (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  flight_no VARCHAR(10) NOT NULL,
  dept_airport VARCHAR(10) NOT NULL,
  arr_airport VARCHAR(10) NOT NULL,
  dept_time VARCHAR(10) NOT NULL,
  arr_time VARCHAR(10) NOT NULL
);

INSERT INTO flight_schedule (flight_no, dept_airport, arr_airport, dept_time, arr_time) VALUES
  ('EK 501', 'BOM', 'DXB', '4:30', '6:00'),
  ('EK 2137', 'BOM', 'DXB', '5:10', '6:50'),
  ('EK 507', 'BOM', 'DXB', '15:35', '17:20'),
  ('EK 503', 'BOM', 'DXB', '19:20', '21:00'),
  ('EK 201', 'DXB', 'JFK', '8:30', '14:25'),
  ('EK 203', 'DXB', 'JFK', '2:50', '8:50'),
  ('EK 205', 'DXB', 'JFK', '9:45', '19:00'),
  ('EK 211', 'DXB', 'IAH', '9:35', '16:50');