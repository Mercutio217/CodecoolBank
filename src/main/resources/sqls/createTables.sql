
CREATE TABLE IF NOT EXISTS `Customers` (
    `id`    INTEGER PRIMARY KEY AUTOINCREMENT,
    `FirstName `    TEXT NOT NULL,
    `LastName`    TEXT NOT NULL,
    `Login`    TEXT NOT NULL,
    `Password`    TEXT NOT NULL,
    `CreateDate`    TEXT NOT NULL,
    `IsActive`    INTEGER NOT NULL,
    `LastLogin`    TEXT
);

INSERT INTO 'Customers' ("FirstName ", LastName, Login, Password, CreateDate, IsActive, LastLogin) VALUES
  ('Janusz', 'Pień', 'jpien', 'loglady', '12-01-1999', 1, '01-06-2017'),
  ('Anna', 'Winnicka', 'awin', '12345', '12-01-1997', 0, '01-07-2007'),
  ('Robert', 'Sadzonka', 'rsadz', 'rplant', '07-07-1977', 1, '05-06-2017'),
  ('Mikołaj', 'Pieczara', 'mpiecz', 'ncave', '18-03-1980', 0, '01-04-2017'),
  ('Witold', 'Wioldowski', 'ww', 'ww', '12-12-1968', 1, '23-05-2017');

CREATE TABLE IF NOT EXISTS  `Accounts` (
    `AccountId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `CustomerId`    INTEGER NOT NULL,
    `Number`    TEXT NOT NULL,
    `AccountTypeId`    INTEGER NOT NULL,
    `AccountStatusID`    INTEGER NOT NULL,
    `OpenDate`    TEXT NOT NULL,
    `Balance`    INTEGER NOT NULL,
    `DebitLine`    INTEGER,
    `Interest`    INTEGER NOT NULL
);

INSERT INTO 'Accounts' (CustomerId, Number, AccountTypeId, AccountStatusID, OpenDate, Balance, DebitLine, Interest) VALUES
  (1, '785934759384y6703449873209', 1, 1, '17-01-2016', 17876, '20000000', '05'),
  (1, 'AZ70 MYDP NWNB 2WI1 NQQX SRVG FFDJ', 2, 1, '4-24-1978', 12344, '96924468', '11'),
  (2, 'AT51 3944 2533 8547 1133', 2, 1, '2-13-1932', 19312657, '12455', '9'),
  (3, 'EE43 6313 0808 2924 9010', 2, 1, '3-7-1954', 17153630, '124535', '11'),
  (4, 'FR38 5023 1414 35AI RKET BQCC G97', 2, 2, '6-30-2005', 3544, '6894377', '14'),
  (5, 'AE49 4101 3378 3836 5170 529', 1, 2, '6-14-2011',32546, '35987088', '12');


CREATE TABLE IF NOT EXISTS  `Cards` (
    `CardId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `CardNumber`    TEXT NOT NULL,
    `CardTypeId`    INTEGER NOT NULL,
    `Validity`    TEXT NOT NULL,
    `BuyingLimit`    INTEGER NOT NULL,
    `CashWithdrawLimit`    INTEGER NOT NULL,
    `Limit`    INTEGER,
    `AccountId`    INTEGER NOT NULL
);

insert into 'Cards' (CardNumber, CardTypeId, Validity, BuyingLimit, CashWithdrawLimit, 'Limit', AccountId) values ('3559389749532012', 2, '16-9-2019', 2757982, 4339880, 21215844, 1);
insert into 'Cards' (CardNumber, CardTypeId, Validity, BuyingLimit, CashWithdrawLimit, 'Limit', AccountId) values ('36150241188888', 1, '15-1-2018', 4246462, 4384390, 89903381, 2);
insert into 'Cards' (CardNumber, CardTypeId, Validity, BuyingLimit, CashWithdrawLimit, 'Limit', AccountId) values ('3586236776597789', 2, '13-7-2017', 3511624, 2428350, 31314995, 5);
insert into 'Cards' (CardNumber, CardTypeId, Validity, BuyingLimit, CashWithdrawLimit, 'Limit', AccountId) values ('5506916050068761', 1, '3-3-2018', 3794525, 4250141, 37060874, 5);
insert into 'Cards' (CardNumber, CardTypeId, Validity, BuyingLimit, CashWithdrawLimit, 'Limit', AccountId) values ('3568673219782572', 1, '2-4-2018', 4978422, 914355, 20379971, 4);


CREATE TABLE IF NOT EXISTS  `Transactions` (
    `TransactionId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `DateOfTransaction`    TEXT NOT NULL,
    `TransactionTypeId`    INTEGER NOT NULL,
    `Value`    INTEGER NOT NULL,
    `Description`    TEXT NOT NULL,
    `TransactionStatusId`    INTEGER NOT NULL,
    `AccountId`    TEXT NOT NULL,
    `CardId`    INTEGER
);

insert into Transactions (DateOfTransaction, TransactionTypeId, Value, Description, TransactionStatusId, AccountId, CardId) values ('29-4-2017', 1, 1685121, 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', 1, 5, 4);
insert into Transactions (DateOfTransaction, TransactionTypeId, Value, Description, TransactionStatusId, AccountId, CardId) values ('4-8-2015', 3, 390618, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', 3, 1, 7);
insert into Transactions (DateOfTransaction, TransactionTypeId, Value, Description, TransactionStatusId, AccountId, CardId) values ('5-12-2015', 3, 180448, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.', 1, 3, 2);
insert into Transactions (DateOfTransaction, TransactionTypeId, Value, Description, TransactionStatusId, AccountId, CardId) values ('10-5-2014', 3, 3534693, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque.', 2, 1, 3);
insert into Transactions (DateOfTransaction, TransactionTypeId, Value, Description, TransactionStatusId, AccountId, CardId) values ('31-12-2012', 3, 3062044, 'Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst.', 3, 5, 2);


CREATE TABLE IF NOT EXISTS  `TransactionTypes` (
    `TransactionTypeId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);

insert into TransactionTypes (Name, Description) values ('Transfer', 'In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla.');
insert into TransactionTypes (Name, Description) values ('Deposit', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.');
insert into TransactionTypes (Name, Description) values ('Withdrawal', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.');

CREATE TABLE IF NOT EXISTS  `CardTypes` (
    `CardTypeId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);

insert into CardTypes (Name, Description) values ('Debit', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.');
insert into CardTypes (Name, Description) values ('Credit', 'Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus.');

CREATE TABLE IF NOT EXISTS  `TransactionStatuses` (
    `TransactionStatusId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);

insert into TransactionStatuses (Name, Description) values ('Finished', 'Cras non velit nec nisi vulputate nonummy.');
insert into TransactionStatuses (Name, Description) values ('In Progress', 'Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.');
insert into TransactionStatuses (Name, Description) values ('Cancelled', 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.');


CREATE TABLE  IF NOT EXISTS  `AccountTypes` (
    `AccountTypeId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);

insert into AccountTypes (Name, Description) values ('Saving Account', 'Quisque porta volutpat erat.');
insert into AccountTypes (Name, Description) values ('Credit Account', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam.');


CREATE TABLE IF NOT EXISTS  `AccountStatuses` (
    `AccountStatusId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);
insert into AccountStatuses (Name, Description) values ('Active', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.');
insert into AccountStatuses (Name, Description) values ('Non active', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.');
