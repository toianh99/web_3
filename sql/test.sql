create table brand
(
    ID     int auto_increment
        primary key,
    Name   varchar(255) null,
    Code   varchar(255) null,
    `Desc` varchar(255) null
);

create table cartitem
(
    ID           int auto_increment
        primary key,
    NameItem     varchar(255) null,
    NameCustomer varchar(255) null,
    Number       varchar(255) null
);

create table category
(
    ID     int auto_increment
        primary key,
    Name   varchar(255) null,
    Code   varchar(255) null,
    `Desc` varchar(255) null
);

create table class
(
    ID int auto_increment
        primary key
);

create table commune
(
    NameCommune varchar(255) not null,
    type        varchar(45)  not null,
    xaid        varchar(5)   not null
        primary key,
    maqh        varchar(5)   not null
);

create table customer_orderitem
(
    CustomerID int auto_increment
        primary key
);

create table devvn_xaphuongthitran
(
    xaid varchar(5) charset utf8   not null,
    name varchar(100) charset utf8 not null,
    type varchar(30) charset utf8  not null,
    maqh varchar(5) charset utf8   not null
)
    charset = latin1;

create table dictrict
(
    ID           int auto_increment,
    NameDictrict varchar(255) not null,
    maqh         varchar(5)   not null,
    type         varchar(45)  not null,
    matp         varchar(5)   not null,
    primary key (ID, maqh)
);

create table inventory
(
    ID          int auto_increment
        primary key,
    NameProduct varchar(255) null,
    Quantity    int          not null,
    PriceIn     int          not null,
    Staff       varchar(255) null
);

create table payment
(
    ID          int auto_increment
        primary key,
    NamePayment varchar(255) null,
    Type        varchar(255) null,
    `Desc`      varchar(255) null
);

create table permission
(
    ID     int auto_increment
        primary key,
    Name   varchar(255) null,
    Code   varchar(255) null,
    `Desc` varchar(255) null
);

create table province
(
    NameProvince varchar(255) not null,
    matp         varchar(5)   not null
        primary key,
    type         varchar(45)  not null
);

create table publisher
(
    ID     int auto_increment
        primary key,
    Name   varchar(255) null,
    `Desc` varchar(255) null
);

create table role
(
    ID     int auto_increment
        primary key,
    Name   varchar(255) null,
    Code   varchar(255) null,
    `Desc` varchar(255) null
);

create table role_permission
(
    RoleID       int not null,
    PermissionID int not null,
    primary key (RoleID, PermissionID),
    constraint FKRole_Permi373264
        foreign key (RoleID) references role (ID),
    constraint FKRole_Permi82941
        foreign key (PermissionID) references permission (ID)
);

create table sale
(
    ID      int auto_increment
        primary key,
    Name    varchar(255) null,
    Percent int          not null,
    `Desc`  varchar(255) null
);

create table shipaddress
(
    ID       int auto_increment
        primary key,
    Province varchar(255) null,
    Commune  varchar(255) null,
    Dictrict varchar(255) null,
    Detail   varchar(255) null
);

create table shipment
(
    ID       int auto_increment
        primary key,
    NameShip varchar(255) null,
    Type     varchar(255) null,
    `Desc`   varchar(255) null
);

create table user
(
    ID       int auto_increment
        primary key,
    Username varchar(255) null,
    Password varchar(255) null,
    Roles    int          null
);

create table customer
(
    Email       varchar(255) null,
    PhoneNumber varchar(255) null,
    UserID      int          not null
        primary key,
    FirstName   varchar(50)  null,
    LastName    varchar(50)  null,
    constraint FKCustomer697196
        foreign key (UserID) references user (ID)
);

create table staff
(
    Posittion varchar(255) null,
    Task      varchar(255) null,
    UserID    int          not null
        primary key,
    constraint FKStaff312633
        foreign key (UserID) references user (ID)
);

create table orderitem
(
    ID            int auto_increment
        primary key,
    ShipaddressID int          not null,
    ShipmentID    int          not null,
    `Payment ID`  int          not null,
    CartItemID    int          not null,
    StaffID       int          not null,
    NameItem      varchar(255) null,
    NameCustomer  varchar(255) null,
    Number        varchar(255) null,
    Price         int          not null,
    Sale          int          not null,
    Date          date         null,
    NameStaff     varchar(255) null,
    Status        varchar(255) null,
    Shipaddress   int          null,
    UserID        int          not null,
    UserID2       int          not null,
    UserID3       int          null,
    StaffUserID   int          not null,
    constraint FKOrderItem307425
        foreign key (CartItemID) references cartitem (ID),
    constraint FKOrderItem371392
        foreign key (`Payment ID`) references payment (ID),
    constraint FKOrderItem402423
        foreign key (ShipaddressID) references shipaddress (ID),
    constraint FKOrderItem744479
        foreign key (StaffUserID) references staff (UserID),
    constraint FKOrderItem866685
        foreign key (ShipmentID) references shipment (ID)
);

create table customer_orderitem2
(
    CustomerUserID int not null,
    OrderItemID    int not null,
    primary key (CustomerUserID, OrderItemID),
    constraint FKCustomer_O406951
        foreign key (OrderItemID) references orderitem (ID),
    constraint FKCustomer_O57288
        foreign key (CustomerUserID) references customer (UserID)
);

create table product
(
    ID          int auto_increment
        primary key,
    SaleID      int          not null,
    OrderItemID int          not null,
    CartItemID  int          not null,
    inventoryID int          not null,
    PublisherID int          not null,
    BrandID     int          not null,
    CategoryID  int          not null,
    Price       int          null,
    Category    varchar(255) null,
    Brand       varchar(255) null,
    Publisher   varchar(255) null,
    Quantity    int          not null,
    Color       varchar(255) null,
    constraint FKProduct279987
        foreign key (inventoryID) references inventory (ID),
    constraint FKProduct325786
        foreign key (PublisherID) references publisher (ID),
    constraint FKProduct365906
        foreign key (CategoryID) references category (ID),
    constraint FKProduct415630
        foreign key (CartItemID) references cartitem (ID),
    constraint FKProduct56091
        foreign key (OrderItemID) references orderitem (ID),
    constraint FKProduct960541
        foreign key (BrandID) references brand (ID),
    constraint FKProduct99009
        foreign key (SaleID) references sale (ID)
);

create table user_orderitem
(
    UserID2 int not null,
    UserID3 int not null,
    primary key (UserID2, UserID3)
);

create table user_role
(
    UserID int not null,
    RoleID int not null,
    primary key (UserID, RoleID),
    constraint FKUser_Role494723
        foreign key (RoleID) references role (ID),
    constraint FKUser_Role973318
        foreign key (UserID) references user (ID)
);

