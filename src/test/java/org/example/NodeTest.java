package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    private Tree tree;

    @BeforeEach
    public void setUp() {
        tree = new Tree();
    }

    @Test
    void createTree() {
        assertNotNull(tree);
        assertNull(tree.getRoot());
    }

    @Test
    void addNodeToTree() {
        Node node = new Node("node1");
        tree.setRoot(node);
        assertNotNull(tree.getRoot());
        assertEquals("node1", tree.getRoot().getName());
    }

    @Test
    void findChildNodeByName() {
        Node node = new Node("node1");
        tree.setRoot(node);
        Node childNode = new Node("child1");
        tree.getRoot().addChild(childNode);
        assertEquals(childNode, tree.getRoot().findChildByName("child1"));
    }

    @Test
    void removeChildNodeByNameOrId() {
        Node node = new Node("node1");
        tree.setRoot(node);
        Node childNode = new Node("child1");
        tree.getRoot().addChild(childNode);
        tree.getRoot().removeChildByName("child1");
        assertNull(tree.getRoot().findChildByName("child1"));
    }

    @Test
    void removeAllChildNodes() {
        Node node = new Node("node1");
        tree.setRoot(node);
        Node childNode1 = new Node("child1");
        Node childNode2 = new Node("child2");
        tree.getRoot().addChild(childNode1);
        tree.getRoot().addChild(childNode2);
        tree.getRoot().removeAllChildren();
        assertTrue(tree.getRoot().getChildren().isEmpty());
    }

    @Test
    void changeNodeValue() {
        Node node = new Node("node1");
        tree.setRoot(node);
        tree.getRoot().setName("newNode");
        assertEquals("newNode", tree.getRoot().getName());
    }
}
