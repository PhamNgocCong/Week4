import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MediaItem {
    protected String id;
    protected String name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

class Book extends MediaItem {
    private String author;
    private int pages;

    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - " + author + " - " + pages);
    }
}

class DVD extends MediaItem {
    private String director;
    private int duration;

    public DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - " + director + " - " + duration);
    }
}

class LibrarySection<T extends MediaItem> {
    private List<T> items;

    public LibrarySection() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }
    public void removeItem(T item) {
        items.remove(item);
    }
public void displaySection(String sectionName) {
        System.out.println("Khu vực " + sectionName + ":");
        for (T item : items) {
            item.displayDetails();}
        System.out.println(); }
}

class LibraryManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            char type = parts[0].charAt(0);

            if (type == 'B') {
                String id = parts[1];
                String name = parts[2];
                String author = parts[3];
                int pages = Integer.parseInt(parts[4]);

                bookSection.addItem(new Book(id, name, author, pages));
            } else if (type == 'D') {
                String id = parts[1];
                String name = parts[2];
                String director = parts[3];
                int duration = Integer.parseInt(parts[4]);

                dvdSection.addItem(new DVD(id, name, director, duration));
            }
        }
        scanner.close();

        bookSection.displaySection("Sách");
        dvdSection.displaySection("DVD");
    }
}
