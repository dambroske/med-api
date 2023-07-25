  create table doctor(
      id bigint not null auto_increment,
      name varchar(100) not null,
      email varchar(100) not null unique,
      phone varchar(20) not null unique,
      register varchar(100) not null unique,
      area varchar(30) not null,
      street varchar(100) not null,
      number varchar(6) not null,
      extra varchar(50) not null,
      zip char(10) not null,
      city varchar(100) not null,
      state varchar(2) not null,

      primary key(id)
  );

  create table patient(
      id bigint not null auto_increment,
      name varchar(100) not null,
      email varchar(100) not null unique,
      phone varchar(20) not null,
      document_id varchar(20) not null unique,
      street varchar(100) not null,
      number varchar(6) not null,
      extra varchar(50) not null,
      zip char(10) not null,
      city varchar(100) not null,
      state varchar(2) not null,

      primary key(id)
  );