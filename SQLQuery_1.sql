SELECT * FROM category
-- Phan trang 5 phan tu/trang 
-- 3 trang 
--  5 phan tu dau tien 
SELECT * 
FROM category
ORDER BY id 
OFFSET X1 ROWS 
FETCH NEXT X2 ROW ONLY

-- X2: So luong phan tu trong 1 trang 
-- 1-> 5: X1: vi tri - 1
SELECT * 
FROM category
ORDER BY id 
OFFSET 0 ROWS 
FETCH NEXT 5 ROW ONLY
-- Trang 2
SELECT * 
FROM category
ORDER BY id 
OFFSET 10 ROWS 
FETCH NEXT 5 ROW ONLY