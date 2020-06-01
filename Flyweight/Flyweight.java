import java.util.ArrayList;

/**
 * 以图书馆借书为例，同学A去图书馆借阅一本高数，一周后还书；同学B去借阅，借阅的是同一本书
 * 书被借阅完时，没有同学还书时，无法借阅书
 */
public class Flyweight {

    /**
     * 抽象享元角色
     */
    public interface IBook {
        void borrow();
    }

    /**
     * 具体享元
     */
    public static class Book implements IBook {

        private String name;
        public Book(String name) {
            this.name = name;
        }
        

        @Override
        public void borrow() {
            System.out.println(name + " 被借阅...");
        }
    }

    public static class BookCount {
        private Book book;
        private int count;
        public BookCount(Book book, int count) {
            this.book = book;
            this.count = count;
        }

        public void borrow() {
            book.borrow();
            this.count --;
        }
    }

    public static class Student {
        public String name;
        public Student(String name) {
            this.name = name;
        }
    }

    /**
     * 享元工厂
     * 图书馆, 简单举例
     */
    public static class Library {
        private ArrayList<BookCount>  books = new ArrayList<BookCount>();
        public Library() {
            books.add(new BookCount(new Book("高等数学"), 3));
            books.add(new BookCount(new Book("Java编程"), 5));
            books.add(new BookCount(new Book("C语言艺术"), 2));
        }

        public void borrow(Student student, String bookName) {
            int size = books.size();
            for (int i = 0; i < size; i++) {
                BookCount count = books.get(i);
                if (count.book.name.equals(bookName)) {
                    if (count.count == 0) {
                        System.out.println("Sorry, " + student.name + ", 没有" + bookName);
                    } else {
                        System.out.println("欢迎 " + student.name);
                        count.borrow();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Student student1 = new Student("slack");
        library.borrow(student1, "C语言艺术");
        Student student2 = new Student("slack2");
        library.borrow(student2, "C语言艺术");
        Student student3 = new Student("slack3");
        library.borrow(student3, "C语言艺术");

    }
}