import java.util.Scanner;

class Book {
    String name;
    String author;
    int id;
    Book next;

    Book(String name, String author, int id) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.next = null;
    }
}

class Student {
    String name;
    String email;
    String book;
    String author;
    int id;
    Student next;

    Student(String name, String email, String book, String author, int id) {
        this.name = name;
        this.email = email;
        this.book = book;
        this.author = author;
        this.id = id;
        this.next = null;
    }
}

public class LibraryManagementSystem {
    private static Book startLib = null;
    private static Student start = null;

    public static void main(String[] args) {
        startLib = initializeLib(startLib);
        greetings();
        mainMenu();
    }

    private static void greetings() {
        System.out.println("\n\n");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t     *      WELCOME TO STUDENT LIBRARY      *");
        System.out.println("\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\n\n");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *       ------------------------       *");
        System.out.println("\t\t\t     *           STUDENT LIBRARY            *");
        System.out.println("\t\t\t     *       ------------------------       *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *      Haridwar,Uttarakhand,India      *");
        System.out.println("\t\t\t     *     Email: studentlib@gmail.com      *");
        System.out.println("\t\t\t     *     Contact:8889997770,9998887770    *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\n\n\t\t\t             Press Enter to continue: ");
        new Scanner(System.in).nextLine();
    }

