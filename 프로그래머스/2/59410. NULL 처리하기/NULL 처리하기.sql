-- 코드를 입력하세요
SELECT ANIMAL_TYPE, 
    case
        when NAME IS NULL then "No name"
        else NAME
    end as NAME,
SEX_UPON_INTAKE
from ANIMAL_INS
ORDER BY ANIMAL_ID;