package main.java.com.cgvsu;

import main.java.com.cgvsu.math.Vector2f;
import main.java.com.cgvsu.math.Vector3f;
import main.java.com.cgvsu.model.Model;
import main.java.com.cgvsu.model.Polygon;
import main.java.com.cgvsu.objWriter.ObjWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== OBJ Writer Demo ===");
        Model model = new Model();
        model.getVertices().addAll(List.of(
                new Vector3f(0, 0, 0),
                new Vector3f(1, 0, 0),
                new Vector3f(0, 1, 0)
        ));
        model.getTextureVertices().addAll(List.of(
                new Vector2f(0, 0),
                new Vector2f(1, 0),
                new Vector2f(0, 1)
        ));
        model.getNormals().addAll(List.of(
                new Vector3f(0, 0, 1)
        ));

        Polygon polygon = new Polygon();
        polygon.getVertexIndices().addAll(List.of(0, 1, 2));
        polygon.getTextureVertexIndices().addAll(List.of(0, 1, 2));
        polygon.getNormalIndices().addAll(List.of(0, 0, 0));
        model.getPolygons().add(polygon);

        Path outputDir = Path.of("data").toAbsolutePath();
        try {
            if (!outputDir.toFile().exists()) {
                outputDir.toFile().mkdirs();
            }

            Path outputFile = outputDir.resolve("demo_output.obj");
            ObjWriter.writeObjToFile(model, outputFile.toString());

            System.out.println("Model successfully saved to:");
            System.out.println(outputFile.toAbsolutePath());
        }
        catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }

        System.out.println("=== Done ===");
    }
}