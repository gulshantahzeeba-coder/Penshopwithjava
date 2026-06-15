package Menus;

import java.util.Scanner;
import Interfaces.IPen;
import Models.Pen;

public class PenMenu {
    private final IPen _iPenService;
    private final Scanner scanner;

    public PenMenu(IPen iPenService) {
        this._iPenService = iPenService;
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n    ---Pen Management System---    ");
            System.out.println(" 1. Add Pen ");
            System.out.println(" 2. List All Pens  ");
            // show search and delete option only if there are pens in the list;
            if (!_iPenService.getAllPens().isEmpty()) {
                System.out.println(" 3. Search Pens by ID ");
                System.out.println(" 4. Update Pens by ID ");
                System.out.println(" 5. Delete Pens by ID ");
            }
            System.out.println(" 0. Exit ");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume new line.
            switch (choice) {
                case 1 -> addPens();
                case 2 -> listPens();
                case 3 -> {
                    if (!_iPenService.getAllPens().isEmpty())
                        searchPen();
                    else
                        System.out.println("There is no Pen to Search ");

                }
                case 4 -> {
                    if (!_iPenService.getAllPens().isEmpty())
                        updatePen();
                    else
                        System.out.println("There is no Pen to update!");
                }
                case 5 -> {
                    if (!_iPenService.getAllPens().isEmpty())
                        deletePen();
                    else
                        System.out.println("There is no Pen to Delete!");
                }
                case 0 -> {
                    exit = true;
                    System.out.println("Exciting the Program. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again!");
            }
        }
    }

    private void addPens() {
        boolean adding = true;

        while (adding) {
            System.out.println("\n Enter Pen Id");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the Pen Title");
            String penTitle = scanner.nextLine();

            System.out.println("Enter the Pen Company");
            String penCompany = scanner.nextLine();

            System.out.println("Enter the Pen Color");
            String penColor = scanner.nextLine();

            _iPenService.addPen(new Pen(id, penTitle, penCompany, penColor));
            System.out.print("Pen added successfully!");

            System.out.print(" would you like to run an other Pen?");
            String choice = scanner.nextLine();
            adding = choice.equalsIgnoreCase("Y");
        }
        System.out.println("\n Pen Added:");
        listPens();
    }

    private void listPens() {
        System.out.println("\n  ---List of pens---  ");
        if (_iPenService.getAllPens().isEmpty()) {
            System.out.println("There is no Pen in Library.");
        } else {
            for (Pen pen : _iPenService.getAllPens()) {
                System.out.println(pen);
            }
        }
    }

    private void searchPen() {
        System.out.println("Enter Pen ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume new Line.

        Pen pen = _iPenService.getPenById(id);
        if (pen != null) {
            System.out.println("Pen found: " + pen);
        } else {
            System.out.println("Pen not found with Id.");
        }
    }

    private void updatePen() {
        System.out.println("Enter the Pen Id to update: ");
        int penId = scanner.nextInt();
        scanner.nextLine(); // consume line.

        Pen existingPen = _iPenService.getPenById(penId);
        if (existingPen != null) {
            System.out.println("Existing pen title: " + existingPen.getPenTitle() +
                    "\n" + "Now enter the new Title: ");
            String title = scanner.nextLine();
            if (title != "" && title != null)
                existingPen.setPenTitle((title));
            else
                System.out.println("You didn't enter any title now old title will be consider!");

            System.out.println("Enter the new Company");
            String penCompany = scanner.nextLine();
            if (penCompany != "" && penCompany != null)
                existingPen.setPenCompany(penCompany);
            else
                System.out.println("You didn't enter any pen company now old pen company will be consider!");

            System.out.println("Enter the new Pen Color: ");
            String penColor = scanner.nextLine();
            if (penColor != "" && penColor != null)
                existingPen.setPencolor(penColor);
            else
                System.out.println("You didn't enter any pen color now old pen color will be consider!");

            _iPenService.updatePen(penId, existingPen);
            System.out.println("Pen updated successfully!");

        } else {
            System.out.println("Pen not found with ID " + penId);
        }
    }

    private void deletePen() {

        System.out.println("Enter the Pen ID to Delete");
        int penId = scanner.nextInt();

        Pen pen = _iPenService.getPenById(penId);
        if (pen != null) {
            _iPenService.deletePen(penId);
            System.out.println("Pen Deleted Successfully");
        } else {
            System.out.println("Pen not found with ID." + penId);
        }
    }

    public void seedPens() {
        _iPenService.addPen(new Pen(1, "SleekWriter", "Bic", "Blue"));
        _iPenService.addPen(new Pen(2, "InkMaster", "Pilot", "Black"));
        _iPenService.addPen(new Pen(3, "PrecisionPoint", "Uni-ball", "Red"));
        _iPenService.addPen(new Pen(4, "SmoothFlow", "Parker", "Green"));
        _iPenService.addPen(new Pen(5, "ClassicQuill", "Cross", "Purple"));
        _iPenService.addPen(new Pen(6, "EcoPen", "Staedtler", "Orange"));
        _iPenService.addPen(new Pen(7, "GelFlow", "Paper Mate", "Pink"));
        _iPenService.addPen(new Pen(8, "QuickDraw", "Sharpie", "Yellow"));
        _iPenService.addPen(new Pen(9, "FountainClassic", "Lamy", "Teal"));
        _iPenService.addPen(new Pen(10, "ArtisticBrush", "Copic", "Brown"));
        

        System.out.println("10 Pens have been seeded to the library.");

    }
}
