-- 创建数据库
DROP DATABASE IF EXISTS huiban;
CREATE DATABASE huiban DEFAULT CHARSET utf8;

-- 使用数据库
use huiban;

-- SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS conference;
DROP TABLE IF EXISTS journal;
DROP TABLE IF EXISTS followList;
DROP TABLE IF EXISTS followList2;
DROP TABLE IF EXISTS attendList;
DROP TABLE IF EXISTS attendList2;
DROP TABLE IF EXISTS comment;


-- -------------------------
-- 用户表：记录用户的详细信息
-- -------------------------
CREATE TABLE user
(
    id           int NOT NULL  AUTO_INCREMENT COMMENT '编号id',
    email        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
    image_url    varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
    user_name    varchar(32)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
    institution  varchar(64)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构',
    password    varchar(8)   CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
    PRIMARY KEY (id) USING BTREE,
    UNIQUE INDEX (email) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT ='用户信息表';

-- 初始化用户信息
INSERT INTO user VALUES (null, 'chm120302@126.com', 'https://ts1.cn.mm.bing.net/th/id/R-C.748160bf925a7acb3ba1c9514bbc60db?rik=AYY%2bJ9WcXYIMgw&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50017%2f0822.jpg_wh1200.jpg&ehk=CMVcdZMU6xxsjVjafO70cFcmJvD62suFC1ytk8UuAUk%3d&risl=&pid=ImgRaw&r=0', 'chm', 'ECNU', '123456');
INSERT INTO user VALUES (null, 'xxx@163.com', 'https://ts1.cn.mm.bing.net/th/id/R-C.6b9074faed6dae2a0457e690c2aa3a03?rik=6V%2fv2rXhPCf7Pg&riu=http%3a%2f%2fn.sinaimg.cn%2fsinacn20115%2f534%2fw1280h854%2f20190221%2f9461-htknpmf9890147.jpg&ehk=RyGDdQrMiIWbz7Uxa%2fLSPOz2iXvM8JpbkBIZgttQkWc%3d&risl=&pid=ImgRaw&r=0', 'admin', 'ECNU', '12345678');



-- ---------------------------
-- 会议表: 关于会议的信息
-- ---------------------------
CREATE TABLE conference
(
    id                   int NOT NULL  AUTO_INCREMENT COMMENT '编号id',
    conference_id        varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议号',
    title                varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议简称',
    full_title           varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议全称',
    ccf_rank             varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'CCF等级',
    sub                  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '所在领域',
    year                 int  NOT NULL COMMENT '会议年份',
    dblp_link            varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议dblp链接',
    mainpage_link        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议主页链接',
    place                varchar(256)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议地点',
    abstract_deadline    date NULL DEFAULT NULL COMMENT '摘要截止时间',
    paper_deadline       date NULL DEFAULT NULL COMMENT '全文截止时间',
    start_time           date NULL DEFAULT NULL COMMENT '会议开始时间',
    end_time             date NULL DEFAULT NULL COMMENT '会议结束时间',
    follow_num           int NULL DEFAULT 0 COMMENT '会议收藏数量',
    attend_num           int NULL DEFAULT 0 COMMENT '会议参加数量',
    accepted_rate        float  NULL DEFAULT NULL COMMENT '会议录用率',
    session_num          int NULL DEFAULT 1 COMMENT '会议举办届数',
    topic_details        text  CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '会议主题',
    is_postponed         boolean NOT NULL DEFAULT false COMMENT '是否延期',
    PRIMARY KEY (id) USING BTREE,
    UNIQUE INDEX (conference_id) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT ='会议信息表';

-- 初始化会议信息
INSERT INTO conference VALUES (null, 'date2023', 'DATE', 'Design, Automation & Test in Europe', 'B','DS','2023', 'https://dblp.org/db/conf/date/index.html', 'https://date23.date-conference.com/', 'Valencia, Spain','2022-09-18', '2022-09-25', '2023-09-17', '2023-09-20',0, 0, NULL, 26,
                               'Within the scope of the conference, the main areas of interest are organised in the following tracks. Submissions can be made to any of the track topics.

Track D: Design Methods and Tools, addresses design automation, design tools and hardware architectures for electronic and embedded systems. The emphasis is on methods, algorithms, and tools related to the use of computers in designing complete systems. The track focus includes significant improvements on existing design methods and tools as well as forward-looking approaches to model and design future system architectures, design flows, and environments.

This track is organised in the following topics:

    D1 System Specification and Modelling, Click here for details
    D2 System-Level Design Methodologies and High-Level-Synthesis, Click here for details
    D3 System Simulation and Validation, Click here for details
    DT4 Design and Test for Analog and Mixed-Signal Circuits and Systems, and MEMS, Click here for details
    DT5 Design and Test of Hardware Security Primitives, Click here for details
    DT6 Design and Test of Secure Systems, Click here for details
    D7 Formal Methods and Verification, Click here for details
    D8 Network-on-Chip and on-chip communication, Click here for details
    D9 Architectural and Microarchitectural Design, Click here for details
    D10 Low-power, Energy-efficient and Thermal-aware Design, Click here for details
    D11 Approximate Computing, Click here for details
    D12 Reconfigurable Systems, Click here for details
    D13 Logical Analysis and Design, Click here for details
    D14 Physical Analysis and Design, Click here for details
    D15 Emerging Design Technologies for Future Computing, Click here for details
    D16 Emerging Design Technologies for Future Memories, Click here for details

Track A: Application Design, is devoted to the presentation and discussion of design experiences with a high degree of industrial relevance, real-world implementations, and applications of specific design and test methodologies. Contributions should illustrate innovative or record-breaking design and test methodologies, which will provide viable solutions in tomorrow’s silicon, embedded systems, and large-scale systems. In topic A8, there is the opportunity to submit 2-page papers that expose industrial research and practice.

This track is organised in the following topics:

    A1 Power-efficient and Sustainable Computing, Click here for details
    A2 Smart Cities, Internet of Everything, Industry 4.0, Click here for details
    A3 Automotive Systems and Smart Energy Systems, Click here for details
    A4 Augmented Living and Personalised Healthcare, Click here for details
    A5 Secure Systems, Circuits, and Architectures, Click here for details
    A6 Self-adaptive and Context-aware Systems, Click here for details
    A7 Applications of Emerging Technologies, Click here for details
    A8 Industrial Experiences Brief Papers, Click here for details

Track T: Test and Dependability, covers all test, design-for-test, reliability, and design-for-robustness issues, at system-, chip-, circuit-, and device-level for both analogue and digital electronics. Topics of interest also include diagnosis, failure mode analysis, debug and post-silicon validation challenges, and test or fault injection methods addressing system security.

This track is organised in the following topics:

    T1 Modelling and Mitigation of Defects, Faults, Variability, and Reliability, Click here for details
    T2 Test Generation, Test Architectures, Design for Test, and Diagnosis, Click here for details
    T3 Dependability and System-Level Test, Click here for details
    DT4 Design and Test for Analog and Mixed-Signal Circuits and Systems, and MEMS, Click here for details
    DT5 Design and Test of Hardware Security Primitives, Click here for details
    DT6 Design and Test of Secure Systems, Click here for details

Track E: Embedded Systems Design, is devoted to the modelling, analysis, design, verification and deployment of embedded software or embedded/cyber-physical systems. Areas of interest include methods, tools, methodologies and development environments for real-time systems, cyber-physical systems, networked systems, and dependable systems. Emphasis is, also, on model-based design and verification, embedded software platforms, software compilation and integration for these systems.

This track is organised in the following topics:

    E1 Embedded Software Architecture, Compilers and Tool Chains, Click here for details
    E2 Real-time, Dependable and Privacy-Enhanced Systems, Click here for details
    E3 Machine Learning Solutions for Embedded and Cyber-Physical Systems, Click here for details
    E4 Design Methodologies for Machine Learning Architectures, Click here for details
    E5 Design Modelling and Verification for Embedded and Cyber-Physical Systems, Click here for details',false);

-- ---------------------------
-- 期刊表：记录期刊详细信息
-- ---------------------------
CREATE TABLE journal
(
    id             int NOT NULL  AUTO_INCREMENT COMMENT '编号id',
    journal_id        varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '期刊号(期刊全称)',
    ccf_rank             varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'CCF等级',
    sub                  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '所在领域',
    dblp_link            varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '期刊dblp链接',
    mainpage_link        varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '期刊主页链接',
    paper_deadline       date NULL DEFAULT NULL COMMENT '截稿时间',
    follow_num           int NULL DEFAULT 0 COMMENT '期刊收藏数量',
    impact_factor        float  NULL DEFAULT NULL COMMENT '期刊影响因子',
    publisher            varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '出版商',
    topic_details        text  CHARACTER SET utf8 COLLATE utf8_general_ci NULL  COMMENT '会议主题',
    is_postponed         boolean NOT NULL DEFAULT false COMMENT '是否延期',
    PRIMARY KEY (id) USING BTREE,
    UNIQUE INDEX (journal_id) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT ='期刊信息表';

-- 初始化期刊信息
INSERT INTO journal VALUES (null, 'IEEE Journal on Selected Areas in Communications', 'A', 'computer networking', 'https://dblp.org/db/journals/jsac/index.html', 'https://ieeexplore.ieee.org/xpl/RecentIssue.jsp?punumber=49', '2024-05-31', 0,  16.4, 'IEEE',
                            'Conventional security architectures and models are considered a single network architecture solution, where devices authenticated within the network are assumed to be implicitly trusted. Such a conventional solution assumes that once devices have been authenticated within the network, are free to access, move, or exfiltrate data. This may introduce security threats and attacks. Although such an approach may be adopted in certain network scenarios, it definitely cannot be applied to NGNs. Zero-Trust security was introduced to overcome these obstacles, in which it does not rely on entry-point authentication, but rather uses context-aware, dynamic, and intelligent authentication schemes to detect and prevent security threats and attacks. Given that zero-trust security is a new security paradigm, little work has been done in this area to secure NGNs using zero-trust models. Zero-trust security models will highly benefit from two elements: threat intelligence and decentralized authentication. Continuous and dynamic trust evaluation is needed to attain high levels of access control in NGN. The use of Artificial Intelligence (AI) and Deep Learning (DL) will grant tremendous capabilities for zero-trust architectures to maintain high levels of intrusion detection and prevention. Moreover, through decentralized authentication methods like blockchain, data will both be stored and shared safely.

This Special Issue aims to foster original research and innovative solutions on the above subject to tackle the challenging issues related to security and trust in NGNs. We welcome the dissemination of high-quality research on emerging ideas, approaches, theories, frameworks, and practices of zero-trust in NGNs. Researchers, developers, and industry experts are welcome to submit their work that may focus on fundamental methodological studies or use cases and application demonstrations.

Topics of interest include, but are not limited to:
- Utilizing zero-trust to secure wireless communication and networks.
- Securing critical infrastructure communication with zero-trust.
- Applying zero-trust for aerial communication and network security.
- Federated Deep Learning-based zero-trust models.
- Distributed and decentralized zero-trust architectures and frameworks for NGN.
- Blockchain-enabled zero-trust architectures and frameworks for NGN.
- Access management and identity authentication using zero-trust in NGN.
- Testing and evaluating zero-trust security in networks.
- Zero-trust for 6G applications and services.
- Security of virtual Environments (e.g., Metaverse) in 6G.
- Conflict detection using AI/ML embedding/representation models.
- Access management for AI/ML model life cycle management in 6G networks.
- Integration of Zero-trust at the physical, data link, and network layers of the OSI model. ', false);

INSERT INTO journal VALUES (null, 'IEEE Internet of Things', 'C', 'computer networking','', '', null,  0, null,  'IEEE', 'details', false);
INSERT INTO journal VALUES (null, 'TWC', 'B', 'computer networking', '', '', null,  0, null, 'IEEE', 'dd', false);

-- ---------------------------
-- 用户关注会议列表：记录用户收藏的会议
-- ---------------------------
CREATE TABLE followList
(
    id             int NOT NULL  AUTO_INCREMENT COMMENT '编号id',
    email          varchar(64)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    category       varchar(32)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类型(Conference)',
    academic_id    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议id或期刊id',
    PRIMARY KEY (id) USING BTREE,
    FOREIGN KEY (email) REFERENCES user (email)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户会议关注列表';


-- ---------------------------
-- 用户关注期刊列表：记录用户收藏的期刊
-- ---------------------------
CREATE TABLE followList2
(
    id             int NOT NULL  AUTO_INCREMENT COMMENT '编号id',
    email          varchar(64)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    category       varchar(32)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类型(Journal)',
    academic_id    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议id或期刊id',
    PRIMARY KEY (id) USING BTREE,
    FOREIGN KEY (email) REFERENCES user (email)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户会议关注列表';


-- 初始化关注列表
INSERT INTO followList VALUES (null, 'chm120302@126.com', 'conference', 'date2023');
INSERT INTO followList2 VALUES (null, 'chm120302@126.com', 'journal', 'IEEE Journal on Selected Areas in Communications');
INSERT INTO followList2 VALUES (null, 'chm120302@126.com', 'journal', 'IEEE Internet of Things');

-- ---------------------------
-- 用户参加会议列表：记录用户参加的会议
-- ---------------------------
CREATE TABLE attendList
(
    id             int NOT NULL  AUTO_INCREMENT COMMENT '编号id',
    email          varchar(64)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    category       varchar(32)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类型(Conference)',
    academic_id    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '会议id或期刊id',
    PRIMARY KEY (id) USING BTREE,
    FOREIGN KEY (email) REFERENCES user (email)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户参加会议/期刊列表';



-- -----------------------------
-- 评论表: 记录用户在会议/期刊页的评论
-- -----------------------------
CREATE TABLE comment
(
    id              int NOT NULL  AUTO_INCREMENT COMMENT '评论编号id',
    image_url       varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
    user_name       varchar(32)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
    comment_time    datetime DEFAULT NULL COMMENT '评论时间',
    content         text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论内容',
    category        varchar(32)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类型(Conference/ Journal)',
    academic_id     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '评论会议/期刊id',
    parent_id       int NOT NULL DEFAULT -1 COMMENT '父评论id',
    PRIMARY KEY (id) USING BTREE
 ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表';

