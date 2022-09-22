Kata LibCB
=============

This Kata will help you to discover the main Spring features :
- Spring Boot
- Spring JPA (_using H2 DB_)
- Spring Boot tests

# Business context

We will create a library manager to handle electronic books borrowing. 
The library gives exclusive access to numeric books.

## Book

The library contains books. Each book has many properties :
- Name
- Author
- Category
  - `KIDS`
  - `NOVEL`
  - `SCIENTIFIC`

## Users

A user should be registered in the subscriber list to be able to borrow a book.

A subscriber has the following properties
- Name
- Age
- Email

## Subscriptions

The library offers 3 types of **yearly** subscriptions :

- `JUNIOR` 
  - Only for subscribers having less than 12 years old
  - The subscriber can borrow only book of category `KIDS`
  - The subscriber can borrow at most 10 books
- `SILVER`
  - Only for subscribers having more than 12 years old
  - The subscriber can borrow any category
  - The subscriber can borrow at most 3 books
- `GOLD`
  - Only for subscribers having more than 12 years old
  - The subscriber can borrow any category
  - The subscriber can borrow at most 10 books

Every subscriber has a `subscriptionId`.

## Borrowing

A subscriber can borrow books from library for **3 weeks** at most.

To borrow a book, a subscriber can ask for a book with his `name` and `author`.
If the book is available, then the subscriber can borrow it. 
Else, the library will give him the availability date.

The subscriber can check his borrowed books, and the deadline to return them.

The subscriber can return the book at any time before the return deadline.

Once we reach the deadline of borrowed book, the book is automatically back to the library
and the subscriber will no more have access.

## Search of book

The subscriber can search books by category or author or name.
The library gives books with availability status.

## Adding books

`Admin` can add new book to the library. 

# Implementation

All the process are handled via HTTP REST requests.

## Subscriptions API

| EndPoint                           | Type  | Description                      |
|:-----------------------------------|:------|:---------------------------------|
| `v1/subscriptions/subscribe`       | POST  | Subscribe to the library         |
| `v1/subscriptions/{subscriptionId}`| GET   | Get the subscription information |

## Books API

| EndPoint               | Type         | Description               |
|:-----------------------|:-------------|:--------------------------|
| `v1/books/{category}`  | GET          | Find books by category    |
| `v1/books/{author}`    | GET          | Get book by author        |
| `v1/books/{name}`      | GET          | Get book by name          |
| `v1/books/add`         | POST         | Add a book to the library |

## Borrowings API

| EndPoint                         | Type    | Description             |
|:---------------------------------|:--------|:------------------------|
|`v1/borrowings/{subscriptionId}`  | GET     | Find borrowing history  |
|`v1/borrowings/borrow`            | POST    | Borrow a book           |
|`v1/borrowings/return`            | POST    | Return a book           |

## Authentication & roles

This feature is optional.