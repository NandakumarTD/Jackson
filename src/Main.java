import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator jsonGenerator = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("truncated_output.json");
            jsonGenerator = jsonFactory.createGenerator(fileWriter);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("superheroes");
            jsonGenerator.writeStartArray();

            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "Superman");
            jsonGenerator.writeStringField("alias", "Clark Kent");
            jsonGenerator.writeFieldName("powers");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeString("Superhuman strength");
            jsonGenerator.writeString("Flight");
            jsonGenerator.writeString("Invulnerability");
            jsonGenerator.writeString("Heat vision");
            jsonGenerator.writeString("X-ray vision");
            jsonGenerator.writeEndArray();
            jsonGenerator.writeFieldName("affiliations");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeString("Justice League");
            jsonGenerator.writeString("Superman Family");
            jsonGenerator.writeEndArray();
            jsonGenerator.writeFieldName("appearance");
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("gender", "Male");
            jsonGenerator.writeStringField("race", "Kryptonian");
            jsonGenerator.writeStringField("height", "63");
            jsonGenerator.writeStringField("weight", "225 lbs");
            jsonGenerator.writeStringField("eyeColor", "Blue");
            jsonGenerator.writeStringField("hairColor", "Black");
            jsonGenerator.writeEndObject();

            jsonGenerator.writeStringField("universe", "DC");

            jsonGenerator.writeFieldName("movies");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("title", "Man of Steel");
            jsonGenerator.writeNumberField("year", 2013);
            jsonGenerator.writeEndObject();

            // Intentional exception
            if(true) {
                throw new RuntimeException("Intentional exception after first movie entry");
            }

            // The below code will not be executed as we throwed an intentional error
//             jsonGenerator.writeEndObject();
//             jsonGenerator.writeStartObject();
//             jsonGenerator.writeStringField("title", "Batman v Superman: Dawn of Justice");
//             jsonGenerator.writeNumberField("year", 2016);
//             jsonGenerator.writeEndObject();
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("title", "Justice League");
//            jsonGenerator.writeNumberField("year", 2017);
//            jsonGenerator.writeEndObject();
//             jsonGenerator.writeEndObject();
//             jsonGenerator.writeEndArray();
//            jsonGenerator.writeEndObject();
//
//
//            //Spider Man
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("name", "Spider-Man");
//            jsonGenerator.writeStringField("alias", "Peter Parker");
//            jsonGenerator.writeFieldName("powers");
//            jsonGenerator.writeStartArray();
//            jsonGenerator.writeString("Wall-Crawling");
//            jsonGenerator.writeString("Superhuman Strength");
//            jsonGenerator.writeString("Enhanced-Agility");
//            jsonGenerator.writeString("Spider-sense");
//            jsonGenerator.writeString("Web-shooters");
//            jsonGenerator.writeEndArray();
//            jsonGenerator.writeFieldName("affiliations");
//            jsonGenerator.writeStartArray();
//            jsonGenerator.writeString("Avengers");
//            jsonGenerator.writeEndArray();
//            jsonGenerator.writeFieldName("appearance");
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("gender", "Male");
//            jsonGenerator.writeStringField("race", "Human");
//            jsonGenerator.writeStringField("height", "5'10\"");
//            jsonGenerator.writeStringField("weight", "167 lbs");
//            jsonGenerator.writeStringField("eyeColor", "Hazel");
//            jsonGenerator.writeStringField("hairColor", "Brown");
//            jsonGenerator.writeEndObject();
//            jsonGenerator.writeStringField("universe", "Marvel");
//            jsonGenerator.writeFieldName("movies");
//            jsonGenerator.writeStartArray();
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("title", "Spider-Man Homecoming");
//            jsonGenerator.writeNumberField("year", 2017);
//            jsonGenerator.writeEndObject();
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("title", "Spider-Man Far From Home");
//            jsonGenerator.writeNumberField("year", 2019);
//            jsonGenerator.writeEndObject();
//            jsonGenerator.writeEndArray();
//            jsonGenerator.writeEndObject();
//            jsonGenerator.writeEndArray();
//            jsonGenerator.writeEndObject();

        } catch (IOException | RuntimeException e) {
            System.err.println("An error occurred: " + e.getMessage());
            if(jsonGenerator!=null){
                jsonGenerator.flush();
            }
        }
    }
}
