select count(*) as COUNT 
from ECOLI_DATA A 
where 1=1
AND(A.GENOTYPE & 2) != 2
AND((A.GENOTYPE & 4) = 4 
    OR A.GENOTYPE & 1 = 1);