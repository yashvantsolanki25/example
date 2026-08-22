class samples
{
    public static void main(String args[])
    {
       /* record player(String last, String first, int level) {}
        var jane = new player("Doe" , "Jane" , 1);
        System.out.println(jane);
        } */
       // Composing
       /*
record Population(int population) {}
record City(String name, Population population) {
    // static methods are allowed in records
    public static City of(String name, int p) {
        var population = new Population(p);
        return new City(name, population);
    }
}

var paris = City.of("Paris", 2_161);
System.out.println(paris); */
// method overriding
record City(String name) {

    public boolean equals(Object other) {
        return other instanceof City(String name) &&
                this.name.equalsIgnoreCase(name);
    }

    public int hashCode() {
        return name != null ? name.toUpperCase().hashCode() : 0;
    }
}

var paris1 = new City("Paris");
var paris2 = new City("paris");
var paris3 = new City("PARIS");
System.out.println("1 == 2 ? " + paris1.equals(paris2));
System.out.println("2 == 3 ? " + paris2.equals(paris3));
System.out.println("1 == 3 ? " + paris1.equals(paris3));


    }
}
