--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.2
-- Dumped by pg_dump version 9.1.2
-- Started on 2012-06-27 15:52:34

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public.registrationrequestitem DROP CONSTRAINT fk_registrationrequestitem_course_id;
ALTER TABLE ONLY public.lection DROP CONSTRAINT fk_lection_course_id;
ALTER TABLE ONLY public.gradebook DROP CONSTRAINT fk_gradebook_student_id;
ALTER TABLE ONLY public.gradebook DROP CONSTRAINT fk_gradebook_courseplanitem_id;
ALTER TABLE ONLY public.gradebook DROP CONSTRAINT fk_gradebook_course_id;
ALTER TABLE ONLY public.courseplanitem DROP CONSTRAINT fk_courseplanitem_quiz_id;
ALTER TABLE ONLY public.courseplanitem DROP CONSTRAINT fk_courseplanitem_lection_id;
ALTER TABLE ONLY public.courseplanitem DROP CONSTRAINT fk_courseplanitem_homework_id;
ALTER TABLE ONLY public.courseplanitem DROP CONSTRAINT fk_courseplanitem_essay_id;
ALTER TABLE ONLY public.courseplanitem DROP CONSTRAINT fk_courseplanitem_course_id;
ALTER TABLE ONLY public.course_student DROP CONSTRAINT fk_course_student_students_id;
ALTER TABLE ONLY public.course_student DROP CONSTRAINT fk_course_student_course_id;
ALTER TABLE ONLY public.course_lecturer DROP CONSTRAINT fk_course_lecturer_lecturers_id;
ALTER TABLE ONLY public.course_lecturer DROP CONSTRAINT fk_course_lecturer_course_id;
ALTER TABLE ONLY public.task DROP CONSTRAINT task_pkey;
ALTER TABLE ONLY public.student DROP CONSTRAINT student_pkey;
ALTER TABLE ONLY public.sequence DROP CONSTRAINT sequence_pkey;
ALTER TABLE ONLY public.registrationrequestitem DROP CONSTRAINT registrationrequestitem_pkey;
ALTER TABLE ONLY public.lecturer DROP CONSTRAINT lecturer_pkey;
ALTER TABLE ONLY public.lection DROP CONSTRAINT lection_pkey;
ALTER TABLE ONLY public.gradebook DROP CONSTRAINT gradebook_pkey;
ALTER TABLE ONLY public.courseplanitem DROP CONSTRAINT courseplanitem_pkey;
ALTER TABLE ONLY public.course_student DROP CONSTRAINT course_student_pkey;
ALTER TABLE ONLY public.course DROP CONSTRAINT course_pkey;
ALTER TABLE ONLY public.course_lecturer DROP CONSTRAINT course_lecturer_pkey;
DROP TABLE public.task;
DROP TABLE public.student;
DROP TABLE public.sequence;
DROP TABLE public.registrationrequestitem;
DROP TABLE public.quiz_questionspool;
DROP TABLE public.quiz_questions;
DROP TABLE public.quiz_answerspool;
DROP TABLE public.quiz_answers;
DROP TABLE public.lecturer;
DROP TABLE public.lection;
DROP TABLE public.homework_usefulfileurls;
DROP TABLE public.homework_targetspool;
DROP TABLE public.homework_commitedfileurls;
DROP TABLE public.gradebook;
DROP TABLE public.essay_topicspool;
DROP TABLE public.courseplanitem;
DROP TABLE public.course_student;
DROP TABLE public.course_lecturer;
DROP TABLE public.course;
DROP EXTENSION adminpack;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- TOC entry 1964 (class 1262 OID 11913)
-- Dependencies: 1963
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 6 (class 2615 OID 23023)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 1965 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 181 (class 3079 OID 23024)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1966 (class 0 OID 0)
-- Dependencies: 181
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 180 (class 3079 OID 23029)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 1967 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 161 (class 1259 OID 23038)
-- Dependencies: 6
-- Name: course; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE course (
    id bigint NOT NULL,
    fulldescription character varying(2048),
    prerequisites character varying(1024),
    briefdescription character varying(512),
    name character varying(255),
    datebegin date,
    dateend date,
    imageurl character varying(255)
);


ALTER TABLE public.course OWNER TO postgres;

--
-- TOC entry 162 (class 1259 OID 23044)
-- Dependencies: 6
-- Name: course_lecturer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE course_lecturer (
    course_id bigint NOT NULL,
    lecturers_id bigint NOT NULL
);


ALTER TABLE public.course_lecturer OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 23047)
-- Dependencies: 6
-- Name: course_student; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE course_student (
    course_id bigint NOT NULL,
    students_id bigint NOT NULL
);


ALTER TABLE public.course_student OWNER TO postgres;

--
-- TOC entry 164 (class 1259 OID 23050)
-- Dependencies: 6
-- Name: courseplanitem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE courseplanitem (
    id bigint NOT NULL,
    date date,
    phase integer,
    essay_id bigint,
    lection_id bigint,
    quiz_id bigint,
    homework_id bigint,
    course_id bigint
);


