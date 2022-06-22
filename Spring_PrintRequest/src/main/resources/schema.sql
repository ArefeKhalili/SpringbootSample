DROP TABLE IF EXISTS T_PrintRequest;

CREATE TABLE T_PrintRequest
(
    id              VARCHAR(20) PRIMARY KEY NOT NULL,
    c_cardPAN       VARCHAR(20),
    c_personnelCode VARCHAR(20)             NOT NULL,
    c_branchCode    VARCHAR(20)             NOT NULL,
    c_ipAddress     VARCHAR(20)
)