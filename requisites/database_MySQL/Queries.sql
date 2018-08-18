use bookstoredb;

create table BookCategory
(
	categoryId int not null auto_increment primary key,
    categoryName varchar(255) not null
);

create table Book
(
	bookId int not null auto_increment primary key,
    bookName varchar(255) not null,
    bookPrice float not null,
    bookAuthor varchar(255) not null,
    bookPublisher varchar(255),
    bookPublishedDate date,
    bookImageURL varchar(500),
    bookQuantity int,
    bookImageName varchar(255) unique
);

create table User
(
	userId int not null auto_increment primary key,
    userFName varchar(255),
    userLName varchar(255),
    userAddress varchar(255),
    userDOB date,
    userPhoneNo varchar(20),
    userGender char(1),
    userUsername varchar(255),
    userPassword varchar(255),
    isAdmin bit
);

create table Book_BookCategory
(
	bookId int not null,
    categoryId int not null,
    constraint fk_Book_BookCategory_bookId foreign key (bookId) references Book(bookId),
    constraint fk_Book_BookCategory_categoryId foreign key (categoryId) references BookCategory(categoryId)
);

create table Book_User
(
	bookId int not null,
	userId int not null,
    quantity int,
    constraint fk_Book_User_bookId foreign key (bookId) references Book(bookId),
    constraint fk_Book_user_userId foreign key (userId) references User(userId)
);

create table UserCategoryInterest
(
	categoryId int not null,
	userId int not null,
    constraint fk_UserCategoryInterest_categoryId foreign key (categoryId) references BookCategory(categoryId),
    constraint fk_UserCategoryInterest_userId foreign key (userId) references User(userId)
);

show tables;