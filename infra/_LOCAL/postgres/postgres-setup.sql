/*
DROP TABLE IF EXISTS item_choice;
DROP TABLE IF EXISTS item_stem;
DROP TABLE IF EXISTS item;
*/

CREATE TABLE item (
	id char(37) CONSTRAINT pk_item PRIMARY KEY,
	code char(50) CONSTRAINT uq_item_code UNIQUE,
	created_by varchar(50),
	created_on timestamp,
	updated_by varchar(50),
	updated_on timestamp,
	status char(10),
	type char(10)
);

CREATE TABLE item_stem (
	item_id char(37) CONSTRAINT pk_item_stem PRIMARY KEY,
	teacher_instruction TEXT,
    body TEXT,
    rationale TEXT
);

CREATE TABLE item_choice (
	id char(37) CONSTRAINT pk_item_choice PRIMARY KEY,
	item_id char(37) NOT NULL,
	is_correct boolean,
    body TEXT,
    rationale TEXT
);

alter table item_stem add constraint FK_ITEM_STEM__ITEM foreign key (item_id) references item;
alter table item_choice add constraint FK_ITEM_CHOICE__ITEM foreign key (item_id) references item;

/*
SELECT * FROM public.item;
SELECT * FROM public.item_choice;
SELECT * FROM public.item_stem;
*/