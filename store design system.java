Import java.util.ArrayList;
Import java.util.InputMismatchException;
Import java.util.Iterator;
Import java.util.Scanner;

Class Product {
    Private int id;
    Private String name;
    Private double price;

    Product(int id, String name, double price) {
        This.id = id;
        This.name = name;
        This.price = price;
    }

    Public int getId() {
        Return id;
    }

    Public String getName() {
        Return name;
    }

    Public double getPrice() {
        Return price;
    }

    @Override
    Public String toString() {
        Return id + “. “ + name + “ - $” + price;
    }
}

Class Store {
    Private ArrayList<Product> products = new ArrayList<>();

    Public void addProduct(Product product) {
        Products.add(product);
    }

    Public void displayProducts() {
        If (products.isEmpty()) {
            System.out.println(“No products available.”);
        } else {
            For (Product product : products) {
                System.out.println(product);
            }
        }
    }

    Public Product getProductById(int id) {
        For (Product product : products) {
            If (product.getId() == id) {
                Return product;
            }
        }
        Return null;
    }

    Public boolean removeProductById(int id) {
        Iterator<Product> iterator = products.iterator();
        While (iterator.hasNext()) {
            If (iterator.next().getId() == id) {
                Iterator.remove();
                Return true;
            }
        }
        Return false;
    }
}

Public class Main {
    Public static void main(String[] args) {
        Store store = new Store();
        Store.addProduct(new Product(1, “Laptop”, 800.0));
        Store.addProduct(new Product(2, “Smartphone”, 500.0));
        Store.addProduct(new Product(3, “Headphones”, 50.0));

        Scanner scanner = new Scanner(System.in);

        While (true) {
            System.out.println(“\nOnline Store Management System”);
            System.out.println(“1. View Products”);
            System.out.println(“2. Buy Product”);
            System.out.println(“3. Exit”);
            System.out.print(“Enter choice: “);

            Try {
                Int choice = scanner.nextInt();

                Switch (choice) {
                    Case 1:
                        Store.displayProducts();
                        Break;
                    Case 2:
                        System.out.print(“Enter product ID to buy: “);
                        Int id = scanner.nextInt();
                        Product product = store.getProductById(id);
                        If (product != null) {
                            System.out.println(“You bought: “ + product.getName() + “ for $” + product.getPrice());
                            Store.removeProductById(id);
                        } else {
                            System.out.println(“Product not found!”);
                        }
                        Break;
                    Case 3:
                        System.out.println(“Exiting…”);
                        Scanner.close();
                        Return;
                    Default:
                        System.out.println(“Invalid choice. Try again.”);
                }
            } catch (InputMismatchException e) {
                System.out.println(“Invalid input. Please enter a number.”);
                Scanner.next(); // Consume invalid input to prevent an infinite loop
            }
        }
    }
}

