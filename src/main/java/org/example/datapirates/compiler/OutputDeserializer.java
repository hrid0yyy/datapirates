package org.example.datapirates.compiler;

import com.google.gson.*;

import java.lang.reflect.Type;

public class OutputDeserializer implements JsonDeserializer<output> {

    @Override
    public output deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String cpuTime = jsonObject.get("cpuTime").getAsString();
        String memory = jsonObject.get("memory").getAsString();
        String output = jsonObject.get("output").getAsString();

        output outputObj = new output();
        outputObj.setCpuTime(cpuTime);
        outputObj.setMemory(memory);
        outputObj.setOutput(output);

        // Handle deserialization of the 'Language' field if needed

        return outputObj;
    }
}