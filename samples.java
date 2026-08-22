class samples
{
    public static void main(String args[])
    {
       /* record player(String last, String first, int level) {}
        var jane = new player("Doe" , "Jane" , 1);
        System.out.println(jane);
        } */
       // Composing
record Population(int population) {}
record City(String name, Population population) {
    // static methods are allowed in records
    public static City of(String name, int p) {
        var population = new Population(p);
        return new City(name, population);
    }
}

var paris = City.of("Paris", 2_161);
System.out.println(paris);
    }
}