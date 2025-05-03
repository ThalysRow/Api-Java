-- V2: Migration add Column rank_tb_ninja_register

ALTER TABLE tb_ninja_register ADD COLUMN rank VARCHAR(3) DEFAULT 'D' NOT NULL;