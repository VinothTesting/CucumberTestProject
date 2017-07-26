@smokeTest
Feature: Add Result Test Feature File
        Verifying the Successful entry of Student Result.
@selenium
Scenario: Add Result test by entering student Result and view the same to verify it.

 Given Teacher logs in using Username as "12" and password as "12" and then navigate to Add Result page

 When Teacher enters marks to all students for an exam in Add Result page

| Fields                 | Values                     |
| Standard             |  10th |
| Section              |            A                |
| Subject   |  PHYSICS     |
| Exam   | FINAL  |
| Student Id           | 12  | 18  | 20  |
| Marks | 60 | 70 | 80 | 

 Then Result must be successfully updated in View Result page

| Fields               |      Values                     |
| Standard             |  10th        |
| Section              |            A               |
| Subject   |   PHYSICS     |
| Exam   | FINAL |
| Student Id           | 12   | 18  | 20  |
| Marks |  60  |  70   |  80  | 