package composite;

public class Main {

    public static void main(String[] args) {
        Composite topLevel =  new Composite(0);

        Composite secondLevel1 =  new Composite(0);
        Composite secondLevel2 =  new Composite(0);
        Leaf leaf1 = new Leaf(0);

        topLevel.add(secondLevel1);
        topLevel.add(secondLevel2);
        topLevel.add(leaf1);

        Composite thirdLevel1 = new Composite(0);
        Leaf leaf2 = new Leaf(0);

        secondLevel2.add(thirdLevel1);
        secondLevel2.add(leaf2);

        topLevel.increment();
        secondLevel2.increment();
        leaf2.increment();

        System.out.println("topLevel " + topLevel.getValue());

        System.out.println("secondLevel1 " + secondLevel1.getValue());
        System.out.println("secondLevel2 " + secondLevel2.getValue());
        System.out.println("leaf1 " + leaf1.getValue());

        System.out.println("thirdLevel1 " + thirdLevel1.getValue());
        System.out.println("leaf2 " + leaf2.getValue());
    }
}
