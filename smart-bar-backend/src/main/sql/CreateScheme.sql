create schema smartbar;

set search_path = smartbar;

create table CATEGORY
(
	ID int not null,
	NAME varchar not null
);

create unique index CATEGORY_ID_uindex
	on CATEGORY (ID);

alter table CATEGORY
	add constraint CATEGORY_pk
		primary key (ID);




create table smartbar.ARTICLE
(
	ID int not null,
	NAME varchar not null,
	PRICE numeric not null,
	IMAGE_URL varchar,
	CATEGORY_ID int not null
		constraint article_category_id_fk
			references smartbar.CATEGORY
);

create unique index ARTICLE_ID_uindex
	on smartbar.ARTICLE (ID);

alter table smartbar.ARTICLE
	add constraint ARTICLE_pk
		primary key (ID);



create table SM_TABLE
(
	ID int not null,
	NAME varchar not null,
	SEAT_COUNT int not null
);

create unique index SM_TABLE_ID_uindex
	on SM_TABLE (ID);

alter table SM_TABLE
	add constraint SM_TABLE_pk
		primary key (ID);



create table SM_ORDER
(
    ID int not null,
    ARTICLE_ID int not null
        constraint SM_ORDER_ARTICLE_ID_fk
            references ARTICLE (ID),
    TABLE_ID int not null
        constraint SM_ORDER_SM_TABLE_ID_fk
            references SM_TABLE (ID),
    QUANTITY int not null
);

create unique index SM_ORDER_ID_uindex
	on SM_ORDER (ID);

alter table SM_ORDER
    add constraint ORDER_pk
        primary key (ID);
