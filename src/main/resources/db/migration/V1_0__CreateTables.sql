CREATE TABLE author
(
    id           BIGINT (20)  NOT NULL AUTO_INCREMENT UNIQUE,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE post
(
    id                  BIGINT (20)     NOT NULL AUTO_INCREMENT UNIQUE,
    body                VARCHAR(255)    NOT NULL,
    date                DATETIME        NOT NULL,
    title               VARCHAR(255)    NOT NULL,
    author_id           BIGINT (20)     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tags
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT UNIQUE,
    text VARCHAR(200) NOT NULL,
    description VARCHAR(500) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tags_post
(
    tag_id BIGINT(20) NOT NULL,
    post_id BIGINT(20) NOT NULL,
    PRIMARY KEY (tag_id, post_id)
);

ALTER TABLE post
    ADD CONSTRAINT post_author_id_author_id
        FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE;

ALTER TABLE tags_post
    ADD CONSTRAINT post_tags_id_post_id
        FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE;


ALTER TABLE tags_post
    ADD CONSTRAINT post_tags_id_tags_id
        FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE;

