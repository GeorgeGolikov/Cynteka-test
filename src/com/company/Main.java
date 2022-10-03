package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:", "Cynteka-test","resources", "input4.txt");
            Reader reader = new Reader(path);
            List<String> inputList = reader.readToList();

            Decoupler decoupler = new Decoupler(inputList);
            PairsCreator pairsCreator = decoupler.decoupleInputList();
            List<String> pairsList = pairsCreator.createSimilarPairs();

            path = Paths.get("D:", "Cynteka-test","resources", "output.txt");
            Writer writer = new Writer(path);
            writer.writeListToFile(pairsList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Throwable cause = e.getCause();
            Objects.requireNonNullElse(cause, e).printStackTrace();
        }
    }
}
