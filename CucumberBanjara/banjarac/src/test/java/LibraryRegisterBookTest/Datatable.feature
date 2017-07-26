@smokeTest
Feature: Register Book Test Feature File
        Verifying the Successful registration of a New Book in Library.
@selenium
Scenario: Registering new book and check whether the book is updated in Total Books page and Available Books Page.

 Given Librarian logs in using Username as "1" and password as "22" and then navigate to New Book Registration page

When Librarian enters all details of a New Book in New Book Registration page to register it

| Fields                 | Values                     |
| BookId             |  444 |
| Book Name              |            SeleniumVinoth                |
| Author Name   |  Vinoth     |
| Publisher Name   | VinothTest  |
| Books Quantity          | 20  | 


Then Librarian navigates to Total Books Page as well as Available Books page and checking whether book details is Updated 


| Fields                 | Values                     |
| BookId             |  444 |
| Book Name              |            SeleniumVinoth                |
| Author Name   |  Vinoth     |
| Publisher Name   | VinothTest  |
| Books Quantity          | 20  | 