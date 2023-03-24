SELECT 
    no, 
    AVAILABLE, 
    CASE 
        WHEN available = 0 THEN '삭제된 글입니다.'
        WHEN available = 1 THEN subject
    END AS subject
FROM replyboard a ORDER BY regroup DESC, relevel ASC;

DELETE FROM REPLYBOARD WHERE NO = 84 and no = 85;

DELETE FROM REPLYBOARD;
commit;
SELECT no,
        subject,
        name,
        password,
        regdate,
        contents,
        regroup,
        relevel,
        restep,
        hit
FROM replyboard
ORDER BY regroup DESC, relevel ASC;
--------------------------------------------------------------------------------
SELECT * FROM REPLYBOARD;
SELECT 
    ROWNUM as num,
    a.no,
    a.subject,
    a.name,
    a.password,
    a.regdate,
    a.contents,
    a.available,
    a.regroup,
    a.relevel,
    a.restep,
    a.hit
FROM 
(SELECT no, 
CASE 
        WHEN available = 0 THEN '삭제된 글입니다.'
        WHEN available = 1 THEN subject
END AS subject, name, password, regdate, 
contents, available, regroup, relevel, restep, hit FROM REPLYBOARD) a ;

SELECT 
        ROWNUM as num,
        a.no,
        a.subject,
        a.name,
        a.password,
        a.regdate,
        a.contents,
        a.available,
        a.regroup,
        a.relevel,
        a.restep,
        a.hit
    FROM 
    (SELECT no, 
    CASE 
            WHEN available = 0 THEN '삭제된 글입니다.'
            WHEN available = 1 THEN subject
    END AS subject, name, password, regdate, 
    contents, available, regroup, relevel, restep, hit 
    FROM REPLYBOARD
    order by regroup desc, relevel desc) a ;

--------
SELECT no, 
CASE 
        WHEN available = 0 THEN '삭제된 글입니다.'
        WHEN available = 1 THEN subject
END AS subject, name, password, regdate, 
contents, available, regroup, relevel, restep, hit FROM REPLYBOARD;
----------------------------------------------------------------------------
delete from replyboard where no = 97;
commit;
----------------------------------------------------------------------------
SELECT 
    ROWNUM as num,
    a.no,
    a.subject,
    a.name,
    a.password,
    a.regdate,
    a.contents,
    a.available,
    a.regroup,
    a.relevel,
    a.restep,
    a.hit
FROM 
(SELECT no, 
CASE 
        WHEN available = 0 THEN '삭제된 글입니다.'
        WHEN available = 1 THEN subject
END AS subject, name, password, regdate, 
contents, available, regroup, relevel, restep, hit FROM REPLYBOARD
order by regroup desc, relevel asc) a ;
-------------------
SELECT * FROM REPLYBOARD WHERE NO = 99 AND PASSWORD = 123;