package org.example.datapirates.compiler;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class CodeTypeAdapter extends TypeAdapter<Code> {

    @Override
    public void write(JsonWriter out, Code code) throws IOException {
        out.beginObject();
        out.name("code").value(code.getCode());
        out.name("language").value(code.getLanguage());
        // Serialize other fields if needed
        out.endObject();
    }

    @Override
    public Code read(JsonReader in) throws IOException {
        // Implement deserialization if needed
        throw new UnsupportedOperationException("Deserialization is not supported.");
    }
}