ALTER TABLE public.courseplanitem OWNER TO postgres;

--
-- TOC entry 165 (class 1259 OID 23053)
-- Dependencies: 6
-- Name: essay_topicspool; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE essay_topicspool (
    essay_id bigint NOT NULL,
    topicspool character varying(255)
);


ALTER TABLE public.essay_topicspool OWNER TO postgres;

--
-- TOC entry 166 (class 1259 OID 23056)
-- Dependencies: 6
-- Name: gradebook; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE gradebook (
    id bigint NOT NULL,
    mark character varying(255),
    course_id bigint,
    student_id bigint,
    courseplanitem_id bigint
);


ALTER TABLE public.gradebook OWNER TO postgres;

--
-- TOC entry 167 (class 1259 OID 23059)
-- Dependencies: 6
-- Name: homework_commitedfileurls; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE homework_commitedfileurls (
    homework_id bigint NOT NULL,
    commitedfileurls character varying(255)
);


ALTER TABLE public.homework_commitedfileurls OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 23062)
-- Dependencies: 6
-- Name: homework_targetspool; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE homework_targetspool (
    homework_id bigint NOT NULL,
    targetspool character varying(255)
);


ALTER TABLE public.homework_targetspool OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 23065)
-- Dependencies: 6
-- Name: homework_usefulfileurls; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE homework_usefulfileurls (
    homework_id bigint NOT NULL,
    usefulfileurls character varying(255)
);


ALTER TABLE public.homework_usefulfileurls OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 23068)
-- Dependencies: 6
-- Name: lection; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE lection (
    id bigint NOT NULL,
    text character varying(16384),
    description character varying(512),
    name character varying(255),
    type integer,
    url character varying(255),
    course_id bigint
);


ALTER TABLE public.lection OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 23074)
-- Dependencies: 6
-- Name: lecturer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE lecturer (
    id bigint NOT NULL,
    bigphotourl character varying(512),
    description character varying(512),
    name character varying(255)
);


ALTER TABLE public.lecturer OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 23080)
-- Dependencies: 6
-- Name: quiz_answers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quiz_answers (
    quiz_id bigint NOT NULL,
    answers integer,
    answers_key integer
);


ALTER TABLE public.quiz_answers OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 23083)
-- Dependencies: 6
-- Name: quiz_answerspool; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quiz_answerspool (
    quiz_id bigint NOT NULL,
    answerspool integer
);


ALTER TABLE public.quiz_answerspool OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 23086)
-- Dependencies: 6
-- Name: quiz_questions; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quiz_questions (
    quiz_id bigint NOT NULL,
    questions character varying(255)
);


ALTER TABLE public.quiz_questions OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 23089)
-- Dependencies: 6
-- Name: quiz_questionspool; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quiz_questionspool (
    quiz_id bigint NOT NULL,
    questionspool character varying(255)
);


ALTER TABLE public.quiz_questionspool OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 23092)
-- Dependencies: 6
-- Name: registrationrequestitem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE registrationrequestitem (
    id bigint NOT NULL,
    birthday date,
    name character varying(255),
    login character varying(255),
    course_id bigint
);


ALTER TABLE public.registrationrequestitem OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 23098)
-- Dependencies: 6
-- Name: sequence; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE public.sequence OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 23101)
-- Dependencies: 6
-- Name: student; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student (
    id bigint NOT NULL,
    birthday date,
    prolongationdays integer,
    name character varying(255),
    login character varying(255)
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 23110)
-- Dependencies: 6
-- Name: task; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE task (
    id bigint NOT NULL,
    dtype character varying(31),
    datebegin date,
    dateend date,
    description character varying(255),
    course_id bigint,
    target character varying(255),
    vcsurl character varying(255),
    text character varying(255),
    topic character varying(255)
);


ALTER TABLE public.task OWNER TO postgres;

--
-- TOC entry 1928 (class 2606 OID 23117)
-- Dependencies: 162 162 162
-- Name: course_lecturer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY course_lecturer
    ADD CONSTRAINT course_lecturer_pkey PRIMARY KEY (course_id, lecturers_id);


--
-- TOC entry 1926 (class 2606 OID 23119)
-- Dependencies: 161 161
-- Name: course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- TOC entry 1930 (class 2606 OID 23121)
-- Dependencies: 163 163 163
-- Name: course_student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY course_student
    ADD CONSTRAINT course_student_pkey PRIMARY KEY (course_id, students_id);


--
-- TOC entry 1932 (class 2606 OID 23123)
-- Dependencies: 164 164
-- Name: courseplanitem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY courseplanitem
    ADD CONSTRAINT courseplanitem_pkey PRIMARY KEY (id);


--
-- TOC entry 1934 (class 2606 OID 23125)
-- Dependencies: 166 166
-- Name: gradebook_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY gradebook
    ADD CONSTRAINT gradebook_pkey PRIMARY KEY (id);


--
-- TOC entry 1936 (class 2606 OID 23127)
-- Dependencies: 170 170
-- Name: lection_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY lection
    ADD CONSTRAINT lection_pkey PRIMARY KEY (id);


