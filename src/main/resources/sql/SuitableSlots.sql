

insert into SuitableSlots (item, equipmentSlot) values ( (select item.id from Item item where item.name = 'Leather boots'), (select slot.id from Equipmentslottype slot where slot.name = 'Head'))


