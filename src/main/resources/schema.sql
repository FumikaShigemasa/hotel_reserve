-- 各種テーブル削除
DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;

--role 権限ENUN
CREATE TYPE role AS ENUM ('ADMIN', 'USER');

-- users テーブルを作成するクエリ
CREATE TABLE users (
id BIGSERIAL PRIMARY KEY,
email VARCHAR(255) NOT NULL UNIQUE,
name VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
gender INTEGER NOT NULL,
prefecture INTEGER NOT NULL,
location TEXT NOT NULL,
post_code VARCHAR(255) NOT NULL,
tell VARCHAR(255) NOT NULL,
is_deleted BOOLEAN NOT NULL,
authority VARCHAR(20) NOT NULL
);

-- 管理者テーブル
CREATE TABLE admin (
id BIGSERIAL PRIMARY KEY,
password VARCHAR(255) NOT NULL,
authority VARCHAR(20) NOT NULL
);

-- ホテルテーブル
CREATE TABLE hotels (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
explanation TEXT NOT NULL,
prefecture INTEGER NOT NULL,
region INTEGER NOT NULL,
location TEXT NOT NULL,
post_code VARCHAR(255) NOT NULL,
tell VARCHAR(255) NOT NULL
);

 -- ホテルプランテーブル
CREATE TABLE hotel_plans (
id BIGSERIAL PRIMARY KEY,
name TEXT NOT NULL,
hotel_id BIGINT NOT NULL,
cost INTEGER NOT NULL,
capacity INTEGER NOT NULL,
provision INTEGER NOT NULL,
explanation TEXT NOT NULL,
is_morning BOOLEAN,
is_dinner BOOLEAN,
FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);


-- ホテル予約状況テーブル
CREATE TABLE hotel_bookings (
id BIGSERIAL PRIMARY KEY,
hotel_id BIGINT NOT NULL,
plan_id BIGINT NOT NULL,
user_id BIGINT NOT NULL,
men INTEGER NOT NULL,
women INTEGER NOT NULL,
other INTEGER NOT NULL,
checkin_date DATE NOT NULL,
checkout_date DATE NOT NULL,
checkin_time TIMESTAMP NOT NULL,
is_family BOOLEAN NOT NULL,
FOREIGN KEY (hotel_id) REFERENCES hotels(id),
FOREIGN KEY (plan_id) REFERENCES hotel_plans(id),
FOREIGN KEY (user_id) REFERENCES users(id)
);

-- ホテル空き状況テーブル
CREATE TABLE hotel_availabilities (
id BIGSERIAL PRIMARY KEY,
hotel_id BIGINT NOT NULL,
plan_id BIGINT NOT NULL,
availabilities INTEGER NOT NULL,
date DATE NOT NULL,
FOREIGN KEY (hotel_id) REFERENCES hotels(id),
FOREIGN KEY (plan_id) REFERENCES hotel_plans(id)
);

--ホテル口コミテーブル
CREATE TABLE hotel_reviews (
id BIGSERIAL PRIMARY KEY,
hotel_id BIGINT NOT NULL,
plan_id BIGINT NOT NULL,
user_id BIGINT NOT NULL,
written_date DATE NOT NULL,
content TEXT NOT NULL,
star_rating INTEGER NOT NULL
);

--都道府県テーブル
CREATE TABLE prefecture (
id INTEGER PRIMARY KEY,
name VARCHAR(255) NOT NULL,
region INTEGER NOT NULL
);

--地域テーブル
CREATE TABLE region (
id INTEGER PRIMARY KEY,
name VARCHAR(255) NOT NULL
);