# spring-r2dbc
Spring Reactive R2DBC (Postgresql)

### Create Postgresql Table Script

CREATE TABLE public.coffee
(
    id SERIAL,
    name character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT coffee_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.coffee
    OWNER to postgres;
