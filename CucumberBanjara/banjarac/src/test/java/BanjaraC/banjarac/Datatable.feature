@smokeTest
Feature: Add Attendance Test Feature File
        Verifying the Successful entry of Student Attendance.
@selenium
Scenario: Add Attendance test by entering student Attendance and view the same to verify it.

 Given Teacher logs in using Username as "12" and password as "12" and then navigate to Add Attendance page

 When Teacher enters all Valid inputs in Add Attendance page

| Fields               |         Values             |
| Standard             |           10th             |
| Section              |            A               |
| Date   | 11-July-2017  |
| Student Id           | 12  | 18  | 20  |
| Attendance Status | Absent | Present  | Present | 
 
 Then Attendance must be sucessfully updated in view Attendance page

| Fields                |         Values             |
| Standard              |          10th              |
| Section               |            A               |
| Date                  | 11-July-2017               |
| Student Id            | 12         | 18      | 20       |
| Attendance Status     |     Absent        |    Present      |     Present      | 