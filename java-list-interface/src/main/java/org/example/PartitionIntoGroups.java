package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class PartitionIntoGroups {

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 90).boxed().toList();

        int blockSize = 20;
        int blockNumber = (list.size() / blockSize) + 1;

        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < blockNumber; i++) {
            List<Integer> internalList = new ArrayList<>();

            for (int j = 0; j < blockSize; j++) {
                if (iterator.hasNext()) {
                    internalList.add(iterator.next());
                }
            }

            System.out.println(String.join(",", internalList.stream()
                    .map(v -> String.format("%02d", v))
                    .toList()
            ));
        }
    }
}
