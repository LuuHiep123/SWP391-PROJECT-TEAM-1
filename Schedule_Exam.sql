USE [master]
GO

DROP DATABASE ScheduleExam
GO

CREATE DATABASE [ScheduleExam]

USE [ScheduleExam]
GO

CREATE TABLE [Account](
Email NVARCHAR(256) PRIMARY KEY NOT NULL,
Account_ID VARCHAR(256),
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

CREATE TABLE [ExamRoom](
Room_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
RoomName NVARCHAR(256),
Place bit,
)

CREATE TABLE [Student/Teacher_ExamRoom](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES ExamRoom(Room_ID),
)

CREATE TABLE [Semester](
SE_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
[Time] TIME(7),
[Day] DATE,
Slot bit,
Place bit,
)

CREATE TABLE [Subject](
Subject_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
Subject_Name NVARCHAR(256),
Grace NVARCHAR(256),
Decription NVARCHAR(256),
Form NVARCHAR(256),
)

CREATE TABLE [Subject_Semester](
SE_ID NVARCHAR(256) FOREIGN KEY REFERENCES Semester(SE_ID),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
)

CREATE TABLE [ExamSchedule](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES ExamRoom(Room_ID),
SE_ID NVARCHAR(256) FOREIGN KEY REFERENCES Semester(SE_ID),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
)

CREATE TABLE [Slot](
Slot_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
Slot_Name NVARCHAR(256),
From_Date DATE,
To_Date DATE,
[Time] TIME(7),
)

CREATE TABLE [Subject_SLot](
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
)

CREATE TABLE [Teacher_Slot](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
Amount INTEGER,
Bonus INTEGER,
[Status] BIT,
)

CREATE TABLE [ExamRoom_SLot](
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES ExamRoom(Room_ID),
)


SELECT * FROM [Account]
DECLARE @AccountID INT = 160000

WHILE @AccountID <= 179999
BEGIN
    DECLARE @Email NVARCHAR(255) = 'user' + CAST(@AccountID AS NVARCHAR(10)) + '@fpt.edu.vn'
    
    INSERT INTO [Account] (Email, Account_ID, [Name], Gender, [Address], DOB, IMG, RoleName)
    VALUES
    (@Email, @AccountID, 'User ' + CAST(@AccountID AS NVARCHAR(10)), 'Male', 'Q' + CAST(@AccountID AS NVARCHAR(10)), '2000-01-01', 0x0123456789ABCDEF, 'Student')
    
    SET @AccountID = @AccountID + 1
END
UPDATE [Account]
SET Email = REPLACE(Email, '@fpt.edu.vn', '@fe.edu.vn')
WHERE Email IN ('userxxxx1@fpt.edu.vn', 'userxxxx2@fpt.edu.vn', 'userxxxx3@fpt.edu.vn', 'userxxxx4@fpt.edu.vn', 'userxxxx5@fpt.edu.vn', 'userxxxx6@fpt.edu.vn', 'userxxxx7@fpt.edu.vn', 'userxxxx8@fpt.edu.vn', 'userxxxx9@fpt.edu.vn');