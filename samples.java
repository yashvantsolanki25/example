class samples
{
    public static void main(String args[])
    {
        record player(String last, String first, int level) {}
        var jane = new player("Doe" , "Jane" , 1);
        System.out.println(jane);
        }
    }