

insert into SuitableSlots (item, equipmentSlot) values ( (select item.id from Item item where item.name = 'Leather boots'), (select slot.id from Equipmentslottype slot where slot.name = 'Feet'))

insert into SuitableSlots (item, equipmentSlot) values ( (select item.id from Item item where item.name = 'Steel dagger'), (select slot.id from Equipmentslottype slot where slot.name = 'Primary hand'))
insert into SuitableSlots (item, equipmentSlot) values ( (select item.id from Item item where item.name = 'Steel dagger'), (select slot.id from Equipmentslottype slot where slot.name = 'Secondary hand'))
