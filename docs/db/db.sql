CREATE TABLE client (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR NOT NULL,
	surname VARCHAR NOT NULL,
	address VARCHAR NOT NULL,
	phone VARCHAR NOT NULL
);

CREATE TABLE credit_card (
	id integer PRIMARY KEY AUTOINCREMENT,
	number VARCHAR NOT NULL,
	expiry_date date NOT NULL,
	client_id INTEGER NOT NULL REFERENCES client(id),
	bank_account_id INTEGER NOT NULL REFERENCES bank_account(id)
);

CREATE TABLE bank_account (
	id integer PRIMARY KEY AUTOINCREMENT,
	number integer NOT NULL,
	blocked boolean NOT NULL
);

CREATE TABLE _transaction (
	id integer PRIMARY KEY AUTOINCREMENT,
	bank_account_id INTEGER NOT NULL REFERENCES bank_account(id),
	amount INTEGER NOT NULL,
	currency VARCHAR NOT NULL,
	type VARCHAR NOT NULL,
	_data date NOT NULL,
	comment VARCHAR NOT NULL
);