    private static void mainMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n\n");
            System.out.println("\n\t\t\t*************************************************");
            System.out.println("\n\t\t\t\t      MAIN MENU: ");
            System.out.println("\n\t\t\t\t     1.ISSUE OF BOOKS ");
            System.out.println("\n\t\t\t\t     2.RETURN OF BOOKS ");
            System.out.println("\n\t\t\t\t     3.DISPLAY STUDENT DETAILS ");
            System.out.println("\n\t\t\t\t     4.EXIT\n ");
            System.out.println("\n\t\t\t*************************************************");
            System.out.print("\n\t\t\t\t      Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    start = bookIssue(start);
                    break;
                case 2:
                    start = bookReturn(start);
                    break;
                case 3:
                    display(start);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\t\t\t\t      ...Invalid Option!...");
                    System.out.print("\n\t\t\t\t      Press Enter to try again: ");
                    scanner.nextLine();
                    scanner.nextLine();
            }
        } while (choice != 4);
    }

    private static Book initializeLib(Book startLib) {
        Book ptr;
        Book newBook1;
        Book newBook2;
        Book newBook3;
        Book newBook4;
        Book newBook5;

        newBook1 = new Book("INTRODUCTION TO JAVA PROGRAMMING", "Y. DANIEL LIANG", 101);
        startLib = newBook1;
        ptr = newBook1;

        newBook2 = new Book("OPERATING SYSTEM CONCEPTS", "ABRAHAM SILBERSCHATZ", 102);
        ptr.next = newBook2;
        ptr = newBook2;

        newBook3 = new Book("HIGHER ENGINEERING MATHEMATICS", "B. V. RAMANA", 103);
        ptr.next = newBook3;
        ptr = newBook3;

        newBook4 = new Book("ARTIFICIAL INTELLIGENCE", "RICH, KNIGHT", 104);
        ptr.next = newBook4;
        ptr = newBook4;

        newBook5 = new Book("THE PROGRAMMING LANGUAGE OF ORACLE", "IVAN BYROSS", 105);
        ptr.next = newBook5;

        return startLib;
    }

    private static Student bookIssue(Student start) {
        Book ptr;
        Student ptr2;
        Student newStudent;
        int i = 1;
        int id;
        int flag = 0;
        if (startLib == null) {
            System.out.println("\n\t\t\t\t No books left in the library to issue!\n\t\t\t\t Sorry for the inconvenience!\n");
        } else {
            clearScreen();
            ptr = startLib;
            System.out.println("\n\t*************** Books Available: ****************\n");
            while (ptr != null) {
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\t Book " + i);
                System.out.println("\n\t Book Title: " + ptr.name);
                System.out.println("\n\t Name of Author: " + ptr.author);
                System.out.println("\n\t Book ID: " + ptr.id);
                System.out.println("\n\t_________________________________________________");
                ptr = ptr.next;
                i++;
            }
            System.out.print("\n\n\t Enter the Book ID: ");
            id = new Scanner(System.in).nextInt();
            ptr = startLib;
            while (ptr != null) {
                if (ptr.id == id) {
                    flag = 1;
                    break;
                }
                ptr = ptr.next;
            }
            if (flag == 1) {
                ptr = startLib;
                while (ptr.id != id) {
                    ptr = ptr.next;
                }
                newStudent = new Student("", "", "", "", 0); // Initialize with empty values
                System.out.println("\n\t Enter Student Details:\n ");
                Scanner scanner = new Scanner(System.in);
                System.out.print("\n\t Enter your Name: ");
                newStudent.name = scanner.nextLine();
                System.out.print("\n\t Enter your Email: ");
                newStudent.email = scanner.nextLine();
                newStudent.book = ptr.name;
                newStudent.author = ptr.author;
                newStudent.id = ptr.id;
                newStudent.next = null;
                System.out.println("\n\t Issue of Book ID " + newStudent.id + " done successfully!\n");
                System.out.println("\n\n\t*************************************************\n");
                if (start == null) {
                    start = newStudent;
                } else {
                    ptr2 = start;
                    while (ptr2.next != null) {
                        ptr2 = ptr2.next;
                    }
                    ptr2.next = newStudent;
                }
                startLib = deleteBook(newStudent.id);
                System.out.print("\n\n\t Press Enter to go to the main menu: ");
                new Scanner(System.in).nextLine();
                clearScreen();
            } else {
                System.out.println("\n\t\t      ...Invalid Option!...\n");
                System.out.print("\n\t\t      Press Enter to try again: ");
                new Scanner(System.in).nextLine();
                clearScreen();
            }
        }
        return start;
    }

    private static Student bookReturn(Student start) {
        Student ptr;
        Student prePtr;
        String bookName;
        String authorName;
        int flag = 0;
        int id;
        int identity;
        System.out.println("\n\n\t*************** Books Submission: ****************\n");
        System.out.print("\n\n\t Enter your Book ID: ");
        identity = new Scanner(System.in).nextInt();
        ptr = start;
        while (ptr != null) {
            if (ptr.id == identity) {
                flag = 1;
                break;
            }
            ptr = ptr.next;
        }
        if (flag == 1) {
            ptr = start;
            int c = 0;
            while (ptr != null) {
                c++;
                ptr = ptr.next;
            }
            ptr = start;
            int d = 1;
            while (ptr.id != identity) {
                d++;
                ptr = ptr.next;
            }
            ptr = start;
            if (d == 1) {
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\t Student Name: " + start.name);
                System.out.println("\n\t Student Email: " + start.email);
                System.out.println("\n\t Name of Book Issued: " + start.book);
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\n\t Return of Book ID " + identity + " done successfully!\n");
                System.out.println("\n\n\t*************************************************\n");
                bookName = start.book;
                authorName = start.author;
                id = start.id;
                start = start.next;
                startLib = addBook(bookName, authorName, id);
            } else {
                ptr = start;
                while (ptr.id != identity) {
                    prePtr = ptr;
                    ptr = ptr.next;
                }
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\t Student Name: " + ptr.name);
                System.out.println("\n\t Student Email: " + ptr.email);
                System.out.println("\n\t Name of Book Issued: " + ptr.book);
                System.out.println("\n\t Book ID: " + ptr.id);
                System.out.println("\n\t_________________________________________________");
                bookName = ptr.book;
                authorName = ptr.author;
                id = ptr.id;
                prePtr.next = ptr.next;
                startLib = addBook(bookName, authorName, id);
            }
            System.out.println("\n\t Thank you! \n\t Do visit again! ");
            System.out.print("\n\n\t Press Enter to go to the main menu: ");
            new Scanner(System.in).nextLine();
            clearScreen();
        } else {
            System.out.println("\n\tSorry the book doesn't exist! Please recheck the entered ID");
            System.out.print("\n\t\t\t\t      Press Enter to try again: ");
            new Scanner(System.in).nextLine();
            clearScreen();
        }
        return start;
    }

    private static void display(Student start) {
        Student ptr = start;
        while (ptr != null) {
            System.out.println("\n\t************* Details of Students: **************\n");
            System.out.println("\n\t_________________________________________________");
            System.out.println("\n\t\t Student Name: " + ptr.name);
            System.out.println("\n\t\t Student Email: " + ptr.email);
            System.out.println("\n\t\t Name of Book Issued: " + ptr.book);
            System.out.println("\n\t\t Book ID: " + ptr.id);
            System.out.println("\n\t_________________________________________________");
            System.out.println("\n\n\t*************************************************\n");
            ptr = ptr.next;
        }
        System.out.print("\n\n\t Press Enter to go to the main menu: ");
        new Scanner(System.in).nextLine();
        clearScreen();
    }

    private static Book deleteBook(int id) {
        Book ptr;
        Book prePtr;
        int c = 0;
        ptr = startLib;
        while (ptr != null) {
            c++;
            ptr = ptr.next;
        }
        if (c == 1) {
            ptr = startLib;
            startLib = null;
        } else if (startLib.id == id) {
            ptr = startLib;
            startLib = startLib.next;
        } else {
            ptr = startLib;
            while (ptr.id != id) {
                prePtr = ptr;
                ptr = ptr.next;
            }
            prePtr.next = ptr.next;
        }
        return startLib;
    }

    private static Book addBook(String bookName, String authorName, int id) {
        Book ptr;
        Book newBook = new Book(bookName, authorName, id);
        newBook.next = null;
        if (startLib == null) {
            startLib = newBook;
        } else {
            ptr = startLib;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newBook;
        }
        return startLib;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
