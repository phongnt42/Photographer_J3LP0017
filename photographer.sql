select * from contact
select * from galery
select * from [image]

create database photographer
go
use [photographer]
go
create table [gallery](
     ID int IDENTITY(1,1) not null primary key,
	 [Name] varchar(max),
	 [mainImage] varchar(max),
	 [description] varchar(max)
)

create table [image](
     ID int IDENTITY(1,1) not null primary key,
	 [url] varchar(max),
	 [galleryID] int,
	 CONSTRAINT FK_ImageGallery FOREIGN KEY (ID)
    REFERENCES [gallery](ID)
)

create table [contact](
	ID int IDENTITY(1,1) not null primary key,
	aboutMe varchar(max),
	contactImage varchar(max),
    [address] varchar(max),
    city varchar(max),
    country varchar(max),
    telephone varchar(max),
    email varchar(max),
    mapLocationUrl varchar(max),
    facebookUrl varchar(max),
    twitterUrl varchar(max),
    googleUrl varchar(max),
    iconFacebook varchar(max),
    iconTwitter varchar(max),
    iconGoogle varchar(max),
)

select * from contact

insert into contact values(
'About me  Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim',
'Thach That, Hoa Lac', 'Ha Noi', 'Vietnam', '0123456789', 'myGallary@gmail.com', 
'https://maps.google.com/maps?width=100%&amp;height=600&amp;hl=en&amp;q=9%20Ng%C3%B5%20116%20Ph%E1%BB%91%20Mi%E1%BA%BFu%20%C4%90%E1%BA%A7m%2C%20T%E1%BB%AB%20Li%C3%AAm%2C%20H%C3%A0%20N%E1%BB%99i+()&amp;ie=UTF8&amp;t=&amp;z=14&amp;iwloc=B&amp;output=embed',
''
)