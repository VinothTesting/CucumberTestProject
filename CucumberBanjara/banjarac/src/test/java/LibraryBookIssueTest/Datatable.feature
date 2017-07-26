@smokeTest
Feature: Book Issue Test Feature File
         Verifying the Successful issue of book to a student.
@selenium
Scenario: Issue a book to student and check whether the book count is updated in Available Books Page.

 Given Librarian logs in using Username as "1" and password as "22" and then navigate to Book Issue Page

When Librarian checks and enter details of a Book and student to issue the book

| Fields                 | Values                     |
| BookId             |  1 |
| StudentId              |            11                |
| Return Date   |  20-July-2017     |

Then Librarian navigates to Available Books page to check whether the book Quantity is reduced by 1 

| Fields                 | Values                     |
| BookId             |  1 |
| Books Quantity          | 26  | 

Then Librarian navigates to non Available Books page to check whether the issued book is added  
| Fields                 |      Values                     |
| BookId                 |         1                       |
| StudentId              |        11                       |

