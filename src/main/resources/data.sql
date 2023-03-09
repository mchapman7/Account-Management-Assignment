INSERT INTO user_tbl VALUES (1111, 'User_A_FN', 'User_A_LN', 'USER_A.AAA@test.com.au');
INSERT INTO user_tbl VALUES (2222, 'User B FN', 'User B LN', 'USER_B.AAA@test.com.au');
INSERT INTO user_tbl VALUES (3333, 'User C FN', 'User C LN', 'USER_C.AAA@test.com.au');

INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (123456, 123456789, 'Smart access', 'Current', 'OPENED', 'AUD', 1285.34, '2023-03-08' , 1111 );
INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (345678, 123456987, 'Incentive saver', 'Savings', 'OPENED', 'AUD', 1456.34, '2023-02-28', 1111 );
INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (567765, 123456678, 'Step pay', 'Current', 'CLOSED', 'AUD', 400, '2023-03-03', 1111 );

INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (121212, 123456789, 'Smart access', 'Current', 'OPENED', 'AUD', 1285.34, '2023-03-08' , 2222 );
INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (212121, 123456987, 'Incentive saver', 'Savings', 'OPENED', 'AUD', 1456.34, '2023-02-28', 2222 );
INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (233223, 123456678, 'Step pay', 'Current', 'CLOSED', 'AUD', 400, '2023-03-03', 2222 );

INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (344334, 123456789, 'Smart access', 'Current', 'OPENED', 'AUD', 1285.34, '2023-03-08' , 3333 );
INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (565454, 123456987, 'Incentive saver', 'Savings', 'OPENED', 'AUD', 1456.34, '2023-02-28', 3333 );
INSERT INTO ACCOUNT (account_id, number, name, type, status, currency, balance, balance_date, user_id) VALUES (656565, 123456678, 'Step pay', 'Current', 'CLOSED', 'AUD', 400, '2023-03-03', 3333 );

INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (9800, 'Coles shopping', '2023-03-02', 'AUD', '1245.56', 'Debit', 123456 );
INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (7898, 'Target shopping', '2023-03-03', 'AUD', '1230.25', 'Debit', 123456 );
INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (5676, 'Salary', '2023-03-04', 'AUD', '1000.00', 'Credit', 123456 );

INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (6565, 'Coles shopping', '2023-03-02', 'AUD', '1245.56', 'Debit', 121212 );
INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (7878, 'Target shopping', '2023-03-03', 'AUD', '1230.25', 'Debit', 121212 );
INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (8787, 'Salary', '2023-03-04', 'AUD', '1000.00', 'Credit', 121212 );

INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (9898, 'Coles shopping', '2023-03-02', 'AUD', '1245.56', 'Debit', 344334 );
INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (6567, 'Target shopping', '2023-03-03', 'AUD', '1230.25', 'Debit', 344334 );
INSERT INTO TRANSACTION (transaction_id, description, transaction_date, currency, amount, type, account_id) VALUES (4354, 'Salary', '2023-03-04', 'AUD', '1000.00', 'Credit', 344334 );