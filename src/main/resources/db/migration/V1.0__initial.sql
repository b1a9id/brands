CREATE TABLE user (
  id                      BIGINT auto_increment NOT NULL,
  name                    VARCHAR(100) NOT NULL,
  age                     INTEGER,
  gender                  VARCHAR(10) NOT NULL,
  address_zip             VARCHAR(20),
  address_prefecture      VARCHAR(20),
  PRIMARY KEY (id)
)
  ENGINE=InnoDB;

create table brand (
  id                      bigint not null auto_increment,
  user_id                 bigint not null,
  brandName               varchar(100) not null,
  designer                varchar(100) not null,
  address_prefecture      varchar(10),
  address_zip             varchar(10),
  primary key (id)
)
  ENGINE=InnoDB;

alter table brand add constraint FKmp088cw47tdpyq89xqv7qa49m foreign key (user_id) references User (id);

INSERT INTO user (id, name, age, gender, address_zip, address_prefecture) VALUES (1, '葵', 18, 'WOMAN', '100-0001', '東京都');
INSERT INTO user (id, name, age, gender, address_zip, address_prefecture) VALUES (2, '良介', 26, 'FREE', '123-4567', '宮崎県');
INSERT INTO user (id, name, age, gender, address_zip, address_prefecture) VALUES (3, '悠真', 32, 'MAN', '222-3333', '神奈川県');

INSERT INTO brand (user_id, brandName, designer, address_prefecture, address_zip) VALUES (1, 'Dulcamara', '與田尚子', '987-6543','大阪府');
INSERT INTO brand (user_id, brandName, designer, address_prefecture, address_zip) VALUES (1, 'STOF', '谷田浩', '123-3333', '東京都');
INSERT INTO brand (user_id, brandName, designer, address_prefecture, address_zip) VALUES (2, 'ETHOSENS', '橋本唯', '221-7656', '東京都');