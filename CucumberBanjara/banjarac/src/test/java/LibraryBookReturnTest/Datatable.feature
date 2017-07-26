
Feature: Book Return Test Feature File
         Verifying the Successful return of book to library by a student.
@selenium
Scenario: Return the book back which is issued to student and check whether that book quantity is added in Available Books Page.

 Given Librarian logs in using Username as "1" and password as "22" and then navigate to Book Return Page

When Librarian checks and enter details of a Book and student to return the book

| Fields                 | Values                     |
| BookId             |  1 |
| StudentId              |            11                |
| Submit Date   |  20-July-2017      |
| Fine Amount  |  20  |

Then Librarian navigates to Available Books page to check whether the book Quantity is increased by 1 

| Fields                 | Values                     |
| BookId             |  1 |
| Books Quantity          | 25  | 

Then Librarian navigates to non Available Books page to check whether the returned book is removed  

| Fields                 | Values                     |
| BookId             |  1     |
| StudentId              |            11                |
