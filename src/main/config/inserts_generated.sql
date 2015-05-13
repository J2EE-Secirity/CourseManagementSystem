--
-- PostgreSQL database dump
--

-- Started on 2012-06-19 21:23:18 EEST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1887 (class 0 OID 38295)
-- Dependencies: 1541
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (1, '2012-01-07', 'giggs', 'Ivan Ivanov', 5);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (2, '2012-02-01', 'scholes', 'Petr Petrov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (3, '2012-01-01', 'valencia', 'Sidor Sidorov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (4, '2012-01-01', 'ronaldo', 'Banan Bananov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (5, '2012-01-01', 'tayson', 'Rulon Oboev', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (6, '2012-01-01', 'chicharito', 'Bidon Pomoev', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (7, '2012-01-01', 'nani', 'Gazon Zaseyan', 10);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (8, '2012-01-01', 'shevchenko', 'Podzhog Saraev', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (9, '2012-01-01', 'toure', 'Rekord Nadoev', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (10, '2012-01-01', 'leeloo', 'Pobeg Zlodeev', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (11, '2012-01-01', 'asasd', 'Otryad Kretinov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (12, '2012-01-01', 'sdfgfg', 'Parad Bratanov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (13, '2012-01-01', 'uuuu', 'Zaplyv Matrosov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (14, '2012-01-01', 'pokko', 'Rozhok Patronov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (15, '2012-01-01', 'rico', 'Pryzhok Gibbonov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (16, '2012-01-01', 'cisco', 'Polet Fazanov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (17, '2012-01-01', 'numba1', 'Barak Mongolov', 0);
INSERT INTO student (id, birthday, login, name, prolongationdays) VALUES (18, '2012-01-01', 'numba2', 'Zagon Baranov', 0);


--
-- TOC entry 1885 (class 0 OID 38279)
-- Dependencies: 1539 1891
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO course (id, briefdescription, datebegin, dateend, fulldescription, imageurl, name, prerequisites) VALUES (1, 'This course is the largest of the introductory programming courses and is one of the largest courses at Stanford. Topics focus on the introduction to the engineering of computer applications emphasizing modern software engineering principles', '2012-01-01', '2012-12-12', 'This course is the largest of the introductory programming courses and is one of the largest courses at Stanford. Topics focus on the introduction to the engineering of computer applications emphasizing modern software engineering principles: object-oriented design, decomposition, encapsulation, abstraction, and testing. Programming Methodology teaches the widely-used Java programming language along with good software engineering principles. Emphasis is on good programming style and the built-in facilities of the Java language. The course is explicitly designed to appeal to humanists and social scientists as well as hard-core techies. In fact, most Programming Methodology graduates end up majoring outside of the School of Engineering.', 'https://s3.amazonaws.com/coursera/topics/algo/small-icon.hover.png', 'Programming Methodology', 'The course requires no previous background in programming, but does require considerable dedication and hard work.');
INSERT INTO course (id, briefdescription, datebegin, dateend, fulldescription, imageurl, name, prerequisites) VALUES (2, 'This course is the natural successor to Programming Methodology and covers such advanced programming topics as recursion, algorithmic analysis, and data abstraction using the C++ programming language, which is similar to both C and Java.', '2012-01-01', '2012-12-12', 'This course is the natural successor to Programming Methodology and covers such advanced programming topics as recursion, algorithmic analysis, and data abstraction using the C++ programming language, which is similar to both C and Java. If youve taken the Computer Science AP exam and done well (scored 4 or 5) or earned a good grade in a college course, Programming Abstractions may be an appropriate course for you to start with, but often Programming Abstractions (Accelerated) is a better choice. Programming Abstractions assumes that you already have familiarity with good programming style and software engineering issues (at the level of Programming Methodology), and that you can use this understanding as a foundation on which to tackle new topics in programming and data abstraction.', 'https://s3.amazonaws.com/coursera/topics/saas/small-icon.hover.png', 'Programming Abstractions', 'Solid performance in Programming Methodology and readiness to move on to advanced programming topics. A comparable introductory programming course (including high school AP courses) is often a reasonable substitute for our Programming Methodology. ');
INSERT INTO course (id, briefdescription, datebegin, dateend, fulldescription, imageurl, name, prerequisites) VALUES (3, 'Advanced memory management features of C and C++; the differences between imperative and object-oriented paradigms.', '2012-01-01', '2012-12-12', 'Advanced memory management features of C and C++; the differences between imperative and object-oriented paradigms. The functional paradigm (using LISP) and concurrent programming (using C and C++). Brief survey of other modern languages such as Python, Objective C, and C#.', 'https://s3.amazonaws.com/coursera/topics/soc101/small-icon.hover.png', 'Programming Paradigms', 'Programming and problem solving at the Programming Abstractions level. Prospective students should know a reasonable amount of C++. You should be comfortable with arrays, pointers, references, classes, methods, dynamic memory allocation, recursion, linked lists, binary search trees, hashing, iterators, and function pointers. You should be able to write well-decomposed, easy-to-understand code, and understand the value that comes with good variable names, short function and method implementations, and thoughtful, articulate comments.');
INSERT INTO course (id, briefdescription, datebegin, dateend, fulldescription, imageurl, name, prerequisites) VALUES (4, 'This course is designed to introduce students to the fundamental concepts and ideas in natural language processing (NLP), and to get them up to speed with current research in the area.', '2012-01-01', '2012-12-12', 'This course is designed to introduce students to the fundamental concepts and ideas in natural language processing (NLP), and to get them up to speed with current research in the area. It develops an in-depth understanding of both the algorithms available for the processing of linguistic information and the underlying computational properties of natural languages. Wordlevel, syntactic, and semantic processing from both a linguistic and an algorithmic perspective are considered. The focus is on modern quantitative techniques in NLP: using large corpora, statistical models for acquisition, disambiguation, and parsing. Also, it examines and constructs representative systems.', 'https://s3.amazonaws.com/coursera/topics/crypto/small-icon.hover.png', 'Natural Language Processing', 'Adequate experience with programming and formal structures (e.g., CS106B/X and CS103B/X).Programming projects will be written in Java 1.5, so knowledge of Java (or a willingness to learn on your own) is required.Knowledge of standard concepts in artificial intelligence and/or computational linguistics (e.g., CS121/221 or Ling 180).Basic familiarity with logic, vector spaces, and probability. Intended Audience:Graduate students and advanced undergraduates specializing in computer science, linguistics, or symbolic systems. ');
INSERT INTO course (id, briefdescription, datebegin, dateend, fulldescription, imageurl, name, prerequisites) VALUES (5, 'This course provides a broad introduction to machine learning and statistical pattern recognition. ', '2012-01-01', '2012-12-12', 'This course provides a broad introduction to machine learning and statistical pattern recognition.Topics include: supervised learning (generative/discriminative learning, parametric/non-parametric learning, neural networks, support vector machines); unsupervised learning (clustering, dimensionality reduction, kernel methods); learning theory (bias/variance tradeoffs; VC theory; large margins); reinforcement learning and adaptive control.The course will also discuss recent applications of machine learning, such as to robotic control, data mining, autonomous navigation, bioinformatics, speech recognition, and text and web data processing.', 'https://s3.amazonaws.com/coursera/topics/compilers/small-icon.hover.png', 'Machine Learning ', 'none');



--
-- TOC entry 1889 (class 0 OID 38308)
-- Dependencies: 1543
-- Data for Name: lecturer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO lecturer (id, bigphotourl, description, name) VALUES (1, 'http://see.stanford.edu/see/images/sahami.jpg', 'Previously, I worked for several years as a Senior Engineering Manager at Epiphany. Prior to working at Epiphany, I completed my PhD in the Computer Science Department at Stanford. I was also an undergrad at Stanford and I loved it so much that I didnt want to leave.Outside of work, I enjoy spending time with family, playing the guitar, going on outdoor excursions, and sleeping (which seems to be getting rarer and rarer these days).', 'Mehran Sahami');
INSERT INTO lecturer (id, bigphotourl, description, name) VALUES (2, 'http://see.stanford.edu/see/images/zelenski.jpg', 'I left my rural hometown of Stevinson, CA (population: 262) to come to Stanford as a wide-eyed freshman in 1985. That tour passed through SLE, the LSJUMB, a half-dozen changes in my major, and I emerged with a Mathematical Sciences degree. A few years out in the "real world" were enough to send me running back for grad school in computer science and I segued into my current position as a lecturer in 1992 without setting foot off campus again.', 'Julie Zelenski');
INSERT INTO lecturer (id, bigphotourl, description, name) VALUES (3, 'http://see.stanford.edu/see/images/cain.gif', 'Jerry Cain is a lecturer at Stanford University in the Computer Science Department.', 'Jerry Cain');
INSERT INTO lecturer (id, bigphotourl, description, name) VALUES (4, 'http://see.stanford.edu/see/images/khatib.jpg', 'Prof. Khatib was the Program Chair of ICRA2000 (San Francisco) and Editor of ``The Robotics Review'' (MIT Press). He has served as the Director of the Stanford Computer Forum, an industry affiliate program. He is currently the President of the International Foundation of Robotics Research, IFRR, and Editor of STAR, Springer Tracts in Advanced Robotics. Prof. Khatib is IEEE fellow, Distinguished Lecturer of IEEE, and recipient of the JARA Award. ', 'Oussama Khatib');
INSERT INTO lecturer (id, bigphotourl, description, name) VALUES (5, 'http://see.stanford.edu/see/images/manning.jpg', 'My research at Stanford is currently supported by an IBM Faculty Partnership Award, ARDA, Scottish Enterprise, and DARPA. Previous funding at Stanford comes from a Terman Fellowship, NSF (for GIB), NTT, NHK, and the Australian Reseach Council.', 'Christopher D. Manning');


--
-- TOC entry 1895 (class 0 OID 38338)
-- Dependencies: 1549 1889 1885
-- Data for Name: course_lecturer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (1, 1);
INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (1, 2);
INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (2, 2);
INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (3, 1);
INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (3, 3);
INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (3, 4);
INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (4, 4);
INSERT INTO course_lecturer (course_id, lecturers_id) VALUES (5, 5);


--
-- TOC entry 1896 (class 0 OID 38343)
-- Dependencies: 1550 1887 1885
-- Data for Name: course_student; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO course_student (course_id, students_id) VALUES (1, 1);
INSERT INTO course_student (course_id, students_id) VALUES (1, 2);
INSERT INTO course_student (course_id, students_id) VALUES (1, 3);
INSERT INTO course_student (course_id, students_id) VALUES (1, 4);
INSERT INTO course_student (course_id, students_id) VALUES (1, 5);
INSERT INTO course_student (course_id, students_id) VALUES (2, 6);
INSERT INTO course_student (course_id, students_id) VALUES (2, 7);
INSERT INTO course_student (course_id, students_id) VALUES (2, 8);
INSERT INTO course_student (course_id, students_id) VALUES (2, 9);
INSERT INTO course_student (course_id, students_id) VALUES (2, 10);
INSERT INTO course_student (course_id, students_id) VALUES (3, 11);
INSERT INTO course_student (course_id, students_id) VALUES (3, 12);
INSERT INTO course_student (course_id, students_id) VALUES (3, 13);
INSERT INTO course_student (course_id, students_id) VALUES (3, 14);
INSERT INTO course_student (course_id, students_id) VALUES (3, 15);
INSERT INTO course_student (course_id, students_id) VALUES (4, 16);
INSERT INTO course_student (course_id, students_id) VALUES (4, 17);
INSERT INTO course_student (course_id, students_id) VALUES (4, 18);
INSERT INTO course_student (course_id, students_id) VALUES (4, 7);
INSERT INTO course_student (course_id, students_id) VALUES (4, 3);
INSERT INTO course_student (course_id, students_id) VALUES (5, 1);
INSERT INTO course_student (course_id, students_id) VALUES (5, 17);
INSERT INTO course_student (course_id, students_id) VALUES (5, 18);
INSERT INTO course_student (course_id, students_id) VALUES (5, 10);
INSERT INTO course_student (course_id, students_id) VALUES (5, 5);



--
-- TOC entry 1884 (class 0 OID 38271)
-- Dependencies: 1538 1885
-- Data for Name: lection; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (1, 'Welcome to CS106A, Course Staff, Why is the class called Programming Methodology?, Are you in the right class?, Class Logistics, Assignments and Grading, Extensions, Midterm and Final, Grade Breakdown, The Honor Code, Why Karel?', 'Lecture 1', '', 1, 'http://www.youtube.com/embed/Hl-zzrqQoSE', 1);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (2, 'Handout Information, Section Sign-up, Karel Commands, An Algorithm vs Program, Syntax of a Karel Program, Running a Karel Program, Creating Methods, SuperKarel, A for Loop, A While Loop, Karel Conditions, If Statement, Putting it All Together', 'Lecture 2', '', 1, 'http://www.youtube.com/embed/KkMDCCdjyW8', 1);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (3, 'Karel and Java, Common Errors, Comments, Pre-conditions and Post-conditions, Decomposition, The DoubleBeepers Example, Importance of Good Software Engineering, The Right Decomposition, The CleanUpKarel Example', 'Lecture 3', '<div><b>Text of lecture in HTML</b>                                                                                                                                                                                                                                                                                                                     textoflecturetextoflecturetextoflecture<br/>FINISH</div>', 0, '', 1);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (4, 'The History of Computing, Computer Science vs Programming, What Does the Computer Understand?, The Compilation Process, Java is an Object Oriented Language, Inheritance, Instance of a Class, The acm.program Hierarchy, Your First Java Program, A ConsoleProgram Example, The Graphics Window, The Sending-Messages-to-a-GLabel Example', 'Lecture 4', '', 2, 'https://docs.google.com/presentation/embed?id=1tNRn35VoHembF2C7OVYkUbv4tJEO5k1Uixj62TDyq_4&start=false&loop=false&delayms=3000', 1);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (5, 'Variables, Data Types for Variables, Syntax for Using Variables, Classes as Types, Objects as Variables, Invoking Methods on Objects, Graphics Coordinates, Operations on the GObject Class and its Subclasses, Drawing Geometrical Objects, A FunGraphics Example, Expressions and Operators', 'Lecture 5', '', 2, 'https://docs.google.com/presentation/embed?id=1F_HTK01a1EOf2LO7tYpsiH4Gpjxioi2SQ63LFTMbtp8&start=false&loop=false&delayms=3000', 1);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (6, 'readInt() and readDouble(), The Division Operator w.r.t ints and Doubles, Order of Precedence for Operators, Type Casting, Shorthands, Constants, The Boolean Data Type, Value Comparisons, Boolean Expressions, Short Circuit Evaluation, Statement Blocks, Scope of Variables, Cascading if, The Switch Statement, The For Loop, The While Loop', 'Lecture 6', '<div><b>this text contains xml error</b</div>', 0, '', 2);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (7, 'The Loop and a Half Problem, For Versus While Loop, The CheckerBoard Program Example, Methods in Java, Examples of Methods, The FactorialExample Program, Returning Objects from Methods', 'Lecture 7', '', 3, 'https://docs.google.com/document/pub?id=1m_CU03PcpnWrGhRJudtcN-vgPC2bVAW4BUfZ9WwJDTQ&amp;embedded=true', 2);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (8, 'About the CS106 Series at Stanford, The CS106 Philosophy, Why take CS106B?, Logistics of the Course, Introducing C++', 'Lecture 8', '', 3, 'https://docs.google.com/document/pub?id=1SSgux65PR9RdmUtPuI6GIe4bDNsq4geAvZM2CcqBTj8', 2);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (9, 'Similarity between C++ & Java: - syntax - variable types - operators - control structures, Looking at an Example C++ code: - comment, #include Statements, Global Declarations (constant), Declaring a Function Prototype, The main() Function, Decomposed Function Definition', 'Lecture 9', '', 0, '', 2);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (10, 'C++ Libraries - Standard Libraries, CS106 Libraries, CS106 random.h Library, C++ String Type, Operations on String Type, String Class Member Functions, C++ string vs Java String, Live Example Code', 'Lecture 10', '', 0, '', 2);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (11, 'C++ Libraries - Standard Libraries, CS106 Libraries, CS106 random.h Library, C++ String Type, Operations on String Type, String Class Member Functions, C++ string vs Java String', 'Lecture 11', '', 0, '', 3);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (12, 'C++ Console I/O, C++ File I/O, Stream Operations, Live Example Coding : Working with Files, Live Coding Continuation: Function to Operate on the Opened File Stream, Passing the File Stream by Reference, Error Function, Class Libraries OO Features', 'Lecture 12', '', 0, '', 3);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (13, 'Client Use of Templates, Vector Class, Vector Client Interface, Client Use of Vector, Type-safety in Templates, Grid Class, Grid Client Interface, Client Use of Grid', 'Lecture 13', '', 0, '', 3);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (14, 'More Containers, Map Class, Uses of Map, Map Client Interface, Live Coding Example: Use of Map, More information on Maps, What’s Missing? Iterator Operation Through the Map', 'Lecture 14', '', 0, '', 3);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (15, 'Seeing Functions as Data: Specific Plot Functions, Generic Plot Function, Back to the Set, Live Coding Example: Use of Set with User Defined Data Types, Client Callback Function', 'Lecture 15', '', 0, '', 3);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (16, 'Client Use of Templates, Vector Class, Vector Client Interface, Client Use of Vector, Type-safety in Templates, Grid Class, Grid Client Interface, Client Use of Grid', 'Lecture 16', '', 0, '', 4);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (17, 'Client Use of Templates, Vector Class, Vector Client Interface, Client Use of Vector, Type-safety in Templates, Grid Class, Grid Client Interface, Client Use of Grid', 'Lecture 17', '', 0, '', 4);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (18, 'readInt() and readDouble(), The Division Operator w.r.t ints and Doubles, Order of Precedence for Operators, Type Casting, Shorthands, Constants, The Boolean Data Type, Value Comparisons, Boolean Expressions, Short Circuit Evaluation, Statement Blocks, Scope of Variables, Cascading if, The Switch Statement, The For Loop, The While Loop', 'Lecture 18', '', 0, '', 4);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (19, 'Handout Information, Section Sign-up, Karel Commands, An Algorithm vs Program, Syntax of a Karel Program, Running a Karel Program, Creating Methods, SuperKarel, A for Loop, A While Loop, Karel Conditions, If Statement, Putting it All Together', 'Lecture 19', '', 0, '', 4);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (20, 'Welcome to CS106A, Course Staff, Why is the class called Programming Methodology?, Are you in the right class?, Class Logistics, Assignments and Grading, Extensions, Midterm and Final, Grade Breakdown, The Honor Code, Why Karel?', 'Lecture 20', '', 0, '', 4);
INSERT INTO lection (id, description, name, text, type, url, course_id) VALUES (21, 'More Containers, Map Class, Uses of Map, Map Client Interface, Live Coding Example: Use of Map, More information on Maps, What’s Missing? Iterator Operation Through the Map', 'Lecture 21', '', 0, '', 5);


--insert into lection_videourls values(1, 'http://www.youtube.com/embed/KkMDCCdjyW8');
--insert into lection_videourls values(1, 'http://www.youtube.com/embed/nziy2_U5JQI');
--insert into lection_videourls values(2, 'http://www.youtube.com/embed/Ps8jOj7diA0');
--insert into lection_videourls values(3, 'http://www.youtube.com/embed/3fyvJcSMrVw');
--insert into lection_videourls values(4, 'http://www.youtube.com/embed/0SARbwvhupQ');
--insert into lection_videourls values(5, 'http://www.youtube.com/embed/Hl-zzrqQoSE');
--insert into lection_videourls values(5, 'http://www.youtube.com/embed/qHOBC9DYFJA');
--insert into lection_videourls values(6, 'http://www.youtube.com/embed/einEGoBc0V8');
--insert into lection_videourls values(7, 'http://www.youtube.com/embed/8WZr6fvtEgk');
--insert into lection_videourls values(7, 'http://www.youtube.com/embed/M4K6HYLHREQ');
--insert into lection_videourls values(7, 'http://www.youtube.com/embed/c5kfCH50wl0');
--insert into lection_videourls values(8, 'http://www.youtube.com/embed/Ps8jOj7diA0');
--insert into lection_videourls values(9, 'http://www.youtube.com/embed/3fyvJcSMrVw');
--insert into lection_videourls values(10, 'http://www.youtube.com/embed/0SARbwvhupQ');
--insert into lection_videourls values(11, 'http://www.youtube.com/embed/Hl-zzrqQoSE');
--insert into lection_videourls values(12, 'http://www.youtube.com/embed/KkMDCCdjyW8');
--insert into lection_videourls values(12, 'http://www.youtube.com/embed/nziy2_U5JQI');
--insert into lection_videourls values(13, 'http://www.youtube.com/embed/Ps8jOj7diA0');
--insert into lection_videourls values(14, 'http://www.youtube.com/embed/3fyvJcSMrVw');

--
-- TOC entry 1886 (class 0 OID 38287)
-- Dependencies: 1540 1885
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (1, 'Essay', '2012-02-01', '2012-02-08', 'Essay1', 1, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (2, 'Essay', '2012-03-01', '2012-03-08', 'Essay2', 2, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (3, 'Essay', '2012-04-01', '2012-04-08', 'Essay3', 1, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (4, 'Essay', '2012-05-01', '2012-05-08', 'Essay4', 4, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (5, 'Homework', '2012-02-08', '2012-02-15', 'Homework1', 1, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (6, 'Homework', '2012-03-08', '2012-03-15', 'Homework2', 2, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (7, 'Homework', '2012-04-08', '2012-04-15', 'Homework3', 2, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (8, 'Homework', '2012-05-08', '2012-05-15', 'Homework4', 3, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (9, 'Homework', '2012-06-08', '2012-06-15', 'Homework5', 4, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (10, 'Quiz', '2012-02-15', '2012-02-25', 'Quiz1', 1, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (11, 'Quiz', '2012-03-15', '2012-03-25', 'Quiz2', 2, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (12, 'Quiz', '2012-04-15', '2012-04-25', 'Quiz3', 3, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (13, 'Quiz', '2012-05-15', '2012-05-25', 'Quiz4', 1, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (14, 'Quiz', '2012-06-15', '2012-06-25', 'Quiz5', 2, '', '', '', '');
INSERT INTO task (id, dtype, datebegin, dateend, description, course_id, target, vcsurl, text, topic) VALUES (15, 'Quiz', '2012-07-15', '2012-07-25', 'Quiz6', 1, '', '', '', '');


--
-- TOC entry 1888 (class 0 OID 38303)
-- Dependencies: 1542 1885 1886 1884 1886 1886
-- Data for Name: courseplanitem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (1, 1,'2012-01-01', 1, 1, 5, 1, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (2, 2,'2012-01-07', 1, NULL, 6, 2, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (3, 3,'2012-01-15', 1, NULL, NULL, 3, 10);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (4, 4,'2012-01-24', 1, NULL, NULL, 4, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (5, 5,'2012-01-30', 1, 2, 7, 5, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (6, 6,'2012-02-01', 1, NULL, NULL, 18, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (7, 1,'2012-02-07', 2, NULL, 8, 6, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (8, 2,'2012-02-12', 2, 3, NULL, 7, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (9, 3,'2012-02-18', 2, NULL, NULL, 8, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (10, 4,'2012-02-24', 2, NULL, NULL, 9, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (11, 5,'2012-02-29', 2, NULL, NULL, 10, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (12, 6,'2012-03-01', 2, NULL, NULL, 11, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (13, 7,'2012-03-07', 1, 4, 9, 12, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (14, 7,'2012-03-14', 1, NULL, NULL, 13, 11);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (15, 8,'2012-03-21', 1, NULL, NULL, 14, 12);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (16, 7,'2012-03-29', 2, NULL, NULL, 15, 13);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (17, 8,'2012-04-01', 2, NULL, NULL, 16, NULL);
INSERT INTO courseplanitem (id, phase,date, course_id, essay_id, homework_id, lection_id, quiz_id) VALUES (18, 9,'2012-04-07', 2, NULL, NULL, 17, 14);


--
-- TOC entry 1904 (class 0 OID 38369)
-- Dependencies: 1558 1886
-- Data for Name: essay_topicspool; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1901 (class 0 OID 38360)
-- Dependencies: 1555 1886
-- Data for Name: homework_commitedfileurls; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1902 (class 0 OID 38363)
-- Dependencies: 1556 1886
-- Data for Name: homework_targetspool; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1903 (class 0 OID 38366)
-- Dependencies: 1557 1886
-- Data for Name: homework_usefulfileurls; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1892 (class 0 OID 38329)
-- Dependencies: 1546 1884
-- Data for Name: lection_audiourls; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1893 (class 0 OID 38332)
-- Dependencies: 1547 1884
-- Data for Name: lection_fileurls; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1894 (class 0 OID 38335)
-- Dependencies: 1548 1884
-- Data for Name: lection_videourls; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1900 (class 0 OID 38357)
-- Dependencies: 1554 1886
-- Data for Name: quiz_answers; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1897 (class 0 OID 38348)
-- Dependencies: 1551 1886
-- Data for Name: quiz_answerspool; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1898 (class 0 OID 38351)
-- Dependencies: 1552 1886
-- Data for Name: quiz_questions; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1899 (class 0 OID 38354)
-- Dependencies: 1553 1886
-- Data for Name: quiz_questionspool; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1890 (class 0 OID 38316)
-- Dependencies: 1544 1885
-- Data for Name: registrationrequestitem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (1, '1970-01-01', 'abracadabra', 'John Smith', 1);
INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (2, '1970-02-01', 'shaitan', 'Bruce Lee', 1);
INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (3, '1970-01-01', 'willis', 'Bruce Willis', 1);
INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (4, '1970-01-03', 'johnny', 'B. Good', 1);
INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (5, '1970-04-01', 'valera', 'Edinson Cavani', 2);
INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (6, '1970-01-01', 'maika', 'maika richards', 2);
INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (7, '1970-05-01', 'dodo', 'Dodo Dumbia', 2);
INSERT INTO registrationrequestitem (id, birthday, login, name, course_id) VALUES (8, '1970-01-01', 'remba', 'John Rembo', 2);


 --
-- TOC entry 1891 (class 0 OID 38324)
-- Dependencies: 1545 1887
-- Data for Name: gradebook; Type: TABLE DATA; Schema: public; Owner: postgres
--
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(1,5,1,1,1);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(2,4,1,2,1);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(3,3,1,3,1);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(4,2,1,4,1);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(5,1,1,5,1);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(6,5,1,6,1);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(7,5,1,1,2);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(8,4,1,2,2);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(9,3,1,3,2);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(10,2,1,4,2);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(11,1,1,5,2);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(12,5,1,6,2);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(13,5,2,7,7);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(14,5,2,8,8);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(15,5,2,9,9);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(16,2,2,10,10);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(17,1,2,11,11);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(18,2,2,12,12);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(19,2,2,13,7);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(20,1,2,14,8);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(21,1,2,15,9);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(22,4,2,16,10);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(23,4,2,17,16);
INSERT INTO gradebook(id,mark,course_id,student_id,courseplanitem_id)VALUES(24,4,2,18,18);

--
-- TOC entry 1905 (class 0 OID 38497)
-- Dependencies: 1559
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN_TABLE', 0);
SELECT pg_sleep(5);
update sequence set seq_count = (select max(n_live_tup) from pg_stat_user_tables) where seq_name = 'SEQ_GEN_TABLE';