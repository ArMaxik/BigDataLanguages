public class Shop {
    public class Department {
        public class Product {
            String name;
            int price;

            Product(String name, int price) {
                this.name = name;
                this.price = price;
            }
        }

        public class Service {
            String name;
            int price;

            Service(String name, int price) {
                this.name = name;
                this.price = price;
            }
        }

        String name;
        Product[] products;
        Service[] services;

        Department(String name, Product[] products, Service[] services) {
            this.name = name;
            this.products = products;
            this.services = services;
        }
    }

    String name;
    Department[] departments;

    Shop(String name, Department[] departments) {
        this.name = name;
        this.departments = departments;
    }
}
