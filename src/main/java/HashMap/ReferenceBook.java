package HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ReferenceBook<K, V> {

    private Node<K,V> [] hashTable;
    private int size = 0;
    private float threshold;   // degree of load / степень нагрузки

    public ReferenceBook() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
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
