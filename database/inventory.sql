--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Debian 10.5-1)
-- Dumped by pg_dump version 10.5 (Debian 10.5-1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


--
-- Name: product_stock_increment(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.product_stock_increment() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
insert into tb_product_stock values(new.id,new.id,new.minimal_stock,'');
return NEW;
END;
$$;


ALTER FUNCTION public.product_stock_increment() OWNER TO postgres;

--
-- Name: receiving_increment(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.receiving_increment() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
 BEGIN
 UPDATE  tb_product_stock SET stock = stock + NEW.quantity,date=new.date
WHERE product_id = new.product_id;
return NEW;
END;
$$;


ALTER FUNCTION public.receiving_increment() OWNER TO postgres;

--
-- Name: transaction_decrement(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.transaction_decrement() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
 BEGIN
 UPDATE  tb_product_stock SET stock = stock - NEW.quantity,date=new.buy_date
WHERE product_id = new.product_id;
return NEW;
END;
$$;


ALTER FUNCTION public.transaction_decrement() OWNER TO postgres;

--
-- Name: update_jual(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_jual() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
 BEGIN
 UPDATE  barang SET stok = stok - NEW.qty
WHERE kodebrg= new.kodebrg;
return NEW;
END;
$$;


ALTER FUNCTION public.update_jual() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tb_customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_customer (
    id integer NOT NULL,
    name character varying(30),
    email character varying(50),
    phone character varying(12),
    address character varying(100)
);


ALTER TABLE public.tb_customer OWNER TO postgres;

--
-- Name: tb_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_customer_id_seq OWNER TO postgres;

--
-- Name: tb_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_customer_id_seq OWNED BY public.tb_customer.id;


--
-- Name: tb_pembelian; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_pembelian (
    id integer NOT NULL,
    name character varying(30),
    product_id integer,
    quantity integer,
    price integer,
    date_buy date,
    supplier_id integer
);


ALTER TABLE public.tb_pembelian OWNER TO postgres;

--
-- Name: tb_penjualan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_penjualan (
    id integer NOT NULL,
    customer_id integer,
    name character varying(30),
    product_id integer,
    price integer,
    quantity integer,
    date_sell date
);


ALTER TABLE public.tb_penjualan OWNER TO postgres;

--
-- Name: tb_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_product (
    id integer NOT NULL,
    barcode integer,
    name character varying(30),
    description character varying(100),
    stock integer,
    purchase_price integer,
    sale_price integer,
    unit_of_measure_id integer
);


ALTER TABLE public.tb_product OWNER TO postgres;

--
-- Name: tb_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_product_id_seq OWNER TO postgres;

--
-- Name: tb_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_product_id_seq OWNED BY public.tb_product.id;


--
-- Name: tb_supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_supplier (
    id integer NOT NULL,
    name character varying(30),
    company_name character varying(20),
    email character varying(50),
    phone character varying(12),
    description character varying(50)
);


ALTER TABLE public.tb_supplier OWNER TO postgres;

--
-- Name: tb_supplier_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_supplier_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_supplier_id_seq OWNER TO postgres;

--
-- Name: tb_supplier_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_supplier_id_seq OWNED BY public.tb_supplier.id;


--
-- Name: tb_unit_of_measure; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_unit_of_measure (
    id integer NOT NULL,
    name character varying(20),
    abbreviation character varying(20),
    description character varying(20)
);


ALTER TABLE public.tb_unit_of_measure OWNER TO postgres;

--
-- Name: tb_unit_of_measure_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_unit_of_measure_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_unit_of_measure_id_seq OWNER TO postgres;

--
-- Name: tb_unit_of_measure_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_unit_of_measure_id_seq OWNED BY public.tb_unit_of_measure.id;


--
-- Name: tb_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_user (
    id integer NOT NULL,
    name character varying(30),
    dob character(10),
    email character varying(50),
    address character varying(100),
    password character varying(20),
    role character(10)
);


ALTER TABLE public.tb_user OWNER TO postgres;

--
-- Name: tb_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_user_id_seq OWNER TO postgres;

--
-- Name: tb_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;


--
-- Name: tb_customer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_customer ALTER COLUMN id SET DEFAULT nextval('public.tb_customer_id_seq'::regclass);


--
-- Name: tb_product id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product ALTER COLUMN id SET DEFAULT nextval('public.tb_product_id_seq'::regclass);


--
-- Name: tb_supplier id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_supplier ALTER COLUMN id SET DEFAULT nextval('public.tb_supplier_id_seq'::regclass);


--
-- Name: tb_unit_of_measure id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_unit_of_measure ALTER COLUMN id SET DEFAULT nextval('public.tb_unit_of_measure_id_seq'::regclass);


--
-- Name: tb_user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);


--
-- Data for Name: tb_customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_customer (id, name, email, phone, address) FROM stdin;
1	ss	ss	ss	ss
2	aa	aa	aa	aa
\.


--
-- Data for Name: tb_pembelian; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_pembelian (id, name, product_id, quantity, price, date_buy, supplier_id) FROM stdin;
\.


--
-- Data for Name: tb_penjualan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_penjualan (id, customer_id, name, product_id, price, quantity, date_sell) FROM stdin;
\.


--
-- Data for Name: tb_product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_product (id, barcode, name, description, stock, purchase_price, sale_price, unit_of_measure_id) FROM stdin;
1	1	ss	ss	1	1	2	1
2	123	aaa	aa	1	12	12	1
\.


--
-- Data for Name: tb_supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_supplier (id, name, company_name, email, phone, description) FROM stdin;
1	ww	ww	ww	ww	www
\.


--
-- Data for Name: tb_unit_of_measure; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_unit_of_measure (id, name, abbreviation, description) FROM stdin;
1	ad	ad	aa
\.


--
-- Data for Name: tb_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_user (id, name, dob, email, address, password, role) FROM stdin;
\.


--
-- Name: tb_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_customer_id_seq', 1, false);


--
-- Name: tb_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_product_id_seq', 1, false);


--
-- Name: tb_supplier_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_supplier_id_seq', 1, false);


--
-- Name: tb_unit_of_measure_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_unit_of_measure_id_seq', 1, false);


--
-- Name: tb_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_user_id_seq', 1, false);


--
-- Name: tb_customer tb_customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_customer
    ADD CONSTRAINT tb_customer_pkey PRIMARY KEY (id);


--
-- Name: tb_pembelian tb_pembelian_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_pembelian
    ADD CONSTRAINT tb_pembelian_pkey PRIMARY KEY (id);


--
-- Name: tb_penjualan tb_penjualan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_penjualan
    ADD CONSTRAINT tb_penjualan_pkey PRIMARY KEY (id);


--
-- Name: tb_product tb_product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product
    ADD CONSTRAINT tb_product_pkey PRIMARY KEY (id);


--
-- Name: tb_supplier tb_supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_supplier
    ADD CONSTRAINT tb_supplier_pkey PRIMARY KEY (id);


--
-- Name: tb_unit_of_measure tb_unit_of_measure_abbreviation_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_unit_of_measure
    ADD CONSTRAINT tb_unit_of_measure_abbreviation_key UNIQUE (abbreviation);


--
-- Name: tb_unit_of_measure tb_unit_of_measure_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_unit_of_measure
    ADD CONSTRAINT tb_unit_of_measure_pkey PRIMARY KEY (id);


--
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


--
-- Name: tb_pembelian fk_product; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_pembelian
    ADD CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES public.tb_product(id);


--
-- Name: tb_pembelian fk_supplier; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_pembelian
    ADD CONSTRAINT fk_supplier FOREIGN KEY (supplier_id) REFERENCES public.tb_supplier(id);


--
-- Name: tb_product fk_uom; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_product
    ADD CONSTRAINT fk_uom FOREIGN KEY (unit_of_measure_id) REFERENCES public.tb_unit_of_measure(id);


--
-- PostgreSQL database dump complete
--

