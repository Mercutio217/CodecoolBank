
CREATE TABLE IF NOT EXISTS `Customers` (
    `id`    INTEGER PRIMARY KEY AUTOINCREMENT,
    `FirstName`    TEXT NOT NULL,
    `LastName`    TEXT NOT NULL,
    `Login`    TEXT NOT NULL,
    `Password`    TEXT NOT NULL,
    `CreateDate`    TEXT NOT NULL,
    `IsActive`    INTEGER NOT NULL,
    `LastLogin`    TEXT
);

CREATE TABLE IF NOT EXISTS  `Accounts` (
    `AccountId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `CustomerId`    INTEGER NOT NULL,
    `Number`    TEXT NOT NULL,
    `AccountTypeId`    INTEGER NOT NULL,
    `AccountStatusId`    INTEGER NOT NULL,
    `OpenDate`    TEXT NOT NULL,
    `Balance`    INTEGER NOT NULL,
    `DebitLine`    INTEGER,
    `Interest`    INTEGER NOT NULL
);

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


CREATE TABLE IF NOT EXISTS  `Transactions` (
    `TransactionId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `DateOfTransaction`    TEXT NOT NULL,
    `TransactionTypeId`    INTEGER NOT NULL,
    `Value`    INTEGER NOT NULL,
    `Description`    TEXT NOT NULL,
    `TransactionStatusId`    INTEGER NOT NULL,
    `SourceAccountId`    TEXT NOT NULL,
    `SourceCardId`    INTEGER,
    `DestinationAccountId` INTEGER
);

CREATE TABLE IF NOT EXISTS  `TransactionTypes` (
    `TransactionTypeId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);

CREATE TABLE IF NOT EXISTS  `CardTypes` (
    `CardTypeId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);

CREATE TABLE IF NOT EXISTS  `TransactionStatuses` (
    `TransactionStatusId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);


CREATE TABLE  IF NOT EXISTS  `AccountTypes` (
    `AccountTypeId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);


CREATE TABLE IF NOT EXISTS  `AccountStatuses` (
    `AccountStatusId`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `Name`    TEXT NOT NULL,
    `Description`    TEXT
);
