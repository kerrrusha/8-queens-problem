package com.kerrrusha.chessboard.model;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.Test;

public class GraphStreamTest {

    @Test
    public void graphStreamIsWorkingTest() throws InterruptedException {
        Graph graph = new SingleGraph("Tutorial 1");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        graph.display();

        Thread.sleep(60000);
    }
}
