USE [master]
GO
-- NGẮT KẾT NỐI DATABASE KHI NÀO KHÔNG DROP ĐƯỢC THÌ MỚI CHẠY CÂU NÀY
USE master;
GO
ALTER DATABASE ScheduleExam
SET SINGLE_USER
WITH ROLLBACK IMMEDIATE;
GO
-- ----------------------------
DROP DATABASE ScheduleExam
GO

CREATE DATABASE [ScheduleExam]

USE [ScheduleExam]
GO

CREATE TABLE [Account](
Email NVARCHAR(256) PRIMARY KEY NOT NULL,
Account_ID NVARCHAR(256),
[Password] VARCHAR(256),
[Name] NVARCHAR(256),
Gender NVARCHAR(256),
[Address] NVARCHAR(256),
DOB DATE,
IMG VARBINARY(MAX),
RoleName NVARCHAR(256),
)

CREATE TABLE [Report](
Report_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
[Type] NVARCHAR(256),
Details VARCHAR(256),
is_resolved NVARCHAR(256),
)

CREATE TABLE [Staff_Report](
Report_ID NVARCHAR(256) FOREIGN KEY REFERENCES Report(Report_ID),
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
)

CREATE TABLE [Room](
Room_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
NumRoom INTEGER,
[Date] DATE,
Campus NVARCHAR(256),
)

CREATE TABLE [Student/Teacher_ExamRoom](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES Room(Room_ID),
)

CREATE TABLE [Semester](
SE_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
SE_Name NVARCHAR(256),
StartDate DATE,
EndDate DATE,
)

CREATE TABLE [Subject](
Subject_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
Subject_Name NVARCHAR(256),
Exam_Code NVARCHAR(256),
Form NVARCHAR(256),
)

CREATE TABLE [Subject_Semester](
SE_ID NVARCHAR(256) FOREIGN KEY REFERENCES Semester(SE_ID),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
)


CREATE TABLE [Slot](
Slot_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
Slot_Name NVARCHAR(256),
Start_Time TIME(7),
End_Time TIME(7),
)

CREATE TABLE [Student_Exam_Schedule](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
SE_ID NVARCHAR(256) FOREIGN KEY REFERENCES Semester(SE_ID),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES Room(Room_ID),
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
regulations NVARCHAR(256),
)

CREATE TABLE [Subject_SLot](
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
)

CREATE TABLE [Salary](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
Amount INTEGER,
Bonus INTEGER,
[Status] BIT,
)

CREATE TABLE [Teacher_Schedule](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
SE_ID NVARCHAR(256) FOREIGN KEY REFERENCES Semester(SE_ID),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES Room(Room_ID),
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
regulations NVARCHAR(256),
)

-- ADD DATA INTO TABLE Account
INSERT INTO [Account] (Email,Account_ID,[Password],[Name],Gender,[Address],DOB,IMG,RoleName) VALUES ('hieplxse160641@fpt.edu.vn','SE160641','1','LuuHiep','Male','186 le van viet','2002-09-16',null,'Student')
INSERT INTO [Account] (Email,Account_ID,[Password],[Name],Gender,[Address],DOB,IMG,RoleName) VALUES ('hoangnqse160625@fpt.edu.vn','SE160625','1','QuocHoang','Male','Do Xuan Hop','2002-10-02',null,'Teacher')

-- ADD DATA INTO TABLE Subject
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('PRF192','Programming Fundamentals','123456/789123','EOS,PEA')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('MAE101','Mathematics for Engineering','712342','EOS')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('CEA201','Computer Organization and Architecture','817234','EOS')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('PRO192','Object-Oriented Programming','812784/912834','EOS,PEA')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('PRN221','Advanced Cross-Platform Application Programming With .NET','178234/938454','EOS,PEA')

-- ADD DATA INTO TABLE Room
INSERT INTO [Room](Room_ID,NumRoom,[Date],Campus) VALUES ('1','101','2023-11-12','HCM')
INSERT INTO [Room] (Room_ID,NumRoom,[Date],Campus) VALUES ('2','102','2023-02-09','HCM')
INSERT INTO [Room] (Room_ID,NumRoom,[Date],Campus) VALUES ('3','103','2023-10-02','HCM')
INSERT INTO [Room] (Room_ID,NumRoom,[Date],Campus) VALUES ('4','104','2023-05-23','HCM')
INSERT INTO [Room] (Room_ID,NumRoom,[Date],Campus) VALUES ('5','105','2023-06-28','HCM')

-- ADD DATA INTO TABLE Semester
INSERT INTO [Semester](SE_ID,SE_Name,StartDate,EndDate) VALUES ('1','Spring22','2022-01-01','2022-05-01')
INSERT INTO [Semester](SE_ID,SE_Name,StartDate,EndDate) VALUES ('2','Summer22','2022-05-01','2022-09-01')
INSERT INTO [Semester](SE_ID,SE_Name,StartDate,EndDate) VALUES ('3','Fall22','2022-09-01','2022-12-31')

-- ADD DATA INTO TABLE Slot
INSERT INTO [Slot](Slot_ID,Slot_Name,Start_Time,End_Time) VALUES ('1','Slot_1','07:00:00','09:15:00')
INSERT INTO [Slot](Slot_ID,Slot_Name,Start_Time,End_Time) VALUES ('2','Slot_2','09:30:00','11:45:00')
INSERT INTO [Slot](Slot_ID,Slot_Name,Start_Time,End_Time) VALUES ('3','Slot_3','12:30:00','14:45:00')
INSERT INTO [Slot](Slot_ID,Slot_Name,Start_Time,End_Time) VALUES ('4','Slot_4','15:00:00','17:15:00')

-- ADD DATA INTO TABLE Student_Exam_Schedule
INSERT INTO [Student_Exam_Schedule](Email,SE_ID,Subject_ID,Room_ID,Slot_ID,regulations) VALUES ('hieplxse160641@fpt.edu.vn','2','CEA201','1','3','do not use GG')
INSERT INTO [Student_Exam_Schedule](Email,SE_ID,Subject_ID,Room_ID,Slot_ID,regulations) VALUES ('hoangnqse160625@fpt.edu.vn','2','PRO192','2','1','do not use GG')