--
-- TOC entry 1938 (class 2606 OID 23129)
-- Dependencies: 171 171
-- Name: lecturer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY lecturer
    ADD CONSTRAINT lecturer_pkey PRIMARY KEY (id);


--
-- TOC entry 1940 (class 2606 OID 23131)
-- Dependencies: 176 176
-- Name: registrationrequestitem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY registrationrequestitem
    ADD CONSTRAINT registrationrequestitem_pkey PRIMARY KEY (id);


--
-- TOC entry 1942 (class 2606 OID 23133)
-- Dependencies: 177 177
-- Name: sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- TOC entry 1944 (class 2606 OID 23137)
-- Dependencies: 178 178
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 1946 (class 2606 OID 23139)
-- Dependencies: 179 179
-- Name: task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY task
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);


--
-- TOC entry 1947 (class 2606 OID 23140)
-- Dependencies: 1925 161 162
-- Name: fk_course_lecturer_course_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY course_lecturer
    ADD CONSTRAINT fk_course_lecturer_course_id FOREIGN KEY (course_id) REFERENCES course(id);


--
-- TOC entry 1948 (class 2606 OID 23145)
-- Dependencies: 1937 162 171
-- Name: fk_course_lecturer_lecturers_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY course_lecturer
    ADD CONSTRAINT fk_course_lecturer_lecturers_id FOREIGN KEY (lecturers_id) REFERENCES lecturer(id);


--
-- TOC entry 1949 (class 2606 OID 23150)
-- Dependencies: 161 1925 163
-- Name: fk_course_student_course_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY course_student
    ADD CONSTRAINT fk_course_student_course_id FOREIGN KEY (course_id) REFERENCES course(id);


--
-- TOC entry 1950 (class 2606 OID 23155)
-- Dependencies: 1943 178 163
-- Name: fk_course_student_students_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY course_student
    ADD CONSTRAINT fk_course_student_students_id FOREIGN KEY (students_id) REFERENCES student(id);


--
-- TOC entry 1951 (class 2606 OID 23160)
-- Dependencies: 164 1925 161
-- Name: fk_courseplanitem_course_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY courseplanitem
    ADD CONSTRAINT fk_courseplanitem_course_id FOREIGN KEY (course_id) REFERENCES course(id);


--
-- TOC entry 1952 (class 2606 OID 23165)
-- Dependencies: 179 164 1945
-- Name: fk_courseplanitem_essay_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY courseplanitem
    ADD CONSTRAINT fk_courseplanitem_essay_id FOREIGN KEY (essay_id) REFERENCES task(id);


--
-- TOC entry 1953 (class 2606 OID 23170)
-- Dependencies: 164 179 1945
-- Name: fk_courseplanitem_homework_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY courseplanitem
    ADD CONSTRAINT fk_courseplanitem_homework_id FOREIGN KEY (homework_id) REFERENCES task(id);


--
-- TOC entry 1954 (class 2606 OID 23175)
-- Dependencies: 1935 164 170
-- Name: fk_courseplanitem_lection_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY courseplanitem
    ADD CONSTRAINT fk_courseplanitem_lection_id FOREIGN KEY (lection_id) REFERENCES lection(id);


--
-- TOC entry 1955 (class 2606 OID 23180)
-- Dependencies: 179 164 1945
-- Name: fk_courseplanitem_quiz_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY courseplanitem
    ADD CONSTRAINT fk_courseplanitem_quiz_id FOREIGN KEY (quiz_id) REFERENCES task(id);


--
-- TOC entry 1956 (class 2606 OID 23185)
-- Dependencies: 161 166 1925
-- Name: fk_gradebook_course_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gradebook
    ADD CONSTRAINT fk_gradebook_course_id FOREIGN KEY (course_id) REFERENCES course(id);


--
-- TOC entry 1957 (class 2606 OID 23190)
-- Dependencies: 1931 164 166
-- Name: fk_gradebook_courseplanitem_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gradebook
    ADD CONSTRAINT fk_gradebook_courseplanitem_id FOREIGN KEY (courseplanitem_id) REFERENCES courseplanitem(id);


--
-- TOC entry 1958 (class 2606 OID 23195)
-- Dependencies: 166 1943 178
-- Name: fk_gradebook_student_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gradebook
    ADD CONSTRAINT fk_gradebook_student_id FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1959 (class 2606 OID 23200)
-- Dependencies: 170 1925 161
-- Name: fk_lection_course_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lection
    ADD CONSTRAINT fk_lection_course_id FOREIGN KEY (course_id) REFERENCES course(id);


--
-- TOC entry 1960 (class 2606 OID 23205)
-- Dependencies: 176 1925 161
-- Name: fk_registrationrequestitem_course_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY registrationrequestitem
    ADD CONSTRAINT fk_registrationrequestitem_course_id FOREIGN KEY (course_id) REFERENCES course(id);


-- Completed on 2012-06-27 15:52:34

--
-- PostgreSQL database dump complete
--

