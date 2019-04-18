package HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RedefinitionEqualsAndHashCode<K, V> {

    private Node<K,V> [] hashTable;
    private int size = 0;
    private float threshold;   // предел

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
