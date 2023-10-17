USE [master]
GO
hihi
    doots
	oke man
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

CREATE TABLE [Room](
Room_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
NumRoom INTEGER,
Campus NVARCHAR(256),
)

CREATE TABLE [Student/Teacher_ExamRoom](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES Room(Room_ID),
)

CREATE TABLE [Semester](
SE_ID NVARCHAR(256) PRIMARY KEY NOT NULL,
StartDate DATE,
EndDate DATE,
NumDay INTEGER,
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
[Time] TIME(7),
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

CREATE TABLE [Teacher_ExamRoom_SLot](
Email NVARCHAR(256) FOREIGN KEY REFERENCES Account(Email),
SE_ID NVARCHAR(256) FOREIGN KEY REFERENCES Semester(SE_ID),
Subject_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Subject](Subject_ID),
Room_ID NVARCHAR(256) FOREIGN KEY REFERENCES Room(Room_ID),
Slot_ID NVARCHAR(256) FOREIGN KEY REFERENCES [Slot](Slot_ID),
regulations NVARCHAR(256),
)

-- ADD DATA INTO TABLE SUBJECT
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('PRF192','Programming Fundamentals','123456/789123','EOS,PEA')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('MAE101','Mathematics for Engineering','712342','EOS')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('CEA201','Computer Organization and Architecture','817234','EOS')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('PRO192','Object-Oriented Programming','812784/912834','EOS,PEA')
INSERT INTO [Subject] (Subject_ID,Subject_Name,Exam_Code,Form) VALUES ('PRN221','Advanced Cross-Platform Application Programming With .NET','178234/938454','EOS,PEA')


SELECT * FROM [Account]
SELECT * FROM [Subject]
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
