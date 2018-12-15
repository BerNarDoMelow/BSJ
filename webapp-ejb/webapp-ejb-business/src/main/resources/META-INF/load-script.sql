INSERT INTO Discount (id, DTYPE, description) VALUES (1, 'NoDiscount', 'Sem desconto');
INSERT INTO Discount (id, DTYPE, description) VALUES (2, 'ThresholdPercentageDiscount', 'Percentagem do Total (acima de limiar)');
INSERT INTO Discount (id, DTYPE, description) VALUES (3, 'EligibleProductsDiscount', 'Percentagem do Total Elegivel');
INSERT INTO Unit (id, abbreviation, description) VALUES (1, 'Kg', 'Kilogram');
INSERT INTO Unit (id, abbreviation, description) VALUES (2, 'l', 'Liters');
INSERT INTO Unit (id, abbreviation, description) VALUES (3, 'u', 'units');
INSERT INTO Product (id, description, discountEligibility, faceValue, prodCod, qty, unit_id) VALUES (1, 'paper', 1, 50, 1, 1000, 1);
INSERT INTO Product (id, description, discountEligibility, faceValue, prodCod, qty, unit_id) VALUES (2, 'toner', 0, 150, 2, 60, 3);
INSERT INTO Product (id, description, discountEligibility, faceValue, prodCod, qty, unit_id) VALUES (3, 'water', 1, 25, 3, 150, 2);
