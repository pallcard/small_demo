package cn.wishhust.design.mode.iterator;

public class ConcretrAggregate implements Aggregate {

    private Integer[] items;

    public ConcretrAggregate() {
        items = new Integer[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }
    }

    @Override
    public Iterator createIterator() {

        return new ConcreteIterator<Integer>(items);
    }
}
