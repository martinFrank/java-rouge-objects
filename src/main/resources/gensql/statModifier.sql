INSERT INTO StatModifer (item, stat, operator, value) VALUES (
    (SELECT item.id FROM Item item WHERE item.name = 'Steel dagger'),
    (SELECT stat.id FROM Stat stat WHERE stat.name = 'Dexterity'), 'Plus', 1.2);



