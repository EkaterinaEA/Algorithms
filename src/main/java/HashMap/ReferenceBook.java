package HashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ReferenceBook<K, V> implements Book<K,V> {

    public static void main(String[] args) {
        ReferenceBook<String, String> strings = new ReferenceBook<>();

        strings.insert("1", "2");
        System.out.println(strings.get("1"));

        strings.insert("1", "3");
        System.out.println(strings.get("1"));

        strings.insert("2", "3");
        System.out.println(strings.size());

        strings.delete("1");
        System.out.println(strings.get("1"));


        // test for the arrayDoubling():
        strings.insert("3", "3");
        strings.insert("4", "4");
        strings.insert("5", "5");
        strings.insert("6", "6");
        strings.insert("7", "7");
        strings.insert("8", "8");
        strings.insert("9", "9");
        strings.insert("10", "10");
        strings.insert("11", "11");
        strings.insert("12", "12");
        strings.insert("13", "13");
        strings.insert("14", "14");
        strings.insert("15", "hello!");
        strings.insert("16", "16");
        strings.insert("17", "17");
        strings.insert("18", "18");

        System.out.println(strings.size());
        System.out.println(strings.get("15"));
        System.out.println(strings.hashTable.length);

    }

    private Node<K,V> [] hashTable;
    private int size = 0;
    private float threshold;   // degree of load / степень нагрузки

    public ReferenceBook() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
    }

    @Override
    public boolean insert(final K key, final V value){
        if (size+1 >= threshold){                            // if the table is overloaded
            threshold*=2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);

        if (hashTable[index] == null){
            return simpleAdd(index, newNode);
        }

        List <Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList){
            if (keyExistButValueNew(node, newNode, value) ||
            collisionProcessing(node, newNode, nodeList)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(final K key) {
        int index = hash(key);

        if (hashTable[index] == null){
            return false;
        }

        if (hashTable[index].getNodes().size() == 1){
            hashTable[index] = null;
            return true;
        }

        List <Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList){
            if (key.equals(node.getKey())){
                nodeList.remove(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(final K key) {
        int index = hash(key);
        if (index < hashTable.length &&
        hashTable[index] != null){

            if (hashTable[index].getNodes().size() == 1){
                return hashTable[index].getNodes().get(0).getValue();
            }

            List <Node<K, V>> nodeList = hashTable[index].getNodes();
            for (Node<K, V> node : nodeList){
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean simpleAdd(int index, Node<K, V> newNode){
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private boolean keyExistButValueNew(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final V value) {
        if (newNode.getKey().equals(nodeFromList.getKey()) &&
        !newNode.getValue().equals(nodeFromList.getValue())){
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    private boolean collisionProcessing(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final List<Node<K, V>> nodes) {

        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)
        ) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    private void arrayDoubling(){          // cell redistribution / перераспределение элементов в ячейки
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable){
            if (node != null){
                for (Node<K, V> n : node.getNodes()){
                    insert(n.key, n.value);
                }
            }
        }
    }

    public void add(K key, V value){
        Node<K, V> newNode = new Node(key, value);
    }

    private int hash(Node<K, V> node){
        return node.hashCode() % hashTable.length;
    }

    private int hash(final K key){
        int hash = 17;
        hash = hash*31 + key.hashCode();
        return hash % hashTable.length;
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }

    private class Node<K, V> {
        private List<Node<K,V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K,V>>();
        }

        private int hash(){
            return hashCode() % hashTable.length;
        }

        public List<Node<K, V>> getNodes() {
            return nodes;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int hashCode(){
            hash = 31;
            hash = hash*17 + key.hashCode();
            hash = hash*17 + value.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj){
                return true;
            }

            if (obj instanceof Node){
                Node<K,V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }
    }
}
