

INSERT INTO Item (name, itemtype, worth, weight) VALUES ('Steel dagger', (SELECT itemtype.id FROM Itemtype itemtype WHERE itemtype.name = 'Short blade') ,11.2, 352.2)
INSERT INTO Item (name, itemtype, worth, weight) VALUES ('Leather helmet', (SELECT itemtype.id FROM Itemtype itemtype WHERE itemtype.name = 'Helmet'), 13.2, 565.4)
INSERT INTO Item (name, itemtype, worth, weight) VALUES ('Steel chain mail', (SELECT itemtype.id FROM Itemtype itemtype WHERE itemtype.name = 'Body armor'), 243.2, 6261.3)
INSERT INTO Item (name, itemtype, worth, weight) VALUES ('Leather boots', (SELECT itemtype.id FROM Itemtype itemtype WHERE itemtype.name = 'Feet wear'), 16.2, 967.5)


